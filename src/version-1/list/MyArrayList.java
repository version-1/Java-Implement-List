
import java.util.*;

// "generic" type <E> : Element
public class MyArrayList<E> implements List<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elementData;
    private int size;

    public MyArrayList() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity >= 0) {
            elementData = new Object[initialCapacity];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
    }

    // <? extends E> -> any type that extends E
    public MyArrayList(Collection<? extends E> c) {
        elementData = c.toArray();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elementData, size);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        T[] list = (T[])Arrays.copyOf(elementData, a.length + elementData.length , a.getClass());
        return list;
    }

    @Override
    public boolean add(E e) {
        if (size == elementData.length) {
            // grow (increases by 50%)
            elementData = grow(size + 1);
        }
        elementData[size] = e;
        size++;
        return true;
    }

    private Object[] grow(int minCapacity) {
        return elementData = Arrays.copyOf(elementData, newCapacity(minCapacity));
    }

    /*
    The maximum size of array to allocate.
    Attempts to allocate larger arrays "may" result in OutOfMemoryOrder
     */
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    /**
     * @param minCapacity the desired minimum capacity
     * @return
     */
    private int newCapacity(int minCapacity) {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity <= minCapacity) {
            if (minCapacity < 0 || minCapacity > MAX_ARRAY_SIZE) {
                throw new OutOfMemoryError("integer overflow");
            }
            return minCapacity;
        }
        return (newCapacity <= MAX_ARRAY_SIZE) ? newCapacity : Integer.MAX_VALUE;
    }

    @Override
    public boolean remove(Object o) {
        int cursor = 0;
        Object[] newList = toArray();
        for (int i = 0; i < size(); i++) {
            if(!o.equals(elementData[i])) {
              newList[cursor] = elementData[cursor];
              cursor++;
            }
        }
        return newList.length != elementData.length;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for(Object item: c) {
            boolean flg = false;
            for (int i = 0; i < elementData.length; i++) {
                if (item.equals(elementData)) {
                    flg = true;
                }
            }
            if (!flg) {
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (E item: c) {
            add(item);
        };
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        grow(size + c.size());
        size++;
        for (int i = index; i < size; i++) {
            Object ele = c.iterator();
            while(ele != null) {
                elementData[i+1] = elementData[i];
                elementData[i] = ele;
            }
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        Object ele = c.iterator().next();
        while(ele != null) {
          remove(ele);
          ele = c.iterator().next();
        }
        return c.size() > 0;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean flg = false;
        for (int i = 0; i < size; i++) {
            if(!c.contains(elementData[i])) {
                remove(elementData[i]);
                flg = true;
            }
        }
        return flg;
    }

    @Override
    public void clear() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + ", size: " + size);
        }
        return (E) elementData[index];
    }

    @Override
    public E set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + ", size: " + size);
        }
        E oldValue = (E) elementData[index];
        elementData[index] = element;
        return oldValue;
    }

    @Override
    public void add(int index, E element) {
        elementData = grow(size + 1);
        for (int i = 0;  i < elementData.length; i++) {
            if (i >= index) {
              elementData[i+1] = elementData[i];
              elementData[i] = element;
            }
        }
    }

    @Override
    public E remove(int index) {
        E ele = (E)elementData[index];
        for (int i = index; i < elementData.length - 1; i++) {
          elementData[index] = elementData[i + 1];
        }
        size--;
        grow(size);
        return ele;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < elementData.length; i++) {
          if (o.equals(elementData[i])) {
            return i;
          };
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = elementData.length - 1; i >= 0 ; i--) {
          if (o.equals(elementData[i])) {
            return i;
          };
        }
        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        List<E> list = new ArrayList<E>();
        for (int i = 0; i < elementData.length; i++) {
            if (i >= fromIndex && i < toIndex) {
                list.add((E)elementData[i]);
            }
        }
        return list;
    }
}
