package banking.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame {
    
    
    JTextField cardTextField;
    JPasswordField pinTextField;

    Login() {
        setTitle("ATM Simulator");
        setLayout(null); 
        
        JLabel title = new JLabel("ATM Simulator System");
        title.setFont(new Font("Osward", Font.BOLD, 30));
        title.setBounds(225, 40, 400, 40);
        add(title);
        
        JLabel cardLabel = new JLabel("Card No:");
        cardLabel.setBounds(250, 150, 100, 30);
        add(cardLabel);

        
        cardTextField = new JTextField();
        cardTextField.setBounds(330, 150, 200, 30);
        add(cardTextField);

        JLabel pinLabel = new JLabel("PIN:");
        pinLabel.setBounds(250, 200, 100, 30);
        add(pinLabel);

        
        pinTextField = new JPasswordField();
        pinTextField.setBounds(330, 200, 200, 30);
        add(pinTextField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(330, 260, 100, 30);
        add(loginButton);        
        
        
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                authenticateUser(); 
            }
        });
        
        setSize(800, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true); 
    }
    
    
    private void authenticateUser() {
        // hard coded credentials
        String validCardNumber = "1"; 
        String validPin = "1";
        
        String enteredCard = cardTextField.getText();
        String enteredPin = new String(pinTextField.getPassword());
        
        if(enteredCard.isBlank() || enteredPin.isBlank())  {
            JOptionPane.showMessageDialog(this, 
                "Fill out Fields", 
                "Authentication Failed", 
                JOptionPane.ERROR_MESSAGE);
        }
        
        else if (enteredCard.equals(validCardNumber) && enteredPin.equals(validPin)) {
            
            //opens account screen
            new Account();
            setVisible(false);
            
        } else {
            
            JOptionPane.showMessageDialog(this, 
                "Invalid Card Number or PIN. Please try again.", 
                "Authentication Failed", 
                JOptionPane.ERROR_MESSAGE);
                
            //clear after error
            cardTextField.setText("");
            pinTextField.setText("");
            cardTextField.requestFocus();
        }
    }
    
    public static void main(String[] args) {
        new Login();
    }
}