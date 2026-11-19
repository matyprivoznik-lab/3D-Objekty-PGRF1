package graphics.mesh;

import graphics.buffer.IndexBuffer;
import graphics.buffer.VertexBuffer;
import transforms.Point3D;

public final class Triangle extends Solid {

    public Triangle() {
        // TODO (cvičení 9): Definujte tři vrcholy ve VertexBufferu v NDC souřadnicích (x, y ∈ [-1, 1], z ∈ [0, 1]).
        // TODO (cvičení 9): Vytvořte IndexBuffer s indexy (0, 1, 2) a oba buffery předejte nadřazené třídě pomocí super(...).
        super(
            new VertexBuffer(
                    new Point3D(-0.65, -0.55,0.0),
                    new Point3D(0.65, -0.55,0.0),
                    new Point3D(0.0, 0.65,0.0)
            ),
            new IndexBuffer()
        );
    }

}
