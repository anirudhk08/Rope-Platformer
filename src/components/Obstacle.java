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
                break;
            case LEVEL_COOL:
                break;
            case LEVEL_SCARY:
                break;
            case LEVEL_UNBEARABLE:
                break;
            case LEVEL_FINAL:
                break;
            default:
                break;
        }

        return obstacles;
    }


    private static void createIntroObstacles(ArrayList<Obstacle> obstacles) {
        obstacles.add(new Obstacle(30, 50, Color.BLUE, 50, 30));
        obstacles.add(new Obstacle(500, 100, Color.RED, 50, 30));
        obstacles.add(new Obstacle(200, 300, Color.GRAY, 50, 100));
        obstacles.add(new Obstacle(500, 500, Color.ORANGE, 50, 30));
        obstacles.add(new Obstacle(900, 250, Color.GREEN, 75, 30));
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(color);
        g.fillRect(xPos, yPos, width, height);
    }
}