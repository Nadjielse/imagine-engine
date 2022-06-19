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
     * Field which has the information of the
     * size of the tiles of this {@code Game}.
     */
    private int tileSize;

    /**
     * Stores the stages of this {@code Game}.
     */
    private ArrayList<Stage> stages;

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

    public void createGameFlow(int fps) {
        this.gameFlow = new GameFlow(this, fps);
    }

    public GameFlow getGameFlow() {
        return this.gameFlow;
    }

    public int getFps() {
        return getGameFlow().getFps();
    }

    public void setDisplayFps(boolean displayFps) {
        getGameFlow().setDisplayFps(displayFps);
    }

    public boolean getDisplayFps() {
        return getGameFlow().getDisplayFps();
    }

    public void setTileSize(int tileSize) {
        if(tileSize < 0) {
            throw new IllegalArgumentException("tileSize cannot be negative");
        }

        this.tileSize = tileSize;
    }

    public void setHorizontalTileAmount(int amount) {
        setTileSize(getGamePanelWidth() / amount);
    }

    public void setVerticalTileAmount(int amount) {
        setTileSize(getGamePanelHeight() / amount);
    }

    public int getTileSize() {
        return this.tileSize;
    }

    public void setStages(ArrayList<Stage> stages) {
        if(stages != null) {
            for(Stage stage : stages) {
                stage.setGame(this);
            }
            this.stages = stages;
        }
    }

    public ArrayList<Stage> getStages() {
        return this.stages;
    }

    public void selectStage(int position) {
        if(getStages() == null || getStages().size() == 0) {
            throw new NoStagesException("There are no stages to select");
        }
        if(position < 0 || position >= stages.size()) {
            throw new IndexOutOfBoundsException("position " + position + " does not correspond to a stage");
        }

        Stage currentStage = getStages().get(position);
        currentStage.start();
        this.currentStage = currentStage;
    }

    public void nextStage() {
        int currentStageIndex = getStages().indexOf(currentStage);
        if(currentStageIndex < getStages().size() - 1) {
            selectStage(currentStageIndex + 1);
        }
    }

    public void previousStage() {
        int currentStageIndex = getStages().indexOf(currentStage);
        if(currentStageIndex > 0) {
            selectStage(currentStageIndex - 1);
        }
    }

    public Stage getCurrentStage() {
        return this.currentStage;
    }

    public void setDrawTileGrid(boolean drawTileGrid) {
        this.drawTileGrid = drawTileGrid;
    }

    public boolean getDrawTileGrid() {
        return this.drawTileGrid;
    }

    public void killGameFlow() {
        if(getGameFlow() != null) {
            getGameFlow().killFlow();
        }
    }

    public void setSize(int width, int height) {
        getGameFrame().setContentPaneSize(width, height);
        getGamePanel().setSize(width, height);
    }



    @Override
    public void start() {
        
        onStart();
    }

    public abstract void onStart();

    @Override
    public void update() {
        if(getCurrentStage() != null) {
            getCurrentStage().update();
        }

        onUpdate();
    }
    
    public abstract void onUpdate();

    @Override
    public void draw(Graphics2D g2) {
        if(getCurrentStage() != null) {
            getCurrentStage().draw(g2);
        }

        onDraw(g2);
    }
    
    public abstract void onDraw(Graphics2D g2);
    
}