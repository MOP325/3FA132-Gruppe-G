import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

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
        
            System.out.println("User Getters test succesfull");
        }
        catch (Exception e) {
            e.printStackTrace();
            fail("User getters test failed: " + e.getMessage())
        }
    }

    @Test
    public void testUserIdSetter() {
        try {
            user.setId(2);
            assertEquals(2, user.getId());

            System.out.println("UserId setters test succesfull");
        }
        catch (Exception e) {
            e.printStackTrace();
            fail("UserId setter test failed: " + e.getMessage());
        }
    }

    @Test
    public void testUserFirstNameSetter() {
        try {
            user.setFirstName("Jeremy");
            assertEquals("Jeremy", user.getFirstName());
    
            System.out.println("UserFirstName setters test succesfull");
        }
        catch (Exception e) {
            e.printStackTrace();
            fail("UserFirstName setter test failed: " + e.getMessage());
        }
    }

    @Test
    public void testUserLastNameSetter() {
        try {
            user.setLastName("Rentschler");
            assertEquals("Rentschler", user.getLastName());

            System.out.println("UsersLastName setters test succesfull");
        }
        catch (Exception e) {
            e.printStackTrace();
            fail("UserLastName setter test failed: " + e.getMessage());
        }

    }

    @Test public void testUserPasswordSetter() {
        try {
            user.setPassword("123");
            assertEquals("123", user.getPassword());
        
            System.out.println("userPassword setters test succesfull");
        }
        catch (Exception e) {
            e.printStackTrace();
            fail("UserPassword setter test failed: " + e.getMessage());
        }

    }

     @Test public void testUserTokenSetter() {
        try {
            user.setToken("12344442323242");
            assertEquals("12344442323242", user.getToken());

            System.out.println("userToken setters test succesfull");
        }
        catch (Exception e) {
            e.printStackTrace();
            fail("UserToken setters test failed: " + e.getMessage());
        }
    }
}
