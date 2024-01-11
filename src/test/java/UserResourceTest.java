import dev.hv.db.dao.UserDAO;
import dev.hv.db.model.User;
import dev.hv.rest.modelTest.UserResource;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserResourceTest {

    private UserDAO userDAO;
    private UserResource userResource;

    @BeforeEach
    void setUp() {
        userDAO = mock(UserDAO.class);
        userResource = new UserResource(userDAO);
    }

    @Test
    void testCreateUser() {
        User user = new User("John", "Doe", "password", "token");

        userResource.createUser(user);

        // Verify that the insert method of UserDAO is called with the correct parameters
        verify(userDAO, times(1)).insert("John", "Doe", "password", "token");
    }

    @Test
    void testUpdateUser() {
        int userId = 1;
        User user = new User("Updated", "User", "newPassword", "newToken");

        userResource.updateUser(userId, user);

        // Verify that the update method of UserDAO is called with the correct parameters
        verify(userDAO, times(1)).update(userId, "Updated", "User", "newPassword", "newToken");
    }

    @Test
    void testGetUserById() {
        int userId = 1;
        when(userDAO.findById(userId)).thenReturn(new User("John", "Doe", "password", "token"));

        User result = userResource.getUserById(userId);

        // Verify that the findById method of UserDAO is called with the correct parameter
        verify(userDAO, times(1)).findById(userId);

        // Verify that the result is not null
        assertNotNull(result);
        assertEquals("John", result.getFirstName());
        assertEquals("Doe", result.getLastName());
        assertEquals("password", result.getPassword());
        assertEquals("token", result.getToken());
    }

    @Test
    void testGetAllUsers() {
        List<User> userList = new ArrayList<>();
        userList.add(new User("John", "Doe", "password", "token"));
        userList.add(new User("Jane", "Doe", "pass123", "token123"));

        when(userDAO.findAll()).thenReturn(userList);

        List<User> result = userResource.getAllUsers();

        // Verify that the findAll method of UserDAO is called
        verify(userDAO, times(1)).findAll();

        // Verify that the result is not null and contains the expected users
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("John", result.get(0).getFirstName());
        assertEquals("Jane", result.get(1).getFirstName());
    }

    @Test
    void testDeleteUser() {
        int userId = 1;

        userResource.deleteUser(userId);

        // Verify that the delete method of UserDAO is called with the correct parameter
        verify(userDAO, times(1)).delete(userId);
    }
}
