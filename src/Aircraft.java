
/**
 * File: Address.java
 * Created By: Group 11 (L03 B03)
 * Submission: November 29, 2023
 */




public class Aircraft {
    // Attributes
    private Flight flight;
    private Crew flightCrew;

    // Constructor
    public Aircraft(Flight flight, Crew flightCrew) {
        this.flight = flight;
        this.flightCrew = flightCrew;
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

    
}
