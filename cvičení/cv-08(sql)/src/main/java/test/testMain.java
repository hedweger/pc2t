package test;

import CRUD.Delete;
import CRUD.Insert;
import CRUD.Select;
import CRUD.Update;

public class testMain {
    public static void main(String[] args) {
        Insert testInsert = new Insert();
        Select testSelect = new Select();
        Delete testDelete = new Delete();
        Update testUpdate = new Update();
        testDelete.DeleteAlbums("The Wall");
        testDelete.DeleteGroup("Pink Floyd");
        testInsert.InsertNewGroup("Pink Floyd", 5);
        testInsert.InsertNewAlbum("The Wall", "Rock",  2000, 26);
        testInsert.ConnectAlbumToGroup("Pink Floyd", "The Wall");
        testSelect.getAllGroups();
        testSelect.getAllAlbums();
        testUpdate.ChangeReleaseYear(1979, "The Wall");
        testSelect.getAllAlbums();
        testSelect.getGroupWithAllAlbums();

    }
}
