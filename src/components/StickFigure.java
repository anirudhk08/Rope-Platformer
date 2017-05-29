
package components;

import data.Level;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static menus.GameWindowConstants.WINDOW_HEIGHT;
import static menus.GameWindowConstants.WINDOW_WIDTH;
import static menus.PhysicsConstants.G;
import static menus.PhysicsConstants.GRAPPLE_VELOCITY;

/**
 * Created by axu047 on 5/4/2017.
 */
public class StickFigure extends PhysicsComponent {

    private BufferedImage stickImage;
    private Rope rope;
    private Level map;
    private boolean leftToRight, moving, jumping;
    private double kinetic, potential;


    public StickFigure(JPanel panel, Image i, Level m) {
        super(m.getStartX(), m.getStartY(), panel, i);

        map = m;

    }

    public int platformTopPos() {
        for (GameComponent g : map) {
            if (isTouching(g)) {
                return g.getTopEdge();
            }
        }
        return Integer.MAX_VALUE;
    }

    public boolean isStandingOnPlatform() {
        for (GameComponent g : map)
            if (isTouching(g) && getBottomEdge() < g.getBottomEdge()) return true;
        return false;
    }

    public boolean isTouchingObstacle() {
        for (GameComponent g : map)
            if (isTouching(g) && g instanceof Obstacle) return true;
        return false;
    }

    public void jump() {
        if (isStandingOnPlatform()) {
            yVel = -4.5;
            jumping = true;
        } else rope = null;
    }

    public void moveRight() {
        if (isStandingOnPlatform()) {
            xVel = 1;
            moving = true;
        }
    }

    public void moveLeft() {
        if (isStandingOnPlatform()) {
            xVel = -1;
            moving = true;
        }
    }

    public double getKinetic() { return kinetic; }

    public void swing(int x, int y) {
        rope = new Rope(x, y, true, this);
        leftToRight = rope.angleToVertical() > 0;
        double vel = getAbsoluteVel();
        kinetic = 0.5 * vel * vel;

        double height = Math.abs(rope.yPos + rope.length() - yPos);
        potential = height * G;
        moving = false;
    }

    public void grapple(int x, int y) {
        rope = new Rope(x, y, false, this);
        moving = false;
    }

    public void stopMoving() {
        if (isStandingOnPlatform()) {
            xVel = 0;
            moving = false;
        }
    }

    @Override
    public void draw(Graphics2D g) {
        updatePos();
        if (rope != null)
            rope.draw(g);
        super.draw(g);
    }

    @Override
    public void update() {
        if (isTouchingObstacle()) {
            restart();
            return;
        }
        boolean standing = isStandingOnPlatform();

        //TODO if fall out of map or dead -> restart
        if (getLeftEdge() > WINDOW_WIDTH || getRightEdge() < 0 || getTopEdge() > WINDOW_HEIGHT) {
            restart();
        }
        //TODO is standing
        if (standing) {
            if (jumping) jumping = false;
            else yVel = 0;
            if (!moving) xVel = 0;
            yPos = platformTopPos() - height / 2;
        }
        //TODO if rope
        if (rope != null) {
            for (GameComponent g : map)
                if (rope.isTouching(g)) {
                rope = null;
                return;
                }
            if (rope.isSwingingRope()) {
                if (standing) {
                    rope = null;
                    return;
                }
                double angle = rope.angleToVertical();
                if (rope.distance() < rope.length()) yVel += G;
                else {
                    double newVel = updateEnergy();
                    if (newVel <= 0) {
                        rope = null;
                    }
                    else {
                        if (!leftToRight)
                            newVel = -newVel;
                        xVel = newVel * Math.cos(angle);
                        yVel = newVel * Math.sin(angle);
                    }
                }
            } else if (rope.isGrapplingRope()) {
                if (rope.distance() < 5.0) rope = null;
                else {
                    double angle = rope.angleFromOwner();

                    xVel = GRAPPLE_VELOCITY * Math.cos(angle);
                    yVel = GRAPPLE_VELOCITY * Math.sin(angle);
                }
            }
        }
        else if (!standing) yVel += G;
    }

    private double updateEnergy() { // return vel
        double height = Math.abs(rope.yPos + rope.length() - yPos);
        double newPotential = height * G;
        double newKinetic = potential + kinetic - newPotential;
        newKinetic *= 0.999;
        if (newKinetic < 0) newKinetic = 0;
        double newVel = Math.sqrt(newKinetic * 2);
        potential = newPotential;
        kinetic = newKinetic;
        return newVel;
    }

    private void restart() {
        xPos = map.getStartX();
        yPos = map.getStartY();
        yVel = G;
        xVel = 0;
        rope = null;
    }
}

