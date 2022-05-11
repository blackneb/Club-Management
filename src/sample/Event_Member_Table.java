package sample;

public class Event_Member_Table {
    int ID;
    String title;
    String content;
    String venue;
    String time;
    Event_Member_Table(){
        this.ID=0;
        this.title="";
        this.content="";
        this.venue="";
        this.time="";
    }
    Event_Member_Table(int ID,String title,String content,String venue,String time){
        this.ID=ID;
        this.content=content;
        this.title=title;
        this.venue=venue;
        this.title=time;
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

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
