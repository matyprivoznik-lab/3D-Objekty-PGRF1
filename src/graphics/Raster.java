package graphics;

import java.awt.*;

public interface Raster {

    int getWidth();
    int getHeight();
    void clear(Integer value);
    Graphics2D createGraphics();
    void present(Graphics graphics);

}
