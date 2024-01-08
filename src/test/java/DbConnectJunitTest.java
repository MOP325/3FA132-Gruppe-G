import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.Test;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.Handle;

import dev.hv.db.init.DbConnect;

public class DbConnectJunitTest {

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
    public void testGetJdbi() {
        DbConnect dbConnect = new DbConnect();
        Jdbi jdbi = dbConnect.getJdbi();
        assertNotNull(jdbi);
    }

    @Test
    public void testCreateAllTables() {
        // Check if the tables were created successfully
        Jdbi jdbi = dbConnect.getJdbi();

        try (Handle handle = jdbi.open()) {
            handle.select("SELECT 1 FROM Customers");
            handle.select("SELECT 1 FROM Reading");
            handle.select("SELECT 1 FROM Users");

            System.out.println("DbConnectJunitTest create tables test succcesfull.");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("DbConnectJunitTest failed to creat all Tables: " + e.getMessage());
        }     
    
    }

    @Test
    public void testRemoveAllTables() {
        // Check if the tables were removed successfully
        Jdbi jdbi = dbConnect.getJdbi();
        try (Handle handle = jdbi.open()) {
            assertEquals(0, handle.select("SELECT name FROM sqlite_master WHERE type='table' AND (name='Customers' OR name='Reading' OR name='Users');").mapTo(Boolean.class).list().size());
            System.out.println("DbConnectJunitTest delete tables test succcesfull.");
        }
        catch(Exception e) {
               System.out.println("DbConnectJunitTest failed to remove all Tables: " + e.getMessage());
        }
    }
}