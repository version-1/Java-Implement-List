
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
        while(n != null) {
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
        tail.next = n;
    }

    public void add(int i, E data) {
        Node n = head.next;
        int cursor = 0;
        while(n != null) {
            if (cursor == i) {
                n.next = new Node();
                n.next.data = data;
                n = n.next;
            }

            cursor++;
            n = n.next;
        }
    }

    public E remove(int i) {
        E data = null;
        Node n = head.next;
        int cursor = 0;
        while(n != null) {
            if (cursor == i - 1 && n.next != null) {
                data = (E)n.next.data;
                n.next = n.next.next;
            }

            cursor++;
            n = n.next;
        }
        return data;
    }

    public E get(int i) {
        Node n = head.next;
        int cursor = 0;
        while(n != null) {
            if (cursor == i) {
                return (E)n.data;
            }

            cursor++;
            n = n.next;
        }
        return null;
    }

    public E set(int i, E newData) {
        E data = null;
        Node n = head.next;
        int cursor = 0;
        while(n != null) {
            if (cursor == i - 1 && n.next != null) {
                data = (E)n.next.data;
                Node node = new Node();
                node.data = newData;
                n.next = n.next.next;
                return data;
            }

            cursor++;
            n = n.next;
        }
        return null;
    }

    @Override
    public String toString() {
        Node n = head.next;
        String str = "";
        while(n != null) {
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
