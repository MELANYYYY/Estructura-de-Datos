public class ArrayList<E> implements IList<E> {
    private Object[] items;
    private int size;
    private int capacity;

    public ArrayList() {
        this.capacity = 10;
        this.items = new Object[capacity];
        this.size = 0;
    }

    protected boolean isFull() {
        return size == capacity;
    }

    protected void expand() {
        Object[] aux = new Object[capacity + 10];
        System.arraycopy(items, 0, aux, 0, size);
        capacity += 10;
        items = aux;
    }

    @Override
    public void add(E e) {
        if (isFull()) {
            expand();
        }
        items[size++] = e;
    }

    @Override
    public void add(E e, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);
        }

        if (isFull()) {
            expand();
        }

        for (int i = size; i > index; i--) {
            items[i] = items[i - 1];
        }

        items[index] = e;
        size++;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);
        }

        @SuppressWarnings("unchecked")
        E aux = (E) items[index];

        for (int i = index; i < size - 1; i++) {
            items[i] = items[i + 1];
        }

        items[size - 1] = null;
        size--;
        return aux;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);
        }

        @SuppressWarnings("unchecked")
        E result = (E) items[index];
        return result;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        items = new Object[10];
        capacity = 10;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(items[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
