package ig.flow;

import java.awt.Graphics2D;

/**
 * Interface to represent classes
 * that are iterated by a {@code GameFlow}.
 * 
 * @author Daniel O Sousa
 */
public interface GameFluid {

    /**
     * Method used to start
     * the class that implements
     * this interface.
     */
    public void start();

    /**
     * Method used to update
     * the class that implements
     * this interface.
     */
    public void update();

    /**
     * Method used to draw the
     * class that implements
     * this interface.
     * 
     * @param g2 a {@code Graphics2D} instance
     *           to draw with
     */
    public void draw(Graphics2D g2);

}