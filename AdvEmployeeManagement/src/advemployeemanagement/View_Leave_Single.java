package AdvEmployeeManagement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author SATTRAJIT
 */
public class View_Leave_Single extends JFrame implements ActionListener{
    JTable t;
    JPanel p1, p2;
    JButton bt;
    String x[] = {"Employee Id", "Name", "Start Date", "End Date", "Reason", "Status"};
    String y[][] = new String[100][6];
    int i=0, j=0, count=0;
    Font f1, f2;
    
    View_Leave_Single(String eid){
        super("Leave Records");
        setSize(1480, 400);
        setLocation(0, 10);
        
        f1 = new Font("MS UI Gothic", Font.BOLD, 17);
        
        try{
            ConnectionClass obj = new ConnectionClass();
            String q = "SELECT * from LeaveReq WHERE EmployeeID = "+eid+";";
            ResultSet rs = obj.stm.executeQuery(q);
            while(rs.next()){
                count++;
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
        if(count==0){
            JOptionPane.showMessageDialog(null, "No Record Found OR Wrong Employee ID!");
            
        }
        
        t = new JTable(y, x);
        t.setBackground(Color.BLACK);
        t.setForeground(Color.WHITE);
        t.setFont(f1);
        
        JScrollPane js = new JScrollPane(t);
        
        add(js);
    }
    
    View_Leave_Single(){
        super("Leave Records");
        setSize(1480, 500);
        setLocation(0, 10);
//        String eid = "7";
        String eid = LoginPage.loggedUser;
        
        f1 = new Font("MS UI Gothic", Font.BOLD, 17);
        
        try{
            ConnectionClass obj = new ConnectionClass();
            String q = "SELECT * from LeaveReq WHERE EmployeeID = "+eid+";";
            ResultSet rs = obj.stm.executeQuery(q);
            while(rs.next()){
                count++;
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
            
        bt = new JButton("Home");
        bt.setFont(f1);
        bt.setBackground(Color.BLACK);
        bt.setForeground(Color.RED);
        bt.addActionListener(this);
        
        p1 = new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(bt);
        p1.setBackground(Color.BLACK);
        
        
        add(p1, "South");
        add(js, "North");
        
        
        if(count==0){
            JOptionPane.showMessageDialog(null, "No Record Found!");
        }
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == bt){
            setVisible(false);
            new HomePage().setVisible(true);
        }
    }
    
    public static void main(String [] args){
        new View_Leave_Single().setVisible(true);
    }
}
