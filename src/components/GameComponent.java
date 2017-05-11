package components;

import java.awt.*;

/**
 * Created by axu047 on 5/4/2017.
 */
public abstract class GameComponent {
    private double xPos, yPos;

    public abstract void draw(Graphics g);

    public GameComponent(double x, double y) {
        xPos = x;
        yPos = y;
    }

    public final double xPos() {
        return xPos;
    }

    public final double yPos() {
        return yPos;
    }

    public void setX(double newX) {
        xPos = newX;
    }

    public void setY(double newY) {
        yPos = newY;
    }

    public boolean isTouching(GameComponent other) {
        if (other == null) return false;
        return false; //TODO
    }

    public double angle(GameComponent other) {
        double yDelta = other.yPos - yPos;
        double xDelta = other.xPos - xPos;
        return Math.atan(yDelta / xDelta);
    }

    public double distance(GameComponent other) {
        double yDelta = other.yPos - yPos;
        double xDelta = other.xPos - xPos;
        return Math.sqrt(xDelta * xDelta + yDelta * yDelta);
    }

    public GameComponent[] getTouching() {
        return null;
    }
}
