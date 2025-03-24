import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class WarehouseRestockingGame {

    // Variables to keep track of clicked items
    private static int clickedBananas = 0;
    private static int clickedApples = 0;

    // Random required quantities for bananas and apples
    private static int requiredBananas;
    private static int requiredApples;

    public static void main(String[] args) {
        // Generate random required quantities once at the start
        generateRandomRequirements();

        // Creating the main frame
        JFrame frame = new JFrame("Warehouse Restocking Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new FlowLayout());

        // Set the background color to a nice color (e.g., light blue)
        frame.getContentPane().setBackground(new Color(173, 216, 230));  // Light blue background

        // Create a label to show required quantity
        JLabel orderLabel = new JLabel("Required: " + requiredBananas + " Bananas and " + requiredApples + " Apples");
        orderLabel.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(orderLabel);

        // Load the images
        
        ImageIcon bananaIcon = new ImageIcon("banana.jpg"); 
        ImageIcon appleIcon = new ImageIcon("apple1.jpg"); 

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
        // Check if the user has selected enough items
        if (clickedBananas >= requiredBananas && clickedApples >= requiredApples) {
            JOptionPane.showMessageDialog(null, "Order successfully submitted!");

            // Generate new random required quantities for the next round
            generateRandomRequirements();
            orderLabel.setText("Required: " + requiredBananas + " Bananas and " + requiredApples + " Apples");

        } else {
            JOptionPane.showMessageDialog(null, "You have not selected enough items! Try again.");
        }

        // Reset the counters for bananas and apples after submission
        clickedBananas = 0;
        clickedApples = 0;
    }

    // Method to generate random required quantities for bananas and apples
    private static void generateRandomRequirements() {
        requiredBananas = (int) (Math.random() * 11);  // Random value between 0 and 10
        requiredApples = (int) (Math.random() * 11);   // Random value between 0 and 10
    }
}



