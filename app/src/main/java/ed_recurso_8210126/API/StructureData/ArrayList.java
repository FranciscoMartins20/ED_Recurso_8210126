package ed_recurso_8210126.API.StructureData;

import java.util.Iterator;

import ed_recurso_8210126.API.ADTs.ListADT;
import ed_recurso_8210126.API.Exceptions.ElementNotFoundException;
import ed_recurso_8210126.API.Exceptions.EmptyCollectionException;

import java.util.ConcurrentModificationException;

public class ArrayList<T> implements ListADT<T> {

    protected final int DEFAULT_CAPACITY = 10;
    protected final int EXPAND_BY = 2;
    protected final int ELEMENT_NOT_FOUND = -1;

    protected T[] items;
    protected int rear;
    protected int modCount;

    @SuppressWarnings("unchecked")
    public ArrayList() {
        this.items = (T[]) new Object[DEFAULT_CAPACITY];
        this.rear = 0;
        this.modCount = 0;
    }

    @Override
    public T first() {
        if (isEmpty()) {
            throw new EmptyCollectionException();
        }
        return items[0];
    }

    @Override
    public T last() {
        if (isEmpty()) {
            throw new EmptyCollectionException();
        }
        return items[rear - 1];
    }

    @Override
    public boolean isEmpty() {
        return (rear == 0);
    }

    @Override
    public int size() {
        return rear;
    }

    protected int find(T element) {
        for (int i = 0; i < rear; i++) {
            if (items[i] != null && items[i].equals(element)) {
                return i;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    @Override
    public boolean contains(T target) {
        return (find(target) != ELEMENT_NOT_FOUND);
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            throw new EmptyCollectionException();
        }

        T result = items[0];

        for (int i = 0; i < rear - 1; i++) {
            items[i] = items[i + 1];
        }

        items[rear - 1] = null;
        rear--;
        modCount++;

        return result;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            throw new EmptyCollectionException();
        }

        T result = items[rear - 1];
        items[rear - 1] = null;
        rear--;
        modCount++;

        return result;
    }

    @Override
    public T remove(T element) {
        int index = find(element);
        if (index == ELEMENT_NOT_FOUND) {
            throw new ElementNotFoundException();
        }

        T result = items[index];

        for (int i = index; i < rear - 1; i++) {
            items[i] = items[i + 1];
        }

        items[rear - 1] = null;
        rear--;
        modCount++;

        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    protected void expandCapacity() {
        @SuppressWarnings("unchecked")
        T[] newItems = (T[]) new Object[items.length + EXPAND_BY];
        System.arraycopy(items, 0, newItems, 0, rear);
        items = newItems;
    }

    private class ArrayListIterator implements Iterator<T> {

        private int current;
        private int expectedModCount;

        public ArrayListIterator() {
            current = 0;
            expectedModCount = modCount;
        }

        @Override
        public boolean hasNext() {
            return (current < rear);
        }

        @Override
        public T next() {
            checkForConcurrentModification();
            if (!hasNext()) {
                throw new EmptyCollectionException();
            }

            T result = items[current];
            current++;
            return result;
        }

        private void checkForConcurrentModification() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }
}
