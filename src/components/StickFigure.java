package components;

import data.Level;
import menus.Game;
import menus.GameLevelConstants;
import menus.GameWindowConstants;

import java.awt.*;
import java.awt.image.BufferedImage;

import static menus.GameWindowConstants.WINDOW_HEIGHT;
import static menus.GameWindowConstants.WINDOW_WIDTH;
import static menus.PhysicsConstants.G;
import static menus.PhysicsConstants.GRAPPLE_VELOCITY;

/**
 * The StickFigure class is a PhysicsComponent: this is the stick
 * figure that moves around levels. A StickFigure can move by changing
 * its horizontal velocity and jump by changing its vertical velocity.
 *
 * StickFigures can create Ropes for swinging and grappling, and use
 * special code for handling physics.
 *
 */
public class StickFigure extends PhysicsComponent
{

    /**
     * Image of the stick object
     */
    private BufferedImage stickImage;

    /**
     * Rope object in use
     */
    private Rope rope;

    /**
     * Map of all game components in use
     *
     */
    private Level map;

    /**
     * Flag to if stick figure is moving forward, idle
     * or in jump mode.
     *
     */
    private boolean leftToRight, moving, jumping;

    /**
     * Kinetic, potential of stick figure
     *
     */
    private double kinetic, potential;


    /**
     * Constructor to initialize stick figure with GUI panel,
     * image and register with game components.
     *
     * @param panel - GUI panel
     * @param i - Image of stick figure
     * @param m - Map of game components
     *
     */
    public StickFigure(Game panel, Image i, Level m)
    {
        super(m.getStartX(), m.getStartY(), panel, i);

        map = m;

    }


    /**
     * Method to get the top edge of the touching
     * game component
     *
     * @return - top edge
     */
    public int platformTopPos()
    {
        for (GameComponent g : map)
        {
            if (isTouching(g))
            {
                return g.getTopEdge();
            }
        }

        return Integer.MAX_VALUE;
    }

    /**
     * Method to indicate if stick figure is standing on platform
     *
     * @return - true if stick figure is standing on platform
     *      - false if stick figure is not standing on platform
     *
     */
    public boolean isStandingOnPlatform()
    {
        for (GameComponent g : map) {
            if (isTouching(g) && getBottomEdge() < g.getBottomEdge()) {
                return true;
            }
        }

        return false;
    }

    /**
     * Method to know if the stick figure is touching the obstacle
     * or not
     * @return - true if stick figure is touching the obstacle
     *         - false if stick figure is not touching the obstacle
     */
    public boolean isTouchingObstacle() {
        for (GameComponent g : map)
            if (isTouching(g) && g instanceof Obstacle) return true;
        return false;
    }


    /**
     * Method to process the jump of a stick figure
     */
    public void jump() {
        if (isStandingOnPlatform()) {
            yVel = -4.5;
            jumping = true;
        } else {
            rope = null;
        }
    }

    /**
     * Method to move stick figure to the right
     *
     */
    public void moveRight() {
        if (isStandingOnPlatform()) {
            xVel = 1;
            moving = true;
        }
    }

    /**
     * Method to move stick figure to the left
     */
    public void moveLeft() {
        if (isStandingOnPlatform()) {
            xVel = -1;
            moving = true;
        }
    }

    /**
     * Method to get the kinetic of stick figure
     *
     * @return - kinetic
     *
     */
    public double getKinetic() {
        return kinetic;
    }

    /**
     * Method to swing the stick figure
     *
     * @param x - x coordinate
     * @param y - y coordinate
     *
     */
    public void swing(int x, int y) {
        rope = new Rope(x, y, true, this);
        leftToRight = rope.angleToVertical() > 0;
        double vel = getAbsoluteVel();
        kinetic = 0.5 * vel * vel;

        double height = Math.abs(rope.yPos + rope.length() - yPos);
        potential = height * G;
        moving = false;
    }

    /**
     * Method to grapple with stick figure
     *
     * @param x - x coordinate
     * @param y - y coordinate
     *
     */
    public void grapple(int x, int y) {
        rope = new Rope(x, y, false, this);
        moving = false;
    }

    /**
     * Method to stop the moving stick figure
     *
     */
    public void stopMoving() {
        if (isStandingOnPlatform()) {
            xVel = 0;
            moving = false;
        }
    }

    public boolean win() {
        return this.xPos >= GameWindowConstants.WINDOW_WIDTH;
    }

    /**
     * Method to draw the stick figure component
     *
     * @param g - graphics object
     *
     */
    @Override
    public void draw(Graphics2D g) {
        updatePos();
        if (rope != null) {
            rope.draw(g);
        }
        super.draw(g);
    }

    /**
     * Method to check and update the stick figure to its starting
     * position
     *
     */
    @Override
    public void update() {
        if (win()) {
            parent.loadNextLevel();
            return;
        }
        if (isTouchingObstacle()) {
            restart();
            return;
        }
        boolean standing = isStandingOnPlatform();

        //TODO if fall out of map or dead -> restart
        if (getLeftEdge() > WINDOW_WIDTH || getRightEdge() < 0 || getTopEdge() > WINDOW_HEIGHT) {
            restart();
        }
        //TODO is standing
        if (standing) {
            if (jumping) jumping = false;
            else yVel = 0;
            if (!moving) xVel = 0;
            yPos = platformTopPos() - height / 2;
        }
        //TODO if rope
        if (rope != null) {
            for (GameComponent g : map)
                if (rope.isTouching(g)) {
                    rope = null;
                    return;
                }
            if (rope.isSwingingRope()) {
                if (standing) {
                    rope = null;
                    return;
                }
                double angle = rope.angleToVertical();
                if (rope.distance() < rope.length()) yVel += G;
                else {
                    double newVel = updateEnergy();
                    if (newVel <= 0) {
                        rope = null;
                    }
                    else {
                        if (!leftToRight)
                            newVel = -newVel;
                        xVel = newVel * Math.cos(angle);
                        yVel = newVel * Math.sin(angle);
                    }
                }
            } else if (rope.isGrapplingRope()) {
                if (rope.distance() < 5.0) rope = null;
                else {
                    double angle = rope.angleFromOwner();

                    xVel = GRAPPLE_VELOCITY * Math.cos(angle);
                    yVel = GRAPPLE_VELOCITY * Math.sin(angle);
                }
            }
        }
        else if (!standing) yVel += G;
    }

    /**
     * Method to update the energy of stick figure
     *
     * @return - energy
     */
    private double updateEnergy() { // return vel
        double height = Math.abs(rope.yPos + rope.length() - yPos);
        double newPotential = height * G;
        double newKinetic = potential + kinetic - newPotential;
        newKinetic *= 0.999;
        if (newKinetic < 0) newKinetic = 0;
        double newVel = Math.sqrt(newKinetic * 2);
        potential = newPotential;
        kinetic = newKinetic;
        return newVel;
    }

    /**
     * Method to move stick figure to starting position
     */
    public void restart() {
        xPos = GameLevelConstants.LEVEL_STARAT_X_COORD;
        yPos = GameLevelConstants.LEVEL_STARAT_Y_COORD;
        yVel = G;
        xVel = 0;
        rope = null;
    }

    public void updateMap(Level newMap) {
        map = newMap;
    }
}