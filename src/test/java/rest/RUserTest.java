package rest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import dev.hv.rest.model.RUser;

public class RUserTest {
    
    @Test
    public void NoArgsTest() {
        RUser user = new RUser();
        assertEquals(user.getUserID(), 0);
        assertEquals(user.getFirstName(), null);
        assertEquals(user.getLastName(), null);
        assertEquals(user.getPassword(), null);
        assertEquals(user.getToken(), null);
    }

    @Test
    public void AllArgsTest() {
        RUser user = new RUser("Ellias", "Dellingshausen", "Passwort", "Token", 1);        
        assertEquals(user.getUserID(), 1);
        assertEquals(user.getFirstName(), "Ellias");
        assertEquals(user.getLastName(), "Dellingshausen");
        assertEquals(user.getPassword(), "Passwort");
        assertEquals(user.getToken(), "Token");    
    
    }

    @Test
    public void setterAndGetterTest() {
        RUser user = new RUser();

        // Setter testen
        user.setUserID(1);
        user.setFirstName("Max");
        user.setLastName("Mustermann");
        user.setPassword("123456");
        user.setToken("xyz");

        // Getter testen
        assertEquals(user.getUserID(), 1);
        assertEquals(user.getFirstName(), "Max");
        assertEquals(user.getLastName(), "Mustermann");
        assertEquals(user.getPassword(), "123456");
        assertEquals(user.getToken(), "xyz");
    }
}
