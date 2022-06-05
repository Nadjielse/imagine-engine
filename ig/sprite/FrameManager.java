package ig.sprite;

public class FrameManager {

    private SpriteSheet spriteSheet;
    private int frameX = 0;
    private int frameY = 0;
    private Sprite currentFrame;

    // TODO throw an exception if spriteSheet is null
    public FrameManager(SpriteSheet spriteSheet) {
        storeSpriteSheet(spriteSheet);
        setFrameX(0);
        setFrameY(0);
    }

    private void storeSpriteSheet(SpriteSheet spriteSheet) {
        this.spriteSheet = spriteSheet;
    }

    public SpriteSheet getSpriteSheet() {
        return this.spriteSheet;
    }

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