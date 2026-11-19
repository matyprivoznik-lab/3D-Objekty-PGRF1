package graphics.mesh;

import graphics.buffer.IndexBuffer;
import graphics.buffer.VertexBuffer;

public abstract class Solid {

    private final IndexBuffer indexBuffer;
    private final VertexBuffer vertexBuffer;

    protected Solid(VertexBuffer vertexBuffer, IndexBuffer indexBuffer) {
        if (vertexBuffer == null || indexBuffer == null) {
            throw new IllegalArgumentException("Solid buffers must not be null");
        }
        if (indexBuffer.size() % 3 != 0) {
            throw new IllegalArgumentException("Triangle index count must be divisible by three");
        }

        for (int i = 0; i < indexBuffer.size(); i++) {
            int vertexIndex = indexBuffer.get(i);
            if (vertexIndex < 0 || vertexIndex >= vertexBuffer.size()) {
                throw new IllegalArgumentException("Vertex index out of range: " + vertexIndex);
            }
        }

        this.vertexBuffer = vertexBuffer;
        this.indexBuffer = indexBuffer;
    }

    public IndexBuffer getIndexBuffer() {
        return indexBuffer;
    }

    public VertexBuffer getVertexBuffer() {
        return vertexBuffer;
    }

}
