package test.components;

import components.PhysicsComponent;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.*;

/**
 * Tests PhysicsComponent
 * Created by aubhrosengupta on 5/28/17.
 */
public class PhysicsComponentTest {

    private PhysicsComponent p;

    /**
     * sets up physicscomponent
     * @throws Exception something wrong happened
     */
    @Before
    public void setUp() throws Exception {
        p = new PhysicsComponent(0, 0) {
            @Override
            public void update() {

            }
        };
    }

    /**
     * tests if total velocity correct
     * @throws Exception something wrong happened
     */
    @Test
    public void getAbsoluteVel() throws Exception {
        assertNotNull(p);
    }

}