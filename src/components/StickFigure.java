
package components;

import data.Level;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static menus.PhysicsConstants.G;
import static menus.PhysicsConstants.GRAPPLE_VELOCITY;

/**
 * Created by axu047 on 5/4/2017.
 */
public class StickFigure extends PhysicsComponent {

    private BufferedImage stickImage;
    private Rope rope;
    private Level map;
    private boolean leftToRight;
    private double kinetic, potential;


    public StickFigure(int x, int y, JPanel panel, Level m) {
        super(x, y);
        try {
            super.image = ImageIO.read(new File("resources/guyWalking1.png"));
            super.parent = panel;
        } catch (IOException e) {
            e.printStackTrace();
        }
        map = m;

    }

    public boolean isTouchingPlatform() {
        for (GameComponent component:
             map) {
            if (component instanceof Platform && component.isTouching(this)) {
                return true;
            }
        }
        return false;
    }

    public void jump() {
        if (isTouchingPlatform()) {
            yVel = -10;
            rope = null;
        }
    }

    public void moveRight() {
        if (isTouchingPlatform()) {
            xVel = 10;
        }
    }

    public void moveLeft() {
        if (isTouchingPlatform()) {
            xVel = -10;
        }
    }

    public void swing(int x, int y) {
        rope = new Rope(x, y, true, this);
        leftToRight = rope.angleToVertical() > 0;
        double vel = getAbsoluteVel();
        kinetic = 0.5 * vel * vel;

        double height = Math.abs(rope.yPos + rope.length() - yPos);
        potential = height * G;
    }

    public void grapple(int x, int y) {
        rope = new Rope(x, y, false, this);
    }

    public void stopMoving() {
        if (isTouchingPlatform()) {
            xVel = 0;
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
        //TODO if fall out of map or dead -> restart

        //TODO is standing
        if (false) {
            yVel = 0;
        }
        //TODO is sliding but not standing
        else if (false) {

        } //TODO if rope
        else if (rope != null) {
            if (rope.isSwingingRope()) {
                double angle = rope.angleToVertical();
                if (rope.distance() < rope.length()) yVel += G;
                else {
                    double newVel = updateEnergy();
                    if (newVel <= 0) {
//                        if (Math.abs(angle) < 0.1 || stop) {
//                            xPos = rope.xPos;
//                            yPos = rope.yPos + rope.length();
//                            xVel = 0;
//                            yVel = 0;
//                            kinetic = 0;
//                            potential = 0;
//                        } else {
//                            xVel = 0;
//                            yVel = G;
//                            leftToRight = !leftToRight;
//                            stop = true;
//                        }
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
        else yVel += G;
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
}

