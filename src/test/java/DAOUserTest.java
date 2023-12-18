import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import dev.hv.db.dao.DAOUser;
import dev.hv.db.model.User;
import java.util.List;

public class DAOUserTest {

    private DAOUser daoUser = new DAOUser();

    @Test
    public void testFindUserById() {
        // Insert user
        User user = new User(1, "John", "Doe", "password123", "token123");
        daoUser.insert(user);
        
        // Find user by ID
        User foundUser = daoUser.findById(1);
        assertNotNull(foundUser);
        assertEquals(user.getId(), foundUser.getId());
        assertEquals(user.getFirstName(), foundUser.getFirstName());
        assertEquals(user.getLastName(), foundUser.getLastName());
        assertEquals(user.getPassword(), foundUser.getPassword());
        assertEquals(user.getToken(), foundUser.getToken());

        System.out.println("Test DAOUser find by id succesful");
    }

    @Test
    public void testUpdateUser() {
        // Insert user
        User user = new User(1, "John", "Doe", "password123", "token123");
        daoUser.insert(user);
        // Update user
        User updatedUser = daoUser.findById(1);
        user.setId(1);
        user.setFirstName("UpdatedFirstName");
        user.setLastName("UpdatedLastName");
        user.setPassword("updatedPassword");
        user.setToken("updatedToken");
        daoUser.update(user);
                
        // Check the new users
        assertNotNull(updatedUser);
        assertEquals(user.getId(), updatedUser.getId());
        assertEquals(user.getFirstName(), updatedUser.getFirstName());
        assertEquals(user.getLastName(), updatedUser.getLastName());
        assertEquals(user.getPassword(), updatedUser.getPassword());
        assertEquals(user.getToken(), updatedUser.getToken());
        System.out.println("Test DAOUser update successful");
    }

    @Test
    public void testFindAllUser() {
        // Insert three users
        daoUser.insert(new User(1, "John", "Doe", "password1", "token1"));
        daoUser.insert(new User(2, "Jane", "Smith", "password2", "token2"));
        daoUser.insert(new User(3, "Bob", "Johnson", "password3", "token3"));
        // Count users
        List<User> userList = daoUser.findAll();
        assertNotNull(userList);
        assertEquals(3, userList.size());
        System.out.println("Test DAOUser find all successful");
    }

    @Test
    public void testDeleteUser() {
        // Insert user
        User user = new User(1, "John", "Doe", "password123", "token123");
        daoUser.insert(user);

        // Delete user by ID
        daoUser.delete(1);
        
        // Should return null
        User deletedUser = daoUser.findById(1);
        assertNull(deletedUser);

        System.out.println("Test DAOUser delete successful");
    }
}