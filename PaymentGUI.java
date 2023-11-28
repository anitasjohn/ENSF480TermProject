import javax.swing.*;
import java.awt.*;

public class PaymentGUI extends JFrame {
    private JLabel amountLabel;
    private JTextField amountTextField;
    private JLabel cardNumberLabel;
    private JTextField cardNumberTextField;
    private JLabel expiryDateLabel;
    private JTextField expiryDateTextField;
    private JButton payButton;

    public PaymentGUI() {
        // Set the title of the window
        super("Payment Page");

        // Create the components
        amountLabel = new JLabel("Amount:");
        amountTextField = new JTextField(10);
        cardNumberLabel = new JLabel("Card Number:");
        cardNumberTextField = new JTextField(16);
        expiryDateLabel = new JLabel("Expiry Date:");
        expiryDateTextField = new JTextField(5);
        payButton = new JButton("Pay");

        // Set font styles
        Font labelFont = new Font(Font.SANS_SERIF, Font.BOLD, 14);
        Font textFieldFont = new Font(Font.SANS_SERIF, Font.PLAIN, 14);

        amountLabel.setFont(labelFont);
        cardNumberLabel.setFont(labelFont);
        expiryDateLabel.setFont(labelFont);

        amountTextField.setFont(textFieldFont);
        cardNumberTextField.setFont(textFieldFont);
        expiryDateTextField.setFont(textFieldFont);

        payButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
        payButton.setForeground(Color.WHITE);
        payButton.setBackground(new Color(58, 130, 255));

        // Set the layout of the window
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);

        // Add the components to the window
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(amountLabel, gbc);

        gbc.gridx = 1;
        add(amountTextField, gbc);

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

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        add(payButton, gbc);

        // Set the size, center, and make the window visible
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
