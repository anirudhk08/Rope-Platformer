package MainMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Anirudh on 5/4/17.
 */
public class MainMenu extends JFrame implements ActionListener {
    private JMenuItem item1 = new JMenuItem("Open");
    private JMenuItem item2 = new JMenuItem("Cancel");

    public MainMenu()
    {
        JFrame F = new JFrame("ismail");
        JMenuBar menubar = new JMenuBar();
        JMenu menu1 = new JMenu("File");

        item1.addActionListener(this);
        item2.addActionListener(this);

        menu1.add(item1);
        menu1.add(item2);


        menubar.add(menu1);
        F.setJMenuBar(menubar);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
