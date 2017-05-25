package gui;


import data.Map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame
{

    /**
     * Create the application.
     */
    public Window()
    {
        super("Game");
        setSize(1000,1000);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Map m = new Map();
        Game g = new Game(this, m);
        add(g);
        g.repaint();

        repaint();
    }

}
