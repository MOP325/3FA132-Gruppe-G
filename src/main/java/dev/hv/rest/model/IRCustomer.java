package dev.hv.rest.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public interface IRCustomer {
    
    String getFirstName();

    int getCustomerID();

    String getLastName();

    void setFirstName(String firstName);

    void setCustomerID(int id);

    void setLastName(String lastName);
}