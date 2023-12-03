/**
 * File: Ticket.java
 * Created By: Group 11 (L03 B03)
 * Submission: November 29, 2023
 */



public class Ticket {
    private Flight flight;
    private String holder;
    private int seatNum;
    private boolean insured;
    private int ticketNum;
    private int flightNum;

    AccessDatabase database = AccessDatabase.getOnlyInstance();

    // used when generating a NEW ticket
    public Ticket(Flight flight, String FName, int seat, boolean insured) {
        this.flight = flight;
        this.holder = FName;
        this.seatNum = seat;
        this.insured = insured;
        // insert new ticket into the database
        database.initializeConnection();
        database.insertNewPassenger(flight.getFlightNumber(), FName, flightNum, insured);
    }

    // only used by fetchTicketHolders() in AccessDatabase.java
    // only used when fetching the ticket holders for a specific flight 
    public Ticket(int flightNum, int ticketNum, String FName, int seat, boolean insured) {
        this.flightNum = flightNum;
        this.ticketNum = ticketNum;
        this.holder = FName;
        this.seatNum = seat;
        this.insured = insured;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public String getName(String name){
        return this.holder;
    }

    public void setName(String name){
        this.holder = name;
    }

    public int getSeatNum(){
        return this.seatNum;
    }

    public boolean checkInsurance(){
        return this.insured;
    }

}
