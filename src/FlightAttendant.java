/**
 * File: FlightAttendant.java
 * Created By: Group 11 (L03 B03)
 * Submission: November 29, 2023
 */



/*  Has to access the database. */
public class FlightAttendant extends Crew{
    private Name name;
    private Email flightAttendantEmail; // _@flightattendant.ca
    private int loginPasscode;

    public FlightAttendant(Name name, Email email, int pass) {
        this.name = name;
        this.flightAttendantEmail = email;
        this.loginPasscode = pass;
    }

    public Name getName() {
        return this.name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Email getFlightAttendantEmail(){
        return this.flightAttendantEmail;
    }

    public int getFlightAttendantPasscode(){
        return this.loginPasscode;
    }

    public void searchPassengers(){
        // 1. insert flight number 
        // 2. search passenger in flight 
        // 3. view passenger ticket details? 
    }

}