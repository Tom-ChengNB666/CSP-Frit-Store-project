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

        frame.getContentPane().setBackground(new Color(173, 216, 230));  // Light blue background

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

    // 🔄 更新用户当前点击了多少水果
    private static void updateOrderInfo(JLabel selectionLabel) {
        selectionLabel.setText("You have selected: " + clickedBananas + " Bananas and " + clickedApples + " Apples");
    }

    private static void submitOrder(JLabel requirementLabel, JLabel selectionLabel) {
        if (validateOrder()) {
            JOptionPane.showMessageDialog(null, "Order successfully submitted!");
    
            generateRandomRequirements();
            requirementLabel.setText("Required: " + requiredBananas + " Bananas and " + requiredApples + " Apples");
        } else {
            JOptionPane.showMessageDialog(null, "You have not selected enough items! Try again.");
        }
    
        // ✅ 清零
        clickedBananas = 0;
        clickedApples = 0;

        updateOrderInfo(selectionLabel);
    }
    

    // ✅ AP Submission 用的 student-developed function
    public static boolean validateOrder() {
        int[] required = {requiredBananas, requiredApples};
        int[] selected = {clickedBananas, clickedApples};

        for (int i = 0; i < required.length; i++) {
            if (selected[i] < required[i]) {
                return false;  // 任意一个没达到数量就返回 false
            }
        }
        return true;  // 全部达到就返回 true
    }

    private static void generateRandomRequirements() {
        requiredBananas = (int) (Math.random() * 11);  // 0~10
        requiredApples = (int) (Math.random() * 11);
    }
}




