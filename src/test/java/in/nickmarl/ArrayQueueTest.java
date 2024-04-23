package in.nickmarl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

public class ArrayQueueTest {
    static final int ELEMENT1 = 1;
    static final int ELEMENT2 = 2;
    static final int ELEMENT3 = 3;

    private ArrayQueue<Integer> emptyQ;
    private ArrayQueue<Integer> singletonQ;
    private ArrayQueue<Integer> multiQ;

    @BeforeEach
    public void setUp() {
        emptyQ = new ArrayQueue<>();

        singletonQ = new ArrayQueue<>();
        singletonQ.enqueue(ELEMENT1);

        multiQ = new ArrayQueue<>();
        multiQ.enqueue(ELEMENT1);
        multiQ.enqueue(ELEMENT2);
        multiQ.enqueue(ELEMENT3);
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
    public void isEmptyShouldReturnFalseForMultiQueue() {
        assertFalse(multiQ.isEmpty());
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
    public void sizeOfMultiQueueShouldBeThree() {
        assertEquals(3, multiQ.size());
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
    public void dequeueOnMultiQueueShouldProduceEmptyQueue() {
        int dequeuedElement = multiQ.dequeue();
        assertEquals(ELEMENT1, dequeuedElement);
        assertEquals(2, multiQ.size());

        dequeuedElement = multiQ.dequeue();
        assertEquals(ELEMENT2, dequeuedElement);
        assertEquals(1, multiQ.size());

        dequeuedElement = multiQ.dequeue();
        assertEquals(ELEMENT3, dequeuedElement);
        assertEquals(0, multiQ.size());
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

    @Test
    public void aSpecificCombinationOfEnqueueAndDequeueShouldTestArrayWrappingAndResizing() {
        ArrayQueue<Integer> testQ = new ArrayQueue<>();
        testQ.enqueue(1);
        testQ.enqueue(2);
        testQ.enqueue(3);
        assertEquals(1, testQ.dequeue());
        assertEquals(2, testQ.dequeue());
        testQ.enqueue(4);
        testQ.enqueue(5);
        testQ.enqueue(6);
        assertEquals(3, testQ.dequeue());
        assertEquals(4, testQ.dequeue());
        assertEquals(5, testQ.dequeue());
        assertEquals(6, testQ.dequeue());
    }

    @Test
    public void testClearShouldGiveMe100PercentCoverage() {
        multiQ.clear();
    }

}
