package dev.hv.db.init;

import org.jdbi.v3.core.Jdbi;

class DbConnect implements IDbConnect {
    private Jdbi jdbi;

    public String dBConnect (String uri, String user, String pw) {
        // Initialize the Jdbi instance with the SQLite database connection
        this.jdbi = Jdbi.create(uri, user, pw);
        return "";
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
        // Implement the logic to create tables using JDBI's @CreateSqlObject or other methods.
        // This method is responsible for initializing your database schema.
    }

    @Override
    public void removeAllTables() {
        // Implement the logic to remove all tables.
    }
}

// DBConnect dbConnect = new DBConnectImpl("jdbc:sqlite:/path/to/your/database.db", "username", "password");

// // Access Jdbi instance
// Jdbi jdbi = dbConnect.getJdbi();

// // Create tables
// dbConnect.createAllTables();

// // Remove tables
// dbConnect.removeAllTables();

// This method is used to create and return a new Jdbi instance with a specified database connection URI, username, and password. It is typically used for initializing a Jdbi instance with connection details for a specific database. You would call this method when you want to work with a different database or when you need a separate Jdbi instance for a specific purpose. The Jdbi instance created with this method is not shared with other parts of your application.