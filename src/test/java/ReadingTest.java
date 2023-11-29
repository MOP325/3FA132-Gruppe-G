import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import dev.hv.db.model.Reading;

// Tests for the getter and setter functionalities of the Reading class
public class ReadingTest {
    Reading reading = new Reading(1, 1, 1, "TestKindOfMeter", 1.1, 1, "TestComment");

    @BeforeEach
    public void setup() {
        this.reading = new Reading(1, 1, 1, "TestKindOfMeter", 1.1, 1, "TestComment");
    }

    @Test
    public void testReadingGetters() {
        assertEquals(1, reading.getId());
        assertEquals(1, reading.getcId());
        assertEquals(1, reading.getMeterId());
        assertEquals("TestKindOfMeter", reading.getKindOfMeter());
        assertEquals(1.1, reading.getMeterCount(), 0.0001);
        assertEquals(1, reading.getSubstitute());
        assertEquals("TestComment", reading.getComment());
    
        System.out.println("Reading getters test succesfull");
    }

    @Test
    public void testReadingIdSetter() {
        reading.setId(1);
        assertEquals(1, reading.getId());
            
        System.out.println("ReadingId setters test succesfull");
    }

    @Test
    public void testReadingcIdSetter() {
        reading.setcId(2);
        assertEquals(2, reading.getcId());
    
        System.out.println("ReadingcId setters test succesfull");
    }

    @Test
    public void testReadingMeterIdSetter() {
        reading.setMeterId(3);
        assertEquals(3, reading.getMeterId());
    
        System.out.println("ReadingMeterId setters test succesfull");
    }

    @Test
    public void testreadingKindOfMeterSetter() {
        reading.setKindOfMeter("TestKindOfMeter");
        assertEquals("TestKindOfMeter", reading.getKindOfMeter());
   
        System.out.println("ReadingKindOfMeter setters test succesfull");
    }

    @Test
    public void testMeterCountSetter() {
        reading.setMeterCount(4.1);
        assertEquals(4.1, reading.getMeterCount(), 0.0001);

        System.out.println("ReadingMeterCount setters test succesfull");
    }

    @Test
    public void testSubstituteSetter() {
        reading.setSubstitute(5);
        assertEquals(5, reading.getSubstitute());
    
        System.out.println("ReadingSubstitute setters test succesfull");
    }

    @Test
    public void testCommentSetter() {
        reading.setComment("TestComment");
        assertEquals("TestComment", reading.getComment());

        System.out.println("ReadingComment setters test succesfull");
    }
}