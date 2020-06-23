package lists;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PositionIterator<T> implements Iterator<Position<T>> {
    private Position<T> cursor;
    private Position<T> recent = null;
    private PositionalList<T> elements;

    public PositionIterator(PositionalList<T> list){
        elements = list;
        cursor = list.first();
    }

    @Override
    public boolean hasNext() {
        return cursor != null;
    }

    @Override
    public Position<T> next() throws NoSuchElementException {
        if(cursor == null){
            throw new NoSuchElementException("No such element");
        }
        recent = cursor;
        cursor = elements.after(cursor);
        return recent;
    }
}
