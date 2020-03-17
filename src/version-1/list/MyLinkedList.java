
// Doubly-Linked list
public class MyLinkedList<E> {
    private int size;
    private Node head, tail;

    private static class Node<E> {
        E data;
        Node next;
        Node prev;

        Node() {
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
        Node n = head.next;
        while (n != null) {
            if (n.data == data) {
                return true;
            }
            n = n.next;
        }
        return false;
    }

    public void add(E data) {
        Node n = new Node<E>();
        n.data = data;
        if (isEmpty()) {
            head = n;
            tail = n;
            size++;
            return;
        }
        tail.next = n;
        n.prev = tail;
        tail = n;
        size++;
    }

    public void add(int i, E data) {
        Node n = head;
        int cursor = 0;
        if (isEmpty()) {
            add(data);
        }
        if (i == 0) {
            head = new Node<E>();
            head.data = data;
            head.next = n;
            return;
        }
        while (n != null) {
            if (cursor == i) {
                Node newNode = new Node();
                newNode.data = data;
                newNode.prev = n.prev;
                n.prev.next = newNode;
                n.prev = newNode;
                newNode.next = n;
                size++;
            }

            cursor++;
            n = n.next;
        }
    }

    public E remove(int i) {
        E data = null;
        Node n = head;
        int cursor = 0;
        if (isEmpty()) {
            return null;
        }
        while (n != null) {
            if (cursor == i) {
                data = (E) n.data;
                n.prev.next = n.next;
               size--;
            }

            cursor++;
            n = n.next;
        }
        return data;
    }

    public E get(int i) {
        Node n = head;
        int cursor = 0;
        while (n != null) {
            if (cursor == i) {
                return (E) n.data;
            }

            cursor++;
            n = n.next;
        }
        return null;
    }

    public E set(int i, E newData) {
        E data = null;
        Node n = head;
        int cursor = 0;
        while (n != null) {
            if (cursor == i) {
                E tmp = (E)n.data;
                n.data = newData;
                return tmp;
            }

            cursor++;
            n = n.next;
        }
        return null;
    }

    @Override
    public String toString() {
        Node n = head.next;
        String str = head.data.toString() + "==";
        while (n != null) {
            if (n.next == null) {
                str += n.data.toString();
            } else {
                str += n.data.toString() + "==";
            }
            n = n.next;
        }
        return str;
    }
}
