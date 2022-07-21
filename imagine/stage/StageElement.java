package imagine.stage;

import imagine.game.Game;
import imagine.game.GameElement;

/**
 * Super class for stage elements like
 * game objects, scenarios or cameras.
 * 
 * @author Daniel O Sousa
 */
public abstract class StageElement extends GameElement {

    /**
     * The stage where this
     * element is used.
     */
    private Stage stage;

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

    /**
     * Generic code for moving this
     * {@code StageElement} according
     * to its speed.
     */
    public void move() {
        increaseX(xSpeed);
        increaseY(ySpeed);
    }

}