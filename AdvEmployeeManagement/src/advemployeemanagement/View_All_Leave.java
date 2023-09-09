package AdvEmployeeManagement;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author SATTRAJIT
 */
public class View_All_Leave extends JFrame implements ActionListener {
    JTable t;
    JButton bt1;
    JTextField tf1;
    JPanel p1, p2, p3;
    String x[] = {"Employee Id", "Name", "Start Date", "End Date", "Reason", "Status"};
    String y[][] = new String[100][6];
    int i=0, j=0;
    Font f1, f2;
    JLabel l1, l2;
    
    View_All_Leave(){
        super("All Employee Leave Record");
        setSize(1480, 530);
        setLocation(0, 10);
        setResizable(false);
        f1 = new Font("MS UI Gothic", Font.BOLD, 17);
        f2 = new Font("Lucida Fax", Font.BOLD, 25);
        
        try{
            ConnectionClass obj = new ConnectionClass();
            String q = "SELECT * from LeaveReq";
            ResultSet rs = obj.stm.executeQuery(q);
            while(rs.next()){
                y[i][j++] = rs.getString("EmployeeID");
                y[i][j++] = rs.getString("Name");
                y[i][j++] = rs.getString("Start");
                y[i][j++] = rs.getString("End");
                y[i][j++] = rs.getString("Reason");
                y[i][j++] = rs.getString("Status");
                
                i++;
                j=0;
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        t = new JTable(y, x);
        t.setBackground(Color.BLACK);
        t.setForeground(Color.WHITE);
        t.setFont(f1);
        
        JScrollPane js = new JScrollPane(t);
        
        l1 = new JLabel("Search any Employee");
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setFont(f2);
        l1.setForeground(Color.YELLOW);
        
        l2 = new JLabel("Employee ID");
        l2.setFont(f2);
        l2.setForeground(Color.ORANGE);
        
        tf1 = new JTextField();
        tf1.setFont(f1);
        
        bt1 = new JButton("Search Employee");
        bt1.setFont(f1);
        bt1.setBackground(Color.BLACK);
        bt1.setForeground(Color.RED);
        bt1.addActionListener(this);
        
        
        p1 = new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);
        p1.setBackground(Color.BLACK);
        
        p2 = new JPanel();
        p2.setLayout(new GridLayout(1,3,10,10));
        p2.add(l2);
        p2.add(tf1);
        p2.add(bt1);
        p2.setBackground(Color.BLACK);
        
        p3 = new JPanel();
        p3.setLayout(new GridLayout(2,1,10,10));
        p3.add(p1);
        p3.add(p2);
        p3.setBackground(Color.BLACK);
        
        
        add(p3, "South");
        add(js, "North");
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == bt1){
            String eid = tf1.getText();
            new View_Leave_Single(eid).setVisible(true);
        }
    }
    
    public static void main(String[] args){
        new View_All_Leave().setVisible(true);
    }
}
