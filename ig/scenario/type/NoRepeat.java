package ig.scenario.type;

import ig.scenario.Scenario;

import java.awt.Graphics2D;

public class NoRepeat implements ScenarioType {

    private String name = "NoRepeat";
    private Scenario scenario;

    public NoRepeat(Scenario scenario) {
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
        if(scenario.getCurrentFrame() == null) {
            return;
        }
        if(scenario.getWidth() == 0 || scenario.getHeight() == 0) {
            return;
        }

        g2.drawImage (
            scenario.getCurrentFrame().getImage(),
            scenario.getX(), scenario.getY(),
            scenario.getWidth(), scenario.getHeight(),
            null
        );
    }
    
}