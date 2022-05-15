package ig;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.Graphics2D;

/**
 * Abstract class that should be extended
 * for creating a tile.
 * <p>
 * A class that extends this one should call the
 * superconstructor and pass the {@code x} and
 * {@code y} parameters.
 * 
 * @author Daniel O Sousa
 */
public abstract class Tile {

    /**
     * The game from which this tile is.
     */
    private Game game;

    /**
     * The path for this tile's sprite.
     */
    public String path;

    /**
     * This tile's sprite.
     */
    public BufferedImage sprite;

    /**
     * The size with which this tile will
     * be drawn.
     */
    public int size;

    /**
     * This tile's x coordinate.
     */
    public int x;

    /**
     * This tile's y coordinate.
     */
    public int y;

    /**
     * Stores the x and y coordinates
     * {@code x} and {@code y}
     * 
     * @param x The x coordinate.
     * @param y The y coordinate.
     */
    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Sets this tile's game and updates
     * its tile size to be the same as the
     * game's.
     * 
     * @param game The game from which this tile
     * is
     */
    public void setGame(Game game) {
        this.game = game;
        this.size = game.getTileSize();
    }

    /**
     * Returns the game from which this tile
     * is.
     * 
     * @return the game from which this tile is
     */
    public Game getGame() {
        return this.game;
    }

    /**
     * Sets the path from where to load this
     * tile's sprite and also loads it.
     * 
     * @param path this tile's sprite path
     */
    public void setPath(String path) {
        this.path = path;
        readSprite();
    }

    /**
     * Returns the path which leads to this
     * tile's sprite.
     * 
     * @return the path to the sprite of this tile
     */
    public String getPath() {
        return this.path;
    }

    /**
     * Sets the size of this tile.
     * 
     * @param size the new size for this tile
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Returns this tile's size.
     * 
     * @return this tile's size
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Saves the sprite which is at the {@code path}
     * property of this tile.
     * <p>
     * The sprite is saved in a {@code BufferedImage}
     * format.
     */
    public void readSprite() {
        try {
            sprite = ImageIO.read(getClass().getResourceAsStream(path));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Draws this tile on the {@code GamePanel}
     * using the {@code Graphics2D}
     * {@code drawImage} method.
     * 
     * @param g2 The {@code Graphics2D} instance
     *           obtained from the {@code GamePanel}
     *           {@code repaint} method
     */
    public void draw(Graphics2D g2) {
        g2.drawImage(sprite, x, y, size, size, null);
    }

}