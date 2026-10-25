package com.example.cctvbackendservice.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

@Component
public class JdbcConnection {

    // Database URL
    private static final String URL =
            "jdbc:postgresql://localhost:5433/cctv_database";

    // Database Username
    private static final String USERNAME = "postgres";

    // Database Password
    private static final String PASSWORD = "12345";

    // Method to get connection
    public static Connection getConnection() {

        Connection connection = null;

        try {

            // Load Driver
            Class.forName("org.postgresql.Driver");

            // Create Connection
            connection = DriverManager.getConnection(
                    URL,
                    USERNAME,
                    PASSWORD
            );

            System.out.println("Database Connected Successfully");

        } catch (ClassNotFoundException e) {

            System.out.println("Driver Not Found");
            e.printStackTrace();

        } catch (SQLException e) {

            System.out.println("Database Connection Failed");
            e.printStackTrace();
        }

        return connection;
    }

//    // Main Method for Testing
//    public static void main(String[] args) {
//
//        Connection connection = getConnection();
//
//        if (connection != null) {
//            System.out.println("Connection Object Created");
//        }
//    }
}