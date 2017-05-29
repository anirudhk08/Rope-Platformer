
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
 * The Player class controls a StickFigure (and thus it uses a reference
 * to one). More specifically, it is a KeyListener and MouseListener that
 * uses such input methods to control the StickFigure. These actions will
 * be registered in KeyBinding’s input() method, which will return a lambda
 * that is a method of StickFigure; this method will then be invoked.
 *
 */
public class Player implements KeyListener, MouseListener
{
    /**
     * Stick figure object
     */
    private StickFigure s;

    /**
     * Key settings
     */
    private KeyBindings settings;

    /**
     * GUI panel
     */
    private Game parent;

    /**
     * Constructor to initialize the Player instance with stick figure,
     * key settings and GUI panel
     *
     * @param stickFigure
     * @param keys
     * @param g
     */
    public Player(StickFigure stickFigure, KeyBindings keys, Game g)
    {
        s = stickFigure;
        settings = keys;
        parent = g;
    }

    /**
     * Method to process the Key typed event
     * @param e - key event
     */
    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    /**
     * Method to process the Key pressed event
     * @param e - key event
     */
    @Override
    public void keyPressed(KeyEvent e)
    {
        if (settings.get(e.getKeyCode()) == PlayerActions.EXIT)
        {
            parent.exit();
            return;
        }

        StickFigureAction action = settings.input(e, s);
        action.action();
    }

    /** Method to process the Key released event
     *
     * @param e - key event
     */
    @Override
    public void keyReleased(KeyEvent e)
    {
        StickFigureAction action = settings.release(e, s);
        action.action();
    }

    /**
     *  Method to process the mouse clicked event
     *
     * @param e - key event
     */
    @Override
    public void mouseClicked(MouseEvent e)
    {

    }

    /**
     * Method to process the mouse pressed event
     *
     * @param e - mouse event
     */
    @Override
    public void mousePressed(MouseEvent e)
    {
        StickFigureActionCoordinates action = settings.click(e, s);
        action.action(e.getX(), e.getY());
    }

    /**
     * Method to process the mouse released event
     *
     * @param e - mouse event
     */
    @Override
    public void mouseReleased(MouseEvent e)
    {

    }

    /**
     * Method to process mouse entered event
     *
     * @param e - mouse event
     */
    @Override
    public void mouseEntered(MouseEvent e)
    {
        parent.requestFocus();
    }

    @Override
    public void mouseExited(MouseEvent e)
    {

    }
}
