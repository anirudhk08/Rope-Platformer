package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by axu047 on 5/5/2017.
 */
public  class LevelSelect extends JFrame implements ActionListener{

    public LevelSelect()
    {
        new JFrame();
        setBounds(100, 100, 450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Level Select");
        lblNewLabel.setBounds(174, 18, 86, 16);
        getContentPane().add(lblNewLabel);

        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Introduction", "A Good Day", "A Cool Day", "A Scary Day", "An Unbearable Day", "Final Day"}));
        comboBox.setBounds(133, 61, 127, 27);
        getContentPane().add(comboBox);

        JLabel lblChooseALevel = new JLabel("Choose a level");
        lblChooseALevel.setBounds(16, 65, 114, 16);
        getContentPane().add(lblChooseALevel);

        JButton btnPlay = new JButton("Play");
        btnPlay.setBounds(42, 224, 317, 29);
        getContentPane().add(btnPlay);


        JButton btnBack = new JButton("Back");
        btnBack.setBounds(42, 117, 117, 29);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setVisible(false);
                Window w = new Window();
                w.setVisible(true);
            }
        });
        getContentPane().add(btnBack);

    }

    public void actionPerformed(ActionEvent event)
    {

    }



}
