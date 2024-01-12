import dev.hv.db.dao.UserDAO;
import dev.hv.db.model.User;
import dev.hv.rest.model.UserResource;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.*;

class UserResourceTest {

    private UserDAO userDAO;
    private UserResource userResource;

    User user = new User(1, "Jeremy", "Rentschler", "123", "12344442323242");

    @BeforeEach
    void setUp() {
        userDAO = mock(UserDAO.class);
        userResource = new UserResource(userDAO);
    }

    @Test
    void testCreateUser() {
        userResource.createUser(user);

        // Verify that the insert method of UserDAO is called with the correct parameters
        verify(userDAO, times(1)).insert("Jeremy", "Rentschler", "123", "12344442323242");
    }

    @Test
    void testUpdateUser() {
        int userId = 1;
        User updatedUser = new User(userId, "Updated", "User", "newPassword", "newToken");

        userResource.updateUser(userId, updatedUser);

        // Verify that the update method of UserDAO is called with the correct parameters
        verify(userDAO, times(1)).update(userId, "Updated", "User", "newPassword", "newToken");
    }

    @Test
    void testGetUserById() {
        int userId = 1;
        when(userDAO.findById(userId)).thenReturn(user);

        User result = userResource.getUserById(userId);

        // Verify that the findById method of UserDAO is called with the correct parameter
        verify(userDAO, times(1)).findById(userId);

        // Verify that the result is not null and contains the expected user data
        assertNotNull(result);
        assertEquals("Jeremy", result.getFirstName());
        assertEquals("Rentschler", result.getLastName());
        assertEquals("123", result.getPassword());
        assertEquals("12344442323242", result.getToken());
    }

    @Test
    void testGetAllUsers() {
        List<User> userList = new ArrayList<>();
        userList.add(this.user);
        User user = new User(1, "Jeremy", "Rentschler", "123", "12344442323242");
        userList.add(user);

        when(userDAO.findAll()).thenReturn(userList);

        List<User> result = userResource.getAllUsers();

        // Verify that the findAll method of UserDAO is called
        verify(userDAO, times(1)).findAll();

        // Verify that the result is not null and contains the expected users
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("John", result.get(0).getFirstName());
        assertEquals("Doe", result.get(0).getLastName());
        assertEquals("Jane", result.get(1).getFirstName());
        assertEquals("Doe", result.get(1).getLastName());
    }

    @Test
    void testDeleteUser() {
        int userId = 1;

        userResource.deleteUser(userId);

        // Verify that the delete method of UserDAO is called with the correct parameter
        verify(userDAO, times(1)).delete(userId);
    }
}
