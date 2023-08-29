package org.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

    public static Connection getConnection() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            String dataBase = "emp_management_sys";
            String URL = "jdbc:mysql://localhost:3306/";
            Connection con = DriverManager.getConnection(URL + dataBase , "root" , "azerty123");

            return con;

        }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
