package imagine.game;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * Class used for creating a 
 * panel that is put inside a
 * {@code GameFrame} to display
 * a {@code Game} on.
 * 
 * @author Daniel O Sousa
 * 
 * @see imagine.game.GameFrame
 * @see imagine.game.Game
 */
public class GamePanel extends JPanel {
    
    /**
     * The {@code GameFrame} where this
     * {@code GamePanel} is contained.
     */
    private GameFrame gameFrame;

    /**
     * Creates a new {@code GamePanel} that will
     * be contained inside the passed {@code gameFrame}.
     * 
     * @param gameFrame the {@code GameFrame} to
     * contain this {@code GamePanel}
     */
    public GamePanel(GameFrame gameFrame) {
        storeGameFrame(gameFrame);
        setDoubleBuffered(true);
        setBackground(Color.BLACK);
    }

    /**
     * Stores the passed {@code gameFrame}
     * into the {@code gameFrame} field.
     * 
     * @param gameFrame the {@code GameFrame}
     * to be stored
     * 
     * @throws IllegalArgumentException if the
     * passed argument is {@code null}
     */
    private void storeGameFrame(GameFrame gameFrame) {
        if(gameFrame == null) {
            throw new IllegalArgumentException("gameFrame cannot be null");
        }

        this.gameFrame = gameFrame;
    }

    /**
     * Returns the {@code GameFrame}
     * that contains this {@code GamePanel}.
     * 
     * @return the container {@code GameFrame}
     */
    public GameFrame getGameFrame() {
        return this.gameFrame;
    }

    /**
     * Returns the {@code Game} displayed
     * via this {@code GamePanel}.
     * 
     * @return the displayed {@code Game}
     */
    public Game getGame() {
        return gameFrame.getGame();
    }

    /**
     * Calls the {@code draw} method of the
     * displayed {@code Game} passing a
     * {@code Graphics2D} instance obtained
     * from the {@code g} parameter.
     * 
     * @param g a {@code Graphics} instance used
     * for drawing on this {@code GamePanel}
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        getGame().draw(g2);
        
        g2.dispose();
    }

}