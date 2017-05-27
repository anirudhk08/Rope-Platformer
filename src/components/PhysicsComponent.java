package components;

import javax.swing.*;
import java.awt.*;

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

    public final void updatePos(double fps) {
        update();
        xPos += xVel / fps;
        yPos += yVel / fps;
    }

    public double getTotalVel() {
        return Math.sqrt(xVel * xVel + yVel * yVel);
    }
}
