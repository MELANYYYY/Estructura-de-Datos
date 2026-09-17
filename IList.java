public interface IList<E> {
    /**
     * Añade un elemento al final de la lista.
     * @param e Elemento a añadir
     */
    void add(E e);

    /**
     * Añade un elemento en una posición específica.
     * @param e Elemento a añadir
     * @param index Posición donde insertar
     */
    void add(E e, int index);

    /**
     * Elimina el elemento en la posición especificada.
     * @param index Posición del elemento a eliminar
     * @return El elemento eliminado
     */
    E remove(int index);

    /**
     * Obtiene el elemento en la posición especificada.
     * @param index Posición del elemento
     * @return El elemento en esa posición
     */
    E get(int index);

    /**
     * Devuelve el número de elementos en la lista.
     * @return Tamaño de la lista
     */
    int size();

    /**
     * Vacía la lista eliminando todos los elementos.
     */
    void clear();

    /**
     * Verifica si la lista está vacía.
     * @return true si está vacía, false en caso contrario
     */
    boolean isEmpty();
}