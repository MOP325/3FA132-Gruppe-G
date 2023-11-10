package dev.hv.db.dao;

import dev.hv.db.model.IDUser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOUser<T extends IDUser> {

    private String jdbcURL = "jdbc:your_database_url";
    private String jdbcUsername = "username";
    private String jdbcPassword = "password";

    // SQL queries for CRUD operations
    private static final String INSERT_USERS_SQL = "INSERT INTO users (firstName, lastName, password, token) VALUES (?, ?, ?, ?);";
    private static final String UPDATE_USERS_SQL = "UPDATE users SET firstName = ?, lastName = ?, password = ?, token = ? WHERE id = ?;";
    private static final String DELETE_USERS_SQL = "DELETE FROM users WHERE id = ?;";

    public DAOUser() {
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

    public long insert(T user) {
        long newId = 0;
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL,
                        Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getToken());

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

    public void update(T user) {
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL)) {

            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getToken());
            preparedStatement.setLong(5, user.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /*
     * public void delete(T user) {
     * delete(user.getId());
     * }
     */

    public void delete(Long id) {
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL)) {
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
