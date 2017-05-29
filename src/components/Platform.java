package components;

import java.awt.*;
import java.util.ArrayList;

import static menus.GameLevelConstants.*;
import static menus.GameLevelConstants.LEVEL_FINAL;
import static menus.GameLevelConstants.LEVEL_UNBEARABLE;

/**
 * Created by Anirudh on 5/4/17.
 */
public class Platform extends GameComponent {


    public Platform(int x, int y, int width, int height)
    {
        super(x, y, width, height);
        this.harmful = false;
    }

    public static ArrayList<Platform> createPlatforms(int gameLevel)
    {
        ArrayList<Platform> platforms = new ArrayList<Platform>();

        switch (gameLevel)
        {
            case LEVEL_INTRO:
                createIntroPlatforms(platforms);
                break;
            case LEVEL_GOOD:
                createGoodPlatforms(platforms);
                break;
            case LEVEL_COOL:
                createCoolPlatforms(platforms);
                break;
            case LEVEL_SCARY:
                createScaryPlatforms(platforms);
                break;
            case LEVEL_UNBEARABLE:
                createUnbearablePlatforms(platforms);
                break;
            case LEVEL_FINAL:
                createFinalPlatforms(platforms);
                break;
            default:
                break;
        }

        return platforms;
    }

    private static void createIntroPlatforms(ArrayList<Platform> p) {
        p.add(new Platform(150, 600, 250, 20));
        p.add(new Platform(700, 700, 250, 20));

    }

    private static void createGoodPlatforms(ArrayList<Platform> p) {

        p.add(new Platform(150, 500, 250, 20));
        p.add(new Platform(700, 700, 250, 20));

    }

    private static void createCoolPlatforms(ArrayList<Platform> p)
    {
        p.add(new Platform(150, 500, 250, 20));
        p.add(new Platform(800, 400, 100, 20));
        p.add(new Platform(700, 700, 250, 20));
    }

    private static void createScaryPlatforms(ArrayList<Platform> p)
    {
        p.add(new Platform(150, 500, 250, 20));
        p.add(new Platform(800, 400, 100, 20));
        p.add(new Platform(700, 700, 250, 20));
    }


    private static void createUnbearablePlatforms(ArrayList<Platform> p)
    {
        p.add(new Platform(150, 500, 250, 20));
        p.add(new Platform(400, 300, 150, 20));
        p.add(new Platform(800, 400, 100, 20));
        p.add(new Platform(700, 700, 250, 20));
    }
    private static void createFinalPlatforms(ArrayList<Platform> p)
    {
        p.add(new Platform(150, 500, 250, 20));
        p.add(new Platform(350, 650, 200, 20));
        p.add(new Platform(400, 300, 150, 20));
        p.add(new Platform(800, 400, 100, 20));
        p.add(new Platform(700, 700, 250, 20));
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.fillRect(getLeftEdge(), getTopEdge(), width, height);
    }
}
