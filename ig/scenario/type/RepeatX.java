package ig.scenario.type;

import ig.scenario.Scenario;

import java.awt.Graphics2D;

public class RepeatX implements ScenarioType {

    private String name = "RepeatX";
    private Scenario scenario;

    public RepeatX(Scenario scenario) {
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

        int drawingX =
            scenario.getX() <= 0 ?
            scenario.getX() % scenario.getWidth() :
            scenario.getX() % scenario.getWidth() - scenario.getWidth();
        while(drawingX < scenario.getGamePanelWidth()) {
            g2.drawImage (
                scenario.getCurrentFrame().getImage(),
                drawingX, scenario.getY(),
                scenario.getWidth(), scenario.getHeight(),
                null
            );
            drawingX += scenario.getWidth();
        }
    }
    
}