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

    public Follow(Camera camera, GameObject target) {
        storeCamera(camera);
        storeTarget(target);
        createGrid();
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
        setGrid (
            new CameraGrid (
                camera,
                camera.getWidth() / 2 - target.getWidth() / 2,
                camera.getHeight() / 2 - target.getHeight() / 2,
                target.getWidth(),
                target.getHeight()
            )
        );
    }

    private int getTargetXOffset() {
        if(target.getRight() - (camera.getX() + grid.getRight()) > 0) {
            return target.getRight() - (camera.getX() + grid.getRight());
        }
        if(target.getLeft() - (camera.getX() + grid.getLeft()) < 0) {
            return target.getLeft() - (camera.getX() + grid.getLeft());
        }

        return 0;
    }

    private int getTargetYOffset() {
        if(target.getBottom() - (camera.getY() + grid.getBottom()) > 0) {
            return target.getBottom() - (camera.getY() + grid.getBottom());
        }
        if(target.getTop() - (camera.getY() + grid.getTop()) < 0) {
            return target.getTop() - (camera.getY() + grid.getTop());
        }

        return 0;
    }

    private void drawGrid(Graphics2D g2) {
        Color color;
        if(getTargetXOffset() != 0 || getTargetYOffset() != 0) {
            color = Color.RED;
        } else {
            color = Color.GREEN;
        }

        grid.draw(g2, color);
    }

    @Override
    public void setGrid(CameraGrid grid) {
        if(grid == null) {
            throw new IllegalArgumentException("cannot set null grid");
        }
        if (
            grid.getX() < 0 || grid.getX() > camera.getWidth() ||
            grid.getY() < 0 || grid.getY() > camera.getHeight()
        ) {
            throw new IllegalArgumentException("cannot set grid outside camera view");
        }
        if (
            grid.getX() + grid.getWidth() > camera.getWidth() ||
            grid.getY() + grid.getHeight() > camera.getHeight()
        ) {
            throw new IllegalArgumentException("cannot set grid outside camera view");
        }

        this.grid = grid;
    }

    @Override
    public void update() {
        camera.setXSpeed(getTargetXOffset());
        camera.setYSpeed(getTargetYOffset());
        camera.move();
    }

    @Override
    public void draw(Graphics2D g2) {
        if(camera.getDrawGrid()) {
            drawGrid(g2);
        }
    }
    
}