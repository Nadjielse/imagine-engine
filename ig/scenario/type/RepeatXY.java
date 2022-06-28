package ig.scenario.type;

import ig.scenario.Scenario;

import java.awt.Graphics2D;

public class RepeatXY implements ScenarioType {

    private String name = "RepeatXY";
    private Scenario scenario;

    public RepeatXY(Scenario scenario) {
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
            int drawingX =
                scenario.getX() <= 0 ?
                scenario.getX() % scenario.getWidth() :
                scenario.getX() % scenario.getWidth() - scenario.getWidth();
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