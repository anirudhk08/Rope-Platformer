package gui;

import components.Platform;
import map.Map;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Anirudh on 5/4/17.
 */
public class Window extends JFrame implements ActionListener {


    public Window()
    {
        setTitle("Game");
        setSize(1000, 1000);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Map m = new Map();
        m.addPlatform(new Platform(10, 10, 100, 100, 0.5, 0.3));
        Game g = new Game(this, m);
        add(g);

        g.repaint();
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
