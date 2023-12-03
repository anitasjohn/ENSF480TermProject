package Users;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import GUI.LoginGUI;
import GUI.PaymentGUI;
import GUI.PaymentReceiptGUI;


public class PopUp {
    Login loggedIn = LoginGUI.getLogin();
     public void getEmail() {
        JTextField emailField = new JTextField();
        Object[] message = {"Enter your email:", emailField};

        int option = JOptionPane.showOptionDialog(
                null,
                message,
                "Email Input",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,   // Set the icon to null
                null,
                null);

        if (option == JOptionPane.OK_OPTION) {
            String email = emailField.getText();
            if (!email.isEmpty()) {
                loggedIn.setEmail(email);
                PaymentReceiptGUI prg = new PaymentReceiptGUI();
                prg.setFrame(true);
            } else {
                PaymentGUI pg = new PaymentGUI();
                pg.setFrame(true);
            }
        } else {
            PaymentGUI pg = new PaymentGUI();
            pg.setFrame(true);
        }
    }
}
