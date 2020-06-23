package tree;

public abstract class AbstractTree<T> implements Tree<T>{

    public int heigth(Position<T> p){
        var h = 0;
        for (var child: children(p))
            h = Math.max(h, 1 + heigth(child));
        return h;
    }

    public int depth(Position<T> p){
        if(isRoot(p))
            return 0;
        else
            return 1 + depth(parent(p));
    }

    @Override
    public boolean isInternal(Position<T> p) throws IllegalArgumentException {
        return numChildren(p) > 0;
    }

    @Override
    public boolean isExternal(Position<T> p) throws IllegalArgumentException {
        return numChildren(p) == 0;
    }

    @Override
    public boolean isRoot(Position<T> p) throws IllegalArgumentException {
        return p == root();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}
