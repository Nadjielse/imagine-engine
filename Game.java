import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;

public class Game extends JFrame {

    public JPanel gamePanel = new JPanel();
    public GameFlow gameFlow;
    public int tileSize;

    public Game(String title, int width, int height, int fps) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(title);

        // Create the game panel
        gamePanel.setDoubleBuffered(true);
        gamePanel.setPreferredSize(new Dimension(width, height));
        gamePanel.setBackground(Color.BLACK);

        add(gamePanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

        gameFlow = new GameFlow(this, fps);
        gameFlow.start();
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
     * Returns this game's displaying area width.
     * <p>
     * The displaying area is the panel on which the
     * game is shown.
     * 
     * @return this game's displaying area width
     */
    public int getGameWidth() {
        return gamePanel.getWidth();
    }

    /**
     * Returns this game's displaying area height.
     * <p>
     * The displaying area is the panel on which the
     * game is shown.
     * 
     * @return this game's displaying area height
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

    public void startGame() {

    }

    public void updateGame() {

    }

    public void drawGame() {

    }

}