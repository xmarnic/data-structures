package in.nickmarl;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An implementation of singly linked-list.
 * 
 * @param <T> the type of elements stored in the list
 */
public class LinkedList<T> implements Iterable<T> {
    private int size;
    private Node<T> head;
    private Node<T> tail;

    /**
     * Represents a node in a singly linked-list.
     * @param <T> the type of data stored in the node
     */
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
     */
    public void addToFront(T data) {
        Node<T> newNode = new Node<T>(data);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    /**
     * Add an element at the back of the list.
     * 
     * Time Complexity: O(1)
     * @param data
     */
    public void addToBack(T data) {
        Node<T> newNode = new Node<T>(data);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
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

    private class LLIterator implements Iterator<T> {
        private Node<T> cur;

        LLIterator() { cur = head; }

        @Override
        public boolean hasNext() { return cur != null; }

        @Override
        public T next() {
            if (hasNext()) {
                T data = cur.data;
                cur = cur.next;
                return data;
            }
            throw new NoSuchElementException();
        }
    }

    @Override
    public Iterator<T> iterator() { return new LLIterator(); }
}