package lists;

import java.util.Objects;

public class ListPosition<T> implements Position<T>{

    private int index;
    private T data;

    public ListPosition(T elem, int index){
        this.index = index;
        this.data = elem;
    }

    @Override
    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public void setElement(T data) {
        this.data = data;
    }

    @Override
    public int getIndex() {
        return index;
    }

    @Override
    public T getElement() throws IllegalStateException {
        return data;
    }

    @Override
    public String toString() {
        return "(" +
                "index=" + index +
                "; data=" + data +
                ')';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListPosition<?> that = (ListPosition<?>) o;
        return index == that.index &&
                Objects.equals(this.data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, data);
    }
}
