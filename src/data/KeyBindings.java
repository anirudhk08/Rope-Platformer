package data;

import components.StickFigure;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.HashMap;

/**
 * Created by axu047 on 5/23/2017.
 */
public class KeyBindings extends HashMap<Integer, PlayerActions> {

    private HashMap<PlayerActions, Integer> reverseMap;

    public KeyBindings() {
        reverseMap = new HashMap<>();
        put(KeyEvent.VK_A, PlayerActions.MOVE_LEFT);
        put(KeyEvent.VK_D, PlayerActions.MOVE_RIGHT);
        put(KeyEvent.VK_SPACE, PlayerActions.JUMP);
        put(KeyEvent.VK_ESCAPE, PlayerActions.PAUSE_GAME);
        put(MouseEvent.BUTTON1, PlayerActions.SWING);
        put(MouseEvent.BUTTON3, PlayerActions.GRAPPLE);
    }

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

    public StickFigureAction input(KeyEvent k, StickFigure s) {

        PlayerActions action = get(k.getKeyCode());
        switch (action) {
            case JUMP:
                return s::jump;
            case MOVE_LEFT:
                return s::moveLeft;
            case MOVE_RIGHT:
                return s::moveRight;
            default:
                return this::doNothing;
        }


    }

    public StickFigureActionCoordinates click(MouseEvent m, StickFigure s) {
        PlayerActions action = get(m.getButton());
        switch (action) {
            case SWING:
                return s::swing;
            case GRAPPLE:
                return s::grapple;
            default:
                return this::doNothing;
        }
    }

    public StickFigureAction release(KeyEvent e, StickFigure s) {
        PlayerActions action = get(e.getKeyCode());
        switch (action) {
            case MOVE_LEFT:
                return s::stopMoving;
            case MOVE_RIGHT:
                return s::stopMoving;
            default:
                return this::doNothing;
        }
    }

    private void doNothing() {
    }
    private void doNothing(double n, double m) {}
}
