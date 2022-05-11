package sample;

public class Announcement_Table {
    private int ID;
    private String title;
    private String date;
    Announcement_Table(){
        this.ID=0;
        this.date="";
        this.title="";
    }
    Announcement_Table(int ID,String title,String date){
        this.ID=ID;
        this.date=date;
        this.title=title;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
