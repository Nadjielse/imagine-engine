package ig.stage;

import java.util.ArrayList;
import java.awt.Graphics2D;

import ig.flow.GameFluid;
import ig.game.Game;
import ig.scenario.Scenario;
import ig.object.GameObject;

// TODO camera

/**
 * Class for creating a stage for a {@code Game}.
 * 
 * @author Daniel O Sousa
 */
public abstract class Stage implements GameFluid {

    /**
     * {@code Game} which has this {@code Stage}.
     */
    private Game game;

    /**
     * The title of this {@code Stage}.
     */
    private String title;

    /**
     * The width of this {@code Stage}.
     */
    private int width;

    /**
     * The height of this {@code Stage}.
     */
    private int height;

    /**
     * The backgrounds of this {@code Stage}.
     */
    private ArrayList<Scenario> backgrounds = new ArrayList<Scenario>();

    /**
     * The objects of this {@code Stage}.
     */
    private ArrayList<GameObject> objects = new ArrayList<GameObject>();

    /**
     * The foregrounds of this {@code Stage}.
     */
    private ArrayList<Scenario> foregrounds = new ArrayList<Scenario>();

    

    /**
     * Sets a reference to the {@code Game}
     * that has this {@code Stage}.
     * 
     * @param game the game to which this
     * {@code Stage} belongs
     */
    public void setGame(Game game) {
        this.game = game;
    }

    /**
     * Returns the {@code Game} to which
     * this {@code Stage} belongs.
     * 
     * @return the {@code Game} of
     * this {@code Stage}
     */
    public Game getGame() {
        return this.game;
    }

    /**
     * Returns the width of the {@code GamePanel}
     * where this {@code Stage} is exhibited.
     * 
     * @return the width of the {@code GamePanel}
     */
    public int getGamePanelWidth() {
        if(game != null) {
            return game.getGamePanelWidth();
        } else {
            return 0;
        }
    }

    /**
     * Returns the height of the {@code GamePanel}
     * where this {@code Stage} is exhibited.
     * 
     * @return the height of the {@code GamePanel}
     */
    public int getGamePanelHeight() {
        if(game != null) {
            return game.getGamePanelHeight();
        } else {
            return 0;
        }
    }

    /**
     * Sets the title of this {@code Stage}.
     * 
     * @param title the title to be set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns the title of this {@code Stage}.
     * 
     * @return this {@code Stage}'s title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Sets the width of this {@code Stage},
     * if the passed {@code width} is greater
     * or equal to {@code 0}.
     * 
     * @param width the width to be set
     * 
     * @throws IllegalArgumentException if the
     * {@code width} argument is negative
     */
    public void setWidth(int width) {
        if(width < 0) {
            throw new IllegalArgumentException("width cannot be negative");
        }

        this.width = width;
    }

    /**
     * Returns the width of this {@code Stage}.
     * 
     * @return this {@code Stage}'s width
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * Sets the height of this {@code Stage},
     * if the passed {@code height} is greater
     * or equal to {@code 0}.
     * 
     * @param height the height to be set
     * 
     * @throws IllegalArgumentException if the
     * {@code height} argument is negative
     */
    public void setHeight(int height) {
        if(height < 0) {
            throw new IllegalArgumentException("height cannot be negative");
        }

        this.height = height;
    }

    /**
     * Returns the height of this {@code Stage}.
     * 
     * @return this {@code Stage}'s height
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * Sets the width of this {@code Stage}, if it is
     * greater or equal to {@code 0}, and does the
     * same with the height.
     * 
     * @param width the width to be set
     * @param height the height to be set
     * 
     * @throws IllegalArgumentException if the
     * {@code width} or {@code height} arguments
     * are negative
     */
    public void setSize(int width, int height) {
        setWidth(width);
        setHeight(height);
    }

    /**
     * Adds a background to this {@code Stage}. This
     * background will be the furthest from the camera.
     * If the {@code background} argument is {@code null},
     * though, it won't be added.
     * 
     * @param background the background to be added
     * 
     * @throws IllegalArgumentException if the {@code background}
     * argument is {@code null}
     */
    public void addBackground(Scenario background) {
        addFurthestBackground(background);
    }

    /**
     * Adds a background to this {@code Stage}. This
     * background will be the furthest from the camera.
     * If the {@code background} argument is {@code null},
     * though, it won't be added.
     * 
     * @param background the background to be added
     * 
     * @throws IllegalArgumentException if the {@code background}
     * argument is {@code null}
     */
    public void addFurthestBackground(Scenario background) {
        if(background == null) {
            throw new IllegalArgumentException("cannot add null background");
        }

        background.setStage(this);
        backgrounds.add(background);
    }

    /**
     * Adds a background to this {@code Stage} at
     * the specified {@code position}. The position
     * means how far between the backgrounds this one
     * will be from the camera. It must be a value
     * between {@code 0} and the amount of backgrounds
     * already in this {@code Stage}.
     * 
     * @param position the position where to add this background
     * @param background the background to be added
     * 
     * @throws IndexOutOfBoundsException if the {@code position}
     * argument is less than {@code 0} or greater than the
     * amount of backgrounds already added to this {@code Stage}
     * @throws IllegalArgumentException if the {@code background}
     * argument is {@code null}
     */
    public void addNthBackground(int position, Scenario background) {
        if(position < 0 || position > backgrounds.size()) {
            throw new IndexOutOfBoundsException (
                "cannot add background to position " + position +
                " (Only " + backgrounds.size() + " backgrounds)"
            );
        }
        if(background == null) {
            throw new IllegalArgumentException("cannot add null background");
        }

        background.setStage(this);
        backgrounds.add(position, background);
    }

    /**
     * Adds a background to this {@code Stage}. This
     * background will be the closest to the camera.
     * If it is {@code null}, though, it won't be added.
     * 
     * @param background the background to be added
     * 
     * @throws IllegalArgumentException if the {@code background}
     * argument is {@code null}
     */
    public void addClosestBackground(Scenario background) {
        if(background == null) {
            throw new IllegalArgumentException("cannot add null background");
        }

        background.setStage(this);
        backgrounds.add(0, background);
    }

    /**
     * Removes the furthest background of this
     * {@code Stage}. If it already has no backgrounds
     * this method won't do anything.
     * 
     * @return the removed background or {@code null}
     * if no background is removed
     */
    public Scenario removeFurthestBackground() {
        if(backgrounds.isEmpty()) {
            return null;
        }

        Scenario removedBackground = backgrounds.remove(backgrounds.size() - 1);
        removedBackground.setStage(null);
        return removedBackground;
    }

    /**
     * Removes the background at the specified position.
     * The position means how far the background is from the
     * camera. It must be between {@code 0} and the amount
     * of backgrounds already in this {@code Stage} minus {@code 1}.
     * If this {@code Stage} has no backgrounds nothing will
     * happen.
     * 
     * @param position the position where to remove a background from
     * 
     * @return the removed background or {@code null} if no
     * background is removed
     * 
     * @throws IndexOutOfBoundsException if the {@code position}
     * argument is less than {@code 0} or greater or equal to the
     * amount of backgrounds in this {@code Stage}
     */
    public Scenario removeNthBackground(int position) {
        if(backgrounds.isEmpty()) {
            return null;
        }
        if(position < 0 || position >= backgrounds.size()) {
            throw new IndexOutOfBoundsException (
                "cannot remove background in position " + position +
                " (Only " + backgrounds.size() + " backgrounds)"
            );
        }

        Scenario removedBackground = backgrounds.remove(position);
        removedBackground.setStage(null);
        return removedBackground;
    }

    /**
     * Removes the passed {@code background} from
     * this {@code Stage}'s backgrounds, if it is present.
     * 
     * @param background the background to be removed
     */
    public void removeBackground(Scenario background) {
        if(backgrounds.remove(background)) {
            background.setStage(null);
        }
    }

    /**
     * Removes the closest background of this
     * {@code Stage}. If it already has no
     * backgrounds this method won't do anything.
     * 
     * @return the removed background or {@code null}
     * if no background is removed
     */
    public Scenario removeClosestBackground() {
        if(backgrounds.isEmpty()) {
            return null;
        }

        Scenario removedBackground = backgrounds.remove(0);
        removedBackground.setStage(null);
        return removedBackground;
    }

    /**
     * Returns this {@code Stage}'s backgrounds.
     * 
     * @return the backgrounds of this {@code Stage}
     */
    public ArrayList<Scenario> getBackgrounds() {
        return backgrounds;
    }

    /**
     * Returns the background specified by the
     * {@code position} argument. This argument
     * means how far the background is from the
     * camera. It must be a number between {@code 0}
     * and the amount of backgrounds in this
     * {@code Stage} minus {@code 1}.
     * 
     * @param position the position of the
     * background to get
     * 
     * @return the background specified by the
     * {@code position} argument
     * 
     * @throws IndexOutOfBoundsException if the
     * {@code position} argument is less than {@code 0}
     * or greater or equal to the amount of backgrounds
     * in this {@code Stage}
     */
    public Scenario getBackground(int position) {
        if(position < 0 || position >= backgrounds.size()) {
            throw new IndexOutOfBoundsException (
                "cannot get background in position " + position +
                " (Only " + backgrounds.size() + " backgrounds)"
            );
        }

        return backgrounds.get(position);
    }

    /**
     * Adds a {@code GameObject} to the
     * objects of this {@code Stage} if
     * the {@code object} argument isn't
     * {@code null}.
     * 
     * @param object the {@code GameObject}
     * to be added
     * 
     * @throws IllegalArgumentException if the
     * {@code object} argument is {@code null}
     */
    public void addObject(GameObject object) {
        if(object == null) {
            throw new IllegalArgumentException("cannot add null object");
        }

        object.setStage(this);
        objects.add(object);
    }

    /**
     * Removes the specified {@code GameObject}
     * of this {@code Stage} if it is present.
     * 
     * @param object the {@code GameObject} to
     * be removed
     */
    public GameObject removeObject(int position) {
        if(position < 0 || position >= objects.size()) {
            throw new IndexOutOfBoundsException (
                "cannot remove object from position " + position +
                " (Only " + objects.size() + " objects)"
            );
        }

        GameObject removedObject = objects.remove(position);
        removedObject.setStage(null);
        return removedObject;
    }

    /**
     * Removes the specified {@code GameObject}
     * of this {@code Stage} if it is present.
     * 
     * @param object the {@code GameObject} to
     * be removed
     */
    public void removeObject(GameObject object) {
        if(objects.remove(object)) {
            object.setStage(null);
        }
    }

    /**
     * Returns an {@code ArrayList} containing
     * the objects of this {@code Stage}.
     * 
     * @return the objects of this {@code Stage}
     */
    public ArrayList<GameObject> getObjects() {
        return objects;
    }

    /**
     * Returns the {@code GameObject} specified
     * by the {@code position} argument.
     * 
     * @param position the position where to
     * get the object from
     * 
     * @return the object of this {@code Stage}
     * specified by the position {@code position}
     */
    public GameObject getObject(int position) {
        if(position < 0 || position >= objects.size()) {
            throw new IndexOutOfBoundsException (
                "cannot get object from position " + position +
                " (Only " + objects.size() + " objects)"
            );
        }

        return objects.get(position);
    }

    /**
     * Adds a foreground to this {@code Stage}. This
     * foreground will be the furthest from the camera.
     * If the {@code foreground} argument is {@code null},
     * though, it won't be added.
     * 
     * @param foreground the foreground to be added
     * 
     * @throws IllegalArgumentException if the {@code foreground}
     * argument is {@code null}
     */
    public void addForeground(Scenario foreground) {
        addFurthestForeground(foreground);
    }

    /**
     * Adds a foreground to this {@code Stage}. This
     * foreground will be the furthest from the camera.
     * If the {@code foreground} argument is {@code null},
     * though, it won't be added.
     * 
     * @param foreground the foreground to be added
     * 
     * @throws IllegalArgumentException if the {@code foreground}
     * argument is {@code null}
     */
    public void addFurthestForeground(Scenario foreground) {
        if(foreground == null) {
            throw new IllegalArgumentException("cannot add null foreground");
        }

        foreground.setStage(this);
        foregrounds.add(foreground);
    }

    /**
     * Adds a foreground to this {@code Stage} at
     * the specified {@code position}. The position
     * means how far between the foregrounds this one
     * will be from the camera. It must be a value
     * between {@code 0} and the amount of foregrounds
     * already in this {@code Stage}.
     * 
     * @param position the position where to add this foreground
     * @param foreground the foreground to be added
     * 
     * @throws IndexOutOfBoundsException if the {@code position}
     * argument is less than {@code 0} or greater than the
     * amount of foregrounds already added to this {@code Stage}
     * @throws IllegalArgumentException if the {@code foreground}
     * argument is {@code null}
     */
    public void addNthForeground(int position, Scenario foreground) {
        if(position < 0 || position > foregrounds.size()) {
            throw new IndexOutOfBoundsException (
                "cannot add foreground to position " + position +
                " (Only " + foregrounds.size() + " foregrounds)"
            );
        }
        if(foreground == null) {
            throw new IllegalArgumentException("cannot add null foreground");
        }

        foreground.setStage(this);
        foregrounds.add(position, foreground);
    }

    /**
     * Adds a foreground to this {@code Stage}. This
     * foreground will be the closest to the camera.
     * If it is {@code null}, though, it won't be added.
     * 
     * @param foreground the foreground to be added
     * 
     * @throws IllegalArgumentException if the {@code foreground}
     * argument is {@code null}
     */
    public void addClosestForeground(Scenario foreground) {
        if(foreground == null) {
            throw new IllegalArgumentException("cannot add null foreground");
        }

        foreground.setStage(this);
        foregrounds.add(0, foreground);
    }

    /**
     * Removes the furthest foreground of this
     * {@code Stage}. If it already has no foregrounds
     * this method won't do anything.
     * 
     * @return the removed foreground or {@code null}
     * if no foreground is removed
     */
    public Scenario removeFurthestForeground() {
        if(foregrounds.isEmpty()) {
            return null;
        }

        Scenario removedForeground = foregrounds.remove(foregrounds.size() - 1);
        removedForeground.setStage(null);
        return removedForeground;
    }

    /**
     * Removes the foreground at the specified position.
     * The position means how far the foreground is from the
     * camera. It must be between {@code 0} and the amount
     * of foregrounds already in this {@code Stage} minus {@code 1}.
     * If this {@code Stage} has no foregrounds nothing will
     * happen.
     * 
     * @param position the position where to remove a foreground from
     * 
     * @return the removed foreground or {@code null} if no
     * foreground is removed
     * 
     * @throws IndexOutOfBoundsException if the {@code position}
     * argument is less than {@code 0} or greater or equal to the
     * amount of foregrounds in this {@code Stage}
     */
    public Scenario removeNthForeground(int position) {
        if(foregrounds.isEmpty()) {
            return null;
        }
        if(position < 0 || position >= foregrounds.size()) {
            throw new IndexOutOfBoundsException (
                "cannot remove foreground in position " + position +
                " (Only " + foregrounds.size() + " foregrounds)"
            );
        }

        Scenario removedForeground = foregrounds.remove(position);
        removedForeground.setStage(null);
        return removedForeground;
    }

    /**
     * Removes the passed {@code foreground} from
     * this {@code Stage}'s foregrounds, if it is present.
     * 
     * @param foreground the foreground to be removed
     */
    public void removeForeground(Scenario foreground) {
        if(foregrounds.remove(foreground)) {
            foreground.setStage(null);
        }
    }

    /**
     * Removes the closest foreground of this
     * {@code Stage}. If it already has no
     * foregrounds this method won't do anything.
     * 
     * @return the removed foreground or {@code null}
     * if no foreground is removed
     */
    public Scenario removeClosestForeground() {
        if(foregrounds.isEmpty()) {
            return null;
        }

        Scenario removedForeground = foregrounds.remove(0);
        removedForeground.setStage(null);
        return removedForeground;
    }

    /**
     * Returns this {@code Stage}'s foregrounds.
     * 
     * @return the foregrounds of this {@code Stage}
     */
    public ArrayList<Scenario> getForegrounds() {
        return foregrounds;
    }

    /**
     * Returns the foreground specified by the
     * {@code position} argument. This argument
     * means how far the foreground is from the
     * camera. It must be a number between {@code 0}
     * and the amount of foregrounds in this
     * {@code Stage} minus {@code 1}.
     * 
     * @param position the position of the
     * foreground to get
     * 
     * @return the foreground specified by the
     * {@code position} argument
     * 
     * @throws IndexOutOfBoundsException if the
     * {@code position} argument is less than {@code 0}
     * or greater or equal to the amount of foregrounds
     * in this {@code Stage}
     */
    public Scenario getForeground(int position) {
        if(position < 0 || position >= foregrounds.size()) {
            throw new IndexOutOfBoundsException (
                "cannot get foreground in position " + position +
                " (Only " + foregrounds.size() + " foregrounds)"
            );
        }

        return foregrounds.get(position);
    }

    /**
     * Starts every background of this
     * {@code Stage} from the furthest to
     * the closest to the camera.
     */
    private void startBackgrounds() {
        for(int i = backgrounds.size() - 1; i >= 0; i--) {
            backgrounds.get(i).start();
        }
    }

    /**
     * Updates every background of this
     * {@code Stage} from the furthest to
     * the closest to the camera.
     */
    private void updateBackgrounds() {
        for(int i = backgrounds.size() - 1; i >= 0; i--) {
            backgrounds.get(i).update();
        }
    }

    /**
     * Draws every background of this
     * {@code Stage} from the furthest to
     * the closest to the camera.
     * 
     * @param g2 a {@code Graphics2D} with
     * which the backgrounds are drawn
     */
    private void drawBackgrounds(Graphics2D g2) {
        for(int i = backgrounds.size() - 1; i >= 0; i--) {
            backgrounds.get(i).draw(g2);
        }
    }

    /**
     * Starts every object of this
     * {@code Stage}.
     */
    private void startObjects() {
        for(GameObject object : objects) {
            object.start();
        }
    }

    /**
     * Updates every object of this
     * {@code Stage}.
     */
    private void updateObjects() {
        for(GameObject object : objects) {
            object.update();
        }
    }

    /**
     * Draws every object of this
     * {@code Stage}.
     * 
     * @param g2 a {@code Graphics2D} with
     * which the objects are drawn
     */
    private void drawObjects(Graphics2D g2) {
        for(GameObject object : objects) {
            object.draw(g2);
        }
    }

    /**
     * Starts every foreground of this
     * {@code Stage} from the furthest to
     * the closest to the camera.
     */
    private void startForegrounds() {
        for(int i = foregrounds.size() - 1; i >= 0; i--) {
            foregrounds.get(i).start();
        }
    }

    /**
     * Updates every foreground of this
     * {@code Stage} from the furthest to
     * the closest to the camera.
     */
    private void updateForegrounds() {
        for(int i = foregrounds.size() - 1; i >= 0; i--) {
            foregrounds.get(i).update();
        }
    }

    /**
     * Draws every foreground of this
     * {@code Stage} from the furthest to
     * the closest to the camera.
     * 
     * @param g2 a {@code Graphics2D} with
     * which the foregrounds are drawn
     */
    private void drawForegrounds(Graphics2D g2) {
        for(int i = foregrounds.size() - 1; i >= 0; i--) {
            foregrounds.get(i).draw(g2);
        }
    }

    /**
     * Executes the {@code start} method of
     * the backgrounds, objects and foregrounds
     * of this {@code Stage}.
     * <p>
     * Also Executes this {@code Stage}'s
     * {@code onStart} method.
     * 
     * @see #onStart()
     */
    public void start() {
        startBackgrounds();
        startObjects();
        startForegrounds();

        onStart();
    }

    /**
     * This method is used to define what
     * should happen when this {@code Stage}
     * is started.
     */
    public abstract void onStart();

    /**
     * This method is executed every
     * frame to call the {@code update}
     * method of the backgrounds, objects
     * and foregrounds of this {@code Stage}.
     * <p>
     * This method also calls this
     * {@code Stage}'s {@code onUpdate}
     * method.
     * 
     * @see #onUpdate()
     */
    public void update() {
        updateBackgrounds();
        updateObjects();
        updateForegrounds();

        onUpdate();
    }

    /**
     * This method is used to define what
     * should happen when this {@code Stage}
     * is updated.
     */
    public abstract void onUpdate();

    /**
     * This method is executed every frame
     * to call the {@code draw} method of
     * the backgrounds, objects and foregrounds
     * of this {@code Stage}, passing the
     * {@code g2} argument.
     * <p>
     * This method also calls this 
     * {@code Stage}'s {@code onDraw} method.
     * 
     * @param g2 the {@code Graphics2D} instance
     *           to draw this {@code Stage}'s
     *           objects with
     * 
     * @see #onDraw(Graphics2D)
     */
    public void draw(Graphics2D g2) {
        drawBackgrounds(g2);
        drawObjects(g2);
        drawForegrounds(g2);
        
        onDraw(g2);
    }

    /**
     * This method is used to define what
     * should happen every time this
     * {@code Stage} is drawn.
     * <p>
     * The {@code g2} parameter is used to
     * do optional customized drawings.
     * 
     * @param g2 a {@code Graphics2D} instance
     * to draw with
     */
    public abstract void onDraw(Graphics2D g2);

}