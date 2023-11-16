public class dbConnectTest {

    public static void main(String[] args) {

        DbConnectJunitTest junitTest = new DbConnectJunitTest();
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
    }
}