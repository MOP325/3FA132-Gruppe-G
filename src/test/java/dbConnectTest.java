public class dbConnectTest {

    public static void main(String[] args) {

        DbConnectJunit junitTest = new DbConnectJunit();
        CustomerTest customerTest = new CustomerTest();
        UserTest userTest = new UserTest();
        ReadingTest readingTest = new ReadingTest();

        junitTest.setup();
        customerTest.setup();
        userTest.setup();
        readingTest.setup();
        
        junitTest.testCreateAllTables();
        
        customerTest.testGetters();
        customerTest.testCustomerIdSetter();
        customerTest.testCustomerFirstNameSetter();
        customerTest.testCustomerLastNameSetter();
        
        userTest.testGetters();
        userTest.testUserIdSetter();
        userTest.testUserFirstNameSetter();
        userTest.testUserLastNameSetter();
        userTest.testUserPasswordSetter();
        userTest.testUserTokenSetter();

        readingTest.testReadingGetters();
        readingTest.testReadingIdSetter();
        readingTest.testReadingcIdSetter();
        readingTest.testReadingMeterIdSetter();
        readingTest.testreadingKindOfMeterSetter();
        readingTest.testMeterCountSetter();
        readingTest.testSubstituteSetter();
        readingTest.testCommentSetter();

        junitTest.teardown();
        junitTest.testRemoveAllTables();

        // String sql = "SELECT Id, FirstName, LastName FROM Customer";

        // DbConnect dbConnect = new DbConnect();
        // dbConnect.dBConnect("jdbc:sqlite:/Users/eliasdellingshausen/desktop/Hausverwaltung.db",
        // "root", "root");

        // Handle handle = dbConnect.getJdbi().open();

        // List<Customer> customers = handle.createQuery(sql).mapToBean(Customer.class)
        // .list();

        // handle.close();

        // for (Customer customer : customers) {
        // // Access and process customer data
        // System.out.println("ID: " + customer.getId() + ", FirstName: " +
        // customer.getFirstName() + ", LastName: "
        // + customer.getLastName());
        // }

    }
}

// org.jdbi.v3.core.statement.UnableToCreateStatementException: org.sqlite.SQLiteException: [SQLITE_ERROR] SQL error or missing database (table Users already exists) [statement:"CREATE TABLE Users (Id INTEGER PRIMARY KEY AUTOINCREMENT, FirstName VARCHAR, LastName VARCHAR, Password VARCHAR, Token VARCHAR)", arguments:{positional:{}, named:{}, finder:[]}