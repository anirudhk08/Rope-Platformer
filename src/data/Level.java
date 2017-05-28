package data;

import components.GameComponent;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by axu047 on 5/5/2017.
 */
public class Level extends ArrayList<GameComponent> {
    private int startX, startY, endX, endY;
    private Image preview;

    public Level(int startX, int startY, int endX, int endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    public void draw(Graphics2D g) {
        for (GameComponent p : this) {
            p.draw(g);
        }
    }

    public int getStartX() { return startX; }
    public int getStartY() { return startY; }

    public boolean isCollision(GameComponent other)
    {
        boolean collision = false;

        for (GameComponent gc: this)
        {
            if ( gc.isTouching(other) )
            {
                collision = true;
                break;
            }
        }

        return collision;
    }

}
