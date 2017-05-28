package menus;

import data.Level;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static menus.GameLevelConstants.*;
import static menus.GameWindowConstants.*;


/**
 * Created by axu047 on 5/5/2017.
 */
public  class LevelSelect extends JPanel implements ActionListener{
    private static JComboBox comboBox;

    public LevelSelect(Window parent)
    {
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
//        setBounds(100, 100, 450, 300);
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
        btnPlay.addActionListener(e -> parent.startGame(new Level()));
        add(btnPlay);


        JButton btnBack = new JButton("Back");
        btnBack.setBounds(42, 117, 117, 29);
        btnBack.addActionListener(e -> parent.goToMainMenu());
        add(btnBack);

    }

    public static int getGameLevel() {
        return comboBox.getSelectedIndex();
    }

    public void actionPerformed(ActionEvent event)
    {

    }



}
