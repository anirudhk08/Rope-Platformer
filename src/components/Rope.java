
package components;

import java.awt.*;
import java.awt.geom.Line2D;
import java.text.DecimalFormat;

/**
 * A Rope is a GameComponent. The Rope is what the stick figure uses
 * to swing or to grapple; each Rope can be one type or the other. A
 * Rope has a reference to the stick figure and contains special methods
 * for calculating its angle to the vertical and distance to the stick
 * figure: these methods are used for implementing swinging physics.
 *
 * A rope is drawn with a straight black line.
 *
 */
public class Rope extends GameComponent
{

    /**
     * Stick figure object
     */
    private StickFigure owner;

    /**
     * Flag to indicate if rope is swing mode
     */
    private boolean swing;

    /**
     * Rope length
     */
    private double length;

    /**
     * Constructor to initialize Rope instance with coordinates,
     * swing mode and the Stick Figure
     *
     * @param x - x coordinate
     * @param y - y coordinate
     * @param isSwingingRope - flag to indicate swing mode
     * @param person - Stick figure object
     */
    public Rope(int x, int y, boolean isSwingingRope, StickFigure person)
    {
        super(x, y);
        swing = isSwingingRope;
        owner = person;
        length = distance();
    }

    /**
     * Method to know if rope is in swing mode.
     *
     * @return - true if rope is in swing mode
     *    - false if rope is not in swing mode
     */
    public boolean isSwingingRope()
    {
        return swing;
    }

    /**
     * Method to indicate if rope in grapple mode.
     *
     * @return - true if rope is in grapple mode
     *      - false if rope is not in grapple mode
     */
    public boolean isGrapplingRope()
    {
        return !swing;
    }

    /**
     * Method to draw the Rope component
     *
     * @param g - graphics object
     */
    @Override
    public void draw(Graphics2D g)
    {
        if (owner.getKinetic() < 1.5 && isSwingingRope()) g.setColor(Color.RED);
        else g.setColor(Color.BLACK);
        g.draw(new Line2D.Double(xPos, yPos, owner.xPos, owner.yPos));
    }

    /**
     * Method to get the rope length.
     *
     * @return - rope length
     */
    public double length()
    {
        return length;
    }

    /**
     * Method to get the distance.
     *
     * @return - distance
     */
    public double distance()
    {
        if (owner == null) {
            return 0D;
        }
        double yDelta = owner.yPos - yPos;
        double xDelta = owner.xPos - xPos;
        return Math.sqrt(xDelta * xDelta + yDelta * yDelta);
    }

    /**
     * Method to compute angle to Vertical
     *
     * @return - angle to vertical
     */
    public double angleToVertical()
    {
        DecimalFormat d = new DecimalFormat("0.##############");
        double angle;

        if (owner.yPos == this.yPos) {
            if (owner.xPos > this.xPos) {
                return -Math.PI / 2;
            }
            else {
                return Math.PI / 2;
            }
        } else if (owner.xPos == this.xPos) {
            if (owner.yPos > this.yPos) {
                return Math.PI;
            }
            else {
                return 0;
            }
        }
        else {
            angle = Math.atan(Math.abs(owner.xPos - this.xPos)/Math.abs(owner.yPos - this.yPos));
        }

        if (owner.xPos < this.xPos) {
            if (owner.yPos > this.yPos) {
                return Double.parseDouble(d.format(angle));
            } else {
                return Double.parseDouble(d.format(Math.PI - angle));
            }
        } else {
            if (owner.yPos > this.yPos) {
                return -Double.parseDouble(d.format(angle));
            } else {
                return -Double.parseDouble(d.format(Math.PI - angle));
            }
        }
    }

    /**
     * Method to compute angle from owner
     *
     * @return angle from owner
     */
    public double angleFromOwner()
    {
        double yDelta = this.yPos - owner.yPos;
        double xDelta = this.xPos - owner.xPos;

        if (yDelta == 0 && xDelta == 0) {
            return 0;
        }

        if (yDelta == 0) {
            if (xDelta > 0) {
                return 0;
            } else {
                return Math.PI;
            }
        }

        if (xDelta == 0) {
            if (yDelta > 0) {
                return Math.PI;
            } else {
                return -Math.PI;
            }
        }

        double angle = Math.atan(yDelta / xDelta);

        if (xDelta < 0) {
            return Math.PI + angle;
        }
        else {
            return angle;
        }
    }
}
