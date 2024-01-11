import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.hv.db.model.Reading;

// Tests for the getter and setter functionalities of the Reading class
public class ReadingTest {
    Reading reading;

    @BeforeEach
    public void setup() {
        this.reading = new Reading(1, 1, 1, 1, "TestKindOfMeter", 1.1, 1, "TestComment");
    }

    @Test
    public void testReadingGetters() {
        assertEquals(1, reading.getId());
        assertEquals(1, reading.getcId());
        assertEquals(1, reading.getMeterId());
        assertEquals(1, reading.getDateOfReading());
        assertEquals("TestKindOfMeter", reading.getKindOfMeter());
        assertEquals(1.1, reading.getMeterCount(), 0.0001);
        assertEquals(1, reading.getSubstitute());
        assertEquals("TestComment", reading.getComment());
    }

    @Test
    public void testReadingIdSetter() {
        reading.setId(1);
        assertEquals(1, reading.getId());
    }

    @Test
    public void testReadingcIdSetter() {
        reading.setcId(2);
        assertEquals(2, reading.getcId());
    }

    @Test
    public void testReadingMeterIdSetter() {
        reading.setMeterId(3);
        assertEquals(3, reading.getMeterId());
    }

    @Test
    public void testReadingKindOfMeterSetter() {
        reading.setKindOfMeter("TestKindOfMeter");
        assertEquals("TestKindOfMeter", reading.getKindOfMeter());
    }

    @Test
    public void testMeterCountSetter() {
        reading.setMeterCount(4.1);
        assertEquals(4.1, reading.getMeterCount(), 0.0001);
    }

    @Test
    public void testDateOfReadingSetter() {
        reading.setDateOfReading(2022);
        assertEquals(2022, reading.getDateOfReading());
    }

    @Test
    void testPrintDateOfReading() {
        reading.setDateOfReading(2022);
        assertEquals("date of reading: 2022", reading.printDateOfReading());
    }

    @Test
    public void testSubstituteSetter() {
        reading.setSubstitute(5);
        assertEquals(5, reading.getSubstitute());
    }

    @Test
    public void testCommentSetter() {
        reading.setComment("TestComment");
        assertEquals("TestComment", reading.getComment());
    }
}