package in.nickmarl;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An implementation of singly linked-list.
 * 
 * @param <T>
 *        the type of elements stored in the list
 */
public class LinkedList<T> implements Iterable<T> {
    private int size;
    private Node<T> head;
    private Node<T> tail;

    /**
     * Represents a node in a singly linked-list.
     * 
     * @param <T>
     *        the type of data stored in the node
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

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Add an element at the front of the list.
     * Time Complexity: O(1)
     * 
     * @param data
     */
    public void addToFront(T data) {
        if (data == null) {
            throw new IllegalArgumentException("A null element cannot be added to the list.");
        }

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
     * Time Complexity: O(1)
     * 
     * @param data
     */
    public void addToBack(T data) {
        if (data == null) {
            throw new IllegalArgumentException("A null element cannot be added to the list.");
        }

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
     * Time Complexity: O(1)
     * 
     * @return the removed element
     * @throws NoSuchElementException
     */
    public T removeFromFront() {
        if (size == 0) {
            throw new NoSuchElementException("An element cannot be removed from an empty list.");
        }

        T data = head.data;
        head = head.next;
        size--;
        if (size < 2) {
            tail = head;
        }
        return data;
    }

    /**
     * Remove the last element from the list.
     * Time Complexity: O(n)
     * 
     * @return the removed element
     * @throws NoSuchElementException
     */
    public T removeFromBack() {
        if (size == 0) {
            throw new NoSuchElementException("An element cannot be removed from an empty list.");
        }

        if (size == 1) {
            T data = head.data;
            head = null;
            tail = null;
            size--;
            return data;
        }

        Node<T> cur = head;
        while (cur.next.next != null) {
            cur = cur.next;
        }

        T data = cur.next.data;
        cur.next = null;
        tail = cur;
        size--;
        return data;
    }

    /**
     * Returns the number of elements in the list.
     * Time Complexity: O(1)
     * 
     * @return the size of the list.
     */
    public int size() {
        return size;
    }

    private class LLIterator implements Iterator<T> {
        private Node<T> cur;

        LLIterator() {
            cur = head;
        }

        @Override
        public boolean hasNext() {
            return cur != null;
        }

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
    public Iterator<T> iterator() {
        return new LLIterator();
    }
}