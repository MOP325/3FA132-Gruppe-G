package dev.hv.rest.model;

public interface IRCustomer {

   String getFirstname();

   Integer getId();

   String getLastname();

   void setFirstname(String firstName);

   void setId(Integer id);

   void setLastname(String lastName);
}
