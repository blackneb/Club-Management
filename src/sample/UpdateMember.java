package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateMember {
    String id,password;
    public TextField updateid;
    public TextField updatepassword;

    public void Update_Member_Account(ActionEvent actionEvent) {
        id=updateid.getText().toString();
        password=updatepassword.getText().toString();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/club_management","root","");
            Statement stat=con.createStatement();
            stat.execute("update members set password='"+password+"';");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
