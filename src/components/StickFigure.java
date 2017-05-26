
package components;

import data.Map;

import javax.imageio.ImageIO;
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
    private Map map;
    private boolean leftToRight;

    public StickFigure(double x, double y, Map m) {
        super(x, y);
        map = m;

        File file = new File("/resources/guyWalking1.png");
        String absolutePath = file.getAbsolutePath();
        //System.out.println(absolutePath);
        try {
            stickImage = ImageIO.read(new File(absolutePath));
        } catch (IOException e) {
            System.out.println(e);
            stickImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        }
    }

    public void jump() {
        //TODO only when on platform or rope
        System.out.println("werwerw");
        if (false) {
            yVel = -10;
            rope = null;
        }
    }

    public void moveRight() {
        // TODO only when on platform
        if (false) {

        }
    }

    public void moveLeft() {
        // TODO only when on platform
        if (false) {

        }
    }

    public void swing(double x, double y) {
        rope = new Rope(x, y, true, this);
    }

    public void grapple(double x, double y) {
        rope = new Rope(x, y, false, this);
    }

    public void stopMoving() {
        // TODO only when on platform
        if (false) {

        }
    }


    @Override
    public void draw(Graphics2D g, double fps) {
        updatePos(fps);
        if (rope != null)
            rope.draw(g, fps);


        //g.drawImage(stickImage, (int)xPos, (int)yPos, width, height, null);
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
                    if (Math.abs(angle) < 0.05) System.out.println(yVel);
                }
            } else if (rope.isGrapplingRope()) {

            }
        }
        else yVel += G;
    }
}

