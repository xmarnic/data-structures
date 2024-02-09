package in.nickmarl;


public class LinkedList<T> {
    private int size;
    private Node<T> head;
    private Node<T> tail;

    private static class Node<T> {
        private T data;
        private Node<T> next;

        private Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        private Node(T data) { this(data, null); }
    }

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Add an element at the front of the list.
     * 
     * Time Complexity: O(1)
     * 
     * @param data
     * @throws UnsupportedOperationException
     */
    public void addToFront(T data) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    /**
     * Add an element at the back of the list.
     * 
     * Time Complexity: O(1)
     * @param data
     * @throws UnsupportedOperationException
     */
    public void addToBack(T data) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    /**
     * Remove the first element from the list.
     * 
     * Time Complexity: O(1)
     * 
     * @return the removed element
     * @throws UnsupportedOperationException
     */
    public T removeFromFront() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    /**
     * Remove the last element from the list.
     * 
     * Time Complexity: O(n)
     * 
     * @return the removed element
     * @throws UnsupportedOperationException
     */
    public T removeFromBack() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    /**
     * Returns the number of elements in the list.
     * 
     * Time Complexity: O(n)
     * 
     * @return the size of the list.
     */
    public int size() {
        return size;
    }
}