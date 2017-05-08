package components;

import java.awt.*;

/**
 * Created by axu047 on 5/4/2017.
 */
public class StickFigure extends PhysicsComponent {

    private double health;
    private Rope rope;
    private int direction;

    public StickFigure(double x, double y) {
        super(x, y);
    }

    public void jump() {
        accelerate(3, 90);
        rope = null;
    }

    public void move() {

    }

    public void swing(double x, double y) {
        rope = new Rope(x, y, true, this);
    }

    public void grapple(double x, double y) {
        rope = new Rope(x, y, false, this);
    }


    @Override
    public void draw(Graphics g) {
        updatePos();
        rope.draw(g);
    }

    @Override
    public void updateForces() {
        accelerate(getGravityAccel(), -90);
        if (isTouching(rope)) {
            if (rope.isSwingingRope()) {
                double a = angle(rope);
                accelerate(getGravityAccel() / Math.sin(a), a);
            }
        }
        if (true) { //TODO is standing
            setYVel(0);
            accelerate(getGravityAccel(), 90);
        }
        else if (true) { //TODO is sliding but not standing

        }
    }
}
