import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

public class ViewPassengersGUI extends JFrame {
    private JTable passengerTable;
    private DefaultTableModel tableModel;

    public ViewPassengersGUI() {
        setTitle("Flight Attendant Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 600));
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

        // Add some sample data
        tableModel.addRow(new Object[]{"1A", "John Doe", "Boarded"});
        tableModel.addRow(new Object[]{"2B", "Jane Doe", "Not Boarded"});
        tableModel.addRow(new Object[]{"3C", "Bob Smith", "Boarded"});

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
