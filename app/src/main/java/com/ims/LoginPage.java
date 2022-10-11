package com.ims;

import com.ims.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class LoginPage implements ActionListener {
    
    String[][] credpair;
    
    JFrame frame = new JFrame();
    JButton loginBtn = new JButton("Login");
    JButton resetBtn = new JButton("Reset");
    
    JTextField usernameField = new JTextField();
    JPasswordField passwdField = new JPasswordField();
    
    JLabel usernameLabel = new JLabel("Username");
    JLabel passwdLabel = new JLabel("Password");
    JLabel msgLabel = new JLabel();
    
    public LoginPage(String[][] credentialsOg){
        credpair = credentialsOg;
        
        usernameLabel.setBounds(55, 55, 75, 25);
        passwdLabel.setBounds(55, 111, 75, 25);
        msgLabel.setBounds(111, 255, 255, 40);
        usernameField.setBounds(127, 55, 211, 40);
        passwdField.setBounds(127, 111, 211, 40);
        
        loginBtn.setBounds(131, 199, 111, 25);
        resetBtn.setBounds(233, 199, 111, 25);
        
        loginBtn.addActionListener(this);
        resetBtn.addActionListener(this);
        loginBtn.setFocusable(false);
        resetBtn.setFocusable(false);
        
        msgLabel.setFont(new Font(null, Font.ITALIC, 31));
        
        frame.add(usernameLabel);
        frame.add(passwdLabel);
        frame.add(msgLabel);
        frame.add(usernameField);
        frame.add(passwdField);
        frame.add(loginBtn);
        frame.add(resetBtn);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(444, 333);
        frame.setTitle("HIMES - Login");
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        
        
        
        
        frame.setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        if (e.getSource() == resetBtn) {
            usernameField.setText("");
            passwdField.setText("");
        }
        
        if (e.getSource() == loginBtn) {
            String usernameID = usernameField.getText();
            String passwdID = String.valueOf(passwdField.getPassword());
            
            try {
                if (credpair[0][0].equals(usernameID) || credpair[1][0].equals(usernameID)) {
                    if (credpair[1][0].equals(Encryption.toHash(passwdID)) || credpair[1][1].equals(Encryption.toHash(passwdID))) {
                        usernameField.setText("");
                        passwdField.setText("");
                        
                        JOptionPane.showMessageDialog(
                            null, 
                            "You are now login as Admin :>", 
                            "Login Successful",
                            JOptionPane.INFORMATION_MESSAGE
                        );
                            
                    }else{
                        usernameField.setText("");
                        passwdField.setText("");
                        
                        JOptionPane.showMessageDialog(
                            null, 
                            "Invalid Password!", 
                            "Login Failed",
                            JOptionPane.ERROR_MESSAGE
                        );
                    }
                }
                else if (usernameID.equals("") && passwdID.equals("")) {
                    usernameField.setText("");
                    passwdField.setText("");
            
                    JOptionPane.showMessageDialog(
                            null, 
                            "Input your username and password.", 
                            "No Input Provided",
                            JOptionPane.INFORMATION_MESSAGE
                        );
                }else{
                    usernameField.setText("");
                    passwdField.setText("");
                    
                    JOptionPane.showMessageDialog(
                            null, 
                            "Invalid Username!", 
                            "Login Failed",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            } catch (Exception ex){};
        }
    }
}
