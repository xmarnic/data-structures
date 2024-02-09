package in.nickmarl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LinkedListTest {
    
    private LinkedList<Integer> emptyList;

    @BeforeEach
    public void setUp() {
        emptyList = new LinkedList<>();
    }

    @Test
    void testSize() {
        assertEquals(0, emptyList.size(), "Empty list should have a size of 0");
    }
}
