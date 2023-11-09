package dev.hv.db.model;

public interface IDUser {
   int getId();

   void setId(int Id);

   String getFirstName();

   void setFirstName(String FirstName);

   String getLastName();

   void setLastName(String LastName);

   String getPassword();

   void setPassword(String Password);

   String getToken();

   void setToken(String Token);
}
