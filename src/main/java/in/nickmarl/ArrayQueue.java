package in.nickmarl;

public class ArrayQueue<T> implements Queue<T> {

    /**
     * The initial capacity of the backing array.
     */
    public static final int INITIAL_CAPACITY = 3;

    private T[] backingArray;
    private int front; // the index of the element representing the head of this Queue
    private int size; // the number of elements in this Queue

    @SuppressWarnings("unchecked")
    public ArrayQueue() {
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
    }

    /**
     * Doubles the capacity of the queue by creating a new backing array twice the length of the original.
     * This method copies all elements from the current backing array to the new array, maintaining queue order.
     * Elements are repositioned starting from index zero, thus resetting the front of the queue to the start
     * of the new array. This operation is performed when the existing array is full to accommodate more elements.
     */
    private void resizeBackingArray() {
        @SuppressWarnings("unchecked")
        T[] newArray = (T[]) new Object[2 * backingArray.length];

        for (int dest = 0, src; dest < size; dest++) {
            src = (front + dest) % backingArray.length;
            newArray[dest] = backingArray[src];
        }

        backingArray = newArray;
        front = 0;
    }

    @Override
    public void enqueue(T data) {
        if (size == backingArray.length) {
            resizeBackingArray();
        }
        int enqueueIndex = (front + size) % backingArray.length;
        backingArray[enqueueIndex] = data;
        size++;
    }

    @Override
    public T dequeue() {
        if (size == 0) {
            return null;
        }
        T data = backingArray[front];
        backingArray[front] = null;
        front++;
        if (front == backingArray.length) {
            front %= backingArray.length;
        }
        size--;
        return data;
    }

    @Override
    public T peek() {
        if (size == 0) {
            return null;
        }
        return backingArray[front];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void clear() {
        this.front = 0;
        this.size = 0;
        this.backingArray = (T[]) new Object[INITIAL_CAPACITY];
    }

}
