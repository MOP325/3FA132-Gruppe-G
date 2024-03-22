package dev.hv.db.dao;

import org.jdbi.v3.core.Jdbi;

import dev.hv.db.model.Customer;

import java.util.List;
import java.util.Properties;

public class CustomerDAOImpl {

    private Properties dbProperties = new Properties();

    Jdbi jdbi = Jdbi.create(dbProperties.getProperty("db.url"));

    public void insert(Customer customer) {
        jdbi.useExtension(CustomerDAO.class, dao -> dao.insert(customer.getFirstName(), customer.getLastName()));
    }

    public void update(Customer customer) {
        jdbi.useExtension(CustomerDAO.class,
                dao -> dao.update(customer.getId(), customer.getFirstName(), customer.getLastName()));
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
