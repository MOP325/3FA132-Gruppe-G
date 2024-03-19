package dev.hv.consoleClient;

import java.sql.*;

public class ExportHV {
    public static void exportToText(String outputFile, String tableName) {

        switch (tableName) {
            case "customer":
                
                break;
            case "reading":
              
                break;
            case "user":
                
                break;
            default:
                break;
        }




        System.out.println("FileTest" + outputFile);
        System.out.println("TableNameTest" + tableName);
    }

    public static void exportToXML(String outputFile, String tableName) {
        switch (tableName) {
            case "customer":
                
                break;
            case "reading":
              
                break;
            case "user":
                
                break;
            default:
                break;
        }
    }

    public static void exportToJSON(String outputFile, String tableName) {
        String url = "jdbc:sqlite:target/Hausverwaltung.db";
        String user = "username";
        String password = "password";
        
        String query = "SELECT * FROM " + tableName;
        
        try(Connection connection = DriverManager.getConnection(url, user, password)) {
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {
                while (resultSet.next()) {
 
                    int customerId = resultSet.getInt("customerId");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    System.out.println("Customer ID: " + customerId + ", Name: " + name + ", Email: " + email);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    



        // switch (tableName) {
        //     case "customer":
                
        //         break;
        //     case "reading":
              
        //         break;
        //     case "user":
                
        //         break;
        //     default:
        //         break;
        // }
    }

    public static void exportToCSV(String outputFile, String tableName) {
        switch (tableName) {
            case "customer":
                
                break;
            case "reading":
              
                break;
            case "user":
                
                break;
            default:
                break;
        }
    }
}
