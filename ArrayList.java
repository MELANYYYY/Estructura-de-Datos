public class ArrayList<E> implements IList<E> {
    private Object[] items;
    private int size;
    private int capacity;

    /**
     * Constructor que inicializa el ArrayList con capacidad inicial de 10.
     */
    public ArrayList() {
        this.capacity = 10;
        this.items = new Object[capacity];
        this.size = 0;
    }

    /**
     * Verifica si el arreglo está lleno.
     * @return true si size == capacity
     */
    protected boolean isFull() {
        return size == capacity;
    }

    /**
     * Expande la capacidad del arreglo aumentándola en 10.
     */
    protected void expand() {
        Object[] aux = new Object[capacity + 10];
        System.arraycopy(items, 0, aux, 0, size);
        capacity += 10;
        items = aux;
    }

    /**
     * Añade un elemento al final de la lista.
     * @param e Elemento a añadir
     */
    @Override
    public void add(E e) {
        if (isFull()) {
            expand();
        }
        items[size++] = e;
    }

    /**
     * Añade un elemento en una posición específica.
     * @param e Elemento a añadir
     * @param index Posición donde insertar
     * @throws IndexOutOfBoundsException si el índice está fuera de rango
     */
    @Override
    public void add(E e, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);
        }

        if (isFull()) {
            expand();
        }

        // Desplazar elementos hacia la derecha
        for (int i = size; i > index; i--) {
            items[i] = items[i - 1];
        }

        items[index] = e;
        size++;
    }

    /**
     * Elimina el elemento en la posición especificada.
     * @param index Posición del elemento a eliminar
     * @return El elemento eliminado
     * @throws IndexOutOfBoundsException si el índice está fuera de rango
     */
    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);
        }

        @SuppressWarnings("unchecked")
        E aux = (E) items[index];

        // Desplazar elementos hacia la izquierda
        for (int i = index; i < size - 1; i++) {
            items[i] = items[i + 1];
        }

        items[size - 1] = null; // Limpiar referencia
        size--;
        return aux;
    }

    /**
     * Obtiene el elemento en la posición especificada.
     * @param index Posición del elemento
     * @return El elemento en esa posición
     * @throws IndexOutOfBoundsException si el índice está fuera de rango
     */
    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);
        }

        @SuppressWarnings("unchecked")
        E result = (E) items[index];
        return result;
    }

    /**
     * Devuelve el número de elementos en la lista.
     * @return Tamaño de la lista
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Vacía la lista eliminando todos los elementos.
     */
    @Override
    public void clear() {
        items = new Object[10];
        capacity = 10;
        size = 0;
    }

    /**
     * Verifica si la lista está vacía.
     * @return true si está vacía
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Retorna una representación en String de la lista.
     * @return String con los elementos de la lista
     */
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