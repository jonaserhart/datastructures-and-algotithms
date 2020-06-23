package lists;

import java.util.Iterator;

public class ElementIterator<T> implements Iterator<T> {

    Iterator<Position<T>> positionIterator;

    public ElementIterator(PositionalList<T> list){
        assert list != null;
        positionIterator = new PositionIterator<>(list);
    }

    @Override
    public boolean hasNext() {
        return positionIterator.hasNext();
    }

    @Override
    public T next() {
        return positionIterator.next().getElement();
    }
}
