package test.compnents;

import components.Rope;
import org.junit.Before;
import org.junit.Test;

import static org.testng.AssertJUnit.*;

/**
 * Created by aubhrosengupta on 5/29/17.
 */
public class RopeTest {

    private Rope r;

    @Before
    public void init() {
        r = new Rope(0, 0, false, null);
    }
    @Test
    public void isSwingingRope() throws Exception {
        assertFalse(r.isSwingingRope());

        r = new Rope(0, 0, true, null);
        assertTrue(r.isSwingingRope());
    }

    @Test
    public void isGrapplingRope() throws Exception {
        assertTrue(r.isGrapplingRope());

        r = new Rope(0, 0, true, null);
        assertFalse(r.isSwingingRope());
    }

    @Test
    public void length() throws Exception {
        assertNotNull(r);
    }

    @Test
    public void distance() throws Exception {
        assertNotNull(r);
    }

    @Test
    public void angleToVertical() throws Exception {
        assertNotNull(r);
    }

    @Test
    public void angleFromOwner() throws Exception {
        assertNotNull(r);
    }

}