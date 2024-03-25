package dev.hv.consoleClient.ImportFile;

import dev.hv.db.dao.CustomerDAOImpl;
import dev.hv.db.dao.ReadingDAOImpl;
import dev.hv.db.dao.UserDAOImpl;
import dev.hv.db.model.Customer;
import dev.hv.db.model.Reading;
import dev.hv.db.model.User;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ImportCSV {

    private CustomerDAOImpl customerDAO;
    private UserDAOImpl userDAO;
    private ReadingDAOImpl readingDAO;

    public ImportCSV() {
        customerDAO = new CustomerDAOImpl();
        userDAO = new UserDAOImpl();
        readingDAO = new ReadingDAOImpl();
    }

    public void pickTable(String outputFile, String tableName) {
        switch (tableName) {
            case "customer":
                importCustomersFromCSV(outputFile);
                break;
            case "user":
                importUsersFromCSV(outputFile);
                break;
            case "reading":
                importReadingsFromCSV(outputFile);
                break;
            default:
                System.out.println("Wrong Table name use -h for help");
                break;
        }
    }

    private void importCustomersFromCSV(String filePath) {
        List<Customer> customers = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int customerId = Integer.parseInt(data[0]);
                String firstName = data[1];
                String lastName = data[2];
                customers.add(new Customer(customerId, firstName, lastName));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Customer customer : customers) {
            customerDAO.insert(customer);
        }
    }

    private void importUsersFromCSV(String filePath) {
        List<User> users = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int userId = Integer.parseInt(data[0]);
                String firstName = data[1];
                String lastName = data[2];
                String password = data[3];
                String token = data[4];
                users.add(new User(userId, firstName, lastName, password, token));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        for (User user : users) {
            userDAO.insert(user);
        }
    }
    
    private void importReadingsFromCSV(String filePath) {
        List<Reading> readings = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int readingId = Integer.parseInt(data[0]);
                int cId = Integer.parseInt(data[1]);
                int meterId = Integer.parseInt(data[2]);
                int dateOfReading = Integer.parseInt(data[3]);
                String kindOfMeter = data[4];
                double meterCount = Double.parseDouble(data[5]);
                int substitute = Integer.parseInt(data[6]);
                String comment = data[7];
                readings.add(new Reading(readingId, cId, meterId, dateOfReading, kindOfMeter, meterCount, substitute, comment));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        for (Reading reading : readings) {
            readingDAO.insert(reading);
        }
    }
}
