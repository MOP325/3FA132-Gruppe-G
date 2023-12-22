import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.hv.db.model.User;

// Tests for the getter and setter functionalities of the User class
public class UserTest {
    User user;

    @BeforeEach
    public void setup() {
        this.user = new User(1, "Jeremy", "Rentschler", "123", "12344442323242");
    }

    @Test
    public void testGetters() {
        assertEquals(1, user.getId());
        assertEquals("Jeremy", user.getFirstName());
        assertEquals("Rentschler", user.getLastName());
        assertEquals("123", user.getPassword());
        assertEquals("12344442323242", user.getToken());
    }

    @Test
    public void testUserIdSetter() {
        user.setId(2);
        assertEquals(2, user.getId());
    }

    @Test
    public void testUserFirstNameSetter() {
        user.setFirstName("Jeremy");
        assertEquals("Jeremy", user.getFirstName());
    }

    @Test
    public void testUserLastNameSetter() {
        user.setLastName("Rentschler");
        assertEquals("Rentschler", user.getLastName());
    }

    @Test
    public void testUserPasswordSetter() {
        user.setPassword("123");
        assertEquals("123", user.getPassword());
    }

    @Test
    public void testUserTokenSetter() {
        user.setToken("12344442323242");
        assertEquals("12344442323242", user.getToken());
    }
}
