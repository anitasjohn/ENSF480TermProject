import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeatGUI implements ActionListener{
    private JFrame frame;
    private JPanel seatPanel;
    private JButton[][] seats;
    private JLabel selectedSeatLabel;

    public SeatGUI() {
        frame = new JFrame("Seat Map");
        frame.setSize(500, 500);

    
        
        seatPanel = new JPanel(new GridLayout(5, 5, 5, 5)); // 5x5 grid for simplicity
        seats = new JButton[5][5];

        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                seats[row][col] = new JButton("Seat " + (row * 5 + col + 1));
                seats[row][col].addActionListener(this);
                seatPanel.add(seats[row][col]);
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
            frame.setVisible(false);
            PaymentGUI pg = new PaymentGUI();
            pg.setFrame(true);
        } else {
            JButton clickedSeat = (JButton) e.getSource();
            selectedSeatLabel.setText("Selected Seat: " + clickedSeat.getText());
        }
        
    
    }
    

    public void setFrame(boolean b) {
        frame.setVisible(b);
    }
    
}
