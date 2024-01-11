package dev.hv.db.init;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import java.util.Properties;

import org.jdbi.v3.core.Handle;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DbConnect implements IDbConnect {
    private Properties dbProperties = new Properties();

    // Creating the tables
    private String createCustomers = "CREATE TABLE Customers (Id INTEGER PRIMARY KEY AUTOINCREMENT, FirstName VARCHAR, LastName VARCHAR)";
    private String createReadings = "CREATE TABLE Readings (Id INTEGER PRIMARY KEY AUTOINCREMENT,cId INTEGER, MeterId INTEGER, DateOfReading INTEGER, KindOfMeter VARCHAR, MeterCount DOUBLE,Substitute INTEGER DEFAULT 0, Comment VARCHAR,FOREIGN KEY (cId) REFERENCES Customer(Id))";
    private String createUsers = "CREATE TABLE Users (Id INTEGER PRIMARY KEY AUTOINCREMENT, FirstName VARCHAR, LastName VARCHAR, Password VARCHAR, Token VARCHAR)";

    // Removing the tables
    private String dropCustomers = "DROP TABLE IF EXISTS Customers";
    private String dropReadings = "DROP TABLE IF EXISTS Readings";
    private String dropUsers = "DROP TABLE IF EXISTS Users";

    // Method to retrieve a Jdbi instance
    @Override
    public Jdbi getJdbi() {
        loadProperties();
        Jdbi jdbi = Jdbi.create(dbProperties.getProperty("db.url"));
        installSqlObjectPlugin(jdbi);
        return jdbi;
    }

    @Override
    public Jdbi getJdbi(String uri, String user, String pw) {
        Jdbi jdbi = Jdbi.create(uri, user, pw);
        installSqlObjectPlugin(jdbi);
        return jdbi;
    }

    private void installSqlObjectPlugin(Jdbi jdbi) {
        jdbi.installPlugin(new SqlObjectPlugin());
    }

    // Method for creating all tables
    @Override
    public void createAllTables() {

        Handle handle = getJdbi().open();

        try {
            handle.begin();

            handle.createUpdate(createCustomers).execute();
            handle.createUpdate(createReadings).execute();
            handle.createUpdate(createUsers).execute();

            handle.commit();
            System.out.println("Tables created succesfully");
        } catch (Exception e) {
            handle.rollback();
            e.printStackTrace();
        } finally {
            handle.close();
        }
    }

    // Method for removing all tables
    @Override
    public void removeAllTables() {

        Handle handle = getJdbi().open();

        try {
            handle.createUpdate(dropCustomers).execute();
            handle.createUpdate(dropReadings).execute();
            handle.createUpdate(dropUsers).execute();

            System.out.println("Tables removed successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            handle.close();
        }
    }

    // Loading configuration information
    public void loadProperties() {
        try (InputStream input = new FileInputStream("src/config.txt");) {
            dbProperties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private String configFilePath;

    public void setConfigFilePath(String configFilePath) {
        this.configFilePath = configFilePath;
    }

    public Properties getDbProperties() {
        return dbProperties;
    }

    public boolean tablesExist() {
        Jdbi jdbi = getJdbi();
        try (Handle handle = jdbi.open()) {
            // Modify the queries based on your database type and structure
            boolean customersTableExists = handle.createQuery("SELECT COUNT(*) FROM Customers")
                    .mapTo(Integer.class)
                    .one() > 0;

            boolean readingTableExists = handle.createQuery("SELECT COUNT(*) FROM Reading")
                    .mapTo(Integer.class)
                    .one() > 0;

            boolean usersTableExists = handle.createQuery("SELECT COUNT(*) FROM Users")
                    .mapTo(Integer.class)
                    .one() > 0;

            return customersTableExists && readingTableExists && usersTableExists;
        }
    }
}