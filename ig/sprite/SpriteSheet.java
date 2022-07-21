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
     * Stores the width of the sprites from
     * this sprite sheet.
     */
    private int spriteWidth;

    /**
     * Stores the height of the sprites from
     * this sprite sheet.
     */
    private int spriteHeight;

    /**
     * Matrix that stores the sprites from this
     * sprite sheet separately.
     */
    private Sprite[][] sprites;

    /**
     * Creates a {@code SpriteSheet} instance which
     * will store the image found in the passed {@code path}.
     * <p>
     * The {@code path} parameter takes into account that it
     * starts from the folder where the package is stored.
     * 
     * @param path the path to the sprite sheet image file
     */
    public SpriteSheet(String path) {
        super(path);
        storeSpriteDimensions();
        loadSprites();
    }

    /**
     * Creates a {@code SpriteSheet} instance with the specified
     * number of rows {@code rows} and the specified number of
     * columns {@code columns}. The created {@code SpriteSheet}
     * will take its image from the passed {@code path} argument.
     * <p>
     * The {@code path} parameter takes into account that it
     * starts from the folder where the package is stored.
     * 
     * @param path the path to the sprite sheet image file
     * @param rows the number of rows of the sprite sheet
     * @param columns the number of columns of the sprite sheet
     */
    public SpriteSheet(String path, int rows, int columns) {
        super(path);
        storeRows(rows);
        storeColumns(columns);
        storeSpriteDimensions();
        loadSprites();
    }

    /**
     * Creates a {@code SpriteSheet} instance with the specified
     * number of rows {@code rows} and the specified number of
     * columns {@code columns}. This {@code SpriteSheet} will
     * have a gap of {@code gap} pixels between its sprites.
     * <p>
     * The sprite sheet image for this {@code SpriteSheet}
     * will be taken from the path {@code path}.
     * <p>
     * The {@code path} parameter takes into account that it
     * starts from the folder where the package is stored.
     * 
     * @param path the path to the sprite sheet image file
     * @param rows the number of rows of the sprite sheet
     * @param columns the number of columns of the sprite sheet
     * @param gap the number of pixels between each sprite from
     *            this sprite sheet
     */
    public SpriteSheet(String path, int rows, int columns, int gap) {
        super(path);
        storeRows(rows);
        storeColumns(columns);
        storeGap(gap);
        storeSpriteDimensions();
        loadSprites();
    }

    /**
     * Creates a {@code SpriteSheet} instance which
     * will store the image passed via the {@code image}
     * parameter.
     * 
     * @param image the sprite sheet image
     */
    public SpriteSheet(BufferedImage image) {
        super(image);
        storeSpriteDimensions();
        loadSprites();
    }

    /**
     * Creates a {@code SpriteSheet} instance with the specified
     * number of rows {@code rows} and the specified number of
     * columns {@code columns}. The created {@code SpriteSheet}
     * will take its image from the passed {@code image} argument.
     * 
     * @param image the sprite sheet image
     * @param rows the number of rows of this sprite sheet
     * @param columns the number of columns of this sprite sheet
     */
    public SpriteSheet(BufferedImage image, int rows, int columns) {
        super(image);
        storeRows(rows);
        storeColumns(columns);
        storeSpriteDimensions();
        loadSprites();
    }

    /**
     * Creates a {@code SpriteSheet} instance with the specified
     * number of rows {@code rows} and the specified number of
     * columns {@code columns}. This {@code SpriteSheet} will
     * have a gap of {@code gap} pixels between its sprites.
     * <p>
     * The sprite sheet image for this {@code SpriteSheet}
     * will be taken from the {@code image} parameter.
     * 
     * @param image the sprite sheet image
     * @param rows the number of rows of this sprite sheet
     * @param columns the number of columns of this sprite sheet
     * @param gap the distance in pixels between the sprites of this
     *            sprite sheet
     */
    public SpriteSheet(BufferedImage image, int rows, int columns, int gap) {
        super(image);
        storeRows(rows);
        storeColumns(columns);
        storeGap(gap);
        storeSpriteDimensions();
        loadSprites();
    }

    /**
     * Stores the amount of rows for this
     * {@code SpriteSheet} if the passed
     * {@code rows} argument is greater than
     * {@code 0}.
     * 
     * @param rows the amount of rows
     * for this {@code SpriteSheet}
     * 
     * @throws IllegalArgumentException if
     * the {@code rows} argument is less or
     * equal to {@code 0}
     */
    private void storeRows(int rows) {
        if(rows <= 0) {
            throw new IllegalArgumentException (
                "rows must be greater than 0"
            );
        }
        
        this.rows = rows;
    }

    /**
     * Returns the amount of rows
     * of this {@code SpriteSheet}.
     * 
     * @return the amount of rows
     * of this {@code SpriteSheet}
     */
    public int getRows() {
        return this.rows;
    }

    /**
     * Stores the amount of columns for this
     * {@code SpriteSheet} if the passed
     * {@code columns} argument is greater than
     * {@code 0}.
     * 
     * @param columns the amount of columns
     * for this {@code SpriteSheet}
     * 
     * @throws IllegalArgumentException if
     * the {@code columns} argument is less or
     * equal to {@code 0}
     */
    private void storeColumns(int columns) {
        if(columns <= 0) {
            throw new IllegalArgumentException (
                "columns must be greater than 0"
            );
        }
        
        this.columns = columns;
    }

    /**
     * Returns the amount of columns
     * of this {@code SpriteSheet}.
     * 
     * @return the amount of columns
     * of this {@code SpriteSheet}
     */
    public int getColumns() {
        return this.columns;
    }

    /**
     * Stores the size of the gap of pixels
     * between each sprite on this {@code SpriteSheet}
     * image if the passed argument is greater or
     * equal to {@code 0}.
     * 
     * @param gap the distance between each sprite
     * from this sprite sheet
     * 
     * @throws IllegalArgumentException if the
     * {@code gap} argument is negative
     */
    private void storeGap(int gap) {
        if(gap < 0) {
            throw new IllegalArgumentException (
                "gap cannot be negative"
            );
        }
        
        this.gap = gap;
    }

    /**
     * Returns the distance in
     * pixels between each sprite
     * on this sprite sheet.
     * 
     * @return the gap between
     * each sprite from this
     * sprite sheet
     */
    public int getGap() {
        return this.gap;
    }

    /**
     * Stores the width of this {@code SpriteSheet}'s
     * sprites into the {@code spriteWidth} property.
     */
    private void storeSpriteWidth() {
        this.spriteWidth = (getWidth() - gap * (columns - 1)) / columns;
    }

    /**
     * Returns the width of the sprites
     * of this {@code SpriteSheet}.
     * 
     * @return the width of the sprites
     * of this {@code SpriteSheet}
     */
    public int getSpriteWidth() {
        return this.spriteWidth;
    }

    /**
     * Stores the height of this {@code SpriteSheet}'s
     * sprites into the {@code spriteHeight} property.
     */
    private void storeSpriteHeight() {
        this.spriteHeight = (getHeight() - gap * (rows - 1)) / rows;
    }

    /**
     * Returns the height of the sprites
     * of this {@code SpriteSheet}.
     * 
     * @return the height of the sprites
     * of this {@code SpriteSheet}
     */
    public int getSpriteHeight() {
        return this.spriteHeight;
    }

    /**
     * Stores the width and height of this
     * {@code SpriteSheet}'s sprites into
     * the {@code spriteWidth} and
     * {@code spriteHeight} properties.
     */
    private void storeSpriteDimensions() {
        storeSpriteWidth();
        storeSpriteHeight();
    }

    /**
     * Saves each sprite from this sprite sheet
     * into a {@code Sprite} instance and stores
     * them into the {@code sprites} property.
     */
    private void loadSprites() {
        this.sprites = new Sprite[rows][columns];

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                sprites[i][j] = new Sprite (
                    getImage().getSubimage (
                        spriteWidth * j + gap * j,
                        spriteHeight * i + gap * i,
                        spriteWidth,
                        spriteHeight
                    )
                );
            }
        }
    }

    /**
     * Returns a matrix storing this
     * {@code SpriteSheet}'s loaded
     * {@code Sprite}s.
     * 
     * @return this {@code SpriteSheet}'s
     * {@code Sprite}s
     */
    public Sprite[][] getSprites() {
        return this.sprites;
    }

}