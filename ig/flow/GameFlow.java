package ig.flow;

import ig.Game;

/**
 * {@code GameFlow} is a class used for creating a new thread
 * on which the game will run.
 * 
 * @author Daniel O Sousa
 */
public class GameFlow implements Runnable {

    /**
     * The game which is running through this GameFlow.
     */
    private Game game;

    /**
     * The thread that runs the game.
     * <p>
     * When set to {@code null}, stops the game.
     */
    public Thread flow = new Thread(this);

    /**
     * The FPS on which the game should run.
     */
    public int fps;

    /**
     * Stores the interval in nano seconds on which
     * the game should be updated and drawn.
     */
    private double fpsInterval;

    /**
     * Stores the last time in nano seconds that a
     * game was updated and drawn.
     */
    private long lastTime;

    /**
     * Stores the start time in nano seconds of the
     * current game updating and drawing.
     */
    private long currentTime;

    /**
     * Variable for controlling the interval
     * between each game update and draw.
     */
    private double delta = 0;

    /**
     * Counts how much time is passed for displaying the
     * current FPS from second to second.
     */
    private long timer = 0;

    /**
     * Counts how many times the game is updated each
     * second so that the current FPS can be calculated.
     */
    private int timesUpdated = 0;

    /**
     * Tells if the FPS should be displayed on the console
     * or not.
     * <p>
     * Is initially set to {@code false}
     */
    public boolean displayFps = false;

    /**
     * Creates a new {@code GameFlow} for running the specified
     * game {@code game} with the specified FPS {@code fps}
     * 
     * @param game The game which will run through this {@code GameFlow}
     * @param fps The FPS with which the game should run
     */
    public GameFlow(Game game, int fps) {
        this.game = game;
        this.fps = fps;
        this.fpsInterval = 1000000000 / this.fps;
    }

    /**
     * Executes the {@code startGame} method from this {@code game}
     * and starts this {@code GameFlow}'s {@code flow}
     */
    public void start() {
        lastTime = System.nanoTime();
        game.startGame();
        flow.start();
    }

    @Override
    public void run() {
        while(flow != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / fpsInterval;
            timer += currentTime - lastTime;
            lastTime = currentTime;

            if(delta >= 1) {
                game.updateGame();
                game.drawGame();
                delta--;

                timesUpdated++;
            }

            if(timer >= 1000000000) {
                if(displayFps) {
                    System.out.print("FPS: " + timesUpdated + "\n");
                }
                timer = 0;
                timesUpdated = 0;
            }

        }
    }

}