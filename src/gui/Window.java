package gui;


import data.KeyBindings;
import data.Map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame
{

    private MainMenu menu;
    private LevelSelect levelSelect;
    private Settings settings;

    /**
     * Create the application.
     */
    public Window(KeyBindings keys)
    {
        super("Game");
        setSize(400,300);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);

        menu = new MainMenu(this);
        levelSelect = new LevelSelect(this);
        settings = new Settings(this, keys);
        add(menu, 0, 0);
//        Map m = new Map();
//        Game g = new Game(this, m);
//        add(g);
//        g.repaint();

        repaint();
    }

    public void goToSettings() {
        getContentPane().remove(menu);
        getContentPane().remove(levelSelect);
//        add(settings, 0, 0);
        add(settings);
        repaint();
    }

    public void goToLevelSelect() {
        getContentPane().remove(menu);
        getContentPane().remove(settings);
        add(levelSelect);
        repaint();
    }

    public void goToMainMenu()
    {
        getContentPane().remove(levelSelect);
        getContentPane().remove(settings);
        add(menu);
        repaint();

    }

}
