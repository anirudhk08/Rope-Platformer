package components;

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
    public void draw() {

    }
}
