package com.ims;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TextEditor extends JFrame implements ActionListener {
    
    JTextArea textArea;
    
    public TextEditor(){
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("IMS - Inventory Management System");
        this.setSize(555, 555);
        this.setLayout(new FlowLayout());
        this.setLocationRelativeTo(null);
        
        textArea = new JTextArea();
        this.add(textArea);
        textArea.setPreferredSize(new Dimension(444, 444));
        
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {}
}