package CRUD;

import connection.DBConnection;
import connection.DBConnection;

import javax.sound.midi.Track;
import java.sql.*;
/*
* inserts a group/album into the respective table
*
 */
public class Insert {
    public Insert() {}
    public void InsertNewAlbum(String Album_name, String Album_genre, int release, int TrackAmount) {
        Connection connection = DBConnection.getdbConn();
        String sql = "insert into Album(AlbumID, albumGenre, releaseY, trackAmount) values(?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, Album_name);
            statement.setString(2, Album_genre);
            statement.setInt(3, release);
            statement.setInt(4, TrackAmount);
            statement.executeUpdate();
            System.out.println("Succesfully inserted " + Album_name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void InsertNewGroup(String Group_name, int members) {
        Connection connection = DBConnection.getdbConn();
        String sql = "insert into Groups(groupID, members) values(?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, Group_name);
            statement.setInt(2, members);
            statement.executeUpdate();
            System.out.println("Succesfully inserted " + Group_name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /*
    * metoda je slouzi k prirazeni alba ke kapele
     */
    public void ConnectAlbumToGroup(String group, String album) {
        Connection connection = DBConnection.getdbConn();
        String sql = "insert into Album_Group (groupID, albumID) values (?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, group);
            statement.setString(2, album);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
