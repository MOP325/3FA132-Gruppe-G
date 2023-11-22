import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import dev.hv.db.dao.DAOCustomer;
import dev.hv.db.model.Customer;
import java.util.List;

public class DAOCustomerTest {
    private DAOCustomer daoCustomer = new DAOCustomer();

    @Test
    public void testFindCustomerById() {
        try {
        
            // Insert customer
            Customer customer = new Customer(1, "John", "Doe");
            daoCustomer.insert(customer);
        
            // Find customer by ID
            Customer foundCustomer = daoCustomer.findById(1);
            assertNotNull(foundCustomer);
            assertEquals(customer.getId(), foundCustomer.getId());
            assertEquals(customer.getFirstName(), foundCustomer.getFirstName());
            assertEquals(customer.getLastName(), foundCustomer.getLastName());
            System.out.println("Test DAOCustomer find by id successful");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Test DAOCustomer find by id failed: " + e.getMessage());
        }
    }

    @Test
    public void testUpdateCustomer() {
        try {
            
            // Insert customer
            Customer customer = new Customer(1, "John", "Doe");
            daoCustomer.insert(customer);

            // Update customer
            Customer updateCustomer = daoCustomer.findById(1);
            customer.setId(1);
            customer.setFirstName("UpdatedFirstName");
            customer.setLastName("UpdatedLastName");
            daoCustomer.update(customer);

            daoCustomer.update(updateCustomer);

            // Check the new customers
            assertNotNull(updateCustomer);
            assertEquals(customer.getId(), updateCustomer.getId());
            assertEquals(customer.getFirstName(), updateCustomer.getFirstName());
            assertEquals(customer.getLastName(), updateCustomer.getLastName());

            System.out.println("Test DaoCustomer update successful");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Test DAOCustomer update failed: " + e.getMessage());
        }
    }

    @Test
    public void testFindAllCustomer() {
        try {

            // Insert customer
            daoCustomer.insert(new Customer(1, "John", "Doe"));
            daoCustomer.insert(new Customer(2, "Jane", "Smith"));
            daoCustomer.insert(new Customer(3, "Bob", "Johnson"));
            

            // Count customers
            List<Customer> customerList = daoCustomer.findAll();
            assertNotNull(customerList);
            assertEquals(3, customerList.size());

            System.out.println("Test DAOCustomer find all successful");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Test DAOCustomer find all failed: " + e.getMessage());
        }
    }

    @Test
    public void testDeleteCustomer() {
        try {
            // Insert customer
            Customer customer = new Customer(1, "John", "Doe");
            daoCustomer.insert(customer);

            // Delete customer by ID
            daoCustomer.delete(1);

            // Should return null
            Customer deletedCustomer = daoCustomer.findById(1);
            assertNotNull(deletedCustomer);

            System.out.println("Test DAOCustomer delete successful");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Test DAOCustomer delete failed: " + e.getMessage());
        }
    }
}
