package Users;
/**
 * File: Name.java
 * Created By: Group 11 (L03 B03)
 * Submission: November 29, 2023
 */

public class Name {
    private String firstName;
    private String lastName;

    public Name(String first, String last){
        this.firstName = first;
        this.lastName = last;
    }

    public void setFirstName(String first){
        this.firstName = first;
    }

    public void setLastName(String last){
        this.lastName = last;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getFullName(){
        return this.firstName + " " + lastName + "\n"; 
    }

    public void printFullName(){
        System.out.println(this.firstName + " " + this.lastName);
    }
}