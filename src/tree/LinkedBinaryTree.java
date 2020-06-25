package tree;

import lists.Node;

import java.util.Iterator;

public class LinkedBinaryTree<T> extends AbstractBinaryTree<T> {

    protected BTNode<T> createNode(T element, BTNode<T> parent, BTNode<T> left, BTNode<T> right){
        return new BTNode<>(element, parent, left, right);
    }

    protected BTNode<T> root = null;
    private int size = 0;

    public LinkedBinaryTree() { }

    protected BTNode<T> validate(Position<T> p) throws IllegalArgumentException{
        if(!(p instanceof BTNode))
            throw new IllegalArgumentException("Not a valid position type");
        var node = (BTNode<T>) p;
        if(node.getParent() == node)
            throw new IllegalArgumentException("Node not in tree");
        return node;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Position<T> root() {
        return root;
    }

    @Override
    public Position<T> parent(Position<T> p) {
        var node = validate(p);
        return node.getParent();
    }

    @Override
    public Position<T> left(Position<T> p) throws IllegalArgumentException {
        var node = validate(p);
        return node.getLeft();
    }

    @Override
    public Position<T> right(Position<T> p) throws IllegalArgumentException {
        var node = validate(p);
        return node.getRight();
    }

    public Position<T> addRoot(T element) throws IllegalStateException{
        if(!isEmpty())
            throw new IllegalStateException("Tree is not empty");
        var root = createNode(element, null,null, null);
        size = 1;
        return root;
    }

    public Position<T> addLeft(Position<T> p, T element) throws IllegalArgumentException{
        var parent = validate(p);
        if(parent.getLeft() != null)
            throw new IllegalArgumentException("Already has left child");
        var child = createNode(element, parent, null,null);
        parent.setLeft(child);
        return child;
    }

    public Position<T> addRight(Position<T> p, T element) throws IllegalArgumentException{
        var parent = validate(p);
        if(parent.getRight() != null)
            throw new IllegalArgumentException("Already has right child");
        var child = createNode(element, parent, null,null);
        parent.setRight(child);
        return child;
    }

    public T set(Position<T> p, T element){
        var node = validate(p);
        var replaced = node.getElement();
        node.setElement(element);
        return replaced;
    }

    public T remove(Position<T> p) throws IllegalArgumentException{
        var nodeToRemove = validate(p);
        if(numChildren(p) == 2)
            throw new IllegalArgumentException("p has two children");

        var child = (nodeToRemove.getLeft() == null) ? nodeToRemove.getRight() : nodeToRemove.getLeft();
        var parent = nodeToRemove.getParent();
        if(child != null)
            child.setParent(parent);
        if(nodeToRemove == root) {
            root = child;
        }
        else{
            if(nodeToRemove == parent.getLeft())
                parent.setLeft(child);
            else
                parent.setRight(child);
        }
        size--;
        var removedElement = nodeToRemove.getElement();
        nodeToRemove.setElement(null);
        nodeToRemove.setRight(null);
        nodeToRemove.setLeft(null);
        nodeToRemove.setParent(nodeToRemove);
        return removedElement;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Iterable<Position<T>> positions() {
        return null;
    }
}
