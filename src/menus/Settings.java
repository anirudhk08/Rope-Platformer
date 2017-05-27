package menus;

import data.KeyBindings;
import data.PlayerActions;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static menus.GameWindowConstants.*;

/**
 * Created by axu047 on 5/11/2017.
 */
public class Settings extends JPanel
{
    JLabel label = new JLabel("Right Mouse Button");
    KeyBindings settings;


    public Settings(Window parent, KeyBindings k)
    {
        settings = k;

        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLayout(null);

        JLabel lblWelcomeToSettings = new JLabel("Welcome to Settings");
        lblWelcomeToSettings.setBounds(150, 6, 135, 16);
        add(lblWelcomeToSettings);

        JLabel lblChooseKeyBindings = new JLabel("Choose key bindings (press backspace to change)");
        lblChooseKeyBindings.setBounds(16, 36, 310, 16);
        add(lblChooseKeyBindings);

        JLabel lblRight = new JLabel("Right");
        lblRight.setBounds(16, 65, 61, 16);
        add(lblRight);

        JLabel lblLeft = new JLabel("Left");
        lblLeft.setBounds(16, 93, 61, 16);
        add(lblLeft);

        JLabel lblJump = new JLabel("Jump");
        lblJump.setBounds(16, 126, 61, 16);
        add(lblJump);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(90, 64, 94, 16);
        textArea.setText("D");
        textArea.setEditable(false);
        textArea.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textArea.selectAll();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        add(textArea);

        JTextArea textArea_1 = new JTextArea();
        textArea_1.setBounds(89, 93, 95, 16);
        textArea_1.setEditable(false);
        textArea_1.setText("A");
        textArea_1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textArea_1.selectAll();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        add(textArea_1);

        JTextArea textArea_4 = new JTextArea();
        textArea_4.setBounds(89, 126, 99, 16);
        textArea_4.setEditable(false);
        textArea_4.setText("SPACE");
        textArea_4.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textArea_4.selectAll();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        add(textArea_4);

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(6, 228, 117, 29);
        btnBack.addActionListener(e -> parent.goToMainMenu());
        add(btnBack);

        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Left Mouse Button", "Right Mouse Button"}));
        comboBox.setBounds(90, 167, 200, 27);
        comboBox.addActionListener(e -> {
            String name = (String) comboBox.getSelectedItem();
            if ( name.equals("Left Mouse Button") )
            {
                settings.put(MouseEvent.BUTTON1, PlayerActions.SWING);
                settings.put(MouseEvent.BUTTON3, PlayerActions.GRAPPLE);
                label.setText("Right Mouse Button");
            }
            else
            {
                settings.put(MouseEvent.BUTTON1, PlayerActions.GRAPPLE);
                settings.put(MouseEvent.BUTTON3, PlayerActions.SWING);
               label.setText("Left Mouse Button");
            }
        });
        comboBox.setVisible(true);
        add(comboBox);

        // RIGHT
        textArea.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e)
            {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int i = e.getKeyCode();
                if (i == KeyEvent.VK_BACK_SPACE || i == KeyEvent.VK_DELETE) {
                    settings.remove(PlayerActions.MOVE_RIGHT);
                    textArea.setText("Enter new key...");
                } else if (textArea.getText().equals("Enter new key...")) {
                    PlayerActions p = settings.put(e.getKeyCode(), PlayerActions.MOVE_RIGHT);
                    if (p != null) {
                        switch (p) {
                            case MOVE_LEFT:
                                textArea_1.setText("Enter new key...");
                                break;
                            case JUMP:
                                textArea_4.setText("Enter new key...");
                                break;
                        }
                    }
                    textArea.setText(convertKeyCode(e));
                }
                textArea.selectAll();
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        // LEFT
        textArea_1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e)
            {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int i = e.getKeyCode();
                if (i == KeyEvent.VK_BACK_SPACE || i == KeyEvent.VK_DELETE) {
                    settings.remove(PlayerActions.MOVE_LEFT);
                    textArea_1.setText("Enter new key...");
                } else if (textArea_1.getText().equals("Enter new key...")) {
                    PlayerActions p = settings.put(e.getKeyCode(), PlayerActions.MOVE_LEFT);
                    if (p != null) {
                        switch (p) {
                            case MOVE_RIGHT:
                                textArea.setText("Enter new key...");
                                break;
                            case JUMP:
                                textArea_4.setText("Enter new key...");
                                break;
                        }
                    }
                    textArea_1.setText(convertKeyCode(e));
                }
                textArea_1.selectAll();
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        // JUMP
        textArea_4.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e)
            {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int i = e.getKeyCode();
                if (i == KeyEvent.VK_BACK_SPACE || i == KeyEvent.VK_DELETE) {
                    settings.remove(PlayerActions.JUMP);
                    textArea_4.setText("Enter new key...");
                } else if (textArea_4.getText().equals("Enter new key...")) {
                    PlayerActions p = settings.put(e.getKeyCode(), PlayerActions.JUMP);
                    if (p != null) {
                        switch (p) {
                            case MOVE_RIGHT:
                                textArea.setText("Enter new key...");
                                break;
                            case MOVE_LEFT:
                                textArea_1.setText("Enter new key...");
                                break;
                        }
                    }
                    textArea_4.setText(convertKeyCode(e));
                }
                textArea_4.selectAll();
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        JLabel lblSwingRope = new JLabel("Swing Rope ");
        lblSwingRope.setBounds(16, 171, 85, 16);
        add(lblSwingRope);

        JLabel lblGrappleHook = new JLabel("Grapple Hook");
        lblGrappleHook.setBounds(16, 200, 94, 16);
        add(lblGrappleHook);

        label.setBounds(126, 200, 198, 16);
        add(label);

    }

    private String convertKeyCode(KeyEvent e) {
        if (e.getKeyCode() == 3) return "CANCEL";
        else if (e.getKeyCode() == 8) return "BACKSPACE";
        else if (e.getKeyCode() == 9) return "TAB";
        else if (e.getKeyCode() == 10) return "ENTER";
        else if (e.getKeyCode() == 12) return "CLEAR";
        else if (e.getKeyCode() == 16) return "SHIFT";
        else if (e.getKeyCode() == 17) return "CTRL";
        else if (e.getKeyCode() == 18) return "ALT";
        else if (e.getKeyCode() == 19) return "PAUSE";
        else if (e.getKeyCode() == 20) return "CAPS LOCK";
        else if (e.getKeyCode() == 21) return "KANA";
        else if (e.getKeyCode() == 24) return "FINAL";
        else if (e.getKeyCode() == 27) return "ESCAPE";
        else if (e.getKeyCode() == 28) return "CONVERT";
        else if (e.getKeyCode() == 29) return "NO CONVERT";
        else if (e.getKeyCode() == 30) return "ACCEPT";
        else if (e.getKeyCode() == 31) return "MODE CHANGE";
        else if (e.getKeyCode() == 32) return "SPACE";
        else if (e.getKeyCode() == 33) return "PAGE UP";
        else if (e.getKeyCode() == 34) return "PAGE DOWN";
        else if (e.getKeyCode() == 35) return "END";
        else if (e.getKeyCode() == 36) return "HOME";
        else if (e.getKeyCode() == 37) return "LEFT";
        else if (e.getKeyCode() == 38) return "UP";
        else if (e.getKeyCode() == 39) return "RIGHT";
        else if (e.getKeyCode() == 40) return "DOWN";
        else if (e.getKeyCode() == 96) return "NUMPAD 0";
        else if (e.getKeyCode() == 97) return "NUMPAD 1";
        else if (e.getKeyCode() == 98) return "NUMPAD 2";
        else if (e.getKeyCode() == 99) return "NUMPAD 3";
        else if (e.getKeyCode() == 100) return "NUMPAD 4";
        else if (e.getKeyCode() == 101) return "NUMPAD 5";
        else if (e.getKeyCode() == 102) return "NUMPAD 6";
        else if (e.getKeyCode() == 103) return "NUMPAD 7";
        else if (e.getKeyCode() == 104) return "NUMPAD 8";
        else if (e.getKeyCode() == 105) return "NUMPAD 9";
        else if (e.getKeyCode() == 106) return "NUMPAD *";
        else if (e.getKeyCode() == 107) return "NUMPAD +";
        else if (e.getKeyCode() == 108) return "NUMPAD ,";
        else if (e.getKeyCode() == 109) return "NUMPAD -";
        else if (e.getKeyCode() == 110) return "NUMPAD .";
        else if (e.getKeyCode() == 111) return "NUMPAD /";
        else if (e.getKeyCode() == 112) return "F1";
        else if (e.getKeyCode() == 113) return "F2";
        else if (e.getKeyCode() == 114) return "F3";
        else if (e.getKeyCode() == 115) return "F4";
        else if (e.getKeyCode() == 116) return "F5";
        else if (e.getKeyCode() == 117) return "F6";
        else if (e.getKeyCode() == 118) return "F7";
        else if (e.getKeyCode() == 119) return "F8";
        else if (e.getKeyCode() == 120) return "F9";
        else if (e.getKeyCode() == 121) return "F10";
        else if (e.getKeyCode() == 122) return "F11";
        else if (e.getKeyCode() == 123) return "F12";
        else if (e.getKeyCode() == 127) return "DELETE";
        else if (e.getKeyCode() == 144) return "NUM LOCK";
        else if (e.getKeyCode() == 145) return "SCROLL LOCK";
        else if (e.getKeyCode() == 154) return "PRINT SCREEN";
        else if (e.getKeyCode() == 155) return "INSERT";
        else if (e.getKeyCode() == 156) return "HELP";
        else if (e.getKeyCode() == 157) return "META";
        else if (e.getKeyCode() == 524) return "WINDOWS";
        else if (e.getKeyCode() == 525) return "CONTEXT MENU";

        return (e.getKeyChar()+"").toUpperCase();
    }
}
