
package components;

import data.Level;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by axu047 on 5/4/2017.
 */
public class StickFigure extends PhysicsComponent {

    private BufferedImage stickImage;
    private final int width = 250;
    private final int height = 500;
    private double health;
    private Rope rope;
    private Level map;
    private boolean leftToRight;


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
    public void draw(Graphics2D g, double fps) {
        updatePos(fps);
        if (rope != null)
            rope.draw(g, fps);
        super.draw(g, fps);
    }

    @Override
    public void update() {
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
                double vel = getTotalVel() - 2;


                if (angle > Math.PI / 2 && yVel > 0) leftToRight = true;
                else if (angle < -Math.PI / 2 && yVel > 0) leftToRight = false;
                else if (vel < G) leftToRight = !leftToRight;

                if (rope.distance() < rope.length()) yVel += G;
                else {
                    if (!leftToRight)
                        vel = -vel;
                    xVel = vel * Math.cos(angle);
                    yVel = vel * Math.sin(angle) + G;
                }
            } else if (rope.isGrapplingRope()) {
                if (rope.distance() < 5.0) rope = null;
                else {
                    double angle = rope.angleFromOwner();
                    double vel = 5000;

                    xVel = vel * Math.cos(angle);
                    yVel = vel * Math.sin(angle);
                }
            }
        }
        else yVel += G;
    }
}

