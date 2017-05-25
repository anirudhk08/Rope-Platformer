package components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.*;



/**
 * Created by Anirudh on 5/23/17.
 */
public class Animations extends JPanel implements ActionListener, KeyListener {

    Timer t = new Timer(1, this);
    double x = 0, y = 0, velX = 0, velY = 0;

    public Animations()
    {
        t.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public void painComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.fill(new Ellipse2D.Double(x, y, 40, 40));
    }

    public void actionPerformed(ActionEvent e)
    {
        x += velX;
        y += velY;
        repaint();
    }

    public void up()
    {
        velY = -1.5;
        velX = 0;
    }

    public void down()
    {
        velY = 1.5;
        velX = 0;
    }

    public void left()
    {
        velX = -1.5;
        velY = 0;
    }

    public void right()
    {
        velX = 1.5;
        velY = 0;
    }

    public void keyPressed(KeyEvent e)
    {
        int code = e.getKeyCode();
        if ( code == KeyEvent.VK_UP )
        {
            up();
        }
        if ( code == KeyEvent.VK_DOWN )
        {
            down();
        }
        if ( code == KeyEvent.VK_RIGHT )
        {
            right();
        }
        if ( code == KeyEvent.VK_LEFT )
        {
            left();
        }

    }

    public void keyTyped(KeyEvent e){}
    public void keyReleased(KeyEvent e) {}




}


