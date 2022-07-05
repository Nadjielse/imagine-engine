package ig.scenario.type;

import ig.scenario.Scenario;

import java.awt.Graphics2D;

/**
 * Class to represent a {@code ScenarioType}
 * that has as characteristic not repeat itself
 * to fill the {@code GamePanel}.
 * 
 * @author Daniel O Sousa
 */
public class NoRepeat implements ScenarioType {

    /**
     * Field that stores the name of
     * this {@code ScenarioType}.
     */
    private String name = "NoRepeat";

    /**
     * The {@code Scenario} that has
     * this {@code ScenarioType}.
     */
    private Scenario scenario;

    /**
     * Constructs a new {@code NoRepeat}
     * {@code ScenarioType} that characterizes
     * the {@code Scenario} passed via the
     * {@code scenario} parameter.
     * 
     * @param scenario the scenario that
     * has this type
     */
    public NoRepeat(Scenario scenario) {
        storeScenario(scenario);
    }

    /**
     * Stores the {@code scenario} parameter
     * in the {@code scenario} field.
     * 
     * @param scenario the {@code scenario}
     * to be stored.
     */
    private void storeScenario(Scenario scenario) {
        if(scenario == null) {
            throw new IllegalArgumentException("scenario cannot be null");
        }

        this.scenario = scenario;
    }

    /**
     * Returns the name of this
     * {@code ScenarioType}.
     * 
     * @return the name of this
     * {@code ScenarioType}
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Draws the {@code Scenario} that has this
     * {@code ScenarioType} with its x and y
     * coordinates and width and height dimensions.
     * 
     * @param g2 a {@code Graphics2D} instance used
     * for drawing the said {@code Scenario}
     */
    @Override
    public void draw(Graphics2D g2) {
        g2.drawImage (
            scenario.getCurrentFrame().getImage(),
            scenario.getX(), scenario.getY(),
            scenario.getWidth(), scenario.getHeight(),
            null
        );
    }
    
}