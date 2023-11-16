public class dbConnectTest {

    public static void main(String[] args) {

        DbConnectJunitTest junitTest = new DbConnectJunitTest();

        // Getter / Setter tests
        CustomerTest customerTest = new CustomerTest();
        UserTest userTest = new UserTest();
        ReadingTest readingTest = new ReadingTest();
        
        // Dao tests
        DAOCustomerTest daoCustomerTest = new DAOCustomerTest();
        DAOUserTest daoUserTest = new DAOUserTest();
        DAOReadingTest daoReadingTest = new DAOReadingTest();

        // Set up tests
        junitTest.setup();
        customerTest.setup();
        userTest.setup();
        readingTest.setup();


        junitTest.testCreateAllTables();
        
        // Customer tests
        customerTest.testGetters();
        customerTest.testCustomerIdSetter();
        customerTest.testCustomerFirstNameSetter();
        customerTest.testCustomerLastNameSetter();
        
        // User tests
        userTest.testGetters();
        userTest.testUserIdSetter();
        userTest.testUserFirstNameSetter();
        userTest.testUserLastNameSetter();
        userTest.testUserPasswordSetter();
        userTest.testUserTokenSetter();

        // Reading tests
        readingTest.testReadingGetters();
        readingTest.testReadingIdSetter();
        readingTest.testReadingcIdSetter();
        readingTest.testReadingMeterIdSetter();
        readingTest.testreadingKindOfMeterSetter();
        readingTest.testMeterCountSetter();
        readingTest.testSubstituteSetter();
        readingTest.testCommentSetter();

        // Dao customer tests
        daoCustomerTest.testFindCustomerById();
        daoCustomerTest.testUpdateCustomer();
        daoCustomerTest.testFindAllCustomer();
        daoCustomerTest.testDeleteCustomer();

        // Dao user tests
        daoUserTest.testFindUserById();
        daoUserTest.testUpdateUser();
        daoUserTest.testFindAllUser();
        daoUserTest.testDeleteUser();


        // Dao reading tests
        daoReadingTest.testFindReadingById();
        daoReadingTest.testUpdateReading();
        daoReadingTest.testFindAllReading();
        daoReadingTest.testDeleteReading();

        // Teardown
        junitTest.teardown();
        junitTest.testRemoveAllTables();
    }
}