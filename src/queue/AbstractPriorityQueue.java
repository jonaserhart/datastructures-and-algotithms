package queue;

import java.util.Comparator;

public abstract class AbstractPriorityQueue<T extends Comparable<T>> implements Queue<T>{

    protected int compare(T first, T second) throws ClassCastException, NullPointerException{
        return first.compareTo(second);
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}
