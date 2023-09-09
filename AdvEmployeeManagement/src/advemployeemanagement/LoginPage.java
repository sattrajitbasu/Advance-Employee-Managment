package AdvEmployeeManagement;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
/**
 *
 * @author SATTRAJIT
 */
public class LoginPage extends JFrame implements ActionListener{
    JFrame f;
    JPanel jp;
    JLabel l1, l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1, b2;
    public static String loggedUser;
    
    LoginPage(){
        
        super("Login Page");
        setSize(500, 240);
        setLocation(400, 300); 
        setResizable(false);
        
        jp = new JPanel();
        jp.setBackground(Color.GRAY);
        jp.setBounds(400, 300, 500, 240);
        jp.setLayout(null);
        
        l1 = new JLabel("Employee Id");
        l2 = new JLabel("Password");
        
        l1.setBounds(40, 20, 100, 30);
        l2.setBounds(40, 70, 100, 30);
        
        jp.add(l1);
        jp.add(l2);
        
        t1 =  new JTextField();
        t1.setBounds(150, 20, 150, 30);
        jp.add(t1);
        
        t2 = new JPasswordField();
        t2.setBounds(150, 70, 150, 30);
        jp.add(t2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("AdvEmployeeManagement/icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT);
        i1 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i1);
        l3.setBounds(340, 20, 120, 120);
        jp.add(l3);
        
        b1 = new JButton("Login");
        b1.setBackground(Color.BLACK);
        b1.setBounds(40, 140, 120, 30);
        b1.addActionListener(this);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Arial", Font.BOLD, 15));
        jp.add(b1);
        
        b2 = new JButton("Close");
        b2.setBackground(Color.BLACK);
        b2.setBounds(180, 140, 120, 30);
        b2.addActionListener(this);
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("Arial", Font.BOLD, 15));
        jp.add(b2);
        
        add(jp);
        getContentPane();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            try{
                ConnectionClass obj = new ConnectionClass();
                String empid = t1.getText();
                String pass = t2.getText();

                String q = "SELECT * FROM LoginDetails WHERE EmployeeID = "+empid+" AND Password = '"+pass+"';";
                ResultSet rs = obj.stm.executeQuery(q);
                if(rs.next()){
                    String role = rs.getString("Role");
                    loggedUser = empid;
                    if(role.equals("admin")){
                        new HomePage().setVisible(true);
                    }
                    else{
                        try{
                            String q1 = "INSERT INTO Attendance VALUES("+empid+", '"+todaysDate()+"');";
                            obj.stm.executeUpdate(q1);
                            JOptionPane.showMessageDialog(null, "Your attendance is Marked!");
                        }catch(Exception e){
                            JOptionPane.showMessageDialog(null, "Your attendance is already Marked!");
//                            e.printStackTrace();
                        }
                        new HomePage2().setVisible(true);
//                        System.out.println("Logged IN!!");
                    }
                    setVisible(false);
                }else{
                    setVisible(false);
                    JOptionPane.showMessageDialog(null, "You have entered Wrong Username or Password!");
                    setVisible(true);
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }   
        }
        if(ae.getSource() == b2){
            System.exit(0);
        }
    }
    
    public static String todaysDate(){
        LocalDate dateObj = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = dateObj.format(formatter);
        return date;
    }
    
    public static void main(String []args){
        new LoginPage().setVisible(true);
    }
}
