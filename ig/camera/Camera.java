package ig.camera;

import java.awt.Graphics2D;

import ig.stage.StageElement;
import ig.stage.Stage;
import ig.flow.GameFluid;
import ig.camera.type.*;

public class Camera extends StageElement implements GameFluid {

    private CameraType type;

    public Camera(Stage stage) {
        storeStage(stage);
        setCoordinates(0, 0);
        setSize (
            getStage().getGamePanelWidth(),
            getStage().getGamePanelHeight()
        );
        setXSpeed(0);
        setYSpeed(0);
        setTypeStatic();
    }

    private void storeStage(Stage stage) {
        if(stage == null) {
            throw new IllegalArgumentException("cannot store null stage");
        }

        setStage(stage);
    }

    public void setType(CameraType type) {
        if(type == null) {
            throw new IllegalArgumentException("cannot set null camera type");
        }

        this.type = type;
    }

    public void setTypeStatic() {
        setType(new Static());
    }

    public void setTypeAutoScroll() {
        setType(new AutoScroll(this));
    }

    public CameraType getType() {
        return this.type;
    }

    @Override
    public void start() {
        
    }

    @Override
    public void update() {
        type.update();
    }

    @Override
    public void draw(Graphics2D g2) {
        type.draw(g2);
    }

}