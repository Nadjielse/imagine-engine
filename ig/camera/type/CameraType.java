package ig.camera.type;

import java.awt.Graphics2D;

import ig.camera.CameraGrid;

public interface CameraType {

    void setGrid(CameraGrid grid);
    
    void update();

    void draw(Graphics2D g2);

}