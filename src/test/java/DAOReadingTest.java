import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import dev.hv.db.dao.DAOReading;
import dev.hv.db.model.Reading;
import java.util.List;

public class DAOReadingTest {
    private DAOReading daoReading = new DAOReading();

    @Test
    public void testFindReadingById() {
        
        try {
            // Insert reading
            Reading reading = new Reading(1, 1, 1, "KindOfMeter", 1.1, 1, "Comment");
            daoReading.insert(reading);

            // Find Reading by ID
            Reading foundReading = daoReading.findById(1);
            assertNotNull(foundReading);
            assertEquals(reading.getId(), foundReading.getId());
            assertEquals(reading.getcId(), foundReading.getcId());
            assertEquals(reading.getMeterId(), foundReading.getMeterId());
            assertEquals(reading.getKindOfMeter(), foundReading.getKindOfMeter());
            assertEquals(reading.getMeterCount(), foundReading.getMeterCount());
            assertEquals(reading.getSubstitute(), foundReading.getSubstitute());
            assertEquals(reading.getComment(), foundReading.getComment());
            System.out.println("Test DAOReading find by id successful");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Test DAOReading find by id failed: " + e.getMessage());
        }
    }

    @Test
    public void testUpdateReading() {

        try {
            // Insert reading
            Reading reading = new Reading(1, 1, 1, "KindOfMeter", 1.1, 1, "Comment");
            daoReading.insert(reading);

            // Update reading
            Reading updatedReading = daoReading.findById(1);
            assertNotNull(updatedReading);
            assertEquals(reading.getId(), updatedReading.getId());
            assertEquals(reading.getcId(), updatedReading.getcId());
            assertEquals(reading.getMeterId(), updatedReading.getMeterId());
            assertEquals(reading.getKindOfMeter(), updatedReading.getKindOfMeter());
            assertEquals(reading.getMeterCount(), updatedReading.getMeterCount());
            assertEquals(reading.getSubstitute(), updatedReading.getSubstitute());
            assertEquals(reading.getComment(), updatedReading.getComment());

            daoReading.update(reading);

            // Check the new users
            assertNotNull(updatedReading);
            assertEquals(reading.getId(), updatedReading.getId());
            assertEquals(reading.getcId(), updatedReading.getcId());
            assertEquals(reading.getMeterId(), updatedReading.getMeterId());
            assertEquals(reading.getKindOfMeter(), updatedReading.getKindOfMeter());
            assertEquals(reading.getMeterCount(), updatedReading.getMeterCount());
            assertEquals(reading.getSubstitute(), updatedReading.getSubstitute());
            assertEquals(reading.getComment(), updatedReading.getComment());

            System.out.println("Test DAOReading update successful");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Test DAOReading update failed: " + e.getMessage());
        }
    }

    @Test
    public void testFindAllReading() {

        try {
                // Insert three reading
                daoReading.insert(new Reading(1, 1, 2, "KindOfMeter", 2.2, 2, "Comment"));
                daoReading.insert(new Reading(2, 2, 2, "KindOfMeter", 2.2, 2, "Comment"));
                daoReading.insert(new Reading(2, 2, 2, "KindOfMeter", 2.2, 2, "Comment"));

                // Count readings
                List<Reading> readingList = daoReading.findAll();
                assertNotNull(readingList);
                assertEquals(3, readingList.size());
                 System.out.println("Test DAOReading find all successful");
           }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Test DAOReading find all failed: " + e.getMessage());
        }
    }

    @Test
    public void testDeleteReading() {
        
        try {
            // Insert reading
            Reading reading = new Reading(1, 1, 1, "KindOfMeter", 1.1, 1, "Comment");
            daoReading.insert(reading);

            // Delete reading by ID
            daoReading.delete(1);
            
            // Should return null
            Reading deletedReading = daoReading.findById(1);
            assertNull(deletedReading);

            System.out.println("Test DAOReading delete successful");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Test DAOReading delete failed: " + e.getMessage());
        }

    }
}