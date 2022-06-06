package ig.object;

import java.awt.Color;
import java.awt.Graphics2D;

import ig.flow.GameFluid;
import ig.sprite.SpriteSheet;
import ig.sprite.Sprite;
import ig.sprite.FrameManager;

/**
 * Class for creating game objects.
 * 
 * @author Daniel O Sousa
 */
public abstract class GameObject implements GameFluid {
    
    /**
     * The x coordinate of this {@code GameObject}.
     */
    private int x;

    /**
     * The y coordinate of this {@code GameObject}.
     */
    private int y;

    /**
     * The width of this {@code GameObject}.
     */
    private int width;

    /**
     * The height of this {@code GameObject}.
     */
    private int height;

    /**
     * A {@code FrameManager} to the {@code SpriteSheet}
     * of this {@code GameObject}.
     */
    private FrameManager frameManager;

    /**
     * The color with which this {@code GameObject}
     * will be drawn. This color is initially set
     * to transparent.
     */
    private Color color = new Color(255, 255, 255, 0);

    /**
     * Determines if the bounding box of this
     * {@code GameObject} will be drawn onscreen.
     * If set to {@code true}, the bounding box
     * will be drawn.
     * <p>
     * Initially this attribute is set to {@code false}.
     */
    private boolean showBoundingBox = false;

    /**
     * Determines if the sprite of this object
     * will be drawn onscreen. If set to
     * {@code true}, the sprite will be drawn.
     * <p>
     * This property is initially set to {@code true}.
     */
    private boolean showSprite = true;

    /**
     * Constructs a {@code GameObject} instance that will
     * have the passed {@code spriteSheet}, {@code x} and
     * {@code y} coordinates and {@code width} and
     * {@code height} dimensions.
     * 
     * @param spriteSheet a {@code SpriteSheet} for this {@code GameObject}
     * @param x the x coordinate
     * @param y the y coordinate
     * @param width the width dimension
     * @param height the height dimension
     */
    public GameObject(SpriteSheet spriteSheet, int x, int y, int width, int height) {
        if(spriteSheet != null) {
            this.frameManager = new FrameManager(spriteSheet);
        }
        setCoordinates(x, y);
        setSize(width, height);
    }
    
    /**
     * Sets the x coordinate of this
     * {@code GameObject}.
     * 
     * @param x the x coordinate
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Returns the x coordinate of this
     * {@code GameObject}.
     * 
     * @return the x coordinate
     */
    public int getX() {
        return this.x;
    }

    /**
     * Sets the y coordinate of this
     * {@code GameObject}.
     * 
     * @param y the y coordinate
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Returns the y coordinate of this
     * {@code GameObject}.
     * 
     * @return the y coordinate
     */
    public int getY() {
        return this.y;
    }

    /**
     * Sets the x and y coordinates of this
     * {@code GameObject}.
     * 
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public void setCoordinates(int x, int y) {
        setX(x);
        setY(y);
    }

    /**
     * Sets the width of this {@code GameObject}
     * if the passed {@code width} is not negative.
     * 
     * @param width the width to be set
     */
    public void setWidth(int width) {
        if(width >= 0) {
            this.width = width;
        }
    }

    /**
     * Returns the width of this {@code GameObject}.
     * 
     * @return the width dimension
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * Sets the height of this {@code GameObject}
     * if the passed {@code height} is not negative.
     * 
     * @param height the height to be set
     */
    public void setHeight(int height) {
        if(height >= 0) {
            this.height = height;
        }
    }

    /**
     * Returns the height of this {@code GameObject}.
     * 
     * @return the height dimension
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * Sets the width and height of this {@code GameObject},
     * respectively, if they are not negative.
     * 
     * @param width the width to be set
     * @param height the height to be set
     */
    public void setSize(int width, int height) {
        setWidth(width);
        setHeight(height);
    }

    /**
     * Returns the coordinate of
     * the top boundary of
     * this {@code GameObject}
     * 
     * @return the top coordinate
     */
    public int getTop() {
        return y;
    }

    /**
     * Returns the coordinate of
     * the right boundary of
     * this {@code GameObject}
     * 
     * @return the right coordinate
     */
    public int getRight() {
        return x + width;
    }

    /**
     * Returns the coordinate of
     * the bottom boundary of
     * this {@code GameObject}
     * 
     * @return the bottom coordinate
     */
    public int getBottom() {
        return y + height;
    }

    /**
     * Returns the coordinate of
     * the left boundary of
     * this {@code GameObject}
     * 
     * @return the left coordinate
     */
    public int getLeft() {
        return x;
    }

    /**
     * Returns the {@code SpriteSheet} of this
     * {@code GameObject}.
     * 
     * @return this {@code GameObject}'s {@code SpriteSheet}
     */
    public SpriteSheet getSpriteSheet() {
        if(frameManager != null) {
            return frameManager.getSpriteSheet();
        } else {
            return null;
        }
    }

    /**
     * Sets the column of the frame of this
     * {@code GameObject}'s {@code SpriteSheet}
     * to draw when this {@code GameObject} is drawn.
     * <p>
     * If the {@code frameX} argument is not a
     * valide column (i.e. is less than {@code 0} or greater
     * than the number of columns of the {@code SpriteSheet}
     * - {@code 1}), than it is not set.
     * 
     * @param frameX the column of the frame to draw
     */
    public void setFrameX(int frameX) {
        if(frameManager != null) {
            frameManager.setFrameX(frameX);
        }
    }

    /**
     * Selects the next frame on the x axis
     * of this {@code GameObject}'s
     * {@code SpriteSheet}  to draw when
     * this {@code GameObject} is drawn.
     */
    public void nextFrameX() {
        if(frameManager != null) {
            frameManager.nextFrameX();
        }
    }

    /**
     * Selects the previous frame on the x axis
     * of this {@code GameObject}'s
     * {@code SpriteSheet} to draw when
     * this {@code GameObject} is drawn.
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
     * Sets the row of the frame of this
     * {@code GameObject}'s {@code SpriteSheet}
     * to draw when this {@code GameObject} is drawn.
     * <p>
     * If the {@code frameY} argument is not a
     * valide row (i.e. is less than {@code 0} or greater
     * than the number of rows of the {@code SpriteSheet}
     * - {@code 1}), than it is not set.
     * 
     * @param frameY the row of the frame to draw
     */
    public void setFrameY(int frameY) {
        if(frameManager != null) {
            frameManager.setFrameY(frameY);
        }
    }

    /**
     * Selects the next frame on the y axis
     * of this {@code GameObject}'s
     * {@code SpriteSheet} to draw when
     * this {@code GameObject} is drawn.
     */
    public void nextFrameY() {
        if(frameManager != null) {
            frameManager.nextFrameY();
        }
    }

    /**
     * Selects the previous frame on the y axis
     * of this {@code GameObject}'s
     * {@code SpriteSheet} to draw when
     * this {@code GameObject} is drawn.
     */
    public void previousFrameY() {
        if(frameManager != null) {
            frameManager.previousFrameY();
        }
    }

    /**
     * Returns the row of this {@code GameObject}'s
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
     * Returns the frame of this {@code GameObject}'s
     * {@code SpriteSheet} which is currently being
     * drawn when this {@code GameObject} is drawn.
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
     * Sets the {@code color} that will be
     * used to draw this {@code GameObject}'s
     * bounding box.
     * 
     * @param color the color to be set
     */
    public void setColor(Color color) {
        if(color != null) {
            this.color = color;
        }
    }

    /**
     * Returns the {@code color} used to
     * draw this {@code GameObject}'s
     * bounding box.
     * 
     * @return the color of this {@code GameObject}'s
     *         bounding box
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Defines if the sprite of this
     * {@code GameObject} should be drawn
     * or not.
     * 
     * @param b a {@code boolean} value
     */
    public void setShowSprite(boolean b) {
        this.showSprite = b;
    }

    /**
     * Returns {@code true} if this
     * {@code GameObject}'s sprite is
     * being drawn when this {@code GameObject}
     * is drawn, and {@code false} otherwise.
     * 
     * @return a {@code boolean} value
     */
    public boolean getShowSprite() {
        return this.showSprite;
    }

    /**
     * Defines if the bounding box of this
     * {@code GameObject} should be drawn
     * or not.
     * 
     * @param b a {@code boolean} value
     */
    public void setShowBoundingBox(boolean b) {
        this.showBoundingBox = b;
    }

    /**
     * Returns {@code true} if this
     * {@code GameObject}'s bounding box is
     * being drawn when this {@code GameObject}
     * is drawn, and {@code false} otherwise.
     * 
     * @return a {@code boolean} value
     */
    public boolean getShowBoundingBox() {
        return this.showBoundingBox;
    }

    /**
     * Executes the {@code onStart} method.
     * 
     * @see #onStart()
     */
    @Override
    public void start() {

        onStart();
    }

    /**
     * Method executed when the
     * {@code start} method is called.
     * <p>
     * This method should be used for defining what
     * should happen when this {@code GameObject} is started.
     * 
     * @see #start()
     */
    public abstract void onStart();

    /**
     * Executes the {@code onUpdate} method.
     * 
     * @see #onUpdate()
     */
    @Override
    public void update() {
        
        onUpdate();
    }

    /**
     * Method executed when the
     * {@code update} method is called.
     * <p>
     * This method should be used for defining what
     * should happen to this {@code GameObject} each
     * frame of the {@code Game}.
     * 
     * @see #update()
     */
    public abstract void onUpdate();

    /**
     * Draws this {@code GameObject} using the passed
     * {@code Graphics2D} instance.
     * <p>
     * The drawing of the bounding box occurs first
     * (if the {@code showBoundingBox} property is set to
     * {@code true}), and then the sprite is drawn
     * (if the {@code showSprite} property is set to
     * {@code true}).
     * <p>
     * After drawing the {@code GameObject}, this method calls the
     * {@code onDraw} method.
     * 
     * @param g2 a {@code Graphics2D} instance
     * 
     * @see #onDraw(Graphics2D)
     */
    @Override
    public void draw(Graphics2D g2) {
        if(showBoundingBox) {
            g2.setColor(color);
            g2.fillRect(x, y, width, height);
        }
        if(showSprite && frameManager != null) {
            g2.drawImage(getCurrentFrame().getImage(), x, y, width, height, null);
        }

        onDraw(g2);
    }
    
    /**
     * Method executed when the
     * {@code draw} method is called.
     * <p>
     * This method should be used for defining what
     * should happen to this {@code GameObject} each frame
     * of the {@code Game}, when it is drawn.
     * <p>
     * The parameter {@code g2} serves to do custom
     * drawings.
     * 
     * @param g2 a {@code Graphics2D} instance
     * 
     * @see #draw(Graphics2D)
     */
    public abstract void onDraw(Graphics2D g2);

}