package rest;

import dev.hv.db.dao.CustomerDAO;
import dev.hv.db.model.Customer;
import dev.hv.rest.util.CustomerResource;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerResourceTest {

    private CustomerResource customerResource;
    private CustomerDAOStub customerDAOStub;

    @BeforeEach
    public void setUp() {
        customerDAOStub = new CustomerDAOStub();
        customerResource = new CustomerResource(customerDAOStub);
    }

    @Test
    public void createCustomerTest() {
        Customer customer = new Customer(1, "John", "Doe");

        customerResource.createCustomer(customer);

        assertEquals(1, customerDAOStub.insertCalls);
        assertEquals("John", customerDAOStub.insertFirstName);
        assertEquals("Doe", customerDAOStub.insertLastName);
    }

    @Test
    public void updateCustomerTest() {
        Customer customer = new Customer(1, "John", "Doe");

        customerResource.updateCustomer(1, customer);

        assertEquals(1, customerDAOStub.updateCalls);
        assertEquals(1, customerDAOStub.updateId);
        assertEquals("John", customerDAOStub.updateFirstName);
        assertEquals("Doe", customerDAOStub.updateLastName);
    }

    @Test
    public void getCustomerByIdTest() {
        Customer expectedCustomer = new Customer(1, "John", "Doe");
        customerDAOStub.findByIdResult = expectedCustomer;

        Customer actualCustomer = customerResource.getCustomerById(1);

        assertEquals(expectedCustomer, actualCustomer);
        assertEquals(1, customerDAOStub.findByIdCalls);
        assertEquals(1, customerDAOStub.findByIdId);
    }

    @Test
    public void getAllCustomersTest() {
        List<Customer> expectedCustomers = Arrays.asList(
                new Customer(1, "John", "Doe"),
                new Customer(1,"Jane", "Smith")
        );
        customerDAOStub.findAllResult = expectedCustomers;

        List<Customer> actualCustomers = customerResource.getAllCustomers();

        assertEquals(expectedCustomers, actualCustomers);
        assertEquals(1, customerDAOStub.findAllCalls);
    }

    @Test
    public void deleteCustomerTest() {
        customerResource.deleteCustomer(1);

        assertEquals(1, customerDAOStub.deleteCalls);
        assertEquals(1, customerDAOStub.deleteId);
    }

    // Stubbed CustomerDAO for testing
    private static class CustomerDAOStub implements CustomerDAO {
        int insertCalls = 0;
        String insertFirstName;
        String insertLastName;

        int updateCalls = 0;
        int updateId;
        String updateFirstName;
        String updateLastName;

        int findByIdCalls = 0;
        int findByIdId;
        Customer findByIdResult;

        int findAllCalls = 0;
        List<Customer> findAllResult;

        int deleteCalls = 0;
        int deleteId;

        @Override
        public void insert(String firstName, String lastName) {
            insertCalls++;
            insertFirstName = firstName;
            insertLastName = lastName;
        }

        @Override
        public void update(int id, String firstName, String lastName) {
            updateCalls++;
            updateId = id;
            updateFirstName = firstName;
            updateLastName = lastName;
        }

        @Override
        public Customer findById(int id) {
            findByIdCalls++;
            findByIdId = id;
            return findByIdResult;
        }

        @Override
        public List<Customer> findAll() {
            findAllCalls++;
            return findAllResult;
        }

        @Override
        public void delete(int id) {
            deleteCalls++;
            deleteId = id;
        }
    }
}
