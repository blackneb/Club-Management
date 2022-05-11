package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class AddMember {

    String fname,lname,dept,pass,fava,dateob;

    @FXML
    public TextField firstname;

    @FXML
    public TextField lastname;

    @FXML
    public TextField department;

    @FXML
    public TextField password;

    @FXML
    public TextField favouriteanimal;

    @FXML
    public DatePicker dob;

    @FXML
    public void Create_Account(){
        fname=firstname.getText().toString();
        lname=lastname.getText().toString();
        dept=department.getText().toString();
        pass=password.getText().toString();
        fava=favouriteanimal.getText().toString();
        dateob=dob.getValue().toString();
        if(fname==null||lname==null||dept==null||pass==null||fava==null||dateob==null){
            JOptionPane.showMessageDialog(null,"Fields can not be empty","Error Found",JOptionPane.INFORMATION_MESSAGE);
        }
        Register();
    }


    public void Register(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/club_management","root","");
            Statement st=con.createStatement();
            st.execute("insert into members(first_name,last_name,department,dob,password,favourite_animal) values ('"+fname+"','"+lname+"','"+dept+"','"+dateob+"','"+pass+"','"+fava+"')");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
