package CRUD;

import connection.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Delete {
    public Delete() {}
    Connection connection;
    /*
     * metoda ktera odstrani album z tabulky podle jmena
     */
    public void DeleteAlbums(String name) {
        connection = DBConnection.getdbConn();
        String sql1 = "delete from Album_Group where albumID=?";
        try (PreparedStatement statement = connection.prepareStatement(sql1)) {
            statement.setString(1, name);
            statement.executeUpdate();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        String sql2 = "delete from Album where albumID=?";
        try (PreparedStatement statement = connection.prepareStatement(sql2)) {
            statement.setString(1, name);
            statement.executeUpdate();
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
            System.out.println("Succesfully deleted " + name + "");
        }
    /*
     * metoda ktera odstrani hodnotu z tabulky
     * pro odstraneni kapely musi byt nejdriv odstraneny vsechny jeji alba
     */
    public void DeleteGroup(String name) {
        connection = DBConnection.getdbConn();
        String sql = "delete from Groups where groupID=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.executeUpdate();
            System.out.println("Succesfully deleted " + name + "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
