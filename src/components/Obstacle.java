package components;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import static menus.GameLevelConstants.*;
import static menus.GameWindowConstants.WINDOW_HEIGHT;
import static menus.GameWindowConstants.WINDOW_WIDTH;

/**
 * Created by Anirudh on 5/27/2017.
 */
public class Obstacle extends GameComponent {
    private int xPos;
    private int yPos;
    private Color color;
    private int width;
    private int height;

    private boolean move;


    public Obstacle(int startX, int startY, Color color, int width, int height, boolean move) {
        super(startX, startY);
        xPos = startX;
        yPos = startY;
        this.color = color;
        this.width = width;
        this.height = height;

        this.move = move;
    }


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


    private static void createIntroObstacles(ArrayList<Obstacle> obstacles) {
        obstacles.add(new Obstacle(500, 50, Color.BLUE, 150, 75, false));
        obstacles.add(new Obstacle(100, 600, Color.ORANGE, 150, 95, false));

    }

    private static void createGoodObstacles(ArrayList<Obstacle> obstacles) {

        obstacles.add(new Obstacle(100, 620, Color.BLUE, 160, 65, false));
        obstacles.add(new Obstacle(500, 100, Color.RED, 100, 30, false));
        obstacles.add(new Obstacle(750, 200, Color.GRAY, 100, 20, false));
        obstacles.add(new Obstacle(500, 500, Color.ORANGE, 40, 30, false));
        obstacles.add(new Obstacle(300, 200, Color.GREEN, 75, 30, false));
        obstacles.add(new Obstacle(750, 620, Color.PINK, 100, 25, false));

    }

    private static void createCoolObstacles(ArrayList<Obstacle> obstacles)
    {
        obstacles.add(new Obstacle(30, 50, Color.BLUE, 200, 30, false));
        obstacles.add(new Obstacle(500, 100, Color.RED, 300, 50, false));
        obstacles.add(new Obstacle(200, 620, Color.GRAY, 200, 30, false));
        obstacles.add(new Obstacle(500, 450, Color.ORANGE, 200, 25, false));
        obstacles.add(new Obstacle(900, 250, Color.GREEN, 75, 400, false));
        obstacles.add(new Obstacle(100, 500, Color.CYAN, 50, 50, false));
    }

    private static void createScaryObstacles(ArrayList<Obstacle> obstacles)
    {
        obstacles.add(new Obstacle(100, 600, Color.CYAN, 50, 50, false));
        obstacles.add(new Obstacle(250, 560, Color.GREEN, 350, 150, false));
        obstacles.add(new Obstacle(350, 50, Color.RED, 60, 60, false));
        obstacles.add(new Obstacle(600, 200, Color.ORANGE, 100, 30, false));
        obstacles.add(new Obstacle(700, 400, Color.BLUE, 30, 150, false));
        obstacles.add(new Obstacle(850, 580, Color.BLACK, 60, 60, true));
        obstacles.add(new Obstacle(100, 460, Color.YELLOW, 70, 70, false));
    }


    private static void createUnbearableObstacles(ArrayList<Obstacle> obstacles)
    {
        obstacles.add(new Obstacle(100, 100, Color.YELLOW, 70, 60, false));
        obstacles.add(new Obstacle(120, 540, Color.RED, 80, 80, false));
        obstacles.add(new Obstacle(500, 150, Color.BLACK, 80,80, false));
        obstacles.add(new Obstacle(500, 540, Color.BLUE, 90, 90, false));
        obstacles.add(new Obstacle(640, 200, Color.ORANGE, 100, 300, true));
        obstacles.add(new Obstacle(800, 540, Color.CYAN, 90, 90, true));
    }
    private static void createFinalObstacles(ArrayList<Obstacle> obstacles)
    {
        obstacles.add(new Obstacle(200, 100, Color.CYAN, 50, 50, true));
        obstacles.add(new Obstacle(310, 100, Color.RED, 50, 50, true));
        obstacles.add(new Obstacle(410, 100, Color.YELLOW, 50, 50, true));
        obstacles.add(new Obstacle(100, 520, Color.BLUE, 60, 60, true));
        obstacles.add(new Obstacle(200, 480, Color.ORANGE, 350, 230, true));
        obstacles.add(new Obstacle(700, 100, Color.MAGENTA, 100, 250, true));
        obstacles.add(new Obstacle(700, 500, Color.GREEN, 100, 230, true));
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean canMove() {
        return move;
    }

    private int getRandomDirection()
    {
        int rand =  new Random().nextInt(7) - 3;
        return rand;
    }

    public boolean isCollision(ArrayList<Obstacle> obstacles)
    {
        boolean collision = false;

        for (Obstacle o: obstacles)
        {
            if (this.equals(o))
            {
                continue;
            }

            if ( (xPos < o.getxPos() + o.getWidth())
                    && (xPos + width > o.getxPos())
                    && (yPos < o.getyPos() + o.getHeight())
                    && (yPos + height > o.getyPos()) )
            {
                collision = true;
                break;
            }

        }

        return collision;
    }

    public void updatePosition()
    {
        if (move)
        {
            int xOrig = xPos;
            int yOrig = yPos;


            xPos += getRandomDirection();
            yPos += getRandomDirection();

            if (!((xPos >= 0) && (xPos <= WINDOW_WIDTH)
                    && (yPos >= 0) && (yPos <= WINDOW_HEIGHT)
                    && (xPos+width >= 0) && (xPos+width <= WINDOW_WIDTH)
                    && (yPos+height >= 0) && (yPos+height <= WINDOW_HEIGHT)))
            {
                xPos = xOrig;
                yPos = yOrig;
            }
        }

        return;
    }

    @Override
    public void draw(Graphics2D g)
    {
        g.setColor(color);
        g.fillRect(xPos, yPos, width, height);
    }
}