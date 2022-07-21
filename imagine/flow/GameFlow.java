package imagine.flow;

import imagine.game.Game;

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
    private Thread flow;

    /**
     * The FPS on which the game should run.
     */
    private int fps;

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
    private boolean displayFps = false;

    /**
     * Creates a new {@code GameFlow} for running the specified
     * game {@code game} with the specified FPS {@code fps}.
     * 
     * @param game The game which will run through this {@code GameFlow}
     * @param fps The FPS with which the game should run
     */
    public GameFlow(Game game, int fps) {
        storeGame(game);
        createFlow();
        storeFps(fps);
        calculateFpsInterval();
        startFlow();
    }

    /**
     * Stores the received {@code game}, if
     * not {@code null}, into the {@code game}
     * field.
     * 
     * @param game the {@code Game} to be stored
     * 
     * @throws IllegalArgumentException if the
     * {@code game} argument is {@code null}
     */
    private void storeGame(Game game) {
        if(game == null) {
            throw new IllegalArgumentException (
                "game store null game"
            );
        }

        this.game = game;
    }

    /**
     * Returns the {@code Game}
     * that uses this
     * {@code GameFlow} to run.
     * 
     * @return the {@code Game}
     * using this {@code GameFlow}
     */
    public Game getGame() {
        return this.game;
    }

    /**
     * Creates a new {@code Thread}
     * to run the {@code game} and
     * stores it at the {@code flow}
     * field.
     */
    private void createFlow() {
        this.flow = new Thread(this);
    }

    /**
     * Returns the {@code Thread}
     * that runs the {@code game}
     * of this {@code GameFlow}.
     * 
     * @return the {@code Thread}
     * of the {@code game} of
     * this {@code GameFlow}
     */
    public Thread getFlow() {
        return this.flow;
    }

    /**
     * Stores the {@code fps} argument into the
     * {@code fps} field. If the argument is
     * not positive, an exception is thrown.
     * 
     * @param fps the fps to be stored
     * 
     * @throws IllegalArgumentException if the
     * {@code fps} argument is not positive
     */
    private void storeFps(int fps) {
        if(fps <= 0) {
            throw new IllegalArgumentException (
                "fps must be positive"
            );
        }

        this.fps = fps;
    }

    /**
     * Returns the fps with
     * which this {@code GameFlow}
     * runs its {@code Game}.
     * 
     * @return the fps of this
     * {@code GameFlow}
     */
    public int getFps() {
        return this.fps;
    }

    /**
     * Calculates the interval in nanoseconds
     * with which each frame of this
     * {@code GameFlow} will run and stores
     * it into the {@code fpsInterval} field.
     */
    private void calculateFpsInterval() {
        this.fpsInterval = 1000000000 / fps;
    }

    /**
     * Returns the interval in nanoseconds
     * between each frame of this
     * {@code GameFlow}.
     * 
     * @return the interval between
     * frames in nanoseconds
     */
    public double getFpsInterval() {
        return this.fpsInterval;
    }

    /**
     * Configures if this {@code GameFlow} should
     * or not display its fps on the console
     * depending on the value of the
     * {@code displayFps} argument.
     * 
     * @param displayFps boolean describing
     * visibility of the fps
     */
    public void setDisplayFps(boolean displayFps) {
        this.displayFps = displayFps;
    }

    /**
     * Returns {@code true} if the
     * fps is configured to be
     * displayed and {@code false}
     * otherwise.
     * 
     * @return boolean describing
     * fps visibility
     */
    public boolean getDisplayFps() {
        return this.displayFps;
    }

    /**
     * Starts the flow of this
     * {@code GameFlow}, executing
     * the {@code start} method of
     * the associated {@code Game}.
     */
    public void startFlow() {
        lastTime = System.nanoTime();
        game.start();
        flow.start();
    }

    /**
     * Stops the flow of this
     * {@code GameFlow}.
     */
    public void killFlow() {
        flow = null;
    }

    /**
     * Method executed every frame of this {@code GameFlow}.
     * The execution of this method causes calls to the
     * {@code update} and {@code draw} methods of the
     * {@code Game} that uses this {@code GameFlow}.
     */
    @Override
    public void run() {
        while(flow != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / fpsInterval;
            timer += currentTime - lastTime;
            lastTime = currentTime;

            if(delta >= 1) {
                game.update();
                game.repaintGamePanel();
                delta--;

                timesUpdated++;
            }

            if(timer >= 1000000000) {
                if(displayFps) {
                    System.out.println (
                        "FPS: " + timesUpdated
                    );
                }
                timer = 0;
                timesUpdated = 0;
            }
        }
    }

}