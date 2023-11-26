/**
 * File: Seatmap.java
 * Created By: Group 11 (L03 B03)
 * Submission: November 29, 2023
 */


import java.util.ArrayList;
public class Seatmap {
    // Attributes
    private ArrayList<Seat> businessClass;
    private ArrayList<Seat> comfortClass;
    private ArrayList<Seat> regularClass;

    // Constructor
    public Seatmap() {
        businessClass = new ArrayList<>();
        comfortClass = new ArrayList<>();
        regularClass = new ArrayList<>();
    }

    // Method to pick a seat by seat number
    public Seat pickSeat(String seatNum) {
        // Search for the seat in each class
        for (Seat seat : businessClass) {
            if (seat.getSeatNumber().equals(seatNum)) {
                return seat;
            }
        }

        for (Seat seat : comfortClass) {
            if (seat.getSeatNumber().equals(seatNum)) {
                return seat;
            }
        }

        for (Seat seat : regularClass) {
            if (seat.getSeatNumber().equals(seatNum)) {
                return seat;
            }
        }

        return null;
    }

    // Method to remove a seat by seat number
    public void removeSeat(String seatNum) {
        
        businessClass.removeIf(seat -> seat.getSeatNumber().equals(seatNum));
        comfortClass.removeIf(seat -> seat.getSeatNumber().equals(seatNum));
        regularClass.removeIf(seat -> seat.getSeatNumber().equals(seatNum));
    }

  
}