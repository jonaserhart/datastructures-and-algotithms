package algorithms.sorting;

import java.util.Comparator;

public interface Sort<E> {
    void sort(E[] collection, Comparator<E> comparator);
}
