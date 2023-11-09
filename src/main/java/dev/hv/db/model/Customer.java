package dev.hv.db.model;
import java.beans.ConstructorProperties;

import org.jdbi.v3.core.mapper.reflect.ColumnName;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Customer implements IDCustomer {
    @ColumnName("c_Id")
    private int Id;

    @ColumnName("c_FirstName")
    private String FirstName;

    @ColumnName("c_LastName")
    private String LastName;


    // No Id needed in Constructor
    @ConstructorProperties({"c_Id", "c_FirstName", "c_LastName"})
    public Customer(int Id, String FirstName, String LastName) {
        this.FirstName = FirstName;
        this.LastName = LastName;
    }

    @Override
    public int getId() {
        return Id;
    }

    @Override
    public void setId(int id) {
        Id = id;
    }

    @Override
    public String getFirstName() {
        return FirstName;
    }

    @Override
    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    @Override
    public String getLastName() {
        return LastName;
    }

    @Override
    public void setLastName(String lastName) {
        LastName = lastName;
    }
}
