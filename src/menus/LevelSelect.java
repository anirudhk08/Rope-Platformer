package menus;

import data.Level;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static menus.GameLevelConstants.*;
import static menus.GameWindowConstants.*;


/**
 * This class is the GUI for LevelSelect. It enables the user
 * to select a level. In addition, the includes GUI Components
 * such as textboxes, labels, combo boxes, etc...
 */

public  class LevelSelect extends JPanel implements ActionListener{

    /**
     * Combobox to display a list of game levels
     */
    private static JComboBox comboBox;

    /**
     * This is the constructor to initialize the class
     * with the Game Window
     * @param parent - Game Window
     */
    public LevelSelect(Window parent)
    {
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLayout(null);

        JLabel lblNewLabel = new JLabel("Level Select");
        lblNewLabel.setBounds(174, 18, 86, 16);
        add(lblNewLabel);

        comboBox = new JComboBox();


        String[] gameLevels = {LEVEL_INTRO_STR, LEVEL_GOOD_STR, LEVEL_COOL_STR, LEVEL_SCARY_STR,
            LEVEL_UNBEARABLE_STR, LEVEL_FINAL_STR};

        comboBox.setModel(new DefaultComboBoxModel(gameLevels));
        comboBox.setBounds(133, 61, 127, 27);
        add(comboBox);

        JLabel lblChooseALevel = new JLabel("Choose a level");
        lblChooseALevel.setBounds(16, 65, 114, 16);
        add(lblChooseALevel);

        JButton btnPlay = new JButton("Play");
        btnPlay.setBounds(42, 224, 317, 29);
        btnPlay.addActionListener(e -> parent.startGame(new Level(100, 100, 900, 900)));
        add(btnPlay);


        JButton btnBack = new JButton("Back");
        btnBack.setBounds(42, 117, 117, 29);
        btnBack.addActionListener(e -> parent.goToMainMenu());
        add(btnBack);

    }

    /**
     * This method returns the integer constant
     * representing the game level chosen by the
     * user
     * @return - game level constant
     */
    public static int getGameLevel()
    {
        return comboBox.getSelectedIndex();
    }

    /**
     * Method required for ActionListener
     * @param event - user action
     */
    public void actionPerformed(ActionEvent event)
    {

    }



}
