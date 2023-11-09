package dev.hv.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dev.hv.db.model.IDCustomer;

public class DAOCustomer<T extends IDCustomer> {

    private String jdbcURL = "jdbc:your_database_url";
    private String jdbcUsername = "username";
    private String jdbcPassword = "password";

    private static final String INSERT_CUSTOMERS_SQL = "INSERT INTO customers (name, email, address) VALUES (?, ?, ?);";
    private static final String UPDATE_CUSTOMERS_SQL = "UPDATE customers SET name = ?, email = ?, address = ? WHERE id = ?;";
    private static final String DELETE_CUSTOMERS_SQL = "DELETE FROM customers WHERE id = ?;";

    public DAOCustomer() {
        // Constructor
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public long insert(T customer) {
        long newId = 0;
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMERS_SQL,
                        Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, customer.getFirstName());
            preparedStatement.setString(2, customer.getLastName());
            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        newId = generatedKeys.getLong(1);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newId;
    }

    public void update(T customer) {
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMERS_SQL)) {

            preparedStatement.setString(1, customer.getFirstName());
            preparedStatement.setString(2, customer.getLastName());
            preparedStatement.setLong(4, customer.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
     * public void update(Long id, T customer) {
     * customer.setId(id);
     * update(customer);
     * }
     * 
     * public void delete(T customer) {
     * delete(customer.getId());
     * }
     */

    public void delete(Long id) {
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMERS_SQL)) {
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
