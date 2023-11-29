package dev.hv.db.model;

// The interface defines methods for structuring customer data in the database.
public interface IDCustomer {
   int getId();

   void setId(int Id);

   String getFirstName();

   void setFirstName(String FirstName);

   String getLastName();

   void setLastName(String LastName);
}
