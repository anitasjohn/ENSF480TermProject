import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PassengersGUI implements ActionListener {
    private JFrame frame;
    private JPanel panel;
    private JTable flightsTable;
    private Object[] columns = {"Flight ID", "Departure", "Destination", "Aircraft", "Duration", "Price"};
    private DefaultTableModel model;


    public PassengersGUI() {
        frame = new JFrame();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10)); // BorderLayout with horizontal and vertical gaps

        createTablePanel();
        createButtonsPanel();

        frame.add(panel);
        frame.setTitle("View Passengers System");
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);
    }

    private void createTablePanel() {
        model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        flightsTable = new JTable(model);

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
            // Assuming there is a SeatGUI class with setFrame method
            frame.setVisible(false);
            ViewPassengersGUI viewPass = new ViewPassengersGUI();
            viewPass.setFrame(true);
        } 
    }

    private void updateTableWithSearchResults() {
        // Add logic to update the table with search results
        // For now, adding a dummy row for demonstration purposes
        Object[] row = {"27109", "March 17, 2020 at 2pm", "Mexico", "Boeing 747", "2 hours", "Price"};
        model.addRow(row);
    }

}
