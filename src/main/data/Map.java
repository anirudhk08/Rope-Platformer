package main.data;

import main.components.GameComponent;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by axu047 on 5/5/2017.
 */
public class Map extends ArrayList<GameComponent> {
    private double startX, startY, endX, endY;
    private Image preview;

    public Map() {

    }

    public void draw(Graphics2D g, double updateTimeMillis) {
        for (GameComponent p : this) {
            p.draw(g, updateTimeMillis);
        }
    }

    public double getStartX() { return startX; }
    public double getStartY() { return startY; }

}
