package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class NewEvent {
    public TextField neweventtitle;
    public TextField neweventvenue;
    public TextArea neweventcontent;
    public DatePicker neweventdate;
    public Button neweventcreate;

    String title,venue,content,date;

    public void Create_New_Event(ActionEvent actionEvent) {
        title=neweventtitle.getText().toString();
        venue=neweventvenue.getText().toString();
        content=neweventcontent.getText().toString();
        date=neweventdate.getValue().toString();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/club_management","root","");
            Statement stat=conn.createStatement();
            stat.execute("insert into event(title,cont,venue,time) values ('"+title+"','"+content+"','"+venue+"','"+date+"');");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
