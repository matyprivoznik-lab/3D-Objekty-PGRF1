package graphics.viewport;

import transforms.Point2D;
import transforms.Point3D;
import transforms.Vec3D;

public final class Viewport {

    private final int width;
    private final int height;

    public Viewport(int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Viewport dimensions must be positive");
        }
        this.width = width;
        this.height = height;
    }

    public Point2D toWindow(Point3D pointInNdc) {
        Vec3D point = pointInNdc.dehomog().orElseThrow(() -> new IllegalArgumentException("NDC point cannot have w = 0"));
        double y = (1.0 - point.getY()) * (height - 1) / 2.0;
        double x = (point.getX() + 1.0) * (width - 1) / 2.0;
        return new Point2D(x, y);
    }

}
