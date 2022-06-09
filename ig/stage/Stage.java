package ig.stage;

import java.util.ArrayList;
import java.awt.Graphics2D;

import ig.flow.GameFluid;
import ig.scenario.Scenario;
import ig.object.GameObject;

// TODO draw backgrounds and foregrounds
// TODO throw exception if addNthBack/Foreground receives a invalid position
// TODO throw exception if removeNthBack/Foreground receives a invalid position
/**
 * Class for creating a stage for a {@code Game}.
 * 
 * @author Daniel O Sousa
 */
public abstract class Stage implements GameFluid {

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
     * Constructor for a {@code Stage}.
     */
    public Stage() {

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
     */
    public void setWidth(int width) {
        if(width >= 0) {
            this.width = width;
        }
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
     */
    public void setHeight(int height) {
        if(height >= 0) {
            this.height = height;
        }
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
     */
    public void setDimensions(int width, int height) {
        setWidth(width);
        setHeight(height);
    }

    /**
     * Adds a background to this {@code Stage}. This
     * background will be the furthest from the camera.
     * 
     * @param background the background to be added
     */
    public void addFurtherBackground(Scenario background) {
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
     */
    public void addNthBackground(int position, Scenario background) {
        backgrounds.add(position, background);
    }

    /**
     * Adds a background to this {@code Stage}. This
     * background will be the closest to the camera.
     * 
     * @param background the background to be added
     */
    public void addCloserBackground(Scenario background) {
        backgrounds.add(0, background);
    }

    /**
     * Removes the furthest background of this
     * {@code Stage}. If it already has no backgrounds
     * this method won't do anything.
     * 
     * @return the removed background
     */
    public Scenario removeFurtherBackground() {
        if(backgrounds.isEmpty()) {
            return null;
        }

        return backgrounds.remove(backgrounds.size() - 1);
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
     * @return the removed background
     */
    public Scenario removeNthBackground(int position) {
        if(backgrounds.isEmpty()) {
            return null;
        }

        return backgrounds.remove(position);
    }

    /**
     * Removes the passed {@code background} from
     * this {@code Stage}'s backgrounds, if it is present.
     * 
     * @param background the background to be removed
     */
    public void removeBackground(Scenario background) {
        backgrounds.remove(background);
    }

    /**
     * Removes the closest background of this
     * {@code Stage}. If it already has no
     * backgrounds this method won't do anything.
     * 
     * @return the removed background
     */
    public Scenario removeCloserBackground() {
        if(backgrounds.isEmpty()) {
            return null;
        }

        return backgrounds.remove(0);
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
     * Adds a foreground to this {@code Stage}. This
     * foreground will be the furthest from the camera.
     * 
     * @param foreground the foreground to be added
     */
    public void addFurtherForeground(Scenario foreground) {
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
     */
    public void addNthForeground(int position, Scenario foreground) {
        foregrounds.add(position, foreground);
    }

    /**
     * Adds a foreground to this {@code Stage}. This
     * foreground will be the closest to the camera.
     * 
     * @param foreground the foreground to be added
     */
    public void addCloserForeground(Scenario foreground) {
        foregrounds.add(0, foreground);
    }

    /**
     * Removes the furthest foreground of this
     * {@code Stage}. If it already has no foregrounds
     * this method won't do anything.
     * 
     * @return the removed foreground
     */
    public Scenario removeFurtherForeground() {
        if(foregrounds.isEmpty()) {
            return null;
        }

        return foregrounds.remove(foregrounds.size() - 1);
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
     * @return the removed foreground
     */
    public Scenario removeNthForeground(int position) {
        if(foregrounds.isEmpty()) {
            return null;
        }

        return foregrounds.remove(position);
    }

    /**
     * Removes the passed {@code foreground} from
     * this {@code Stage}'s foregrounds, if it is present.
     * 
     * @param foreground the foreground to be removed
     */
    public void removeForeground(Scenario foreground) {
        foregrounds.remove(foreground);
    }

    /**
     * Removes the closest foreground of this
     * {@code Stage}. If it already has no
     * foregrounds this method won't do anything.
     * 
     * @return the removed foreground
     */
    public Scenario removeCloserForeground() {
        if(foregrounds.isEmpty()) {
            return null;
        }

        return foregrounds.remove(0);
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
     * Adds a {@code GameObject} to the
     * objects of this {@code Stage}.
     * 
     * @param object the {@code GameObject} to be added
     */
    public void addObject(GameObject object) {
        objects.add(object);
    }

    /**
     * Removes the specified {@code GameObject}
     * of this {@code Stage}.
     * 
     * @param object the {@code GameObject} to be
     *               removed
     */
    public void removeObject(GameObject object) {
        objects.remove(object);
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

    private void startObjects() {
        for(GameObject object : objects) {
            object.start();
        }
    }

    private void updateObjects() {
        for(GameObject object : objects) {
            object.update();
        }
    }

    private void drawObjects(Graphics2D g2) {
        for(GameObject object : objects) {
            object.draw(g2);
        }
    }

    /**
     * Executes the {@code start} method of
     * the objects of this {@code Stage}.
     * <p>
     * Also Executes this {@code Stage}'s
     * {@code onStart} method.
     * 
     * @see #onStart()
     */
    public void start() {
        startObjects();

        onStart();
    }

    /**
     * This method is used to define what
     * should happen when this {@code Stage}
     * is started.
     * 
     * @see #start()
     */
    public abstract void onStart();

    /**
     * This method is executed every
     * frame to call the {@code update}
     * method of the objects of this
     * {@code Stage}.
     * <p>
     * This method also calls this
     * {@code Stage}'s {@code onUpdate}
     * method.
     * 
     * @see #onUpdate()
     */
    public void update() {
        updateObjects();

        onUpdate();
    }

    /**
     * This method is used to define what
     * should happen when this {@code Stage}
     * is updated.
     * 
     * @see #update()
     */
    public abstract void onUpdate();

    /**
     * This method is executed every frame
     * to call the {@code draw} method of
     * the objects of this {@code Stage},
     * passing the {@code g2} argument.
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
        drawObjects(g2);
        
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
     *           to draw with
     * 
     * @see #draw(Graphics2D)
     */
    public abstract void onDraw(Graphics2D g2);

}