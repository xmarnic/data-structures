package in.nickmarl;

/**
 * An ADT for a queue. A queue is first in, first out data structure.
 */
public interface Queue<T> {

    /**
     * Add an element to this queue.
     * Time Complexity: amortized O(1) or better depending on the implementation.
     * 
     * @param data
     *        The element to be enqueued.
     */
    public abstract void enqueue(T data);

    /**
     * Removes the element at the head of this queue.
     * Time Complexity: O(1)
     * 
     * @return the head of this queue.
     */
    public abstract T dequeue();

    /**
     * Retrieves, but does not remove, the head of this queue, or returns null if
     * this queue is empty.
     * Time Complexity: O(1)
     * 
     * @return the head of this queue or null if the queue is empty.
     */
    public abstract T peek();

    /**
     * Returns true if, and only if, this queue is empty.
     * Time Complexity: O(1)
     * 
     * @return true if this queue is empty, otherwise false.
     */
    public abstract boolean isEmpty();

    /**
     * Returns the number of elements in this queue.
     * Time Complexity: O(1)
     * 
     * @return the size of this queue.
     */
    public abstract int size();

    /**
     * Removes all of the elements from this list. The list will be empty after this
     * call returns.
     * Time Complexity: O(1)
     */
    public abstract void clear();
}
