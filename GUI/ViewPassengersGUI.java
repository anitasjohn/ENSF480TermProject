package GUI;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Database.AccessDatabase;

import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;

public class ViewPassengersGUI extends JFrame {
    private JTable passengerTable;
    private DefaultTableModel tableModel;
    ArrayList<String> passengers = new ArrayList<String>();
    AccessDatabase db = new AccessDatabase();

    public ViewPassengersGUI(int flightNum) {
        db.initializeConnection();
        setTitle("Passengers Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 600));
        passengers = db.fetchTicketHolders(flightNum);
        createComponents();
        pack();
        setLocationRelativeTo(null);
        setVisible(true); 
    }

    private void createComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Create a sample data model for the table
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Seat Number");
        tableModel.addColumn("Passenger Name");
        tableModel.addColumn("Status");

        for(String pass : passengers) {
            String[] splitPass = pass.split(",");
            tableModel.addRow(new Object[]{splitPass[0].strip(), splitPass[1].strip(), splitPass[2].strip()});
        }
        // Add some sample data
        

        passengerTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(passengerTable);

        // Customize the appearance of the table
        passengerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        passengerTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        passengerTable.setFont(new Font("Arial", Font.PLAIN, 12));

        mainPanel.add(tableScrollPane, BorderLayout.CENTER);

        // Create a control panel with buttons
        JPanel controlPanel = new JPanel();
        JButton updateStatusButton = new JButton("Update Status");
        JButton addPassengerButton = new JButton("Add Passenger");
        JButton returnButton = new JButton("Go back");

        controlPanel.add(updateStatusButton);
        controlPanel.add(addPassengerButton);
        controlPanel.add(returnButton);

        mainPanel.add(controlPanel, BorderLayout.SOUTH);

        // Add action listeners for the buttons
        updateStatusButton.addActionListener(e -> updatePassengerStatus());
        addPassengerButton.addActionListener(e -> addPassenger());
        returnButton.addActionListener(e -> {
            setVisible(false);
            PassengersGUI vp = new PassengersGUI();
            vp.setFrame(true);
        }    
        );

        getContentPane().add(mainPanel, BorderLayout.CENTER);
    }

    private void updatePassengerStatus() {
        int selectedRow = passengerTable.getSelectedRow();
        if (selectedRow != -1) {
            String currentStatus = (String) tableModel.getValueAt(selectedRow, 2);
            String newStatus = (currentStatus.equals("Boarded")) ? "Not Boarded" : "Boarded";
            tableModel.setValueAt(newStatus, selectedRow, 2);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a passenger to update the status.");
        }
    }

    private void addPassenger() {
        String seatNumber = JOptionPane.showInputDialog(this, "Enter Seat Number:");
        String passengerName = JOptionPane.showInputDialog(this, "Enter Passenger Name:");

        if (seatNumber != null && !seatNumber.isEmpty() && passengerName != null && !passengerName.isEmpty()) {
            Vector<Object> rowData = new Vector<>();
            rowData.add(seatNumber);
            rowData.add(passengerName);
            rowData.add("Not Boarded");
            tableModel.addRow(rowData);
        } else {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter both seat number and passenger name.");
        }
    }

    public void setFrame(boolean b) {
        setVisible(b);
    }

}
