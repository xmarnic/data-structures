package in.nickmarl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

public class LinkedQueueTest {
    static final int ELEMENT1 = 1;
    static final int ELEMENT2 = 2;

    private LinkedQueue<Integer> emptyQ;
    private LinkedQueue<Integer> singletonQ;

    @BeforeEach
    public void setUp() {
        emptyQ = new LinkedQueue<>();

        singletonQ = new LinkedQueue<>();
        singletonQ.enqueue(ELEMENT1);
    }

    @Test
    public void isEmptyShouldReturnTrueForEmptyQueue() {
        assertTrue(emptyQ.isEmpty());
    }

    @Test
    public void isEmptyShouldReturnFalseForSingletonQueue() {
        assertFalse(singletonQ.isEmpty());
    }

    @Test
    public void sizeOfEmptyQueueShouldBeZero() {
        assertEquals(0, emptyQ.size());
    }

    @Test
    public void sizeOfSingletonQueueShouldBeOne() {
        assertEquals(1, singletonQ.size());
    }

    @Test
    public void enqueueOnEmptyQueueShouldProduceSingletonQueue() {
        emptyQ.enqueue(ELEMENT1);
        assertFalse(emptyQ.isEmpty());
        assertEquals(1, emptyQ.size());
    }

    @Test
    public void enqueueOnSingletonQueueShouldProduceAQueOfSizeTwo() {
        singletonQ.enqueue(ELEMENT2);
        assertEquals(2, singletonQ.size());
        assertEquals(ELEMENT1, singletonQ.dequeue());
        assertEquals(1, singletonQ.size());
        assertEquals(ELEMENT2, singletonQ.dequeue());
        assertEquals(0, singletonQ.size());
    }

    @Test
    public void dequeueOnSingletonQueueShouldProduceEmptyQueue() {
        int dequeuedElement = singletonQ.dequeue();
        assertEquals(ELEMENT1, dequeuedElement);
        assertEquals(0, singletonQ.size());
    }

    @Test
    public void peekShouldReturnNullFromEmptyQueue() {
        assertNull(emptyQ.peek());
        assertEquals(0, emptyQ.size());
    }

    @Test
    public void peekShouldReturnButNotRemoveHeadElementFromSingletonQueue() {
        int peekedElement = singletonQ.peek();
        assertEquals(ELEMENT1, peekedElement);
        assertEquals(1, singletonQ.size());
    }

}
