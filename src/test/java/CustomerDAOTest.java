import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.hv.db.dao.CustomerDAO;
import dev.hv.db.model.Customer;
import dev.hv.db.init.DbConnect;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.mapper.reflect.BeanMapper;

import java.util.List;

public class CustomerDAOTest {

    private CustomerDAO customerDAO;
    private Jdbi jdbi;

    @BeforeEach
    void setup() {
        // Create an instance of the Jdbi with the existing database configuration
        jdbi = new DbConnect().getJdbi();
        jdbi.registerRowMapper(BeanMapper.factory(Customer.class));

        // Initialize CustomerDAO
        customerDAO = jdbi.onDemand(CustomerDAO.class);

        // Create the customers table if it doesn't exist (you may want to modify this
        // based on your database)
        new DbConnect().createAllTables();
    }

    @AfterEach
    void cleanup() {
        // Remove all data from the customers table after each test
        new DbConnect().removeAllTables();
    }

    @Test
    void testInsertAndFindById() {
        // Insert a new customer
        customerDAO.insert("John", "Doe");

        // Find the customer by ID
        Customer foundCustomer = customerDAO.findById(1);

        assertNotNull(foundCustomer);
        assertEquals("John", foundCustomer.getFirstName());
        assertEquals("Doe", foundCustomer.getLastName());
    }

    @Test
    void testUpdate() {
        // Insert a new customer
        customerDAO.insert("John", "Doe");

        // Update the customer
        customerDAO.update(1, "UpdatedFirstName", "UpdatedLastName");

        // Find the updated customer by ID
        Customer updatedCustomer = customerDAO.findById(1);

        assertNotNull(updatedCustomer);
        assertEquals("UpdatedFirstName", updatedCustomer.getFirstName());
        assertEquals("UpdatedLastName", updatedCustomer.getLastName());
    }

    @Test
    void testFindAll() {
        // Insert multiple customers
        customerDAO.insert("John", "Doe");
        customerDAO.insert("Jane", "Smith");
        customerDAO.insert("Bob", "Johnson");

        // Find all customers
        List<Customer> customers = customerDAO.findAll();

        assertNotNull(customers);
        assertEquals(3, customers.size());
    }

    @Test
    void testDelete() {
        // Insert a new customer
        customerDAO.insert("John", "Doe");

        // Delete the customer
        customerDAO.delete(1);

        // Try to find the deleted customer
        Customer deletedCustomer = customerDAO.findById(1);

        assertNull(deletedCustomer);
    }
}