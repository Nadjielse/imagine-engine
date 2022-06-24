package ig.scenario;

import ig.game.GameElement;
import ig.sprite.SpriteSheet;

public class Scenario extends GameElement {

    private boolean repeatX = true;
    private boolean repeatY = true;

    // TODO constructor should not accept null spriteSheet
    public Scenario(SpriteSheet spriteSheet) {
        setCoordinates(0, 0);
        setSize(spriteSheet.getSpriteWidth(), spriteSheet.getSpriteHeight());
        setSpriteSheet(spriteSheet);
    }

    public Scenario(SpriteSheet spriteSheet, int width, int height) {
        setCoordinates(0, 0);
        setSize(width, height);
        setSpriteSheet(spriteSheet);
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

}