package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by axu047 on 5/11/2017.
 */
public class Settings extends JFrame implements KeyListener
{
    JLabel label = new JLabel("Right Mouse Button");


    public Settings()
    {
        new JFrame();
        setBounds(100, 100, 450, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel lblWelcomeToSettings = new JLabel("Welcome to Settings");
        lblWelcomeToSettings.setBounds(160, 6, 135, 16);
        getContentPane().add(lblWelcomeToSettings);

        JLabel lblChooseKeyBindings = new JLabel("Choose key bindings");
        lblChooseKeyBindings.setBounds(16, 36, 159, 16);
        getContentPane().add(lblChooseKeyBindings);

        JLabel lblRight = new JLabel("Right");
        lblRight.setBounds(16, 65, 61, 16);
        getContentPane().add(lblRight);

        JLabel lblLeft = new JLabel("Left");
        lblLeft.setBounds(16, 93, 61, 16);
        getContentPane().add(lblLeft);

        JLabel lblJump = new JLabel("Jump");
        lblJump.setBounds(16, 126, 61, 16);
        getContentPane().add(lblJump);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(90, 64, 94, 16);
        textArea.setEditable(false);
        textArea.setText("D");
        textArea.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e)
            {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int i = e.getKeyCode();
                if (i == KeyEvent.VK_BACK_SPACE || i == KeyEvent.VK_DELETE) {
                    textArea.setText("Enter new key...");
                } else if (textArea.getText().equals("Enter new key...")) {
                    textArea.setText((e.getKeyChar()+"").toUpperCase());
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        getContentPane().add(textArea);

        JTextArea textArea_1 = new JTextArea();
        textArea_1.setBounds(89, 93, 95, 16);
        textArea_1.setEditable(false);
        textArea_1.setText("A");
        textArea_1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e)
            {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int i = e.getKeyCode();
                if (i == KeyEvent.VK_BACK_SPACE || i == KeyEvent.VK_DELETE) {
                    textArea_1.setText("Enter new key...");
                } else if (textArea_1.getText().equals("Enter new key...")) {
                    textArea_1.setText((e.getKeyChar()+"").toUpperCase());
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        getContentPane().add(textArea_1);

        JTextArea textArea_4 = new JTextArea();
        textArea_4.setBounds(89, 126, 99, 16);
        textArea_4.setEditable(false);
        textArea_4.setText("SPACE");
        textArea_4.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e)
            {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int i = e.getKeyCode();
                if (i == KeyEvent.VK_BACK_SPACE || i == KeyEvent.VK_DELETE) {
                    textArea_4.setText("Enter new key...");
                } else if (textArea_4.getText().equals("Enter new key...")) {
                    textArea_4.setText((e.getKeyChar()+"").toUpperCase());
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        getContentPane().add(textArea_4);

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(6, 228, 117, 29);
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

        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Left Mouse Button", "Right Mouse Button"}));
        comboBox.setBounds(90, 167, 179, 27);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String name = (String) comboBox.getSelectedItem();
                if ( name.equals("Left Mouse Button") )
                {
                    label.setText("Right Mouse Button");
                }
                else
                {
                   label.setText("Left Mouse Button");
                }
            }
        });
        getContentPane().add(comboBox);

        JLabel lblSwingRope = new JLabel("Swing Rope ");
        lblSwingRope.setBounds(16, 171, 85, 16);
        getContentPane().add(lblSwingRope);

        JLabel lblGrappleHook = new JLabel("Grapple Hook");
        lblGrappleHook.setBounds(16, 200, 94, 16);
        getContentPane().add(lblGrappleHook);

        label.setBounds(126, 200, 198, 16);
        getContentPane().add(label);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
