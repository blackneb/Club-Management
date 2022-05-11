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

public class AdminEvent {
    @FXML
    public TableView eventtable;
    @FXML
    public TableColumn<Event_Table, Integer> eventid;
    @FXML
    public TableColumn<Event_Table, String> titleid;
    @FXML
    public TableColumn<Event_Table, String > venueid;
    @FXML
    public TableColumn<Event_Table, String> timeid;
    @FXML
    private AnchorPane admineventrootpane;
    @FXML
    public Button newevent;
    @FXML
    public Button deleteevent;

    @FXML
    public void initialize(){
        eventid.setCellValueFactory(new PropertyValueFactory("ID"));
        titleid.setCellValueFactory(new PropertyValueFactory("title"));
        venueid.setCellValueFactory(new PropertyValueFactory("venue"));
        timeid.setCellValueFactory(new PropertyValueFactory("time"));
        view_to_database();

    }

    private void view_to_database() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/club_management","root","");
            Statement stmt=con.createStatement();
            String query="SELECT * FROM event";
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                System.out.println(rs.getString(2));
                eventtable.getItems().addAll(tableadd(rs.getInt(1),rs.getString(2),rs.getString(5),rs.getString(4)));
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public Event_Table tableadd(int ID, String title,String venue,String time){
        Event_Table evet=new Event_Table();
        evet.setID(ID);
        evet.setTitle(title);
        evet.setVenue(venue);
        evet.setTime(time);
        return evet;
    }

    public void Create_New_Event(ActionEvent actionEvent) throws IOException {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("/UI/new_event.fxml"));
        admineventrootpane.getChildren().setAll(pane);
    }

    public void Delete_Events(ActionEvent actionEvent) throws IOException {
        AnchorPane pane=FXMLLoader.load(getClass().getResource("/UI/delete_event.fxml"));
        admineventrootpane.getChildren().setAll(pane);
    }
}
