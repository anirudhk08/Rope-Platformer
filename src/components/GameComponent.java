package components;

/**
 * Created by axu047 on 5/4/2017.
 */
public abstract class GameComponent {
    private double xPos, yPos;

    public abstract void draw();

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
}
