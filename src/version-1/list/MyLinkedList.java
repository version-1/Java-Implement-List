package collections.list;

// Doubly-Linked list
public class MyLinkedList<E> {
    private int size;
    private Node head, tail;

    private static class Node<E> {
        E data;
        Node next;
        Node prev;
        Node(E data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public boolean contains(E data) {
        // TODO
        return false;
    }

    public void add(E data) {
        // TODO
    }

    public void add(int i, E data) {
        // TODO
    }

    public E remove(int i) {
        // TODO
        return null;
    }

    public E get(int i) {
        // TODO
        return null;
    }

    public E set(int i, E newData) {
        // TODO
        // should return the previous data
        return null;
    }

    @Override
    public String toString() {
        // TODO
        // ex) "Obj0"=="Obj1"==null
        return super.toString();
    }
}
