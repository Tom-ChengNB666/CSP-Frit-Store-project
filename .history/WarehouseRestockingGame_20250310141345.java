import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WarehouseRestockingGame {

    // Variables to keep track of clicked items
    private static int clickedBananas = 0;
    private static int clickedApples = 0;
    private static int requiredBananas = 5;  // Adjust this as needed
    private static int requiredApples = 3;   // Adjust this as needed

    public static void main(String[] args) {
        // Creating the main frame
        JFrame frame = new JFrame("Warehouse Restocking Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new FlowLayout());

        // Create a label to show required quantity
        JLabel orderLabel = new JLabel("Required: " + requiredBananas + " Bananas and " + requiredApples + " Apples");
        orderLabel.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(orderLabel);

        // Load the images
        ImageIcon bananaIcon = new ImageIcon("banana.jpg"); // Path to banana.jpg (update with correct path if necessary)
        ImageIcon appleIcon = new ImageIcon("apple.jpg");   // Path to apple.jpg (update with correct path if necessary)

        // Create buttons for Banana and Apple images
        JButton bananaButton = new JButton(bananaIcon);
        JButton appleButton = new JButton(appleIcon);

        // Set action listeners for buttons to handle clicks
        bananaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickedBananas++;
                updateOrderInfo(orderLabel);
            }
        });

        appleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickedApples++;
                updateOrderInfo(orderLabel);
            }
        });

        // Add the buttons to the frame
        frame.add(bananaButton);
        frame.add(appleButton);

        // Create a submit button
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitOrder();
            }
        });

        // Add the submit button to the frame
        frame.add(submitButton);

        // Make the frame visible
        frame.setVisible(true);
    }

    // Method to update the order info displayed
    private static void updateOrderInfo(JLabel orderLabel) {
        orderLabel.setText("You have selected: " + clickedBananas + " Bananas and " + clickedApples + " Apples");
    }

    // Method to handle the submit button click
    private static void submitOrder() {
        if (clickedBananas >= requiredBananas && clickedApples >= requiredApples) {
            JOptionPane.showMessageDialog(null, "Order successfully submitted!");
        } else {
            JOptionPane.showMessageDialog(null, "You have not selected enough items! Try again.");
        }
    }
}
