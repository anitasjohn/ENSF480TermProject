package Users;
/**
 * File: FlightAttendant.java
 * Created By: Group 11 (L03 B03)
 * Submission: November 29, 2023
 */
/*  Has to access the database. */
public class AirlineAgent  {
    private int airlineNumber;
    private Name name;
    private Email airlineEmail; 
    private String loginPass;

    public AirlineAgent(int aN, Name name, Email email, String pass) {
        this.airlineNumber = aN;
        this.name = name;
        this.airlineEmail = email;
        this.loginPass = pass;
    }

    public Name getName() {
        return this.name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Email getAirlineEmail(){
        return this.airlineEmail;
    }

    public String getAirlinePassword(){
        return this.loginPass;
    }
}