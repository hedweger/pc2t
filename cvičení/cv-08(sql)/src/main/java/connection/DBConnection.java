package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection dbConn;
    private DBConnection() {}
    public static Connection getdbConn() {
        String url = "jdbc:sqlserver://localhost;DatabaseName=Music_Group;encrypt=true;trustServerCertificate=true;";
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
