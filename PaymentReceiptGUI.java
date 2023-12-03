package GUI;
import javax.swing.*;

import BookingSystem.Flight;
import BookingSystem.Ticket;
import Database.AccessDatabase;
import Users.Login;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentReceiptGUI extends JFrame {
    Login loggedIn = LoginGUI.getLogin();
    AccessDatabase db;
    private JLabel ticketNumberLabel;
    private JLabel userLabel;
    private JTextField userTextField;
    private JButton returnBtn;
    private JButton cancelButton;
    private JTextArea receiptTextArea;


    int ticketNumber;

    public PaymentReceiptGUI() {
        // Set the title of the window
        super("Payment Receipt");
        db = AccessDatabase.getOnlyInstance();
        db.initializeConnection();

        db.updateBalance(loggedIn.getCard().getCardNumber(), loggedIn.getCard().getBalance());
        
        //Creates the ticket and adds it to the database
        if(loggedIn.getUser() != "guest") {
            loggedIn.setTicket(new Ticket(new Flight(loggedIn.getDeparture(), loggedIn.getDestination(), loggedIn.getDeptAirport(), loggedIn.getDestAirport(), loggedIn.getDuration(), loggedIn.getFlight(), loggedIn.getFlightTime(), loggedIn.getPrice()), loggedIn.getFName(), loggedIn.getSeat(), loggedIn.getInsured()));
        } {
            loggedIn.setTicket(new Ticket(new Flight(loggedIn.getDeparture(), loggedIn.getDestination(), loggedIn.getDeptAirport(), loggedIn.getDestAirport(), loggedIn.getDuration(), loggedIn.getFlight(), loggedIn.getFlightTime(), loggedIn.getPrice()), loggedIn.getEmail(), loggedIn.getSeat(), loggedIn.getInsured()));
        }

        db.insertNewTicket(loggedIn.getTicket().getFlight().getFlightNumber(), loggedIn.getTicket().getName(), Integer.parseInt(loggedIn.getTicket().getSeatNum()), loggedIn.getTicket().checkInsurance());

        //This will add the ticket to the array of tickets.
        loggedIn.setTickets(loggedIn.getTicket());
        ticketNumber = db.fetchTicketNumber(loggedIn.getTicket().getFlight().getFlightNumber(), loggedIn.getTicket().getName(), Integer.parseInt(loggedIn.getTicket().getSeatNum()));
        // Create the components
        ticketNumberLabel = new JLabel("Ticket Number: #" + ticketNumber);
        userLabel = new JLabel("Enter your Ticket Number:");
        userTextField = new JTextField(10);
        returnBtn = new JButton("Return to Homepage");
        cancelButton = new JButton("Cancel Flight");
        receiptTextArea = new JTextArea(10, 30);
        receiptTextArea.setText("Ticket has been successfully purchased. Ticket for Flight " + loggedIn.getFlight() + " and was sent to " + loggedIn.getEmail() + ". Your Seat Number is " + loggedIn.getSeat() + ". Press cancel flight if you would like to cancel.");

        // Set font styles
        Font labelFont = new Font(Font.SANS_SERIF, Font.BOLD, 14);
        Font textFieldFont = new Font(Font.SANS_SERIF, Font.PLAIN, 14);

        ticketNumberLabel.setFont(labelFont);

        returnBtn.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
        cancelButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));

        receiptTextArea.setEditable(false);

        // Set the layout of the window
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);

        // Add the components to the window
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(ticketNumberLabel, gbc);

        gbc.gridx = 1;

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        add(returnBtn, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        add(cancelButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(receiptTextArea, gbc);

        // Add ActionListener to the payButton
        returnBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Payment processing logic
                setVisible(false);
                loggedIn.setFName("");
                LoginGUI login = new LoginGUI();
                login.setFrame(true);
            }
        });

        // Add ActionListener to the cancelButton
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform cancellation logic here
                db.deleteTicket(loggedIn.getTicket().getFlight(), loggedIn.getTicket().getSeatNum(), loggedIn.getTicket().getName());

                //prints out a cancellation message
                String cancellationMessage = cancelFlight();
                receiptTextArea.setText(cancellationMessage);
            }
        });

        // Set the size, center, and make the window visible
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void setFrame(boolean b) {
        setVisible(b);
    }

    private String cancelFlight() {
        // Implement your flight cancellation logic here
        if(loggedIn.getInsured()) {
            db.updateBalance(loggedIn.getCard().getCardNumber(), loggedIn.getCard().getBalance() + loggedIn.getPrice());
            return "Thanking for using our Airline. An amount of " + loggedIn.getPrice() + " dollars has been refunded to your account.";
        } else {
            return "Sorry you had to cancel. Unfortunately, our airline will not refund you the full amount of " + loggedIn.getPrice() + " dollars.";
        }
        //remove ticket from tickets
    }
}
