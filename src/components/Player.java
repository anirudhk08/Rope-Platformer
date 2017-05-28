
package components;

import data.KeyBindings;
import data.PlayerActions;
import data.StickFigureAction;
import data.StickFigureActionCoordinates;
import menus.Game;

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
    private Game parent;

    public Player(StickFigure stickFigure, KeyBindings keys, Game g) {
        s = stickFigure;
        settings = keys;
        parent = g;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (settings.get(e.getKeyCode()) == PlayerActions.EXIT) {
            parent.exit();
            return;
        }
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
        parent.requestFocus();
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
