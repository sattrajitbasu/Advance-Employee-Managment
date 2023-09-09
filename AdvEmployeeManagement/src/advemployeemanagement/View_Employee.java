package AdvEmployeeManagement;

import AdvEmployeeManagement.HomePage;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author SATTRAJIT
 */
public class View_Employee extends JFrame implements ActionListener{
    JFrame f;
    JTextField t;
    JLabel l1, bg;
    JButton b1, b2;
    JPanel jp;
    View_Employee(){
        super("View Employee");
        setResizable(false);
        
        jp = new JPanel();
        jp.setLayout(null);
        
        bg = new JLabel();
        bg.setBounds(0, 0, 640, 445);
        
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("AdvEmployeeManagement/icons/p1.jpg"));
        bg.setIcon(ic);
        jp.add(bg);
        
        
        l1 = new JLabel("Employee Id");
        l1.setVisible(true);
        l1.setBounds(80, 100, 250, 30);
        l1.setFont(new Font("Arial", Font.BOLD, 30));
        bg.add(l1);
        
        t = new JTextField();
        t.setBounds(350, 100, 220, 30);
        bg.add(t);
        
        b1 = new JButton("Search");
        b1.setBounds(180, 250, 130, 45);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.ORANGE);
        b1.setFont(new Font("Arial", Font.BOLD, 18));
        b1.addActionListener(this);
        bg.add(b1);
        
        b2 = new JButton("Cancel");
        b2.setBounds(350, 250, 130, 45);
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.setFont(new Font("Arial", Font.BOLD, 18));
        b2.addActionListener(this);
        bg.add(b2);
        
        add(jp);
        
        setVisible(true);
        setSize(640, 445);
        setLocation(300, 100);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getActionCommand().equals("Search")){
            try{
                 ConnectionClass obj = new ConnectionClass();
                String q = "SELECT * FROM PersonalInformation WHERE  EmployeeID = '"+t.getText()+"';";
                ResultSet rs = obj.stm.executeQuery(q);
                if(rs.next()){
                    setVisible(false);
                    new View_Employee_Data(t.getText());
                }else{
                    JOptionPane.showMessageDialog(f, "Not Found!",
                   "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        if(ae.getActionCommand().equals("Cancel")){
            setVisible(false);
        }
        
    }
    
    public static void main(String []args){
        new View_Employee();
    }
}
