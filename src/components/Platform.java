package components;

/**
 * Created by Anirudh on 5/4/17.
 */
public class Platform extends GameComponent {

    private double staticFriction = 0;
    private double kineticFriction = 0;

    public Platform(double s, double k)
    {
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
