import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI implements ActionListener{
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

    //These are register and go back options
    JButton signBtn = new JButton("Sign up");

    public LoginGUI() {
        
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

        panel.setLayout(null);
        panel.add(email);
        panel.add(password);
        panel.add(loginBtn);
        panel.add(registerBtn);
        panel.add(browseBtn);       
        panel.add(userLabel);
        panel.add(passwordLabel);
        /*
        panel.add(firstName);
        panel.add(lastName);
        panel.add(addressLabel);
        panel.add(regEmailLabel);
        panel.add(regPasswordLabel);
    
        panel.add(name);
        panel.add(surname);
        panel.add(address);
        panel.add(regEmail);
        panel.add(regPassword);
        */
        frame.setVisible(true);
    }  
    

    //this function is primarily used to track the current user.
    public String typeofuser() {
        String typedEmail = email.getText();
        if(typedEmail.contains("admin")) {
            return "admin";
        } else if(typedEmail.contains("airline")) {
            return "airline-agent";
        } else if(typedEmail.contains("flight")) {
            return "flight-attendant";
        }else if(typedEmail.contains("user")) {
            return "user";
        }
        else {
            return "";
        }
    }

    public void setFrame(boolean b) {
        frame.setVisible(b);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(((JButton) e.getSource()).getText() == "Login") {
            if(typeofuser() == "admin") {
                frame.setVisible(false);
                AdminGUI a = new AdminGUI();
                a.setFrame(true);
            } else if(typeofuser() == "airline-agent") { 
                frame.setVisible(false);
                AirlineAgentGUI agentFrame = new AirlineAgentGUI();
                agentFrame.setFrame(true);
            } else if(typeofuser() == "flight-attendant") {
                frame.setVisible(false);
                PassengersGUI p = new PassengersGUI();
                p.setFrame(true);
            } else if(typeofuser() == "user") {
                frame.setVisible(false);
                FlightGUI f = new FlightGUI();
                f.setFrame(true);
            }

        } else if(((JButton) e.getSource()).getText() == "Register") {
            frame.setVisible(false);
            RegisterGUI registerFrame = new RegisterGUI();
            registerFrame.setFrame(true);
        }  else {
            frame.setVisible(false);
            FlightGUI flightFrame = new FlightGUI();
            flightFrame.setFrame(true);
        }
        
    }
};

    

