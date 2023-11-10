package dev.hv.db.dao;

import dev.hv.db.model.IDReading;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOReading<T extends IDReading> {

    private String jdbcURL = "jdbc:your_database_url";
    private String jdbcUsername = "username";
    private String jdbcPassword = "password";

    // SQL queries for CRUD operations
    private static final String INSERT_READINGS_SQL = "INSERT INTO readings (cId, meterId, dateOfReading, kindOfMeter, meterCount, substitute, comment) VALUES (?, ?, ?, ?, ?, ?, ?);";
    private static final String UPDATE_READINGS_SQL = "UPDATE readings SET cId = ?, meterId = ?, dateOfReading = ?, kindOfMeter = ?, meterCount = ?, substitute = ?, comment = ? WHERE id = ?;";
    private static final String DELETE_READINGS_SQL = "DELETE FROM readings WHERE id = ?;";

    public DAOReading() {
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

    public long insert(T reading) {
        long newId = 0;
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_READINGS_SQL,
                        Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setInt(1, reading.getcId());
            preparedStatement.setInt(2, reading.getMeterId());
            preparedStatement.setString(3, reading.getDateOfReading());
            preparedStatement.setString(4, reading.getKindOfMeter());
            preparedStatement.setDouble(5, reading.getMeterCount());
            preparedStatement.setInt(6, reading.getSubstitute());
            preparedStatement.setString(7, reading.getComment());

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

    public void update(T reading) {
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_READINGS_SQL)) {

            preparedStatement.setInt(1, reading.getcId());
            preparedStatement.setInt(2, reading.getMeterId());
            preparedStatement.setString(3, reading.getDateOfReading());
            preparedStatement.setString(4, reading.getKindOfMeter());
            preparedStatement.setDouble(5, reading.getMeterCount());
            preparedStatement.setInt(6, reading.getSubstitute());
            preparedStatement.setString(7, reading.getComment());
            preparedStatement.setLong(8, reading.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
     * public void delete(T reading) {
     * delete(reading.getId());
     * }
     * 
     */
    public void delete(Long id) {
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE_READINGS_SQL)) {
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
