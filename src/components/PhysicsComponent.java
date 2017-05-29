package components;

import javax.swing.*;
import java.awt.*;

import static menus.PhysicsConstants.G;


/**
 * A PhysicsComponent is a GameComponent that has the ability to
 * simulate simple physics, such as the stick figure. All PhysicsComponents
 * have an x and y velocity. The method update() will update the velocity
 * (thus providing a means of acceleration) and position of the object.
 * PhysicsComponents also have a constant G for the acceleration due to gravity.
 *
 */
public abstract class PhysicsComponent extends GameComponent {

    /**
     * Horizontal and vertical velocities of the Physics component
     *
     */
    protected double xVel, yVel = G;

    /**
     * Constructor to initialize the Physics component with its
     * center coordinates.
     *
     * @param x - x coordinate
     * @param y - y coordinate
     */
    public PhysicsComponent(int x, int y)
    {
        super(x, y);
    }

    /**
     * Constructor to initialize the Physics component with its
     * center coordinates, GUI panel and image.
     *
     * @param x - x coordinate
     * @param y - y coordinate
     * @param parent - GUI panel
     * @param img - image of Physics component
     */
    public PhysicsComponent(int x, int y, JPanel parent, Image img)
    {
        super(x, y, parent, img);
    }

    /**
     * Abstract method to update the Physics component.
     *
     */
    public abstract void update();


    /**
     * Method to update the position of Physics component.
     *
     */
    public final void updatePos()
    {
        update();
        xPos += xVel;
        yPos += yVel;
    }

    /**
     * Method to get the absolute velocity of the Physics component.
     *
     * @return - absolute of Physics component.
     *
     */
    public double getAbsoluteVel()
    {
        return Math.sqrt(xVel * xVel + yVel * yVel);
    }
}
