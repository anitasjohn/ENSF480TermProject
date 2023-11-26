/**
 * File: Aircraft.java
 * Created By: Group 11 (L03 B03)
 * Submission: November 29, 2023
 */
import java.util.ArrayList;
public class Aircraft {
    // Attributes
    private Flight flight;
    private Crew flightCrew;
    private Seatmap seatmap;
    private boolean inAir; // true if, aircraft has an appointed flight, for system admin

    // Constructor
    public Aircraft(Flight flight, Crew flightCrew, ArrayList<Seat>business, ArrayList<Seat> comfort, ArrayList<Seat> regular, boolean state) {
        this.flight = flight;
        this.flightCrew = flightCrew;
        this.seatmap = new Seatmap(business, comfort, regular);
        this.inAir = state;
    }

    // Getter and Setter methods for Flight
    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    // Getter and Setter methods for Flight Crew
    public Crew getFlightCrew() {
        return flightCrew;
    }

    public void setFlightCrew(Crew flightCrew) {
        this.flightCrew = flightCrew;
    }

    public Seatmap getSeatMap(){
        return this.seatmap;   
    } // no setters for seatmap, as seats in airplanes cannot be rearranged
    
    public boolean getAircraftActivity(){
        return this.inAir;
    }
}
