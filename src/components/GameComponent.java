package components;

import javax.swing.*;
import java.awt.*;


public abstract class GameComponent {
    protected double xPos, yPos; // center
    protected int height, width;
    protected JPanel parent;
    protected Image image;
    protected boolean harmful = false;

    public void draw(Graphics2D g) {
        if (image != null) {
            g.drawImage(image, getLeftEdge(), getTopEdge(), parent);
        }
    }

    public GameComponent(int x, int y) {
        xPos = x;
        yPos = y;
    }

    public GameComponent(int x, int y, JPanel p, Image i) {
        this(x, y);
        height = i.getHeight(p);
        width = i.getWidth(p);
        parent = p;
        image = i;
    }

    public GameComponent(int x, int y, JPanel p, Image i, int h, int w) {
        this(x, y, p, i);
        height = h;
        width = w;
    }

    public GameComponent(double x, double y, int w, int h)
    {
        xPos = x;
        yPos = y;
        width = w;
        height = h;

    }

    public boolean isHarmful()
    {
        return harmful;
    }

    public void setHarmful(boolean harmful)
    {
        this.harmful = harmful;
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

    public double getxPos() {
        return xPos;
    }

    public double getyPos() {
        return yPos;
    }

    public boolean isTouching(GameComponent other) {
        if (other == null || this.equals(other)) {
            return false;
        }

        return Math.abs(this.xPos - other.xPos) <= (this.width / 2 + other.width / 2) &&
                Math.abs(this.yPos - other.yPos) <= (this.height / 2 + other.height / 2);
    }

    public boolean hasImage() {
        return image == null;
    }
}
