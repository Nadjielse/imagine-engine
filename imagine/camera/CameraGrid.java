package imagine.camera;

import java.awt.Graphics2D;
import java.awt.Color;

import imagine.game.GameElement;

/**
 * Class to represent camera grids used to
 * follow camera targets.
 * 
 * @author Daniel O Sousa
 */
public class CameraGrid extends GameElement {

    /**
     * The {@code Camera} that
     * has this {@code CameraGrid}.
     */
    private Camera camera;

    /**
     * Constructs a new {@code CameraGrid} for the passed {@code camera}
     * (that must not be {@code null}) at the specified {@code x} and
     * {@code y} coordinates and with the passed {@code width}
     * and {@code height}. The width and height dimensions must not be
     * negative.
     * 
     * @param camera the camera that has this {@code CameraGrid}
     * @param x the x coordinate
     * @param y the y coordinate
     * @param width the width dimension
     * @param height the height dimension
     * 
     * @throws IllegalArgumentException if the {@code camera} is {@code null}
     * or the {@code width} or {@code height} is negative
     */
    public CameraGrid(Camera camera, int x, int y, int width, int height) {
        storeCamera(camera);
        setCoordinates(x, y);
        setSize(width, height);
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
     * Draws this {@code CameraGrid} using the
     * {@code g2} and the {@code color} arguments.
     * 
     * @param g2 a {@code Graphics2D} instance to
     * draw with
     * @param color the color with which to draw
     */
    public void draw(Graphics2D g2, Color color) {
        if(color == null) {
            g2.setColor(Color.WHITE);
        } else {
            g2.setColor(color);
        }

        g2.drawLine (
            0,
            getTop(),
            camera.getWidth(),
            getTop()
        );
        g2.drawLine (
            0,
            getBottom(),
            camera.getWidth(),
            getBottom()
        );
        g2.drawLine (
            getLeft(),
            0,
            getLeft(),
            camera.getHeight()
        );
        g2.drawLine (
            getRight(),
            0,
            getRight(),
            camera.getHeight()
        );
    }

}