/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalmanagementsystem.GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mikeyks
 */
public class Appointmenttab extends JFrame implements ActionListener {
    private JLabel title, seeappt, search;
    private JTextField searchF;
    private DefaultTableModel sched;
    private JButton btnsrch, btnback;
    private DefaultListModel<String> src;
    private LinkedList<String> srchlst;
    
    Appointmenttab() {
        setSize(870, 500);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(this);
        
        title = new JLabel("Welcome!");
        title.setBounds(10, 5, 280, 50);
        title.setFont(new Font("Western", Font.PLAIN, 20));
        add(title);
        
        seeappt = new JLabel("see appointments here: ");
        seeappt.setBounds(10, 30, 280, 50);
        seeappt.setFont(new Font("Western", Font.PLAIN, 16));
        add(seeappt);
        
        search = new JLabel("Search Appointments");
        search.setBounds(10, 57, 200, 50);
        search.setFont(new Font("Western", Font.PLAIN, 14));
        add(search);
        
         searchF = new JTextField();
        searchF.setBounds(150, 74, 200, 20);
        searchF.setFont(new Font("Western", Font.PLAIN, 14));
        add(searchF);
        
         sched = new DefaultTableModel();
        sched.addColumn("patient name:");
        sched.addColumn("patient age:");
        sched.addColumn("Appointment Date");
        sched.addColumn("Patient ID:");
        JTable tab = new JTable(sched);
        tab.getTableHeader().setReorderingAllowed(false);
        tab.getTableHeader().setResizingAllowed(false);
        JScrollPane scroll = new JScrollPane(tab);
        scroll.setBounds(10, 100, 720, 305);
        scroll.setFont(new Font("Western", Font.PLAIN, 14));
        add(scroll);
        
        btnsrch = new JButton("Search");
        btnsrch.setBounds(750, 340, 90, 50);
        add(btnsrch); 
        
        btnback = new JButton("Back");
        btnback.setBounds(760, 400, 70, 50);
        add(btnback); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnsrch) {
            //logic here
    }    
         if (e.getSource() == btnback) {
           hospitalmanagementsystem.GUI.HospitalSysApp menu = new hospitalmanagementsystem.GUI.HospitalSysApp();
            this.setVisible(false);
            menu.setVisible(true);
   }
}
}
