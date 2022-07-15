package ig.camera.type;

import java.awt.Graphics2D;

import ig.camera.Camera;
import ig.camera.CameraGrid;

public class AutoScroll implements CameraType {

    private Camera camera;

    public AutoScroll(Camera camera) {
        storeCamera(camera);
    }

    private void storeCamera(Camera camera) {
        if(camera == null) {
            throw new IllegalArgumentException("cannot store null camera");
        }

        this.camera = camera;
    }

    @Override
    public void setGrid(CameraGrid grid) {
        
    }

    @Override
    public void update() {
        camera.move();
    }

    @Override
    public void draw(Graphics2D g2) {
        
    }
    
}