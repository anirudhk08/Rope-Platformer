
package components;

import java.awt.*;
import java.awt.geom.Line2D;
import java.text.DecimalFormat;

/**
 * Created by axu047 on 5/4/2017.
 */
public class Rope extends GameComponent {

    private StickFigure owner;
    private boolean swing;
    private double length;

    public Rope(double x, double y, boolean isSwingingRope, StickFigure person) {
        super(x, y);
        swing = isSwingingRope;
        owner = person;
        length = distance();
    }

    public boolean isSwingingRope() { return swing; }
    public boolean isGrapplingRope() { return !swing; }

    @Override
    public void draw(Graphics2D g, double fps) {
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
        DecimalFormat d = new DecimalFormat("0.###############");
        double angle;
        if (owner.yPos - yPos == 0.0) {
            if (owner.xPos > xPos) angle = -Math.PI / 2;
            else angle = Math.PI / 2;
        } else angle = Math.atan(Math.abs(owner.xPos - xPos)/Math.abs(owner.yPos - yPos));
        if (owner.xPos < xPos && owner.yPos > yPos) { // down left
            return Double.parseDouble(d.format(angle));
        }
        else if (owner.xPos > xPos && owner.yPos > yPos) {
            return -Double.parseDouble(d.format(angle));
        } else if (owner.xPos < xPos && owner.yPos < yPos) {
            return Double.parseDouble(d.format(Math.PI - angle));
        } else if (owner.xPos > xPos && owner.yPos < yPos) {
            return -Double.parseDouble(d.format(Math.PI - angle));
        } else throw new IllegalStateException("Shouldn't be here");
    }

    public double angleFromOwner() {
        double yDelta = owner.yPos - yPos;
        double xDelta = owner.xPos - xPos;
        return Math.atan(yDelta / xDelta);
    }
}
