package data;

import components.GameComponent;

import java.awt.*;
import java.util.ArrayList;

/**
 * This class holds all the game components
 * and provides functions to check if they collide
 * with each other.
 *
 * @author - Aubhro Sengupta
 */
public class Level extends ArrayList<GameComponent> {

    /**
     * These are the upper left and lower right
     * components of all the game components
     */
    private int startX, startY, endX, endY;

    /**
     * Represents the graphical image of the
     * game background.
     */
    private Image preview;

    /**
     * This constuctor initializes the instance
     * with the coordinates.
     * @param startX - top edge
     * @param startY - left edge
     * @param endX - right edge
     * @param endY - bottom edge
     */
    public Level(int startX, int startY, int endX, int endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    /**
     * This method draws the GUI components
     * @param g - graphics 2D component
     */
    public void draw(Graphics2D g) {
        for (GameComponent p : this) {
            p.draw(g);
        }
    }

    /**
     * This method returns the left edge of the
     * GUI component.
     * @return - left edge
     */
    public int getStartX()
    {
        return startX;
    }

    /**
     * This method returns the top edge of the GUI
     * component.
     * @return - top edge
     */
    public int getStartY()
    {
        return startY;
    }

    /**
     * This method determines if the given component
     * collides or touches with any other game component
     * in the system.
     * @param other - other game component
     * @return - returns true if the other game component touches any other component
     * otherwise returns false
     */
    public boolean isCollision(GameComponent other)
    {
        boolean collision = false;

        for (GameComponent gc: this)
        {
            if ( gc.isTouching(other) )
            {
                collision = true;
                break;
            }
        }

        return collision;
    }

}
