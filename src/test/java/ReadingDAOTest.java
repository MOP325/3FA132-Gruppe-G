import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.hv.db.dao.ReadingDAO;
import dev.hv.db.model.Reading;
import dev.hv.db.init.DbConnect;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.mapper.reflect.BeanMapper;

import java.util.List;

public class ReadingDAOTest {

    private ReadingDAO readingDAO;
    private Jdbi jdbi;

    @BeforeEach
    void setup() {
        // Create an instance of the Jdbi with the existing database configuration
        jdbi = new DbConnect().getJdbi();
        jdbi.registerRowMapper(BeanMapper.factory(Reading.class));

        // Initialize ReadingDAO
        readingDAO = jdbi.onDemand(ReadingDAO.class);

        // Create the readings table if it doesn't exist
        new DbConnect().createAllTables();
    }

    @AfterEach
    void cleanup() {
        // Remove all data from the readings table after each test
        new DbConnect().removeAllTables();
    }

    @Test
    void testInsertAndFindById() {
        // Insert a new reading
        readingDAO.insert(1, 101, 2022, "Electric", 150.5, 0, "Regular");

        // Find the reading by ID
        Reading foundReading = readingDAO.findById(1);

        assertNotNull(foundReading);
        assertEquals(1, foundReading.getId());
        assertEquals(1, foundReading.getcId());
        assertEquals(101, foundReading.getMeterId());
        assertEquals(2022, foundReading.getDateOfReading());
        assertEquals("Electric", foundReading.getKindOfMeter());
        assertEquals(150.5, foundReading.getMeterCount());
        assertEquals(0, foundReading.getSubstitute());
        assertEquals("Regular", foundReading.getComment());
    }

    @Test
    void testUpdate() {
        // Insert a new reading
        readingDAO.insert(1, 101, 2022, "Electric", 150.5, 0, "Regular");

        // Update the reading
        readingDAO.update(1, 2, 102, 2022, "Gas", 200.0, 1, "Updated");

        // Find the updated reading by ID
        Reading updatedReading = readingDAO.findById(1);

        assertNotNull(updatedReading);
        assertEquals(2, updatedReading.getcId());
        assertEquals(102, updatedReading.getMeterId());
        assertEquals(2022, updatedReading.getDateOfReading());
        assertEquals("Gas", updatedReading.getKindOfMeter());
        assertEquals(200.0, updatedReading.getMeterCount());
        assertEquals(1, updatedReading.getSubstitute());
        assertEquals("Updated", updatedReading.getComment());
    }

    @Test
    void testFindAll() {
        // Insert multiple readings
        readingDAO.insert(1, 101, 2022, "Electric", 150.5, 0, "Regular");
        readingDAO.insert(2, 102, 2022, "Gas", 200.0, 1, "Updated");
        readingDAO.insert(3, 103, 2022, "Water", 50.3, 0, "Low");

        // Find all readings
        List<Reading> readings = readingDAO.findAll();

        assertNotNull(readings);
        assertEquals(3, readings.size());
    }

    @Test
    void testDelete() {
        // Insert a new reading
        readingDAO.insert(1, 101, 2022, "Electric", 150.5, 0, "Regular");

        // Delete the reading
        readingDAO.delete(1);

        // Try to find the deleted reading
        Reading deletedReading = readingDAO.findById(1);

        assertNull(deletedReading);
    }
}