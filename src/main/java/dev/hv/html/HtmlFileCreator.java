package dev.hv.html;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class HtmlFileCreator {

    public void createHTML(ArrayList<String> dataList) {

        String filePath = "src/main/resources/testDataHTML.html";

        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            // Writing HTML content to the file
            writer.println("<!DOCTYPE html>");
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<title>Test Solutions</title>");
            writer.println("</head>");
            writer.println("<body>");

            writer.println("<style>");
            writer.println(".my-css-class { font-family: Arial, Helvetica, sans-serif }");
            writer.println("</style>");

            // Loop through the ArrayList and generate HTML for each string
            for (String data : dataList) {
                writer.println("<p class=\"my-css-class\">" + data + "</p>");
            }

            writer.println("</body>");
            writer.println("</html>");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("HTML file created successfully at: " + filePath);
    }

}
