
package components;

import java.awt.*;
import java.awt.geom.Line2D;

/**
 * Created by axu047 on 5/4/2017.
 */
public class Rope extends GameComponent {

    private StickFigure owner;
    private boolean swing;
    private double length;

    public Rope(int x, int y, boolean isSwingingRope, StickFigure person) {
        super(x, y);
        swing = isSwingingRope;
        owner = person;
        length = distance();
    }

    public boolean isSwingingRope() { return swing; }
    public boolean isGrapplingRope() { return !swing; }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.draw(new Line2D.Double(xPos, yPos, owner.xPos, owner.yPos));
    }

    public double length() { return length; }

    public double distance() {
        double yDelta = owner.yPos - yPos;
        double xDelta = owner.xPos - xPos;
        return Math.sqrt(xDelta * xDelta + yDelta * yDelta);
    }

    public double angleToVertical() {
        double angle;
        if (owner.yPos == yPos) {
            if (owner.xPos > xPos) {
                return  -Math.PI / 2;
            } else {
                return Math.PI / 2;
            }
        } else {
            angle = Math.atan(Math.abs(owner.xPos - xPos) / Math.abs(owner.yPos - yPos));
        }

        if (owner.xPos < xPos && owner.yPos > yPos) { // down left
            return angle;
        } else if (owner.xPos > xPos && owner.yPos > yPos) {
            return -angle;
        } else if (owner.xPos < xPos && owner.yPos < yPos) {
            return Math.PI - angle;
        } else if (owner.xPos > xPos && owner.yPos < yPos) {
            return -(Math.PI - angle);
        } else return Math.PI;
    }

    public double angleFromOwner() {
        double yDelta = owner.yPos - yPos;
        double xDelta = xPos - owner.xPos;

        if (xDelta == 0 && yDelta == 0) {
            return 0D;
        }

        if (xDelta == 0) {
            if (yDelta < 0) {
                return Math.PI / 2;
            } else if(yDelta > 0) {
                return -Math.PI / 2;
            }
        }

        if (yDelta == 0) {
            if (xDelta < 0) {
                return Math.PI;
            } else if(xDelta > 0) {
                return 0D;
            }
        }
        double angle = Math.atan(yDelta / xDelta);
        if (xDelta < 0 && yDelta < 0) {
            return angle - Math.PI;
        } else if(xDelta < 0 && yDelta > 0) {
            return angle + Math.PI;
        }
        return angle;
    }
}
