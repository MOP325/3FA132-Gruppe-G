package rest;

import dev.hv.db.dao.UserDAO;
import dev.hv.db.model.User;
import dev.hv.rest.util.UserResource;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserResourceTest {

    private UserResource userResource;
    private UserDAOStub userDAOStub;

    @BeforeEach
    public void setUp() {
        userDAOStub = new UserDAOStub();
        userResource = new UserResource(userDAOStub);
    }

    @Test
    public void createUserTest() {
        User user = new User(1, "John", "Doe", "password123", "token123");

        userResource.createUser(user);

        assertEquals(1, userDAOStub.insertCalls);
        assertEquals("John", userDAOStub.insertFirstName);
        assertEquals("Doe", userDAOStub.insertLastName);
        assertEquals("password123", userDAOStub.insertPassword);
        assertEquals("token123", userDAOStub.insertToken);
    }

    @Test
    public void updateUserTest() {
        User user = new User(1, "John", "Doe", "password123", "token123");

        userResource.updateUser(1, user);

        assertEquals(1, userDAOStub.updateCalls);
        assertEquals(1, userDAOStub.updateId);
        assertEquals("John", userDAOStub.updateFirstName);
        assertEquals("Doe", userDAOStub.updateLastName);
        assertEquals("password123", userDAOStub.updatePassword);
        assertEquals("token123", userDAOStub.updateToken);
    }

    @Test
    public void getUserByIdTest() {
        User expectedUser = new User(1, "John", "Doe", "password123", "token123");
        userDAOStub.findByIdResult = expectedUser;

        User actualUser = userResource.getUserById(1);

        assertEquals(expectedUser, actualUser);
        assertEquals(1, userDAOStub.findByIdCalls);
        assertEquals(1, userDAOStub.findByIdId);
    }

    @Test
    public void getAllUsersTest() {
        List<User> expectedUsers = Arrays.asList(
                new User(1, "John", "Doe", "password123", "token123"),
                new User(2, "Jane", "Smith", "pass456", "token456")
        );
        userDAOStub.findAllResult = expectedUsers;

        List<User> actualUsers = userResource.getAllUsers();

        assertEquals(expectedUsers, actualUsers);
        assertEquals(1, userDAOStub.findAllCalls);
    }

    @Test
    public void deleteUserTest() {
        userResource.deleteUser(1);

        assertEquals(1, userDAOStub.deleteCalls);
        assertEquals(1, userDAOStub.deleteId);
    }

    // Stubbed UserDAO for testing
    private static class UserDAOStub implements UserDAO {
        int insertCalls = 0;
        String insertFirstName;
        String insertLastName;
        String insertPassword;
        String insertToken;

        int updateCalls = 0;
        int updateId;
        String updateFirstName;
        String updateLastName;
        String updatePassword;
        String updateToken;

        int findByIdCalls = 0;
        int findByIdId;
        User findByIdResult;

        int findAllCalls = 0;
        List<User> findAllResult;

        int deleteCalls = 0;
        int deleteId;

        @Override
        public void insert(String firstName, String lastName, String password, String token) {
            insertCalls++;
            insertFirstName = firstName;
            insertLastName = lastName;
            insertPassword = password;
            insertToken = token;
        }

        @Override
        public void update(int id, String firstName, String lastName, String password, String token) {
            updateCalls++;
            updateId = id;
            updateFirstName = firstName;
            updateLastName = lastName;
            updatePassword = password;
            updateToken = token;
        }

        @Override
        public User findById(int id) {
            findByIdCalls++;
            findByIdId = id;
            return findByIdResult;
        }

        @Override
        public List<User> findAll() {
            findAllCalls++;
            return findAllResult;
        }

        @Override
        public void delete(int id) {
            deleteCalls++;
            deleteId = id;
        }
    }
}
