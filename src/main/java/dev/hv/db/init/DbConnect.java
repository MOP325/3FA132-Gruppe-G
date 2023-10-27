package dev.hv.db.init;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.statement.Update;
import org.jdbi.v3.core.Handle;

public class DbConnect implements IDbConnect {
    private Jdbi jdbi;
    private DbConnect dbConnect;

    private String createCustomers = "CREATE TABLE Customers (Id INTEGER PRIMARY KEY AUTOINCREMENT, FirstName VARCHAR, LastName VARCHAR)";
    private String createReading = "CREATE TABLE Reading (Id INTEGER PRIMARY KEY AUTOINCREMENT,cId INTEGER, MeterId INTEGER, DateOfReading VARCHAR, KindOfMeter VARCHAR, MeterCount DOUBLE,Substitute INTEGER DEFAULT 0, Comment VARCHAR,FOREIGN KEY (cId) REFERENCES Customer(Id))";

    private String dropCustomers = "DROP TABLE IF EXISTS Customers";
    private String dropReading = "DROP TABLE IF EXISTS Reading";

    public void dBConnect(String uri, String user, String pw) {
        // Initialize the Jdbi instance with the SQLite database connection
        dbConnect.dBConnect("jdbc:sqlite:/Users/eliasdellingshausen/desktop/Hausverwaltung.db", "root", "root");

        this.jdbi = Jdbi.create(uri, user, pw);
    }

    @Override
    public Jdbi getJdbi() {
        return jdbi;
    }

    @Override
    public Jdbi getJdbi(String uri, String user, String pw) {
        return Jdbi.create(uri, user, pw);
    }

    @Override
    public void createAllTables() {
        // Implement the logic to create tables using JDBI's @CreateSqlObject or other
        // methods.
        // This method is responsible for initializing your database schema.

        Handle handle = dbConnect.getJdbi().open();
        Update updateCustomer = null;
        Update updateReading = null;
        try {
            updateCustomer = handle.createUpdate(createCustomers);
            updateCustomer.execute();

            updateReading = handle.createUpdate(createReading);
            updateReading.execute();
            // Add more createUpdate statements for other tables if needed

            System.out.println("Tables created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Ensure that the Update object is closed in a finally block to release
            // resources
            if (updateCustomer != null) {
                updateCustomer.close();
            }

            if (updateReading != null) {
                updateReading.close();
            }

            if (handle == null) {
                handle.close();
            }
        }
    }

    @Override
    public void removeAllTables() {

        Handle handle = dbConnect.getJdbi().open();
        Update updateCustomer = null;
        Update updateReading = null;
        try {
            updateCustomer = handle.createUpdate(dropCustomers);
            updateCustomer.execute();

            updateReading = handle.createUpdate(dropReading);
            updateReading.execute();

            System.out.println("Tables removed successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Ensure that the Update objects are closed in a finally block to release
            // resources
            if (updateCustomer != null) {
                updateCustomer.close();
            }
            if (updateReading != null) {
                updateReading.close();
            }

            // Ensure that the Handle is closed as well
            if (handle != null) {
                handle.close();
            }
        }

        // Implement the logic to remove all tables.
    }
}