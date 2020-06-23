package lists;

public class SinglyLinkedList<T>{
    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    public SinglyLinkedList(){
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T last(){
        if(isEmpty()) return null;
        return tail.getElement();
    }

    public T first(){
        if(isEmpty()) return null;
        return head.getElement();
    }

    public void addLast(T element){
        var newNode = new ListNode<>(element, null);
        if(isEmpty())
            head = newNode;
        else
            tail.setNext(newNode);
        tail = newNode;
        size++;
    }

    public void addFirst(T element){
        head = new ListNode<>(element, head);
        if(isEmpty())
            tail = head;
        size++;
    }

    public T removeFirst(){
        if(isEmpty()) return null;
        T answer = head.getElement();
        head = head.next();
        size--;
        if(isEmpty())
            tail = null;
        return answer;
    }
}
