package com.lcaohoanq.formhandling;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Properties;

public class DatabaseConnection {
    public Connection databaseLink;
    private Properties loadEnv() {
        Dotenv dotenv = Dotenv.configure().load();
        Properties properties = new Properties();
        properties.setProperty("DB_URL", dotenv.get("DB_URL"));
        properties.setProperty("DB_USER", dotenv.get("DB_USER"));
        properties.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
        return properties;
    }

    public Connection getConnection() {
        Properties properties = loadEnv();

        String url = properties.getProperty("DB_URL");
        String databaseUser = properties.getProperty("DB_USER");
        String databasePassword = properties.getProperty("DB_PASSWORD");

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
            System.out.println("Connect to database successfully");
        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }

        return databaseLink;
    }
}
