import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class WarehouseRestockingGame {

    private static int clickedBananas = 0;
    private static int clickedApples = 0;

    private static int requiredBananas;
    private static int requiredApples;

    public static void main(String[] args) {
        generateRandomRequirements();

        JFrame frame = new JFrame("Warehouse Restocking Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new FlowLayout());

        frame.getContentPane().setBackground(new Color(173, 216, 230));

        JLabel requirementLabel = new JLabel("Required: " + requiredBananas + " Bananas and " + requiredApples + " Apples");
        requirementLabel.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(requirementLabel);

        JLabel selectionLabel = new JLabel("You have selected: " + clickedBananas + " Bananas and " + clickedApples + " Apples");
        selectionLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        frame.add(selectionLabel);

        ImageIcon bananaIcon = new ImageIcon("banana.jpg");
        ImageIcon appleIcon = new ImageIcon("RedApple.png");

        JButton bananaButton = new JButton(bananaIcon);
        JButton appleButton = new JButton(appleIcon);

        bananaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickedBananas++;
                updateOrderInfo(selectionLabel);
            }
        });

        appleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickedApples++;
                updateOrderInfo(selectionLabel);
            }
        });

        frame.add(bananaButton);
        frame.add(appleButton);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitOrder(requirementLabel, selectionLabel);
            }
        });

        frame.add(submitButton);

        frame.setVisible(true);
    }

    private static void updateOrderInfo(JLabel selectionLabel) {
        selectionLabel.setText("You have selected: " + clickedBananas + " Bananas and " + clickedApples + " Apples");
    }

    private static void submitOrder(JLabel requirementLabel, JLabel selectionLabel) {
        int[] selected = {clickedBananas, clickedApples};  // ✅ 参数列表
        if (validateOrderWithList(selected)) {
            JOptionPane.showMessageDialog(null, "Order successfully submitted!");
            generateRandomRequirements();
            requirementLabel.setText("Required: " + requiredBananas + " Bananas and " + requiredApples + " Apples");
        } else {
            JOptionPane.showMessageDialog(null, "You have not selected enough items! Try again.");
        }

        clickedBananas = 0;
        clickedApples = 0;
        updateOrderInfo(selectionLabel);
    }

    // ✅ Student-developed procedure with loop + selection + parameter + list
    public static boolean validateOrderWithList(int[] selectedItems) {
        int[] requiredItems = {requiredBananas, requiredApples};

        for (int i = 0; i < requiredItems.length; i++) {
            if (selectedItems[i] < requiredItems[i]) {
                return false;
            }
        }
        return true;
    }

    private static void generateRandomRequirements() {
        requiredBananas = (int) (Math.random() * 11);  // 0~10
        requiredApples = (int) (Math.random() * 11);
    }
}





