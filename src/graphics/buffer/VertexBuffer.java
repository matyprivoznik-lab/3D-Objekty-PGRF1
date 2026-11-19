package graphics.buffer;

import transforms.Point3D;

public class VertexBuffer {

    private final Point3D[] internalVertex;

    public VertexBuffer(Point3D... vertices) {
        // TODO (cvičení 9): Vytvořte interní pole vrcholů a pomocí clone() do něj uložte kopii vstupního pole.
        this.internalVertex = vertices.clone();
    }

    public int size() {
        // TODO (cvičení 9): Vraťte počet vrcholů uložených v interním poli.
        return 0;
    }

    public Point3D get(int index) {
        // TODO (cvičení 9): Vraťte vrchol na zadaném indexu. Neplatný index automaticky vyvolá výjimku.
        return null;
    }

}
