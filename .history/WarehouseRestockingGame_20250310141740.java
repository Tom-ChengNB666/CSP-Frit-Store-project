import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WarehouseRestockingGame {

    // Variables to keep track of clicked items
    private static int clickedBananas = 0;
    private static int clickedApples = 0;

    public static void main(String[] args) {
        // Creating the main frame
        JFrame frame = new JFrame("Warehouse Restocking Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new FlowLayout());

        // Set the background color to a nice color (e.g., light blue)
        frame.getContentPane().setBackground(new Color(173, 216, 230));  // Light blue background

        // Create a label to show required quantity
        JLabel orderLabel = new JLabel("Required: 0 Bananas and 0 Apples");
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
                submitOrder(orderLabel);
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
    private static void submitOrder(JLabel orderLabel) {
        // Generate random required quantities on each submit
        int requiredBananas = (int) (Math.random() * 11);  // Random value between 0 and 10
        int requiredApples = (int) (Math.random() * 11);   // Random value between 0 and 10

        // Display the new required quantities
        orderLabel.setText("Required: " + requiredBananas + " Bananas and " + requiredApples + " Apples");

        // Check if the user has selected enough items
        if (clickedBananas >= requiredBananas && clickedApples >= requiredApples) {
            JOptionPane.showMessageDialog(null, "Order successfully submitted!");
        } else {
            JOptionPane.showMessageDialog(null, "You have not selected enough items! Try again.");
        }

        // Reset the counters for bananas and apples after submission
        clickedBananas = 0;
        clickedApples = 0;
    }
}


