package data;

/**
 * Interface for stick figure action coordinates.
 *
 * @author Adam Xu
 */
@FunctionalInterface
public interface StickFigureActionCoordinates {
    /**
     * Interface method specifies the action needed
     * to be performed at the given coordinates
     * @param x - x coordinate
     * @param y - y coordinate
     */
    void action(double x, double y);
}