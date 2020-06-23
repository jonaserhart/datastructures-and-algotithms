package queue;

public interface Queue<T> {
    int size();
    boolean isEmpty();
    boolean offer(T e) throws IllegalArgumentException;
    T peek();
    T poll();
}
