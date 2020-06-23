package lists;

public interface Node<T> {
    Node<T> next();
    void setNext(Node<T> next);
    T getElement();
}
