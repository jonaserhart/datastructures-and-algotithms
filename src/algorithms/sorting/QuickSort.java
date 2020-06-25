package algorithms.sorting;

import java.util.Comparator;

public class QuickSort<E> implements Sort<E> {
    @Override
    public void sort(E[] collection, Comparator<E> comparator) {
        quickSort(collection, comparator, 0, collection.length-1);
    }

    /**
     * Sort only a subpart of an array (in - place)
     * @param collection collection to sort
     * @param comparator comparator of type E
     * @param start startindex of sort
     * @param end endindex of sort
     */
    public void quickSort(E[] collection, Comparator<E> comparator, int start, int end){
        if (start >= end)
            return;

        int left = start;
        int right = end - 1;

        var pivot = collection[end];
        E temp;

        while (left <= right){
            while (left <= right && comparator.compare(collection[left], pivot) < 0){
                left ++;
            }
            while (left <= right && comparator.compare(collection[right], pivot) > 0){
                right --;
            }
            if (left <= right){
                temp = collection[left];
                collection[left] = collection[right];
                collection[right] = temp;
                left++;
                right--;
            }
        }
        temp = collection[left];
        collection[left] = collection[end];
        collection[end] = temp;

        quickSort(collection, comparator, start, left-1);
        quickSort(collection, comparator, left+1, end);
    }
}
