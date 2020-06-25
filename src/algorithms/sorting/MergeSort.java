package algorithms.sorting;

import java.util.Arrays;
import java.util.Comparator;

public class MergeSort<E> implements Sort<E>{

    @Override
    public void sort(E[] collection, Comparator<E> comparator) {
        var n = collection.length;
        if (n < 2) return;

        var mid = n/2;
        var part1 = Arrays.copyOfRange(collection, 0,mid);
        var part2 = Arrays.copyOfRange(collection, mid, n);

        sort(part1, comparator);
        sort(part2, comparator);

        merge(part1, part2, collection, comparator);
    }

    private <T> void merge(T[] part1, T[] part2, T[] arrayToInsertInto, Comparator<T> comparator){
        int i = 0, j = 0;
        while ((i + j) < arrayToInsertInto.length){
            if (j == part2.length || (i < part1.length && comparator.compare(part1[i], part2[j]) < 0)){
                arrayToInsertInto[i+j] = part1[i++];
                continue;
            }
            arrayToInsertInto[i+j] = part2[j++];
        }
    }
}
