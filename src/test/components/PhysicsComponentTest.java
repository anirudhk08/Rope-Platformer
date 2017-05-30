package test.components;

import components.PhysicsComponent;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.*;

/**
 * Created by aubhrosengupta on 5/28/17.
 */
public class PhysicsComponentTest {

    private PhysicsComponent p;

    @Before
    public void setUp() throws Exception {
        p = new PhysicsComponent(0, 0) {
            @Override
            public void update() {

            }
        };
    }

    @Test
    public void getAbsoluteVel() throws Exception {
        assertNotNull(p);
    }

}