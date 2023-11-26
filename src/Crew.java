/**
 * File: Crew.java
 * Created By: Group 11 (L03 B03)
 * Submission: November 29, 2023
 */

import java.util.ArrayList;

public class Crew {
    private ArrayList<Name> pilots;
    private ArrayList<FlightAttendant> flightAttendants;
    private Flight workOnFlight; // which flight this crew is working for 

    public Crew(){
        this.pilots = new ArrayList<Name>();
        this.flightAttendants = new ArrayList<FlightAttendant>();
    }

    public Crew(ArrayList<Name> pilots, ArrayList<FlightAttendant> flightAttendants) {
        this.pilots = pilots;
        this.flightAttendants = flightAttendants;
    }

    public ArrayList<Name> getPilots() {
        return pilots;
    }

    public void setPilots(ArrayList<Name> pilots) {
        this.pilots = pilots;
    }

    public ArrayList<FlightAttendant> getFlightAttendants() {
        return flightAttendants;
    }

    public void setFlightAttendants(ArrayList<FlightAttendant> flightAttendants) {
        this.flightAttendants = flightAttendants;
    }

    public void addCrewMember(Name pilot){
        if(this.pilots.size() < 2){
            this.pilots.add(pilot);
        }
        else{
            System.err.println("Reached max pilots on crew..");
        }
    }

    public void addCrewMember(FlightAttendant flightAttendant){
        this.flightAttendants.add(flightAttendant);
    }

    public void setWorksOnFlight(Flight flight){
        this.workOnFlight = flight;
    }

    public Flight getCrewFlight(){
        return this.workOnFlight;
    }

}