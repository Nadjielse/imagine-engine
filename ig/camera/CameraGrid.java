package ig.camera;

import java.awt.Graphics2D;
import java.awt.Color;

import ig.game.GameElement;

public class CameraGrid extends GameElement {

    private Camera camera;

    public CameraGrid(Camera camera, int x, int y, int width, int height) {
        storeCamera(camera);
        setCoordinates(x, y);
        setSize(width, height);
    }

    private void storeCamera(Camera camera) {
        if(camera == null) {
            throw new IllegalArgumentException("cannot store null camera");
        }
        
        this.camera = camera;
    }

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