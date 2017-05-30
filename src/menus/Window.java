package menus;


import data.KeyBindings;
import data.Level;

import javax.swing.*;

import static menus.GameWindowConstants.*;

/**
 * The Window class is the JFrame that contains all the content.
 * This project will use one JFrame and switch between multiple JPanels
 * that each contain different content. When the Window class is first
 * created, it will start off by creating all JPanels required (switch
 * between them instead of creating a new one every time), then show the
 * layout of components. Each JPanel will have a reference to this class so it can
 * be possible for the JPanels to let this class switch to other screens. All JPanels
 * have some form of a back button that will return to the previous menu.
 *
 *
 * @author - Anirudh Kothapalli
 */
public class Window extends JFrame
{
    /**
     * Game Menu
     */
    private MainMenu menu;

    /**
     * Game Levels
     */
    private LevelSelect levelSelect;

    /**
     * Game settings
     */
    private Settings settings;

    /**
     * User defined key bindings
     */
    private KeyBindings keyBindings;

    /**
     * The constructor to create the game
     * application.
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

    /**
     * This method starts the game based
     * on the user chosen game level
     * @param m - game level
     */
    public void startGame(Level m) {
        getContentPane().removeAll();
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        Game g = new Game(this, m, keyBindings);
        add(g);

        repaint();
    }

    /**
     * This method goes to settings when the settings
     * button is clicked
     */
    public void goToSettings() {
        getContentPane().removeAll();
        add(settings);
        repaint();
    }

    /**
     * This method goes to level select when
     * the level select button is clicked
     */
    public void goToLevelSelect() {
        getContentPane().removeAll();
        add(levelSelect);
        repaint();
    }

    /**
     * This method goes to main menu screen.
     */
    public void goToMainMenu()
    {
        getContentPane().removeAll();
        add(menu);
        repaint();
    }

}
