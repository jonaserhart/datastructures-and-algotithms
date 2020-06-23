package lists;

public class ListNode<T> implements Node<T> {

    private T element;
    private Node<T> next;

    public ListNode(T e, Node<T> next){

    }

    @Override
    public Node<T> next() {
        return next;
    }

    @Override
    public void setNext(Node<T> next) {
        this.next = next;
    }

    @Override
    public T getElement() {
        return element;
    }
}
