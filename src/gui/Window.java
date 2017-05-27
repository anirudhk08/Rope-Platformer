package gui;


import data.KeyBindings;
import data.Map;

import javax.swing.*;

import static gui.GameWindowConstants.*;

public class Window extends JFrame
{

    private MainMenu menu;
    private LevelSelect levelSelect;
    private Settings settings;
    private KeyBindings keyBindings;

    /**
     * Create the application.
     */
    public Window(KeyBindings keys)
    {
        keyBindings = keys;

        setTitle("Game");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);

        menu = new MainMenu(this);
        levelSelect = new LevelSelect(this);
        settings = new Settings(this, keyBindings);
        add(menu, 0, 0);

        repaint();
    }

    public void startGame(Map m) {
        getContentPane().removeAll();
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        Game g = new Game(this, m, keyBindings);
        add(g);

        repaint();
    }

    public void goToSettings() {
        getContentPane().removeAll();
        add(settings);
        repaint();
    }

    public void goToLevelSelect() {
        getContentPane().removeAll();
        add(levelSelect);
        repaint();
    }

    public void goToMainMenu()
    {
        getContentPane().removeAll();
        add(menu);
        repaint();
    }

}
