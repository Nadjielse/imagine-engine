package ig.camera.type;

import java.awt.Graphics2D;
import java.awt.Color;

import ig.camera.Camera;
import ig.camera.CameraGrid;
import ig.object.GameObject;

public class Follow implements CameraType {

    private Camera camera;
    private GameObject target;
    private CameraGrid grid;
    private int smoothness = 0;

    public Follow(Camera camera, GameObject target) {
        storeCamera(camera);
        storeTarget(target);
        createGrid();
    }

    public Follow(Camera camera, GameObject target, int smoothness) {
        this(camera, target);
        storeSmoothness(smoothness);
    }

    private void storeCamera(Camera camera) {
        if(camera == null) {
            throw new IllegalArgumentException("cannot store null camera");
        }
        
        this.camera = camera;
    }

    private void storeTarget(GameObject target) {
        if(target == null) {
            throw new IllegalArgumentException("cannot store null target");
        }
        
        this.target = target;
    }

    private void createGrid() {
        this.grid = new CameraGrid (
            camera.getWidth() / 2 - target.getWidth() / 2,
            camera.getHeight() / 2 - target.getHeight() / 2,
            target.getWidth(),
            target.getHeight()
        );
    }

    private void storeSmoothness(int smoothness) {
        if(smoothness < 0) {
            throw new IllegalArgumentException("cannot store negative smoothness");
        }
        
        this.smoothness = smoothness;
    }

    @Override
    public void update() {
        
    }

    @Override
    public void draw(Graphics2D g2) {
        if(!camera.getDrawGrid()) {
            return;
        }

        g2.setColor(Color.BLACK);
        g2.drawLine (
            0,
            grid.getTop(),
            camera.getWidth(),
            grid.getTop()
        );
        g2.drawLine (
            0,
            grid.getBottom(),
            camera.getWidth(),
            grid.getBottom()
        );
        g2.drawLine (
            grid.getLeft(),
            0,
            grid.getLeft(),
            camera.getHeight()
        );
        g2.drawLine (
            grid.getRight(),
            0,
            grid.getRight(),
            camera.getHeight()
        );
    }
    
}