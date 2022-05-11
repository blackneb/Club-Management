package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteAnnouncement {
    public TextField deleteannouncementid;
    public Button deleteannouncementdelete;

    String id;

    public void Delete_Old_Announcement(ActionEvent actionEvent) {
        id=deleteannouncementid.getText().toString();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/club_management","root","");
            Statement stat=conn.createStatement();
            stat.execute("delete from announcement where ID='"+id+"';");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
