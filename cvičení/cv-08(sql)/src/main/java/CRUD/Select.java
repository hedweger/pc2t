package CRUD;

import connection.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Select {
    public Select() {}
    Connection connection;
    public void getAllGroups() {
        connection = DBConnection.getdbConn();
        String sql = "select * from Groups";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                System.out.println("Group name: " +
                        rs.getString("groupID") +
                        "; member count: " +
                        rs.getString("members"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("");
    }
    public void getAllAlbums() {
        connection = DBConnection.getdbConn();
        String sql = "select * from Album";
        try (PreparedStatement statement = connection.prepareStatement(sql);){
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                System.out.println("Album name: " +
                        rs.getString("albumID") +
                        "; release: " +
                        rs.getInt("releaseY") +
                        "; album genre: " +
                        rs.getString("albumGenre") +
                        "; track amount: " +
                         rs.getInt("trackAmount"));
            }
            System.out.println("");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void getGroupWithAllAlbums() {
        connection = DBConnection.getdbConn();
        String sql = "select Album_Group.groupID, Album_Group.albumID, Album.releaseY, Album.albumGenre " +
                "from Album_Group " +
                "left join Album " +
                "on Album_Group.albumID = Album.albumID";
        try (PreparedStatement statement = connection.prepareStatement(sql);){
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                System.out.println("Group name: " +
                        rs.getString("groupID") +
                        "; album name: " +
                        rs.getString("albumID") +
                        "; track amount: " +
                        rs.getInt("releaseY") +
                        "; album genre: " +
                        rs.getString("albumGenre"));
            }
            System.out.println("");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
