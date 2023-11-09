package dev.hv.db.model;
import java.beans.ConstructorProperties;

import org.jdbi.v3.core.mapper.reflect.ColumnName;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class User implements IDUser {
    @ColumnName("u_Id")
    private int Id;

    @ColumnName("u_Firstname")
    private String FirstName;

    @ColumnName("u_LastName")
    private String Lastname;

    @ColumnName("u_Password")
    private String Password;

    @ColumnName("u_Token")
    private String Token;

    // Id gets genereated automaticly
    @ConstructorProperties({"u_Id", "u_FirstName", "u_LastName", "u_Password", "u_Token"})
    public User(int Id, String FirstName, String LastName, String Password, String Token) {
        this.Id = Id;
        this.FirstName = FirstName;
        this.Lastname = LastName;
        this.Password = Password;
        this.Token = Token;
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
        return Lastname;
    }

    @Override
    public void setLastName(String lastName) {
        Lastname = lastName;
    }

    @Override
    public String getPassword() {
        return Password;
    }

    @Override 
    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public String getToken() {
        return Token;
    }

    @Override 
    public void setToken(String token) {
        Token = token;
    }

}
