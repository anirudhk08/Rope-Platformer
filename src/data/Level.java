package data;

import components.GameComponent;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by axu047 on 5/5/2017.
 */
public class Level extends ArrayList<GameComponent> {
    private double startX, startY, endX, endY;
    private Image preview;

    public Level() {
        super();
    }

    public Level(double startX, double startY, double endX, double endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    public void draw(Graphics2D g, double updateTimeMillis) {
        for (GameComponent p : this) {
            p.draw(g, updateTimeMillis);
        }
    }

    public double getStartX() { return startX; }
    public double getStartY() { return startY; }

}
