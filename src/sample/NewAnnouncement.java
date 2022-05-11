package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class NewAnnouncement{

    public TextArea newannouncementcontent;
    public TextField newannouncementtitle;
    public TextField newannouncementdate;
    public Button newannouncementcreate;

    String title,content,date;

    public void Create_New_Announcement(ActionEvent actionEvent) {
        title=newannouncementtitle.getText().toString();
        content=newannouncementcontent.getText().toString();
        date=newannouncementdate.getText().toString();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/club_management","root","");
            Statement stat=conn.createStatement();
            stat.execute("insert into announcement(title,cont,date) values ('"+title+"','"+content+"','"+date+"');");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
