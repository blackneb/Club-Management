package sample;

public class Announcement_Member_Table {
    int ID;
    String title;
    String content;
    String date;
    Announcement_Member_Table(int ID, String title, String content, String date){
        this.ID=ID;
        this.title=title;
        this.content=content;
        this.date=date;
    }

    public Announcement_Member_Table() {
        this.ID=0;
        this.title="";
        this.content="";
        this.date="";
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
