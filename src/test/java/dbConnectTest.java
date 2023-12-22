// import static org.junit.jupiter.api.Assertions.*;

// import org.jdbi.v3.core.Jdbi;
// import org.junit.jupiter.api.AfterEach;
// import org.junit.jupiter.api.BeforeAll;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;

// import java.io.IOException;
// import java.nio.file.Files;
// import java.nio.file.Path;

// import dev.hv.db.init.DbConnect;

// public class DbConnectTest {

// private DbConnect dbConnect;

// @BeforeAll
// public static void globalSetup() {
// // Perform any global setup here if needed
// }

// @BeforeEach
// public void setUp() {
// dbConnect = new DbConnect();

// // Ensure that dbProperties is initialized before calling loadProperties
// dbConnect.loadProperties();

// dbConnect.removeAllTables();
// dbConnect.createAllTables();
// }

// @AfterEach
// public void tearDown() {
// dbConnect.removeAllTables();
// }

// @Test
// public void getJdbi_DefaultConstructor_ReturnsValidJdbiInstance() {
// Jdbi jdbi = dbConnect.getJdbi();

// assertNotNull(jdbi);
// // Add more assertions if needed
// }

// @Test
// public void getJdbi_WithParameters_ReturnsValidJdbiInstance() {
// Jdbi jdbi = dbConnect.getJdbi("jdbc:h2:mem:test", "username", "password");

// assertNotNull(jdbi);
// // Add more assertions if needed
// }

// @Test
// public void loadProperties_ValidConfigFile_PropertiesLoadedSuccessfully()
// throws IOException {
// // Create a temporary config file
// Path tempConfigFile = Files.createTempFile("tempConfig", ".txt");
// Files.writeString(tempConfigFile, "db.url=jdbc:h2:mem:test");

// // Set the config file path in the DbConnect instance
// dbConnect.setConfigFilePath(tempConfigFile.toString());

// // Load properties
// dbConnect.loadProperties();

// // Verify that properties are loaded
// assertNotNull(dbConnect.getDbProperties().getProperty("db.url"));

// // Clean up
// Files.deleteIfExists(tempConfigFile);
// }

// @Test
// public void
// createAndRemoveAllTables_ValidTables_TablesCreatedAndRemovedSuccessfully() {
// // Create tables
// dbConnect.createAllTables();

// // Check if tables exist
// assertTrue(dbConnect.tablesExist());

// // Remove tables
// dbConnect.removeAllTables();

// // Check if tables are removed
// assertFalse(dbConnect.tablesExist());
// }

// @Test
// public void removeAllTables_NoTablesToDrop_NoExceptionThrown() {
// // This test ensures that calling removeAllTables when no tables exist does
// not
// // throw an exception
// assertDoesNotThrow(() -> dbConnect.removeAllTables());
// }
// }