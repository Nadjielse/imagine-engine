package ig.scenario.type;

import ig.scenario.Scenario;

import java.awt.Graphics2D;

/**
 * Class to represent a {@code ScenarioType}
 * that has as characteristic repeat itself
 * on the x and y axis to fill the {@code GamePanel}.
 * 
 * @author Daniel O Sousa
 */
public class RepeatXY implements ScenarioType {

    /**
     * Field that stores the name of
     * this {@code ScenarioType}.
     */
    private String name = "RepeatXY";

    /**
     * The {@code Scenario} that has
     * this {@code ScenarioType}.
     */
    private Scenario scenario;

    /**
     * Constructs a new {@code RepeatXY}
     * {@code ScenarioType} that characterizes
     * the {@code Scenario} passed via the
     * {@code scenario} parameter.
     * 
     * @param scenario the scenario that
     * has this type
     */
    public RepeatXY(Scenario scenario) {
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
     * {@code ScenarioType} in a way that it repeats
     * itself to fill the {@code GamePanel} on the
     * x and y axis.
     * 
     * @param g2 a {@code Graphics2D} instance used
     * for drawing the said {@code Scenario}
     */
    @Override
    public void draw(Graphics2D g2) {
        if(scenario.getGamePanelWidth() == 0 || scenario.getGamePanelHeight() == 0) {
            return;
        }

        int drawingY =
            scenario.getApparentY() <= 0 ?
            scenario.getApparentY() % scenario.getHeight() :
            scenario.getApparentY() % scenario.getHeight() - scenario.getHeight();
        while(drawingY < scenario.getGamePanelHeight()) {
            int drawingX =
                scenario.getApparentX() <= 0 ?
                scenario.getApparentX() % scenario.getWidth() :
                scenario.getApparentX() % scenario.getWidth() - scenario.getWidth();
            while(drawingX < scenario.getGamePanelWidth()) {
                g2.drawImage (
                    scenario.getCurrentFrame().getImage(),
                    drawingX, drawingY,
                    scenario.getWidth(), scenario.getHeight(),
                    null
                );
                drawingX += scenario.getWidth();
            }
            drawingY += scenario.getHeight();
        }
    }
    
}