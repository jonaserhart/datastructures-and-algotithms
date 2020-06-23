package tree;

import java.util.LinkedList;

public abstract class AbstractBinaryTree<T> extends AbstractTree<T> implements BinaryTree<T> {

    @Override
    public Position<T> sibling(Position<T> p) throws IllegalArgumentException {
        var parent = parent(p);
        if(parent == null) return null;
        if(p == left(parent))
            return right(parent);
        return left(parent);
    }

    @Override
    public Iterable<Position<T>> children(Position<T> p) throws IllegalArgumentException {
        var snapshot = new LinkedList<Position<T>>();
        if(left(p) != null)
            snapshot.add(p);
        if(right(p) != null)
            snapshot.add(p);
        return snapshot;
    }

    @Override
    public int numChildren(Position<T> p) throws IllegalArgumentException {
        var countOfChildren = 0;
        if(left(p) != null)
            countOfChildren++;
        if(right(p) != null)
            countOfChildren++;
        return countOfChildren;
    }
}
