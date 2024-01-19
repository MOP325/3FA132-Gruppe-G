package rest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import dev.hv.rest.model.RCustomer;

public class RCustomerTest {
    
    @Test
    public void NoArgsTest() {
        RCustomer customer = new RCustomer();
        assertEquals(customer.getCustomerID(), 0);
        assertEquals(customer.getFirstName(), null);
        assertEquals(customer.getLastName(), null);
    }

    @Test
    public void AllArgsTest() {
        RCustomer customer = new RCustomer("Ellias", "Dellingshausen", 1);
        assertEquals(customer.getCustomerID(), 1);
        assertEquals(customer.getFirstName(), "Ellias");
        assertEquals(customer.getLastName(), "Dellingshausen");
    }

    @Test
    public void setterAndGetterTest() {
        RCustomer customer = new RCustomer();
        customer.setCustomerID(2);
        customer.setFirstName("Jeremy");
        customer.setLastName("Rentschler");

        assertEquals(customer.getCustomerID(), 2);
        assertEquals(customer.getFirstName(), "Jeremy");
        assertEquals(customer.getLastName(), "Rentschler");
    }
}
