package lists;

public interface Position<E> {
    int getIndex();

    void setIndex(int index);

    E getElement() throws IllegalStateException;

    void setElement(E element) throws IllegalStateException;
}
