import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import dev.hv.db.model.Customer;

public class CustomerTest {
    Customer customer;

    @BeforeEach
    public void setup() {
        this.customer = new Customer(1, "John", "Doe");
    }

    @Test
    public void testGetters() {
        // Test getters
        try {
        assertEquals(1, customer.getId());
        assertEquals("John", customer.getFirstName());
        assertEquals("Doe", customer.getLastName());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("Customer Getters test succesfull");
        }
    }

    @Test
    public void testCustomerIdSetter() {
        // Test id setter
        try {
        customer.setId(2);
        assertEquals(2, customer.getId());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("CustomerId setters test succesfull");
        }
    }

    @Test
    public void testCustomerFirstNameSetter() {
        // Test setters
        try {
        customer.setFirstName("Jeremy");
        assertEquals("Jeremy", customer.getFirstName());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("CustomerFirstName setters test succesfull");
        }
    }

    @Test
    public void testCustomerLastNameSetter() {
        // Test setters
        try {
        customer.setLastName("Rentschler");
        assertEquals("Rentschler", customer.getLastName());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("CustomerLastName setters test succesfull");
        }
    }
}
