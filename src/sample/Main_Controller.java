package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.awt.*;
import java.io.IOException;
import java.nio.FloatBuffer;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main_Controller {
    @FXML
    public AnchorPane mainanchorpane;
    Login_Controller log=new Login_Controller();

    private TextField usermember;

    @FXML
    private TextField passmember;

    @FXML
    private BorderPane borderpane;

    @FXML
    public void initialize() throws IOException {
        init();

    }

    public void init() throws IOException {
        AnchorPane pane=FXMLLoader.load(getClass().getResource("/UI/admin_login.fxml"));
        mainanchorpane.getChildren().setAll(pane);
    }

    @FXML
    public void Register(){
        Boolean member=log.getMember();
        Boolean admin=log.getAdmin();
        if(member.equals(false)&&admin.equals(false)){
            System.out.println("Please login");
        }
        else if(member.equals(true)){
            LoadUI("/UI/logged_user");
        }
        else if(admin.equals(true)){
            LoadUI("/UI/manage_member");
        }

    }

    @FXML
    public void Announcement(){
        Boolean member=log.getMember();
        Boolean admin=log.getAdmin();
        if(member.equals(false)&&admin.equals(false)){
            System.out.println("Please login");
        }
        else if(member.equals(true)){
            LoadUI("/UI/member_announcement");
        }
        else if(admin.equals(true)){
            LoadUI("/UI/admin_announcement");
        }
    }

    @FXML
    public void Event(){
        Boolean member=log.getMember();
        Boolean admin=log.getAdmin();
        if(member.equals(false)&&admin.equals(false)){
            System.out.println("Please login");
        }
        else if(member.equals(true)){
            LoadUI("/UI/member_event");
        }
        else if(admin.equals(true)){
            LoadUI("/UI/admin_event");
        }
    }

    @FXML
    public void Go_To_Admin_Panel(){
        Boolean member=log.getMember();
        Boolean admin=log.getAdmin();
        System.out.println(log.getMember());
        if(member.equals(true)){
            System.out.println("Please logout member account");
        }
        else if(admin.equals(true)){
            LoadUI("/UI/manage_member");
        }
        else{
            LoadUI("/UI/admin_login");
        }
    }

    @FXML
    public void Go_To_Member_Panel(){
        Boolean member=log.getMember();
        Boolean admin=log.getAdmin();
        System.out.println(log.getAdmin());
        if(admin.equals(true)){
            System.out.println("please logout admin account");
        }
        else if(member.equals(true)){
            LoadUI("/UI/logged_user");
        }
        else{
            LoadUI("/UI/member_login");
        }
    }

    public void LoadUI(String ui){
        Parent root;
        try{
            root=FXMLLoader.load(getClass().getResource(ui+".fxml"));
            borderpane.setCenter(root);
        }
        catch (IOException ex){
            Logger.getLogger(Main_Controller.class.getName()).log(Level.SEVERE,null,ex);
        }


    }

    public void Log_out() {
        log.setMember(false);
        log.setAdmin(false);
        System.out.println(log.getMember());
        System.out.println(log.getAdmin());
        log.setCurrent_Account("");
        LoadUI("/UI/admin_login");
    }
}
