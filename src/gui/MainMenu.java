package gui;

import javax.swing.*;

/**
 * Created by axu047 on 5/5/2017.
 */
public class MainMenu extends JPanel {

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Action");
        JPanel panel = new JPanel();
        JButton button = new JButton("Click");

        panel.add(button);
        frame.add(panel);

        frame.setSize(300,300);
        frame.setVisible(true);
    }

}
