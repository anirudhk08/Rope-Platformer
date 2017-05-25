package components;

import javax.swing.*;
import java.awt.*;

/**
 * Created by axu047 on 5/4/2017.
 */
public abstract class GameComponent {
    protected double xPos, yPos; // center
    private JPanel parent;
    private Image image;
    private boolean useImage = false;

    public void draw(Graphics2D g, double updateTimeMillis) {
        if (useImage)
            g.drawImage(image, (int) (xPos - image.getWidth(parent)/2), (int) (yPos - image.getHeight(parent)/2), parent);
    }

    public GameComponent(double x, double y) {
        xPos = x;
        yPos = y;
    }

    public GameComponent(double x, double y, JPanel p, Image i) {
        xPos = x;
        yPos = y;
        parent = p;
        image = i;
        useImage = true;
    }

    public boolean isTouching(GameComponent other) {
        if (other == null) return false;
        return false; //TODO fix
    }

    public boolean hasImage() { return useImage; }

    public GameComponent[] getTouching() {
        return null; // TODO fix
    }
}
