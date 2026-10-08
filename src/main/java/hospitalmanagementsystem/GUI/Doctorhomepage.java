/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalmanagementsystem.GUI;

import java.awt.Font;
import javax.swing.*;

/**
 *
 * @author Mikeyks
 */
public class Doctorhomepage extends JFrame{
    private JLabel greeting, docname, docspec, patientlist, DocID;
    
    Doctorhomepage() {
        setSize(870, 500);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(this);
        
        greeting = new JLabel("Hello, Welcome,");
        greeting.setBounds(10, 5, 280, 50);
        greeting.setFont(new Font("Western", Font.PLAIN, 20));
        add(greeting);
        
        docname = new JLabel("Dr. [name]");
        docname.setBounds(157, 5, 280, 50);
        docname.setFont(new Font("Western", Font.PLAIN, 20));
        add(docname);
        
        docspec = new JLabel();
        docspec.setBounds(20, 5, 280, 50);
        docspec.setFont(new Font("Western", Font.PLAIN, 20));
        add(docspec);
    }
}
