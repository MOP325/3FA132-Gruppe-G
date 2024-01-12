package dev.hv.db.dao;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import dev.hv.db.model.Customer;

import java.util.List;

// Interface for database access to the "customer" table, defines methods for inserting, updating, querying, and deleting user data.
public interface CustomerDAO {

    @SqlUpdate("INSERT INTO customers (FirstName, LastName) VALUES (:firstName, :lastName)")
    void insert(@Bind("firstName") String firstName, @Bind("lastName") String lastName);

    @SqlUpdate("UPDATE customers SET FirstName = :firstName, LastName = :lastName WHERE Id = :id")
    void update(@Bind("id") int id, @Bind("firstName") String firstName, @Bind("lastName") String lastName);

    @SqlQuery("SELECT * FROM customers WHERE Id = :id")
    Customer findById(@Bind("id") int id);

    @SqlQuery("SELECT * FROM customers")
    List<Customer> findAll();

    @SqlUpdate("DELETE FROM customers WHERE Id = :id")
    void delete(@Bind("id") int id);
}