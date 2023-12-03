package GUI;
import javax.swing.*;

import Database.AccessDatabase;
import Login.UserLogin;
import Users.AirlineAgent;
import Login.AirlineAgentLogin;
import Users.FlightAttendant;
import Login.FlightAttendantLogin;
import Users.Login;
import Users.Users;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;

public class LoginGUI implements ActionListener{
    private static Login requestedLogin;

    //Flight_Attendants, Airline_agents and RegisteredUsers
    ArrayList<FlightAttendant> flight_attendants;    
    ArrayList<AirlineAgent> agents;
    ArrayList<Users> users;

    AccessDatabase db = AccessDatabase.getOnlyInstance();
    //JFrame set up
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JTextField email = new JTextField();
    JPasswordField password = new JPasswordField();
    
    JLabel firstName = new JLabel("Enter First Name");
    JLabel lastName = new JLabel("Enter Last Name");
    JLabel addressLabel = new JLabel("Address");
    JLabel regEmailLabel = new JLabel("Email");
    JLabel regPasswordLabel = new JLabel("Password");

    JTextField name = new JTextField();
    JTextField surname = new JTextField();
    JTextField address = new JTextField();
    JTextField regEmail = new JTextField();
    JPasswordField regPassword = new JPasswordField();

    JLabel message = new JLabel("");


    //These are register and go back options
    JButton signBtn = new JButton("Sign up");

    public static Login getLogin() {
        return requestedLogin;
    }
    public LoginGUI() {
        db.initializeConnection();
        flight_attendants = db.fetchFAs();
        agents = db.fetchAirlineAgents();
        users = db.fetchUsers();
        db.deleteConnection();
        JLabel userLabel = new JLabel("Email");
        JLabel passwordLabel = new JLabel("Password");

       
        //This is to add our login/register buttons
        JButton loginBtn = new JButton("Login");
        JButton registerBtn = new JButton("Register");

        //We will also implement an option for the user to browse as a guest user
        JButton browseBtn = new JButton("Browse as Guest");

        frame.add(panel);
        frame.setTitle("Welcome to our Airline");
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Center the frame on the screen

        //Setting Bounds for Labels
        userLabel.setBounds(50, 20, 80, 25);
        passwordLabel.setBounds(50, 50, 80, 25);
        firstName.setBounds(400, 20, 150, 25);
        lastName.setBounds(400, 50, 150, 25);
        addressLabel.setBounds(400, 80, 150, 25);
        regEmailLabel.setBounds(400, 110, 150, 25);
        regPasswordLabel.setBounds(400, 140, 150, 25);

        //Setting Bounds for Text Fields
        email.setBounds(150, 20, 165, 25);
        password.setBounds(150, 50, 165, 25);
        name.setBounds(570, 20, 165, 25);
        surname.setBounds(570, 50, 165, 25);
        address.setBounds(570, 80, 165, 25);
        regEmail.setBounds(570, 110, 165, 25);
        regPassword.setBounds(570, 140, 165, 25);

        loginBtn.setBounds(50, 80, 80, 25);
        loginBtn.addActionListener(this);
        registerBtn.setBounds(140, 80, 80, 25);
        registerBtn.addActionListener(this);
        browseBtn.setBounds(230, 80, 150, 25);
        browseBtn.addActionListener(this);

        message.setBounds(100, 110, 300, 25);
        panel.add(message);

        panel.setLayout(null);
        panel.add(email);
        panel.add(password);
        panel.add(loginBtn);
        panel.add(registerBtn);
        panel.add(browseBtn);       
        panel.add(userLabel);
        panel.add(passwordLabel);
        frame.setVisible(true);
    }  
    

    //this function is primarily used to track the current user.
    public String typeofuser() {
        String typedEmail = email.getText().strip();
        char[] typedPassword = password.getPassword();

        requestedLogin = new Login(typedEmail, new String(typedPassword));
        
        requestedLogin.setLoginStrategy(new FlightAttendantLogin());
        if(requestedLogin.performStartegy()) {
            return "flight-attendant";
        }
        requestedLogin.setLoginStrategy(new AirlineAgentLogin());
        if(requestedLogin.performStartegy()) {
            return "airline-agent";
        }
        requestedLogin.setLoginStrategy(new UserLogin());
        if(requestedLogin.performStartegy()) {
            return "user";
        }
        
        
     
    //setting the full name of the flight attendant, airline agent and user that is logged in into the Login class
    for (FlightAttendant fa : flight_attendants) {
        if (typedEmail.equals(fa.getFlightAttendantEmail().getEmail().strip()) && Arrays.equals(typedPassword, (fa.getFlightAttendantPasscode()).toCharArray())) {
            requestedLogin.setFName(fa.getName().getFullName());
        }
    }

    for (AirlineAgent aa : agents) {
        if (typedEmail.equals(aa.getAirlineEmail().getEmail().strip()) && Arrays.equals(typedPassword, (aa.getAirlinePassword()).toCharArray())) {
            requestedLogin.setFName(aa.getName().getFullName());
        }
    }

    for (Users user : users) {
        if (typedEmail.equals(user.getUserEmail().strip()) && Arrays.equals(typedPassword, (user.getPassword()).toCharArray())) {
            requestedLogin.setFName(user.getUserName());
        }
    }

    return "";

}

    public void setFrame(boolean b) {
        frame.setVisible(b);
    }

    public void actionPerformed(ActionEvent e) {
        if(((JButton) e.getSource()).getText() == "Login") {
            if(typeofuser() == "admin") {
                requestedLogin.setUser("admin");
                frame.setVisible(false);
                AdminGUI a = new AdminGUI();
                a.setFrame(true);
            } else if(typeofuser() == "airline-agent") {
                requestedLogin.setUser("airline-agent");
                frame.setVisible(false);
                AirlineAgentGUI agentFrame = new AirlineAgentGUI();
                agentFrame.setFrame(true);
            } else if(typeofuser() == "flight-attendant") {
                requestedLogin.setUser("flight-attendant");
                frame.setVisible(false);
                PassengersGUI p = new PassengersGUI();
                p.setFrame(true);
            } else if(typeofuser() == "user") {
                requestedLogin.setUser("user");
                frame.setVisible(false);
                FlightGUI f = new FlightGUI();
                f.setFrame(true);
            } else {
                message.setText("Invalid Login. Please Try again.");
            }
        } else if(((JButton) e.getSource()).getText() == "Register") {
            frame.setVisible(false);
            RegisterGUI registerFrame = new RegisterGUI();
            registerFrame.setFrame(true);
        }  else {
            requestedLogin = new Login(" ", " ");
            requestedLogin.setUser("guest");
            frame.setVisible(false);
            FlightGUI flightFrame = new FlightGUI();
            flightFrame.setFrame(true);
        }
        
    }
}

    

