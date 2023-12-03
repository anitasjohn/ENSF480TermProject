package BookingSystem;
/**
 * File: Crew.java
 * Created By: Group 11 (L03 B03)
 * Submission: November 29, 2023
 */

import java.util.ArrayList;

import Users.FlightAttendant;

 public class Crew {
     private ArrayList<Pilot> pilots;
     private ArrayList<FlightAttendant> flightAttendants;
 
     public Crew(ArrayList<Pilot> pilots, ArrayList<FlightAttendant> flightAttendants) {
         this.pilots = pilots;
         this.flightAttendants = flightAttendants;
     }
 
     public ArrayList<Pilot> getPilots() {
         return pilots;
     }
 
     public void setPilots(ArrayList<Pilot> pilots) {
         this.pilots = pilots;
     }
 
     public ArrayList<FlightAttendant> getFlightAttendants() {
         return flightAttendants;
     }
 
     public void setFlightAttendants(ArrayList<FlightAttendant> flightAttendants) {
         this.flightAttendants = flightAttendants;
     }
 
     public void addCrewMember(Pilot pilot){
         this.pilots.add(pilot);
     }
 
     public void addCrewMember(FlightAttendant flightAttendant){
         this.flightAttendants.add(flightAttendant);
     }
 
 }