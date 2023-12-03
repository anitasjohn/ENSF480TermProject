package BookingSystem;
/**
 * File: Seat.java
 * Created By: Group 11 (L03 B03)
 * Submission: November 29, 2023
 */

 public class Seat {
    private String seatNumber;
    
    public Seat(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getSeatNumber() {
        return this.seatNumber;
    }
    
    // Setter methods
    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }
}