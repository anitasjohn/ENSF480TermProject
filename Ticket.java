package BookingSystem;
/**
 * File: Ticket.java
 * Created By: Group 11 (L03 B03)
 * Submission: November 29, 2023
 */

public class Ticket {
    private Flight flight;
    private String holder;
    private String seatNum;
    private boolean insured;

    public Ticket(Flight flight, String FName, String seat, boolean insured) {
        this.flight = flight;
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

    public String getName(){
        return this.holder;
    }

    public void setName(String name){
        this.holder = name;
    }

    public String getSeatNum(){
        return this.seatNum;
    }

    public boolean checkInsurance(){
        return this.insured;
    }

}