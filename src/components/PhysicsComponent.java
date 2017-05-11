package components;

import java.text.DecimalFormat;

/**
 * Created by axu047 on 5/4/2017.
 */
public abstract class PhysicsComponent extends GameComponent {
    private int xVel, yVel;
    public final double G = 9.807;

    public PhysicsComponent(double x, double y) {
        super(x, y);
    }


    public abstract void updateForces();

    public void updatePos(double updateTimeMillis) {
        updateForces();
        setX(xPos() + xVel * updateTimeMillis / 1000.0);
        setY(yPos() + yVel * updateTimeMillis / 1000.0);
    }

    public void accelerate(double a, double angle) {
        DecimalFormat df = new DecimalFormat("#.000000000000000");
        double cos = Double.parseDouble(df.format(Math.cos(angle)));
        double sin = Double.parseDouble(df.format(Math.sin(angle)));
        xVel += a * cos;
        yVel += a * sin;
    }

    public void setYVel(int newYVel) { yVel = newYVel; }
    public void setXVel(int newXVel)  {xVel = newXVel; }
}
