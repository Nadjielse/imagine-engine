package ig.camera.type;

import java.awt.Graphics2D;

import ig.camera.CameraGrid;

/**
 * Interface extended by all
 * {@code CameraType}s.
 * 
 * @author Daniel O Sousa
 */
public interface CameraType {

    /**
     * Method for setting the grid
     * of the {@code Camera} that has
     * this {@code CameraType}.
     * 
     * @param grid the grid to be set
     */
    void setGrid(CameraGrid grid);
    
    /**
     * Method for defining how
     * a {@code Camera} that has
     * this {@code CameraType}
     * should update.
     */
    void update();

    /**
     * Method for defining how
     * a {@code Camera} that has
     * this {@code CameraType}
     * should draw its grid.
     * 
     * @param g2 {@code Graphics2D}
     * instance to draw with
     */
    void draw(Graphics2D g2);

}