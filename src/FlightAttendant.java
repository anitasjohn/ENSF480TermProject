/**
 * File: Address.java
 * Created By: Group 11 (L03 B03)
 * Submission: November 29, 2023
 */



/*  Has to access the database. */
class FlightAttendant  {
    private String name;
    private Email flightAttendantEmail; // _@flightattendant.ca
    private String loginPasscode;

    public FlightAttendant(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}