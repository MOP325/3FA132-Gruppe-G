package dev.hv.rest.util;

import dev.hv.db.dao.CustomerDAO;
import dev.hv.db.model.Customer;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.sun.net.httpserver.HttpExchange;

import java.util.List;

@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource {
    private final CustomerDAO customerDAO;

    public CustomerResource(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createCustomer(Customer customer) {
        customerDAO.insert(
                customer.getFirstName(),
                customer.getLastName()
        );
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateCustomer(@PathParam("id") int id, Customer customer) {
        customerDAO.update(
                id,
                customer.getFirstName(),
                customer.getLastName()
        );
    }

    @GET
    @Path("/{id}")
    public Customer getCustomerById(@PathParam("id") int id) {
        return customerDAO.findById(id);
    }

    @GET
    public List<Customer> getAllCustomers() {
        return customerDAO.findAll();
    }

    @DELETE
    @Path("/{id}")
    public void deleteCustomer(@PathParam("id") int id) {
        customerDAO.delete(id);
    }

    public void handle(HttpExchange exchange) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handle'");
    }
}
