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

    @Test
    void removeFromFrontShouldThrowExceptionForEmptyList() {
        assertThrows(NoSuchElementException.class, emptyList::removeFromFront,
         "No element can be removed from an empty list.");
    }

    @Test
    void removeFromFrontShouldRemoveFirstElementFromSingletonListToCreateAnEmptyList() {
        final int returnValue = singletonList.removeFromFront();
        assertEquals(ELEMENT1, returnValue);
        assertEquals(0, singletonList.size());

        Iterator<Integer> iter = singletonList.iterator();
        assertFalse(iter.hasNext());
    }

    @Test
    void removeFromFrontShouldRemoveFirstElementAndDecrementSizeOfFewList() {
        final int returnValue = fewList.removeFromFront();
        assertEquals(ELEMENT1, returnValue);
        assertEquals(2, fewList.size());

        Iterator<Integer> iter = fewList.iterator();
        assertTrue(iter.hasNext());
        assertEquals(ELEMENT2, iter.next());

        assertTrue(iter.hasNext());
        assertEquals(ELEMENT3, iter.next());

        assertFalse(iter.hasNext());
    }

    @Test
    void removeFromFrontShouldRemoveFirstAndSecondElementsWhenCalledTwiceOnFewList() {
        final int returnValue1 = fewList.removeFromFront();
        assertEquals(ELEMENT1, returnValue1);
        assertEquals(2, fewList.size());

        Iterator<Integer> iter = fewList.iterator();
        assertTrue(iter.hasNext());
        assertEquals(ELEMENT2, iter.next());

        final int returnValue2 = fewList.removeFromFront();
        assertEquals(ELEMENT2, returnValue2);
        assertEquals(1, fewList.size());

        assertTrue(iter.hasNext());
        assertEquals(ELEMENT3, iter.next());

        assertFalse(iter.hasNext());
    }

    @Test
    void removeFromBackShouldThrowExceptionForEmptyList() {
        assertThrows(NoSuchElementException.class, emptyList::removeFromBack,
         "No element can be removed from an empty list.");
    }

    @Test
    void removeFromBackShouldRemoveLastElementFromSingletonListToCreateAnEmptyList() {
        final int returnValue = singletonList.removeFromBack();
        assertEquals(ELEMENT1, returnValue);
        assertEquals(0, singletonList.size());

        Iterator<Integer> iter = singletonList.iterator();
        assertFalse(iter.hasNext());
    }
}
