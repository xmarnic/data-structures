package in.nickmarl;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An implementation of an ArrayList.
 */
public class ArrayList<T> implements Iterable<T> {

    /*
     * The initial capacity of the ArrayList.
     */
    public static final int INITIAL_CAPACITY = 9;

    private T[] backingArray;
    private int size;

    /**
     * This is the constructor that constructs a new ArrayList.
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast an Object[] to a T[] to get the generic typing.
     */
    @SuppressWarnings("unchecked")
    public ArrayList() {
        // DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
    }

    /**
     * Adds the data to the front of the list.
     * This add may require elements to be shifted.
     * Method runs in O(n) time.
     *
     * @param data
     *        the data to add to the front of the list
     * @throws java.lang.IllegalArgumentException
     *         if data is null
     */
    public void addToFront(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }

        if (size == backingArray.length) {
            @SuppressWarnings("unchecked")
            T[] newArray = (T[]) new Object[backingArray.length * 2];
            System.arraycopy(backingArray, 0, newArray, 1, backingArray.length);
            backingArray = newArray;
        } else {
            for (int i = size - 1; i >= 0; i--) {
                backingArray[i + 1] = backingArray[i];
            }
        }
        backingArray[0] = data;
        size++;
    }

    /**
     * Adds the data to the back of the list.
     * Method runs in amortized O(1) time.
     *
     * @param data
     *        the data to add to the back of the list
     * @throws java.lang.IllegalArgumentException
     *         if data is null
     */
    @SuppressWarnings("unchecked")
    public void addToBack(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }

        if (size == backingArray.length) {
            T[] newArray = (T[]) new Object[backingArray.length * 2];
            System.arraycopy(backingArray, 0, newArray, 0, backingArray.length);
            backingArray = newArray;
        }

        backingArray[size] = data;
        size++;
    }

    /**
     * Removes and returns the first data of the list.
     * Do not shrink the backing array.
     * This remove may require elements to be shifted.
     * Method runs in O(n) time.
     *
     * @return the data formerly located at the front of the list
     * @throws java.util.NoSuchElementException
     *         if the list is empty
     */
    public T removeFromFront() {
        if (size == 0) {
            throw new NoSuchElementException();
        }

        T data = backingArray[0];
        for (int i = 0; i < size - 1; i++) {
            backingArray[i] = backingArray[i + 1];
        }
        backingArray[size - 1] = null;
        size--;
        return data;
    }

    /**
     * Removes and returns the last data of the list.
     * Does not shrink the backing array.
     * Method runs in O(1) time.
     *
     * @return the data formerly located at the back of the list
     * @throws java.util.NoSuchElementException
     *         if the list is empty
     */
    public T removeFromBack() {
        if (size == 0) {
            throw new NoSuchElementException();
        }

        T data = backingArray[size - 1];
        backingArray[size - 1] = null;
        size--;
        return data;
    }

    /**
     * Returns the backing array of the list.
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the backing array of the list
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the size of the list.
     * Method runs in O(1) time.
     * 
     * @return the size of the list
     */
    public int size() {
        return size;
    }

    private class ALIterator implements Iterator<T> {
        private int cur;

        public ALIterator() {
            cur = 0;
        }

        @Override
        public boolean hasNext() {
            return cur < size;
        }

        @Override
        public T next() {
            if (hasNext()) {
                return backingArray[cur++];
            }
            throw new NoSuchElementException();
        }

    }

    @Override
    public Iterator<T> iterator() {
        return new ALIterator();
    }
}