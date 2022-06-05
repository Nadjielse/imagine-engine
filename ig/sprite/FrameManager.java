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
     * The {@code spriteSheet}'s
     * frame which is currently
     * selected.
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
     * @param spriteSheet the new {@code SpriteSheet}
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
     * {@code spriteSheet} to select a frame from.
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

    public void nextFrameX() {
        if(frameX < spriteSheet.getColumns() - 1) {
            setFrameX(frameX + 1);
        } else {
            setFrameX(0);
        }
    }

    public void previousFrameX() {
        if(frameX > 0) {
            setFrameX(frameX - 1);
        } else {
            setFrameX(spriteSheet.getColumns() - 1);
        }
    }

    public int getFrameX() {
        return this.frameX;
    }

    /**
     * Sets the row of this {@code FrameManager}'s
     * {@code spriteSheet} to select a frame from.
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

    public void nextFrameY() {
        if(frameY < spriteSheet.getRows() - 1) {
            setFrameY(frameY + 1);
        } else {
            setFrameY(0);
        }
    }

    public void previousFrameY() {
        if(frameY > 0) {
            setFrameY(frameY - 1);
        } else {
            setFrameY(spriteSheet.getRows() - 1);
        }
    }

    public int getFrameY() {
        return this.frameY;
    }

    private void updateCurrentFrame() {
        this.currentFrame = spriteSheet.getSprites()[frameY][frameX];
    }

    public Sprite getCurrentFrame() {
        return this.currentFrame;
    }

}