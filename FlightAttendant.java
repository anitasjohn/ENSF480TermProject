package Users;
/**
 * File: FlightAttendant.java
 * Created By: Group 11 (L03 B03)
 * Submission: November 29, 2023
 */
/*  Has to access the database. */
public class FlightAttendant  {
    private int flightNumber;
    private Name name;
    private Email flightAttendantEmail; // _@flightattendant.ca
    private String loginPasscode;

    public FlightAttendant(int fN, Name name, Email email, String pass) {
        this.flightNumber = fN;
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

    public String getFlightAttendantPasscode(){
        return this.loginPasscode;
    }
}