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

    private Obstacle o;

    @Before
    public void setUp() throws Exception {
        o = new Obstacle(0, 0, Color.black, 20, 20, false);
    }

    @Test
    public void createObstacles() throws Exception {
        ArrayList<Obstacle> obstacles = Obstacle.createObstacles(GameLevelConstants.LEVEL_INTRO);
        assertEquals(obstacles.size(), 3);

        obstacles = Obstacle.createObstacles(GameLevelConstants.LEVEL_COOL);
        assertEquals(obstacles.size(), 6);

        obstacles = Obstacle.createObstacles(GameLevelConstants.LEVEL_GOOD);
        assertEquals(obstacles.size(), 5);

        obstacles = Obstacle.createObstacles(GameLevelConstants.LEVEL_SCARY);
        assertEquals(obstacles.size(), 6);

        obstacles = Obstacle.createObstacles(GameLevelConstants.LEVEL_UNBEARABLE);
        assertEquals(obstacles.size(), 7);

        obstacles = Obstacle.createObstacles(GameLevelConstants.LEVEL_FINAL);
        assertEquals(obstacles.size(), 9);
    }

    @Test
    public void canMove() throws Exception {
        assertFalse(o.canMove());
    }

}