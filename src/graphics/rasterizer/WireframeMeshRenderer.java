package graphics.rasterizer;

import graphics.mesh.Solid;
import graphics.viewport.Viewport;

import java.awt.Color;

public final class WireframeMeshRenderer implements MeshRenderer {

    private final LineRasterizer lineRasterizer;

    public WireframeMeshRenderer(LineRasterizer lineRasterizer) {
        this.lineRasterizer = lineRasterizer;
    }

    @Override
    public void render(Iterable<? extends Solid> solids, Viewport viewport, int color) {
        // TODO (cvičení 9): Pro každé těleso (Solid) načtěte vertexový a indexový buffer.
        // TODO (cvičení 9): Indexy zpracovávejte po trojicích, které určují jednotlivé trojúhelníky.

        // TODO (cvičení 9): Pomocí indexů získejte tři vrcholy (Point3D) a převeďte je z NDC do souřadnic okna pomocí viewport.toWindow().
        // TODO (cvičení 9): Vykreslete všechny tři hrany trojúhelníku pomocí lineRasterizer.rasterize().
    }

    @Override
    public void render(Iterable<? extends Solid> solids, Viewport viewport, Color color) {
        render(solids, viewport, color.getRGB());
    }

}
