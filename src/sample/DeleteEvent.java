package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteEvent {
    public TextField deleteeventid;
    public Button deleteeventdelete;
    String id;

    public void Delete_Old_Event(ActionEvent actionEvent) {
        id=deleteeventid.getText().toString();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/club_management","root","");
            Statement stat=conn.createStatement();
            stat.execute("delete from event where ID='"+id+"';");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
