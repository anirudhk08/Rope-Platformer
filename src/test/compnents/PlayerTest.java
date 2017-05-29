package test.compnents;

import components.Player;
import org.junit.Before;

import static junit.framework.TestCase.*;

/**
 * Created by aubhrosengupta on 5/29/17.
 */
public class PlayerTest {
    @Before
    public void setUp() throws Exception {
        Player p = new Player(null, null, null);
        assertNotNull(p);
    }

}