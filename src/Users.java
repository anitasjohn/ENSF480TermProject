/**
 * File: Users.java
 * Created By: Group 11 (L03 B03)
 * Submission: November 29, 2023
 */

import java.util.ArrayList; 

public class Users {
    private ArrayList<Ticket> tickets;
    private Email userEmail;
    private String loginPassword;
    private Address homeAddress;
    private Name name;

    // replace args with your own
    private AccessDatabase database = new AccessDatabase();

    // Users ctor for registration 
    Users(String firstName, String lastName, String email, String password, String streetAddress, String postalCode, String city, String province, String country){
        this.name = new Name(firstName, lastName);
        this.userEmail = new Email(email);
        this.loginPassword = password;
        this.homeAddress = new Address(streetAddress, postalCode, city, province, country);
        this.tickets = new ArrayList<Ticket>();
        
        database.initializeConnection();
        database.insertNewUser(name, userEmail, loginPassword, homeAddress);
    }

    public Address getAddress(){
        return this.homeAddress;
    }

    public Email getUserEmail(){
        return this.userEmail;
    }

    public String getUserName(){
        return this.name.getFullName();
    }

    public void setNewPassword(String newPass){
        this.loginPassword = newPass;
    }

}
