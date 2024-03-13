package Login;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import Login.UserDAO;

public class Registration_page implements ActionListener {
    JFrame frame = new JFrame("Registration Page");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JPasswordField confirmPasswordField = new JPasswordField(); 

    // Buttons
    JButton registerButton = new JButton("Register");
    JButton resetButton = new JButton("Reset");

    // Labels
    JLabel userIDLabel = new JLabel("Enter new userID:");
    JLabel userPasswordLabel = new JLabel("Password:");
    JLabel confirmPasswordLabel = new JLabel("Confirm pw:");
    JLabel messageLabel = new JLabel();

    HashMap<String, String> logininfo = new HashMap<String, String>();

    public Registration_page() {
        frame.setLayout(null);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  
        userIDLabel.setBounds(50, 100, 100, 25);
        userPasswordLabel.setBounds(50, 150, 100, 25);
        confirmPasswordLabel.setBounds(50, 200, 120, 25);
        userIDField.setBounds(150, 100, 200, 25);
        userPasswordField.setBounds(150, 150, 200, 25);
        confirmPasswordField.setBounds(150, 200, 200, 25); 
        registerButton.setBounds(150, 250, 100, 25);
        resetButton.setBounds(250, 250, 100, 25);
        messageLabel.setBounds(50, 250, 300, 25);

        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(confirmPasswordLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(confirmPasswordField);
        frame.add(registerButton);
        frame.add(resetButton);
        frame.add(messageLabel);

        registerButton.addActionListener(this);
        resetButton.addActionListener(this);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == resetButton) {
            userIDField.setText("");
            userPasswordField.setText("");
            confirmPasswordField.setText("");
            
        } else if (e.getSource() == registerButton) {
            String username = userIDField.getText();
            String password = new String(userPasswordField.getPassword());
            String confirmPassword = new String(confirmPasswordField.getPassword());
          

            if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(null, "Passwords do not match!");
                return;
            }

            User user = new User(username, password);
            UserDAO userDAO = new UserDAO();
            if (userDAO.insertUser(user)) {
                JOptionPane.showMessageDialog(null, "Registration successful!");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to register user!");
            }
        }
    }  

    

    public static void main(String[] args) {
        Registration_page registrationForm = new Registration_page();
    }
}
