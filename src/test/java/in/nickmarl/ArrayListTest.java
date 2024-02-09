package in.nickmarl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit testing suite for ArrayList.
 */
public class ArrayListTest 
{

    private ArrayList<Integer> emptyList;

    @BeforeEach
    public void setUp() {
        emptyList = new ArrayList<>();
    }
    
    /**
     * Rigorous Test :-)
     */
    @Test
    public void emptyArrayListShouldHaveSizeZero()
    {
        assertEquals( 0, emptyList.size(), "Empty list should have a size of 0" );
    }
}
