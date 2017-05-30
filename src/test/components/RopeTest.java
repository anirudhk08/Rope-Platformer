package test.components;

import components.Rope;
import components.StickFigure;
import data.Level;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


/**
 * Tests rope class
 */
public class RopeTest {

    private Rope r;

    /**
     * Creates a rope
     */
    @Before
    public void init() {
        r = new Rope(10, 10, false, new StickFigure(null, new Image() {
            @Override
            public int getWidth(ImageObserver observer) {
                return 10;
            }

            @Override
            public int getHeight(ImageObserver observer) {
                return 20;
            }

            @Override
            public ImageProducer getSource() {
                return null;
            }

            @Override
            public Graphics getGraphics() {
                return null;
            }

            @Override
            public Object getProperty(String name, ImageObserver observer) {
                return null;
            }
        }, new Level(0, 0, 0, 0)));
    }

    /**
     * Tests if rope is swinging
     * @throws Exception something wrong happened
     */
    @Test
    public void isSwingingRope() throws Exception {
        assertFalse(r.isSwingingRope());

        r = new Rope(0, 0, true, null);
        assertTrue(r.isSwingingRope());
    }

    /**
     * Tests if rope is grappling hook
     * @throws Exception something wrong happened
     */
    @Test
    public void isGrapplingRope() throws Exception {
        assertTrue(r.isGrapplingRope());

        r = new Rope(0, 0, true, null);
        assertFalse(r.isGrapplingRope());
    }

    /**
     * Tests rope length
     * @throws Exception something wrong happened
     */
    @Test
    public void length() throws Exception {
        assertTrue(r.length() > 0);
        assertNotNull(r);
    }

    /**
     * Tests rope distance
     * @throws Exception something wrong happened
     */
    @Test
    public void distance() throws Exception {
        assertTrue(r.distance() > 0);
        assertNotNull(r);
    }

    /**
     * Tests rope length
     * @throws Exception something wrong happened
     */
    @Test
    public void angleToVertical() throws Exception {
        double d = r.angleToVertical();
        assertEquals(2.35, d, 0.01);
        assertNotNull(r);
    }

    /**
     * Tests the angle from owner
     * @throws Exception something wrong happened
     */
    @Test
    public void angleFromOwner() throws Exception {
        double d = r.angleFromOwner();
        assertEquals(0.78, d, 0.01);
        assertNotNull(r);
    }

}