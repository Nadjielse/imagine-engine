package ig.stage;

import java.util.ArrayList;
import java.awt.Graphics2D;

import ig.scenario.Scenario;
import ig.object.GameObject;

// TODO prevent errors from accessing scenario arraylists incorrectly
// TODO draw backgrounds and foregrounds
// TODO document
/**
 * Class for creating a stage for a {@code Game}.
 * 
 * @author Daniel O Sousa
 */
public class Stage {

    /**
     * The title of the stage.
     */
    private String title;

    /**
     * The width of the stage.
     */
    private int width;

    /**
     * The height of the stage.
     */
    private int height;

    private ArrayList<Scenario> backgrounds = new ArrayList<Scenario>();

    /**
     * The objects of the stage.
     */
    private ArrayList<GameObject> objects = new ArrayList<GameObject>();

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

    public void addFurtherBackground(Scenario background) {
        backgrounds.add(background);
    }

    public void addNthBackground(int position, Scenario background) {
        backgrounds.add(position, background);
    }

    public void addCloserBackground(Scenario background) {
        backgrounds.add(0, background);
    }

    public Scenario removeFurtherBackground() {
        return backgrounds.remove(backgrounds.size() - 1);
    }

    public Scenario removeNthBackground(int position) {
        return backgrounds.remove(position);
    }

    public void removeBackground(Scenario background) {
        backgrounds.remove(background);
    }

    public Scenario removeCloserBackground() {
        return backgrounds.remove(0);
    }

    public ArrayList<Scenario> getBackgrounds() {
        return backgrounds;
    }

    public void addFurtherForeground(Scenario foreground) {
        foregrounds.add(foreground);
    }

    public void addNthForeground(int position, Scenario foreground) {
        foregrounds.add(position, foreground);
    }

    public void addCloserForeground(Scenario foreground) {
        foregrounds.add(0, foreground);
    }

    public Scenario removeFurtherForeground() {
        return foregrounds.remove(foregrounds.size() - 1);
    }

    public Scenario removeNthForeground(int position) {
        return foregrounds.remove(position);
    }

    public void removeForeground(Scenario foreground) {
        foregrounds.remove(foreground);
    }

    public Scenario removeCloserForeground() {
        return foregrounds.remove(0);
    }

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
        for(GameObject object : objects) {
            object.start();
        }
        onStart();
    }

    /**
     * This method is used to define what
     * should happen when this {@code Stage}
     * is started.
     * 
     * @see #start()
     */
    protected void onStart() {

    }

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
        for(GameObject object : objects) {
            object.update();
        }
        onUpdate();
    }

    /**
     * This method is used to define what
     * should happen when this {@code Stage}
     * is updated.
     * 
     * @see #update()
     */
    protected void onUpdate() {

    }

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
        for(GameObject object : objects) {
            object.draw(g2);
        }
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
    protected void onDraw(Graphics2D g2) {

    }

}