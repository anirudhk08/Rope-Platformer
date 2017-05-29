package menus;

import components.*;
import data.KeyBindings;
import data.Level;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static menus.GameLevelConstants.LEVEL_FINAL;
import static menus.GameWindowConstants.*;

/**
 * Game is the main JPanel that will run all levels. To do so, the
 * paintComponent() method will continuously call the draw() method of all
 * the GameComponents in the level (including Map). More specifically, there is
 * a predefined FRAMES_PER_SECOND that will draw the game at set time intervals. There
 * is a pause button that stops the game and brings up a pause menu: the player can
 * return to the level select menu through here. When a level is finished, the next
 * level is automatically played; if it’s the last level, then the Window will return
 * to LevelSelect.
 *
 * Created by Anirudh on 5/27/2017.
 *
 */


public class Game extends JPanel {
    /**
     * Map of all Game Components
     */
    private Level map;

    /**
     * StickFigure representing the user playing the game
     */
    private StickFigure player;

    /**
     * Refresh frequency
     */
    private Timer timer;

    /**
     * The user playing the game
     */
    private Player p1;

    /**
     * List of obstacles placed in the game
     */
    private ArrayList<Obstacle> obstacles;

    private Window p;

    private int gameLevel;


    /**
     * List of platforms placed in the game
     */
    private ArrayList<Platform> platforms;

    /**
     * This is the constructor mapping the Game Components, GUI, and
     * player key bindings.
     * @param parent - parent GUI component
     * @param m - map of game components
     * @param k - user defined key bindings
     */
    public Game(Window parent, Level m, KeyBindings k){
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setBackground(Color.WHITE);

        map = m;
        try {
            BufferedImage image = ImageIO.read(new File("resources/spidermanfinal.png"));
            player = new StickFigure(this, image, map);
        } catch (IOException e) {
            e.printStackTrace();
        }

        p1 = new Player(player, k, this);


        // create obstacles and platforms based on game level
        gameLevel = LevelSelect.getGameLevel();
        obstacles = Obstacle.createObstacles(gameLevel);
        platforms = Platform.createPlatforms(gameLevel);

        // add all obstacles to game map
        for (Obstacle o: obstacles)
        {
            map.add(o);
        }
        p = parent;

        // add all platforms to game map
        for (Platform p: platforms)
        {
            map.add(p);
        }


        start();
        repaint();
        setFocusable(true);
    }


    /**
     * This method registers the action listeners
     * and starts the timer
     */
    public void start() {
        addMouseListener(p1);
        addKeyListener(p1);
        ActionListener al = ae -> repaint();
        timer = new Timer((int) (1000.0 / FRAMES_PER_SECOND), al);
        timer.start();
        p.requestFocus();
    }

    public void loadNextLevel() {
        if (gameLevel >= LEVEL_FINAL) {
            exit();
        } else {
            gameLevel += 1;
            map = new Level(0, 0, 100, 100);

            obstacles = Obstacle.createObstacles(gameLevel);
            platforms = Platform.createPlatforms(gameLevel);
            for (Obstacle o: obstacles)
            {
                map.add(o);
            }
            for (Platform p: platforms)
            {
                map.add(p);
            }
            player.updateMap(map);
            player.restart();
            repaint();
        }
    }


    /**
     * This method unregisters the action listeners
     * and stops the timer
     */
    public void exit() {
        if (timer != null) timer.stop();
        removeMouseListener(p1);
        removeKeyListener(p1);
        p.goToLevelSelect();
    }

    /**
     * Draw all the game components on the GUI Window.
     * @param g - graphics component
     */
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        super.paintComponent(g);
        map.draw(g2);
        player.draw(g2);


        for (Obstacle o: obstacles)
        {
            if (o.canMove()) {
                int xOrig = o.getxPos();
                int yOrig = o.getyPos();
                o.updatePosition();
                if (map.isCollision(o))
                {
                    o.updatePosition(xOrig, yOrig);
                }
            }

            o.draw(g2);
        }

        for (Platform p: platforms)
        {
            p.draw(g2);
        }
    }
}