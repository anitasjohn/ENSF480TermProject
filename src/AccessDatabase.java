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

    public boolean insertNewUser(Name name, Email email, String password, Address addr){
        try {
            String query = "INSERT INTO REGISTED_USER (FirstName, LastName, Email, Pw, StreetAddr, PostalCode, City, Province, Country) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
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


    // add methods below as needed
}
