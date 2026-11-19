package graphics.rasterizer;

import graphics.Raster;
import transforms.Point2D;
import transforms.Vec2D;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public final class GraphicsLineRasterizer implements LineRasterizer {

    private final Raster raster;

    /* -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=- Constructors -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */

    public GraphicsLineRasterizer(Raster raster) {
        this.raster = raster;
    }

    /* -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=- */

    @Override
    public void rasterize(Point2D point1, Point2D point2, int color) {
        Vec2D start = point1.dehomog().orElse(null);
        Vec2D end = point2.dehomog().orElse(null);
        if (start == null || end == null) {
            return;
        }

        Graphics2D graphics = raster.createGraphics();
        try {
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            graphics.setColor(new Color(color, true));
            graphics.drawLine(
                (int) Math.round(start.getX()),
                (int) Math.round(start.getY()),
                (int) Math.round(end.getX()),
                (int) Math.round(end.getY())
            );
        } finally {
            graphics.dispose();
        }
    }

}
