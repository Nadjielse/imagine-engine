package ig.game;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * Class for creating a panel for displaying
 * a game.
 * 
 * @author Daniel O Sousa
 */
public class GamePanel extends JPanel {

    /**
     * The game which is displayed by this
     * {@code GamePanel}.
     */
    private Game game;

    /**
     * Creates a {@code GamePanel} for displaying
     * the game.
     * 
     * @param game The game which will be displayed
     */
    public GamePanel(Game game) {
        this.game = game;
        
        setDoubleBuffered(true);
        setBackground(Color.BLACK);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        // Draw

        g2.dispose();
    }

}