package Users;
import java.util.ArrayList;

import BookingSystem.Ticket;
import BookingSystem.Wallet;
import Login.Check;
/**
 * File: Login.java
 * Created By: Group 11 (L03 B03)
 * Submission: November 29, 2023
 */

// NOT SINGLETON
// Can possibly convert to Singleton


public class Login {
    private String enteredEmail;
    private String enteredPw;
    private Check loginStrategy;
    
    private int flightNo;
    private String typeOfUser;
    private String typeOfSeat;
    private String FName;
    private int price;
    private boolean isInsured;
    
    private ArrayList<Ticket> tickets = new ArrayList<Ticket>();
    private ArrayList<Wallet> wallet = new ArrayList<Wallet>();

    private Ticket recentlyPurchased;
    private Wallet cardUsed;

    private String departure;
    private String destination;
    private String departAirport;
    private String destAirport;
    private String duration;
    private String flightTime;

    public Login(String email, String pw){
        this.enteredEmail = email;
        this.enteredPw = pw;
    }

    public void setLoginStrategy(Check strategy){
        this.loginStrategy = strategy;
    }

    public boolean performStartegy(){
        return loginStrategy.validate(enteredEmail, enteredPw);
    }

    /*Getters and Setters */
    public void setEmail(String email) {
        enteredEmail = email;
    }

    public String getEmail() {
        return enteredEmail;
    }

    public String getPassword() {
        return enteredPw;
    }

    public void setUser(String user) {
        typeOfUser = user;
    }

    public String getUser() {
        return typeOfUser;
    }

    public void setFName(String fullname) {
        FName = fullname;
    }

    public String getFName() {
        return FName;
    }

    public void setPrice(int newPrice) {
        price = newPrice;
    }

    public int getPrice() {
        return price;
    }
    
    public void setInsured(boolean b) {
        isInsured = b;
    }

    public boolean getInsured() {
        return isInsured;
    }

    public void setSeat(String seat) {
        typeOfSeat = seat;
    }

    public String getSeat() {
        return typeOfSeat;
    }

    public void setFlight(int flightID) {
        flightNo = flightID;
    }

    public int getFlight() {
        return flightNo;
    }

    public void setTypeOfSeat(String type) {
        typeOfSeat = type;
    }

    public String getTypeOfSeat() {
        return typeOfSeat;
    }

    public void setTickets(Ticket ticket) {
        tickets.add(ticket);
    }
     public void setWallet(Wallet w) {
        wallet.add(w);
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }
     public ArrayList<Wallet> getWallet() {
        return wallet;
    }

     public void setTicket(Ticket ticket) {
        recentlyPurchased = ticket;
    }
     public Ticket getTicket() {
        return recentlyPurchased;
    }

    public void setCard(Wallet card) {
        cardUsed = card;
    }
     public Wallet getCard() {
        return cardUsed;
    }


    //Additional setters and getters for the flight
    public void setDeparture(String d) {
        departure = d;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDestination(String d) {
        destination = d;
    }

    public String getDestination() {
        return destination;
    }

    public void setDeptAirport(String d) {
        departAirport = d;
    }

    public String getDeptAirport() {
        return departAirport;
    }
    
    public void setDestAirport(String d) {
        destAirport = d;
    }

    public String getDestAirport() {
        return destAirport;
    }

    public void setDuration(String d) {
        duration = d;
    }

    public String getDuration() {
        return duration;
    }

    public void setFlightTime(String ft) {
        flightTime = ft;
    }

    public String getFlightTime() {
        return flightTime;
    }
}