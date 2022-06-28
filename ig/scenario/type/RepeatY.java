package ig.scenario.type;

import ig.scenario.Scenario;

import java.awt.Graphics2D;

public class RepeatY implements ScenarioType {

    private String name = "RepeatY";
    private Scenario scenario;

    public RepeatY(Scenario scenario) {
        storeScenario(scenario);
    }

    private void storeScenario(Scenario scenario) {
        if(scenario == null) {
            throw new IllegalArgumentException("scenario cannot be null");
        }

        this.scenario = scenario;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void draw(Graphics2D g2) {
        if(scenario.getGamePanelWidth() == 0 || scenario.getGamePanelHeight() == 0) {
            return;
        }

        int drawingY =
            scenario.getY() <= 0 ?
            scenario.getY() % scenario.getHeight() :
            scenario.getY() % scenario.getHeight() - scenario.getHeight();
        while(drawingY < scenario.getGamePanelHeight()) {
            g2.drawImage (
                scenario.getCurrentFrame().getImage(),
                scenario.getX(), drawingY,
                scenario.getWidth(), scenario.getHeight(),
                null
            );
            drawingY += scenario.getHeight();
        }
    }
    
}