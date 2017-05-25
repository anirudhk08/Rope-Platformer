package components;

import java.awt.*;

/**
 * Created by Anirudh on 5/4/17.
 */
public abstract class Platform extends GameComponent {

    private double width, height;
    private boolean harmful;

    public Platform(int x, int y, double w, double h)
    {
        super(x, y);
        width = w;
        height = h;
    }

    public boolean isHarmful() { return harmful; }

    public abstract void move();

    @Override
    public void draw(Graphics2D g, double updateTimeMillis) {
        g.setColor(Color.BLACK);
        g.fillRect((int) xPos, (int) yPos, (int) width, (int) height);
    }
}
