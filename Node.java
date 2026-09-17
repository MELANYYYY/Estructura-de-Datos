public class Node<E> {
    protected E info;
    protected Node<E> next;

    /**
     * Constructor que inicializa un nodo con información y siguiente en null.
     * @param info Información a almacenar en el nodo
     */
    public Node(E info) {
        this.info = info;
        this.next = null;
    }

    /**
     * Constructor que inicializa un nodo con información y referencia al siguiente nodo.
     * @param info Información a almacenar en el nodo
     * @param next Referencia al siguiente nodo
     */
    public Node(E info, Node<E> next) {
        this.info = info;
        this.next = next;
    }

    /**
     * Obtiene la información almacenada en el nodo.
     * @return La información del nodo
     */
    public E getInfo() {
        return info;
    }

    /**
     * Establece la información del nodo.
     * @param info Información a establecer
     */
    public void setInfo(E info) {
        this.info = info;
    }

    /**
     * Obtiene el nodo siguiente.
     * @return El nodo siguiente o null si es el último
     */
    public Node<E> getNext() {
        return next;
    }

    /**
     * Establece el nodo siguiente.
     * @param next El nodo a establecer como siguiente
     */
    public void setNext(Node<E> next) {
        this.next = next;
    }
}