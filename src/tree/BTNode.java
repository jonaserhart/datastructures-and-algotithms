package tree;

public class BTNode<T> implements Position<T> {
    private T element;
    private BTNode<T> parent;
    private BTNode<T> left;
    private BTNode<T> right;

    public BTNode(T element, BTNode<T> parent, BTNode<T> left, BTNode<T> right) {
        this.element = element;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    @Override
    public T getElement() {
        return element;
    }

    @Override
    public void setElement(T element) {
        this.element = element;
    }

    public BTNode<T> getParent() {
        return parent;
    }

    public void setParent(BTNode<T> parent) {
        this.parent = parent;
    }

    public BTNode<T> getLeft() {
        return left;
    }

    public void setLeft(BTNode<T> left) {
        this.left = left;
    }

    public BTNode<T> getRight() {
        return right;
    }

    public void setRight(BTNode<T> right) {
        this.right = right;
    }
}
