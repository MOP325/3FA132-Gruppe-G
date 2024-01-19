// import org.jdbi.v3.core.Handle;
// import org.jdbi.v3.core.Jdbi;
// import org.jdbi.v3.core.statement.Query;
// import org.jdbi.v3.core.statement.Update;
// import org.junit.jupiter.api.AfterEach;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;

// import dev.hv.db.init.DbConnect;

// import java.io.ByteArrayInputStream;
// import java.io.InputStream;
// import java.sql.SQLException;
// import java.util.List;
// import java.util.Properties;

// import static org.junit.jupiter.api.Assertions.*;

// class DbConnectTest {

//     private DbConnect dbConnect;

//     @BeforeEach
//     void setUp() {
//         dbConnect = new DbConnect();
//     }

//     // @Test
//     // void testGetJdbi() {
//     // // Testing getJdbi() method with default properties
//     // Jdbi resultJdbi = dbConnect.getJdbi();

//     // assertNotNull(resultJdbi);
//     // }

//     @AfterEach
//     void cleanup() {
//         // Remove all data from the customers table after each test
//         new DbConnect().removeAllTables();
//     }

//     @Test
//     void testGetJdbiWithCredentials() {
//         // Testing getJdbi() method with custom URI, user, and password
//         Jdbi resultJdbi = dbConnect.getJdbi("jdbc:sqlite:test.db", "user", "password");

//         assertNotNull(resultJdbi);
//     }

//     @Test
//     void testCreateAllTables() {
//         // Creating an in-memory database for testing
//         // Jdbi testJdbi = Jdbi.create("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;");
//         // dbConnect.installSqlObjectPlugin(testJdbi);

//         // Creating tables
//         dbConnect.createAllTables();

//         System.out.println(dbConnect.getJdbi());

//         // Verifying that tables exist
//         assertTrue(tableExists(dbConnect.getJdbi(), "Customers"));
//         assertTrue(tableExists(dbConnect.getJdbi(), "Readings"));
//         assertTrue(tableExists(dbConnect.getJdbi(), "Users"));
//     }

//     @Test
//     void testRemoveAllTables() {
//         // Creating an in-memory database for testing
//         // Jdbi testJdbi = Jdbi.create("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;");
//         // // Jdbi testJdbi = new DbConnect().getJdbi();
//         // dbConnect.installSqlObjectPlugin(testJdbi);

//         // Creating tables
//         dbConnect.createAllTables();

//         // Removing tables
//         dbConnect.removeAllTables();

//         // Verifying that tables do not exist
//         assertFalse(dbConnect.tablesExist());
//     }

//     @Test
//     void testTablesExist() {
//         // Creating an in-memory database for testing
//         Jdbi testJdbi = Jdbi.create("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;");
//         dbConnect.installSqlObjectPlugin(testJdbi);

//         // Verifying that tables do not exist initially
//         assertFalse(dbConnect.tablesExist());

//         // Creating tables
//         dbConnect.createAllTables();

//         // Verifying that tables exist after creation
//         assertTrue(dbConnect.tablesExist());

//         // Removing tables
//         dbConnect.removeAllTables();

//         // Verifying that tables do not exist after removal
//         assertFalse(dbConnect.tablesExist());
//     }

//     @Test
//     void testLoadProperties() {
//         // Creating a ByteArrayInputStream with test properties
//         String testProperties = "db.url=jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;";
//         InputStream inputStream = new ByteArrayInputStream(testProperties.getBytes());

//         // Setting the test config file path
//         dbConnect.setConfigFilePath("src/test/resources/config.txt");

//         // Loading properties
//         dbConnect.loadProperties();

//         // Verifying that properties are loaded correctly
//         assertEquals("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;", dbConnect.getDbProperties().getProperty("db.url"));
//     }

//     // private boolean tableExists(Jdbi jdbi, String tableName) {
//     // try (Handle handle = jdbi.open()) {
//     // Query query = handle
//     // .createQuery("SELECT COUNT(*) FROM INFORMATION_SCHEMA.TABLES WHERE
//     // TABLE_NAME= :tableName")
//     // .bind("tableName", tableName);
//     // return query.mapTo(Integer.class).one() > 0;
//     // } catch (Exception e) {
//     // e.printStackTrace();
//     // return false;
//     // }
//     // }
//     private boolean tableExists(Jdbi jdbi, String tableName) {
//         try (Handle handle = jdbi.open()) {
//             String sql = "SELECT 1 FROM " + tableName + " LIMIT 1";
//             List<Integer> result = handle.createQuery(sql)
//                     .mapTo(Integer.class)
//                     .list();

//             return !result.isEmpty();
//         } catch (Exception e) {
//             // Assuming SQLException is thrown when the table doesn't exist
//             return false;
//         }
//     }

// }