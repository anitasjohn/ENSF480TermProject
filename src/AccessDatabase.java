/**
 * File: Address.java
 * Created By: Group 11 (L03 B03)
 * Submission: November 29, 2023
 */

// SINGLETON PATTERN

import java.sql.*;
import java.util.*;

import javax.swing.SingleSelectionModel;

public class AccessDatabase {
    private static AccessDatabase onlyInstance;
    public final String DBURL;
    public final String USERNAME;
    public final String PASSWORD;

    private Connection dbConnect;
    private ResultSet results;

    private AccessDatabase(){
        DBURL = "jdbc:mysql://localhost/flight_system";
        USERNAME = "ENTER USERNAME HERE";
        PASSWORD = "ENTER PASSWORD";
    }

    // public AccessDatabase(String url, String user, String pw) {
    //     // Database URL
    //     this.DBURL = url;

    //     // Database credentials
    //     this.USERNAME = user;
    //     this.PASSWORD = pw;
    // }

    // Create a connection to the database
    public void initializeConnection() {
        try {
            dbConnect = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
        } catch (SQLException e) {
			System.out.println("Failed to connect to database");
            e.printStackTrace();
        }
    }

    public static AccessDatabase getOnlyInstance() {
        if (onlyInstance == null){
            onlyInstance = new AccessDatabase();
        };
        
        return onlyInstance;
    }

    String getDburl() {
        return this.DBURL;
    }

    String getUsername() {
        return this.USERNAME;
    }

    String getPassword() {
        return this.PASSWORD;
    }

    // user registration
    public boolean insertNewUser(Name name, Email email, String password, Address addr){
        try {
            String query = "INSERT INTO REGISTERED_USERS (FirstName, LastName, Email, Pw, FullAdress) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);

            // setting values/parameters
            myStmt.setString(1, name.getFirstName());
            myStmt.setString(2, name.getLastName());
            myStmt.setString(3, email.getEmail());
            myStmt.setString(4, password);
            myStmt.setString(5, addr.getAddress());

            int rowCount = myStmt.executeUpdate();
            myStmt.clearParameters();
            myStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                 if(dbConnect != null){
                    dbConnect.close();
                 }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return true; // if inserted successfully
    }

    // validate email, to avoid duplicates
    public boolean validateEmail(String inputEmail){
        try {
            String query = "SELECT * FROM REGISTERED_USERS WHERE Email = ?";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);

            myStmt.setString(1, inputEmail);
            results = myStmt.executeQuery();
            myStmt.close();
            if(results.next()){ // check if there is an existing user with same email
                return false;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                 if(dbConnect != null){
                    results.deleteRow(); // double check if this is correct
                    dbConnect.close();
                 }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true; // if there is no duplicate for same email
    }

    // user login
    public boolean userLogin(String email, String pw){
        try {
            String query = "SELECT * REGISTERED_USERS WHERE Email = ? AND Pw = ?";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);

            myStmt.setString(1, email);
            myStmt.setString(2, pw);

            results = myStmt.executeQuery();

            myStmt.close();

            if(!results.next()){ // if no existing user
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            try {
                 if(dbConnect != null){
                    results.deleteRow(); // double check if this is correct
                    dbConnect.close();
                 }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return true;
    }

    // flight attendant login
    public boolean attendantLogin(String email, String pw){
        try {
            String query = "SELECT * FLIGHT_ATTENDANTS WHERE Email = ? AND Pw = ?";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);

            myStmt.setString(1, email);
            myStmt.setString(2, pw);

            results = myStmt.executeQuery();

            myStmt.close();

            if(!results.next()){ // if no existing user
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            try {
                 if(dbConnect != null){
                    results.deleteRow(); // double check if this is correct
                    dbConnect.close();
                 }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return true;
    }

    // airline agent login
    public boolean agentLogin(String email, String pw){
        try {
            String query = "SELECT * AIRLINE_AGENTS WHERE Email = ? AND Pw = ?";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);

            myStmt.setString(1, email);
            myStmt.setString(2, pw);

            results = myStmt.executeQuery();

            myStmt.close();

            if(!results.next()){ // if no existing user
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            try {
                 if(dbConnect != null){
                    results.deleteRow(); // double check if this is correct
                    dbConnect.close();
                 }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return true; // if there exists an agent with the same login credentials
    }

    // get all flights for browsing given a destination city
    public ArrayList<Flight> fetchFLights(String destination){
        ArrayList<Flight> flights = new ArrayList<Flight>();
        String fromC, toC, fromA, toA, duration, time;
        int price, flightNumber;

        try {
            PreparedStatement myStmt = dbConnect.prepareStatement("SELECT * FROM FLIGHTS WHERE Destination = ?");
            myStmt.setString(1, destination);
            results = myStmt.executeQuery();

            while(results.next()){

                flightNumber = results.getInt("FlightNumber");
                fromC = results.getString("Departure");
                toC = results.getString("Destination");
                fromA = results.getString("DepartureAirport");
                toA = results.getString("DestinationAirport");
                duration = results.getString("Duration");
                time = results.getString("FlightTime");
                price = results.getInt("Price");
                Flight flight = new Flight(fromC, toC, fromA, toA, duration, flightNumber, time, price);
                flights.add(flight);
            }

            myStmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                 if(dbConnect != null){
                    dbConnect.close();
                 }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return flights;
    }

    // inserting into TICKETS table
    public boolean insertNewPassenger(int flightNum, String FName, int seatNum, boolean is_insured){
        try {
            String query = "INSERT INTO TICKETS (FlightNumber, FName, SeatNum, Is_insured) VALUES = (?, ?, ?, ?)";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);

            // setting values/parameters
            myStmt.setInt(1, flightNum);
            myStmt.setString(2, FName);
            myStmt.setInt(3, seatNum);
            myStmt.setBoolean(4, is_insured);
            

            int rowCount = myStmt.executeUpdate();
            myStmt.clearParameters();
            myStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                 if(dbConnect != null){
                    dbConnect.close();
                 }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return true; // if inserted successfully
    }

    // // get passengers given a flight number
    // // returns a list of ticket holders STRING
    // // ALTERNATIVELY, input are flight number and ticket number to get specific passenger
    // public ArrayList<String> fetchTicketHolders(int flightNum){
    //     ArrayList<String> holders = new ArrayList<>();
    //     int ticketNum ,flightNumber, seatNum;
    //     String holder;
    //     boolean is_insured;

    //     try {
    //         PreparedStatement myStmt = dbConnect.prepareStatement("SELECT * FROM TICKETS WHERE FlightNumber = ?");
    //         myStmt.setInt(1, flightNum);
    //         results = myStmt.executeQuery();

    //         while(results.next()){

    //             ticketNum = results.getInt("TicketNum");
    //             flightNumber = results.getInt("FlightNumber");
    //             holder = results.getString("FName");
    //             seatNum = results.getInt("SeatNum");
    //             is_insured = results.getBoolean("Is_insured");
    //             String ticket = "Ticket Number: " + ticketNum + "   Flight Number: " + flightNumber + 
    //                                 "   Holder: " + holder + "   Seat: " + seatNum + "   Insured: " + is_insured;
    //             holders.add(ticket);
    //         }

    //         myStmt.close();

    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }finally {
    //         try {
    //              if(dbConnect != null){
    //                 dbConnect.close();
    //              }
    //         } catch (Exception e) {
    //             e.printStackTrace();
    //         }
    //     }

    //     return holders;
    // }

    // get passengers given a flight number
    // returns a list of ticket holders STRING
    // ALTERNATIVELY, input are flight number and ticket number to get specific passenger
    public ArrayList<Ticket> fetchTicketHolders(int flightNum){
        ArrayList<Ticket> holders = new ArrayList<>();
        int ticketNum ,flightNumber, seatNum;
        String holder;
        boolean is_insured;

        try {
            PreparedStatement myStmt = dbConnect.prepareStatement("SELECT * FROM TICKETS WHERE FlightNumber = ?");
            myStmt.setInt(1, flightNum);
            results = myStmt.executeQuery();

            while(results.next()){

                ticketNum = results.getInt("TicketNum");
                flightNumber = results.getInt("FlightNumber");
                holder = results.getString("FName");
                seatNum = results.getInt("SeatNum");
                is_insured = results.getBoolean("Is_insured");
                Ticket ticket = new Ticket(flightNumber, ticketNum,  holder, seatNum, is_insured);
                holders.add(ticket);
            }

            myStmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                 if(dbConnect != null){
                    dbConnect.close();
                 }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return holders;
    }



    // remove a ticket from TICKETS table if cancelled
    // ensure is_insured == true before using this method
    // upon returning, the seat should be restored as well
    public boolean deleteTicket(int ticketNum){
        try {
            String query = "DELETE FROM TICKETS WHERE TicketNum = ?";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);

            myStmt.setInt(1, ticketNum);
            myStmt.executeUpdate(); // should be 1

            myStmt.close();

        } catch (SQLException e) {
            
            e.printStackTrace();
            return false;
        } finally {
            try {
                 if(dbConnect != null){
                    dbConnect.close();
                 }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return true; // if deletion is successful
    }
    
    // add methods below as needed
}
