package dev.hv.consoleClient.ExportFile;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dev.hv.db.dao.CustomerDAOImpl;
import dev.hv.db.dao.ReadingDAOImpl;
import dev.hv.db.dao.UserDAOImpl;
import dev.hv.db.model.Customer;
import dev.hv.db.model.Reading;
import dev.hv.db.model.User;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;


public class ExportHV {
    private static CustomerDAOImpl daoCustomer = new CustomerDAOImpl();
    private static ReadingDAOImpl daoReading = new ReadingDAOImpl();
    private static UserDAOImpl daoUser = new UserDAOImpl();
    
    public static void exportToText(String outputFile, String tableName) {
        switch (tableName) {
            case "customer":
                List<Customer> customers = daoCustomer.findAll();
                String customerText = convertListToText(customers);
                writeToFile(outputFile, customerText);
                break;
            case "user":
                List<User> users = daoUser.findAll();
                String userText = convertListToText(users);
                writeToFile(outputFile, userText);
                break;
            case "reading":
                List<Reading> readings = daoReading.findAll();
                String readingText = convertListToText(readings);
                writeToFile(outputFile, readingText);
                break;
            default:
                break;
        }
    }

    public static void exportToXML(String outputFile, String tableName) {
        switch (tableName) {
            case "customer":
                List<Customer> customers = daoCustomer.findAll();
                String customerXml = convertListToXml(customers);
                writeToFile(outputFile, customerXml);
                break;
            case "user":
                List<User> users = daoUser.findAll();
                String userXml = convertListToXml(users);
                writeToFile(outputFile, userXml);
                break;
            case "reading":
                List<Reading> readings = daoReading.findAll();
                String readingXml = convertListToXml(readings);
                writeToFile(outputFile, readingXml);
                break;
            default:
                break;
        }
    }

    public static void exportToJSON(String outputFile, String tableName) {
        switch (tableName) {
            case "customer":
                List<Customer> customers = daoCustomer.findAll();
                String customerJson = convertListToJson(customers);
                writeToFile(outputFile, customerJson);
                break;
            case "user":
                List<User> users = daoUser.findAll();
                String userJson = convertListToJson(users);
                writeToFile(outputFile, userJson);
                break;
            case "reading":
                List<Reading> readings = daoReading.findAll();
                String readingJson = convertListToJson(readings);
                writeToFile(outputFile, readingJson);
                break;
            default:
                break;
        }
    }
    
    public static void exportToCSV(String outputFile, String tableName) {
        switch (tableName) {
            case "customer":
                List<Customer> customers = daoCustomer.findAll();
                String customerCsv = convertListToCsv(customers);
                writeToFile(outputFile, customerCsv);
                break;
            case "user":
                List<User> users = daoUser.findAll();
                String userCsv = convertListToCsv(users);
                writeToFile(outputFile, userCsv);
                break;
            case "reading":
                List<Reading> readings = daoReading.findAll();
                String readingCsv = convertListToCsv(readings);
                writeToFile(outputFile, readingCsv);
                break;
            default:
                break;
        }
    }


    // Converting Methods
    private static String convertListToText(List<?> list) {
        StringBuilder builder = new StringBuilder();
        for (Object item : list) {
            builder.append(item.toString()).append("\n");
        }
        return builder.toString();
    }

    public static <T> String convertListToJson(List<T> list) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(list);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> String convertListToCsv(List<T> list) {
        try {
            CsvMapper mapper = new CsvMapper();
            CsvSchema schema = mapper.schemaFor(list.get(0).getClass()).withHeader();
            return mapper.writer(schema).writeValueAsString(list);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> String convertListToXml(List<T> list) {
        try {
            XmlMapper mapper = new XmlMapper();
            return mapper.writeValueAsString(list);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void writeToFile(String outputFile, String data) {
        try (FileWriter writer = new FileWriter(outputFile)) {
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
