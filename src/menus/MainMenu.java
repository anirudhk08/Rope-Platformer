package menus;

import javax.swing.*;
import java.awt.*;

import static menus.GameWindowConstants.WINDOW_HEIGHT;
import static menus.GameWindowConstants.WINDOW_WIDTH;

/**
 * The class for displaying the GUI
 * components of the game menu.
 */
public class MainMenu extends JPanel {

    /**
     * Constructor to initialize the
     * Game Menu.
     * @param parent - Game Window
     */
    public MainMenu(Window parent) {

        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        JButton btnNewButton = new JButton("Level Select");
        btnNewButton.setBackground(Color.CYAN);
        btnNewButton.setBounds(18, 215, 117, 29);
        btnNewButton.addActionListener(e -> parent.goToLevelSelect());
        add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Settings");
        btnNewButton_1.setBounds(176, 215, 117, 29);
        btnNewButton_1.addActionListener(e -> parent.goToSettings());
        add(btnNewButton_1);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setForeground(SystemColor.desktop);
        Image img = new ImageIcon("resources/platformer.png").getImage();
        lblNewLabel.setIcon(new ImageIcon(img));
        lblNewLabel.setBounds(0,0, 1000, 1000);
        add(lblNewLabel);

//        Panel panel = new Panel();
//        panel.setBounds(0, 0, 197, 60);
//        add(panel);

//        JLabel lblWelcomeToRope = new JLabel("Welcome to Rope Platformer");
//        lblWelcomeToRope.setForeground(SystemColor.desktop);
//        panel.add(lblWelcomeToRope);
    }


}
