package test.compnents;

import components.Obstacle;
import menus.GameLevelConstants;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

import static junit.framework.TestCase.*;

/**
 * Created by aubhrosengupta on 5/28/17.
 */
public class ObstacleTest {
    @Before
    public void setUp() throws Exception {
        Obstacle o = new Obstacle(0, 0, Color.black, 20, 20, false);
    }

    @Test
    public void createObstacles() throws Exception {
        ArrayList<Obstacle> obstacles = Obstacle.createObstacles(GameLevelConstants.LEVEL_INTRO);
        assertEquals(obstacles.size(), 1);

        obstacles = Obstacle.createObstacles(GameLevelConstants.LEVEL_COOL);
        assertEquals(obstacles.size(), 4);

        obstacles = Obstacle.createObstacles(GameLevelConstants.LEVEL_GOOD);
        assertEquals(obstacles.size(), 3);

        obstacles = Obstacle.createObstacles(GameLevelConstants.LEVEL_SCARY);
        assertEquals(obstacles.size(), 4);

        obstacles = Obstacle.createObstacles(GameLevelConstants.LEVEL_UNBEARABLE);
        assertEquals(obstacles.size(), 5);

        obstacles = Obstacle.createObstacles(GameLevelConstants.LEVEL_FINAL);
        assertEquals(obstacles.size(), 7);
    }

    @Test
    public void canMove() throws Exception {
    }

}