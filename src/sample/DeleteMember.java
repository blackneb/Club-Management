package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteMember {
    String id;
    public TextField deleteid;

    public void Delete_Member_Account(ActionEvent actionEvent) {
        id=deleteid.getText().toString();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/club_management","root","");
            Statement stat=conn.createStatement();
            stat.execute("delete from members where ID='"+id+"';");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
