/**
 * File: Address.java
 * Created By: Group 11 (L03 B03)
 * Submission: November 29, 2023
 */



/*  Has to access the database. */
class FlightAttendant  {
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
}