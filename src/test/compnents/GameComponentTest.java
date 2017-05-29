package test.compnents;

import components.GameComponent;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static junit.framework.TestCase.*;

/**
 * Created by aubhrosengupta on 5/28/17.
 */
public class GameComponentTest {

    public GameComponent g;

    @Before
    public void init() {
        g = new GameComponent(0, 0, 10, 20) {

            @Override
            public void draw(Graphics2D g) {

            }
        };
    }

    @Test
    public void getTopEdge() throws Exception {
        // Y axis reverted
        assertEquals(g.getTopEdge(), -10);
    }

    @Test
    public void getBottomEdge() throws Exception {
        assertEquals(g.getBottomEdge(), 10);
    }

    @Test
    public void getRightEdge() throws Exception {
        assertEquals(g.getRightEdge(), 5);
    }

    @Test
    public void getLeftEdge() throws Exception {
        assertEquals(g.getLeftEdge(), -5);
    }

    @Test
    public void getxPos() throws Exception {
        assertEquals(g.getxPos(), 0);
    }

    @Test
    public void getyPos() throws Exception {
        assertEquals(g.getyPos(), 0);
    }

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

    @Test
    public void hasImage() throws Exception {
        assertFalse(g.hasImage());
    }

}