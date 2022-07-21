package imagine.camera.type;

import java.awt.Graphics2D;

import imagine.camera.CameraGrid;

/**
 * Class that represents a static
 * camera type. This camera type
 * doesn't move automatically.
 * 
 * @author Daniel O Sousa
 */
public class Static implements CameraType {

    /**
     * This method does nothing because
     * {@code Static} cameras have no
     * {@code CameraGrid} to set.
     * 
     * @param grid a {@code CameraGrid}
     * that would be setted
     */
    @Override
    public void setGrid(CameraGrid grid) {
        
    }

    /**
     * Once a {@code Static} camera
     * updates nothing happens because
     * {@code Static} cameras aren't
     * meant to move, so this method
     * doesn't do anything.
     */
    @Override
    public void update() {
        
    }

    /**
     * This method would be used to
     * draw the grid of the camera
     * that has this {@code CameraType},
     * but since {@code Static} cameras
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