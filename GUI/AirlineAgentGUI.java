package GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AirlineAgentGUI implements ActionListener {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    public AirlineAgentGUI() {
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null); // Center the frame on the screen

        JButton button1 = new JButton("View Passengers");
        JButton button2 = new JButton("Book a Flight");
        JButton goBackBtn = new JButton("Go back");
        button1.addActionListener(this);
        button2.addActionListener(this);
        goBackBtn.addActionListener(this);

        button1.setBounds(10, 10, 80, 25);
        button2.setBounds(10, 50, 80, 25);
        goBackBtn.setBounds(10, 90, 80, 25);
        frame.add(panel);
        panel.add(button1);
        panel.add(button2);
        panel.add(goBackBtn);

        frame.setVisible(true);
    }

    public void setFrame(boolean b) {
        frame.setVisible(b);
    }

    public void actionPerformed(ActionEvent e) {
        if(((JButton) e.getSource()).getText() == "Go back") {
            frame.setVisible(false);
            LoginGUI login = new LoginGUI();
            login.setFrame(true);
        } else if(((JButton) e.getSource()).getText() == "View Passengers") {
            //for view passengers
            frame.setVisible(false);
            PassengersGUI p = new PassengersGUI();
            p.setFrame(true);
        } else if(((JButton) e.getSource()).getText() == "Book a Flight") {
            //to browse flights
            frame.setVisible(false);
            FlightGUI f = new FlightGUI();
            f.setFrame(true);
        }
    }
}
