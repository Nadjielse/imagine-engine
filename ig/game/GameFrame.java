package ig.game;

import javax.swing.JFrame;
import java.awt.Dimension;

public class GameFrame extends JFrame {

    private Game game;
    private GamePanel gamePanel;

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

    private void storeGame(Game game) {
        if(game == null) {
            throw new IllegalArgumentException("game cannot be null");
        }

        this.game = game;
    }

    public Game getGame() {
        return this.game;
    }

    private void createGamePanel() {
        this.gamePanel = new GamePanel(this);
        add(this.gamePanel);
    }

    public GamePanel getGamePanel() {
        return this.gamePanel;
    }

    public void setContentPaneSize(int width, int height) {
        getContentPane().setPreferredSize(new Dimension(width, height));
        pack();
    }

    public int getContentPaneWidth() {
        return getContentPane().getWidth();
    }

    public int getContentPaneHeight() {
        return getContentPane().getHeight();
    }
    
}