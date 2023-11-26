/**
 * File: Ticket.java
 * Created By: Group 11 (L03 B03)
 * Submission: November 29, 2023
 */



public class Ticket {
    private Flight flight;
    private String seatNum;

    public Ticket(Flight flight, String seat) {
        this.flight = flight;
        this.seatNum = seat;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public String getSeatNum(){
        return this.seatNum;
    }

}
