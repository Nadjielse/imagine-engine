package ig.stage;

import ig.game.Game;

/**
 * Super class for stage elements like
 * game objects, scenarios or cameras.
 * 
 * @author Daniel O Sousa
 */
public abstract class StageElement {

    /**
     * The stage where this
     * element is used.
     */
    private Stage stage;

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
     * The speed on the x axis.
     */
    private int xSpeed = 0;

    /**
     * The speed on the y axis.
     */
    private int ySpeed = 0;

    /**
     * Sets the stage of this
     * {@code StageElement}.
     * 
     * @param stage the stage to be set
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * Returns the stage of this
     * {@code StageElement}.
     * 
     * @return the stage of this
     * {@code StageElement}
     */
    public Stage getStage() {
        return this.stage;
    }

    /**
     * Returns the width of the {@code Stage}
     * of this {@code StageElement}.
     * 
     * @return the width of the {@code Stage}
     */
    public int getStageWidth() {
        if(stage != null) {
            return stage.getWidth();
        } else {
            return 0;
        }
    }

    /**
     * Returns the height of the {@code Stage}
     * of this {@code StageElement}.
     * 
     * @return the height of the {@code Stage}
     */
    public int getStageHeight() {
        if(stage != null) {
            return stage.getHeight();
        } else {
            return 0;
        }
    }

    /**
     * Returns the game associated
     * with this {@code StageElement}.
     * 
     * @return the game of this
     * {@code StageElement}
     */
    public Game getGame() {
        if(stage != null) {
            return stage.getGame();
        } else {
            return null;
        }
    }

    /**
     * Returns the width of the panel
     * where this {@code StageElement}
     * would be exhibited.
     * 
     * @return the game panel width
     */
    public int getGamePanelWidth() {
        if(getGame() != null) {
            return getGame().getGamePanelWidth();
        } else {
            return 0;
        }
    }

    /**
     * Returns the height of the panel
     * where this {@code StageElement}
     * would be exhibited.
     * 
     * @return the game panel height
     */
    public int getGamePanelHeight() {
        if(getGame() != null) {
            return getGame().getGamePanelHeight();
        } else {
            return 0;
        }
    }

    /**
     * Sets the x coordinate of this
     * {@code StageElement}.
     * 
     * @param x the x coordinate
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Increments the x coordinate
     * of this {@code StageElement}
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
     * of this {@code StageElement}
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
     * {@code StageElement}.
     * 
     * @return the x coordinate
     */
    public int getX() {
        return this.x;
    }

    /**
     * Sets the y coordinate of this
     * {@code StageElement}.
     * 
     * @param y the y coordinate
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Increments the y coordinate
     * of this {@code StageElement}
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
     * of this {@code StageElement}
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
     * {@code StageElement}.
     * 
     * @return the y coordinate
     */
    public int getY() {
        return this.y;
    }

    /**
     * Sets the x and y coordinates of this
     * {@code StageElement}.
     * 
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public void setCoordinates(int x, int y) {
        setX(x);
        setY(y);
    }

    /**
     * Sets the width of this {@code StageElement}
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
     * Returns the width of this {@code StageElement}.
     * 
     * @return the width dimension
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * Sets the height of this {@code StageElement}
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
     * Returns the height of this {@code StageElement}.
     * 
     * @return the height dimension
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * Sets the width and height of this {@code StageElement},
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
     * this {@code StageElement}.
     * 
     * @return the top coordinate
     */
    public int getTop() {
        return y;
    }

    /**
     * Returns the x coordinate of
     * the right boundary of
     * this {@code StageElement}.
     * 
     * @return the right coordinate
     */
    public int getRight() {
        return x + width;
    }

    /**
     * Returns the y coordinate of
     * the bottom boundary of
     * this {@code StageElement}.
     * 
     * @return the bottom coordinate
     */
    public int getBottom() {
        return y + height;
    }

    /**
     * Returns the x coordinate of
     * the left boundary of
     * this {@code StageElement}.
     * 
     * @return the left coordinate
     */
    public int getLeft() {
        return x;
    }

    /**
     * Sets the speed on the x axis of
     * this {@code StageElement} to
     * the passed {@code xSpeed}.
     * 
     * @param xSpeed the speed to be set
     */
    public void setXSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    /**
     * Increments the speed on the x axis of
     * this {@code StageElement} by the value
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
     * this {@code StageElement} by the value
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
     * {@code StageElement} on
     * the x axis.
     * 
     * @return the x speed
     */
    public int getXSpeed() {
        return this.xSpeed;
    }

    /**
     * Sets the speed on the y axis of
     * this {@code StageElement} to
     * the passed {@code ySpeed}.
     * 
     * @param ySpeed the speed to be set
     */
    public void setYSpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }

    /**
     * Increments the speed on the y axis of
     * this {@code StageElement} by the value
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
     * this {@code StageElement} by the value
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
     * {@code StageElement} on
     * the y axis.
     * 
     * @return the y speed
     */
    public int getYSpeed() {
        return this.ySpeed;
    }

}