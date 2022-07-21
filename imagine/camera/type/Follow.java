package imagine.camera.type;

import java.awt.Graphics2D;
import java.awt.Color;

import imagine.camera.Camera;
import imagine.camera.CameraGrid;
import imagine.object.GameObject;

/**
 * Class that represents a follow
 * camera type. This camera
 * type moves automatically always
 * trying to fit the target object
 * into the camera grid.
 * 
 * @author Daniel O Sousa
 */
public class Follow implements CameraType {

    /**
     * Reference to the {@code Camera}
     * that has this {@code CameraType}.
     */
    private Camera camera;

    /**
     * The object that the camera
     * that has this type tries
     * to centralize on
     * the game panel.
     */
    private GameObject target;

    /**
     * The grid where the camera
     * that has this type tries
     * to fit its target into.
     */
    private CameraGrid grid;

    /**
     * Creates a {@code Follow}
     * {@code CameraType} that will
     * make its corresponding {@code Camera}
     * follow the passed {@code target}.
     * 
     * @param camera the {@code Camera}
     * that has this {@code CameraType}
     * @param target the {@code GameObject}
     * that will be followed by the {@code camera}
     */
    public Follow(Camera camera, GameObject target) {
        storeCamera(camera);
        storeTarget(target);
        createGrid();
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
     * Stores the {@code target} argument in the {@code target}
     * field. If the argument is {@code null} an exception will
     * be thrown advising that a {@code null} target shouldn't
     * be stored.
     * 
     * @param target the {@code GameObject} to be stored
     * 
     * @throws IllegalArgumentException if the {@code target} argument
     * is {@code null}
     */
    private void storeTarget(GameObject target) {
        if(target == null) {
            camera.setTypeStatic();
        }
        
        this.target = target;
    }

    /**
     * Creates a {@code CameraGrid} with the {@code target}
     * dimensions that will be centralized
     * on the screen. This {@code CameraGrid} will then
     * be passed to the {@code grid} field.
     */
    private void createGrid() {
        int gridWidth =
            target.getWidth() > camera.getWidth() ?
            camera.getWidth() :
            target.getWidth();
        int gridHeight =
            target.getHeight() > camera.getHeight() ?
            camera.getHeight() :
            target.getHeight();
            
        setGrid (
            new CameraGrid (
                camera,
                camera.getWidth() / 2 - gridWidth / 2,
                camera.getHeight() / 2 - gridHeight / 2,
                gridWidth,
                gridHeight
            )
        );
    }

    /**
     * Returns the horizontal distance between the {@code target}
     * and the {@code grid}.
     * 
     * @return distance between {@code target} and {@code grid}
     */
    private int getTargetXOffset() {
        if(target.getRight() - (camera.getX() + grid.getRight()) > 0) {
            return target.getRight() - (camera.getX() + grid.getRight());
        }
        if(target.getLeft() - (camera.getX() + grid.getLeft()) < 0) {
            return target.getLeft() - (camera.getX() + grid.getLeft());
        }

        return 0;
    }

    /**
     * Returns the vertical distance between the {@code target}
     * and the {@code grid}.
     * 
     * @return distance between {@code target} and {@code grid}
     */
    private int getTargetYOffset() {
        if(target.getBottom() - (camera.getY() + grid.getBottom()) > 0) {
            return target.getBottom() - (camera.getY() + grid.getBottom());
        }
        if(target.getTop() - (camera.getY() + grid.getTop()) < 0) {
            return target.getTop() - (camera.getY() + grid.getTop());
        }

        return 0;
    }

    /**
     * Draws the {@code grid} outline using the {@code g2}
     * argument. The drawing will have a red color if the
     * {@code target} is outside the {@code grid} and a green
     * color if it is inside.
     * 
     * @param g2 {@code Graphics2D} with which to draw
     */
    private void drawGrid(Graphics2D g2) {
        Color color;
        if(getTargetXOffset() != 0 || getTargetYOffset() != 0) {
            color = Color.RED;
        } else {
            color = Color.GREEN;
        }

        grid.draw(g2, color);
    }

    /**
     * Sets the {@code grid} to the {@code grid} argument.
     * Exceptions will be thrown if the argument is either {@code null},
     * or if it is greater or outside the {@code camera}
     * 
     * @param grid the {@code CameraGrid} to be set
     * 
     * @throws IllegalArgumentException if the {@code grid} argument
     * is {@code null} or greater or outside the {@code camera}
     */
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

    /**
     * Sets the {@code camera} x and y speeds
     * and moves it according to them in a way
     * that it follows the {@code target}.
     */
    @Override
    public void update() {
        camera.setXSpeed(getTargetXOffset());
        camera.setYSpeed(getTargetYOffset());
        camera.move();
    }

    /**
     * Draws the {@code CameraGrid} of
     * the {@code camera} if it is
     * configured to do so by its
     * {@code drawGrid} field.
     * 
     * @param g2 {@code Graphics2D}
     * instance to draw with
     */
    @Override
    public void draw(Graphics2D g2) {
        if(camera.getDrawGrid()) {
            drawGrid(g2);
        }
    }
    
}