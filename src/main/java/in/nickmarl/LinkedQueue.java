package in.nickmarl;

/**
 * A linked implementation of Queue.
 */
public class LinkedQueue<T> implements Queue<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    /**
     * A node in linked implementation of queue.
     */
    private static class Node<T> {

        private T data;
        private Node<T> next;

        private Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        private Node(T data) {
            this(data, null);
        }
    }

    /**
     * Instantiate an new LinkedQueue.
     */
    public LinkedQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Add an element to this queue.
     * Time Complexity: O(1)
     * 
     * @param data
     *        The element to be enqueued.
     */
    @Override
    public void enqueue(T data) {
        // we enqueue at the tail so that deque operations are O(1)

        Node<T> node = new Node<>(data);
        if (size == 0) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        size++;
    }

    /**
     * Removes the element at the head of this queue.
     * Time Complexity: O(1)
     * 
     * @return the head of this queue.
     */
    @Override
    public T dequeue() {
        if (size == 0) {
            return null;
        }

        if (size == 1) {
            tail = null;
        }
        T data = head.data; // dequeueing at the head allows for an O(1) time complexity
        head = head.next;
        size--;
        return data;
    }

    /**
     * Retrieves, but does not remove, the head of this queue, or returns null if
     * this queue is empty.
     * Time Complexity: O(1)
     * 
     * @return the head of this queue or null if the queue is empty.
     */
    @Override
    public T peek() {
        if (size == 0) {
            return null;
        }
        return head.data;
    }

    /**
     * Returns true if, and only if, this queue is empty.
     * Time Complexity: O(1)
     * 
     * @return true if this queue is empty, otherwise false.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of elements in this queue.
     * Time Complexity: O(1)
     * 
     * @return the size of this queue.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Removes all of the elements from this list. The list will be empty after this
     * call returns.
     * Time Complexity: O(1)
     */
    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
}
