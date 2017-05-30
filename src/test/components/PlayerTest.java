package test.components;

import components.Player;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;

/**
 * Tests Player
 * Created by aubhrosengupta on 5/29/17.
 */
public class PlayerTest {

    /**
     * tests Player constructor
     */
    @Test
    public void test() {
        Player p = new Player(null, null, null);
        assertNotNull(p);
    }

}