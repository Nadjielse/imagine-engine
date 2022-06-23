package ig.game;

import ig.sprite.*;

/**
 * Super class for game elements like
 * game objects, scenarios or cameras.
 * 
 * @author Daniel O Sousa
 */
public abstract class GameElement {

    /**
     * The x coordinate.
     */
    private int x;

    /**
     * The y coordinate.
     */
    private int y;

    /**
     * The width dimension.
     */
    private int width;

    /**
     * The height dimension.
     */
    private int height;

    /**
     * A frame manager to store and
     * manage the sprite sheet.
     */
    private FrameManager frameManager;

    /**
     * The speed on the x axis.
     */
    private int xSpeed = 0;

    /**
     * The speed on the y axis.
     */
    private int ySpeed = 0;

    /**
     * Sets the x coordinate of this
     * {@code GameElement}.
     * 
     * @param x the x coordinate
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Increments the x coordinate
     * of this {@code GameElement}
     * by the amount specified by
     * the {@code value} argument.
     * 
     * @param value the amount to
     * increment the x by
     */
    public void increaseX(int value) {
        setX(x + value);
    }

    /**
     * Decrements the x coordinate
     * of this {@code GameElement}
     * by the amount specified by
     * the {@code value} argument.
     * 
     * @param value the amount to
     * decrement the x by
     */
    public void decreaseX(int value) {
        setX(x - value);
    }

    /**
     * Returns the x coordinate of this
     * {@code GameElement}.
     * 
     * @return the x coordinate
     */
    public int getX() {
        return this.x;
    }

    /**
     * Sets the y coordinate of this
     * {@code GameElement}.
     * 
     * @param y the y coordinate
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Increments the y coordinate
     * of this {@code GameElement}
     * by the amount specified by
     * the {@code value} argument.
     * 
     * @param value the amount to
     * increment the y by
     */
    public void increaseY(int value) {
        setY(y + value);
    }

    /**
     * Decrements the y coordinate
     * of this {@code GameElement}
     * by the amount specified by
     * the {@code value} argument.
     * 
     * @param value the amount to
     * decrement the y by
     */
    public void decreaseY(int value) {
        setY(y - value);
    }

    /**
     * Returns the y coordinate of this
     * {@code GameElement}.
     * 
     * @return the y coordinate
     */
    public int getY() {
        return this.y;
    }

    /**
     * Sets the x and y coordinates of this
     * {@code GameElement}.
     * 
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public void setCoordinates(int x, int y) {
        setX(x);
        setY(y);
    }

    /**
     * Sets the width of this {@code GameElement}
     * if the passed {@code width} is not negative.
     * If it is negative, throws an exception.
     * 
     * @param width the width to be set
     * 
     * @throws IllegalArgumentException if the
     * {@code width} parameter is {@code null}.
     */
    public void setWidth(int width) {
        if(width < 0) {
            throw new IllegalArgumentException("cannot set width to " + width + " (negative width)");
        }
        
        this.width = width;
    }

    /**
     * Returns the width of this {@code GameElement}.
     * 
     * @return the width dimension
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * Sets the height of this {@code GameElement}
     * if the passed {@code height} is not negative.
     * If it is negative, throws an exception.
     * 
     * @param height the height to be set
     * 
     * @throws IllegalArgumentException if the
     * {@code height} parameter is {@code null}.
     */
    public void setHeight(int height) {
        if(height < 0) {
            throw new IllegalArgumentException("cannot set height to " + height + " (negative height)");
        }
        
        this.height = height;
    }

    /**
     * Returns the height of this {@code GameElement}.
     * 
     * @return the height dimension
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * Sets the width and height of this {@code GameElement},
     * respectively, if they are not negative. If one of
     * the arguments is negative, an exception will be
     * thrown.
     * 
     * @param width the width to be set
     * @param height the height to be set
     * 
     * @throws IllegalArgumentException if one of the
     * parameters is negative
     */
    public void setSize(int width, int height) {
        setWidth(width);
        setHeight(height);
    }

    /**
     * Returns the y coordinate of
     * the top boundary of
     * this {@code GameElement}.
     * 
     * @return the top coordinate
     */
    public int getTop() {
        return y;
    }

    /**
     * Returns the x coordinate of
     * the right boundary of
     * this {@code GameElement}.
     * 
     * @return the right coordinate
     */
    public int getRight() {
        return x + width;
    }

    /**
     * Returns the y coordinate of
     * the bottom boundary of
     * this {@code GameElement}.
     * 
     * @return the bottom coordinate
     */
    public int getBottom() {
        return y + height;
    }

    /**
     * Returns the x coordinate of
     * the left boundary of
     * this {@code GameElement}.
     * 
     * @return the left coordinate
     */
    public int getLeft() {
        return x;
    }

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
     * be used by this {@code GameElement}.
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
     * this {@code GameElement}.
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
     * Sets the column of this {@code GameElement}'s
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
     * of this {@code GameElement}'s
     * {@code SpriteSheet}.
     */
    public void nextFrameX() {
        if(frameManager != null) {
            frameManager.nextFrameX();
        }
    }

    /**
     * Selects the previous frame on the x axis
     * of this {@code GameElement}'s
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
     * Sets the row of this {@code GameElement}'s
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
     * of this {@code GameElement}'s
     * {@code SpriteSheet}.
     */
    public void nextFrameY() {
        if(frameManager != null) {
            frameManager.nextFrameY();
        }
    }

    /**
     * Selects the previous frame on the y axis
     * of this {@code GameElement}'s
     * {@code SpriteSheet}.
     */
    public void previousFrameY() {
        if(frameManager != null) {
            frameManager.previousFrameY();
        }
    }

    /**
     * Returns the row of this {@code GameElement}'s
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
     * {@code GameElement}'s {@code SpriteSheet}.
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
     * Sets the speed on the x axis of
     * this {@code GameElement} to
     * the passed {@code xSpeed}.
     * 
     * @param xSpeed the speed to be set
     */
    public void setXSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    /**
     * Increments the speed on the x axis of
     * this {@code GameElement} by the value
     * specified by the {@code value} argument.
     * 
     * @param value the value to
     * increment the x speed by
     */
    public void increaseXSpeed(int value) {
        setXSpeed(xSpeed + value);
    }

    /**
     * Decrements the speed on the x axis of
     * this {@code GameElement} by the value
     * specified by the {@code value} argument.
     * 
     * @param value the value to
     * decrement the x speed by
     */
    public void decreaseXSpeed(int value) {
        setXSpeed(xSpeed - value);
    }

    /**
     * Returns the speed of this
     * {@code GameElement} on
     * the x axis.
     * 
     * @return the x speed
     */
    public int getXSpeed() {
        return this.xSpeed;
    }

    /**
     * Sets the speed on the y axis of
     * this {@code GameElement} to
     * the passed {@code ySpeed}.
     * 
     * @param ySpeed the speed to be set
     */
    public void setYSpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }

    /**
     * Increments the speed on the y axis of
     * this {@code GameElement} by the value
     * specified by the {@code value} argument.
     * 
     * @param value the value to
     * increment the y speed by
     */
    public void increaseYSpeed(int value) {
        setYSpeed(ySpeed + value);
    }

    /**
     * Decrements the speed on the y axis of
     * this {@code GameElement} by the value
     * specified by the {@code value} argument.
     * 
     * @param value the value to
     * decrement the y speed by
     */
    public void decreaseYSpeed(int value) {
        setYSpeed(ySpeed - value);
    }

    /**
     * Returns the speed of this
     * {@code GameElement} on
     * the y axis.
     * 
     * @return the y speed
     */
    public int getYSpeed() {
        return this.ySpeed;
    }

}