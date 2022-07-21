package imagine.scenario.type;

import java.awt.Graphics2D;

/**
 * Interface that every scenario
 * type implements.
 * 
 * @author Daniel O Sousa
 */
public interface ScenarioType {

    /**
     * Method to get the name
     * of the {@code ScenarioType}.
     * 
     * @return the name of the
     * {@code ScenarioType}
     */
    String getName();

    /**
     * Method to determine how a
     * {@code ScenarioType} should be
     * drawn.
     * 
     * @param g2 a {@code Graphics2D}
     * instance used in the drawing
     */
    void draw(Graphics2D g2);

}