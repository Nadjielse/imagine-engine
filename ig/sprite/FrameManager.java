package ig.sprite;

/**
 * Class that helps managing the
 * frames of a {@code SpriteSheet}.
 * 
 * @author Daniel O Sousa
 */
public class FrameManager {

    /**
     * The {@code SpriteSheet}
     * instance that is managed
     * by this {@code FrameManager}.
     */
    private SpriteSheet spriteSheet;

    /**
     * The column of the
     * {@code spriteSheet}
     * where to select a
     * frame from.
     */
    private int frameX = 0;

    /**
     * The row of the
     * {@code spriteSheet}
     * where to select a
     * frame from.
     */
    private int frameY = 0;

    /**
     * The currently selected frame
     * from this {@code FrameManager}'s
     * {@code spriteSheet}.
     */
    private Sprite currentFrame;

    // TODO throw an exception if spriteSheet is null
    /**
     * Creates a {@code FrameManager} instance
     * that will manage the frames of the
     * passed {@code SpriteSheet}.
     * 
     * @param spriteSheet the {@code SpriteSheet}
     *                    to be managed
     */
    public FrameManager(SpriteSheet spriteSheet) {
        storeSpriteSheet(spriteSheet);
        setFrameX(0);
        setFrameY(0);
    }

    /**
     * Stores the passed {@code SpriteSheet} into
     * the {@code spriteSheet} property.
     * 
     * @param spriteSheet the {@code SpriteSheet}
     *                    that will be managed by this
     *                    {@code FrameManager}
     */
    private void storeSpriteSheet(SpriteSheet spriteSheet) {
        this.spriteSheet = spriteSheet;
    }

    /**
     * Returns the {@code SpriteSheet}
     * managed by this {@code FrameManager}.
     * 
     * @return the {@code spriteSheet} of
     *         this {@code FrameManager}
     */
    public SpriteSheet getSpriteSheet() {
        return this.spriteSheet;
    }

    /**
     * Sets the column of this {@code FrameManager}'s
     * {@code spriteSheet} to select a frame from and
     * selects the frame which is there.
     * <p>
     * If the passed {@code frameX} is not a column of the
     * {@code spriteSheet} (i.e. is less than {@code 0} or greater
     * than the number of columns of the {@code spriteSheet}
     * - {@code 1}), then this method won't
     * do anything.
     * 
     * @param frameX the column where to get a
     *               frame from
     */
    public void setFrameX(int frameX) {
        if(frameX >= 0 && frameX < spriteSheet.getColumns()) {
            this.frameX = frameX;
            updateCurrentFrame();
        }
    }

    /**
     * Selects the frame at the next column
     * of this {@code FrameManager}'s
     * {@code spriteSheet}.
     */
    public void nextFrameX() {
        if(frameX < spriteSheet.getColumns() - 1) {
            setFrameX(frameX + 1);
        } else {
            setFrameX(0);
        }
    }

    /**
     * Selects the frame at the previous column
     * of this {@code FrameManager}'s
     * {@code spriteSheet}.
     */
    public void previousFrameX() {
        if(frameX > 0) {
            setFrameX(frameX - 1);
        } else {
            setFrameX(spriteSheet.getColumns() - 1);
        }
    }

    /**
     * Returns the column of
     * this {@code FrameManager}'s
     * {@code spriteSheet} where the
     * current frame is located.
     * 
     * @return the column of the current frame
     */
    public int getFrameX() {
        return this.frameX;
    }

    /**
     * Sets the row of this {@code FrameManager}'s
     * {@code spriteSheet} to select a frame from and
     * selects the frame which is there.
     * <p>
     * If the passed {@code frameY} is not a row of the
     * {@code spriteSheet} (i.e. is less than {@code 0} or greater
     * than the number of rows of the {@code spriteSheet}
     * - {@code 1}), then this method won't
     * do anything.
     * 
     * @param frameY the row where to get a
     *               frame from
     */
    public void setFrameY(int frameY) {
        if(frameY >= 0 && frameY < spriteSheet.getRows()) {
            this.frameY = frameY;
            updateCurrentFrame();
        }
    }

    /**
     * Selects the frame at the next row
     * of this {@code FrameManager}'s
     * {@code spriteSheet}.
     */
    public void nextFrameY() {
        if(frameY < spriteSheet.getRows() - 1) {
            setFrameY(frameY + 1);
        } else {
            setFrameY(0);
        }
    }

    /**
     * Selects the frame at the previous row
     * of this {@code FrameManager}'s
     * {@code spriteSheet}.
     */
    public void previousFrameY() {
        if(frameY > 0) {
            setFrameY(frameY - 1);
        } else {
            setFrameY(spriteSheet.getRows() - 1);
        }
    }

    /**
     * Returns the row of
     * this {@code FrameManager}'s
     * {@code spriteSheet} where the
     * current frame is located.
     * 
     * @return the row of the current frame
     */
    public int getFrameY() {
        return this.frameY;
    }

    /**
     * Updates the {@code currentFrame} to
     * match the frame specified by the {@code frameX}
     * and {@code frameY} properties.
     */
    private void updateCurrentFrame() {
        this.currentFrame = spriteSheet.getSprites()[frameY][frameX];
    }

    /**
     * Returns the current frame selected
     * by this {@code FrameManager}.
     * 
     * @return the current frame of this {@code FrameManager}
     */
    public Sprite getCurrentFrame() {
        return this.currentFrame;
    }

}