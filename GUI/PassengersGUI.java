package GUI;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import BookingSystem.Flight;
import Database.AccessDatabase;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

public class PassengersGUI implements ActionListener {
    private JFrame frame;
    private JPanel panel;
    private JTable flightsTable;
    private Object[] columns = {"Flight ID", "Departure", "Destination", "Dep. Airport", "Dest. Airport", "Duration", "FlightTime", "Price"};
    private DefaultTableModel model;
    ArrayList<Flight> flights = new ArrayList<Flight>();
    AccessDatabase db = AccessDatabase.getOnlyInstance();
    int selectedRow = -1;

    public PassengersGUI() {
        db.initializeConnection();

        flights = db.fetchFLights();
        
    
        frame = new JFrame();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10)); // BorderLayout with horizontal and vertical gaps

        createTablePanel();
        createButtonsPanel();

        frame.add(panel);
        frame.setTitle("View Passengers");
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);
        db.deleteConnection();
    }

    private void createTablePanel() {
        model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        flightsTable = new JTable(model);
        for(Flight flight: flights) {
            Object[] row = {flight.getFlightNumber(), flight.getDeparture(), flight.getDestination(), flight.getDepartureAirport(), flight.getDestinationAirport(), flight.getDuration(), flight.getTimeOfFlight(), flight.getPrice()};
            model.addRow(row);
        }

        flightsTable.getSelectionModel().addListSelectionListener(e -> {
            selectedRow = flightsTable.getSelectedRow();
        });

        JScrollPane tableScrollPane = new JScrollPane(flightsTable);
        tableScrollPane.setBorder(BorderFactory.createTitledBorder("Available Flights"));
        panel.add(tableScrollPane, BorderLayout.CENTER);
    }

    private void createButtonsPanel() {
        JPanel buttonsPanel = new JPanel();
        JButton nextBtn = new JButton("View Passengers");
        JButton backBtn = new JButton("Go back");

        nextBtn.addActionListener(this);
        backBtn.addActionListener(this);

        buttonsPanel.add(nextBtn);
        buttonsPanel.add(backBtn);

        panel.add(buttonsPanel, BorderLayout.SOUTH);
    }

    public void setFrame(boolean b) {
        frame.setVisible(b);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Go back")) {
            frame.setVisible(false);
            // Assuming there is a LoginGUI class with setFrame method
            LoginGUI login = new LoginGUI();
            login.setFrame(true);
        } else if (e.getActionCommand().equals("View Passengers")) {

            if(selectedRow != -1) {
                // Assuming there is a SeatGUI class with setFrame method
                frame.setVisible(false);
                //add an argument for ViewPassengersGUI
                ViewPassengersGUI viewPass = new ViewPassengersGUI(flights.get(selectedRow).getFlightNumber());
                viewPass.setFrame(true);
            }
        } 
        db.deleteConnection();
    }

}
