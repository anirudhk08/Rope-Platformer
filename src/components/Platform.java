package components;

import java.awt.*;

/**
 * Created by Anirudh on 5/4/17.
 */
public abstract class Platform extends GameComponent {

    private double width, height;
    private boolean harmful;

    public Platform(int x, int y, double w, double h, boolean obstacle)
    {
        super(x, y);
        width = w;
        height = h;
        harmful = obstacle;
    }

    public boolean isHarmful() { return harmful; }

    public abstract void move();

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.fillRect(getLeftEdge(), getTopEdge(), (int) width, (int) height);
    }
}
