package components;

/**
 * Created by axu047 on 5/4/2017.
 */
public abstract class PhysicsComponent extends GameComponent {
    private double xVel, yVel;

    private static final double G = 6.67408 * 1e-11;
    private static final double MASS_EARTH = 5.972 * 1e24;

    public PhysicsComponent(double x, double y) {
        super(x, y);
    }

    public double getGravityAccel() {
        return (G * MASS_EARTH) / (yPos() * yPos());
    }

    public abstract void updateForces();

    public void updatePos() {
        setX(xPos() + xVel);
        setY(yPos() + yVel);
    }

    public void accelerate(double a, double angle) {
        xVel += a * Math.cos(angle);
        yVel += a * Math.sin(angle);
    }

    public void setYVel(int newYVel) { yVel = newYVel; }
    public void setXVel(int newXVel)  {xVel = newXVel; }
}
