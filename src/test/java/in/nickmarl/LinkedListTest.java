package in.nickmarl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Iterator;
import java.util.NoSuchElementException;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LinkedListTest {
    static final int ELEMENT1 = 1; 
    static final int ELEMENT2 = 2; 
    static final int ELEMENT3 = 3; 

    private LinkedList<Integer> emptyList;
    private LinkedList<Integer> singletonList;
    private LinkedList<Integer> fewList;

    @BeforeEach
    public void setUp() {
        emptyList = new LinkedList<>();

        singletonList = new LinkedList<>();
        singletonList.addToFront(ELEMENT1);

        fewList = new LinkedList<>();
        fewList.addToBack(ELEMENT1);
        fewList.addToBack(ELEMENT2);
        fewList.addToBack(ELEMENT3);
    }

    @Test
    void emptyListShouldBeSizeZero() {
        assertEquals(0, emptyList.size(), "Empty list should have a size of 0");
    }

    @Test
    void singletonListShouldBeSizeOne() {
        assertEquals(1, singletonList.size(), "Empty list should have a size of 1");
    }

    @Test
    void fewListShouldBeSizeThree() {
        assertEquals(3, fewList.size(), "Empty list should have a size of 3");
    }

    @Test
    void emptyListShouldIterateCorrectly() {
        Iterator<Integer> iter = emptyList.iterator();
        assertFalse(iter.hasNext());
        assertThrows(NoSuchElementException.class, iter::next, "Calling next when hasNext is False should throw NoSuchElementException.");
    }

    @Test
    void fewArrayListShouldIterateCorrectly() {
        Iterator<Integer> iter = fewList.iterator();

        assertEquals(ELEMENT1, iter.next());

        assertTrue(iter.hasNext());
        assertEquals(ELEMENT2, iter.next());

        assertTrue(iter.hasNext());
        assertEquals(ELEMENT3, iter.next());

        assertFalse(iter.hasNext());
        assertThrows(NoSuchElementException.class, iter::next, "Calling next when hasNext is False should throw NoSuchElementException.");
    }

    @Test
    void addToFrontOfEmptyListShouldProduceAListOfSizeOne() {
        final int testValue = 0;
        emptyList.addToFront(testValue);
        assertEquals(1, emptyList.size());

        Iterator<Integer> iter = emptyList.iterator();
        assertTrue(iter.hasNext());
        assertEquals(testValue, iter.next());

        assertFalse(iter.hasNext());
    }

    @Test
    void addToFrontOfSingletonListShouldProduceAListOfSizetwo() {
        final int testValue = 0;
        singletonList.addToFront(testValue);
        assertEquals(2, singletonList.size());

        Iterator<Integer> iter = singletonList.iterator();
        assertTrue(iter.hasNext());
        assertEquals(testValue, iter.next());

        assertTrue(iter.hasNext());
        assertEquals(ELEMENT1, iter.next());
    }
}
