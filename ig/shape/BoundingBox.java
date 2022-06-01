package ig.shape;

/**
 * Class for creating a bounding box
 * represented by its boundaries coordinates
 * (top, right, bottom and left)
 * 
 * @author Daniel O Sousa
 */
public class BoundingBox {

    /**
     * The coordinate of the top boundary of
     * this {@code BoundingBox}
     */
    private int top;

    /**
     * The coordinate of the right boundary of
     * this {@code BoundingBox}
     */
    private int right;

    /**
     * The coordinate of the bottom boundary of
     * this {@code BoundingBox}
     */
    private int bottom;

    /**
     * The coordinate of the left boundary of
     * this {@code BoundingBox}
     */
    private int left;

    /**
     * Constructor for a {@code BoundingBox}
     * instance that takes the {@code top},
     * {@code right}, {@code bottom} and {@code left}
     * arguments as its boundaries coordinates.
     * 
     * @param top the top coordinate
     * @param right the right coordinate
     * @param bottom the bottom coordinate
     * @param left the left coordinate
     */
    public BoundingBox(int top, int right, int bottom, int left) {
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        this.left = left;

        if(this.top > this.bottom) {
            int aux = this.top;
            this.top = this.bottom;
            this.bottom = aux;
        }
        if(this.right < this.left) {
            int aux = this.right;
            this.right = this.left;
            this.left = aux;
        }
    }

    /**
     * Sets this {@code BoundingBox} top
     * boundary coordinate with the passed
     * {@code top} argument.
     * 
     * @param top the top coordinate
     */
    public void setTop(int top) {
        if(top <= this.bottom) {
            this.top = top;
        } else {
            int height = this.bottom - this.top;
            this.top = top;
            this.bottom = this.top + height;
        }
    }

    /**
     * Returns this {@code BoundingBox}
     * current top boundary coordinate.
     * 
     * @return the top coordinate
     */
    public int getTop() {
        return this.top;
    }

    /**
     * Sets this {@code BoundingBox} right
     * boundary coordinate with the passed
     * {@code right} argument.
     * 
     * @param right the right coordinate
     */
    public void setRight(int right) {
        if(right >= this.left) {
            this.right = right;
        } else {
            int width = this.right - this.left;
            this.right = right;
            this.left = this.right - width;
        }
    }

    /**
     * Returns this {@code BoundingBox}
     * current right boundary coordinate.
     * 
     * @return the right coordinate
     */
    public int getRight() {
        return this.right;
    }

    /**
     * Sets this {@code BoundingBox} bottom
     * boundary coordinate with the passed
     * {@code bottom} argument.
     * 
     * @param bottom the bottom coordinate
     */
    public void setBottom(int bottom) {
        if(bottom >= this.top) {
            this.bottom = bottom;
        } else {
            int height = this.bottom - this.top;
            this.bottom = bottom;
            this.top = this.bottom - height;
        }
    }

    /**
     * Returns this {@code BoundingBox}
     * current bottom boundary coordinate.
     * 
     * @return the bottom coordinate
     */
    public int getBottom() {
        return this.bottom;
    }

    /**
     * Sets this {@code BoundingBox} left
     * boundary coordinate with the passed
     * {@code left} argument.
     * 
     * @param left the left coordinate
     */
    public void setLeft(int left) {
        if(left <= this.right) {
            this.left = left;
        } else {
            int width = this.right - this.left;
            this.left = left;
            this.right = this.left + width;
        }
    }

    /**
     * Returns this {@code BoundingBox}
     * current left boundary coordinate.
     * 
     * @return the left coordinate
     */
    public int getLeft() {
        return this.left;
    }

    @Override
    public String toString() {
        return "{ " + "top: " + top + ", " + "right: " + right + ", " + "bottom: " + bottom + ", " + "left: " + left + " }";
    }
    
}