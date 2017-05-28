package components;

import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import menus.GameLevelConstants;

import static menus.GameLevelConstants.*;

/**
 * Created by Anirudh on 5/27/2017.
 */
public class Obstacle extends GameComponent {
    private int xPos;
    private int yPos;
    private Color color;
    private int width;
    private int height;


    public Obstacle(int startX, int startY, Color color, int width, int height) {
        super(startX, startY);
        xPos = startX;
        yPos = startY;
        this.color = color;
        this.width = width;
        this.height = height;
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
        obstacles.add(new Obstacle(500, 50, Color.BLUE, 150, 75));
        obstacles.add(new Obstacle(100, 600, Color.ORANGE, 150, 95));

    }

    private static void createGoodObstacles(ArrayList<Obstacle> obstacles) {


        obstacles.add(new Obstacle(100, 620, Color.BLUE, 160, 65));
        obstacles.add(new Obstacle(500, 100, Color.RED, 100, 30));
        obstacles.add(new Obstacle(750, 200, Color.GRAY, 100, 20));
        obstacles.add(new Obstacle(500, 500, Color.ORANGE, 40, 30));
        obstacles.add(new Obstacle(300, 200, Color.GREEN, 75, 30));
        obstacles.add(new Obstacle(750, 620, Color.PINK, 100, 25));

    }

    private static void createCoolObstacles(ArrayList<Obstacle> obstacles)
    {
        obstacles.add(new Obstacle(30, 50, Color.BLUE, 200, 30));
        obstacles.add(new Obstacle(500, 100, Color.RED, 300, 50));
        obstacles.add(new Obstacle(200, 620, Color.GRAY, 200, 30));
        obstacles.add(new Obstacle(500, 450, Color.ORANGE, 200, 25));
        obstacles.add(new Obstacle(900, 250, Color.GREEN, 75, 400));
        obstacles.add(new Obstacle(100, 500, Color.CYAN, 50, 50));
    }

    private static void createScaryObstacles(ArrayList<Obstacle> obstacles)
    {
        obstacles.add(new Obstacle(100, 600, Color.CYAN, 50, 50));
        obstacles.add(new Obstacle(250, 560, Color.GREEN, 350, 150));
        obstacles.add(new Obstacle(350, 50, Color.RED, 60, 60));
        obstacles.add(new Obstacle(600, 200, Color.ORANGE, 100, 30));
        obstacles.add(new Obstacle(700, 400, Color.BLUE, 30, 150));
        obstacles.add(new Obstacle(850, 580, Color.BLACK, 60, 60));
        obstacles.add(new Obstacle(100, 460, Color.YELLOW, 70, 70));
    }


    private static void createUnbearableObstacles(ArrayList<Obstacle> obstacles)
    {
        obstacles.add(new Obstacle(100, 100, Color.YELLOW, 70, 60));
        obstacles.add(new Obstacle(120, 540, Color.RED, 80, 80));
        obstacles.add(new Obstacle(500, 150, Color.BLACK, 80,80));
        obstacles.add(new Obstacle(500, 540, Color.BLUE, 90, 90));
        obstacles.add(new Obstacle(640, 200, Color.ORANGE, 100, 300));
        obstacles.add(new Obstacle(800, 540, Color.CYAN, 90, 90));
    }
    private static void createFinalObstacles(ArrayList<Obstacle> obstacles)
    {
        obstacles.add(new Obstacle(200, 100, Color.CYAN, 50, 50));
        obstacles.add(new Obstacle(310, 100, Color.RED, 50, 50));
        obstacles.add(new Obstacle(410, 100, Color.YELLOW, 50, 50));
        obstacles.add(new Obstacle(100, 520, Color.BLUE, 60, 60));
        obstacles.add(new Obstacle(200, 480, Color.ORANGE, 350, 230));
        obstacles.add(new Obstacle(700, 100, Color.MAGENTA, 100, 250));
        obstacles.add(new Obstacle(700, 500, Color.MAGENTA, 100, 230));
    }



    @Override
    public void draw(Graphics2D g) {
        g.setColor(color);
        g.fillRect(xPos, yPos, width, height);
    }
}