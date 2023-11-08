import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.Handle;

public class DbConnectJunit {

    private DbConnect dbConnect;

    @Before
    public void setup() {
        // Initialize the DbConnect instance and create the database tables before each test
        dbConnect = new DbConnect();
        dbConnect.dBConnect("jdbc:sqlite:/Users/eliasdellingshausen/desktop/Hausverwaltung.db", "root", "root");
        dbConnect.createAllTables();
    }

    @After
    public void teardown() {
        // Remove the database tables after each test
        dbConnect.removeAllTables();
    }

    @Test
    public void testCreateAllTables() {
        // Check if the tables were created successfully
        Jdbi jdbi = dbConnect.getJdbi();
        try (Handle handle = jdbi.open()) {
            // You can write queries to check if the tables exist and have the expected structure
            assertTrue(handle.select("SELECT name FROM sqlite_master WHERE type='table' AND name='Customers';").mapTo(Boolean.class).findOnly());
            assertTrue(handle.select("SELECT name FROM sqlite_master WHERE type='table' AND name='Reading';").mapTo(Boolean.class).findOnly());
            assertTrue(handle.select("SELECT name FROM sqlite_master WHERE type='table' AND name='Users';").mapTo(Boolean.class).findOnly());
        }
    }

    @Test
    public void testRemoveAllTables() {
        // Check if the tables were removed successfully
        Jdbi jdbi = dbConnect.getJdbi();
        try (Handle handle = jdbi.open()) {
            // You can write queries to check if the tables no longer exist
            assertEquals(0, handle.select("SELECT name FROM sqlite_master WHERE type='table' AND (name='Customers' OR name='Reading' OR name='Users');").mapTo(Boolean.class).list().size());
        }
    }
}