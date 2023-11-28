import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import dev.hv.db.model.Customer;

// Tests für die Getter- und Setter-Funktionalitäten der Customer-Klasse
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
        System.out.println("Customer getters test succesfull");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Customer getterts test failed: " + e.getMessage());
        }
    }

    @Test
    public void testCustomerIdSetter() {
        // Test id setter
        try {
        customer.setId(2);
        assertEquals(2, customer.getId());
        System.out.println("CustomerId setters test succesfull");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("CustomerId setters test failed: " + e.getMessage());
        }
    }

    @Test
    public void testCustomerFirstNameSetter() {
        // Test setters
        try {
        customer.setFirstName("Jeremy");
        assertEquals("Jeremy", customer.getFirstName());
        System.out.println("CustomerFirstName setters test succesfull");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("CustomerFirstName setter test failed: " + e.getMessage());
        }
    }

    @Test
    public void testCustomerLastNameSetter() {
        // Test setters
        try {
        customer.setLastName("Rentschler");
        assertEquals("Rentschler", customer.getLastName());
        System.out.println("CustomerLastName setters test succesfull");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("CustomerLastName setters test failed: " + e.getMessage());
        }
    }
}
