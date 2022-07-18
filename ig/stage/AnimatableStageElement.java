package ig.stage;

import ig.sprite.*;
import ig.camera.Camera;

/**
 * Super class for animatable stage elements
 * like game objects and scenarios. 
 * 
 * @author Daniel O Sousa
 */
public abstract class AnimatableStageElement extends StageElement {
    
    /**
     * A frame manager to store and
     * manage the sprite sheet.
     */
    private FrameManager frameManager;



    /**
     * Creates a new {@code FrameManager} to
     * manage the passed {@code SpriteSheet}.
     * 
     * @param spriteSheet the {@code SpriteSheet}
     * which the {@code frameManager} will manage
     */
    private void createFrameManager(SpriteSheet spriteSheet) {
        this.frameManager = new FrameManager(spriteSheet);
    }

    /**
     * Sets the sprite sheet that will
     * be used by this {@code AnimatableStageElement}.
     * 
     * @param spriteSheet the sprite sheet
     * to be set
     */
    public void setSpriteSheet(SpriteSheet spriteSheet) {
        if(spriteSheet == null) {
            this.frameManager = null;
        } else {
            createFrameManager(spriteSheet);
        }
    }

    /**
     * Returns the {@code SpriteSheet} of
     * this {@code AnimatableStageElement}.
     * 
     * @return the {@code spriteSheet}
     */
    public SpriteSheet getSpriteSheet() {
        if(frameManager != null) {
            return frameManager.getSpriteSheet();
        } else {
            return null;
        }
    }

    /**
     * Sets the column of this {@code AnimatableStageElement}'s
     * {@code spriteSheet} where to select a frame from.
     * <p>
     * If the passed {@code frameX} is invalid (is less
     * than {@code 0} or greater or equal to the amount of
     * columns of the sprite sheet) this method won't
     * do anything.
     * 
     * @param frameX the column of the frame to select
     */
    public void setFrameX(int frameX) {
        if(frameManager != null) {
            frameManager.setFrameX(frameX);
        }
    }

    /**
     * Selects the next frame on the x axis
     * of this {@code AnimatableStageElement}'s
     * {@code SpriteSheet}.
     */
    public void nextFrameX() {
        if(frameManager != null) {
            frameManager.nextFrameX();
        }
    }

    /**
     * Selects the previous frame on the x axis
     * of this {@code AnimatableStageElement}'s
     * {@code SpriteSheet}.
     */
    public void previousFrameX() {
        if(frameManager != null) {
            frameManager.previousFrameX();
        }
    }

    /**
     * Returns the column of this {@code GameObject}'s
     * {@code SpriteSheet} where the current frame is
     * located.
     * 
     * @return the column where the current frame is
     */
    public int getFrameX() {
        if(frameManager != null) {
            return frameManager.getFrameX();
        } else {
            return 0;
        }
    }

    /**
     * Sets the row of this {@code AnimatableStageElement}'s
     * {@code spriteSheet} where to select a frame from.
     * <p>
     * If the passed {@code frameY} is invalid (is less
     * than {@code 0} or greater or equal to the amount of
     * rows of the sprite sheet) this method won't
     * do anything.
     * 
     * @param frameY the row of the frame to select
     */
    public void setFrameY(int frameY) {
        if(frameManager != null) {
            frameManager.setFrameY(frameY);
        }
    }

    /**
     * Selects the next frame on the y axis
     * of this {@code AnimatableStageElement}'s
     * {@code SpriteSheet}.
     */
    public void nextFrameY() {
        if(frameManager != null) {
            frameManager.nextFrameY();
        }
    }

    /**
     * Selects the previous frame on the y axis
     * of this {@code AnimatableStageElement}'s
     * {@code SpriteSheet}.
     */
    public void previousFrameY() {
        if(frameManager != null) {
            frameManager.previousFrameY();
        }
    }

    /**
     * Returns the row of this {@code AnimatableStageElement}'s
     * {@code SpriteSheet} where the current frame is
     * located.
     * 
     * @return the row where the current frame is
     */
    public int getFrameY() {
        if(frameManager != null) {
            return frameManager.getFrameY();
        } else {
            return 0;
        }
    }

    /**
     * Returns the current frame of this
     * {@code AnimatableStageElement}'s {@code SpriteSheet}.
     * 
     * @return the current frame
     */
    public Sprite getCurrentFrame() {
        if(frameManager != null) {
            return frameManager.getCurrentFrame();
        } else {
            return null;
        }
    }

    /**
     * Returns the {@code Camera} of the
     * {@code Stage} that contains this
     * {@code AnimatableStageElement}.
     * 
     * @return the {@code Camera} of the
     * {@code Stage} of this
     * {@code AnimatableStageElement}
     */
    public Camera getCamera() {
        if(getStage() != null) {
            return getStage().getCamera();
        } else {
            return null;
        }
    }

    /**
     * Returns the x coordinate of the
     * {@code Camera} of the {@code Stage}
     * that contains this
     * {@code AnimatableStageElement}.
     * 
     * @return the x coordinate of the
     * {@code Camera} of the
     * {@code Stage} of this
     * {@code AnimatableStageElement}
     */
    public int getCameraX() {
        if(getCamera() != null) {
            return getCamera().getX();
        } else {
            return 0;
        }
    }

    /**
     * Returns the y coordinate of the
     * {@code Camera} of the {@code Stage}
     * that contains this
     * {@code AnimatableStageElement}.
     * 
     * @return the y coordinate of the
     * {@code Camera} of the
     * {@code Stage} of this
     * {@code AnimatableStageElement}
     */
    public int getCameraY() {
        if(getCamera() != null) {
            return getCamera().getY();
        } else {
            return 0;
        }
    }

}