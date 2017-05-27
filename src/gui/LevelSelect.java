package gui;

import data.Map;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by axu047 on 5/5/2017.
 */
public  class LevelSelect extends JPanel implements ActionListener{

    public LevelSelect(Window parent)
    {
        setSize(601,400);
        setLayout(null);

        JLabel lblNewLabel = new JLabel("Level Select");
        lblNewLabel.setBounds(174, 18, 86, 16);
        add(lblNewLabel);

        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Introduction", "A Good Day", "A Cool Day", "A Scary Day", "An Unbearable Day", "Final Day"}));
        comboBox.setBounds(133, 61, 127, 27);
        add(comboBox);

        JLabel lblChooseALevel = new JLabel("Choose a level");
        lblChooseALevel.setBounds(16, 65, 114, 16);
        add(lblChooseALevel);

        JButton btnPlay = new JButton("Play");
        btnPlay.setBounds(42, 224, 317, 29);
        btnPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.startGame(new Map());
            }
        });
        add(btnPlay);


        JButton btnBack = new JButton("Back");
        btnBack.setBounds(42, 117, 117, 29);
        btnBack.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                parent.goToMainMenu();
            }


        });
        add(btnBack);

    }

    public void actionPerformed(ActionEvent event)
    {

    }



}
