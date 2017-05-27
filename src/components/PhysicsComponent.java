package components;

import javax.swing.*;
import java.awt.*;

import static menus.GameWindowConstants.FRAMES_PER_SECOND;

/**
 * Created by axu047 on 5/4/2017.
 */
public abstract class PhysicsComponent extends GameComponent {
    final double G = 50;
    protected double xVel, yVel = G;

    public PhysicsComponent(int x, int y) {
        super(x, y);
    }
    public PhysicsComponent(int x, int y, JPanel parent, Image img) {
        super(x, y, parent, img);
    }

    public abstract void update();

    public final void updatePos() {
        update();
        xPos += xVel / FRAMES_PER_SECOND;
        yPos += yVel / FRAMES_PER_SECOND;
    }

    public double getAbsoluteVel() {
        return Math.sqrt(xVel * xVel + yVel * yVel);
    }
}
