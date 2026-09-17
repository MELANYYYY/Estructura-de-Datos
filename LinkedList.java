public class LinkedList<E> implements IList<E> {
    private Node<E> first;
    private int size;

    /**
     * Constructor que inicializa una lista vacía.
     */
    public LinkedList() {
        this.first = null;
        this.size = 0;
    }

    /**
     * Añade un elemento al final de la lista enlazada.
     * @param e Elemento a añadir
     */
    @Override
    public void add(E e) {
        Node<E> newNode = new Node<>(e);

        if (isEmpty()) {
            first = newNode;
        } else {
            Node<E> cursor = first;
            while (cursor.getNext() != null) {
                cursor = cursor.getNext();
            }
            cursor.setNext(newNode);
        }
        size++;
    }

    /**
     * Añade un elemento en una posición específica de la lista enlazada.
     * @param e Elemento a añadir
     * @param index Posición donde insertar
     * @throws IndexOutOfBoundsException si el índice está fuera de rango
     */
    @Override
    public void add(E e, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);
        }

        Node<E> newNode = new Node<>(e);

        if (index == 0) {
            // Insertar al principio
            newNode.setNext(first);
            first = newNode;
        } else {
            // Recorrer hasta la posición index - 1
            Node<E> cursor = first;
            for (int i = 0; i < index - 1; i++) {
                cursor = cursor.getNext();
            }
            newNode.setNext(cursor.getNext());
            cursor.setNext(newNode);
        }
        size++;
    }

    /**
     * Elimina el elemento en la posición específica.
     * @param index Posición del elemento a eliminar
     * @return El elemento eliminado
     * @throws IndexOutOfBoundsException si el índice está fuera de rango
     */
    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);
        }

        Node<E> aux;

        if (index == 0) {
            // Eliminar el primer nodo
            aux = first;
            first = first.getNext();
        } else {
            // Recorrer hasta la posición index - 1
            Node<E> cursor = first;
            for (int i = 0; i < index - 1; i++) {
                cursor = cursor.getNext();
            }
            aux = cursor.getNext();
            cursor.setNext(aux.getNext());
        }
        size--;
        return aux.getInfo();
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

        Node<E> cursor = first;
        for (int i = 0; i < index; i++) {
            cursor = cursor.getNext();
        }
        return cursor.getInfo();
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
     * Vacía la lista enlazada.
     */
    @Override
    public void clear() {
        first = null;
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
        Node<E> cursor = first;
        while (cursor != null) {
            sb.append(cursor.getInfo());
            if (cursor.getNext() != null) {
                sb.append(", ");
            }
            cursor = cursor.getNext();
        }
        sb.append("]");
        return sb.toString();
    }
}