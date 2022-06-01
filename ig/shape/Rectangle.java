package ig.shape;

/**
 * A class for constructing a rectangle with its x and y
 * coordinates and its width and height dimensions.
 * 
 * @author Daniel O Sousa
 */
public class Rectangle {

    /**
     * The x coordinate of this {@code Rectangle}.
     */
    private int x;

    /**
     * The y coordinate of this {@code Rectangle}.
     */
    private int y;

    /**
     * The width of this {@code Rectangle}.
     * <p>
     * This property must never be negative.
     */
    private int width;

    /**
     * The height of this {@code Rectangle}.
     * <p>
     * This property must never be negative.
     */
    private int height;

    /**
     * Constructs a {@code Rectangle} instance with
     * the passed {@code x}, {@code y}, {@code width}
     * and {@code height}.
     * 
     * @param x the x coordinate
     * @param y the y coordinate
     * @param width the width to be set
     * @param height the height to be set
     */
    public Rectangle(int x, int y, int width, int height) {
        setCoordinates(x, y);
        setSize(width, height);
    }

    /**
     * Sets the x coordinate of this {@code Rectangle}.
     * 
     * @param x the x coordinate
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Returns the x coordinate of this {@code Rectangle}.
     * 
     * @return the x coordinate
     */
    public int getX() {
        return this.x;
    }

    /**
     * Sets the y coordinate of this {@code Rectangle}.
     * 
     * @param y the y coordinate
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Returns the y coordinate of this {@code Rectangle}.
     * 
     * @return the y coordinate
     */
    public int getY() {
        return this.y;
    }

    /**
     * Sets the x and y coordinates of this {@code Rectangle}.
     * 
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public void setCoordinates(int x, int y) {
        setX(x);
        setY(y);
    }

    /**
     * Sets the x and y coordinates of this {@code Rectangle}.
     * 
     * @param point a {@code Point} instance informing
     *              the x and y coordinates
     */
    public void setCoordinates(Point point) {
        setCoordinates(point.getX(), point.getY());
    }

    /**
     * Sets the width of this {@code Rectangle}
     * if the passed {@code width} is greater
     * or equal to 0.
     * 
     * @param width the width to be set
     */
    public void setWidth(int width) {
        if(width >= 0) {
            this.width = width;
        }
    }

    /**
     * Returns the width of this {@code Rectangle}.
     * 
     * @return the width of this {@code Rectangle}
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * Sets the height of this {@code Rectangle}
     * if the passed {@code height} is greater
     * or equal to 0.
     * 
     * @param height the height to be set
     */
    public void setHeight(int height) {
        if(height >= 0) {
            this.height = height;
        }
    }

    /**
     * Returns the height of this {@code Rectangle}.
     * 
     * @return the height of this {@code Rectangle}
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * Sets the width of this {@code Rectangle}
     * if the passed {@code width} is greater
     * or equal to 0 and does the same
     * with the {@code height}.
     * 
     * @param width the width to be set
     * @param height the height to be set
     */
    public void setSize(int width, int height) {
        setWidth(width);
        setHeight(height);
    }

    /**
     * Returns a {@code BoundingBox} representation
     * of this {@code Rectangle}, with its top, right,
     * bottom and left boundaries coordinates.
     * 
     * @return this {@code Rectangle}'s bounding box
     */
    public BoundingBox getBoundingBox() {
        return new BoundingBox (
            this.y,
            this.x + this.width,
            this.y + this.height,
            this.x
        );
    }

    @Override
    public String toString() {
        return getBoundingBox().toString();
    }

}