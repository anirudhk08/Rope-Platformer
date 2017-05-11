package components;

import map.Map;

import java.awt.*;

/**
 * Created by axu047 on 5/4/2017.
 */
public class StickFigure extends PhysicsComponent {

    private double health;
    private Rope rope;
    private int direction;
    private Map map;

    public StickFigure(double x, double y, Map m) {
        super(x, y);
        map = m;
    }

    public void jump() {
        //TODO only when on platform or rope
        accelerate(3, -90);
        rope = null;
    }

    public void move() {

    }

    public void swing(int x, int y) {
        rope = new Rope(x, y, true, this);
    }

    public void grapple(int x, int y) {
        rope = new Rope(x, y, false, this);
    }


    @Override
    public void draw(Graphics2D g, double updateTimeMillis) {
        updatePos(updateTimeMillis);
        if (rope != null)
            rope.draw(g, updateTimeMillis);
        g.fillRect((int) xPos(), (int) yPos(), 100, 100);
    }

    @Override
    public void updateForces() {
        accelerate(G, Math.PI/2);
        if (rope != null) {
            if (rope.isSwingingRope()) {
                double a = angle(rope);
                if (a > 0 && a < Math.PI)
                    accelerate(G / Math.sin(a), -a);
            }
        }
        //TODO is standing
        //TODO is sliding but not standing
    }
}
