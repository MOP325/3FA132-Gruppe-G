package dev.hv.consoleClient.ImportFile;

import dev.hv.db.dao.CustomerDAOImpl;
import dev.hv.db.dao.ReadingDAOImpl;
import dev.hv.db.dao.UserDAOImpl;
import dev.hv.db.model.Customer;
import dev.hv.db.model.Reading;
import dev.hv.db.model.User;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Document;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class ImportXML {

    private CustomerDAOImpl customerDAO;
    private UserDAOImpl userDAO;
    private ReadingDAOImpl readingDAO;

    public ImportXML() {
        customerDAO = new CustomerDAOImpl();
        userDAO = new UserDAOImpl();
        readingDAO = new ReadingDAOImpl();
    }

    public void pickTable(String outputFile, String tableName) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(outputFile);
            doc.getDocumentElement().normalize();

            switch (tableName) {
                case "customer":
                    importCustomerFromXML(doc);
                    break;
                case "user":
                    importUserFromXML(doc);
                    break;
                case "reading":
                    importReadingFromXML(doc);
                    break;
                default:
                    System.out.println("Wrong Table name use -h for help");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void importCustomerFromXML(Document doc) {
        NodeList customerNodes = doc.getElementsByTagName("customer");
    
        List<Customer> customers = new ArrayList<>();
        for (int i = 0; i < customerNodes.getLength(); i++) {
            Node node = customerNodes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                int customerId = Integer.parseInt(element.getAttribute("id"));
                String firstName = element.getElementsByTagName("firstName").item(0).getTextContent();
                String lastName = element.getElementsByTagName("lastName").item(0).getTextContent();
                customers.add(new Customer(customerId, firstName, lastName));
            }
        }
    
        for (Customer customer : customers) {
            customerDAO.insert(customer);
        }
    }

    private void importUserFromXML(Document doc) {
        NodeList userNodes = doc.getElementsByTagName("user");

        List<User> users = new ArrayList<>();
        for (int i = 0; i < userNodes.getLength(); i++) {
            Node node = userNodes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                int userId = Integer.parseInt(element.getAttribute("id"));
                String firstName = element.getElementsByTagName("firstName").item(0).getTextContent();
                String lastName = element.getElementsByTagName("lastName").item(0).getTextContent();
                String password = element.getElementsByTagName("password").item(0).getTextContent();
                String token = element.getElementsByTagName("token").item(0).getTextContent();
                users.add(new User(userId, firstName, lastName, password, token));
            }
        }

        for (User user : users) {
            userDAO.insert(user);
        }
    }

    private void importReadingFromXML(Document doc) {
        NodeList readingNodes = doc.getElementsByTagName("reading");

        List<Reading> readings = new ArrayList<>();
        for (int i = 0; i < readingNodes.getLength(); i++) {
            Node node = readingNodes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                int readingId = Integer.parseInt(element.getAttribute("id"));
                int cId = Integer.parseInt(element.getElementsByTagName("cId").item(0).getTextContent());
                int meterId = Integer.parseInt(element.getElementsByTagName("meterId").item(0).getTextContent());
                int dateOfReading = Integer.parseInt(element.getElementsByTagName("dateOfReading").item(0).getTextContent());
                String kindOfMeter = element.getElementsByTagName("kindOfMeter").item(0).getTextContent();
                double meterCount = Double.parseDouble(element.getElementsByTagName("meterCount").item(0).getTextContent());
                int substitute = Integer.parseInt(element.getElementsByTagName("substitute").item(0).getTextContent());
                String comment = element.getElementsByTagName("comment").item(0).getTextContent();
                readings.add(new Reading(readingId, cId, meterId, dateOfReading, kindOfMeter, meterCount, substitute, comment));
            }
        }

        for (Reading reading : readings) {
            readingDAO.insert(reading);
        }
    }
}
