package ig.object;

import java.awt.Graphics2D;
import java.awt.Color;

import ig.sprite.SpriteSheet;
import ig.sprite.Sprite;
import ig.space.Point;

/**
 * Class for creating new tiles for a {@code Game}.
 * In order to use this class, you must extend
 * it and call its constructor.
 */
public abstract class Tile {

    /**
     * The x coordinate of this {@code Tile}.
     */
    private int x;

    /**
     * The y coordinate of this {@code Tile}.
     */
    private int y;

    /**
     * The width of this {@code Tile}.
     * <p>
     * The value of this property must not
     * be a negative number.
     */
    private int width;

    /**
     * The height of this {@code Tile}.
     * <p>
     * The value of this property must not
     * be a negative number.
     */
    private int height;

    /**
     * The color with which the {@code draw} method
     * will draw the bounding box of this {@code Tile},
     * if the {@code showBoundingBox} property is set
     * to {@code true}.
     * 
     * @see #draw(Graphics2D)
     * @see #showBoundingBox
     */
    private Color color = new Color(255, 255, 255, 0);

    /**
     * The sprite sheet of this {@code Tile}.
     */
    private SpriteSheet spriteSheet;

    /**
     * The column of the frame from the
     * {@code spriteSheet} that should be drawn by the
     * {@code draw} method if the property
     * {@code showSprite} is set to {@code true}.
     * 
     * @see #draw(Graphics2D)
     * @see #showSprite
     */
    private int frameX = 0;

    /**
     * The row of the frame from the
     * {@code spriteSheet} that should be drawn by the
     * {@code draw} method if the property
     * {@code showSprite} is set to {@code true}.
     * 
     * @see #draw(Graphics2D)
     * @see #showSprite
     */
    private int frameY = 0;

    /**
     * The current frame of this {@code Tile}
     * that will be drawn by the {@code draw}
     * method if the {@code showSprite}
     * property is set to {@code true}.
     * 
     * @see #draw(Graphics2D)
     * @see #showSprite
     */
    private Sprite currentFrame;

    // private Stage stage;

    /**
     * Property that tells if this {@code Tile}'s
     * bounding box should be drawn when the
     * {@code draw} method is called.
     * <p>
     * This property is initially set to
     * {@code false}. If it is set to {@code true}
     * the bounding box will be drawn with the
     * color specified by the {@code color} atribute.
     * 
     * @see #draw(Graphics2D)
     * @see #color
     */
    private boolean showBoundingBox = false;

    /**
     * Property that tells if this {@code Tile}'s
     * current frame should be drawn when the
     * {@code draw} method is called.
     * <p>
     * This property is initially set to {@code true}.
     * 
     * @see #draw(Graphics2D)
     * @see #currentFrame
     */
    private boolean showSprite = true;

    /**
     * Constructs a {@code Tile} instance, which will have
     * the passed {@code spriteSheet}, {@code x} and {@code y}
     * coordinates, {@code width} and {@code height}
     * <p>
     * The {@code width} and {@code height} arguments should be
     * positive, otherwise they are not set and the dimensions
     * of this {@code Tile} keep being the initial ones (0 by 0 pixels).
     * 
     * @param spriteSheet The {@code SpriteSheet} for this {@code Tile}
     * @param x The x coordinate
     * @param y The y coordinate
     * @param width The width of this {@code Tile}
     * @param height The height of this {@code Tile}
     */
    public Tile(SpriteSheet spriteSheet, int x, int y, int width, int height) {
        setSpriteSheet(spriteSheet);
        setCoordinates(x, y);
        setSize(width, height);
    }

    /**
     * Sets the x coordinate of this {@code Tile}.
     * 
     * @param x the x coordinate
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Returns the x coordinate of this {@code Tile}.
     * 
     * @return the x coordinate
     */
    public int getX() {
        return this.x;
    }

    /**
     * Sets the y coordinate of this {@code Tile}.
     * 
     * @param y the y coordinate
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Returns the y coordinate of this {@code Tile}.
     * 
     * @return the y coordinate
     */
    public int getY() {
        return this.y;
    }

    /**
     * Sets the x and y coordinates of this {@code Tile}.
     * 
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public void setCoordinates(int x, int y) {
        setX(x);
        setY(y);
    }

    /**
     * Sets the x and y coordinates of this {@code Tile}.
     * 
     * @param point a {@code Point} instance informing
     *              the x and y coordinates
     */
    public void setCoordinates(Point point) {
        setCoordinates(point.getX(), point.getY());
    }

    /**
     * Sets the width if the passed {@code width}
     * is greater or equal to 0.
     * 
     * @param width the width to be set
     */
    private void setWidth(int width) {
        if(width >= 0) {
            this.width = width;
        }
    }

    /**
     * Returns the width of this {@code Tile}.
     * 
     * @return the width of this {@code Tile}
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * Sets the height if the passed {@code height}
     * is greater or equal to 0.
     * 
     * @param height the height to be set
     */
    private void setHeight(int height) {
        if(height >= 0) {
            this.height = height;
        }
    }

    /**
     * Returns the height of this {@code Tile}.
     * 
     * @return the height of this {@code Tile}
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * Sets the width if the passed {@code width}
     * is greater or equal to 0 and does the same
     * with the {@code height}.
     * 
     * @param width the width to be set
     * @param height the height to be set
     */
    private void setSize(int width, int height) {
        setWidth(width);
        setHeight(height);
    }

    /**
     * Sets the sprite sheet of this {@code Tile} and
     * sets both the {@code frameX} and {@code frameY}
     * to 0.
     * <p>
     * Also updates the {@code currentFrame} property
     * to match the frame pointed by the {@code frameX} and
     * {@code frameY} properties.
     * 
     * @param spriteSheet the new sprite sheet of this {@code Tile}
     * 
     * @see #currentFrame
     * @see #frameX
     * @see #frameY
     */
    private void setSpriteSheet(SpriteSheet spriteSheet) {
        this.spriteSheet = spriteSheet;
        setFrameX(0);
        setFrameY(0);
    }

    /**
     * Returns the sprite sheet of this {@code Tile}.
     * 
     * @return the sprite sheet of this {@code Tile}
     */
    public SpriteSheet getSpriteSheet() {
        return this.spriteSheet;
    }

    /**
     * Sets the column of this {@code Tile}'s {@code spriteSheet}
     * - if it isn't {@code null} - where is located the
     * frame which should be drawn by the {@code draw} method.
     * <p>
     * If the passed {@code frameX} is greater or equal to the
     * number of columns of the {@code spriteSheet}, or less
     * than 0, than this method does nothing.
     * <p>
     * This method also updates the {@code currentFrame} property,
     * so it matches the new {@code frameX} and {@code frameY}
     * specification.
     * 
     * @param frameX the column of the frame to draw
     * 
     * @see #draw(Graphics2D)
     */
    public void setFrameX(int frameX) {
        if(spriteSheet != null) {
            if(frameX >= 0 && frameX < spriteSheet.getColumns()) {
                this.frameX = frameX;
                updateCurrentFrame();
            }
        }
    }

    /**
     * Returns the column of the {@code spriteSheet}
     * where is located the {@code currentFrame} which is
     * being drawn by the {@code draw} method.
     * 
     * @return the column where the {@code currentFrame} is
     * 
     * @see #draw(Graphics2D)
     */
    public int getFrameX() {
        return this.frameX;
    }

    /**
     * If the {@code spriteSheet} isn't {@code null}, makes
     * the {@code frameX} change, turning the next frame
     * into the {@code currentFrame}.
     */
    public void nextFrameX() {
        if(spriteSheet != null) {
            if(frameX < spriteSheet.getColumns() - 1) {
                setFrameX(frameX + 1);
            } else {
                setFrameX(0);
            }
        }
    }

    /**
     * If the {@code spriteSheet} isn't {@code null}, makes
     * the {@code frameX} change, turning the previous frame
     * into the {@code currentFrame}.
     */
    public void previousFrameX() {
        if(spriteSheet != null) {
            if(frameX > 0) {
                setFrameX(frameX - 1);
            } else {
                setFrameX(spriteSheet.getColumns() - 1);
            }
        }
    }

    /**
     * Sets the row of this {@code Tile}'s {@code spriteSheet}
     * - if it isn't {@code null} - where is located the
     * frame which should be drawn by the {@code draw} method.
     * <p>
     * If the passed {@code frameY} is greater or equal to the
     * number of rows of the {@code spriteSheet}, or less
     * than 0, than this method does nothing.
     * <p>
     * This method also updates the {@code currentFrame} property,
     * so it matches the new {@code frameX} and {@code frameY}
     * specification.
     * 
     * @param frameY the row of the frame to draw
     * 
     * @see #draw(Graphics2D)
     */
    public void setFrameY(int frameY) {
        if(spriteSheet != null) {
            if(frameY >= 0 && frameY < spriteSheet.getRows()) {
                this.frameY = frameY;
                updateCurrentFrame();
            }
        }
    }

    /**
     * Returns the row of the {@code spriteSheet}
     * where is located the {@code currentFrame} which is
     * being drawn by the {@code draw} method.
     * 
     * @return the row where the {@code currentFrame} is
     * 
     * @see #draw(Graphics2D)
     */
    public int getFrameY() {
        return this.frameY;
    }

    /**
     * If the {@code spriteSheet} isn't {@code null}, makes
     * the {@code frameY} change, turning the next frame
     * into the {@code currentFrame}.
     */
    public void nextFrameY() {
        if(spriteSheet != null) {
            if(frameY < spriteSheet.getRows() - 1) {
                setFrameY(frameY + 1);
            } else {
                setFrameY(0);
            }
        }
    }

    /**
     * If the {@code spriteSheet} isn't {@code null}, makes
     * the {@code frameY} change, turning the previous frame
     * into the {@code currentFrame}.
     */
    public void previousFrameY() {
        if(spriteSheet != null) {
            if(frameY > 0) {
                setFrameY(frameY - 1);
            } else {
                setFrameY(spriteSheet.getRows() - 1);
            }
        }
    }

    /**
     * Updates the {@code currentFrame} property, making it
     * match the specification of the {@code frameX} and {@code frameY}
     * properties.
     * 
     * @see #frameX
     * @see #frameY
     * @see #currentFrame
     */
    private void updateCurrentFrame() {
        this.currentFrame = spriteSheet.getSprites()[frameY][frameX];
    }

    /**
     * Returns the {@code currentFrame} of this
     * {@code Tile}.
     * 
     * @return the {@code currentFrame} of this
     *             {@code Tile}.
     */
    public Sprite getCurrentFrame() {
        return this.currentFrame;
    }


    /*
    public Stage getStage() {
        return this.stage;
    }
    */

    /**
     * Sets the color which would be used to
     * draw the bounding box of this {@code Tile}.
     * <p>
     * However if the passed {@code color} is
     * {@code null}, does nothing.
     * 
     * @param color the color of this {@code Tile}'s
     *              bounding box
     */
    public void setColor(Color color) {
        if(color != null) {
            this.color = color;
        }
    }

    /**
     * Returns the color of the bounding box
     * of this {@code Tile}.
     * 
     * @return the color of this {@code Tile}'s
     *         bounding box
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Sets the {@code showSprite} property to the
     * passed boolean {@code b}, so the sprite
     * of this {@code Tile} is visible or not.
     * 
     * @param b the value for the {@code showSprite}
     *          property
     */
    public void setShowSprite(boolean b) {
        this.showSprite = b;
    }

    /**
     * Returns the value of the {@code showSprite}
     * property, which is {@code true} if the sprite is being
     * drawn and {@code false} otherwise.
     * 
     * @return the {@code showShowSprite} property
     */
    public boolean getShowSprite() {
        return this.showSprite;
    }

    /**
     * Sets the {@code showBoundingBox} property to the
     * passed boolean {@code b}, so the bounding box
     * of this {@code Tile} is visible or not.
     * 
     * @param b the value for the {@code showBoundingBox}
     *          property
     */
    public void setShowBoundingBox(boolean b) {
        this.showBoundingBox = b;
    }

    /**
     * Returns the value of the {@code showBoundingBox}
     * property, which is {@code true} if the bounding box
     * is being drawn and {@code false} otherwise.
     * 
     * @return the {@code showBoundingBox} property
     */
    public boolean getShowBoundingBox() {
        return this.showBoundingBox;
    }

    /**
     * Executes the {@code onStart} method.
     * 
     * @see #onStart()
     */
    public void start() {

        onStart();
    }

    /**
     * Abstract method that is executed when the
     * {@code start} method is called.
     * <p>
     * This method should be used for defining what
     * should happen when this {@code Tile} is initialized.
     * 
     * @see #start()
     */
    protected abstract void onStart();

    /**
     * Executes the {@code onUpdate} method.
     * 
     * @see #onUpdate()
     */
    public void update() {

        onUpdate();
    }

    /**
     * Abstract method that is executed when the
     * {@code update} method is called.
     * <p>
     * This method should be used for defining what
     * should happen to this {@code Tile} each
     * frame of the {@code Game}.
     * 
     * @see #update()
     */
    protected abstract void onUpdate();

    /**
     * Draws this {@code Tile} using the passed
     * {@code Graphics2D} instance.
     * <p>
     * The drawing of the bounding box occurs first
     * (if the {@code showBoundingBox} property is set to
     * {@code true}), and then the sprite is drawn
     * (if the {@code showSprite} property is set to
     * {@code true}).
     * <p>
     * After drawing the {@code Tile}, this method calls the
     * {@code onDraw} method.
     * 
     * @param g2 a {@code Graphics2D} instance
     * 
     * @see #onDraw(Graphics2D)
     */
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

    /**
     * Abstract method that is executed when the
     * {@code draw} method is called.
     * <p>
     * This method should be used for defining what
     * should happen to this {@code Tile} each frame
     * of the {@code Game}, when it is drawn.
     * <p>
     * The parameter {@code g2} serves to do custom
     * drawing related things
     * 
     * @param g2 a {@code Graphics2D} instance
     * 
     * @see #draw(Graphics2D)
     */
    protected abstract void onDraw(Graphics2D g2);

}