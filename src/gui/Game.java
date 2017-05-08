package gui;

import components.StickFigure;
import map.Map;

import javax.swing.*;
import java.awt.*;

/**
 * Created by axu047 on 5/5/2017.
 */
public class Game extends JPanel {
    private Map map;
    private StickFigure player;

    public Game(Map m) {
        map = m;
        player = new StickFigure(map.getStartX(), map.getStartY());
    }

    @Override
    public void paint(Graphics g) {
        map.draw(g);

    }
}
