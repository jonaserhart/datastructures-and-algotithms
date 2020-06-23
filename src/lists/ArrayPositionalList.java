package lists;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayPositionalList<T> implements PositionalList<T>, Iterable<T> {

    private int size;
    private Position<T>[] data;

    public ArrayPositionalList() {
        int INIT_SIZE = 0;
        data = new Position[INIT_SIZE];
    }

    //region Methods
    //region Public
    //region Iterator
    @Override
    public Iterator<T> iterator() {
        return new ElementIterator<>(this);
    }

    public Iterator<Position<T>> positionsIterator(){
        return new PositionIterator<>(this);
    }
    //endregion

    //region ListMethods
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    @Override
    public Position<T> first() {
        return isEmpty() ? null : data[0];
    }

    @Override
    public Position<T> last() {
        return isEmpty() ? null : data[getMaxIndex()];
    }

    @Override
    public Position<T> before(Position<T> position) {
        validatePositionIsInList(position);
        return tryGetPositionFromIndex(position.getIndex()-1);
    }

    @Override
    public Position<T> after(Position<T> position) {
        validatePositionIsInList(position);
        return tryGetPositionFromIndex(position.getIndex()+1);
    }

    @Override
    public Position<T> addFirst(T element) {
        return addElementAt(0, element);
    }

    @Override
    public Position<T> addLast(T element) {
        return addElementAt(getMaxIndex()+1, element);
    }

    @Override
    public Position<T> addBefore(Position<T> position, T element) {
        return addElementAt(position.getIndex(), element);
    }

    @Override
    public Position<T> addAfter(Position<T> position, T element) {
        return addElementAt(position.getIndex()+1, element);
    }

    @Override
    public T set(Position<T> position, T element) {
        validatePositionIsInList(position);
        var index = position.getIndex();
        var newElement = new ListPosition<>(element, index);
        var oldElement = tryGetPositionFromIndex(index);
        data[index] = newElement;
        return oldElement.getElement();
    }

    public Position<T> removeFirst(){
        var value = first();
        updateIndexesOnInsert(0);
        return value;
    }

    @Override
    public T remove(Position<T> position) {
        validatePositionIsInList(position);
        updateIndexesOnRemove(position.getIndex());

        return position.getElement();
    }
    //endregion

    @Override
    public String toString() {
        var stringBuilder = new StringBuilder();

        stringBuilder.append("[ ");
        for (var datum: data){
            stringBuilder.append(datum).append(" ");
        }
        stringBuilder.append("]");

        return stringBuilder.toString();
    }

    //endregion
    //region Private
    //adds an element to the list at a certain index
    private Position<T> addElementAt(int index, T element){
        //ensuring, the 'data' - array capacity is sufficient
        ensureCapacity();

        //in case, a call to 'addBefore(first_element)' is made
        if(index == -1){
            return addFirst(element);
        }
        //update all indices that are affected by the insert of the value into the list
        updateIndexesOnInsert(index);
        //add new element into list
        var newElement = new ListPosition<T>(element, index);
        data[index] = newElement;
        //return new element (typeOf Position)
        return newElement;
    }

    //to ensure that data - array has sufficient capacity
    private void ensureCapacity(){
        //needed capacity for an add-operation
        var neededCapacity = size+1;
        if(neededCapacity >= data.length){
            //copy array into bigger array
            data = Arrays.copyOf(data, neededCapacity);
        }
    }

    private int getMaxIndex(){
        return size -1;
    }

    private Position<T> tryGetPositionFromIndex(int indexOfPosition) {
        Position<T> result;
        try{
            result = data[indexOfPosition];
        }
        catch (Exception e){
            result = null;
        }
        return result;
    }

    private void updateIndexesOnRemove(int indexToRemove){
        for(var i = indexToRemove; i < getMaxIndex(); i++){
            data[i] = data[i+1];
            if(data[i] != null){
                data[i].setIndex(i);
            }
        }
        data = Arrays.copyOf(data, size-1);
        size--;
    }

    private void updateIndexesOnInsert(int indexToInsert) {
        for (var i = size; i > indexToInsert; i--) {
            //update indexes of array
            data[i] = data[i - 1];

            //update indexes of position objects
            var elem = data[i];
            elem.setIndex(elem.getIndex() + 1);
        }
        //increment size of list
        size++;
    }

    //check if requested position is in list or not
    private void validatePositionIsInList(Position<T> position){
        //throw an exception if position is not in list
        if(!isInList(position)){
            var message = "Position " + (position) + " is not in list";
            throw new IllegalArgumentException(message);
        }
    }

    private boolean isInList(Position<T> position) {
        boolean isInList = false;
        //iterate throug all data, checking if an item is in the list
        for(var datum: data){
            //the equals method in 'ListPosition' - class is overridden
            //so this next statement compares position.index AND position.element
            if (datum == position) {
                isInList = true;
                break;
            }
        }
        return isInList;
    }
    //endregion
    //endregion
}
