package gui;

import components.Platform;
import map.Map;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Anirudh on 5/4/17.
 */
public class Window extends JFrame implements ActionListener {


    public Window()
    {
        super("Anirudh");
        setSize(1000,1000);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton button1 = new JButton("Level Select");
        button1.addActionListener(this);
        add(button1);
    }

    public void actionPerformed(ActionEvent e)
    {
        System.out.println("Button has been clicked");
    }










}
