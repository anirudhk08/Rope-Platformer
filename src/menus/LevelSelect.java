package menus;

import data.Level;
import javafx.scene.control.ComboBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import static menus.GameLevelConstants.*;
import static menus.GameWindowConstants.*;


/**
 * This class is the GUI for LevelSelect. It enables the user
 * to select a level. In addition, the includes GUI Components
 * such as textboxes, labels, combo boxes, etc...
 *
 * @author - Anirudh Kothapalli
 */

public class LevelSelect extends JPanel implements ActionListener
{

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
        lblNewLabel.setBounds(380, 19, 225, 36);
        lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        add(lblNewLabel);


        comboBox = new JComboBox();


        String[] gameLevels = {LEVEL_INTRO_STR, LEVEL_GOOD_STR, LEVEL_COOL_STR, LEVEL_SCARY_STR,
            LEVEL_UNBEARABLE_STR, LEVEL_FINAL_STR};

        comboBox.setModel(new DefaultComboBoxModel(gameLevels));
        comboBox.setBounds(347, 157, 218, 60);
        comboBox.setVisible(true);
        comboBox.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        add(comboBox);


        JLabel lblChooseALevel = new JLabel("Choose a level");
        lblChooseALevel.setBounds(376, 103, 229, 27);
        lblChooseALevel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        add(lblChooseALevel);

        JButton btnPlay = new JButton("Play");
        btnPlay.setBounds(446, 564, 500, 96);
        btnPlay.setFont(new Font("Comic Sans Ms", Font.PLAIN, 20));
        btnPlay.addActionListener(e -> parent.startGame(new Level(100, 100, 900, 900)));
        add(btnPlay);


        JButton btnBack = new JButton("Back");
        btnBack.setBounds(41, 574, 211, 79);
        btnBack.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
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
