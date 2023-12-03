package GUI;
import javax.swing.*;

import BookingSystem.Seat;
import BookingSystem.Seatmap;
import Database.AccessDatabase;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//incorporate seats and seat map
public class SeatGUI implements ActionListener{
    private JFrame frame;
    private JPanel seatPanel;
    private JButton[][] seats;
    private JLabel selectedSeatLabel;
    AccessDatabase db;

    boolean seatSelected = false;

    public SeatGUI() {
        int flightNum = LoginGUI.getLogin().getFlight();
        String typeOfSeat = LoginGUI.getLogin().getTypeOfSeat();
        ArrayList<Seat> bookedFlights = new ArrayList<Seat>();
        db = AccessDatabase.getOnlyInstance();
        db.initializeConnection();

        bookedFlights = db.fetchSeats(flightNum);
        db.deleteConnection();
        Seatmap seatmap = new Seatmap();

        ArrayList<Seat> typeOfSeats = new ArrayList<Seat>();
        frame = new JFrame("Seat Map");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 

        
        if(typeOfSeat == "Business") {
            typeOfSeats = seatmap.getBusiness();
        } else if(typeOfSeat == "Comfort") {
            typeOfSeats = seatmap.getComfort();
        } else {
            typeOfSeats = seatmap.getOrdinary();
        }

        seatPanel = new JPanel(new GridLayout(10, 5, 5, 5)); // 5x5 grid for simplicity
        seats = new JButton[10][5];

        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 5; col++) {
                int index = (row * 5 + col + 1) - 1;
                if(index <= typeOfSeats.size() -1) {
                    seats[row][col] = new JButton("Seat: " + typeOfSeats.get(index).getSeatNumber());
                    seats[row][col].addActionListener(this);
                    seatPanel.add(seats[row][col]);

                    //check if the seat is already booked by the user
                    for(Seat seat: bookedFlights) {                        
                        if(typeOfSeats.get(index).getSeatNumber().strip().equals(seat.getSeatNumber().strip())) {
                            seats[row][col].setText("Selected Seat");
                            seats[row][col].setEnabled(false);
                            break;
                        }
                    }
                } else {
                    break;
                }
            }
        }

        selectedSeatLabel = new JLabel("Selected Seat: None");
        frame.setLayout(new BorderLayout());
        frame.add(seatPanel, BorderLayout.CENTER);
        frame.add(selectedSeatLabel, BorderLayout.SOUTH);

        frame.setVisible(true);

        JButton paymentBtn = new JButton("Continue to Checkout");
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.add(paymentBtn);
        paymentBtn.addActionListener(this);
        frame.add(bottomPanel, BorderLayout.SOUTH);
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(((JButton) e.getSource()).getText() == "Continue to Checkout") {
            if(seatSelected) {
                frame.setVisible(false);
                PaymentGUI pg = new PaymentGUI();
                pg.setFrame(true);
            }
        } else {
            JButton clickedSeat = (JButton) e.getSource();
            selectedSeatLabel.setText("Selected Seat: " + clickedSeat.getText());
            LoginGUI.getLogin().setSeat(clickedSeat.getText().split(" ")[1].strip());
            seatSelected = true;
        }
        
    
    }

    public void setFrame(boolean b) {
        frame.setVisible(b);
    }
    
}
