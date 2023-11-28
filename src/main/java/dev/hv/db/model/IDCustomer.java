package dev.hv.db.model;

// Das Interface IDCustomer definiert Methoden zur Strukturierung von Kundendaten in der Datenbank.
public interface IDCustomer {
   int getId();

   void setId(int Id);

   String getFirstName();

   void setFirstName(String FirstName);

   String getLastName();

   void setLastName(String LastName);
}
