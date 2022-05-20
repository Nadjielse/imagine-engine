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
        setSpriteDimensions();
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
        setRows(rows);
        setColumns(columns);
        setSpriteDimensions();
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
        setRows(rows);
        setColumns(columns);
        setGap(gap);
        setSpriteDimensions();
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
        setSpriteDimensions();
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
        setRows(rows);
        setColumns(columns);
        setSpriteDimensions();
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
        setRows(rows);
        setColumns(columns);
        setGap(gap);
        setSpriteDimensions();
        loadSprites();
    }

    /**
     * Sets the amount of rows for this {@code SpriteSheet}
     * if the passed {@code rows} argument is greater than
     * 0.
     * 
     * @param rows the amount of rows for this {@code SpriteSheet}
     * @see #getRows()
     */
    private void setRows(int rows) {
        if(rows > 0) {
            this.rows = rows;
        }
    }

    /**
     * Returns the amount of rows of this {@code SpriteSheet}.
     * 
     * @return the amount of rows of this {@code SpriteSheet}
     */
    public int getRows() {
        return this.rows;
    }

    /**
     * Sets the amount of columns for this {@code SpriteSheet}
     * if the passed {@code columns} argument is greater than
     * 0.
     * 
     * @param columns the amount of columns for this {@code SpriteSheet}
     * @see #getColumns()
     */
    private void setColumns(int columns) {
        if(columns > 0) {
            this.columns = columns;
        }
    }

    /**
     * Returns the amount of columns of this {@code SpriteSheet}.
     * 
     * @return the amount of columns of this {@code SpriteSheet}
     */
    public int getColumns() {
        return this.columns;
    }

    /**
     * Sets the size of the gap of pixels between each sprite
     * on this {@code SpriteSheet} image if the passed argument
     * is greater or equal to 0.
     * 
     * @param gap the distance between each sprite from this
     *            sprite sheet
     * @see #getGap()
     */
    private void setGap(int gap) {
        if(gap >= 0) {
            this.gap = gap;
        }
    }

    /**
     * Returns the distance in pixels between each sprite
     * on this sprite sheet.
     * 
     * @return the distance between each sprite from this
     *         sprite sheet
     */
    public int getGap() {
        return this.gap;
    }

    /**
     * Stores the width and height of this {@code SpriteSheet}'s
     * sprites into the {@code spriteWidth} and {@code spriteHeight}
     * properties.
     * 
     * @see #spriteWidth
     * @see #spriteHeight
     */
    private void setSpriteDimensions() {
        setSpriteWidth();
        setSpriteHeight();
    }

    /**
     * Stores the width of this {@code SpriteSheet}'s
     * sprites into the {@code spriteWidth} property.
     * 
     * @see #spriteWidth
     * @see #getSpriteWidth()
     */
    private void setSpriteWidth() {
        spriteWidth = (getWidth() - gap * (columns - 1)) / columns;
    }

    /**
     * Returns the width of the sprites of this {@code SpriteSheet}.
     * 
     * @return the width of the sprites of this {@code SpriteSheet}
     */
    public int getSpriteWidth() {
        return spriteWidth;
    }

    /**
     * Stores the height of this {@code SpriteSheet}'s
     * sprites into the {@code spriteHeight} property.
     * 
     * @see #spriteHeight
     * @see #getSpriteHeight()
     */
    private void setSpriteHeight() {
        spriteHeight = (getHeight() - gap * (rows - 1)) / rows;
    }

    /**
     * Returns the height of the sprites of this {@code SpriteSheet}.
     * 
     * @return the height of the sprites of this {@code SpriteSheet}
     */
    public int getSpriteHeight() {
        return spriteHeight;
    }

    /**
     * Returns a matrix storing this {@code SpriteSheet}'s
     * loaded {@code Sprite}s.
     * 
     * @return this {@code SpriteSheet}'s {@code Sprite}s
     */
    public Sprite[][] getSprites() {
        return sprites;
    }

    /**
     * Saves each sprite from this sprite sheet into a
     * {@code Sprite} instance and stores them into the
     * {@code sprites} property.
     * 
     * @see #sprites
     */
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