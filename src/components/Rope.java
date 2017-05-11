package components;

import java.awt.*;

/**
 * Created by axu047 on 5/4/2017.
 */
public class Rope extends GameComponent {

    private StickFigure owner;
    private boolean swing;

    public Rope(double x, double y, boolean isSwingingRope, StickFigure person) {
        super(x, y);
        swing = isSwingingRope;
        owner = person;
    }

    public boolean isSwingingRope() { return swing; }
    public boolean isGrapplingRope() { return !swing; }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawLine((int) xPos(), (int) yPos(), (int) owner.xPos(), (int) owner.yPos());
    }
}
