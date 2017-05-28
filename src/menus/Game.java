package menus;

import components.Obstacle;
import components.StickFigure;
import data.KeyBindings;
import data.Level;
import master.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static menus.GameWindowConstants.*;


/**
 * Created by Anirudh on 5/27/2017.
 */
public class Game extends JPanel {
    private Level map;
    private StickFigure player;
    private Timer timer;
    private Player p1;
    private ArrayList<Obstacle> obstacles;

    public Game(Window parent, Level m, KeyBindings k){
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        map = m;
        player = new StickFigure(map.getStartX(), map.getStartY(), this, map);
        p1 = new Player(player, k);
        obstacles = Obstacle.createObstacles(GameLevelConstants.LEVEL_INTRO);
        start();
        repaint();
        setFocusable(true);
        requestFocus();
    }

    public void start() {
        addMouseListener(p1);
        addKeyListener(p1);
        ActionListener al = ae -> repaint();
        timer = new Timer((int) (1000.0 / FRAMES_PER_SECOND), al);
        timer.start();
    }

    public void stop() {
        if (timer != null) timer.stop();
        removeMouseListener(p1);
        removeKeyListener(p1);
    }

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
            o.draw(g2);
        }
    }
}