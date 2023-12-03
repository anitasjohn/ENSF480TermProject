package BookingSystem;
/**
 * File: Address.java
 * Created By: Group 11 (L03 B03)
 * Submission: November 29, 2023
 */

 import java.util.ArrayList;

import Database.AccessDatabase;
 public class Seatmap {
     // Attributes
     private ArrayList<Seat> businessClass;
     private ArrayList<Seat> comfortClass;
     private ArrayList<Seat> regularClass;
 
     // Constructor
     public Seatmap() {
        AccessDatabase db = AccessDatabase.getOnlyInstance();
        db.initializeConnection();
         businessClass = new ArrayList<Seat>();
         comfortClass = new ArrayList<Seat>();
         regularClass = new ArrayList<Seat>();

         for(int i = 1; i <= 30; i++) {
            regularClass.add(new Seat(String.valueOf(i)));
         }

         for(int i = 31; i <= 40; i++) {
            comfortClass.add(new Seat(String.valueOf(i)));
         }

         for(int i = 41; i <= 45; i++) {
            businessClass.add(new Seat(String.valueOf(i)));
         }

         db.deleteConnection();
     }
 

     public ArrayList<Seat> getBusiness() {
        return businessClass;
     }

     public ArrayList<Seat> getComfort() {
        return comfortClass;
     }

     public ArrayList<Seat> getOrdinary() {
        return regularClass;
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