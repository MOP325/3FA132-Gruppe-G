package dev.hv.rest.model;

public class Users implements IRUser {

    private String firstName;
    private Integer id;
    private String lastName;
    private String password;
    private String token;

    public Users(String firstName, Integer id, String lastName, String password, String token) {
        this.firstName = firstName;
        this.id = id;
        this.lastName = lastName;
        this.password = password;
        this.token = token;
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
    public String getPassword() {
        return password;
    }

    @Override
    public String getToken() {
        return token;
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

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void setToken(String token) {
        this.token = token;
    }
}
