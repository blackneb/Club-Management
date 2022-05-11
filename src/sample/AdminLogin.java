package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class AdminLogin {

    @FXML
    public TextField useradmin;

    @FXML
    public TextField passadmin;

    @FXML
    public AnchorPane adminrootpane;

    String username, password;

    @FXML
    public void Admin_Login() throws IOException {
        Login_Controller log=new Login_Controller();
        username=useradmin.getText().toString();
        password=passadmin.getText().toString();
        if(username.equals("admin")&&password.equals("admin")){
            log.Current_Account=username;
            log.setAdmin(true);
            System.out.println(log.getAdmin());
            AnchorPane pane= FXMLLoader.load(getClass().getResource("/UI/manage_member.fxml"));
            adminrootpane.getChildren().setAll(pane);
        }
        else{
            System.out.println("false");
        }
    }
}
