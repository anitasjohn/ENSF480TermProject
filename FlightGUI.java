package GUI;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import BookingSystem.Flight;
import Database.AccessDatabase;
import Users.Login;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FlightGUI implements ActionListener {
    Login loggedIn = LoginGUI.getLogin();
    String user;
    private JFrame frame;
    private JPanel panel;
    private JTable flightsTable;
    private Object[] columns = {"Flight ID", "Departure", "Destination", "Dep. Airport", "Dest. Airport","Duration", "FlightTime", "Price"};
    private DefaultTableModel model;
    JTextField destination = new JTextField(10);
    JTextField originOptions = new JTextField(10);
    JComboBox<String> prices = new JComboBox<>(new String[]{"Ordinary", "Comfort", "Business"});
    ArrayList<Flight> flights;


    //to see if the track clicked on a flight
    int selectedRow = -1;

    AccessDatabase db;

    public FlightGUI() {
        db = AccessDatabase.getOnlyInstance();
        db.initializeConnection();
        frame = new JFrame();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10)); // BorderLayout with horizontal and vertical gaps

        createTopPanel();
        createTablePanel();
        createButtonsPanel();

        frame.add(panel);
        frame.setTitle("Flight Booking System");
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);
    }

    private void createTopPanel() {
        JPanel topPanel = new JPanel(new FlowLayout()); // FlowLayout for a single line
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        String[] days = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        String[] years = {"2023", "2024"};
        
        JLabel originLabel = new JLabel("From:");
        JLabel destLabel = new JLabel("To:");
        JLabel departLabel = new JLabel("Departure:");
        JComboBox<String> monthOptions = new JComboBox<>(months);
        JComboBox<String> daysOptions = new JComboBox<>(days);
        JComboBox<String> yearsOptions = new JComboBox<>(years);
        JLabel priceLabel = new JLabel("Seating Price:");
        
        topPanel.add(originLabel);
        topPanel.add(originOptions);
        topPanel.add(destLabel);
        topPanel.add(destination);
        topPanel.add(departLabel);
        topPanel.add(monthOptions);
        topPanel.add(daysOptions);
        topPanel.add(yearsOptions);
        topPanel.add(priceLabel);
        topPanel.add(prices);

        panel.add(topPanel, BorderLayout.NORTH);
    }

    private void createTablePanel() {
        model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        flightsTable = new JTable(model);
        flightsTable.getSelectionModel().addListSelectionListener(e -> {
            selectedRow = flightsTable.getSelectedRow();
        });
    
        JScrollPane tableScrollPane = new JScrollPane(flightsTable);
        tableScrollPane.setBorder(BorderFactory.createTitledBorder("Available Flights"));
        panel.add(tableScrollPane, BorderLayout.CENTER);
    }

    private void createButtonsPanel() {
        JPanel buttonsPanel = new JPanel(); // Left-aligned FlowLayout
    
        JButton searchBtn = new JButton("Search");
        JButton nextBtn = new JButton("Next");
        JButton backBtn = new JButton("Go back");
        JButton viewPromoBtn = new JButton("View Promos");
    
        searchBtn.addActionListener(this);
        nextBtn.addActionListener(this);
        backBtn.addActionListener(this);
        viewPromoBtn.addActionListener(this);
    
        buttonsPanel.add(searchBtn);
        buttonsPanel.add(nextBtn);
        buttonsPanel.add(backBtn);

        // Add an empty panel to absorb extra space
        JPanel emptyPanel = new JPanel();
        buttonsPanel.add(emptyPanel);
    
        if(loggedIn.getUser() == "user") {
            // Add viewPromoBtn to the right
            buttonsPanel.add(viewPromoBtn);
        }
    
        panel.add(buttonsPanel, BorderLayout.SOUTH);
    }

    public void setFrame(boolean b) {
        frame.setVisible(b);
    }

    public void setUser(String typeOfUser) {
        user = typeOfUser;
    }
    public String getUser() {
        return user;
    }
    

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Go back")) {
            frame.setVisible(false);
            // Assuming there is a LoginGUI class with setFrame method
            LoginGUI login = new LoginGUI();
            login.setFrame(true);
        } else if (e.getActionCommand().equals("Next")) {
            // Assuming there is a SeatGUI class with setFrame method
            if(selectedRow != -1) {
                String seat = ((String)prices.getSelectedItem()).strip();
                loggedIn.setTypeOfSeat(seat);
                int flightNo = (int)flightsTable.getValueAt(selectedRow, 0);
                loggedIn.setFlight(flightNo);
                int price = (int)flightsTable.getValueAt(selectedRow, 7);
                loggedIn.setPrice(price);

                //Storing arguments for the flight
                loggedIn.setDeparture((String) flightsTable.getValueAt(selectedRow, 1));
                loggedIn.setDestination((String) flightsTable.getValueAt(selectedRow, 2));
                loggedIn.setDeptAirport((String)flightsTable.getValueAt(selectedRow, 3));
                loggedIn.setDestAirport((String) flightsTable.getValueAt(selectedRow, 4));
                loggedIn.setDuration((String) flightsTable.getValueAt(selectedRow, 5));
                loggedIn.setFlightTime((String) flightsTable.getValueAt(selectedRow, 6));
                frame.setVisible(true);
                SeatGUI seatMap = new SeatGUI();
                seatMap.setFrame(true);
            }
        } else if (e.getActionCommand().equals("Search")) {
            // Add your search logic here
            // For example, update the table with search results
            updateTableWithSearchResults();
        } else if(e.getActionCommand().equals("View Promos")) {
            String message = "Sent on December 1st, 2023:\n\nYou get access to the airport lounges for 40% off.\nYou receive a free companion ticket once a year.\nYou are automatically applied for the cancellation insurance.";
            JOptionPane.showMessageDialog(null, message, "Registered User Promos", JOptionPane.PLAIN_MESSAGE);
        }
    }

    private void updateTableWithSearchResults() {
        int current_row_count = model.getRowCount();
        if(current_row_count != 0) {
            for(int i = 0; i < current_row_count; i++) {
                model.removeRow(0);
            }
        }
        if(destination.getText() != "" && originOptions.getText() != "") {
            int amount;
            flights = db.fetchFLights(destination.getText());
            for(Flight flight: flights) {
                String seat = ((String)prices.getSelectedItem()).strip();
                if(seat == "Comfort") {
                    amount = flight.getPrice() * 2;
                } else if(seat == "Business") {
                    amount = flight.getPrice() * 3;
                } else {
                    amount = flight.getPrice();
                }
                Object[] row = {flight.getFlightNumber(), flight.getDeparture(), flight.getDestination(), flight.getDepartureAirport(), flight.getDestinationAirport(), flight.getDuration(), flight.getTimeOfFlight() , amount};
                model.addRow(row);
            }
        }
        // Add logic to update the table with search results
    }

}
