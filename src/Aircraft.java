/**
 * File: Aircraft.java
 * Created By: Group 11 (L03 B03)
 * Submission: November 29, 2023
 */

public class Aircraft {
    // Attributes
    private Flight flight;
    private Crew flightCrew;
    private Seatmap seatmap;
    private boolean inAir; // true if, aircraft has an appointed flight

    // Constructor
    public Aircraft(Flight flight, Crew flightCrew, Seatmap seatm, boolean state) {
        this.flight = flight;
        this.flightCrew = flightCrew;
        this.seatmap = seatm;
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
