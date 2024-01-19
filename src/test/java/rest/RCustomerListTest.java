package rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

import dev.hv.rest.model.RCustomer;
import dev.hv.rest.model.RCustomerList;

public class RCustomerListTest {

    @Test
    public void testDefaultConstructor() {
        RCustomerList list = new RCustomerList();
        assertTrue("List should be emoty", list.isEmpty());
    }

    @Test
    public void testCollectionConstructor() {
        Collection<RCustomer> collection = Arrays.asList(new RCustomer(), new RCustomer());
        RCustomerList list = new RCustomerList(collection);
        assertEquals("Amount of List Items should be the same as Colection", collection.size(), list.size());
    }
}
