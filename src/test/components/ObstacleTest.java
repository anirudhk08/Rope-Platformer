package test.components;

import components.Obstacle;
import menus.GameLevelConstants;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

import static junit.framework.TestCase.*;

/**
 * Test class to validate the methods and functionality of Obstacle class
 */
public class ObstacleTest {

    /**
     * Obstacle object
     */
    private Obstacle o;

    /**
     * Setup the test data
     * @throws Exception - exception if errors during setup
     */
    @Before
    public void setUp() throws Exception {
        o = new Obstacle(0, 0, Color.black, 20, 20, false);
    }

    /**
     * Test that obstacles are created properly for Intro game level
     * @throws Exception - exception if there's an error with creation
     */
    @Test
    public void createObstaclesForIntroLevel() throws Exception {
        ArrayList<Obstacle> obstacles = Obstacle.createObstacles(GameLevelConstants.LEVEL_INTRO);
        assertEquals(obstacles.size(), 3);
    }

    /**
     * Test that obstacles are created properly for Cool game level
     * @throws Exception - exception if there's an error with creation
     */
    @Test
    public void createObstaclesForCoolLevel() throws Exception {
        ArrayList<Obstacle> obstacles = Obstacle.createObstacles(GameLevelConstants.LEVEL_COOL);
        assertEquals(obstacles.size(), 6);
    }

    /**
     * Test that obstacles are created properly for Good game level
     * @throws Exception - exception if there's an error with creation
     */
    @Test
    public void createObstaclesForGoodLevel() throws Exception {
        ArrayList<Obstacle> obstacles = Obstacle.createObstacles(GameLevelConstants.LEVEL_GOOD);
        assertEquals(obstacles.size(), 5);
    }

    /**
     * Test that obstacles are created properly for Scary game level
     * @throws Exception - exception if there's an error with creation
     */
    @Test
    public void createObstaclesForScaryLevel() throws Exception {
        ArrayList<Obstacle> obstacles = Obstacle.createObstacles(GameLevelConstants.LEVEL_SCARY);
        assertEquals(obstacles.size(), 6);
    }

    /**
     * Test that obstacles are created properly for Unbreable game level
     * @throws Exception - exception if there's an error with creation
     */
    @Test
    public void createObstaclesForUnbearableLevel() throws Exception {
        ArrayList<Obstacle> obstacles = Obstacle.createObstacles(GameLevelConstants.LEVEL_UNBEARABLE);
        assertEquals(obstacles.size(), 7);
    }

    /**
     * Test that obstacles are created properly for Final game level
     * @throws Exception - exception if there's an error with creation
     */
    @Test
    public void createObstaclesForFinalLevel() throws Exception {
        ArrayList<Obstacle> obstacles = Obstacle.createObstacles(GameLevelConstants.LEVEL_FINAL);
        assertEquals(obstacles.size(), 9);
    }

    /**
     * Test that move field is disabled correctly during creation
     * @throws Exception - exception if there's an error in initializing move field
     */
    @Test
    public void canMoveTrue() throws Exception {
        Obstacle o = new Obstacle(200, 100, Color.CYAN, 50, 50, true);
        assertTrue(o.canMove());
    }

    /**
     * Test that move field is enabled correctly during creation
     * @throws Exception - exception if there's an error in initializing move field
     */
    @Test
    public void canMoveFalse() throws Exception {
        Obstacle o = new Obstacle(200, 100, Color.CYAN, 50, 50, false);
        assertFalse(o.canMove());
    }

    /**
     * Test that obstacle moves in random direction when move is enabled
     * @throws Exception - error when obstacle position update
     */
    @Test
    public void getRandomDirectionWithMove() throws Exception {
        Obstacle o = new Obstacle(200, 100, Color.CYAN, 50, 50, true);

        double xOrig = o.getxPos();
        double yOrig = o.getyPos();

        o.updatePosition();

        assertTrue( Math.abs(o.getxPos() - xOrig) <= 4 );
        assertTrue(Math.abs(o.getyPos() - yOrig)  <= 4 );
    }

    /**
     * Test that obstacle moves in random direction when move is disabled
     * @throws Exception - error with obstacle position update
     */
    @Test
    public void getRandomDirectionWithoutMove() throws Exception {

        double xOrig = o.getxPos();
        double yOrig = o.getyPos();

        o.updatePosition();

        assertEquals( o.getxPos(), xOrig );
        assertEquals( o.getyPos(), yOrig );
    }


    /**
     * Test the obstacle position is updated to a new random position.
     *
     * @throws Exception - error with obstacle position update
     */
    @Test
    public void updatePosition() throws Exception {
        Obstacle o = new Obstacle(200, 100, Color.CYAN, 50, 50, true);
        double xOrig = o.getxPos();
        double yOrig = o.getyPos();

        o.updatePosition();

        assertTrue( xOrig != o.getxPos() || yOrig != o.getyPos() );
    }

    /**
     * Test the obstacle position is updated the specified position.
     *
     * @throws Exception - error with obstacle position update
     */
    @Test
    public void updatePositionWithCoordinates() throws Exception {
        Obstacle o = new Obstacle(100, 100, Color.BLACK, 50, 50, true);

        o.updatePosition(200, 300);

        assertTrue( o.getxPos() == 200 || o.getyPos() == 300 );
    }
}