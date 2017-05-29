package components;

import java.awt.*;
import java.util.ArrayList;

import static menus.GameLevelConstants.*;
import static menus.GameLevelConstants.LEVEL_FINAL;
import static menus.GameLevelConstants.LEVEL_UNBEARABLE;

/**
 * This class is for Platform game component. These Platform components
 * are static, do not block the stick figure from moving forward and
 * are not considered harmful.
 *
 * This class provide methods to create and manage Platform components
 * for different levels of the game.
 *
 */
public class Platform extends GameComponent {
    /**
     * Constructor to initialize the Platform component with center
     * coordinates, width and height of game component
     *
     * @param x - x coordinate of the Platform instance
     * @param y - y coordinate of the Platform instance
     * @param width - width of the Platform instance
     * @param height - height of the Platform instance
     */
    public Platform(int x, int y, int width, int height)
    {
        super(x, y, width, height);
        this.harmful = false;
    }

    /**
     * Method to create a list of Platform instances based a game level.
     *
     * @param gameLevel - parameter to indicate game level
     * @return - list of obstacles
     */
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


    /**
     * Method to create platform objects for "Introduction" game level
     *
     * @param p - List of platform objects
     */
    private static void createIntroPlatforms(ArrayList<Platform> p) {
        p.add(new Platform(150, 600, 250, 20));
        p.add(new Platform(700, 700, 250, 20));

    }

    /**
     * Method to create platform objects for "Good Day" game level
     *
     * @param p - List of platform objects
     */
    private static void createGoodPlatforms(ArrayList<Platform> p) {

        p.add(new Platform(150, 500, 250, 20));
        p.add(new Platform(700, 700, 250, 20));

    }

    /**
     * Method to create platform objects for "Cool Day" game level
     *
     * @param p - List of platform objects
     */
    private static void createCoolPlatforms(ArrayList<Platform> p)
    {
        p.add(new Platform(150, 500, 250, 20));
        p.add(new Platform(700, 300, 100, 20));
        p.add(new Platform(700, 700, 250, 20));
    }

    /**
     * Method to create platform objects for "Scary Day" game level
     *
     * @param p - List of platform objects
     */
    private static void createScaryPlatforms(ArrayList<Platform> p)
    {
        p.add(new Platform(150, 500, 250, 20));
        p.add(new Platform(750, 300, 100, 20));
        p.add(new Platform(700, 700, 250, 20));
    }

    /**
     * Method to create platform objects for "Unbearable Day" game level
     *
     * @param p - List of platform objects
     */
    private static void createUnbearablePlatforms(ArrayList<Platform> p)
    {
        p.add(new Platform(150, 500, 250, 20));
        p.add(new Platform(400, 300, 150, 20));
        p.add(new Platform(800, 400, 100, 20));
        p.add(new Platform(700, 700, 250, 20));
    }

    /**
     * Method to create platform objects for "Final Day" game level
     *
     * @param p - List of platform objects
     */
    private static void createFinalPlatforms(ArrayList<Platform> p)
    {
        p.add(new Platform(150, 500, 250, 20));
        p.add(new Platform(350, 650, 200, 20));
        p.add(new Platform(400, 300, 150, 20));
        p.add(new Platform(800, 400, 100, 20));
        p.add(new Platform(700, 700, 250, 20));
    }

    /**
     * Method to draw a platform object
     *
     * @param g - graphics object
     */
    @Override
    public void draw(Graphics2D g)
    {
        g.setColor(Color.BLACK);
        g.fillRect(getLeftEdge(), getTopEdge(), width, height);
    }
}
