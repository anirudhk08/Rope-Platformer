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
import static org.junit.Assert.assertFalse;


/**
 * Created by aubhrosengupta on 5/29/17.
 */
public class RopeTest {

    private Rope r;

    @Before
    public void init() {
        r = new Rope(0, 0, false, new StickFigure(null, new Image() {
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
        assertFalse(r.isGrapplingRope());
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