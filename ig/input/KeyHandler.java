package ig.input;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * The {@code KeyHandler} class is used for
 * knowing which keyboard keys are currently
 * pressed.
 * <p>
 * To use it, you must add it to a
 * {@code Component} using the method
 * {@code addKeyListener}.
 * 
 * @author Daniel O Sousa
 */
public class KeyHandler implements KeyListener {

    /**
     * Array list for storing the codes of the keys
     * that are currently pressed.
     */
    private ArrayList<Integer> activeKeys = new ArrayList<Integer>();

    

    /**
     * Returns an array list storing the codes
     * of the currently pressed keys.
     * 
     * @return array list with codes of the
     * currently pressed keys
     */
    public ArrayList<Integer> getActiveKeys() {
        return this.activeKeys;
    }
    
    /**
     * Adds the passed {@code keyCode} to the
     * {@code activeKeys} array list to represent
     * a pressed key. However, does nothing if the
     * key code is already in there.
     * 
     * @param keyCode the code of the key to
     * add to {@code activeKeys}
     * 
     * @see #removeKey(int)
     * @see #activeKeys
     */
    private void addKey(int keyCode) {
        if(!activeKeys.contains(keyCode)) {
            activeKeys.add(keyCode);
        }
    }

    /**
     * Removes the specified {@code keyCode}
     * from the {@code activeKeys} array list,
     * if it is there.
     * 
     * @param keyCode the key code to remove
     * from {@code activeKeys}
     * 
     * @see #addKey(int)
     * @see #activeKeys
     */
    private void removeKey(int keyCode) {
        activeKeys.remove((Integer) keyCode);
    }

    /**
     * Verifies if a key specified by the
     * passed {@code keyCode} argument
     * is currently pressed, returning {@code true}
     * in that case and {@code false} otherwise.
     * 
     * @param keyCode the code of the key to verify
     * if is pressed
     * 
     * @return a boolean telling if the key specified
     * by the passed {@code keyCode} is currently
     * pressed
     */
    public boolean isPressed(int keyCode) {
        return activeKeys.contains(keyCode);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    
    /**
     * {@inheritDoc}
     * <p>
     * Also adds the pressed key's code to
     * the {@code activeKeys} array list.
     */
    @Override
    public void keyPressed(KeyEvent e) {
        addKey(e.getKeyCode());
    }

    /**
     * {@inheritDoc}
     * <p>
     * Also removes the released key's code
     * from the {@code activeKeys} array list.
     */
    @Override
    public void keyReleased(KeyEvent e) {
        removeKey(e.getKeyCode());
    }

}