package dev.hv.rest.server;

import org.jdbi.v3.core.Jdbi;


import dev.hv.db.init.DbConnect;

public class RestServer {

        static DbConnect db = new DbConnect();

        public static final String pack = "dev.hv.rest.model";
        public static final String url = "http://localhost:8080/";
        public static Jdbi jdbi = db.getJdbi();

    public static void main(final String[] args) {
        System.out.println("Start server");
        DbConnect db = new DbConnect();
    }
}