package ig.object;

import java.awt.Graphics2D;
import java.awt.Color;

import ig.sprite.SpriteSheet;
import ig.sprite.Sprite;
import ig.space.Point;

public abstract class Tile {

    /**
     * The x coordinate.
     */
    private int x;

    /**
     * The y coordinate.
     */
    private int y;

    /**
     * The width.
     */
    private int width;

    /**
     * The height
     */
    private int height;
    private Color color = new Color(255, 255, 255, 0);
    private SpriteSheet spriteSheet;
    private int frameX = 0;
    private int frameY = 0;
    private Sprite currentFrame;
    // private Stage stage;
    private boolean showBoundingBox = false;
    private boolean showSprite = true;


    public Tile(SpriteSheet spriteSheet, int x, int y, int width, int height) {
        setSpriteSheet(spriteSheet);
        setCoordinates(x, y);
        setSize(width, height);
    }

    /**
     * Sets the x coordinate.
     * 
     * @param x the x coordinate
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Returns the x coordinate.
     * 
     * @return the x coordinate
     */
    public int getX() {
        return this.x;
    }

    /**
     * Sets the y coordinate.
     * 
     * @param y the y coordinate
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Returns the y coordinate.
     * 
     * @return the y coordinate
     */
    public int getY() {
        return this.y;
    }

    /**
     * Sets the x and y coordinates.
     * 
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public void setCoordinates(int x, int y) {
        setX(x);
        setY(y);
    }

    /**
     * Sets the x and y coordinates.
     * 
     * @param point a point instance informing
     *              the x and y coordinates
     */
    public void setCoordinates(Point point) {
        setCoordinates(point.getX(), point.getY());
    }

    /**
     * Sets the width if the passed argument
     * is greater than 0.
     * 
     * @param width the width to be set
     */
    protected void setWidth(int width) {
        if(width > 0) {
            this.width = width;
        }
    }

    /**
     * Returns the width.
     * 
     * @return the width.
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * Sets the height if the passed argument
     * is greater than 0.
     * 
     * @param height the height to be set
     */
    protected void setHeight(int height) {
        if(height > 0) {
            this.height = height;
        }
    }

    /**
     * Returns the height.
     * 
     * @return the height
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * Sets the width and the height. But if
     * one of the passed arguments is less
     * or equal to 0, does nothing with it.
     * 
     * @param width the width to be set
     * @param height the height to be set
     */
    protected void setSize(int width, int height) {
        setWidth(width);
        setHeight(height);
    }


    protected void setSpriteSheet(SpriteSheet spriteSheet) {
        if(this.spriteSheet == null) {
            this.spriteSheet = spriteSheet;
            setFrameX(0);
            setFrameY(0);
        }
    }

    public SpriteSheet getSpriteSheet() {
        return this.spriteSheet;
    }


    public void setFrameX(int frameX) {
        if(spriteSheet != null) {
            if(frameX >= 0 && frameX < spriteSheet.getColumns()) {
                this.frameX = frameX;
                updateCurrentFrame();
            }
        }
    }

    public int getFrameX() {
        return this.frameX;
    }

    public void nextFrameX() {
        if(spriteSheet != null) {
            if(frameX < spriteSheet.getColumns() - 1) {
                setFrameX(frameX + 1);
            } else {
                setFrameX(0);
            }
        }
    }

    public void previousFrameX() {
        if(spriteSheet != null) {
            if(frameX > 0) {
                setFrameX(frameX - 1);
            } else {
                setFrameX(spriteSheet.getColumns() - 1);
            }
        }
    }


    public void setFrameY(int frameY) {
        if(spriteSheet != null) {
            if(frameY >= 0 && frameY < spriteSheet.getRows()) {
                this.frameY = frameY;
                updateCurrentFrame();
            }
        }
    }

    public int getFrameY() {
        return this.frameY;
    }

    public void nextFrameY() {
        if(spriteSheet != null) {
            if(frameY < spriteSheet.getRows() - 1) {
                setFrameY(frameY + 1);
            } else {
                setFrameY(0);
            }
        }
    }

    public void previousFrameY() {
        if(spriteSheet != null) {
            if(frameY > 0) {
                setFrameY(frameY - 1);
            } else {
                setFrameY(spriteSheet.getRows() - 1);
            }
        }
    }


    private void updateCurrentFrame() {
        this.currentFrame = spriteSheet.getSprites()[frameX][frameY];
    }

    public Sprite getCurrentFrame() {
        return this.currentFrame;
    }


    /*
    public Stage getStage() {
        return this.stage;
    }
    */


    public void setColor(Color color) {
        if(color != null) {
            this.color = color;
        }
    }

    public Color getColor() {
        return this.color;
    }


    public void setShowSprite(boolean b) {
        this.showSprite = b;
    }

    public boolean getShowSprite() {
        return this.showSprite;
    }


    public void setShowBoundingBox(boolean b) {
        this.showBoundingBox = b;
    }

    public boolean getShowBoundingBox() {
        return this.showBoundingBox;
    }


    public void start() {

        onStart();
    }

    protected abstract void onStart();

    public void update() {

        onUpdate();
    }

    protected abstract void onUpdate();

    public void draw(Graphics2D g2) {
        if(showBoundingBox) {
            g2.setColor(color);
            g2.fillRect(x, y, width, height);
        }
        if(showSprite) {
            g2.drawImage(currentFrame.getImage(), x, y, width, height, null);
        }

        onDraw(g2);
    }

    protected abstract void onDraw(Graphics2D g2);

}