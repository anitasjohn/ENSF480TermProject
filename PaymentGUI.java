package GUI;
import javax.swing.*;

import BookingSystem.Wallet;
import Users.Login;
import Users.PopUp;
import Database.AccessDatabase;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class PaymentGUI extends JFrame {
    Login loggedInUser = LoginGUI.getLogin();
    private JLabel amountLabel;
    private JLabel amount;
    private JLabel cardNumberLabel;
    private JTextField cardNumberTextField;
    private JLabel expiryDateLabel;
    private JTextField expiryDateTextField;
    private JLabel message;

    private JLabel cvcLabel;
    private JTextField cvcTextField;

    private JButton payButton;
    private JCheckBox cancelInsur;  // Added JCheckBox

    public PaymentGUI() {
        // Set the title of the window
        super("Payment Page");

        AccessDatabase db = AccessDatabase.getOnlyInstance();
        db.initializeConnection();
        ArrayList<Wallet> cards = db.fetchWallet();
        for(Wallet card: cards) {
            loggedInUser.setWallet(card);
        }
        
        db.deleteConnection();

        // Create the components
        amountLabel = new JLabel("Amount: ");
        amount = new JLabel(String.valueOf(loggedInUser.getPrice()));
        cardNumberLabel = new JLabel("Card Number:");
        cardNumberTextField = new JTextField(16);
        expiryDateLabel = new JLabel("Expiry Date:");
        expiryDateTextField = new JTextField(5);
        cvcLabel = new JLabel("CVC:");
        cvcTextField = new JTextField(3); // Adjust the size as needed

        message = new JLabel("");

        
        payButton = new JButton("Pay");
        cancelInsur = new JCheckBox("Cancellation Insurance");  // Initialize JCheckBox

        // Set font styles
        Font labelFont = new Font(Font.SANS_SERIF, Font.BOLD, 14);
        Font textFieldFont = new Font(Font.SANS_SERIF, Font.PLAIN, 14);

        amountLabel.setFont(labelFont);
        cardNumberLabel.setFont(labelFont);
        expiryDateLabel.setFont(labelFont);
        cvcLabel.setFont(labelFont);

        amount.setFont(textFieldFont);
        cardNumberTextField.setFont(textFieldFont);
        expiryDateTextField.setFont(textFieldFont);
        cvcTextField.setFont(textFieldFont);

        payButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
        payButton.setForeground(Color.WHITE);
        payButton.setBackground(new Color(58, 130, 255));

        cancelInsur.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));  // Set font for JCheckBox

        // Set the layout of the window
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);

        // Add the components to the window
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(amountLabel, gbc);

        gbc.gridx = 1;
        add(amount, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(cardNumberLabel, gbc);

        gbc.gridx = 1;
        add(cardNumberTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(expiryDateLabel, gbc);

        gbc.gridx = 1;
        add(expiryDateTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(cvcLabel, gbc);

        gbc.gridx = 1;
        add(cvcTextField, gbc);

        // Increment the grid y position for the "Pay" button
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        add(payButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.CENTER;
        add(message, gbc);


        // Add ActionListener to the existing payButton
        payButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cardNumberTextField.getText().equals("") || expiryDateTextField.getText().equals("") || cvcTextField.getText().equals("")) {
                    message.setText("Not a valid card. Please fill in the blanks.");
                } else if(!validPayment(cardNumberTextField.getText(), expiryDateTextField.getText(), cvcTextField.getText(), loggedInUser.getPrice())) {
                    message.setText("Not a valid card or Insufficient Funds.");
                } else {
                    if(loggedInUser.getUser() == "guest") {
                        setVisible(false);
                        PopUp guestWindow = new PopUp();
                        guestWindow.getEmail();
                    } else {
                        setVisible(false);
                        PaymentReceiptGUI pr = new PaymentReceiptGUI();
                        pr.setFrame(true);
                    }
                    
                }
                
            }
        });
    
        //Change this a little later
        cancelInsur.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                int newPrice = Integer.parseInt(amount.getText()) + 50;
                int revertPrice = Integer.parseInt(amount.getText()) - 50;
                // This code will be executed when the state of the checkbox changes
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    amount.setText(String.valueOf(newPrice));
                    loggedInUser.setPrice(newPrice);
                    loggedInUser.setInsured(true);
                } else {
                    amount.setText(String.valueOf(revertPrice));
                    loggedInUser.setPrice(revertPrice);
                    loggedInUser.setInsured(false);
                }
            }
        });

        // Add JCheckBox
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        add(cancelInsur, gbc);

        // Set the size, center, and make the window visible
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void setFrame(boolean b) {
        setVisible(b);
    }

    public boolean validPayment(String cardNumber, String expiration, String cvc, int amount) {
        for(Wallet card: loggedInUser.getWallet()) {
            if(cardNumber.strip().equals(card.getCardNumber().strip()) && expiration.strip().equals(card.getCardExpDate().strip()) && cvc.equals(card.getCardCvc()) && (card.getBalance() > amount)) {
                loggedInUser.setCard(card);
                loggedInUser.getCard().setBalance(loggedInUser.getCard().getBalance() - amount);
                return true;
            } 
        }
        return false;
    }
}
