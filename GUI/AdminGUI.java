package GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AdminGUI implements ActionListener {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    public AdminGUI() {
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null); // Center the frame on the screen

        JButton flightsBtn = new JButton("Modify Flights");
        JButton crewsBtn = new JButton("Modify Crews");
        JButton acBtn = new JButton("Modify Aircrafts");
        JButton goBackBtn = new JButton("Go back");
        flightsBtn.addActionListener(this);
        crewsBtn.addActionListener(this);
        acBtn.addActionListener(this);
        goBackBtn.addActionListener(this);

        flightsBtn.setBounds(10, 10, 80, 25);
        crewsBtn.setBounds(10, 50, 80, 25);
        acBtn.setBounds(10, 90, 80, 25);
        frame.add(panel);
        panel.add(flightsBtn);
        panel.add(crewsBtn);
        panel.add(acBtn);
        panel.add(goBackBtn);

        frame.setVisible(true);
    }

    public void setFrame(boolean b) {
        frame.setVisible(b);
    }

    public void actionPerformed(ActionEvent e) {
        if(((JButton) e.getSource()).getText() == "Go back") {
            frame.setVisible(false);
            //LoginGUI login = new LoginGUI();
            //login.setFrame(true);
        } else if(((JButton) e.getSource()).getText() == "Modify Flights") {
            //To modify flights
            System.out.println("Admin wants to modify flights");
        } else if(((JButton) e.getSource()).getText() == "Modify Crews") {
            //To modify crews
            System.out.println("Admin wants to modify crews");
        } else if(((JButton) e.getSource()).getText() == "Modify Aircrafts") {
            //To modify aircrafts
            System.out.println("Admin wants to modify aircrafts");
        }
    }
}
