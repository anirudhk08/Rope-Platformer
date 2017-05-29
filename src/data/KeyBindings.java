package data;

import components.StickFigure;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.HashMap;

/**
 * The KeyBindings class is a HashMap<Integer, PlayerAction> that specifically maps
 * KeyEvent and MouseEvent constants (for example, KeyEvent.VK_A) to PlayerAction enums
 * that specify actions. When this class is instantiated, it can read predefined keyboard
 * settings from a file or directly set them in the constructor. The Player can register
 * actions with the input() method, which will query the PlayerAction based on the input and
 * return a lambda that contains the matching method in StickFigure.
 */
public class KeyBindings extends HashMap<Integer, PlayerActions> {

    /**
     * KeyBindings is a HashMap<Integer, Player> to map
     * keyboard or mouse inputs to StickFigure movements.
     */
    private HashMap<PlayerActions, Integer> reverseMap;

    /**
     * This is the constructor to initizlize key bindings
     */
    public KeyBindings() {
        reverseMap = new HashMap<>();
        put(KeyEvent.VK_A, PlayerActions.MOVE_LEFT);
        put(KeyEvent.VK_D, PlayerActions.MOVE_RIGHT);
        put(KeyEvent.VK_SPACE, PlayerActions.JUMP);
        put(KeyEvent.VK_ESCAPE, PlayerActions.EXIT);
        put(MouseEvent.BUTTON1, PlayerActions.SWING);
        put(MouseEvent.BUTTON3, PlayerActions.GRAPPLE);
    }

    /**
     * This method maps an integer to player
     * @param i - key
     * @param p - player (value)
     * @return - map associated with the player actions
     */
    @Override
    public PlayerActions put(Integer i, PlayerActions p) {
        PlayerActions swap = null;
        if (reverseMap.containsKey(p)) {
            int oldKeyCode = reverseMap.get(p);
            remove(oldKeyCode);
        }
        if (containsKey(i)) {
            PlayerActions action = get(i);
            swap = action;
            reverseMap.remove(action);
        }
        super.put(i, p);
        reverseMap.put(p, i);
        return swap;
    }

    /**
     * This method removes the player from
     * the map if present.
     * @param key - player to be removed
     * @return - Hashmap of the player actions
     */
    @Override
    public PlayerActions remove(Object key) {
        if (key instanceof PlayerActions) {
            PlayerActions p = (PlayerActions) key;
            if (!containsKey(p)) return null;
            int keycode = reverseMap.get(p);
            super.remove(keycode);
            reverseMap.remove(p);
            return p;
        } else if (key instanceof Integer) {
            int keycode = (Integer) key;
            if (!reverseMap.containsKey(keycode)) return null;
            PlayerActions p = get(keycode);
            super.remove(keycode);
            reverseMap.remove(p);
            return p;
        } else return null;
    }

    /**
     * This method receives the keyboard events
     * and performs the corresponding action on the
     * stick figure.
     * @param k - key board event
     * @param s - stick figure instance
     * @return - action to be performed on the StickFigure
     */
    public StickFigureAction input(KeyEvent k, StickFigure s) {
        PlayerActions action = get(k.getKeyCode());
        if (action == null) return this::doNothing;
        switch (action) {
            case JUMP:
                return s::jump;
            case MOVE_LEFT:
                return s::moveLeft;
            case MOVE_RIGHT:
                return s::moveRight;
            default: return this::doNothing;

        }


    }

    /**
     * This method captures the mouse events, coordinates, and
     * returns the action to be performed on Stick Figure.
     * @param m - the input mouse event
     * @param s - stick figure instance
     * @return - action to be performed on stick figure
     */
    public StickFigureActionCoordinates click(MouseEvent m, StickFigure s) {
        PlayerActions action = get(m.getButton());
        if (action == null) return this::doNothing;
        switch (action) {
            case SWING:
                return (double x, double y) -> s.swing((int)x, (int)y);
            case GRAPPLE:
                return (double x, double y) -> s.grapple((int)x, (int)y);
            default:
                return this::doNothing;
        }
    }

    /**
     * This method determines if Stick Figure can
     * be stopped from moving.
     * @param e - input keyboard event
     * @param s - stick figure
     * @return - specifies nothing or stop
     * moving action to be performed on stick figure
     */
    public StickFigureAction release(KeyEvent e, StickFigure s) {
        PlayerActions action = get(e.getKeyCode());
        if (action == null) return this::doNothing;
        switch (action) {
            case MOVE_LEFT:
                return s::stopMoving;
            case MOVE_RIGHT:
                return s::stopMoving;
            default:
                return this::doNothing;
        }
    }

    /**
     * This method specifies that no action
     * should be performed on stick figure.
     */
    private void doNothing()
    {
    }

    /**
     * This method specifies that no action
     * should be performed on stick figure
     *
     * @param n - x coordinate
     * @param m - y coordinate
     */
    private void doNothing(double n, double m)
    {

    }
}
