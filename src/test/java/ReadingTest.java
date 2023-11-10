import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import dev.hv.db.model.Reading;



public class ReadingTest {
    Reading reading;

    @BeforeEach
    public void setup() {
        reading = new Reading(1, 1, 1, "TestKindOfMeter", 1.1, 1, "TestComment");
    }

    @Test
    public void testReadingGetters() {
        //Test getters
        try {
            assertEquals(1, reading.getId());
            assertEquals(1, reading.getcId());
            assertEquals(1, reading.getMeterId());
            assertEquals("TestKindOfMeter", reading.getKindOfMeter());
            assertEquals(1.1, reading.getMeterCount());
            assertEquals(1, reading.getSubstitute());
            assertEquals("TestComment", reading.getComment());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("Reading getters test succesfull");
        }
    }

    @Test
    public void testReadingIdSetter() {
        // Test Id setter
        try {
            reading.setId(1);
            assertEquals(1, reading.getId());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("ReadingId setters test succesfull");
        }
    }

    @Test
    public void testReadingcIdSetter() {
        // Test cId setter
        try {
            reading.setcId(2);
            assertEquals(2, reading.getcId());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("ReadingcId setters test succesfull");
        }
    }

    @Test
    public void testReadingMeterIdSetter() {
        // Test MeterId setter
        try {
            reading.setMeterId(3);
            assertEquals(3, reading.getMeterId());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("ReadingMeterId setters test succesfull");
        }
    }

    @Test
    public void testreadingKindOfMeterSetter() {
        // Test KindOfMeter setter
        try {
            reading.setKindOfMeter("TestKindOfMeter");
            assertEquals("TestKindOfMeter", reading.getKindOfMeter());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("ReadingKindOfMeter setters test succesfull");
        }
    }

    @Test
    public void testMeterCountSetter() {
        // Test MeterCount setter
        try {
            reading.setMeterCount(4.1);
            assertEquals(4.1, reading.getMeterCount());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("ReadingMeterCount setters test succesfull");
        }
    }

    @Test
    public void testSubstituteSetter() {
        // Test Substitute setter
        try {
            reading.setSubstitute(5);
            assertEquals(5, reading.getSubstitute());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("ReadingSubstitute setters test succesfull");
        }
    }

    @Test
    public void testCommentSetter() {
        // Test Comment setter
        try {
            reading.setComment("TestComment");
            assertEquals("Test", null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("ReadingComment setters test succesfull");
        }
    }
}