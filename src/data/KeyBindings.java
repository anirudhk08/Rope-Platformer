package data;

import components.StickFigure;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.HashMap;

/**
 * Created by axu047 on 5/23/2017.
 */
public class KeyBindings extends HashMap<Integer, PlayerActions> {

    public KeyBindings() {
        put(KeyEvent.VK_A, PlayerActions.MOVE_LEFT);
        put(KeyEvent.VK_D, PlayerActions.MOVE_RIGHT);
        put(KeyEvent.VK_SPACE, PlayerActions.JUMP);
        put(MouseEvent.BUTTON1, PlayerActions.SWING);
        put(MouseEvent.BUTTON3, PlayerActions.GRAPPLE);
    }

    public StickFigureAction input(InputEvent e, StickFigure s) {
        if (e instanceof KeyEvent) {
            KeyEvent k = (KeyEvent) e;
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
        return null;
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

    private void doNothing() {}
}
