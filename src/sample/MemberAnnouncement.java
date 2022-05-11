package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MemberAnnouncement {

    @FXML
    public TableColumn manid;
    @FXML
    public TableColumn mantitle;
    @FXML
    public TableColumn mancontent;
    @FXML
    public TableColumn mandate;
    @FXML
    public TableView memberanntable;

    @FXML
    public void initialize(){
        manid.setCellValueFactory(new PropertyValueFactory("ID"));
        mantitle.setCellValueFactory(new PropertyValueFactory("title"));
        mancontent.setCellValueFactory(new PropertyValueFactory("content"));
        mandate.setCellValueFactory(new PropertyValueFactory("date"));
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
                memberanntable.getItems().addAll(tableadd(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public Announcement_Member_Table tableadd(int ID,String title, String content,String date){
        Announcement_Member_Table amt=new Announcement_Member_Table();
        amt.setID(ID);
        amt.setTitle(title);
        amt.setContent(content);
        amt.setDate(date);
        return amt;
    }

}
