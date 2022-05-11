package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AdminAnnouncement {

    @FXML
    public AnchorPane adminannouncementrootpane;

    @FXML
    public Button newannouncement;

    @FXML
    public Button announcementmanagementdelete;

    @FXML
    public TableColumn<Announcement_Table, Integer> annid;

    @FXML
    public TableColumn<Announcement_Table, String> anntitle;

    @FXML
    public TableColumn<Announcement_Table, String> anndate;
    @FXML
    public TableView admintable;


    @FXML
    public void initialize(){
        annid.setCellValueFactory(new PropertyValueFactory("ID"));
        anntitle.setCellValueFactory(new PropertyValueFactory("title"));
        anndate.setCellValueFactory(new PropertyValueFactory("date"));
        view_to_database();

    }

    private void view_to_database() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/club_management","root","");
            Statement stmt=con.createStatement();
            String query="SELECT * FROM announcement";
            ResultSet rs = stmt.executeQuery(query);
            Table_Add table=new Table_Add();
            table.setID(0);
            table.setDepartment("cse");
            table.setDob("abc");
            table.setName("anter");
            while(rs.next()){
                System.out.println(rs.getString(2));
                admintable.getItems().addAll(tableadd(rs.getInt(1),rs.getString(2),rs.getString(4)));
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public Announcement_Table tableadd(int ID,String title,String date){
        Announcement_Table annt=new Announcement_Table();
        annt.setID(ID);
        annt.setTitle(title);
        annt.setDate(date);
        return annt;
    }

    public void Create_New_Announcement(ActionEvent actionEvent) throws IOException {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("/UI/new_announcement.fxml"));
        adminannouncementrootpane.getChildren().setAll(pane);
    }

    public void Go_Delete_Announcement(ActionEvent actionEvent) throws IOException {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("/UI/delete_announcement.fxml"));
        adminannouncementrootpane.getChildren().setAll(pane);
    }
}
