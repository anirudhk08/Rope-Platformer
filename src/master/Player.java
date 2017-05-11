package master;

import components.StickFigure;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by axu047 on 5/5/2017.
 */
public class Player implements KeyListener, MouseListener {
    private StickFigure s;

    public Player(StickFigure stickFigure) {
        s = stickFigure;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_D) {
            System.out.println("here");
            s.move();
        } if (e.getKeyCode() == KeyEvent.VK_A) {

        }if (e.getKeyCode() == KeyEvent.VK_W) {
            System.out.println("there");
            s.jump();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

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
}
