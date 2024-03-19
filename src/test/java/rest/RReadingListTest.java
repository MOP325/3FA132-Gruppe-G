package rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import dev.hv.rest.model.RReading;
import dev.hv.rest.model.RReadingList;

public class RReadingListTest {
    
    private RReadingList emptyList;
    private RReadingList listWithElements;

    @Before
    public void setUp() {
        emptyList = new RReadingList();
        listWithElements = new RReadingList(Arrays.asList(new RReading(), new RReading()));
    }

    @Test
    public void emptyConstructorTest() {
        assertTrue("List should be empty", emptyList.isEmpty());
    }

    @Test
    public void listWithElementsTest() {
        assertEquals("List shozld have 2 elements", 2, listWithElements.size());
    }

    // @Test
    // public void addElementTest() {
    //     RReading reading = new RReading();
    //     emptyList.add((IRReading) reading);
    //     assertEquals("Should add a new Element to the empty List", 1, emptyList.size());
    // }

    // @Test
    // public void removeElementTest() {
    //     IRReading reading = listWithElements.get(0);
    //     listWithElements.remove(reading);
    //     assertEquals("Should have removed one Element of the List, one is still remaining", 1, listWithElements.size());
    // }

    // @Test
    // public void initialCapacityConstructorTest() {
    //     int initialCapacity = 5;
    //     RReadingList listWithCapacity = new RReadingList(initialCapacity);

    //     for(int i = 0; i < initialCapacity; i++) {
    //         listWithCapacity.add(new RReading());
    //     }

    //     assertEquals(initialCapacity, listWithCapacity.size());
    
    //     listWithCapacity.add(new RReading());
    //     assertEquals(initialCapacity + 1, listWithCapacity.size());
    // }
}
