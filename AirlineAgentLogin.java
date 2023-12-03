package Login;
import Database.AccessDatabase;
/**
 * File: AirlineAgentLogin.java
 * Created by: Group 11 (L03 B03)
 * Submission: November 29, 2023
 */

public class AirlineAgentLogin implements Check{
    private AccessDatabase database = AccessDatabase.getOnlyInstance();

    public boolean validate(String email, String passcode){
        //Checks if any matches in database of logins
        database.initializeConnection();
        // need to change to database.attendantLogin()
        return database.agentLogin(email, passcode);
    }
}