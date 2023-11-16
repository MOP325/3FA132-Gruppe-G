import static org.junit.Assert.assertEquals;

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
    public void testCreateAllTables() {
        // Check if the tables were created successfully
        Jdbi jdbi = dbConnect.getJdbi();

        try (Handle handle = jdbi.open()) {
            handle.select("SELECT 1 FROM Customers");
            handle.select("SELECT 1 FROM Reading");
            handle.select("SELECT 1 FROM Users");

            System.out.println(handle.select("SELECT 1 FROM Customers"));
        }
        catch (Exception e) {
            System.out.println("Failed the Test to creat all Tables in the DbConnectJunitTest");
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
            assertEquals(0, handle.select("SELECT name FROM sqlite_master WHERE type='table' AND (name='Customers' OR name='Reading' OR name='Users');").mapTo(Boolean.class).list().size());
        }
        catch(Exception e) {
               System.out.println("Failed the Test to remove all Tables in the DbConnectJunitTest");
        }
        finally {
            System.out.println("Delete tables test completed.");
        }
    }
}