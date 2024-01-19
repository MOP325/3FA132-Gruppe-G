package rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import dev.hv.rest.model.RUser;
import dev.hv.rest.model.RUserList;

public class RUserListTest {
    
    @Test
    public void testDefaultConstructor() {
        RUserList userList = new RUserList();
        assertNotNull(userList);
    }

    @Test
    public void testConstructorWithCollection() {
        Collection<RUser> collection = new ArrayList<>();
        collection.add(new RUser());
        collection.add(new RUser());

        RUserList userList = new RUserList(collection);
        assertEquals("Amount of List Items should be the same as Colection", 2, userList.size());
    }

    @Test
    public void testConstructorWithInitialCapacity() {
        int initialCapacity = 10;
        RUserList userList = new RUserList(initialCapacity);
        assertNotNull(userList);
    }
}
