package ig.game;

import javax.swing.JFrame;
import java.awt.Dimension;

/**
 * Class that serves to hold a {@code GamePanel}
 * and exhibit a {@code Game} on it.
 * 
 * @author Daniel O Sousa
 * 
 * @see ig.game.Game
 * @see ig.game.GamePanel
 */
public class GameFrame extends JFrame {

    /**
     * The game which this {@code GameFrame} is showing.
     */
    private Game game;

    /**
     * The game panel which this {@code GameFrame} is holding.
     */
    private GamePanel gamePanel;

    /**
     * Constructs a new {@code GameFrame}
     * to show the specified {@code game}.
     * 
     * @param game the game that this {@code GameFrame}
     * will display
     */
    public GameFrame(Game game) {
        storeGame(game);
        createGamePanel();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Imagine Engine");
        setLayout(null);
        // TODO set icon
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    /**
     * Stores the passed {@code game}
     * into the {@code game} field.
     * 
     * @param game the {@code Game} to be stored
     * 
     * @throws IllegalArgumentException if the
     * passed {@code game} is null
     */
    private void storeGame(Game game) {
        if(game == null) {
            throw new IllegalArgumentException("game cannot be null");
        }

        this.game = game;
    }

    /**
     * Returns the {@code Game} which
     * this {@code GameFrame} displays.
     * 
     * @return the displayed {@code Game}
     */
    public Game getGame() {
        return this.game;
    }

    /**
     * Creates and stores a {@code GamePanel}
     * to display the {@code game}.
     */
    private void createGamePanel() {
        this.gamePanel = new GamePanel(this);
        add(this.gamePanel);
    }

    /**
     * Returns the {@code GamePanel} contained
     * within this {@code GameFrame}.
     * 
     * @return the {@code GamePanel} of
     * this {@code GameFrame}
     */
    public GamePanel getGamePanel() {
        return this.gamePanel;
    }

    /**
     * Sets the size of the content pane of
     * this {@code GameFrame} to the specified
     * {@code width} and {@code height}.
     * 
     * @param width the width to be set
     * @param height the height to be set
     */
    public void setContentPaneSize(int width, int height) {
        getContentPane().setPreferredSize(new Dimension(width, height));
        pack();
    }

    /**
     * Returns the width of the content
     * pane of this {@code GameFrame}.
     * 
     * @return the content pane width
     */
    public int getContentPaneWidth() {
        return getContentPane().getWidth();
    }

    /**
     * Returns the height of the content
     * pane of this {@code GameFrame}.
     * 
     * @return the content pane height
     */
    public int getContentPaneHeight() {
        return getContentPane().getHeight();
    }
    
}