package com.lcaohoanq.formhandling;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Properties;

public class DatabaseConnection {
    public Connection databaseLink;
    public Connection getConnection() {
        String url = EnvUtils.get("DB_URL");
        String databaseUser = EnvUtils.get("DB_USER");
        String databasePassword = EnvUtils.get("DB_PASSWORD");

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
