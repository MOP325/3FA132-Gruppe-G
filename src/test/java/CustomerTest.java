import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import dev.hv.db.model.Customer;

// Tests for the getter and setter functionalities of the Customer class
public class CustomerTest {
    Customer customer = new Customer(1, "John", "Doe");;

    @BeforeEach
    public void setup() {
        this.customer = new Customer(1, "John", "Doe");
    }

    @Test
    public void testGetters() {
        assertEquals(1, customer.getId());
        assertEquals("John", customer.getFirstName());
        assertEquals("Doe", customer.getLastName());
    
        System.out.println("Customer getters test succesfull");
    }

    @Test
    public void testCustomerIdSetter() {
        customer.setId(2);
        assertEquals(2, customer.getId());
    
        System.out.println("CustomerId setters test succesfull");
    }

    @Test
    public void testCustomerFirstNameSetter() {
        customer.setFirstName("Jeremy");
        assertEquals("Jeremy", customer.getFirstName());
    
        System.out.println("CustomerFirstName setters test succesfull");
    }

    @Test
    public void testCustomerLastNameSetter() {
        customer.setLastName("Rentschler");
        assertEquals("Rentschler", customer.getLastName());
        
        System.out.println("CustomerLastName setters test succesfull");
    }
}
