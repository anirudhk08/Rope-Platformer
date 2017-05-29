package test.data;

import components.GameComponent;
import data.Level;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static junit.framework.TestCase.*;

/**
 * Created by aubhrosengupta on 5/29/17.
 */
public class LevelTest {

    private Level l;

    @Before
    public void setUp() throws Exception {
        l = new Level(0,10,20,30);
    }

    @Test
    public void getStartX() throws Exception {
        assertEquals(l.getStartX(), 0);
    }

    @Test
    public void getStartY() throws Exception {
        assertEquals(l.getStartY(), 10);
    }

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