package com.example.examnsc.utils;
//by : Huy
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {

    private static Connection connection;

    public synchronized static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/ExamNSC";
        String username = "root";
        String password = "";
        if (connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(url, username, password);
                System.out.println("Connect success !");
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        }else {
            System.out.println("Use existing connection !");
        }
        return connection;
    }

    public void closeConnection() {
        try {
            connection.close();
            connection = null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            connection = null;
        }
    }
}
