package CRUD;

import connection.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {
    public Update() {}
    public void ChangeReleaseYear(int year, String album) {
        Connection connection = DBConnection.getdbConn();
        String sql = "update Album set releaseY=? where albumID=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, year);
            statement.setString(2, album);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Updated!");
    }
}
