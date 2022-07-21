package imagine.game;

/**
 * Class to represent a generic
 * {@code GameElement}.
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
            throw new IllegalArgumentException (
                "cannot set width to " + width +
                " (negative width)"
            );
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
            throw new IllegalArgumentException (
                "cannot set height to " + height +
                " (negative height)"
            );
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

}