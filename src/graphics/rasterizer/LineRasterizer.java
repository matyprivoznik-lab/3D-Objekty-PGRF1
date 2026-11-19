package graphics.rasterizer;

import transforms.Point2D;

public interface LineRasterizer {

    void rasterize(Point2D point1, Point2D point2, int color);

}
