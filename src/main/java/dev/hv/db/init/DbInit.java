package dev.hv.db.init;

//import dev.hv.db.init.DbConnect;

public class DbInit {
    
    public void dbInit () {

    DbConnect connect = new DbConnect();
    // Pfad von Elias
    connect.getJdbi("jdbc:sqlite:/Users/eliasdellingshausen/desktop/Hausverwaltung.db", "username", "password");
    
    }
    
}
