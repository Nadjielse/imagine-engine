import javax.swing.JFrame;
import java.awt.Dimension;

/**
 * Abstract class for creating a new game.
 * <p>
 * To use this class you must extend it into
 * your own game class.
 * 
 * @author Daniel O Sousa
 */
public abstract class Game extends JFrame {

    /**
     * The {@code GamePanel} for displaying the game.
     */
    public GamePanel gamePanel = new GamePanel(this);

    /**
     * {@code GameFlow} for controlling the game frame rate.
     */
    public GameFlow gameFlow;

    /**
     * The size of the game's tiles.
     */
    public int tileSize;

    /**
     * Sets some basic configurations for this game, including
     * its title, its size (which defaults to 400 by 400 pixels)
     * and its {@code gamePanel}.
     */
    public Game() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Placeholder");
        add(gamePanel);
        setGameSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    /**
     * Sets this game's tile size to {@code size}
     * 
     * @param size the new size to this game's tiles
     */
    public void setTileSize(int size) {
        tileSize = size;
    }

    /**
     * Returns the tile size of this game
     * 
     * @return the tile size of this game
     */
    public int getTileSize() {
        return tileSize;
    }

    /**
     * Sets this game's width and height.
     * 
     * @param width The new width
     * @param height The new height
     */
    public void setGameSize(int width, int height) {
        gamePanel.setPreferredSize(new Dimension(width, height));
        pack();
    }

    /**
     * Returns this game's panel width.
     * 
     * @return this game's panel width
     */
    public int getGameWidth() {
        return gamePanel.getWidth();
    }

    /**
     * Returns this game's panel height.
     * 
     * @return this game's panel height
     */
    public int getGameHeight() {
        return gamePanel.getHeight();
    }

    /**
     * Sets this game's tile size so that the amount
     * of tiles to fit the game horizontally
     * are the amount {@code amount}
     * 
     * @param amount the amount of tiles to fit the
     * game horizontally
     */
    public void setHorizontalTileAmount(int amount) {
        tileSize = getGameWidth() / amount;
    }

    /**
     * Sets this game's tile size so that the amount
     * of tiles to fit the game vertically
     * are the amount {@code amount}
     * 
     * @param amount the amount of tiles to fit the
     * game vertically
     */
    public void setVerticalTileAmount(int amount) {
        tileSize = getGameHeight() / amount;
    }

    /**
     * Creates a new {@code GameFlow} and starts it
     * with the passed {@code fps}.
     * 
     * @param fps The fps with which the game flow will run
     */
    public void createGameFlow(int fps) {
        gameFlow = new GameFlow(this, fps);
        gameFlow.start();
    }

    /**
     * Tells if the game should display its current FPS or
     * not.
     * 
     * @param b {@code true} to display and {@code false}
     *          to not
     */
    public void displayFps(boolean b) {
        gameFlow.displayFps = b;
    }

    /**
     * This method serves to define what should happen
     * once the game flow starts.
     */
    public abstract void startGame();

    /**
     * This method serves to define what should happen in
     * every frame of the game.
     * <p>
     * This will execute in every frame of the game before the
     * {@code drawGame} method.
     */
    public abstract void updateGame();

    /**
     * Executes in every frame of the game after the
     * {@code updateGame} method.
     * <p>
     * Draws every object on the current stage.
     */
    public void drawGame() {
        gamePanel.repaint();
    }

}