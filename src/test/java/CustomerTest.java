//import static org.junit.Assert.assertEquals;
//import static org.junit.jupiter.api.Assertions.fail;
//
//import org.apache.velocity.app.event.ReferenceInsertionEventHandler.referenceInsertExecutor;
//import org.junit.Test;
//import org.junit.jupiter.api.BeforeEach;
//
//import dev.hv.db.model.Customer;
//
//// Tests for the getter and setter functionalities of the Customer class
//public class CustomerTest {
//    Customer customer = new Customer(1, "John", "Doe");;
//
//    @BeforeEach
//    public void setup() {
//        this.customer = new Customer(1, "John", "Doe");
//    }
//
//    // @Test
//    // public String testGetters() {
//    // try {
//    // assertEquals(1, customer.getId());
//    // assertEquals("John", customer.getFirstName());
//    // assertEquals("Doe", customer.getLastName());
//
//    // System.out.println("Customer getters test successful");
//    // return "CustomerGetters test successful";
//    // } catch (AssertionError e) {
//    // // Handle the assertion failure
//    // System.err.println("testGetters test failed: " + e.getMessage());
//    // // fail("Customer getters test failed");
//    // return "Customer getters test failed" + e.getMessage();
//    // }
//
//    // }
//
//    @Test
//    public void testGetters() {
//        assertEquals(1, customer.getId());
//        assertEquals("John", customer.getFirstName());
//        assertEquals("Doe", customer.getLastName());
//    }
//
//    // @Test
//    // public String testCustomerIdSetter() {
//    // try {
//    // customer.setId(2);
//    // assertEquals(2, customer.getId());
//
//    // System.out.println("CustomerId setters test succesfull");
//    // return "CustomerId setters test succesfull";
//    // } catch (AssertionError e) {
//    // System.out.println("testSetterId test failed: " + e.getMessage());
//    // return "testSetterId test failed: " + e.getMessage();
//    // }
//
//    // }
//
//    @Test
//    public void testCustomerIdSetter() {
//        customer.setId(2);
//        assertEquals(2, customer.getId());
//    }
//
//    // @Test
//    // public String testCustomerFirstNameSetter() {
//    // try {
//    // customer.setFirstName("Jeremy");
//    // assertEquals("Jeremy", customer.getFirstName());
//
//    // System.out.println("CustomerFirstName setters test succesfull");
//    // return "CustomerFirstName setters test succesfull";
//    // } catch (AssertionError e) {
//    // System.out.println("CustomerFirstNameSetters test failed: " +
//    // e.getMessage());
//    // return "CustomerFirstNameSetters test failed: " + e.getMessage();
//    // }
//    // }
//
//    @Test
//    public void testCustomerFirstNameSetter() {
//        customer.setFirstName("Jeremy");
//        assertEquals("Jeremy", customer.getFirstName());
//    }
//
//    // @Test
//    // public String testCustomerLastNameSetter() {
//    // try {
//    // customer.setLastName("Rentschler");
//    // assertEquals("Rentschler", customer.getLastName());
//
//    // System.out.println("CustomerLastName setters test succesfull");
//    // return "CustomerLastName setters test succesfull";
//    // } catch (AssertionError e) {
//    // System.out.println("CustomerLastNameSetters test failed: " + e.getMessage());
//    // return "CustomerLastNameSetters test failed: " + e.getMessage();
//    // }
//    // }
//
//    @Test
//    public void testCustomerLastNameSetter() {
//        customer.setLastName("Rentschler");
//        assertEquals("Rentschler", customer.getLastName());
//    }
//}

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.hv.db.model.Customer;

// Tests for the getter and setter functionalities of the Customer class
public class CustomerTest {
    Customer customer;

    @BeforeEach
    public void setup() {
        this.customer = new Customer(1, "John", "Doe");
    }

    @Test
    public void testGetters() {
        assertEquals(1, customer.getId());
        assertEquals("John", customer.getFirstName());
        assertEquals("Doe", customer.getLastName());
    }

    @Test
    public void testCustomerIdSetter() {
        customer.setId(2);
        assertEquals(2, customer.getId());
    }

    @Test
    public void testCustomerFirstNameSetter() {
        customer.setFirstName("Jeremy");
        assertEquals("Jeremy", customer.getFirstName());
    }

    @Test
    public void testCustomerLastNameSetter() {
        customer.setLastName("Rentschler");
        assertEquals("Rentschler", customer.getLastName());
    }
}
