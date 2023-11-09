import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import dev.hv.db.model.Customer;

public class CustomerTest {
    static Customer customer;

    @BeforeEach
    public void setup() {
        customer = new Customer(1, "Jeremy", "Rentschler");
    }

    @Test
    public static void testGetters() {
        // Create a Customer object

        // Test getters
        assertEquals(1, customer.getId());
        assertEquals("John", customer.getFirstName());
        assertEquals("Doe", customer.getLastName());
    }

    @Test
    public static void testCustomerIdSetter() {
        // Test id setter
        customer.setId(2);
        assertEquals(2, customer.getId());
    }

    @Test
    public static void testCustomerFirstNameSetter() {
        // Test setters
        customer.setFirstName("Jeremy");
        assertEquals("Jeremy", customer.getFirstName());
    }

    @Test
    public static void testCustomerLastNameSetter() {
        // Test setters
        customer.setLastName("Rentschler");
        assertEquals("Rentschler", customer.getLastName());
    }
}