
package master;

import components.StickFigure;
import data.KeyBindings;
import data.StickFigureAction;
import data.StickFigureActionCoordinates;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by axu047 on 5/5/2017.
 */
public class Player implements KeyListener, MouseListener {
    private StickFigure s;
    private KeyBindings settings;

    public Player(StickFigure stickFigure, KeyBindings keys) {
        s = stickFigure;
        settings = keys;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        StickFigureAction action = settings.input(e, s);
        action.action();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        StickFigureAction action = settings.release(e, s);
        action.action();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        StickFigureActionCoordinates action = settings.click(e, s);
        action.action(e.getX(), e.getY());
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
