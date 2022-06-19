package ig.game;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class GamePanel extends JPanel {
    
    private GameFrame gameFrame;

    public GamePanel(GameFrame gameFrame) {
        storeGameFrame(gameFrame);
        setDoubleBuffered(true);
        setBackground(Color.BLACK);
    }

    private void storeGameFrame(GameFrame gameFrame) {
        if(gameFrame == null) {
            throw new IllegalArgumentException("gameFrame cannot be null");
        }

        this.gameFrame = gameFrame;
    }

    public GameFrame getGameFrame() {
        return this.gameFrame;
    }

    public Game getGame() {
        return gameFrame.getGame();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        getGame().draw(g2);
        
        g2.dispose();
    }

}