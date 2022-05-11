package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.awt.*;
import java.io.IOException;
import java.sql.*;

public class MemberLogin {


    public TextField memberusername;
    public TextField memberpassword;
    public AnchorPane memberrootpane;
    String Tempuser,Temppass;
    String username,password;

    Login_Controller log=new Login_Controller();
    
    @FXML
    public void Member_Login() {
        username=memberusername.getText().toString();
        password=memberpassword.getText().toString();
        System.out.println(username + " " + password);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/club_management","root","");
            Statement stat=conn.createStatement();
            ResultSet rs=stat.executeQuery("select * from members;");
            ResultSetMetaData rss=rs.getMetaData();
            while(rs.next()){
                Tempuser=rs.getString(2);
                Temppass=rs.getString(6);
                System.out.println(Tempuser+ " " + Temppass);
                if(Tempuser.equals(username)&&Temppass.equals(password)){
                    System.out.println("True");
                    log.setMember(true);
                    log.setCurrent_Account(username);
                    AnchorPane pane=FXMLLoader.load(getClass().getResource("/UI/logged_user.fxml"));
                    memberrootpane.getChildren().setAll(pane);
                }
                else{
                    System.out.println("false");
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
