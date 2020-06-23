package lists;

public interface List<T> {
    /**
     * current size of the list
     * @return size of the list (0 if empty)
     */
    int size();

    /**
     * check if the list has any elements
     * @return the boolean value true if the list is empty, otherwise false
     */
    boolean isEmpty();

    /**
     * get an element at index i
     * @param i index
     * @return element at index i
     * @throws IndexOutOfBoundsException when the requested index does not exist
     */
    T get(int i) throws IndexOutOfBoundsException;

    /**
     * set an element at index i
     * @param i index
     * @return replaced element
     * @throws IndexOutOfBoundsException when the requested index does not exist
     */
    T set(int i) throws IndexOutOfBoundsException;

    /**
     * add element at index i, shifting all subsequent elements later
     * @param i index
     * @param e new element to add
     * @throws IndexOutOfBoundsException when requested index does not exist
     */
    void add(int i, T e) throws IndexOutOfBoundsException;

    /**
     * remove element at index i, shifting all subsequent elements earlier
     * @param i index
     * @return removed element
     * @throws IndexOutOfBoundsException when requested index does not exist
     */
    T remove(int i) throws IndexOutOfBoundsException;
}
