/**
 * File: Address.java
 * Created By: Group 11 (L03 B03)
 * Submission: November 29, 2023
 */


import java.sql.*;
import java.util.*;

public class AccessDatabase {
    public final String DBURL;
    public final String USERNAME;
    public final String PASSWORD;

    private Connection dbConnect;
    private ResultSet results;

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
    public boolean insertNewPassenger(int flightNum, String FName, int seatNum){
        try {
            String query = "INSERT INTO TICKETS (FlightNumber, FName, SeatNum) VALUES = (?, ?, ?)";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);

            // setting values/parameters
            myStmt.setInt(1, flightNum);
            myStmt.setString(2, FName);
            myStmt.setInt(3, seatNum);
            

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

    // get passengers given a flight number

    















    // add methods below as needed
}
