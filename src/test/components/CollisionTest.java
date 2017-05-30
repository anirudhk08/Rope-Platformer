package test.components;

import components.*;
import data.KeyBindings;
import data.Level;
import menus.*;
import org.junit.Before;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import static junit.framework.TestCase.*;

/**
 * Tests to validate the collisions or touching functionality of
 * Game components such as Rope, Stick Figure, Obstacle, Platform, ...
 *
 */
public class CollisionTest {
    /**
     * Obstacle object
     */
    private GameComponent obstacle;
    private GameComponent platform;
    private GameComponent player;
    private Level level;
    private Game g;

    /**
     * Setup the test data
     * @throws Exception - exception if errors during setup
     */
    @Before
    public void setUp() throws Exception {
        KeyBindings k = new KeyBindings();
        menus.Window w = new menus.Window(k);
        w.setVisible(false);
        w.startGame(new Level(0, 0, 0, 0));

        g = (Game) w.getContentPane().getComponent(0);
        player = g.getStickFigure();
        obstacle = new Obstacle(0, 0, Color.black, 20, 20, false);
        platform = new Platform(150, 600, 250, 20);
        level = new Level(0, 0, 100, 100);

        level.add(obstacle);
        level.add(platform);
        level.add(player);
    }

    /**
     * Test to validate that an obstacle overlaps with another obstacle
     * @throws Exception - error to validate obstacle collision
     */
    @Test
    public void obstacleObstacleCollision() throws Exception {
        Obstacle o = new Obstacle(10, 10, Color.black, 30, 30, false);
        assertTrue(level.isCollision(o));
    }

    /**
     * Test to validate that an obstacle does not overlap with another obstacle
     * @throws Exception - error to validate obstacle collision
     */
    @Test
    public void obstacleObstacleNoCollision() throws Exception {
        Obstacle o = new Obstacle(50, 50, Color.black, 10, 10, false);
        assertFalse(level.isCollision(o));
    }

    /**
     * Test to validate that an obstacle overlaps with a platform
     * @throws Exception - error to validate obstacle collision
     */
    @Test
    public void obstaclePlatformCollision() throws Exception {
        Platform p = new Platform(10, 10, 30, 30);
        assertTrue(level.isCollision(p));
    }

    /**
     * Test to validate that an obstacle collides with a player
     * @throws Exception - error to validate obstacle collision
     */
    @Test
    public void obstaclePlayerCollision() throws Exception {
        assertTrue(level.isCollision(player));
    }

    /**
     * Test to validate that an obstacle does not collide with a player
     * @throws Exception - error to validate obstacle collision
     */
    @Test
    public void obstaclePlayerNoCollision() throws Exception {
        BufferedImage image = ImageIO.read(new File("resources/spidersmall.png"));
        StickFigure player1 = new StickFigure(g, image, level);
        player1.updatePos();
        assertFalse(level.isCollision(player1));
    }

}