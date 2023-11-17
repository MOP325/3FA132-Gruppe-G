import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import dev.hv.db.model.User;

public class UserTest{
    User user;

    @BeforeEach
    public void setup() {
        this.user = new User(1, "Jeremy", "Rentschler", "123", "12344442323242");
    }

    @Test
    public void testGetters() {
        try {
            assertEquals(1, user.getId());
            assertEquals("Jeremy", user.getFirstName());
            assertEquals("Rentschler", user.getLastName());
            assertEquals("123", user.getPassword());
            assertEquals("12344442323242", user.getToken());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("User Getters test succesfull");
        }
    }

    @Test
    public void testUserIdSetter() {
        try {
            user.setId(2);
            assertEquals(2, user.getId());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("UserId setters test succesfull");
        }
    }

    @Test
    public void testUserFirstNameSetter() {
        try {
            user.setFirstName("Jeremy");
            assertEquals("Jeremy", user.getFirstName());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("UserFirstName setters test succesfull");
        }
    }

    @Test
    public void testUserLastNameSetter() {
        try {
            user.setLastName("Rentschler");
            assertEquals("Rentschler", user.getLastName());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("UsersLastName setters test succesfull");
        }

    }

    @Test public void testUserPasswordSetter() {
        try {
            user.setPassword("123");
            assertEquals("123", user.getPassword());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("userPassword setters test succesfull");
        }

    }

     @Test public void testUserTokenSetter() {
        try {
            user.setToken("12344442323242");
            assertEquals("12344442323242", user.getToken());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("userToken setters test succesfull");
        }

    }
}
