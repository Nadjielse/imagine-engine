package imagine.camera;

import java.awt.Graphics2D;

import imagine.stage.StageElement;
import imagine.stage.Stage;
import imagine.flow.GameFluid;
import imagine.camera.type.*;
import imagine.object.GameObject;

/**
 * Class that represents the view of a {@code Stage}.
 * 
 * @author Daniel O Sousa
 */
public class Camera extends StageElement implements GameFluid {

    /**
     * Represents the type of
     * this {@code Camera}.
     */
    private CameraType type;

    /**
     * Boolean that determines if the
     * grid of the {@code Camera}
     * should be drawn.
     */
    private boolean drawGrid = false;

    /**
     * Constructs a new Camera located
     * at the top left corner of the
     * passed {@code stage} with
     * the size of the {@code GamePanel}
     * where the {@code stage} is being
     * exhibited.
     * <p>
     * By default, the created
     * {@code Camera} has {@code 0} as its
     * x and y speeds and is of the
     * {@code Static} type.
     * 
     * @param stage the {@code Stage} that
     * this {@code Camera} is associated with
     * 
     * @throws IllegalArgumentException if the
     * {@code stage} argument is {@code null}
     */
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

    /**
     * Stores the {@code stage} argument
     * in the {@code stage} field. If the
     * argument is {@code null}, though, throws
     * an {@code IllegalArgumentException} warning
     * that a {@code null} stage cannot
     * be stored.
     * 
     * @param stage the {@code Stage} to be stored
     * 
     * @throws IllegalArgumentException if the
     * {@code stage} argument is {@code null}
     */
    private void storeStage(Stage stage) {
        if(stage == null) {
            throw new IllegalArgumentException("cannot store null stage");
        }

        setStage(stage);
    }

    /**
     * Sets the type of this {@code Camera}
     * to the passed {@code type}. If said
     * {@code type} is {@code null}, though, throws
     * an {@code IllegalArgumentException} warning
     * that a {@code null} type cannot be set.
     * 
     * @param type a {@code CameraType} instance
     * indicating the type to be set
     * 
     * @throws IllegalArgumentException if the
     * passed {@code type} is {@code null}
     */
    public void setType(CameraType type) {
        if(type == null) {
            throw new IllegalArgumentException("cannot set null camera type");
        }

        this.type = type;
    }

    /**
     * Sets the type of this {@code Camera}
     * to the {@code Static} {@code CameraType}.
     */
    public void setTypeStatic() {
        setType(new Static());
    }

    /**
     * Sets the type of this {@code Camera}
     * to the {@code AutoScroll} {@code CameraType}.
     */
    public void setTypeAutoScroll() {
        setType(new AutoScroll(this));
    }

    /**
     * Sets the type of this {@code Camera}
     * to the {@code Follow} {@code CameraType}
     * making the {@code target} argument be
     * the target followed by the {@code Camera}.
     * <p>
     * If the passed {@code target} is {@code null},
     * this {@code Camera}'s type will be automatically
     * converted to {@code Static}.
     * 
     * @param target the target that the
     * {@code Camera} will follow
     */
    public void setTypeFollow(GameObject target) {
        setType(new Follow(this, target));
    }

    /**
     * Returns the type of this {@code Camera}.
     * 
     * @return this {@code Camera}'s type
     */
    public CameraType getType() {
        return this.type;
    }

    /**
     * Sets the grid of this {@code Camera}
     * to the passed {@code CameraGrid}.
     * 
     * @param grid the grid to be set
     */
    public void setGrid(CameraGrid grid) {
        type.setGrid(grid);
    }

    /**
     * Defines if the grid of this {@code Camera}
     * should be drawn onscreen or not according
     * to the value of the boolean argument
     * {@code drawGrid}.
     * 
     * @param drawGrid {@code boolean} determining
     * if the grid should be drawn
     */
    public void setDrawGrid(boolean drawGrid) {
        this.drawGrid = drawGrid;
    }

    /**
     * Returns either {@code true} if this
     * {@code Camera}'s grid is being drawn
     * or {@code false} otherwise.
     * 
     * @param drawGrid {@code boolean}
     * determining if the grid
     * should be drawn
     */
    public boolean getDrawGrid() {
        return this.drawGrid;
    }

    /**
     * Moves this {@code Camera} according to its
     * x and y speeds respecting the borders of
     * the {@code Stage} which it is filming.
     */
    @Override
    public void move() {
        if (
            getLeft() + getXSpeed() < 0
        ) {
            setX(0);
        } else if (
            getRight() + getXSpeed() > getStageWidth()
        ) {
            setX(getStageWidth() - getWidth());
        } else {
            increaseX(getXSpeed());
        }

        if (
            getTop() + getYSpeed() < 0
        ) {
            setY(0);
        } else if (
            getBottom() + getYSpeed() > getStageHeight()
        ) {
            setY(getStageHeight() - getHeight());
        } else {
            increaseY(getYSpeed());
        }
    }

    @Override
    public void start() {
        
    }

    /**
     * Updates this {@code Camera}
     * the way it is determined
     * by its type.
     */
    @Override
    public void update() {
        type.update();
    }

    /**
     * Draws the grid of this {@code Camera}
     * if it has one and is configured to
     * draw it.
     * 
     * @param g2 the {@code Graphics2D} instance
     * with which the grid would be drawn
     */
    @Override
    public void draw(Graphics2D g2) {
        type.draw(g2);
    }

}