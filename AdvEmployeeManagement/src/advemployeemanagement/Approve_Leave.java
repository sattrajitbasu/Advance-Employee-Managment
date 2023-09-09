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
public class Approve_Leave extends JFrame implements ActionListener{
    JLabel l1, l2, l3, l4, l5, l6, l7, title;
    JButton bt1, bt2, bt3;
    JPanel p1, p2;
    JTextField t1, t2, t3, t4, t5, t6;
    Font f1, f2;
    Choice ch;
    String [] reasons = {"Personal Health Issue", "Family Member Health Issue", "Personal Things", "Function/Celebration"};
    
    Approve_Leave(){
        super("Leave Requests");
        setLocation(450, 50);
        setSize(950, 450);
        setResizable(false);
        
        f1 = new Font("Arial", Font.BOLD, 25);
        f2 = new Font("Arial", Font.BOLD, 16);
        
        title = new JLabel("Leave Requests");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(f1);
        
        ch = new Choice();
        
        
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
        t3 = new JTextField();
        t3.setEditable(false);
        t4 = new JTextField();
        t4.setEditable(false);
        
        l1.setFont(f2);
        l2.setFont(f2);
        l3.setFont(f2);
        l4.setFont(f2);
        l5.setFont(f2);
        
        t1.setFont(f2);
        t2.setFont(f2);
        t3.setFont(f2);
        t4.setFont(f2);
        
        
        
        bt1 = new JButton("Approve");
        bt1.addActionListener(this);
        bt1.setForeground(Color.WHITE);
        bt1.setBackground(Color.BLUE);
        bt1.setFont(f2);
        bt1.setEnabled(false);
        bt2 = new JButton("Reject");
        bt2.addActionListener(this);
        bt2.setForeground(Color.WHITE);
        bt2.setBackground(Color.RED);
        bt2.setFont(f2);
        bt2.setEnabled(false);
        bt3 = new JButton("Cancel");
        bt3.addActionListener(this);
        bt3.setForeground(Color.WHITE);
        bt3.setBackground(Color.ORANGE);
        bt3.setFont(f2);
        
        updateReq();
        
        
        
        ch.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                try{
                    ConnectionClass obj2 = new ConnectionClass();
                    String eid = ch.getSelectedItem();
                    String q2 = "SELECT * FROM LeaveReq WHERE EmployeeID = "+eid+" AND Status = 'Pending';";
                    ResultSet rs1 = obj2.stm.executeQuery(q2);
                    
                    if(rs1.next()){
                        t1.setText(rs1.getString("Name"));
                        t2.setText(rs1.getString("Start"));
                        t3.setText(rs1.getString("End"));
                        t4.setText(rs1.getString("Reason"));
                    }
                    if(!ch.getSelectedItem().equals("")){
                        bt1.setEnabled(true);
                        bt2.setEnabled(true);
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        
        p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 1, 10, 10));
        p1.add(title);
        
        p2 = new JPanel();
        p2.setLayout(new GridLayout(7, 2, 10, 10));
        p2.add(l1);
        p2.add(ch);
        p2.add(l2);
        p2.add(t1);
        p2.add(l3);
        p2.add(t2);
        p2.add(l4);
        p2.add(t3);
        p2.add(l5);
        p2.add(t4);
        p2.add(bt1);
        p2.add(bt2);
        p2.add(bt3);
        
        
        setLayout(new BorderLayout(10, 10));
        add(p1, "North");
        add(p2, "South");
        
    }
    
    public void updateReq(){
        try{
            ConnectionClass obj = new ConnectionClass();
            String q = "SELECT EmployeeID FROM LeaveReq WHERE Status = 'Pending'";
            ch.removeAll();
            ResultSet rs = obj.stm.executeQuery(q);
            ch.add("");
            while(rs.next()){
                ch.add(rs.getString("EmployeeID"));
            }
            if(ch.getItemCount()==1){
                bt1.setEnabled(false);
                bt2.setEnabled(false);
            }
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String [] args){
        new Approve_Leave().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == bt1){
            try{
                String eid = ch.getSelectedItem();
                String start = t2.getText();
                String end = t3.getText();
                String rea = t4.getText();
                
                ConnectionClass objx = new ConnectionClass();
                String q1 = "INSERT INTO ActiveLeaves VALUES("+eid+", '"+start+"', '"+end+"', '"+rea+"');";
                String q2 = "update leavereq set status = 'Approved' where employeeid = "+eid+ " and start = '"+start+
                            "' and end = '"+end+"' and reason = '"+rea+"';";
                
                objx.stm.addBatch(q1);
                objx.stm.addBatch(q2);
                objx.stm.executeBatch();
                updateReq();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }    
        else if(ae.getSource() == bt2){
            try{
                ConnectionClass objx = new ConnectionClass();
                String eid = ch.getSelectedItem();
                String start = t2.getText();
                String end = t3.getText();
                String rea = t4.getText();
                String q = "update leavereq set status = 'Rejected' where employeeid = "+eid+ " and start = '"+start+
                            "' and end = '"+end+"' and reason = '"+rea+"';";
                
                objx.stm.executeUpdate(q);
                updateReq();
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }
        else if(ae.getSource() == bt3){
            setVisible(false);
        }
        
    }
}
