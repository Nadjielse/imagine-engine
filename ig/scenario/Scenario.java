package ig.scenario;

import java.awt.Graphics2D;

import ig.stage.AnimatableStageElement;
import ig.flow.GameFluid;
import ig.stage.Stage;
import ig.sprite.SpriteSheet;
import ig.game.Game;

public abstract class Scenario extends AnimatableStageElement implements GameFluid {

    private Stage stage;
    private int xParallaxSpeed = 100;
    private int yParallaxSpeed = 100;
    private boolean repeatX = true;
    private boolean repeatY = true;

    public Scenario(SpriteSheet spriteSheet) {
        setCoordinates(0, 0);
        setSize(spriteSheet.getSpriteWidth(), spriteSheet.getSpriteHeight());
        setSpriteSheet(spriteSheet);
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Stage getStage() {
        return this.stage;
    }

    public Game getGame() {
        if(getStage() == null) {
            return null;
        } else {
            return getStage().getGame();
        }
    }

    public void setXParallaxSpeed(int xParallaxSpeed) {
        this.xParallaxSpeed = xParallaxSpeed;
    }

    public int getXParallaxSpeed() {
        return this.xParallaxSpeed;
    }

    public void setYParallaxSpeed(int yParallaxSpeed) {
        this.yParallaxSpeed = yParallaxSpeed;
    }

    public int getYParallaxSpeed() {
        return this.yParallaxSpeed;
    }

    public void setRepeatX(boolean repeatX) {
        this.repeatX = repeatX;
    }

    public boolean getRepeatX() {
        return this.repeatX;
    }

    public void setRepeatY(boolean repeatY) {
        this.repeatY = repeatY;
    }

    public boolean getRepeatY() {
        return this.repeatY;
    }

    public boolean isVisible() {
        if(getGame() == null) {
            return false;
        }

        if (
            getBottom() > 0 &&
            getTop() < getGame().getGamePanelHeight() &&
            getLeft() < getGame().getGamePanelWidth() &&
            getRight() > 0
        ) {
            return true;
        }

        if (
            getRepeatX() &&
            getBottom() > 0 &&
            getTop() < getGame().getGamePanelHeight()
        ) {
            return true;
        }

        if (
            getRepeatY() &&
            getLeft() < getGame().getGamePanelWidth() &&
            getRight() > 0
        ) {
            return true;
        }

        return false;
    }

    @Override
    public void start() {

        onStart();
    }

    public abstract void onStart();

    @Override
    public void update() {
        increaseX(getXSpeed());
        increaseY(getYSpeed());

        onUpdate();
    }
    
    public abstract void onUpdate();

    @Override
    public void draw(Graphics2D g2) {

        // Draw will occur only if the game is accessible,
        // and the scenario is inside the game panel or is
        // horizontally aligned with repeatX true or is
        // vertically aligned with repeatY true
        if(!isVisible()) {
            onDraw(g2);
            return;
        }
        if(getWidth() == 0 || getHeight() == 0) {
            onDraw(g2);
            return;
        }

        // IF REPEATX AND REPEATY ARE TRUE
        int drawingY = getY() <= 0 ? getY() % getHeight() : getY() % getHeight() - getHeight();
        while(drawingY < getGame().getGamePanelHeight()) {
            int drawingX = getX() <= 0 ? getX() % getWidth() : getX() % getWidth() - getWidth();
            while(drawingX < getGame().getGamePanelWidth()) {
                g2.drawImage (
                    getCurrentFrame().getImage(),
                    drawingX,
                    drawingY,
                    getWidth(),
                    getHeight(),
                    null
                );
                drawingX += getWidth();
            }
            drawingY += getHeight();
        }

        onDraw(g2);
    }
    
    public abstract void onDraw(Graphics2D g2);

}