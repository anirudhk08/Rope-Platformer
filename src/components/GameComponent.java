package components;

import javax.swing.*;
import java.awt.*;


/**
 * Class to define and manage the GUI of a game component.
 *
 * This base class is extended by other game components such as
 * Platform, Obstacle, Physics Component, Player and Stick Figure
 */
public abstract class GameComponent
{
    protected double xPos, yPos; // center
    protected int height, width;
    protected JPanel parent;
    protected Image image;
    protected boolean harmful = false;

    /**
     * Draw the game component
     * @param g - graphics object
     */
    public void draw(Graphics2D g)
    {
        if (image != null) {
            g.drawImage(image, getLeftEdge(), getTopEdge(), parent);
        }
    }

    /**
     * Constructor to initialize the center coordinate of the
     * game component
     *
     * @param x - center x coordinate of the game component
     * @param y - center y coordinate of the game component
     */
    public GameComponent(int x, int y)
    {
        xPos = x;
        yPos = y;
    }

    /**
     * Constructor to initialize the center coordinates, JPanel
     * and image of the game component
     *
     * @param x - center x coordinate of the game component
     * @param y - center y coordinate of the game component
     * @param p - JPanel of the game component
     * @param i - Image of the game component
     */
    public GameComponent(int x, int y, JPanel p, Image i)
    {
        this(x, y);
        height = i.getHeight(p);
        width = i.getWidth(p);
        parent = p;
        image = i;
    }

    /**
     * Constructor to initialize the center coordinates, JPanel,
     * image, height and width of the game component
     * @param x - center x coordinate of the game component
     * @param y - center y coordinate of the game component
     * @param p - panel of the game component
     * @param i - image of the game component
     * @param h - height of the game component
     * @param w - width of the game component
     */
    public GameComponent(int x, int y, JPanel p, Image i, int h, int w)
    {
        this(x, y, p, i);
        height = h;
        width = w;
    }


    /**
     * Constructor to initialize the center coordinates,
     * height and width of the game component
     *
     * @param x - center x coordinate of the game component
     * @param y - center y coordinate of the game component
     * @param w - width of the game component
     * @param h - height of the game component
     */
    public GameComponent(int x, int y, int w, int h)
    {
        xPos = x;
        yPos = y;
        width = w;
        height = h;

    }

    /**
     * Method to determine if this game component is
     * harmful to Stick figure.
     *
     * @return - true if game component is harmful;
     *   false if game component is not harmful
     */
    public boolean isHarmful()
    {
        return harmful;
    }

    /**
     * Method to get the top edge of the game component.
     *
     * @return - top edge of game component
     */
    public int getTopEdge()
    {
        return (int) (yPos - height/2);
    }

    /**
     * Method to get bottom edge of the game component.
     *
     * @return - bottom edge of the game component
     */
    public int getBottomEdge()
    {
        return getTopEdge() + height;
    }

    /**
     * Method to get the right edge of the game component
     *
     * @return - right edge of the game component
     */
    public int getRightEdge()
    {
        return (int) (xPos + width / 2);
    }

    /**
     * Method to get left edge of the game component
     *
     * @return - left edge of the game component
     */
    public int getLeftEdge()
    {
        return getRightEdge() - width;
    }

    /**
     * Method to get center x-coordinate of game component
     *
     * @return - center x-coordinate of game component
     */
    public int getxPos() {
        return (int) xPos;
    }

    /**
     * Method to get center y-coordinate of game component
     *
     * @return - center y-coordinate of game component
     */
    public int getyPos()
    {
        return (int) xPos;
    }

    /**
     * Method to check if this game component is touching the
     * specified game component.
     *
     * @param other - other game component
     * @return - true if this component is touching other game component
     *    false if this component is not touching other game component
     */
    public boolean isTouching(GameComponent other)
    {
        if (other == null || this.equals(other)) {
            return false;
        }

        return Math.abs(this.xPos - other.xPos) <= (this.width / 2 + other.width / 2) &&
                Math.abs(this.yPos - other.yPos) <= (this.height / 2 + other.height / 2);
    }

    /**
     * Method to check if the game component has an image or not.
     *
     * @return - true if game component has image
     *   false if game component doesn't have an image
     */
    public boolean hasImage() {
        return image != null;
    }
}
