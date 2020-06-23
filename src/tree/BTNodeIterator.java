package tree;
import java.util.Iterator;

/**
 * Snapshot iterator for Binary Tree
 * @param <T> type of binary tree
 */
public class BTNodeIterator<T> implements Iterator<Position<T>> {

    private Position<T> cursor;
    private Position<T> recent = null;
    private Position<T> root;

    public BTNodeIterator(BTNode<T> root){
        this.root = root;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Position<T> next() {
        return null;
    }
}
