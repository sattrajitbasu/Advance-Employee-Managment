package AdvEmployeeManagement;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author SATTRAJIT
 */
public class HomePage extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10;
    Font f, f1, f2;
    JPanel p1;
    HomePage(){
        super("Home Page");
        setLocation(0,0);
        setSize(1600, 800);
        setResizable(false);
        System.out.println(LoginPage.loggedUser);
        f = new Font("Lucida Fox", Font.BOLD, 20);
        f1 = new Font("Gadugi", Font.BOLD, 35);
        f2 = new Font("MS UI Gothic", Font.BOLD, 18);
        
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("AdvEmployeeManagement/icons/homebg.jpg"));
        Image img = ic.getImage().getScaledInstance(1600, 800, Image.SCALE_DEFAULT);
        ImageIcon ic1 = new ImageIcon(img);
        l1 = new JLabel(ic1);
        
        JMenuBar m1 = new JMenuBar();
        m1.setBackground(Color.BLACK);
        
        JMenu men1 = new JMenu("Employee Profile");
        men1.setFont(f);
        men1.setForeground(Color.GRAY);
        JMenuItem ment11 = new JMenuItem("Add Profile");
        JMenuItem ment12 = new JMenuItem("View Profile");
        ment11.setFont(f2);
        ment12.setFont(f2);
        ment11.addActionListener(this);
        ment12.addActionListener(this);
        men1.add(ment11);
        men1.add(ment12);
        m1.add(men1);
        
        JMenu men2 = new JMenu("Manage");
        men2.setFont(f);
        men2.setForeground(Color.GRAY);
        JMenuItem ment21 = new JMenuItem("Update Details");
        ment21.setFont(f2);
        ment21.addActionListener(this);
        men2.add(ment21);
        m1.add(men2);
        
        JMenu men3 = new JMenu("Leave");
        men3.setFont(f);
        men3.setForeground(Color.GRAY);
        JMenuItem ment31 = new JMenuItem("View Leaves");
        JMenuItem ment32 = new JMenuItem("Approve Leaves");
        ment31.setFont(f2);
        ment32.setFont(f2);
        ment31.addActionListener(this);        
        ment32.addActionListener(this);        
        men3.add(ment31);
        men3.add(ment32);
        m1.add(men3);
        
//        JMenu men4 = new JMenu("Salary");
//        men4.setFont(f);
//        men4.setForeground(Color.GRAY);
//        JMenuItem ment41 = new JMenuItem("Add Salary");
//        JMenuItem ment42 = new JMenuItem("Generate Salary Slip");
//        ment41.setFont(f2);
//        ment42.setFont(f2);
//        ment41.addActionListener(this);
//        ment42.addActionListener(this);
//        men4.add(ment41);
//        men4.add(ment42);
//        m1.add(men4);
        
        JMenu men5 = new JMenu("Delete");
        men5.setForeground(Color.GRAY);
        men5.setFont(f);
        JMenuItem ment51 = new JMenuItem("Delete Employee");
        ment51.setFont(f2);
        ment51.addActionListener(this);
        men5.add(ment51);
        m1.add(men5);
        
        JMenu men6 = new JMenu("Attendance");
        men6.setFont(f);
        men6.setForeground(Color.GRAY);
        JMenuItem ment61 = new JMenuItem("View Attendance");
        ment61.setFont(f2);
        ment61.addActionListener(this);
        men6.add(ment61);
        m1.add(men6);
        
        JMenu men7 = new JMenu("Exit");
        men7.setFont(f);
        men7.setForeground(Color.RED);
        JMenuItem ment71 = new JMenuItem("Logout");
        ment71.setFont(f2);
        ment71.addActionListener(this);
        men7.add(ment71);
        m1.add(men7);
        
        setJMenuBar(m1);
        add(l1);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       String comnd = e.getActionCommand();
       
       if(comnd.equals("Add Profile")){
           new Add_Employee().setVisible(true);
       }
       else if(comnd.equals("View Profile")){
           new View_Employee();
       }
       else if(comnd.equals("Update Details")){
           new Update_Details().setVisible(true);
       }
       else if(comnd.equals("View Attendance")){
           new View_All_Attendance().setVisible(true);
       }
       else if(comnd.equals("Approve Leaves")){
           new Approve_Leave().setVisible(true);
       }
       else if(comnd.equals("View Leaves")){
           new View_All_Leave().setVisible(true);
       }
//       else if(comnd.equals("Add Salary")){
//           new Salary().setVisible(true);
//       }
//       else if(comnd.equals("Generate Salary Slip")){
//           new Generate_PaySlip().setVisible(true);
//       }
       else if(comnd.equals("Delete Employee")){
           new Delete_Employee().setVisible(true);
       }
       else if(comnd.equals("Logout")){
           new LoginPage().setVisible(true);
           setVisible(false);
       }
    }
    
    public static void main(String[] args){
        new HomePage().setVisible(true);
    }
    
}
