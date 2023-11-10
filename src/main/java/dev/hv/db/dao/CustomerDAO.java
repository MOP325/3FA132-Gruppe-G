package dev.hv.db.dao;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import dev.hv.db.model.Customer;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import java.util.List;

public interface CustomerDAO {

    @SqlUpdate("INSERT INTO customers (c_FirstName, c_LastName) VALUES (:firstName, :lastName)")
    void insert(@Bind("firstName") String firstName, @Bind("lastName") String lastName);

    @SqlUpdate("UPDATE customers SET c_FirstName = :firstName, c_LastName = :lastName WHERE c_Id = :id")
    void update(@Bind("id") int id, @Bind("firstName") String firstName, @Bind("lastName") String lastName);

    @SqlQuery("SELECT * FROM customers WHERE c_Id = :id")
    Customer findById(@Bind("id") int id);

    @SqlQuery("SELECT * FROM customers")
    List<Customer> findAll();

    @SqlUpdate("DELETE FROM customers WHERE c_Id = :id")
    void delete(@Bind("id") int id);
}

