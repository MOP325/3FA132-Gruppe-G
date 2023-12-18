package dev.hv.rest.model;

public class Customers implements IRCustomer {

    private String firstName;
    private Integer id;
    private String lastName;

    // Konstruktor
    public Customers(String firstName, Integer id, String lastName) {
        this.firstName = firstName;
        this.id = id;
        this.lastName = lastName;
    }

    @Override
    public String getFirstname() {
        return firstName;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getLastname() {
        return lastName;
    }

    @Override
    public void setFirstname(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public void setLastname(String lastName) {
        this.lastName = lastName;
    }
}
