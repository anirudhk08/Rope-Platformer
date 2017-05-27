package components;

import javax.swing.*;
import java.awt.*;

/**
 * Created by axu047 on 5/4/2017.
 */
public abstract class GameComponent {
    protected double xPos, yPos; // center
    protected int height, width;
    private JPanel parent;
    private Image image;
    private boolean useImage = false;

    public void draw(Graphics2D g, double fps) {
        if (useImage) {
            g.drawImage(image, (int) (xPos - width / 2), (int) (yPos - height / 2), parent);
        }
    }

    public GameComponent(double x, double y) {
        xPos = x;
        yPos = y;
        useImage = false;
    }

    public GameComponent(double x, double y, JPanel p, Image i) {
        this(x, y);
        height = i.getHeight(p);
        width = i.getWidth(p);
        parent = p;
        image = i;
        useImage = true;
    }

    public GameComponent(double x, double y, JPanel p, Image i, int h, int w) {
        this(x, y, p, i);
        height = h;
        width = w;
    }

    public int getTopEdge() {
        return (int)yPos - height/2;
    }

    public int getBottomEdge() {
        return getTopEdge() + height;
    }

    public int getRightEdge() {
        return (int)xPos + width / 2;
    }

    public int getLeftEdge() {
        return getRightEdge() - width;
    }

    public boolean isTouching(GameComponent other) {
        if (other == null) {
            return false;
        }

        return Math.abs(this.xPos - other.xPos) <= (this.width / 2 + other.width / 2) &&
                Math.abs(this.yPos - other.yPos) <= (this.height / 2 + other.height / 2);
    }

    public boolean hasImage() { return useImage; }

    public GameComponent[] getTouching() {
        return null; // TODO fix
    }
}
