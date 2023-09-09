package AdvEmployeeManagement;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author SATTRAJIT
 */
public class Delete_Employee extends JFrame implements ActionListener{
    JFrame f;
    JTextField t;
    JLabel l1, bg;
    JButton b1, b2;
    JPanel jp;
    Delete_Employee(){
        super("Delete Employee");
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
        
        b1 = new JButton("Delete");
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
        
        if(ae.getActionCommand().equals("Delete")){
            try{
                String eid = t.getText();
                ConnectionClass obj = new ConnectionClass();
                String exists = "Select EmployeeId from PersonalInformation where EmployeeId = " + eid + ";";
                ResultSet rs = obj.stm.executeQuery(exists);
                
                if(!rs.next()){
                    setVisible(true);
                    JOptionPane.showMessageDialog(this, "Employee Not Found");
                }else{
                    String q1 = "DELETE FROM SalaryInformation WHERE EmployeeID = "+ eid +";";
                    String q2 = "DELETE FROM JobDetails WHERE EmployeeID = "+ eid +";";
                    String q3 = "DELETE FROM PersonalInformation WHERE EmployeeID = "+ eid +";";
                    String q4 = "DELETE FROM Attendance WHERE EmployeeID = "+eid+";";
                    String q5 = "DELETE FROM LoginDetails WHERE EmployeeID = "+eid+";";
                    String q6 = "DELETE FROM LeaveReq WHERE EmployeeID = "+eid+";";
                    String q7 = "DELETE FROM ActiveLeaves WHERE EmployeeID = "+eid+";";
                    
                    obj.stm.addBatch(q1);
                    obj.stm.addBatch(q2);
                    obj.stm.addBatch(q3);

                    obj.stm.executeBatch();
                    JOptionPane.showMessageDialog(this, "Successfully Deleted");
                    setVisible(false);
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
        new Delete_Employee();
    }
}
