package test.components;

import components.Player;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;

/**
 * Tests Player
 */
public class PlayerTest {

    /**
     * Tests Player constructor
     */
    @Test
    public void test() {
        Player p = new Player(null, null, null);
        assertNotNull(p);
    }

}