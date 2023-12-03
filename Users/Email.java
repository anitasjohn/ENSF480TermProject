package Users;
/**
 * File: Email.java
 * Created By: Group 11 (L03 B03)
 * Submission: November 29, 2023
 */


 public class Email{
    private String emailAddress;

    public Email(String email){
        this.emailAddress = email;
    }

    public String getEmail(){
        return this.emailAddress;
    }

    public void setEmail(String emailString){
        this.emailAddress = emailString;
    }

}