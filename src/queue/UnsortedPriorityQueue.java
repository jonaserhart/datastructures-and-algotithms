package queue;

import lists.ArrayPositionalList;
import lists.Position;

import java.util.Iterator;

public class UnsortedPriorityQueue<T extends Comparable<T>> extends AbstractPriorityQueue<T> {

    private ArrayPositionalList<T> list = new ArrayPositionalList<>();

    private Position<T> findMin(){
        var smallest = list.first();

        for (var iterator = list.positionsIterator(); iterator.hasNext(); ) {
            var position = iterator.next();
            if(position.getElement().compareTo(smallest.getElement()) < 0)
                smallest = position;
        }
        return smallest;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean offer(T e) throws IllegalArgumentException {
        list.addLast(e);
        return true;
    }

    @Override
    public T peek() {
        if(list.isEmpty()) return null;
        return findMin().getElement();
    }

    @Override
    public T poll() {
        if(list.isEmpty()) return null;
        return list.remove(findMin());
    }
}
