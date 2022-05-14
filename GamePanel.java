import javax.swing.JPanel;
import java.awt.Dimension;
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
    public Game game;

    /**
     * Creates a {@code GamePanel} for displaying
     * the game {@code game} with the specified width
     * {@code width} and height {@code height}.
     * 
     * @param game The game which will be displayed
     * @param width The width of the game panel
     * @param height The height of the game panel
     */
    public GamePanel(Game game, int width, int height) {
        this.game = game;
        
        setDoubleBuffered(true);
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.BLACK);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        // Draw

        g2.dispose();
    }

}