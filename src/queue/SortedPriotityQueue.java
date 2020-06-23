package queue;

import lists.ArrayPositionalList;

import java.util.LinkedList;

public class SortedPriotityQueue<T extends Comparable<T>> implements Queue<T> {

    private final ArrayPositionalList<T> list = new ArrayPositionalList<>();

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean offer(T e) throws IllegalArgumentException {
        var walk = list.last();

        while(walk != null && e.compareTo(walk.getElement()) < 0){
            walk = list.before(walk);
        }
        if(walk == null)
            list.addFirst(e);
        else
            list.addAfter(walk, e);
        return true;
    }

    @Override
    public T peek() {
        if(list.isEmpty()) return null;
        return list.first().getElement();
    }

    @Override
    public T poll() {
        if(list.isEmpty()) return null;
        return list.removeFirst().getElement();
    }
}
