package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static gui.GameWindowConstants.*;

/**
 * Created by axu047 on 5/5/2017.
 */
public class MainMenu extends JPanel {


    public MainMenu(Window parent) {
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        JButton btnNewButton = new JButton("Level Select");
        btnNewButton.setBackground(Color.CYAN);
        btnNewButton.setBounds(18, 215, 117, 29);
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                parent.goToLevelSelect();
            }
        });
        add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Settings");
        btnNewButton_1.setBounds(176, 215, 117, 29);
        btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                parent.goToSettings();
            }
        });
        add(btnNewButton_1);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setForeground(SystemColor.desktop);
        Image img = new ImageIcon("platformer.png").getImage();
        lblNewLabel.setIcon(new ImageIcon(img));
        lblNewLabel.setBounds(0,0, 450, 278);
        add(lblNewLabel);

//        Panel panel = new Panel();
//        panel.setBounds(0, 0, 197, 60);
//        add(panel);

//        JLabel lblWelcomeToRope = new JLabel("Welcome to Rope Platformer");
//        lblWelcomeToRope.setForeground(SystemColor.desktop);
//        panel.add(lblWelcomeToRope);
    }


}
