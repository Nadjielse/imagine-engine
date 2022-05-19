package ig.sprite;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;

public class SpriteSheet {

    private String path;
    private BufferedImage img;
    private int rows = 1;
    private int columns = 1;
    private int gap = 0;
    private int spriteWidth;
    private int spriteHeight;

    public SpriteSheet(String path) {
        this.path = path;
        load();
    }

    public SpriteSheet(String path, int rows, int columns) {
        this.path = path;
        this.rows = rows;
        this.columns = columns;
        load();
    }

    public SpriteSheet(String path, int rows, int columns, int gap) {
        this.path = path;
        this.rows = rows;
        this.columns = columns;
        setGap(gap);
        load();
    }

    public void setGap(int gap) {
        if(gap >= 0) {
            this.gap = gap;
        }
    }

    public int getGap() {
        return this.gap;
    }

    public void load() {
        try {
            img = ImageIO.read(getClass().getResourceAsStream(path));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void updateDimensions() {
        updateWidth();
        updateHeight();
    }

    public void updateWidth() {
        spriteWidth = img.getWidth() / columns;
    }

    public void updateHeight() {
        spriteHeight = img.getHeight() / rows;
    }

}