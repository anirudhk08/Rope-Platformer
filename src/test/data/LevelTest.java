package test.data;

import components.GameComponent;
import data.Level;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static junit.framework.TestCase.*;

/**
 * Tests Level class
 */
public class LevelTest {

    private Level l;

    /**
     * Sets up level
     * @throws Exception something wrong happened
     */
    @Before
    public void setUp() throws Exception {
        l = new Level(0,10,20,30);
    }

    /**
     * Tests level starting X position
     * @throws Exception something wrong happened
     */
    @Test
    public void getStartX() throws Exception {
        assertEquals(l.getStartX(), 0);
    }

    /**
     * Tests level starting Y position
     * @throws Exception something wrong happened
     */
    @Test
    public void getStartY() throws Exception {
        assertEquals(l.getStartY(), 10);
    }

    /**
     * Tests obstacle collision
     * @throws Exception something wrong happened
     */
    @Test
    public void isCollision() throws Exception {
        GameComponent g = new GameComponent(0,0) {
            @Override
            public void draw(Graphics2D g) {

            }
        };

        assertFalse(l.isCollision(g));

        l.add(g);

        g = new GameComponent(0, 0) {
            @Override
            public void draw(Graphics2D g) {
                super.draw(g);
            }
        };

        assertTrue(l.isCollision(g));
    }

}