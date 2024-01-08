package dev.hv.rest.model;

public interface IRUser {

   String getFirstname();

   Integer getId();

   String getLastname();

   String getPassword();

   String getToken();

   void setFirstname(String firstName);

   void setId(Integer id);

   void setLastname(String lastName);

   void setPassword(String password);

   void setToken(String token);
}
