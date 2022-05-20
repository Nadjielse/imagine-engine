package ig.sprite;

import java.awt.image.BufferedImage;

/**
 * Class to instantiate a sprite sheet and load
 * its sprites separately.
 * 
 * @author Daniel O Sousa
 */
public class SpriteSheet extends Sprite {

    /**
     * Represents how many rows this sprite sheet
     * has.
     */
    private int rows = 1;

    /**
     * Represents how many columns this
     * sprite sheet has.
     */
    private int columns = 1;

    /**
     * Represents how big, in pixels, is the
     * gap between each sprite inside the
     * sprite sheet.
     */
    private int gap = 0;

    /**
     * Matrix that stores the sprites from this
     * sprite sheet separately.
     */
    private Sprite[][] sprites;

    /**
     * Stores the width of the sprites from
     * this sprite sheet.
     */
    private int spriteWidth;

    /**
     * Stores the height of the sprites from
     * this sprite sheet.
     */
    private int spriteHeight;


    public SpriteSheet(String path) {
        super(path);
        setSpriteDimensions();
        loadSprites();
    }

    public SpriteSheet(String path, int rows, int columns) {
        super(path);
        setRows(rows);
        setColumns(columns);
        setSpriteDimensions();
        loadSprites();
    }

    public SpriteSheet(String path, int rows, int columns, int gap) {
        super(path);
        setRows(rows);
        setColumns(columns);
        setGap(gap);
        setSpriteDimensions();
        loadSprites();
    }


    public SpriteSheet(BufferedImage image) {
        super(image);
        setSpriteDimensions();
        loadSprites();
    }

    public SpriteSheet(BufferedImage image, int rows, int columns) {
        super(image);
        setRows(rows);
        setColumns(columns);
        setSpriteDimensions();
        loadSprites();
    }

    public SpriteSheet(BufferedImage image, int rows, int columns, int gap) {
        super(image);
        setRows(rows);
        setColumns(columns);
        setGap(gap);
        setSpriteDimensions();
        loadSprites();
    }


    private void setRows(int rows) {
        if(rows > 0) {
            this.rows = rows;
        }
    }

    public int getRows() {
        return this.rows;
    }


    private void setColumns(int columns) {
        if(columns > 0) {
            this.columns = columns;
        }
    }

    public int getColumns() {
        return this.columns;
    }


    private void setGap(int gap) {
        if(gap >= 0) {
            this.gap = gap;
        }
    }

    public int getGap() {
        return this.gap;
    }

    
    private void setSpriteDimensions() {
        setSpriteWidth();
        setSpriteHeight();
    }


    private void setSpriteWidth() {
        spriteWidth = (getWidth() - gap * (columns - 1)) / columns;
    }

    public int getSpriteWidth() {
        return spriteWidth;
    }


    private void setSpriteHeight() {
        spriteHeight = (getHeight() - gap * (rows - 1)) / rows;
    }

    public int getSpriteHeight() {
        return spriteHeight;
    }


    public Sprite[][] getSprites() {
        return sprites;
    }


    private void loadSprites() {
        sprites = new Sprite[rows][columns];

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                sprites[i][j] = new Sprite (
                    getImage().getSubimage (
                        spriteWidth * i + gap * i,
                        spriteHeight * j + gap * j,
                        spriteWidth,
                        spriteHeight
                    )
                );
            }
        }
    }

}