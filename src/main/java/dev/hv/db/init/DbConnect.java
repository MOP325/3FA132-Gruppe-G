package dev.hv.db.init;

import org.jdbi.v3.core.Jdbi;

import java.util.Properties;

import org.jdbi.v3.core.Handle;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


public class DbConnect implements IDbConnect {
    private Properties dbProperties = new Properties();

    private String createCustomers = "CREATE TABLE Customers (Id INTEGER PRIMARY KEY AUTOINCREMENT, FirstName VARCHAR, LastName VARCHAR)";
    private String createReading = "CREATE TABLE Reading (Id INTEGER PRIMARY KEY AUTOINCREMENT,cId INTEGER, MeterId INTEGER, DateOfReading VARCHAR, KindOfMeter VARCHAR, MeterCount DOUBLE,Substitute INTEGER DEFAULT 0, Comment VARCHAR,FOREIGN KEY (cId) REFERENCES Customer(Id))";
    private String createUsers = "CREATE TABLE Users (Id INTEGER PRIMARY KEY AUTOINCREMENT, FirstName VARCHAR, LastName VARCHAR, Password VARCHAR, Token VARCHAR)";

    private String dropCustomers = "DROP TABLE IF EXISTS Customers";
    private String dropReading = "DROP TABLE IF EXISTS Reading";
    private String dropUsers = "DROP TABLE IF EXISTS Users";

    @Override
    public Jdbi getJdbi() {
        loadProperties();
        Jdbi jdbi = Jdbi.create(dbProperties.getProperty("db.url"));
        return jdbi;
    }
    
    private void loadProperties() {
    	try (InputStream input = new FileInputStream("src/config.txt"); ) {
        	dbProperties.load(input);
    	} catch (IOException ex) {
    		ex.printStackTrace();
    	}

    }

    @Override
    public Jdbi getJdbi(String uri, String user, String pw) {
        return Jdbi.create(uri, user, pw);
    }

    @Override
    public void createAllTables() {

        Handle handle = getJdbi().open();
        
        try {
            handle.begin();

            handle.createUpdate(createCustomers).execute();
            handle.createUpdate(createReading).execute();
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

    @Override
    public void removeAllTables() {

        Handle handle = getJdbi().open();
        
        try {
            handle.createUpdate(dropCustomers).execute();
            handle.createUpdate(dropReading).execute();
            handle.createUpdate(dropUsers).execute();
            
            System.out.println("Tables removed successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            handle.close();
        }
    }
}