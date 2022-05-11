package sample;

public class Table_Add {
    private int ID;
    private String name;
    private String dob;
    private String department;
    Table_Add(){
        this.ID=0;
        this.name="";
        this.dob="";
        this.department="";
    }
    Table_Add(int ID,String name,String dob,String department){
        this.ID=ID;
        this.name=name;
        this.dob=dob;
        this.department=department;
    }
    public void setID(int ID){
        this.ID=ID;
    }
    public int getID(){
        return ID;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setDob(String dob){
        this.dob=dob;
    }
    public String getDob(){
        return dob;
    }
    public void setDepartment(String department){
        this.department=department;
    }
    public String getDepartment(){
        return department;
    }





}
