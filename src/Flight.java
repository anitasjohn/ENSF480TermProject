/**
 * File: Address.java
 * Created By: Group 11 (L03 B03)
 * Submission: November 29, 2023
 */




public class Flight {
    // Private instance variables
    private String destination;
    private String location;
    private String duration;
    private int flightNumber;
    private String takeoffNumber;

    // Constructors
    public Flight() {
        // Default constructor
    }

    public Flight(String destination, String location, String duration, int flightNumber, String takeoffNumber) {
        this.destination = destination;
        this.location = location;
        this.duration = duration;
        this.flightNumber = flightNumber;
        this.takeoffNumber = takeoffNumber;
    }

    // Getter and setter methods
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getTakeoffNumber() {
        return takeoffNumber;
    }

    public void setTakeoffNumber(String takeoffNumber) {
        this.takeoffNumber = takeoffNumber;
    }

    public void printFlightDetails() {
        System.out.println("Flight Details:");
        System.out.println("Destination: " + destination);
        System.out.println("Location: " + location);
        System.out.println("Duration: " + duration);
        System.out.println("Flight Number: " + flightNumber);
        System.out.println("Takeoff Number: " + takeoffNumber);
    }
}

    
