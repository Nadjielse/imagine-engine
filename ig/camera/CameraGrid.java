package ig.camera;

import ig.game.GameElement;

public class CameraGrid extends GameElement {

    public CameraGrid(int x, int y, int width, int height) {
        setCoordinates(x, y);
        setSize(width, height);
    }

}