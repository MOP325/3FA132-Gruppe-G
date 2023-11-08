import org.jdbi.v3.core.Handle;

import dev.hv.db.init.*;

import java.util.List;

public class dbConnectTest {

    public static void main(String[] args) {

        DbConnectJunit testOne = new DbConnectJunit();
        testOne.setup();
        testOne.testCreateAllTables();
        testOne.testRemoveAllTables();
        testOne.teardown();

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