package GUI;
import javax.swing.*;

import Database.AccessDatabase;
import Users.Email;
import Users.Name;
import Users.Users;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RegisterGUI implements ActionListener{
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();

    JTextField name = new JTextField();
    JTextField surname = new JTextField();
    JTextField address = new JTextField();
    JTextField email = new JTextField();
    JPasswordField password = new JPasswordField();
    AccessDatabase db = AccessDatabase.getOnlyInstance();
    ArrayList<Users> registered = new ArrayList<Users>();
    JLabel message = new JLabel(" ");



    public RegisterGUI() {
        db.initializeConnection();
        registered = db.fetchUsers();
        JLabel firstName = new JLabel("Enter First Name");
        JLabel lastName = new JLabel("Enter Last Name");
        JLabel addressLabel = new JLabel("Address");
        JLabel userLabel = new JLabel("Email");
        JLabel passwordLabel = new JLabel("Password");
        message.setBounds(200, 225, 300, 25);
        
        //These are register and go back options
        JButton signBtn = new JButton("Sign up");
        JButton returnBtn = new JButton("Go back");

        frame.add(panel);
        frame.setTitle("Excited to Register!");
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Center the frame on the screen

        //sets the positioning and size of the labels
        firstName.setBounds(50, 20, 150, 25);
        lastName.setBounds(50, 50, 150, 25);
        addressLabel.setBounds(50, 80, 150, 25);
        userLabel.setBounds(50, 110, 150, 25);
        passwordLabel.setBounds(50, 140, 150, 25);

        //sets the positioning and size of the text fields
        name.setBounds(220, 20, 165, 25);
        surname.setBounds(220, 50, 165, 25);
        address.setBounds(220, 80, 165, 25);
        email.setBounds(220, 110, 165, 25);
        password.setBounds(220, 140, 165, 25);

        signBtn.setBounds(200, 180, 80, 25);
        signBtn.addActionListener(this);
        returnBtn.setBounds(300, 180, 80, 25);
        returnBtn.addActionListener(this);

        panel.setLayout(null);
        panel.add(firstName);
        panel.add(lastName);
        panel.add(addressLabel);
        panel.add(userLabel);
        panel.add(passwordLabel);

        panel.add(name);
        panel.add(surname);
        panel.add(address);
        panel.add(email);
        panel.add(password);

        panel.add(signBtn);
        panel.add(returnBtn);
        panel.add(message);
        frame.setVisible(true);
    }  

    public void setFrame(boolean b) {
        frame.setVisible(b);
    }

    public void actionPerformed(ActionEvent e) {
        boolean canRegister = true;
        // TODO Auto-generated method stub
        if(((JButton) e.getSource()).getText() == "Sign up") {

            for(Users user: registered) {
                //if(user.getUserName().strip().equals((name.getText() + " " + surname.getText()).strip())) {
                if(user.getUserEmail().strip().equals((email.getText()).strip())) {
                    message.setText("User is already registered.");
                    canRegister = false;
                    break;
                }
            }
            if(name.getText().equals("") || surname.getText().equals("") || address.getText().equals("") || email.getText().equals("") || password.getPassword().equals("")) {
                message.setText("Invalid Registration. Please fill in the blanks.");
                canRegister = false;
            } 

            if(canRegister) {
                message.setText("User is successfully registered.");
                db.insertNewUser(new Name(name.getText(), surname.getText()), new Email(email.getText()), new String(password.getPassword()), address.getText());
            }

            
            //fill this with a label message
        } else if(((JButton) e.getSource()).getText() == "Go back") {
            frame.setVisible(false);
            LoginGUI login = new LoginGUI();
            login.setFrame(true);
        }  
        
    }
};

    

