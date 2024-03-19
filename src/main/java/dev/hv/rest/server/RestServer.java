package dev.hv.rest.server;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.List;

import org.jdbi.v3.core.Jdbi;

import dev.hv.db.init.DbConnect;
import dev.hv.db.model.User;
import dev.hv.rest.util.UserResource;

public class RestServer {

    private static ObjectMapper mapper = new ObjectMapper();
    static DbConnect dbConnect = new DbConnect();
    public static final String pack = "dev.hv.rest.modal";
    public static final String url = "http://localhost:8080";
    static final Jdbi jdbi = dbConnect.getJdbi();


    public static void main(final String[] args) throws IOException {
        System.out.println("Start server");
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/", new MyHandler());
        server.createContext("/users", new UserApiHandler());

        server.setExecutor(null);
        server.start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            server.stop(0);
            System.out.println("Server stopped");
        }));
    }

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = "Hello, HttpServer!";
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    public static class UserApiHandler implements HttpHandler {
        private UserResource userResource;


        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String requestMethod = exchange.getRequestMethod();

            switch (requestMethod) {
                case "POST":
                    handlePost(exchange);
                    break;
                case "PUT":
                    handlePut(exchange);
                    break;
                case "GET":
                    handleGet(exchange);
                    break;
                case "DELETE":
                    handleDelete(exchange);
                    break;
                default:
                    sendResponse(exchange, 405, "Method Not Allowed");
            }
        }

        private void handlePost(HttpExchange exchange) throws IOException {
            if (exchange.getRequestMethod().equalsIgnoreCase("POST")) {
                User user = readRequestBody(exchange, User.class);
                userResource.createUser(user);
                sendResponse(exchange, 201, "User created successfully");
            }
        }

        private void handlePut(HttpExchange exchange) throws IOException {
            if (exchange.getRequestMethod().equalsIgnoreCase("PUT")) {
                String path = exchange.getRequestURI().getPath();
                int id = extractIdFromPath(path);
                User user = readRequestBody(exchange, User.class);
                userResource.updateUser(id, user);
                sendResponse(exchange, 200, "User updated successfully");
            }
        }

        private void handleGet(HttpExchange exchange) throws IOException {
            String path = exchange.getRequestURI().getPath();
            if (path.equals("/users")) {
                List<User> users = userResource.getAllUsers();
                sendJsonResponse(exchange, 200, users);
            } else {
                int id = extractIdFromPath(path);
                User user = userResource.getUserById(id);
                if (user != null) {
                    sendJsonResponse(exchange, 200, user);
                } else {
                    sendResponse(exchange, 404, "User not found");
                }
            }
        }

        private void handleDelete(HttpExchange exchange) throws IOException {
            if (exchange.getRequestMethod().equalsIgnoreCase("DELETE")) {
                String path = exchange.getRequestURI().getPath();
                int id = extractIdFromPath(path);
                userResource.deleteUser(id);
                sendResponse(exchange, 200, "User deleted successfully");
            }
        }

        private int extractIdFromPath(String path) {
            String[] parts = path.split("/");
            return Integer.parseInt(parts[parts.length - 1]);
        }

        private <T> T readRequestBody(HttpExchange exchange, Class<T> valueType) throws IOException {
            return mapper.readValue(exchange.getRequestBody(), valueType);
        }

        private void sendResponse(HttpExchange exchange, int statusCode, String message) throws IOException {
            exchange.sendResponseHeaders(statusCode, message.length());
            OutputStream os = exchange.getResponseBody();
            os.write(message.getBytes());
            os.close();
        }

        private void sendJsonResponse(HttpExchange exchange, int statusCode, Object responseObj) throws IOException {
            exchange.getResponseHeaders().set("Content-Type", "application/json");
            exchange.sendResponseHeaders(statusCode, 0);
            OutputStream os = exchange.getResponseBody();
            mapper.writeValue(os, responseObj);
            os.close();
        }
    }
}