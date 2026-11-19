package graphics.buffer;

public class IndexBuffer {

    private final int[] internalIndices;

    public IndexBuffer(int... indices) {
        // TODO (cvičení 9): Vytvořte interní pole indexů a pomocí clone() do něj uložte kopii vstupního pole.
        this.internalIndices = indices.clone();
    }

    public int size() {
        // TODO (cvičení 9): Vraťte počet indexů uložených v interním poli.
        return 0;
    }

    public int get(int index) {
        // TODO (cvičení 9): Vraťte index na zadané pozici pomocí přístupu do pole.
        return 0;
    }

}
