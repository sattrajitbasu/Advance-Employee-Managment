package AdvEmployeeManagement;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author SATTRAJIT
 */
public class View_All_Attendance extends JFrame implements ActionListener {
    JTable t;
    JButton bt1, bt2;
    JTextField tf1, tf2;
    JPanel p1, p2, p3, p4, p5;
    String x[] = {"Employee Id", "Date"};
    String y[][] = new String[100][2];
    int i=0, j=0;
    Font f1, f2;
    JLabel l1, l2, l3, l4;
    
    View_All_Attendance(){
        super("All Employee Attendance Record");
        setSize(1480, 630);
        setLocation(0, 10);
        setResizable(false);
        f1 = new Font("MS UI Gothic", Font.BOLD, 17);
        f2 = new Font("Lucida Fax", Font.BOLD, 25);
        
        try{
            ConnectionClass obj = new ConnectionClass();
            String q = "SELECT * from Attendance";
            ResultSet rs = obj.stm.executeQuery(q);
            while(rs.next()){
                y[i][j++] = rs.getString("EmployeeID");
                y[i][j++] = rs.getString("DateMarked");
                
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
        
        l3 = new JLabel("Search any Date");
        l3.setHorizontalAlignment(JLabel.CENTER);
        l3.setFont(f2);
        l3.setForeground(Color.CYAN);
        
        l4 = new JLabel("Date");
        l4.setFont(f2);
        l4.setForeground(Color.GREEN);
        
        tf2 = new JTextField();
        tf2.setFont(f1);
        
        bt2 = new JButton("Search Date");
        bt2.setFont(f1);
        bt2.setBackground(Color.BLACK);
        bt2.setForeground(Color.PINK);
        bt2.addActionListener(this);
        
        
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
        p3.setLayout(new GridLayout(1,1,10,10));
        p3.add(l3);
        p3.setBackground(Color.BLACK);
        
        p4 = new JPanel();
        p4.setLayout(new GridLayout(1,3,10,10));
        p4.add(l4);
        p4.add(tf2);
        p4.add(bt2);
        p4.setBackground(Color.BLACK);
        
        p5 = new JPanel();
        p5.setLayout(new GridLayout(4,1,10,10));
        p5.add(p1);
        p5.add(p2);
        p5.add(p3);
        p5.add(p4);
        p5.setBackground(Color.BLACK);
        
        
        add(p5, "South");
        add(js, "North");
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == bt1){
            int eid = Integer.parseInt(tf1.getText());
            new View_Single_Attendance(eid).setVisible(true);
        }
        if(ae.getSource() == bt2){
            String date = tf2.getText();
            int flag = 0;
            if(!date.matches("^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$")){
                    JOptionPane.showMessageDialog(this, "Write the correct Date Format(YYYY-MM-DD)!",
                   "Error", JOptionPane.WARNING_MESSAGE);
                    flag = 1;
            }
            if(flag==0){
                new View_Single_Attendance(date).setVisible(true);
            }
        }
    }
    
    public static void main(String[] args){
        new View_All_Attendance().setVisible(true);
    }
}
