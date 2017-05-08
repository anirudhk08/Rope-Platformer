package map;

import components.Platform;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by axu047 on 5/5/2017.
 */
public class Map {
    private LinkedList<Platform> platforms;
    private double startX, startY, endX, endY;
    private Image preview;

    public Map() {
        platforms = new LinkedList<>();
    }

    public void draw(Graphics g) {
        for (Platform p : platforms) {
            p.draw(g);
        }
    }

    public double getStartX() { return startX; }
    public double getStartY() { return startY; }

    public void addPlatform(Platform p) {
        platforms.add(p);
    }
}
