package graphics.rasterizer;

import graphics.mesh.Solid;
import graphics.viewport.Viewport;

import java.awt.*;

public interface MeshRenderer {

    void render(Iterable<? extends Solid> solids, Viewport viewport, int color);
    void render(Iterable<? extends Solid> solids, Viewport viewport, Color color);

}
