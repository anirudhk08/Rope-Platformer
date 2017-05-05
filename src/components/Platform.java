package components;

/**
 * Created by Anirudh on 5/4/17.
 */
public class Platform extends GameComponent {

    private double staticFriction;
    private double kineticFriction;

    public Platform(double x, double y, double s, double k)
    {
        super(x, y);
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

    public void draw()
    {

    }





}
