package Database;
/**
 * File: Address.java
 * Created By: Group 11 (L03 B03)
 * Submission: November 29, 2023
 */
 import java.sql.*;
 import java.util.*;
 import javax.swing.SingleSelectionModel;

import BookingSystem.Flight;
import BookingSystem.Seat;
import BookingSystem.Wallet;
import Users.AirlineAgent;
import Users.Email;
import Users.FlightAttendant;
import Users.Name;
import Users.Users;
 
 public class AccessDatabase {
     private static AccessDatabase onlyInstance;
     public final String DBURL;
     public final String USERNAME;
     public final String PASSWORD;
 
     private Connection dbConnect;
     private ResultSet results;
 
     public AccessDatabase(){
         DBURL = "jdbc:mysql://localhost:3306/FLIGHT_SYSTEM";
         USERNAME = "root";
         PASSWORD = "Yolo123$";
     }
 
     public AccessDatabase(String url, String user, String pw) {
         // Database URL
         this.DBURL = url;
 
         // Database credentials
         this.USERNAME = user;
         this.PASSWORD = pw;
     }

     
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

     public void deleteConnection() {
        try {
             dbConnect.close();
         } catch (SQLException e) {
             System.out.println("Failed to close connection.");
             e.printStackTrace();
         }
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
     public boolean insertNewUser(Name name, Email email, String password, String addr){
         try {
             String query = "INSERT INTO REGISTERED_USERS (FirstName, LastName, Email, Pw, FullAdress) VALUES (?, ?, ?, ?, ?)";
             PreparedStatement myStmt = dbConnect.prepareStatement(query);
 
             // setting values/parameters
             myStmt.setString(1, name.getFirstName());
             myStmt.setString(2, name.getLastName());
             myStmt.setString(3, email.getEmail());
             myStmt.setString(4, password);
             myStmt.setString(5, addr);
 
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
     public boolean userLogin(String email, String pw) {
        try {
            String query = "SELECT * FROM REGISTERED_USERS WHERE Email = ? AND Pw = ?";
            try (PreparedStatement myStmt = dbConnect.prepareStatement(query)) {
                myStmt.setString(1, email);
                myStmt.setString(2, pw);
    
                try (ResultSet results = myStmt.executeQuery()) {
                    if (!results.next()) { // if no existing user
                        return false;
                    }
                    // Additional logic if needed
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                // Close the connection here if needed
                if (dbConnect != null && !dbConnect.isClosed()) {
                    dbConnect.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    
        return true;
    }
    
 
     // flight attendant login
     public boolean attendantLogin(String email, String pw) {
        try {
            String query = "SELECT * FROM FLIGHT_ATTENDANTS WHERE Email = ? AND Pw = ?";
            try (PreparedStatement myStmt = dbConnect.prepareStatement(query)) {
                myStmt.setString(1, email);
                myStmt.setString(2, pw);
    
                try (ResultSet results = myStmt.executeQuery()) {
                    if (!results.next()) { // if no existing user
                        return false;
                    }
                    // Additional logic if needed
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                // Close the connection here if needed
                if (dbConnect != null && !dbConnect.isClosed()) {
                    dbConnect.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    
        return true;
    }
    
 
     // airline agent login
     public boolean agentLogin(String email, String pw) {
        try {
            String query = "SELECT * FROM AIRLINE_AGENTS WHERE Email = ? AND Pw = ?";
            try (PreparedStatement myStmt = dbConnect.prepareStatement(query)) {
                myStmt.setString(1, email);
                myStmt.setString(2, pw);
    
                try (ResultSet results = myStmt.executeQuery()) {
                    if (!results.next()) { // if no existing user
                        return false;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                // Close the connection here if needed
                if (dbConnect != null && !dbConnect.isClosed()) {
                    dbConnect.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return true;
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
         }
 
         return flights;
     }

     public ArrayList<Flight> fetchFLights(){
         ArrayList<Flight> flights = new ArrayList<Flight>();
         String fromC, toC, fromA, toA, duration, time;
         int price, flightNumber;
 
         try {
             PreparedStatement myStmt = dbConnect.prepareStatement("SELECT * FROM FLIGHTS");
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
         }
 
         return flights;
     }

    public ArrayList<FlightAttendant> fetchFAs(){
         ArrayList<FlightAttendant> flight_attendants = new ArrayList<FlightAttendant>();
         int flightNumber;
         String name;
         String email;
         String pass;
 
         try {
             PreparedStatement myStmt = dbConnect.prepareStatement("SELECT * FROM FLIGHT_ATTENDANTS");
             results = myStmt.executeQuery();
 
             while(results.next()){
                 flightNumber = results.getInt("FA_Number");
                 name = results.getString("FName");
                 email = results.getString("Email");
                 pass = results.getString("Pw");
                 FlightAttendant fa = new FlightAttendant(flightNumber, new Name(name.split(" ")[0], name.split(" ")[1]), new Email(email), pass);
                 flight_attendants.add(fa);
            }
            myStmt.close();
 
         } catch (SQLException e) {
             e.printStackTrace();
         }
 
         return flight_attendants;
     }

     public ArrayList<AirlineAgent> fetchAirlineAgents(){
         ArrayList<AirlineAgent> airline_agents = new ArrayList<AirlineAgent>();
         int aNumber;
         String name;
         String email;
         String pass;
 
         try {
             PreparedStatement myStmt = dbConnect.prepareStatement("SELECT * FROM AIRLINE_AGENTS");
             results = myStmt.executeQuery();
 
             while(results.next()){
                 aNumber = results.getInt("FA_Number");
                 name = results.getString("FName");
                 email = results.getString("Email");
                 pass = results.getString("Pw");
                 AirlineAgent aa = new AirlineAgent(aNumber, new Name(name.split(" ")[0], name.split(" ")[1]), new Email(email), pass);
                 airline_agents.add(aa);
            }
            myStmt.close();
 
         } catch (SQLException e) {
             e.printStackTrace();
         }
 
         return airline_agents;
     }

     public ArrayList<Users> fetchUsers() {
        ArrayList<Users> users = new ArrayList<Users>();
        String fname;
        String lname;
        String email;
        String pass;
        String address;

        try {
            PreparedStatement myStmt = dbConnect.prepareStatement("SELECT * FROM REGISTERED_USERS");
            results = myStmt.executeQuery();

            while(results.next()){
                fname = results.getString("FirstName");
                lname = results.getString("LastName");
                email = results.getString("Email");
                pass = results.getString("Pw");
                address = results.getString("FullAdress");
                Users user = new Users(fname, lname, email, pass, address);
                users.add(user);
           }
           myStmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }


     // inserting into TICKETS table
     public boolean insertNewTicket(int flightNum, String FName, int seatNum, boolean is_insured){
         try {
             String query = "INSERT INTO TICKETS (FlightNumber, FName, SeatNum, Is_insured) VALUES (?, ?, ?, ?)";
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
         } 
 
         return true; // if inserted successfully
     }
 
     // get passengers given a flight number
     // returns a list of ticket holders
     // ALTERNATIVELY, input are flight number and ticket number to get specific passenger
     public ArrayList<String> fetchTicketHolders(int flightNum){
         ArrayList<String> holders = new ArrayList<>();
         int ticketNum, flightNumber, seatNum;
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
                 //String ticket = "Ticket Number: " + ticketNum + "   Flight Number: " + flightNumber + 
                 //                   "   Holder: " + holder + "   Seat: " + seatNum + "   Insured: " + is_insured;
                 String passenger = seatNum + ", " + holder + ",  " + "Not Boarded"; 
                 holders.add(passenger);
             }
 
             myStmt.close();
 
         } catch (SQLException e) {
             e.printStackTrace();
         }
 
         return holders;
     }

     public ArrayList<Seat> fetchSeats(int flightNum) {
         ArrayList<Seat> seats = new ArrayList<Seat>();
         String seatNum;
 
         try {
             PreparedStatement myStmt = dbConnect.prepareStatement("SELECT * FROM TICKETS WHERE FlightNumber = ?");
             myStmt.setInt(1, flightNum);
             results = myStmt.executeQuery();
 
             while(results.next()){
                 seatNum = results.getString("SeatNum");
                 seats.add(new Seat(seatNum));
             }
 
             myStmt.close();
 
         } catch (SQLException e) {
             e.printStackTrace();
         }
 
         return seats;
     }


     public ArrayList<Wallet> fetchWallet() {
         ArrayList<Wallet> cards = new ArrayList<Wallet>();
         String cardNum;
         String expiryDate;
         String cvc;
         int balance;
 
         try {
             PreparedStatement myStmt = dbConnect.prepareStatement("SELECT * FROM CREDIT_CARD");
             results = myStmt.executeQuery();
 
             while(results.next()){
                cardNum = results.getString("CreditNumber");
                cvc = results.getString("Cvc");
                expiryDate = results.getString("ExpirationDate");
                balance = results.getInt("Balance");
                cards.add(new Wallet(cardNum, cvc, expiryDate, balance));
             }
 
             myStmt.close();
 
         } catch (SQLException e) {
             e.printStackTrace();
         }
 
         return cards;
     }

     public void updateBalance(String cardNo, int balance) {
        try {
           PreparedStatement myStmt = dbConnect.prepareStatement("UPDATE CREDIT_CARD SET BALANCE = ? WHERE CreditNumber = ?");
           myStmt.setInt(1, balance);
           myStmt.setString(2, cardNo);

            int rowsAffected = myStmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Update successful. Rows affected: " + rowsAffected);
            } else {
                System.out.println("No rows were updated.");
            }
            myStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

     }
 

     public int fetchTicketNumber(int flightNo, String fname, int seatNo){
        int ticketNo = 0;
         try {
             PreparedStatement myStmt = dbConnect.prepareStatement("SELECT * FROM TICKETS WHERE FlightNumber = ? AND FName = ? AND SeatNum = ?");
             myStmt.setInt(1, flightNo);
             myStmt.setString(2, fname);
             myStmt.setInt(3, seatNo);

            results = myStmt.executeQuery();
             while(results.next()){
                ticketNo = results.getInt("TicketNum");                
            }
            myStmt.close();
 
         } catch (SQLException e) {
             e.printStackTrace();
         }

         return ticketNo;
         
     }

     // remove a ticket from TICKETS table if cancelled
     // ensure is_insured == true before using this method
     // upon returning, the seat should be restored as well
     public boolean deleteTicket(Flight flight, String seatNum, String holderName) {
        try {
            String query = "DELETE FROM TICKETS WHERE FlightNumber = ? AND SeatNum = ? AND FName = ?";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);

            myStmt.setInt(1, flight.getFlightNumber()); 
            myStmt.setString(2, seatNum);
            myStmt.setString(3, holderName);

            int rowsAffected = myStmt.executeUpdate();

            myStmt.close();

            // Check if a ticket was deleted
            if (rowsAffected == 0) {
                System.out.println("No ticket found for Flight " + flight.getFlightNumber() + ", Seat " + seatNum + ", and Holder " + holderName);
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true; // if deletion is successful
}



 }
