package menus;

import javax.swing.*;
import java.awt.*;

import static menus.GameWindowConstants.WINDOW_HEIGHT;
import static menus.GameWindowConstants.WINDOW_WIDTH;

/**
 * The class for displaying the GUI
 * components of the game menu.
 *
 * @author - Anirudh Kothapalli
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
        btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
        btnNewButton.setForeground(Color.BLACK);
        btnNewButton.setBounds(786, 191, 208, 76);
        btnNewButton.addActionListener(e -> parent.goToLevelSelect());
        add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Settings");
        btnNewButton_1.setForeground(Color.BLACK);
        btnNewButton_1.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
        btnNewButton_1.setBounds(786, 389, 208, 76);
        btnNewButton_1.addActionListener(e -> parent.goToSettings());
        add(btnNewButton_1);


        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setForeground(SystemColor.desktop);
        Image img = new ImageIcon("resources/amazingspiderman.png").getImage();
        lblNewLabel.setIcon(new ImageIcon(img));
        lblNewLabel.setBounds(0, 0, 1010, 900);
        add(lblNewLabel);

    }


}
