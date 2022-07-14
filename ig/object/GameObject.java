package ig.object;

import java.awt.Color;
import java.awt.Graphics2D;

import ig.stage.AnimatableStageElement;
import ig.flow.GameFluid;
import ig.sprite.SpriteSheet;

/**
 * Class for creating game objects.
 * 
 * @author Daniel O Sousa
 */
public abstract class GameObject extends AnimatableStageElement implements GameFluid {

    /**
     * The color with which this {@code GameObject}
     * will be drawn if it is configured to do so by the
     * {@code showBoudingBox} attribute set to
     * {@code true}. This color is initially set to transparent.
     */
    private Color color = new Color(255, 255, 255, 0);

    /**
     * Determines if the bounding box of this
     * {@code GameObject} will be drawn onscreen.
     * If set to {@code true}, the bounding box
     * will be drawn with the color specified by
     * the {@code color} attribute.
     * <p>
     * Initially, this attribute is set to {@code false}.
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
        setSpriteSheet(spriteSheet);
        setCoordinates(x, y);
        setSize(width, height);
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
     * @param showSprite a {@code boolean} specifying
     * if the sprite will be drawn
     */
    public void setShowSprite(boolean showSprite) {
        this.showSprite = showSprite;
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
     * @param showBoundingBox a {@code boolean} specifying
     * if the bounding box will be drawn
     */
    public void setShowBoundingBox(boolean showBoundingBox) {
        this.showBoundingBox = showBoundingBox;
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
     * Returns the apparent x coordinate of
     * this {@code GameObject} when taking into
     * account the camera position.
     * 
     * @return the apparent x coordinate
     */
    public int getApparentX() {
        return getX() - getCameraX();
    }

    /**
     * Returns the apparent y coordinate of
     * this {@code GameObject} when taking into
     * account the camera position.
     * 
     * @return the apparent y coordinate
     */
    public int getApparentY() {
        return getY() - getCameraY();
    }

    /**
     * Returns the apparent y coordinate of
     * the top boundary of this {@code GameObject}
     * when taking into account the camera position.
     * 
     * @return the apparent top coordinate
     */
    public int getApparentTop() {
        return getTop() - getCameraY();
    }

    /**
     * Returns the apparent x coordinate of
     * the right boundary of this {@code GameObject}
     * when taking into account the camera position.
     * 
     * @return the apparent right coordinate
     */
    public int getApparentRight() {
        return getRight() - getCameraX();
    }

    /**
     * Returns the apparent y coordinate of
     * the bottom boundary of this {@code GameObject}
     * when taking into account the camera position.
     * 
     * @return the apparent bottom coordinate
     */
    public int getApparentBottom() {
        return getBottom() - getCameraY();
    }

    /**
     * Returns the apparent x coordinate of
     * the left boundary of this {@code GameObject}
     * when taking into account the camera position.
     * 
     * @return the apparent left coordinate
     */
    public int getApparentLeft() {
        return getLeft() - getCameraX();
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
            g2.fillRect (
                getApparentX(), getApparentY(),
                getWidth(), getHeight()
            );
        }
        if(showSprite && getSpriteSheet() != null) {
            g2.drawImage (
                getCurrentFrame().getImage(),
                getApparentX(), getApparentY(),
                getWidth(), getHeight(),
                null
            );
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