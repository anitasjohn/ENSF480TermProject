import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FlightGUI implements ActionListener {
    String user;
    private JFrame frame;
    private JPanel panel;
    private JTable flightsTable;
    private Object[] columns = {"Flight ID", "Departure", "Destination", "Aircraft", "Duration", "Price"};
    private DefaultTableModel model;


    public FlightGUI() {
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

        JTextField originOptions = new JTextField(10);
        JTextField destination = new JTextField(10);

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
        JComboBox<String> prices = new JComboBox<>(new String[]{"Ordinary", "Comfort", "Business-Class"});

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

        JScrollPane tableScrollPane = new JScrollPane(flightsTable);
        tableScrollPane.setBorder(BorderFactory.createTitledBorder("Available Flights"));
        panel.add(tableScrollPane, BorderLayout.CENTER);
    }

    private void createButtonsPanel() {
        JPanel buttonsPanel = new JPanel();
        JButton searchBtn = new JButton("Search");
        JButton nextBtn = new JButton("Next");
        JButton backBtn = new JButton("Go back");

        searchBtn.addActionListener(this);
        nextBtn.addActionListener(this);
        backBtn.addActionListener(this);

        buttonsPanel.add(searchBtn);
        buttonsPanel.add(nextBtn);
        buttonsPanel.add(backBtn);

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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Go back")) {
            frame.setVisible(false);
            // Assuming there is a LoginGUI class with setFrame method
            LoginGUI login = new LoginGUI();
            login.setFrame(true);
        } else if (e.getActionCommand().equals("Next")) {
            // Assuming there is a SeatGUI class with setFrame method
            SeatGUI seatMap = new SeatGUI();
            seatMap.setFrame(true);
        } else if (e.getActionCommand().equals("Search")) {
            // Add your search logic here
            // For example, update the table with search results
            updateTableWithSearchResults();
        }
    }

    private void updateTableWithSearchResults() {
        // Add logic to update the table with search results
        // For now, adding a dummy row for demonstration purposes
        Object[] row = {"27109", "March 17, 2020 at 2pm", "Mexico", "Boeing 747", "2 hours", "Price"};
        model.addRow(row);
    }

}
