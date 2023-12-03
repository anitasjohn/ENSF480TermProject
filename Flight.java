package BookingSystem;
/**
 * File: Address.java
 * Created By: Group 11 (L03 B03)
 * Submission: November 29, 2023
 */

public class Flight {
    // Private instance variables
    private String fromCity;     // place of departure
    private String toCity;      // place of departure
    //private Address location;        // address of airport 
    private String fromAirport;
    private String toAirport;
    private String duration;        // duration of flight
    private int flightNumber;       // flight id
    //private String takeoffNumber;   // gate number at airport 
    private String timeOfFlight;    // time of the flight
    private int price;

    // Constructors
    public Flight() {
        // Default constructor
    }

    public Flight(String from, String to, String fromAirport, String toAirport , String duration, int flightNumber, String time, int price) {
        //this.destination = destination;
        this.fromCity = from;
        this.toCity = to;
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
        //this.location = location;
        this.duration = duration;
        this.flightNumber = flightNumber;
        //this.takeoffNumber = takeoffNumber;
        this.timeOfFlight = time;
        this.price = price;
    }

    // Getter and setter methods
    public String getDeparture() {
        return fromCity;
    }
    public String getDestination() {
        return toCity;
    }

    public String getDepartureAirport() {
        return fromAirport;
    }
    public String getDestinationAirport() {
        return toAirport;
    }

    public int getPrice() {
        return price;
    }

    public void setDeparture(String departure) {
        this.fromCity = departure;
    }

    public void setDestination(String destination) {
        this.toCity = destination;
    }

    // public Address getLocation() {
    //     return location;
    // }

    // public void setLocation(Address location) {
    //     this.location = location;
    // }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    //AUTO GENERATED IN DATABASE
    public int getFlightNumber() {
        return flightNumber;
    }

    public String getTimeOfFlight() {
        return timeOfFlight;
    }

    // public void setFlightNumber(int flightNumber) {
    //     this.flightNumber = flightNumber;
    // }

    // public String getTakeoffNumber() {
    //     return takeoffNumber;
    // }

    // public void setTakeoffNumber(String takeoffNumber) {
    //     this.takeoffNumber = takeoffNumber;
    // }

    public void printFlightDetails() {
        System.out.println("Flight Details:");
        System.out.println("Departure: " + fromCity);
        System.out.println("From Airport: " + fromAirport);
        System.out.println("Destination: " + toCity);
        System.out.println("To Airport: " + toAirport);
        //System.out.println("Location: " + location.getAddress());
        System.out.println("Duration: " + duration);
        System.out.println("Flight Number: " + flightNumber);
       // System.out.println("Takeoff Number: " + takeoffNumber);
        System.out.print("Time of flight: " + timeOfFlight);
        System.out.println("Price: " + this.price);
    }

    public String getflightDetailsString(){
        String flightDetailsString = "Flight Details:\n Departure: " + fromCity +  "\nDestination: " + this.toCity + "\nDeparture Airport: " + this.fromAirport +
                                        "\nDestination Airport: "  + toAirport + "\nDuration: " + this.duration + "\nFlight Number: " + this.flightNumber + "\nTIme of flight: " + this.timeOfFlight + "\nPrice: " + this.price;

        return flightDetailsString;
    }
}

    