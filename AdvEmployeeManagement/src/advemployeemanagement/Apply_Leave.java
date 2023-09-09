/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AdvEmployeeManagement;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author SATTRAJIT
 */
public class Apply_Leave extends JFrame implements ActionListener{
    JLabel l1, l2, l3, l4, l5, l6, l7, title;
    JButton bt1, bt2;
    JPanel p1, p2;
    JTextField t1, t2, t3, t4, t5, t6;
    Font f1, f2;
    JComboBox cb;
    String empID="7";
    String [] reasons = {"Personal Health Issue", "Family Member Health Issue", "Personal Things", "Function/Celebration"};
    
    Apply_Leave(){
        super("Apply Leave");
        setLocation(450, 50);
        setSize(950, 450);
        setResizable(false);
        empID = LoginPage.loggedUser;
        
        f1 = new Font("Arial", Font.BOLD, 25);
        f2 = new Font("Arial", Font.BOLD, 16);
        
        title = new JLabel("Apply Leave");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(f1);
        
        l1 = new JLabel("Employee ID");
        l1.setHorizontalAlignment(JLabel.CENTER);
        l2 = new JLabel("Name");
        l2.setHorizontalAlignment(JLabel.CENTER);
        l3 = new JLabel("Start Date");
        l3.setHorizontalAlignment(JLabel.CENTER);
        l4 = new JLabel("End Date");
        l4.setHorizontalAlignment(JLabel.CENTER);
        l5 = new JLabel("Leave Reason");
        l5.setHorizontalAlignment(JLabel.CENTER);
        
        t1 = new JTextField();
        t1.setEditable(false);
        t2 = new JTextField();
        t2.setEditable(false);
        t3 = new JTextField("YYYY-MM-DD");
        t4 = new JTextField("YYYY-MM-DD");
        
        l1.setFont(f2);
        l2.setFont(f2);
        l3.setFont(f2);
        l4.setFont(f2);
        l5.setFont(f2);
        
        t1.setFont(f2);
        t2.setFont(f2);
        t3.setFont(f2);
        t4.setFont(f2);
        
        
        bt1 = new JButton("Submit");
        bt1.addActionListener(this);
        bt1.setForeground(Color.WHITE);
        bt1.setBackground(Color.BLUE);
        bt1.setFont(f2);
        bt2 = new JButton("Cancel");
        bt2.addActionListener(this);
        bt2.setForeground(Color.WHITE);
        bt2.setBackground(Color.RED);
        bt2.setFont(f2);
        
        
        
        try{
            ConnectionClass obj = new ConnectionClass();
            String q = "Select * from PersonalInformation WHERE EmployeeID = "+empID+";";
            ResultSet rs = obj.stm.executeQuery(q);
            if(rs.next()){
                t1.setText(empID);
                t2.setText(rs.getString("FirstName")+" "+rs.getString("LastName"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        cb = new JComboBox(reasons);
        cb.setFont(f2);
        
        p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 1, 10, 10));
        p1.add(title);
        
        p2 = new JPanel();
        p2.setLayout(new GridLayout(7, 2, 10, 10));
        p2.add(l1);
        p2.add(t1);
        p2.add(l2);
        p2.add(t2);
        p2.add(l3);
        p2.add(t3);
        p2.add(l4);
        p2.add(t4);
        p2.add(l5);
        p2.add(cb);
        p2.add(bt1);
        p2.add(bt2);
        
        
        setLayout(new BorderLayout(10, 10));
        add(p1, "North");
        add(p2, "South");
        
    }
    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == bt1){
            String empId = t1.getText();
            String name = t2.getText();
            String start = t3.getText();
            String end = t4.getText();
            String rea = (String)cb.getSelectedItem();
            
            int flag = 0;
            if(!start.matches("^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$")){
                    JOptionPane.showMessageDialog(this, "Write the correct  Start Date(YYYY-MM-DD)!",
                   "Error", JOptionPane.WARNING_MESSAGE);
                    flag = 1;
            }
            if(!end.matches("^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$")){
                    JOptionPane.showMessageDialog(this, "Write the correct  End Date(YYYY-MM-DD)!",
                   "Error", JOptionPane.WARNING_MESSAGE);
                    flag = 1;
            }
            if(start.compareTo(end) > 0){
                JOptionPane.showMessageDialog(this, "End date should come after start date",
                   "Error", JOptionPane.WARNING_MESSAGE);
                    flag = 1;
            }
            if(flag == 0){
                try{
                    ConnectionClass obj = new ConnectionClass();
                    String q = "INSERT INTO LeaveReq VALUES("+empId+", '"+name+"', '"+start+"', '"+end+"', '"+rea+"', 'Pending');";
                    int x = obj.stm.executeUpdate(q);
                    if(x==1){
                         JOptionPane.showMessageDialog(null, "Successfully applied leave");
                         new HomePage2();
                         setVisible(false);
                    }
                }
                catch(Exception e){
//                    e.printStackTrace();
                }
            }
        }
        else if(ae.getSource() == bt2){
            setVisible(false);
        }
    }
    
    public static void main(String [] args){
        new Apply_Leave().setVisible(true);
    }
}
