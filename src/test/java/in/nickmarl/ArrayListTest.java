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
    private ArrayList<Integer> singletonList;
    private ArrayList<Integer> fewList;

    @BeforeEach
    public void setUp() {
        emptyList = new ArrayList<>();

        singletonList = new ArrayList<>();
        singletonList.addToBack(1);

        fewList = new ArrayList<>();
        fewList.addToBack(1);
        fewList.addToBack(2);
        fewList.addToBack(3);

    }
    
    /**
     * Rigorous Test :-)
     */
    @Test
    public void emptyArrayListShouldHaveSizeZero()
    {
        assertEquals( 0, emptyList.size(), "Empty ArrayList should have a size of 0" );
    }

    @Test
    public void singletonArrayListShouldHaveSizeOne()
    {
        assertEquals( 1, singletonList.size(), "Singleton ArrayList should have a size of 1" );
    }

    @Test
    public void fewArrayListShouldHaveSizeThree()
    {
        assertEquals( 3, fewList.size(), "few ArrayList should have a size of 3" );
    }
}
