package main.gui;

import main.data.Map;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Anirudh on 5/4/17.
 */
public class Window extends JFrame implements ActionListener {


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

    public void actionPerformed(ActionEvent e)
    {
        System.out.println("Button has been clicked");
    }










}
