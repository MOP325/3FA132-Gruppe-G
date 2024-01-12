package dev.hv.rest.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public interface IRUser {
    
    String getFirstName();

    int getUserID();
     
    String getLastName();

    String getPassword();

    String getToken();

    void setFirstName(String firstName);

    void setUserID(int id);

    void setLastName(String lastName);

    void setPassword(String password);

    void setToken(String token);
}
