package components;

import java.awt.*;

/**
 * Created by axu047 on 5/4/2017.
 */
public abstract class GameComponent {
    private double xPos, yPos;

    public abstract void draw(Graphics2D g, double updateTimeMillis);

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
        double a = Math.atan(Math.abs(yDelta / xDelta));
        if (yDelta > 0 && xDelta > 0) { // quadrant IV
            return 2 * Math.PI - a;
        } else if (yDelta < 0 && xDelta < 0) { // quadrant II
            return Math.PI - a;
        } else if (yDelta > 0 && xDelta < 0) { // quadrant III
            return Math.PI + a;
        } else {
            return a;
        }
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
