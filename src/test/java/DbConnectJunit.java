import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.Test;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.Handle;

import dev.hv.db.init.DbConnect;

public class DbConnectJunit {

    private DbConnect dbConnect;

    @BeforeAll
    public void setup() {
        dbConnect = new DbConnect();
        dbConnect.removeAllTables();
        dbConnect.createAllTables();

    }

    @AfterAll
    public void teardown() {
        dbConnect.removeAllTables();
    }

    @Test
    public void testCreateAllTables() {
        // Check if the tables were created successfully
        Jdbi jdbi = dbConnect.getJdbi();

        try (Handle handle = jdbi.open()) {
            // You can write queries to check if the tables exist and have the expected structure
            // assertTrue(handle.select("SELECT name FROM sqlite_master WHERE type='table' AND name='Customers';").mapTo(Boolean.class).findOnly());
            // assertTrue(handle.select("SELECT name FROM sqlite_master WHERE type='table' AND name='Reading';").mapTo(Boolean.class).findOnly());
            // assertTrue(handle.select("SELECT name FROM sqlite_master WHERE type='table' AND name='Users';").mapTo(Boolean.class).findOnly());
            handle.select("SELECT 1 FROM Customers");
            handle.select("SELECT 1 FROM Reading");
            handle.select("SELECT 1 FROM Users");

            System.out.println(handle.select("SELECT 1 FROM Customers"));
        }
        catch (Exception e) {
            System.out.println("Upsi Wupsi XDD");
            e.printStackTrace();

        } 
        finally {
        System.out.println("Tables creation test completed.");
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
        catch(Exception e) {
               System.out.println("Upsi Wupsi XDD");
        }
        finally {
            System.out.println("Delete tables test completed.");
        }
    }
}