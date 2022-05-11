package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManageMember {

    @FXML
    private TableColumn<Table_Add, Integer> idcol;
    @FXML
    private TableColumn<Table_Add, String> namecol;
    @FXML
    private TableColumn<Table_Add, String > dobcol;
    @FXML
    private TableColumn<Table_Add, String> departmentcol;

    @FXML
    private TableView mainTable;

    @FXML
    private AnchorPane rootpane;

    @FXML
    public void initialize(){
        idcol.setCellValueFactory(new PropertyValueFactory("ID"));
        namecol.setCellValueFactory(new PropertyValueFactory("name"));
        dobcol.setCellValueFactory(new PropertyValueFactory("dob"));
        departmentcol.setCellValueFactory(new PropertyValueFactory("department"));
        view_to_database();

    }
    @FXML
    public void Register_Member() throws IOException {
      AnchorPane pane=FXMLLoader.load(getClass().getResource("/UI/add_member.fxml"));
      rootpane.getChildren().setAll(pane);
    }

    public void view_to_database(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/club_management","root","");
            Statement stmt=con.createStatement();
            String query="SELECT * FROM members";
            ResultSet rs = stmt.executeQuery(query);
          while(rs.next()){
                System.out.println(rs.getString(2));
                mainTable.getItems().addAll(tableadd(rs.getInt(1),rs.getString(2),rs.getString(5),rs.getString(4)));
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Table_Add tableadd(int ID,String name,String dob,String department){
        Table_Add tadd=new Table_Add();
        tadd.setID(ID);
        tadd.setName(name);
        tadd.setDob(dob);
        tadd.setDepartment(department);
        return tadd;
    }

    public void Update_Member(ActionEvent actionEvent) throws IOException {
        AnchorPane pane=FXMLLoader.load(getClass().getResource("/UI/update_member.fxml"));
        rootpane.getChildren().setAll(pane);
    }

    public void Delete_Member(ActionEvent actionEvent) throws IOException {
        AnchorPane pane=FXMLLoader.load(getClass().getResource("/UI/delete_member.fxml"));
        rootpane.getChildren().setAll(pane);
    }
}
