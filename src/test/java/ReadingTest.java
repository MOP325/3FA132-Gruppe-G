import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import dev.hv.db.model.Reading;



public class ReadingTest {
    Reading reading;

    @BeforeEach
    public void setup() {
        this.reading = new Reading(1, 1, 1, "TestKindOfMeter", 1.1, 1, "TestComment");
    }

    @Test
    public void testReadingGetters() {
        //Test getters
        try {
            assertEquals(1, reading.getId());
            assertEquals(1, reading.getcId());
            assertEquals(1, reading.getMeterId());
            assertEquals("TestKindOfMeter", reading.getKindOfMeter());
            assertEquals(1.1, reading.getMeterCount(), 0.0001);
            assertEquals(1, reading.getSubstitute());
            assertEquals("TestComment", reading.getComment());
    
            System.out.println("Reading getters test succesfull");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Reading getters test failed: " + e.getMessage());
        }
    }

    @Test
    public void testReadingIdSetter() {
        // Test Id setter
        try {
            reading.setId(1);
            assertEquals(1, reading.getId());
            
            System.out.println("ReadingId setters test succesfull");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("ReadingId setter test failed: " + e.getMessage());
        }
    }

    @Test
    public void testReadingcIdSetter() {
        // Test cId setter
        try {
            reading.setcId(2);
            assertEquals(2, reading.getcId());
    
            System.out.println("ReadingcId setters test succesfull");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("ReadingcId setter test failed: " + e.getMessage());
        }
    }

    @Test
    public void testReadingMeterIdSetter() {
        // Test MeterId setter
        try {
            reading.setMeterId(3);
            assertEquals(3, reading.getMeterId());
    
            System.out.println("ReadingMeterId setters test succesfull");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("RadingMeterId setter test failed: " + e.getMessage());
        }
    }

    @Test
    public void testreadingKindOfMeterSetter() {
        // Test KindOfMeter setter
        try {
            reading.setKindOfMeter("TestKindOfMeter");
            assertEquals("TestKindOfMeter", reading.getKindOfMeter());
   
            System.out.println("ReadingKindOfMeter setters test succesfull");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("ReadingKindOfMeter setter test failed: " + e.getMessage());
        }
    }

    @Test
    public void testMeterCountSetter() {
        // Test MeterCount setter
        try {
            reading.setMeterCount(4.1);
            assertEquals(4.1, reading.getMeterCount(), 0.0001);

            System.out.println("ReadingMeterCount setters test succesfull");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("ReadingMeterCount setter test failed: " + e.getMessage());
        }
    }

    @Test
    public void testSubstituteSetter() {
        // Test Substitute setter
        try {
            reading.setSubstitute(5);
            assertEquals(5, reading.getSubstitute());
    
        System.out.println("ReadingSubstitute setters test succesfull");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("ReadingSubstitute setter test failed: " + e.getMessage());
        }
    }

    @Test
    public void testCommentSetter() {
        // Test Comment setter
        try {
            reading.setComment("TestComment");
            assertEquals("TestComment", reading.getComment());

            System.out.println("ReadingComment setters test succesfull");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ReadingComment setter test failed: " + e.getMessage());
        }
    }
}