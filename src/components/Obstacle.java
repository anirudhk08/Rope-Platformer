package components;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import static menus.GameLevelConstants.*;
import static menus.GameWindowConstants.WINDOW_HEIGHT;
import static menus.GameWindowConstants.WINDOW_WIDTH;


/**
 * Class representing Obstacle game component. These Obstacles blocks
 * the stick figure from moving forward and hence considered harmful.
 *
 * This class provide methods to create and manage Obstacles for
 * different levels of the game.
 *
 */
public class Obstacle extends GameComponent
{

    /**
     * Color of the obstacle
     */
    private Color color;

    /**
     * Flag to indicate if obstacle can move or not
     */
    private boolean move;

    /**
     * Constructor to initialize obstacle with its coordinates, widhth, height, color
     * and if it can move in random direction.
     *
     * @param startX - center x coordinate of the obstacle
     * @param startY - center y coordinate of the obstacle
     * @param color - color of the obstacle object
     * @param width - width of the obstacle object
     * @param height - height of the obstacle object
     * @param move - indicates if the obstacle can move or not
     */
    public Obstacle(int startX, int startY, Color color, int width, int height, boolean move) {
        super(startX, startY, width, height);

        this.color = color;
        this.move = move;
        this.harmful = true;
    }


    /**
     * Method to create a list of obstacles based a game level.
     *
     * @param gameLevel - parameter to indicate game level
     * @return - list of obstacles
     */
    public static ArrayList<Obstacle> createObstacles(int gameLevel)
    {
        ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();

        switch (gameLevel)
        {
            case LEVEL_INTRO:
                createIntroObstacles(obstacles);
                break;
            case LEVEL_GOOD:
                createGoodObstacles(obstacles);
                break;
            case LEVEL_COOL:
                createCoolObstacles(obstacles);
                break;
            case LEVEL_SCARY:
                createScaryObstacles(obstacles);
                break;
            case LEVEL_UNBEARABLE:
                createUnbearableObstacles(obstacles);
                break;
            case LEVEL_FINAL:
                createFinalObstacles(obstacles);
                break;
            default:
                break;
        }

        return obstacles;
    }

    /**
     * Method to create obstacle for "Introduction" game level
     *
     * @param obstacles - obstacle list
     */
    private static void createIntroObstacles(ArrayList<Obstacle> obstacles)
    {
        obstacles.add(new Obstacle(500, 50, Color.BLUE, 150, 75, true));

        // place obstacles on the winning end
        obstacles.add(new Obstacle(1000, 0, Color.GREEN, 75, 300, false));
        obstacles.add(new Obstacle(1000, 700, Color.GREEN, 75, 300, false));
    }

    /**
     * Method to create obstacle for "Good Day" game level
     *
     * @param obstacles - obstacle list
     */
    private static void createGoodObstacles(ArrayList<Obstacle> obstacles) {

        obstacles.add(new Obstacle(100, 620, Color.BLUE, 150, 75, true));
        obstacles.add(new Obstacle(500, 100, Color.RED, 150, 100, true));
        obstacles.add(new Obstacle(750, 620, Color.YELLOW, 100, 100, true));

        // place obstacles on the winning end
        obstacles.add(new Obstacle(1000, 0, Color.GREEN, 75, 500, false));
        obstacles.add(new Obstacle(1000, 700, Color.GREEN, 75, 200, false));
    }

    /**
     * Method to create obstacle for "Cool Day" game level
     *
     * @param obstacles - obstacle list
     */
    private static void createCoolObstacles(ArrayList<Obstacle> obstacles)
    {
        obstacles.add(new Obstacle(100, 620, Color.BLUE, 75, 75, true));
        obstacles.add(new Obstacle(500, 100, Color.RED, 75, 75, true));
        obstacles.add(new Obstacle(600, 620, Color.YELLOW, 75, 75, true));
        obstacles.add(new Obstacle(900, 250, Color.GREEN, 75, 75, true));

        // place obstacles on the winning end
        obstacles.add(new Obstacle(1000, 0, Color.CYAN, 75, 500, false));
        obstacles.add(new Obstacle(1000, 700, Color.CYAN, 75, 300, false));
    }

    /**
     * Method to create obstacle for "Scary Day" game level
     *
     * @param obstacles - obstacle list
     */
    private static void createScaryObstacles(ArrayList<Obstacle> obstacles)
    {
        obstacles.add(new Obstacle(100, 620, Color.BLUE, 150, 75, true));
        obstacles.add(new Obstacle(500, 100, Color.RED, 150, 100, true));
        obstacles.add(new Obstacle(600, 620, Color.YELLOW, 100, 100, true));
        obstacles.add(new Obstacle(900, 250, Color.GREEN, 75, 150, true));

        // place obstacles on the winning end
        obstacles.add(new Obstacle(1000, 0, Color.CYAN, 75, 500, false));
        obstacles.add(new Obstacle(1000, 700, Color.CYAN, 75, 300, false));
    }


    /**
     * Method to create obstacle for "Unbearable Day" game level
     *
     * @param obstacles - obstacle list
     */
    private static void createUnbearableObstacles(ArrayList<Obstacle> obstacles)
    {
        obstacles.add(new Obstacle(100, 100, Color.YELLOW, 70, 60, true));
        obstacles.add(new Obstacle(120, 600, Color.RED, 60, 80, true));
        obstacles.add(new Obstacle(500, 540, Color.BLUE, 70, 70, true));
        obstacles.add(new Obstacle(640, 200, Color.ORANGE, 50, 50, true));
        obstacles.add(new Obstacle(800, 540, Color.CYAN, 90, 90, true));

        // place obstacles on the winning end
        obstacles.add(new Obstacle(1000, 0, Color.GREEN, 75, 300, false));
        obstacles.add(new Obstacle(1000, 700, Color.GREEN, 75, 300, false));
    }

    /**
     * Method to create obstacle for "Final Day" game level
     *
     * @param obstacles - obstacle list
     */
    private static void createFinalObstacles(ArrayList<Obstacle> obstacles)
    {
        obstacles.add(new Obstacle(200, 100, Color.CYAN, 50, 50, true));
        obstacles.add(new Obstacle(310, 100, Color.RED, 50, 50, true));
        obstacles.add(new Obstacle(410, 100, Color.YELLOW, 50, 50, true));
        obstacles.add(new Obstacle(100, 600, Color.BLUE, 50, 50, true));
        obstacles.add(new Obstacle(200, 400, Color.ORANGE, 50, 50, true));
        obstacles.add(new Obstacle(700, 100, Color.MAGENTA, 50, 50, true));
        obstacles.add(new Obstacle(700, 500, Color.GREEN, 50, 50, true));

        // place obstacles on the winning end
        obstacles.add(new Obstacle(1000, 0, Color.GREEN, 75, 300, false));
        obstacles.add(new Obstacle(1000, 700, Color.GREEN, 75, 300, false));
    }


    /**
     * Method to know if this game component can move
     * in random directions
     *
     * @return - true if game component can move
     *    false if game component can move
     */
    public boolean canMove()
    {
        return move;
    }

    /**
     * Method to generate either negative or postive random numbers
     *
     * @return - negative or positive randam number
     */
    private int getRandomDirection()
    {
        int max = 4;
        int min = -4;

        int rand =  new Random().nextInt(max - min + 1) - max;

        return rand;
    }

    /**
     * Method to update the position of obstacle in a random direction
     *
     * The sign of x-coordinate and y-coordinate determines
     * the directions: (+, +), (+, -), (-, +), (-, -)
     *
     */
    public void updatePosition()
    {
        if (move)
        {
            int xOrig = (int) xPos;
            int yOrig = (int) yPos;


            xPos += getRandomDirection();
            yPos += getRandomDirection();

            if (getLeftEdge() < 0 || getRightEdge() > WINDOW_WIDTH
                    || getTopEdge() < 0 || getBottomEdge() > WINDOW_HEIGHT)
            {
                xPos = xOrig;
                yPos = yOrig;
            }

        }

    }

    /**
     * Method to move the obstacle to specified position
     *
     * @param xPos - center x coordinate of obstacle
     * @param yPos - center y coordinate of obstacle
     */
    public void updatePosition(int xPos, int yPos)
    {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    /**
     * Method to draw the the obstacle
     * 
     * @param g - graphics object
     */
    @Override
    public void draw(Graphics2D g)
    {
        g.setColor(color);
        g.fillRect(getLeftEdge(), getTopEdge(), width, height);
    }
}