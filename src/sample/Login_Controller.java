package sample;

public class Login_Controller {
    static Boolean Admin = false;
    static Boolean Member = false;
    static String Current_Account="";
    public void setCurrent_Account(String Current_Account){
        this.Current_Account=Current_Account;
    }
    public String getCurrent_Account(){
        return Current_Account;
    }
    public void setAdmin(Boolean Admin){
        this.Admin=Admin;
    }
    public void setMember(Boolean Member){
        this.Member=Member;
    }
    public boolean getAdmin(){
        return Admin;
    }
    public boolean getMember(){
        return Member;
    }
}
