package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class LoggedUser {

    @FXML
    public Label loggedwellcome;
    Login_Controller log=new Login_Controller();

    private void init(){
        loggedwellcome.setText("Hello, Wellcome" + " " + log.getCurrent_Account());
    }

    @FXML
    public void initialize(){
        init();
    }
}
