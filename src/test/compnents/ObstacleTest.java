package test.compnents;

import components.Obstacle;
import menus.GameLevelConstants;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

import static junit.framework.TestCase.*;

/**
 * Test class to validate the methods of Obstacless class
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
    public void canMoveTrue() throws Exception {
        Obstacle o = new Obstacle(200, 100, Color.CYAN, 50, 50, true);
        assertTrue(o.canMove());
    }

    @Test
    public void canMoveFalse() throws Exception {
        Obstacle o = new Obstacle(200, 100, Color.CYAN, 50, 50, false);
        assertFalse(o.canMove());
    }

    @Test
    public void getRandomDirection() throws Exception {
        Obstacle o = new Obstacle(200, 100, Color.CYAN, 50, 50, true);

        double xOrig = o.getxPos();
        double yOrig = o.getyPos();

        o.updatePosition();

        assertTrue( Math.abs(o.getxPos() - xOrig) <= 4 );
        assertTrue(Math.abs(o.getyPos() - yOrig)  <= 4 );
    }

    @Test
    public void updatePosition() throws Exception {
        Obstacle o = new Obstacle(200, 100, Color.CYAN, 50, 50, true);
        double xOrig = o.getxPos();
        double yOrig = o.getyPos();

        o.updatePosition();

        assertTrue( xOrig != o.getxPos() || yOrig != o.getyPos() );
    }

    @Test
    public void updatePositionWithCoordinates() throws Exception {
        Obstacle o = new Obstacle(100, 100, Color.BLACK, 50, 50, true);

        o.updatePosition(200, 300);

        assertTrue( o.getxPos() == 200 || o.getyPos() == 300 );
    }
}