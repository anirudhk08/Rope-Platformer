package test.compnents;

import components.Player;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;

/**
 * Created by aubhrosengupta on 5/29/17.
 */
public class PlayerTest {
    @Test
    public void test() {
        Player p = new Player(null, null, null);
        assertNotNull(p);
    }

}