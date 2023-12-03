package Users;
/**
 * File: Users.java
 * Created By: Group 11 (L03 B03)
 * Submission: November 29, 2023
 */
//implement this into the RegisterGUI class
 import java.util.ArrayList; 

 public class Users {
     private Email userEmail;
     private String loginPassword;
     private String homeAddress;
     private Name name;
  
     // Users ctor for registration 
     /* 
     Users(String firstName, String lastName, String email, String password, String streetAddress, String postalCode, String city, String province, String country){
         this.name = new Name(firstName, lastName);
         this.userEmail = new Email(email);
         this.loginPassword = password;
         this.homeAddress = new Address(streetAddress, postalCode, city, province, country);
         this.tickets = new ArrayList<Ticket>();
         
         database.initializeConnection();
         database.insertNewUser(name, userEmail, loginPassword, homeAddress);
     }
     */

     public Users(String firstName, String lastName, String email, String password, String streetAddress){
        this.name = new Name(firstName, lastName);
        this.userEmail = new Email(email);
        this.loginPassword = password;
        this.homeAddress = streetAddress;
    }

     public String getAddress(){
         return this.homeAddress;
     }
 
     public String getUserEmail(){
         return this.userEmail.getEmail();
     }
 
     public String getUserName(){
         return this.name.getFullName();
     }
     
     public String getPassword(){
        return loginPassword;
     }
 
     public void setNewPassword(String newPass){
         this.loginPassword = newPass;
     }
 }