package dev.hv.db.dao;
import org.jdbi.v3.core.Jdbi;

import dev.hv.db.model.Customer;

import java.util.List;

public class DAOCustomer {

    private Jdbi jdbi;

    public DAOCustomer() {
        jdbi = Jdbi.create("jdbc:your_database_url", "username", "password");
    }

    public void insert(Customer customer) {
        jdbi.useExtension(CustomerDAO.class, dao -> dao.insert(customer.getFirstName(), customer.getLastName()));
    }

    public void update(Customer customer) {
        jdbi.useExtension(CustomerDAO.class, dao -> dao.update(customer.getId(), customer.getFirstName(), customer.getLastName()));
    }

    public Customer findById(int id) {
        return jdbi.withExtension(CustomerDAO.class, dao -> dao.findById(id));
    }

    public List<Customer> findAll() {
        return jdbi.withExtension(CustomerDAO.class, CustomerDAO::findAll);
    }

    public void delete(int id) {
        jdbi.useExtension(CustomerDAO.class, dao -> dao.delete(id));
    }
}