package imagine.sprite;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;

/**
 * A class that instantiates and loads a sprite.
 * 
 * @author Daniel O Sousa
 */
public class Sprite {
    
    /**
     * The path to where the sprite image file is.
     */
    private String path;

    /**
     * The loaded sprite image.
     */
    private BufferedImage img;

    /**
     * Constructs a {@code Sprite}, loading its image from
     * where the {@code path} specifies.
     * <p>
     * The {@code path} takes into account that it will start from
     * the folder where the library is stored.
     * 
     * @param path the path to where the sprite image is
     */
    public Sprite(String path) {
        storePath(path);
        load();
    }
    
    /**
     * Constructs a {@code Sprite}, storing the passed
     * image as its image.
     * 
     * @param image the image of the new sprite
     */
    public Sprite(BufferedImage image) {
        storeImage(image);
    }

    /**
     * Stores the {@code path}, if it isn't
     * {@code null}, of this sprite's image.
     * 
     * @param path the new path for this sprite
     * 
     * @throws IllegalArgumentException if the
     * {@code path} argument is {@code null}
     */
    private void storePath(String path) {
        if(path == null) {
            throw new IllegalArgumentException (
                "cannot store null path"
            );
        }

        this.path = path;
    }
    
    /**
     * Returns the path to this sprite's image.
     * <p>
     * If it is {@code null} that means that the
     * image was passed directly to the constructor
     * without specifying its {@code path}.
     * 
     * @return the path to this sprite's image
     */
    public String getPath() {
        return this.path;
    }

    /**
     * Stores the image {@code img}, if it isn't
     * {@code null}, to be used in this sprite.
     * 
     * @param img this sprite's image
     * 
     * @throws IllegalArgumentException if the
     * {@code img} argument is {@code null}
     */
    private void storeImage(BufferedImage img) {
        if(img == null) {
            throw new IllegalArgumentException (
                "cannot store null image"
            );
        }

        this.img = img;
    }
    
    /**
     * Returns the image of this sprite.
     * 
     * @return this sprite's image
     */
    public BufferedImage getImage() {
        return this.img;
    }

    /**
     * Returns this sprite's width in pixels.
     * 
     * @return this sprite's width
     */
    public int getWidth() {
        return img.getWidth();
    }

    /**
     * Returns this sprite's height in pixels.
     * 
     * @return this sprite's height
     */
    public int getHeight() {
        return img.getHeight();
    }
    
    /**
     * Loads this sprite's image and saves it into
     * the {@code img} property.
     */
    private void load() {
        try {
            img = ImageIO.read(getClass().getResourceAsStream("./../../" + path));
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
    
}