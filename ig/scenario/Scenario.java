package ig.scenario;

import ig.sprite.FrameManager;
import ig.sprite.SpriteSheet;
import ig.sprite.Sprite;

public class Scenario {

    private int x;
    private int y;
    private int width;
    private int height;
    private FrameManager frameManager;
    private boolean repeatX = true;
    private boolean repeatY = true;
    private int xSpeed = 0;
    private int ySpeed = 0;

    // TODO constructor should not accept null spriteSheet
    public Scenario(SpriteSheet spriteSheet) {
        setCoordinates(0, 0);
        setSize(spriteSheet.getSpriteWidth(), spriteSheet.getSpriteHeight());
        createFrameManager(spriteSheet);
    }

    public Scenario(SpriteSheet spriteSheet, int width, int height) {
        setCoordinates(0, 0);
        setSize(width, height);
        createFrameManager(spriteSheet);
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return this.x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return this.y;
    }

    public void setCoordinates(int x, int y) {
        setX(x);
        setY(y);
    }

    public void setWidth(int width) {
        if(width >= 0) {
            this.width = width;
        }
    }

    public int getWidth() {
        return this.width;
    }

    public void setHeight(int height) {
        if(height >= 0) {
            this.height = height;
        }
    }

    public int getHeight() {
        return this.height;
    }

    public void setSize(int width, int height) {
        setWidth(width);
        setHeight(height);
    }

    private void createFrameManager(SpriteSheet spriteSheet) {
        frameManager = new FrameManager(spriteSheet);
    }

    public SpriteSheet getSpriteSheet() {
        return frameManager.getSpriteSheet();
    }

    public void setFrameX(int frameX) {
        frameManager.setFrameX(frameX);
    }

    public void nextFrameX() {
        frameManager.nextFrameX();
    }

    public void previousFrameX() {
        frameManager.previousFrameX();
    }

    public int getFrameX() {
        return frameManager.getFrameX();
    }

    public void setFrameY(int frameY) {
        frameManager.setFrameY(frameY);
    }

    public void nextFrameY() {
        frameManager.nextFrameY();
    }

    public void previousFrameY() {
        frameManager.previousFrameY();
    }

    public int getFrameY() {
        return frameManager.getFrameY();
    }

    public Sprite getCurrentFrame() {
        return frameManager.getCurrentFrame();
    }

    public void setRepeatX(boolean repeatX) {
        this.repeatX = repeatX;
    }

    public boolean getRepeatX() {
        return this.repeatX;
    }

    public void setRepeatY(boolean repeatY) {
        this.repeatY = repeatY;
    }

    public boolean getRepeatY() {
        return this.repeatY;
    }

    public void setXSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public int getXSpeed() {
        return this.xSpeed;
    }

    public void setYSpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }

    public int getYSpeed() {
        return this.ySpeed;
    }
    
}