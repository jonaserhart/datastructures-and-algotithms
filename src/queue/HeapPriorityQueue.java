package queue;

import java.util.ArrayList;

public class HeapPriorityQueue<T extends Comparable<T>> extends AbstractPriorityQueue<T> {

    protected ArrayList<T> heap = new ArrayList<>();

    protected int parent(int i) {
        return (i-1)/2;
    }
    protected int left(int i){
        return 2*i + 1;
    }
    protected int right(int i){
        return 2*i+2;
    }
    protected boolean hasLeft(int i){
        return left(i) < heap.size();
    }
    protected boolean hasRight(int i){
        return right(i) < heap.size();
    }

    protected void swap(int i, int j){
        var temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    protected void upHeap(int i){
        while(i > 0){
            int p = parent(i);
            if (compare(heap.get(i), heap.get(p)) >= 0) break;
            swap(i, p);
            i = p;
        }
    }

    protected void downHeap(int i){
        while (hasLeft(i)){
            var leftIndex = left(i);
            var rightIndex = right(i);
            var smallChildIndex = leftIndex;
            if(hasRight(i))
                if(compare(heap.get(leftIndex), heap.get(rightIndex)) > 0)
                    smallChildIndex = rightIndex;
            if(compare(heap.get(smallChildIndex), heap.get(i)) >= 0) break;
            swap(i, smallChildIndex);
            i = smallChildIndex;
        }
    }

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public boolean offer(T e) throws IllegalArgumentException {
        heap.add(e);
        upHeap(heap.size() - 1);
        return true;
    }

    @Override
    public T peek() {
        if(heap.isEmpty()) return null;
        return heap.get(0);
    }

    @Override
    public T poll() {
        if(heap.isEmpty()) return null;
        var removedEntry = heap.get(0);
        swap(0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        downHeap(0);
        return removedEntry;
    }
}
