package ig.game;

import java.util.ArrayList;
import java.awt.Graphics2D;

import ig.flow.*;
import ig.input.KeyHandler;
import ig.stage.Stage;

/**
 * Abstract class for creating a new game.
 * <p>
 * To use this class you must extend it into
 * your own game class.
 * 
 * @author Daniel O Sousa
 */
public abstract class Game implements GameFluid {

    /**
     * The {@code GameFrame} where this game will be held.
     */
    private GameFrame gameFrame;

    /**
     * An object to help keeping track of
     * the keys pressed by the player.
     */
    private KeyHandler keyHandler;

    /**
     * An object for controlling the flow of the game.
     */
    private GameFlow gameFlow;

    /**
     * Field which has the information of the default
     * width of the tiles of this {@code Game}.
     */
    private int tileWidth;

    /**
     * Field which has the information of the default
     * height of the tiles of this {@code Game}.
     */
    private int tileHeight;

    /**
     * Stores the stages of this {@code Game}.
     */
    private ArrayList<Stage> stages = new ArrayList<Stage>();

    /**
     * Stores the current stage of this {@code Game}.
     */
    private Stage currentStage;

    /**
     * Boolean value to configure if a tile
     * grid should be displayed. This grid is
     * usually great for debugging.
     */
    private boolean drawTileGrid = false;

    /**
     * Constructs a new {@code Game} instance
     * with the default size of {@code 1024} by {@code 576} pixels.
     */
    public Game() {
        createGameFrame();
        setSize(1024, 576);
        centralize();
        createKeyHandler();
    }

    /**
     * Creates a new {@code GameFrame}
     * instance for holding this game.
     */
    private void createGameFrame() {
        this.gameFrame = new GameFrame(this);
    }

    /**
     * Returns the frame which is holding this game.
     * 
     * @return the {@code GameFrame}
     */
    public GameFrame getGameFrame() {
        return this.gameFrame;
    }

    /**
     * Returns the width of the frame of this {@code Game}.
     * 
     * @return the {@code GameFrame} width
     */
    public int getGameFrameWidth() {
        return getGameFrame().getWidth();
    }

    /**
     * Returns the height of the frame of this {@code Game}.
     * 
     * @return the {@code GameFrame} height
     */
    public int getGameFrameHeight() {
        return getGameFrame().getHeight();
    }

    /**
     * Returns the width of the content pane
     * of the frame of this {@code Game}.
     * 
     * @return the content pane width
     */
    public int getContentPaneWidth() {
        return getGameFrame().getContentPaneWidth();
    }

    /**
     * Returns the height of the content pane
     * of the frame of this {@code Game}.
     * 
     * @return the content pane height
     */
    public int getContentPaneHeight() {
        return getGameFrame().getContentPaneHeight();
    }

    /**
     * Returns the panel where this {@code Game} is drawn.
     * 
     * @return the {@code GamePanel}
     */
    public GamePanel getGamePanel() {
        return getGameFrame().getGamePanel();
    }

    /**
     * Returns the width of the panel of this {@code Game}.
     * 
     * @return the {@code GamePanel} width
     */
    public int getGamePanelWidth() {
        return getGamePanel().getWidth();
    }

    /**
     * Returns the height of the panel of this {@code Game}.
     * 
     * @return the {@code GamePanel} height
     */
    public int getGamePanelHeight() {
        return getGamePanel().getHeight();
    }

    /**
     * Centralizes the game on the screen.
     */
    public void centralize() {
        gameFrame.setLocationRelativeTo(null);
    }

    /**
     * Creates a {@code KeyHandler} instance
     * to monitor the inputs from the keyboard.
     */
    private void createKeyHandler() {
        this.keyHandler = new KeyHandler();
        getGameFrame().addKeyListener(this.keyHandler);
    }

    /**
     * Returns the {@code KeyHandler} that
     * is monitoring the keyboard input.
     * 
     * @return the {@code KeyHandler}
     */
    public KeyHandler getKeyHandler() {
        return this.keyHandler;
    }

    /**
     * Verifies if a key specified by the passed
     * {@code keyCode} is currently pressed.
     * 
     * @param keyCode the code of the key to verify
     * 
     * @return {@code true} or {@code false} depending
     * on the key state
     */
    public boolean keyIsPressed(int keyCode) {
        return getKeyHandler().isPressed(keyCode);
    }

    /**
     * Creates and starts a {@code GameFlow} to
     * loop through the game.
     * 
     * @param fps the fps with which the game
     * should iterate
     */
    public void createGameFlow(int fps) {
        this.gameFlow = new GameFlow(this, fps);
    }

    /**
     * Returns the {@code GameFlow} of this {@code Game}.
     * 
     * @return the {@code GameFlow}
     */
    public GameFlow getGameFlow() {
        return this.gameFlow;
    }

    /**
     * Returns the fps with which this
     * {@code Game} is configured to run.
     * {@code 0} is returned if no fps was
     * configured.
     * 
     * @return the fps of this {@code Game}
     */
    public int getFps() {
        if(gameFlow != null) {
            return gameFlow.getFps();
        } else {
            return 0;
        }
    }

    /**
     * Makes the flow of this {@code Game} finish.
     */
    public void killGameFlow() {
        if(gameFlow != null) {
            gameFlow.killFlow();
        }
    }

    /**
     * Sets if the fps should or shouldn't
     * be displayed on the console.
     * 
     * @param displayFps boolean to
     * configure the fps display
     */
    public void setDisplayFps(boolean displayFps) {
        if(gameFlow != null) {
            gameFlow.setDisplayFps(displayFps);
        }
    }

    /**
     * Returns {@code true} if the fps is configured
     * to be displayed on the console and {@code false}
     * otherwise. {@code false} is also returned
     * if there is no {@code GameFlow} executing.
     * 
     * @return boolean indicating fps display
     * state
     */
    public boolean getDisplayFps() {
        if(gameFlow != null) {
            return gameFlow.getDisplayFps();
        } else {
            return false;
        }
    }

    /**
     * Sets the default width of the
     * tiles of this {@code Game}.
     * 
     * @param tileWidth the tile width to be set
     * 
     * @throws IllegalArgumentException if the passed
     * {@code tileWidth} is negative
     */
    private void setTileWidth(int tileWidth) {
        if(tileWidth < 0) {
            throw new IllegalArgumentException (
                "can't set tile width to " + tileWidth + ": " +
                tileWidth + " < 0"
            );
        }

        this.tileWidth = tileWidth;
    }

    /**
     * Sets the default height of the
     * tiles of this {@code Game}.
     * 
     * @param tileHeight the tile height to be set
     * 
     * @throws IllegalArgumentException if the passed
     * {@code tileHeight} is negative
     */
    private void setTileHeight(int tileHeight) {
        if(tileHeight < 0) {
            throw new IllegalArgumentException (
                "can't set tile height to " + tileHeight + ": "
                + tileHeight + " < 0"
            );
        }

        this.tileHeight = tileHeight;
    }

    /**
     * Sets the default size of the
     * tiles of this {@code Game}.
     * 
     * @param width the tile width to be set
     * @param height the tile height to be set
     * 
     * @throws IllegalArgumentException if the
     * passed {@code width} or {@code height}
     * is negative
     */
    public void setTileSize(int width, int height) {
        setTileWidth(width);
        setTileHeight(height);
    }

    /**
     * Sets the tile width in a way that the
     * determined {@code amount} of tiles
     * fits the screen horizontally.
     * 
     * @param amount the amount of tiles that the
     * game should have horizontally
     * 
     * @throws IllegalArgumentException if the
     * passed {@code amount} is negative
     */
    public void setHorizontalTileAmount(int amount) {
        if(amount < 0) {
            throw new IllegalArgumentException (
                "can't have " + amount + " tiles horizontally onscreen: " +
                amount + " < 0"
            );
        }

        setTileWidth (
            amount == 0 ?
            0 :
            getGamePanelWidth() / amount
        );
    }

    /**
     * Sets the tile height in a way that the
     * determined {@code amount} of tiles
     * fits the screen vertically.
     * 
     * @param amount the amount of tiles that the
     * game should have vertically
     * 
     * @throws IllegalArgumentException if the
     * passed {@code amount} is negative
     */
    public void setVerticalTileAmount(int amount) {
        if(amount < 0) {
            throw new IllegalArgumentException (
                "can't have " + amount + " tiles vertically onscreen: " +
                amount + " < 0"
            );
        }

        setTileHeight (
            amount == 0 ?
            0 :
            getGamePanelHeight() / amount
        );
    }

    /**
     * Returns the default width of
     * the tiles of this {@code Game}.
     * 
     * @return the default tile width
     */
    public int getTileWidth() {
        return this.tileWidth;
    }

    /**
     * Returns the default height of
     * the tiles of this {@code Game}.
     * 
     * @return the default tile height
     */
    public int getTileHeight() {
        return this.tileHeight;
    }

    /**
     * Sets the stages of this {@code Game}.
     * If the passed argument is {@code null},
     * does nothing.
     * 
     * @param stages the stages that this
     * {@code Game} will have
     */
    public void setStages(ArrayList<Stage> stages) {
        if(stages != null) {
            this.stages = stages;
        }
    }

    /**
     * Adds the passed {@code stage} to
     * the end of the list of stages if
     * the argument is not {@code null}.
     * 
     * @param stage {@code Stage} to
     * be added
     * 
     * @throws IllegalArgumentException if
     * the {@code stage} argument is
     * {@code null}
     */
    public void addStage(Stage stage) {
        addLastStage(stage);
    }

    /**
     * Adds the passed {@code stage} to
     * the beginning of the list of stages if
     * the argument is not {@code null}.
     * 
     * @param stage {@code Stage} to
     * be added
     * 
     * @throws IllegalArgumentException if
     * the {@code stage} argument is
     * {@code null}
     */
    public void addFirstStage(Stage stage) {
        if(stage == null) {
            throw new IllegalArgumentException (
                "cannot add null stage"
            );
        }

        stages.add(0, stage);
    }

    /**
     * Adds the passed {@code stage} to the
     * specified {@code position} of the list
     * of stages.
     * <p>
     * If the {@code stage} is null an exception
     * will be thrown. Also if the {@code position}
     * is invalid ({@code position < 0 || position
     * > stages.size()}) an exception will
     * be thrown.
     * 
     * @param position the position where to add
     * the {@code stage}
     * @param stage {@code Stage} to be added
     * 
     * @throws IndexOutOfBoundsException if the
     * {@code position} argument is invalid
     * @throws IllegalArgumentException if the
     * {@code stage} argument is {@code null}
     */
    public void addNthStage(int position, Stage stage) {
        if(position < 0 || position > stages.size()) {
            throw new IndexOutOfBoundsException (
                "cannot add stage at position " +
                position
            );
        }
        if(stage == null) {
            throw new IllegalArgumentException (
                "cannot add null stage"
            );
        }

        stages.add(position, stage);
    }

    /**
     * Adds the passed {@code stage} to
     * the end of the list of stages if
     * the argument is not {@code null}.
     * 
     * @param stage {@code Stage} to
     * be added
     * 
     * @throws IllegalArgumentException if
     * the {@code stage} argument is
     * {@code null}
     */
    public void addLastStage(Stage stage) {
        if(stage == null) {
            throw new IllegalArgumentException (
                "cannot add null stage"
            );
        }

        stages.add(stage);
    }

    /**
     * Removes all stages that are
     * stored in this {@code Game}.
     * After the removal the current
     * stage will be unselected.
     */
    public void removeAllStages() {
        stages.clear();
        if(currentStage != null) {
            unselectStage();
        }
    }

    /**
     * Removes the specified {@code stage}
     * from the stages stored in this
     * {@code Game} if it exists. If this
     * removed stage is the current stage
     * it is unselected.
     * 
     * @param stage the stage to be removed
     */
    public void removeStage(Stage stage) {
        stages.remove(stage);
        if(currentStage == stage) {
            unselectStage();
        }
    }

    /**
     * Removes and returns the first stage
     * from the stages stored in this
     * {@code Game} if there are any. If this
     * removed stage is the current stage
     * it is unselected.
     * 
     * @return the removed {@code Stage}
     */
    public Stage removeFirstStage() {
        if(stages.isEmpty()) {
            return null;
        }

        Stage removedStage = stages.remove(0);
        if(currentStage == removedStage) {
            unselectStage();
        }
        return removedStage;
    }

    /**
     * Removes and returns the stage at the
     * specified {@code position} from the
     * stages stored in this {@code Game} if
     * there are any and the {@code position}
     * is valid ({@code position > 0 && position
     * < stages.size()}).
     * <p>
     * If the stage removed by this method is
     * the current stage, it is unselected.
     * 
     * @param position the position where is
     * the {@code Stage} to be removed
     * 
     * @return the removed {@code Stage}
     * 
     * @throws IndexOutOfBoundsException if the
     * position is invalid
     */
    public Stage removeNthStage(int position) {
        if(stages.isEmpty()) {
            return null;
        }
        if(position < 0 || position >= stages.size()) {
            throw new IndexOutOfBoundsException (
                "position " + position +
                " does not match a stage"
            );
        }

        Stage removedStage = stages.remove(position);
        if(currentStage == removedStage) {
            unselectStage();
        }
        return removedStage;
    }

    /**
     * Removes and returns the last stage
     * from the stages stored in this
     * {@code Game} if there are any. If
     * this removed stage is the current
     * stage it is unselected.
     * 
     * @return the removed {@code Stage}
     */
    public Stage removeLastStage() {
        if(stages.isEmpty()) {
            return null;
        }

        Stage removedStage = stages.remove(stages.size() - 1);
        if(currentStage == removedStage) {
            unselectStage();
        }
        return removedStage;
    }

    /**
     * Returns an {@code ArrayList} with
     * the stages of this {@code Game}.
     * 
     * @return the stages of this {@code Game}
     */
    public ArrayList<Stage> getStages() {
        return this.stages;
    }

    /**
     * Selects and starts the stage specified
     * by the passed {@code position}.
     * If there are no stages added to this
     * {@code Game}, however, does nothing.
     * <p>
     * If the passed argument does not correspond
     * to a stage (is negative or greater or equal 
     * to the amount of added stages), throws
     * an {@code IndexOutOfBoundsException}.
     * 
     * @param position a position specifiyng
     * the stage to select
     * 
     * @throws IndexOutOfBoundsException if the argument
     * doesn't correspond to a stage
     */
    public void selectStage(int position) {
        if(stages.isEmpty()) {
            return;
        }
        if(position < 0 || position >= stages.size()) {
            throw new IndexOutOfBoundsException (
                "position " + position +
                " does not correspond to a stage"
            );
        }

        Stage currentStage = stages.get(position);
        currentStage.start();
        this.currentStage = currentStage;
    }

    /**
     * Unselects whatever stage
     * is currently selected.
     */
    public void unselectStage() {
        this.currentStage = null;
    }

    /**
     * Selects and starts the next stage from
     * the stages of this {@code Game}. If the
     * current stage is {@code null}, the first
     * stage will be selected.
     * <p>
     * If there are no stages to select, this
     * method won't do anything.
     */
    public void nextStage() {
        if(stages.isEmpty()) {
            return;
        }
        if(currentStage == stages.get(stages.size() - 1)) {
            return;
        }
        if(currentStage == null) {
            selectStage(0);
            return;
        }
        
        selectStage(stages.indexOf(currentStage) + 1);
    }

    /**
     * Selects and starts the previous stage from
     * the stages of this {@code Game}. If the
     * current stage is {@code null}, the last
     * stage will be selected.
     * <p>
     * If there are no stages to select, this
     * method won't do anything.
     */
    public void previousStage() {
        if(stages.isEmpty()) {
            return;
        }
        if(currentStage == stages.get(0)) {
            return;
        }
        if(currentStage == null) {
            selectStage(stages.size() - 1);
            return;
        }
        
        selectStage(stages.indexOf(currentStage) - 1);
    }

    /**
     * Returns the stage which is
     * currently selected.
     * 
     * @return the current stage
     */
    public Stage getCurrentStage() {
        return this.currentStage;
    }

    /**
     * Specifies if a tile grid should be drawn.
     * This grid is usually good for debugging.
     * 
     * @param drawTileGrid boolean indicating
     * visibility of tile grid
     */
    public void setDrawTileGrid(boolean drawTileGrid) {
        this.drawTileGrid = drawTileGrid;
    }

    /**
     * Returns {@code true} or {@code false}
     * depending if the tile grid is configured
     * to be drawn or not.
     * 
     * @return boolean indicating tile grid
     * visibility
     */
    public boolean getDrawTileGrid() {
        return this.drawTileGrid;
    }

    /**
     * Sets the size of the frame
     * containing this {@code Game}.
     * 
     * @param width the width to be set
     * @param height the height to be set
     */
    public void setSize(int width, int height) {
        getGameFrame().setContentPaneSize(width, height);
        getGamePanel().setSize(width, height);
    }

    /**
     * Method executed once the flow of
     * this {@code Game} starts.
     * <p>
     * This method executes the {@code onStart} method.
     * 
     * @see #onStart()
     */
    @Override
    public void start() {
        
        onStart();
    }

    /**
     * User defined method to specify
     * what should happen once this
     * {@code Game} starts.
     */
    public abstract void onStart();

    /**
     * Executed every frame of this {@code Game} to
     * update the current stage.
     * <p>
     * This method also executes the {@code onUpdate}
     * method.
     * 
     * @see #onUpdate()
     */
    @Override
    public void update() {
        if(currentStage != null) {
            currentStage.update();
        }

        onUpdate();
    }
    
    /**
     * User defined method to specify
     * what should happen once this
     * {@code Game} updates.
     */
    public abstract void onUpdate();

    /**
     * Executed every frame of this {@code Game}
     * after the {@code update} method to
     * draw the current stage.
     * <p>
     * This method also executes the {@code onDraw}
     * method.
     * 
     * @param g2 a {@code Graphics2D} instance used
     * for drawing the game.
     * 
     * @see #update()
     * @see #onDraw(Graphics2D)
     */
    @Override
    public void draw(Graphics2D g2) {
        if(currentStage != null) {
            currentStage.draw(g2);
        }

        onDraw(g2);
    }
    
    /**
     * User defined method to specify
     * what should happen every time this
     * {@code Game} is drawn.
     */
    public abstract void onDraw(Graphics2D g2);
    
}