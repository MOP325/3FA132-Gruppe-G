package dev.hv.db.init;

import org.jdbi.v3.core.Jdbi;

// Ein Interface welches eine Schnittstelle für den Datenbankzugriff definiert
public interface IDbConnect {

   /** create all tables */
   void createAllTables();

   /** returns the singelton of the jdbi object */
   Jdbi getJdbi();

   /** returns the singelton of the jdbi object with initialization */
   Jdbi getJdbi(String uri, String user, String pw);

   /** remove all tables */
   void removeAllTables();

}
