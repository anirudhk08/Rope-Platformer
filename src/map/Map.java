package map;

import components.Platform;

import java.util.LinkedList;

/**
 * Created by axu047 on 5/5/2017.
 */
public class Map {
    private LinkedList<Platform> platforms;
    private int startX, startY, endX, endY;
    //TODO preview image

    public Map() {
        platforms = new LinkedList<>();
    }
}
