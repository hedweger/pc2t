package com.company.dbconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
    private static Connection dbConn;
    private DBConn() {}
    public static Connection getDbConn() {
        String url = "jdbc:sqlserver://localhost;DatabaseName=Student;encrypt=true;trustServerCertificate=true;";
        String user = "sa";
        String password = "password123";
        if(dbConn == null) {
            try {
                dbConn = DriverManager.getConnection(url,
                        user,
                        password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return dbConn;
    }
    public static void closeConnection() {
        try {
            dbConn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
