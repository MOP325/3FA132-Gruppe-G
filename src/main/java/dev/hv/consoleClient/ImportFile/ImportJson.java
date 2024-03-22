package dev.hv.consoleClient.ImportFile;

import dev.hv.db.dao.CustomerDAOImpl;
import dev.hv.db.dao.ReadingDAOImpl;
import dev.hv.db.dao.UserDAOImpl;
import dev.hv.db.model.Customer;
import dev.hv.db.model.Reading;
import dev.hv.db.model.User;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import java.io.File;
import java.util.List;


public class ImportJson {

    private CustomerDAOImpl customerDAO;
    private UserDAOImpl userDAO;
    private ReadingDAOImpl readingDAO;

    public ImportJson() {
        customerDAO = new CustomerDAOImpl();
        userDAO = new UserDAOImpl();
        readingDAO = new ReadingDAOImpl();
    }

    public void pickTable(String outputFile, String tableName) {
        switch (tableName) {
            case "customer":
                importCustomerFromJson(outputFile);
                break;
            case "user":
                importUserFromXML(outputFile);
                break;
            case "reading":
                importReadingFromXML(outputFile);
                break;
            default:
                System.out.println("Wrong Table name use -h for help");
                break;
        }
    }

    

    public void importCustomerFromJson(String jsonFile) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File(jsonFile);
            CollectionType listType = mapper.getTypeFactory().constructCollectionType(List.class, Customer.class);
            List<Customer> customers = mapper.readValue(file, listType);

            for (Customer customer : customers) {
                customerDAO.insert(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void importUserFromXML(String jsonFile) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File(jsonFile);
            CollectionType listType = mapper.getTypeFactory().constructCollectionType(List.class, User.class);
            List<User> users = mapper.readValue(file, listType);

            for (User user : users) {
                userDAO.insert(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void importReadingFromXML(String jsonFile) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File(jsonFile);
            CollectionType listType = mapper.getTypeFactory().constructCollectionType(List.class, Reading.class);
            List<Reading> readings = mapper.readValue(file, listType);

            for (Reading reading : readings) {
                readingDAO.insert(reading);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
