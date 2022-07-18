package ig.camera.type;

import java.awt.Graphics2D;

import ig.camera.Camera;
import ig.camera.CameraGrid;

/**
 * Class that represents an auto
 * scroll camera type. This camera
 * type moves automatically according
 * to its x and y speeds.
 * 
 * @author Daniel O Sousa
 */
public class AutoScroll implements CameraType {

    /**
     * Reference to the {@code Camera}
     * that has this {@code CameraType}.
     */
    private Camera camera;

    /**
     * Creates an {@code AutoScroll}
     * {@code CameraType} that defines
     * the type of the passed
     * {@code camera}.
     * 
     * @param camera the {@code Camera}
     * that has this {@code CameraType}
     */
    public AutoScroll(Camera camera) {
        storeCamera(camera);
    }

    /**
     * Stores the {@code camera} argument in the {@code camera}
     * field. If the argument is {@code null} an exception will
     * be thrown advising that a {@code null} camera shouldn't
     * be stored.
     * 
     * @param camera the {@code Camera} to be stored
     * 
     * @throws IllegalArgumentException if the {@code camera} argument
     * is {@code null}
     */
    private void storeCamera(Camera camera) {
        if(camera == null) {
            throw new IllegalArgumentException("cannot store null camera");
        }

        this.camera = camera;
    }

    /**
     * This method does nothing because
     * {@code AutoScroll} cameras have no
     * {@code CameraGrid} to set.
     * 
     * @param grid a {@code CameraGrid}
     * that would be setted
     */
    @Override
    public void setGrid(CameraGrid grid) {
        
    }

    /**
     * Moves the corresponding
     * {@code Camera} according
     * to its x and y speeds.
     */
    @Override
    public void update() {
        camera.move();
    }

    /**
     * This method would be used to
     * draw the grid of the camera
     * that has this {@code CameraType},
     * but since {@code AutoScroll} cameras
     * don't have grids, this method
     * does nothing.
     * 
     * @param g2 a {@code Graphics2D}
     * that would be used to draw the
     * {@code CameraGrid}
     */
    @Override
    public void draw(Graphics2D g2) {
        
    }
    
}