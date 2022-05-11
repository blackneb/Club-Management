package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MemberEvent {
    @FXML
    public TableColumn eid;
    @FXML
    public TableColumn etitle;
    @FXML
    public TableColumn econtent;
    @FXML
    public TableColumn evenue;
    @FXML
    public TableColumn etime;
    @FXML
    public TableView eventmembertable;
    @FXML
    public void initialize(){
        eid.setCellValueFactory(new PropertyValueFactory("ID"));
        etitle.setCellValueFactory(new PropertyValueFactory("title"));
        econtent.setCellValueFactory(new PropertyValueFactory("content"));
        evenue.setCellValueFactory(new PropertyValueFactory("venue"));
        etime.setCellValueFactory(new PropertyValueFactory("time"));
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
                eventmembertable.getItems().addAll(tableadd(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public Event_Member_Table tableadd(int ID,String title,String content,String venue,String time){
        Event_Member_Table emt=new Event_Member_Table();
        emt.setID(ID);
        emt.setContent(content);
        emt.setTime(time);
        emt.setTitle(title);
        emt.setVenue(venue);
        return emt;
    }


}
