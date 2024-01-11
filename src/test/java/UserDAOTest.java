import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.hv.db.dao.UserDAO;
import dev.hv.db.model.User;
import dev.hv.db.init.DbConnect;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.mapper.reflect.BeanMapper;

import java.util.List;

public class UserDAOTest {

    private UserDAO userDAO;
    private Jdbi jdbi;

    @BeforeEach
    void setup() {
        // Create an instance of the Jdbi with the existing database configuration
        jdbi = new DbConnect().getJdbi();
        jdbi.registerRowMapper(BeanMapper.factory(User.class));

        // Initialize UserDAO
        userDAO = jdbi.onDemand(UserDAO.class);

        // Create the users table if it doesn't exist
        new DbConnect().createAllTables();
    }

    @AfterEach
    void cleanup() {
        // Remove all data from the users table after each test
        new DbConnect().removeAllTables();
    }

    @Test
    void testInsertAndFindById() {
        // Insert a new user
        userDAO.insert("John", "Doe", "password123", "token123");

        // Find the user by ID
        User foundUser = userDAO.findById(1);

        assertNotNull(foundUser);
        assertEquals(1, foundUser.getId());
        assertEquals("John", foundUser.getFirstName());
        assertEquals("Doe", foundUser.getLastName());
        assertEquals("password123", foundUser.getPassword());
        assertEquals("token123", foundUser.getToken());
    }

    @Test
    void testUpdate() {
        // Insert a new user
        userDAO.insert("John", "Doe", "password123", "token123");

        // Update the user
        userDAO.update(1, "Jane", "Smith", "newpassword", "newtoken");

        // Find the updated user by ID
        User updatedUser = userDAO.findById(1);

        assertNotNull(updatedUser);
        assertEquals("Jane", updatedUser.getFirstName());
        assertEquals("Smith", updatedUser.getLastName());
        assertEquals("newpassword", updatedUser.getPassword());
        assertEquals("newtoken", updatedUser.getToken());
    }

    @Test
    void testFindAll() {
        // Insert multiple users
        userDAO.insert("John", "Doe", "password123", "token123");
        userDAO.insert("Jane", "Smith", "newpassword", "newtoken");
        userDAO.insert("Alice", "Johnson", "pass123", "token456");

        // Find all users
        List<User> users = userDAO.findAll();

        assertNotNull(users);
        assertEquals(3, users.size());
    }

    @Test
    void testDelete() {
        // Insert a new user
        userDAO.insert("John", "Doe", "password123", "token123");

        // Delete the user
        userDAO.delete(1);

        // Try to find the deleted user
        User deletedUser = userDAO.findById(1);

        assertNull(deletedUser);
    }
}