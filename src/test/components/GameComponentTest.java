package test.components;

import components.GameComponent;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static junit.framework.TestCase.*;

/**
 * Tests GameComponents
 *
 * @author - Aubhro Sengupta
 */
public class GameComponentTest {

    public GameComponent g;

    /**
     * initialize Gamecomponent
     */
    @Before
    public void init() {
        g = new GameComponent(0, 0, 10, 20) {

            @Override
            public void draw(Graphics2D g) {

            }
        };
    }

    /**
     * tests top edge of gamecomponent
     * @throws Exception something wrong happened
     */
    @Test
    public void getTopEdge() throws Exception {
        // Y axis reverted
        assertEquals(g.getTopEdge(), -10);
    }

    /**
     * tests bottom edge of gamecomponent
     * @throws Exception something wrong happened
     */
    @Test
    public void getBottomEdge() throws Exception {
        assertEquals(g.getBottomEdge(), 10);
    }

    /**
     * tests right edge of gamecomponent
     * @throws Exception something wrong happened
     */
    @Test
    public void getRightEdge() throws Exception {
        assertEquals(g.getRightEdge(), 5);
    }

    /**
     * tests left edge of gamecomponent
     * @throws Exception something wrong happened
     */
    @Test
    public void getLeftEdge() throws Exception {
        assertEquals(g.getLeftEdge(), -5);
    }

    /**
     * tests center x position of gamecomponent
     * @throws Exception something wrong happened
     */
    @Test
    public void getxPos() throws Exception {
        assertEquals(g.getxPos(), 0D);
    }

    /**
     * tests center y position of gamecomponent
     * @throws Exception something wrong happened
     */
    @Test
    public void getyPos() throws Exception {
        assertEquals(g.getyPos(), 0D);
    }

    /**
     * tests if two gamecomponents touching
     * @throws Exception something wrong happened
     */
    @Test
    public void isTouching() throws Exception {
        GameComponent other = new GameComponent(0, 20, 10, 20) {

            @Override
            public void draw(Graphics2D g) {

            }
        };

        assertTrue(g.isTouching(other));

        other = new GameComponent(0, 300, 10, 20) {

            @Override
            public void draw(Graphics2D g) {

            }
        };

        assertFalse(g.isTouching(other));

    }

    /**
     * tests if gamecomponent using an image
     * @throws Exception something wrong happened
     */
    @Test
    public void hasImage() throws Exception {
        assertFalse(g.hasImage());
    }

}