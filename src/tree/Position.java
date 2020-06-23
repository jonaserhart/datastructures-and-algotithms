package tree;

public interface Position<T> {
    T getElement() throws IllegalStateException;
    void setElement(T element) throws IllegalStateException;
}