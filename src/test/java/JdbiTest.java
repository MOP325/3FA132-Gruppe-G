// import org.jdbi.v3.core.Jdbi;

// import dev.hv.db.init.DbConnect;

// public class JdbiTest {
//     public static void main(String[] args) {
//         // Create an instance of your DbConnect class
//         DbConnect dbConnect = new DbConnect();

//         // Get a Jdbi instance for database connection
//         Jdbi jdbi = dbConnect.getJdbi();

//         // Test the connection by opening a handle and printing a message
//         try {
//             jdbi.useHandle(handle -> {
//                 System.out.println("Connected to the database successfully!");
//             });
//         } catch (Exception e) {
//             e.printStackTrace();
//             System.err.println("Failed to connect to the database.");
//         }
//     }
// } 
