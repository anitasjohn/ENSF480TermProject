/**
 * File: Ticket.java
 * Created By: Group 11 (L03 B03)
 * Submission: November 29, 2023
 */



public class Ticket {
    private Flight flight;
    private String holder;
    private String seatNum;

    public Ticket(Flight flight, String FName, String seat) {
        this.flight = flight;
        this.holder = FName;
        this.seatNum = seat;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public void setName(String name){
        this.holder = name;
    }

    public String getSeatNum(){
        return this.seatNum;
    }

}
