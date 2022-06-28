package ig.scenario;

import java.awt.Graphics2D;

import ig.stage.AnimatableStageElement;
import ig.flow.GameFluid;
import ig.scenario.type.*;
import ig.sprite.SpriteSheet;

public abstract class Scenario extends AnimatableStageElement implements GameFluid {

    private int xParallaxSpeed = 100;
    private int yParallaxSpeed = 100;
    private ScenarioType type;

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

    public void setType(ScenarioType type) {
        if(type == null) {
            throw new IllegalArgumentException("type cannot be null");
        }

        this.type = type;
    }

    public void setTypeNoRepeat() {
        setType(new NoRepeat(this));
    }

    public void setTypeRepeatX() {
        setType(new RepeatX(this));
    }

    public void setTypeRepeatY() {
        setType(new RepeatY(this));
    }

    public void setTypeRepeatXY() {
        setType(new RepeatXY(this));
    }

    public String getType() {
        return this.type.getName();
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
    
    public abstract void onDraw(Graphics2D g2);

}