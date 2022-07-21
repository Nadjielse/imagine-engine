package imagine.scenario;

import java.awt.Graphics2D;

import imagine.stage.AnimatableStageElement;
import imagine.flow.GameFluid;
import imagine.scenario.type.*;
import imagine.sprite.SpriteSheet;

/**
 * Class for creating and customizing
 * scenarios for stages.
 * 
 * @author Daniel O Sousa
 */
public abstract class Scenario extends AnimatableStageElement implements GameFluid {

    /**
     * The speed with which the scenario will
     * appear to move to one side when the camera
     * moves to the opposite side in a horizontal
     * direction.
     * <p>
     * This property has a default value of {@code 100},
     * which means that the scenario will appear to
     * move as fast to one side as the camera moves to
     * the other.
     */
    private int xParallaxSpeed = 100;

    /**
     * The speed with which the scenario will
     * appear to move to one side when the camera
     * moves to the opposite side in a vertical
     * direction.
     * <p>
     * This property has a default value of {@code 100},
     * which means that the scenario will appear to
     * move as fast to one side as the camera moves to
     * the other.
     */
    private int yParallaxSpeed = 100;

    /**
     * The type of scenario which specifies
     * how it is drawn.
     */
    private ScenarioType type;

    /**
     * Constructs a {@code Scenario} which will
     * have the specified {@code spriteSheet}.
     * This {@code Scenario} will also have the
     * coordinates default to {@code 0} and dimensions
     * default to the dimensions of the frames of
     * its sprite sheet. By default, the created
     * {@code Scenario} will be configured to repeat
     * in the x and y axis to fill the {@code GamePanel}.
     * 
     * @param spriteSheet the {@code SpriteSheet}
     * of this {@code Scenario}
     */
    public Scenario(SpriteSheet spriteSheet) {
        setSpriteSheet(spriteSheet);
        setCoordinates(0, 0);
        if(spriteSheet != null) {
            setSize (
                spriteSheet.getSpriteWidth(),
                spriteSheet.getSpriteHeight()
            );
        }
        setTypeRepeatXY();
    }

    /**
     * Sets the speed with which this {@code Scenario}
     * will appear to move on the x axis when compared to
     * the speed of the camera.
     * 
     * @param xParallaxSpeed the speed to be set
     */
    public void setXParallaxSpeed(int xParallaxSpeed) {
        this.xParallaxSpeed = xParallaxSpeed;
    }

    /**
     * Returns the speed with which the parallax
     * effect is done by this {@code Scenario} on
     * the x axis.
     * 
     * @return the parallax speed on the x axis
     */
    public int getXParallaxSpeed() {
        return this.xParallaxSpeed;
    }

    /**
     * Sets the speed with which this {@code Scenario}
     * will appear to move on the y axis when compared to
     * the speed of the camera.
     * 
     * @param yParallaxSpeed the speed to be set
     */
    public void setYParallaxSpeed(int yParallaxSpeed) {
        this.yParallaxSpeed = yParallaxSpeed;
    }

    /**
     * Returns the speed with which the parallax
     * effect is done by this {@code Scenario} on
     * the y axis.
     * 
     * @return the parallax speed on the y axis
     */
    public int getYParallaxSpeed() {
        return this.yParallaxSpeed;
    }

    /**
     * Sets the type of this {@code Scenario} to
     * the passed {@code type}, which cannot be {@code null}.
     * 
     * @param type the type to be set
     */
    public void setType(ScenarioType type) {
        if(type == null) {
            throw new IllegalArgumentException("type cannot be null");
        }

        this.type = type;
    }

    /**
     * Sets the type of this {@code Scenario}
     * to "no repeat", which means that it won't
     * repeat itself to fill the {@code GamePanel}.
     */
    public void setTypeNoRepeat() {
        setType(new NoRepeat(this));
    }

    /**
     * Sets the type of this {@code Scenario}
     * to "repeat x", which means that it will
     * repeat itself to fill the {@code GamePanel}
     * only on the x axis.
     */
    public void setTypeRepeatX() {
        setType(new RepeatX(this));
    }

    /**
     * Sets the type of this {@code Scenario}
     * to "repeat y", which means that it will
     * repeat itself to fill the {@code GamePanel}
     * only on the y axis.
     */
    public void setTypeRepeatY() {
        setType(new RepeatY(this));
    }

    /**
     * Sets the type of this {@code Scenario}
     * to "repeat x y", which means that it will
     * repeat itself to fill the {@code GamePanel}
     * on the x and y axis.
     */
    public void setTypeRepeatXY() {
        setType(new RepeatXY(this));
    }

    /**
     * Returns the type of this {@code Scenario}.
     * 
     * @return the type of this {@code Scenario}
     */
    public String getType() {
        return this.type.getName();
    }

    /**
     * Returns the apparent x coordinate of
     * this {@code Scenario} when taking into
     * account the camera position.
     * 
     * @return the apparent x coordinate
     */
    public int getApparentX() {
        return getX() - getCameraX() * xParallaxSpeed / 100;
    }

    /**
     * Returns the apparent y coordinate of
     * this {@code Scenario} when taking into
     * account the camera position.
     * 
     * @return the apparent y coordinate
     */
    public int getApparentY() {
        return getY() - getCameraY() * yParallaxSpeed / 100;
    }

    /**
     * Calls the {@code onStart()} method.
     * 
     * @see #onStart()
     */
    @Override
    public void start() {

        onStart();
    }

    /**
     * Method used to define what should
     * happen once this {@code Scenario}
     * starts.
     */
    public abstract void onStart();

    /**
     * Increases the x and y coordinates
     * of this {@code Scenario} by its respective
     * speeds and calls the {@code onUpdate()}
     * method.
     * 
     * @see #onUpdate()
     */
    @Override
    public void update() {
        move();

        onUpdate();
    }
    
    /**
     * Method used to define what should
     * happen every time this {@code Scenario}
     * is updated.
     */
    public abstract void onUpdate();

    /**
     * Draws this {@code Scenario} according
     * to the {@code draw} method defined by
     * its type. Depending on the type, access
     * to the {@code Game} to which this {@code Scenario}
     * belongs may be needed for the drawing.
     * 
     * @param g2 a {@code Graphics2D} instance used
     * in the drawing
     */
    @Override
    public void draw(Graphics2D g2) {
        if(getCurrentFrame() == null) {
            onDraw(g2);
            return;
        }
        if(getWidth() == 0 || getHeight() == 0) {
            onDraw(g2);
            return;
        }

        type.draw(g2);

        onDraw(g2);
    }
    
    /**
     * Method used for defining what should
     * happen every time this {@code Scenario}
     * is drawn.
     * 
     * @param g2 a {@code Graphics2D} instance used
     * in the drawing
     */
    public abstract void onDraw(Graphics2D g2);

}