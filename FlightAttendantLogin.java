package Login;
import Database.AccessDatabase;

/**
 * File: FlightAttendantLogin.java
 * Created by: Group 11 (L03 B03)
 * Submission: November 29, 2023
 */


 public class FlightAttendantLogin implements Check{
    private AccessDatabase database = AccessDatabase.getOnlyInstance();

    public boolean validate(String email, String passcode){
        //Checks if any matches in database of logins
        database.initializeConnection();
        return database.attendantLogin(email, passcode);
    }
}