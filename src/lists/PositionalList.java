package lists;

public interface PositionalList<T> {

    /**
     * Size of the list
     * @return number of elements in the list
     */
    int size();

    /**
     * Is the list empty?
     * @return true if the list is empty, otherwise false
     */
    boolean isEmpty();

    /**
     * Get the first element from the list
     * @return first element of the list (or null, if empty)
     */
    Position<T> first();

    /**
     * Get the last element from the list
     * @return last element of the list (or null, if empty)
     */
    Position<T> last();

    /**
     * inserts an element before a given position
     * @param position given position
     * @return position before given position (null, if previous position does not exist)
     * @throws IllegalArgumentException when given position does not exist
     */
    Position<T> before(Position<T> position) throws IllegalArgumentException;

    /**
     * inserts an element after given position
     * @param position given position
     * @return position after given position (null, if next position is end of the list)
     * @throws IllegalArgumentException when given position does not exist
     */
    Position<T> after(Position<T> position) throws IllegalArgumentException;

    /**
     * inserts an element at the first index
     * @param element element to be inserted at the front of the list
     * @return Position of the newly inserted element
     */
    Position<T> addFirst(T element);

    /**
     * @param element element to be inserted at the back of the list
     * @return Position of the newly inserted element
     */
    Position<T> addLast(T element);

    /**
     * inserts an element directly before given position
     * @param position given position
     * @param element element to insert before position
     * @return new position of the inserted element
     */
    Position<T> addBefore(Position<T> position, T element);

    /**
     * inserts element after given position
     * @param position given position
     * @param element element to insert
     * @return position of new element
     */
    Position<T> addAfter(Position<T> position, T element);

    /**
     * replaces element at position with new element
     * @param position position of the legacy element
     * @param element new element
     * @return replaced element
     * @throws IllegalArgumentException when position does not exist
     */
    T set(Position<T> position, T element) throws IllegalArgumentException;

    /**
     * removes the element stored at given position
     * @param position given position
     * @return removed element
     * @throws IllegalArgumentException when position does not exist
     */
    T remove (Position<T> position) throws IllegalArgumentException;

}
