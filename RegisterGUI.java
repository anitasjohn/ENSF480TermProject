import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterGUI implements ActionListener{
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    public RegisterGUI() {
        JLabel firstName = new JLabel("Enter First Name");
        JLabel lastName = new JLabel("Enter Last Name");
        JLabel addressLabel = new JLabel("Address");
        JLabel userLabel = new JLabel("Email");
        JLabel passwordLabel = new JLabel("Password");

        JTextField name = new JTextField();
        JTextField surname = new JTextField();
        JTextField address = new JTextField();
        JTextField email = new JTextField();
        JPasswordField password = new JPasswordField();

        //These are register and go back options
        JButton signBtn = new JButton("Sign up");
        JButton returnBtn = new JButton("Go back");

        frame.add(panel);
        frame.setTitle("Excited to Register!");
        frame.setSize(1650,1080);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        frame.setVisible(true);
    }  

    public void setFrame(boolean b) {
        frame.setVisible(b);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(((JButton) e.getSource()).getText() == "Sign up") {
            System.out.println("Sign user up");
            //fill this with a label message
        } else if(((JButton) e.getSource()).getText() == "Go back") {
            frame.setVisible(false);
            LoginGUI login = new LoginGUI();
            login.setFrame(true);
        }  
        
    }
};

    

