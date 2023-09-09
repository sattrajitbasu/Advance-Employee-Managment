package AdvEmployeeManagement;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author SATTRAJIT
 */
public class View_Employee_Data extends JFrame implements ActionListener {
    JFrame f;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, head, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10;
    JButton b1, b2;
    String firstname, lastname, email, phoneno, department, jobtitle, hiredate, salary, dateofbirth;
    JPanel jp;
    
    
    View_Employee_Data(String eId){
        super("EmployeeDetails");
        try{
            
            ConnectionClass obj = new ConnectionClass();
            String q = "SELECT * FROM PersonalInformation NATURAL JOIN JobDetails NATURAL JOIN SalaryInformation WHERE EmployeeID ="+ eId + ";";
            ResultSet rs = obj.stm.executeQuery(q);
            
            while(rs.next()){
                firstname = rs.getString("FirstName");
                lastname = rs.getString("LastName");
                email = rs.getString("Email");
                phoneno = rs.getString("PhoneNumber");
                dateofbirth = rs.getString("DateOfBirth");
                department = rs.getString("Department");
                jobtitle = rs.getString("JobTitle");
                hiredate = rs.getString("HireDate");
                salary = rs.getString("Salary");
            }
             
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        
        setSize(600, 670);
        setLocation(450, 120);
        setBackground(Color.WHITE);
        
        jp = new JPanel();
        jp.setLayout(null);

        head = new JLabel("Employee Details");
        head.setBounds(170, 10, 250, 40);
        head.setFont(new Font("Arial", Font.BOLD, 28));
        jp.add(head);

        l1 = new JLabel("Employee Id: ");
        l1.setBounds(150, 70, 150, 30);
        l1.setFont(new Font("serif", Font.BOLD, 20));
        jp.add(l1);

        v1 = new JLabel(eId);
        v1.setBounds(300, 70, 200, 30);
        v1.setFont(new Font("serif", Font.BOLD, 20));
        jp.add(v1);
         
       
        l2 = new JLabel("Date Of Birth: ");
        l2.setBounds(150, 120, 150, 30);
        l2.setFont(new Font("serif", Font.BOLD, 20));
        jp.add(l2);
        
        v2 = new JLabel(dateofbirth);
        v2.setBounds(300, 120, 200, 30);
        v2.setFont(new Font("serif", Font.BOLD, 20));
        jp.add(v2);

        l3 = new JLabel("First Name: ");
        l3.setBounds(150, 170, 150, 30);
        l3.setFont(new Font("serif", Font.BOLD, 20));
        jp.add(l3);

        v3 = new JLabel(firstname);
        v3.setBounds(300, 170, 200, 30);
        v3.setFont(new Font("serif", Font.BOLD, 20));
        jp.add(v3);
        
        l4 = new JLabel("Last Name: ");
        l4.setBounds(150, 220, 150, 30);
        l4.setFont(new Font("serif", Font.BOLD, 20));
        jp.add(l4);

        v4 = new JLabel(lastname);
        v4.setBounds(300, 220, 200, 30);
        v4.setFont(new Font("serif", Font.BOLD, 20));
        jp.add(v4);

        l5 = new JLabel("Email: ");
        l5.setBounds(150, 270, 150, 30);
        l5.setFont(new Font("serif", Font.BOLD, 20));
        jp.add(l5);

        v5 = new JLabel(email);
        v5.setBounds(300, 270, 200, 30);
        v5.setFont(new Font("serif", Font.BOLD, 20));
        jp.add(v5);
        
        l6 = new JLabel("Phone Number: ");
        l6.setBounds(150, 320, 150, 30);
        l6.setFont(new Font("serif", Font.BOLD, 20));
        jp.add(l6);

        v6 = new JLabel(phoneno);
        v6.setBounds(300, 320, 200, 30);
        v6.setFont(new Font("serif", Font.BOLD, 20));
        jp.add(v6);
                
        l7 = new JLabel("Department: ");
        l7.setBounds(150, 370, 150, 30);
        l7.setFont(new Font("serif", Font.BOLD, 20));
        jp.add(l7);

        v7 = new JLabel(department);
        v7.setBounds(300, 370, 200, 30);
        v7.setFont(new Font("serif", Font.BOLD, 20));
        jp.add(v7);

        l8 = new JLabel("Job Title: ");
        l8.setBounds(150, 420, 150, 30);
        l8.setFont(new Font("serif", Font.BOLD, 20));
        jp.add(l8);

        v8 = new JLabel(jobtitle);
        v8.setBounds(300, 420, 200, 30);
        v8.setFont(new Font("serif", Font.BOLD, 20));
        jp.add(v8);
        
        l9 = new JLabel("Hire Date: ");
        l9.setBounds(150, 470, 150, 30);
        l9.setFont(new Font("serif", Font.BOLD, 20));
        jp.add(l9);

        v9 = new JLabel(hiredate);
        v9.setBounds(300, 470, 200, 30);
        v9.setFont(new Font("serif", Font.BOLD, 20));
        jp.add(v9);

        l10 = new JLabel("Salary: ");
        l10.setBounds(150, 520, 150, 30);
        l10.setFont(new Font("serif", Font.BOLD, 20));
        jp.add(l10);

        v10 = new JLabel(salary);
        v10.setBounds(300, 520, 200, 30);
        v10.setFont(new Font("serif", Font.BOLD, 20));
        jp.add(v10);

        b1 = new JButton("Cancel");
        b1.setBackground(Color.RED);
        b1.setBounds(160, 570, 100, 30);
        b1.addActionListener(this);
        jp.add(b1);

        
        
        add(jp);
        setVisible(true);
        
        
    }
    
    View_Employee_Data(){
        super("EmployeeDetails");
        String eId = LoginPage.loggedUser;
//        String eId = "7";
        try{
            
            ConnectionClass obj = new ConnectionClass();
            String q = "SELECT * FROM PersonalInformation NATURAL JOIN JobDetails NATURAL JOIN SalaryInformation WHERE EmployeeID ="+ eId + ";";
            ResultSet rs = obj.stm.executeQuery(q);
            
            while(rs.next()){
                firstname = rs.getString("FirstName");
                lastname = rs.getString("LastName");
                email = rs.getString("Email");
                phoneno = rs.getString("PhoneNumber");
                dateofbirth = rs.getString("DateOfBirth");
                department = rs.getString("Department");
                jobtitle = rs.getString("JobTitle");
                hiredate = rs.getString("HireDate");
                salary = rs.getString("Salary");
            }
             
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        
        setSize(600, 670);
        setLocation(450, 120);
        setBackground(Color.WHITE);
        
        jp = new JPanel();
        jp.setLayout(null);

        head = new JLabel("Employee Details");
        head.setBounds(170, 10, 250, 40);
        head.setFont(new Font("Arial", Font.BOLD, 28));
        jp.add(head);

        l1 = new JLabel("Employee Id: ");
        l1.setBounds(150, 70, 150, 30);
        l1.setFont(new Font("serif", Font.BOLD, 20));
        jp.add(l1);

        v1 = new JLabel(eId);
        v1.setBounds(300, 70, 200, 30);
        v1.setFont(new Font("serif", Font.BOLD, 20));
        jp.add(v1);
         
       
        l2 = new JLabel("Date Of Birth: ");
        l2.setBounds(150, 120, 150, 30);
        l2.setFont(new Font("serif", Font.BOLD, 20));
        jp.add(l2);
        
        v2 = new JLabel(dateofbirth);
        v2.setBounds(300, 120, 200, 30);
        v2.setFont(new Font("serif", Font.BOLD, 20));
        jp.add(v2);

        l3 = new JLabel("First Name: ");
        l3.setBounds(150, 170, 150, 30);
        l3.setFont(new Font("serif", Font.BOLD, 20));
        jp.add(l3);

        v3 = new JLabel(firstname);
        v3.setBounds(300, 170, 200, 30);
        v3.setFont(new Font("serif", Font.BOLD, 20));
        jp.add(v3);
        
        l4 = new JLabel("Last Name: ");
        l4.setBounds(150, 220, 150, 30);
        l4.setFont(new Font("serif", Font.BOLD, 20));
        jp.add(l4);

        v4 = new JLabel(lastname);
        v4.setBounds(300, 220, 200, 30);
        v4.setFont(new Font("serif", Font.BOLD, 20));
        jp.add(v4);

        l5 = new JLabel("Email: ");
        l5.setBounds(150, 270, 150, 30);
        l5.setFont(new Font("serif", Font.BOLD, 20));
        jp.add(l5);

        v5 = new JLabel(email);
        v5.setBounds(300, 270, 200, 30);
        v5.setFont(new Font("serif", Font.BOLD, 20));
        jp.add(v5);
        
        l6 = new JLabel("Phone Number: ");
        l6.setBounds(150, 320, 150, 30);
        l6.setFont(new Font("serif", Font.BOLD, 20));
        jp.add(l6);

        v6 = new JLabel(phoneno);
        v6.setBounds(300, 320, 200, 30);
        v6.setFont(new Font("serif", Font.BOLD, 20));
        jp.add(v6);
                
        l7 = new JLabel("Department: ");
        l7.setBounds(150, 370, 150, 30);
        l7.setFont(new Font("serif", Font.BOLD, 20));
        jp.add(l7);

        v7 = new JLabel(department);
        v7.setBounds(300, 370, 200, 30);
        v7.setFont(new Font("serif", Font.BOLD, 20));
        jp.add(v7);

        l8 = new JLabel("Job Title: ");
        l8.setBounds(150, 420, 150, 30);
        l8.setFont(new Font("serif", Font.BOLD, 20));
        jp.add(l8);

        v8 = new JLabel(jobtitle);
        v8.setBounds(300, 420, 200, 30);
        v8.setFont(new Font("serif", Font.BOLD, 20));
        jp.add(v8);
        
        l9 = new JLabel("Hire Date: ");
        l9.setBounds(150, 470, 150, 30);
        l9.setFont(new Font("serif", Font.BOLD, 20));
        jp.add(l9);

        v9 = new JLabel(hiredate);
        v9.setBounds(300, 470, 200, 30);
        v9.setFont(new Font("serif", Font.BOLD, 20));
        jp.add(v9);

        l10 = new JLabel("Salary: ");
        l10.setBounds(150, 520, 150, 30);
        l10.setFont(new Font("serif", Font.BOLD, 20));
        jp.add(l10);

        v10 = new JLabel(salary);
        v10.setBounds(300, 520, 200, 30);
        v10.setFont(new Font("serif", Font.BOLD, 20));
        jp.add(v10);


        b2 = new JButton("Cancel");
        b2.setBackground(Color.red);
        b2.setBounds(350, 570, 100, 30);
        b2.addActionListener(this);
        jp.add(b2);
        
        add(jp);
        setVisible(true);
        
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            setVisible(false);
            new View_Employee().setVisible(true);
        }
        else if(e.getSource()==b2){
            setVisible(false);
        }
    }
    public static void main(String []args){
        new View_Employee_Data().setVisible(true);
    }
    
}
