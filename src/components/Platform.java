package components;

import java.awt.*;

/**
 * Created by Anirudh on 5/4/17.
 */
public class Platform extends GameComponent {

    private double staticFriction, kineticFriction;
    private double width, height;

    public Platform(int x, int y, double w, double h, double s, double k )
    {
        super(x, y);
        width = w;
        height = h;
        staticFriction = s;
        kineticFriction = k;
    }

    public double getStaticFriction()
    {
        return staticFriction;
    }

    public double getKineticFriction()
    {
        return kineticFriction;
    }


    @Override
    public void draw(Graphics2D g, double updateTimeMillis) {
        g.setColor(Color.BLACK);
        g.fillRect((int) xPos(), (int) yPos(), (int) width, (int) height);
    }
}
