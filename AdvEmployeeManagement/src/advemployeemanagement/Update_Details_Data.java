package AdvEmployeeManagement;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author SATTRAJIT
 */
public class Update_Details_Data extends JFrame implements ActionListener {
    JLabel title, bg, id1, id2, id3, id4, id5, id6, id7, id8, id9, id10, id11;
    JFrame f;
    JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11;
    JButton b1, b2;
    String firstname, lastname, dateofbirth, phoneno, email, department, jobtitle, employeeId, salary, hiredate;
    JPanel jp;
    JComboBox bx1, bx2;
    String[] departments = { "IT", "Finance", "Customer Care", "Ware House"};
    String[] it = { "SDE", "SRE", "DEVOPs", "DBA"};
    String[] finance = {"Accountant", "Consultant", "CA"};
    String [] warehouse = {"Packaging", "Delivery"};
    String [] customercare = {"Client-Relation", "Helpline"};
    Update_Details_Data(String eID){
        super("Update Details-");
        try{
            
            ConnectionClass obj = new ConnectionClass();
            String q = "SELECT * FROM PersonalInformation NATURAL JOIN JobDetails NATURAL JOIN SalaryInformation WHERE EmployeeID ="+ eID + ";";
            ResultSet rs = obj.stm.executeQuery(q);
            
            while(rs.next()){
                employeeId = rs.getString("EmployeeID");
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
        setSize(900, 600);
        setLocation(300, 100);
        setResizable(false);
        
        
        jp = new JPanel();
        
        bg = new JLabel();
        bg.setBounds(0, 0, 900, 600);
        bg.setLayout(null);
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("AdvEmployeeManagement/icons/bg1.jpg"));
        Image img = ic.getImage().getScaledInstance(900, 600, Image.SCALE_DEFAULT);
        ImageIcon ic1 = new ImageIcon(img);
        bg.setIcon(ic1);
        jp.add(bg);
        
        title = new JLabel("Update Employee Details");
        title.setBounds(280, 30, 500, 50);
        title.setFont(new Font("Impact", Font.BOLD, 40));
        title.setForeground(Color.BLACK);
        bg.add(title);
        
        id1 = new JLabel("First Name");
        id1.setBounds(50, 150, 150, 30);
        id1.setFont(new Font("Arial", Font.BOLD, 20));
        bg.add(id1);
        
        t1 = new JTextField(firstname);
        t1.setBounds(180, 150, 250, 30);
        t1.setFont(new Font("Arial", Font.PLAIN, 16));
//        t1.setText(firstname);
        bg.add(t1);
        
        id2 = new JLabel("Last Name");
        id2.setBounds(450, 150, 200, 30);
        id2.setFont(new Font("Arial", Font.BOLD, 20));
        bg.add(id2);
        
        t2 = new JTextField(lastname);
        t2.setBounds(620, 150, 250, 30);
        t2.setFont(new Font("Arial", Font.PLAIN, 16));
        bg.add(t2);
        
        id3 = new JLabel("Email");
        id3.setBounds(50, 200, 100, 30);
        id3.setFont(new Font("Arial", Font.BOLD, 20));
        bg.add(id3);
        
        t3 = new JTextField(email);
        t3.setBounds(180, 200, 250, 30);
        t3.setFont(new Font("Arial", Font.PLAIN, 16));
        bg.add(t3);
        
        id4 = new JLabel("Phone Number");
        id4.setBounds(450, 200, 200, 30);
        id4.setFont(new Font("Arial", Font.BOLD, 20));
        bg.add(id4);
        
        t4 = new JTextField(phoneno);
        t4.setBounds(620, 200, 250, 30);
        t4.setFont(new Font("Arial", Font.PLAIN, 16));
        bg.add(t4);
        
        id5 = new JLabel("Department");
        id5.setBounds(50, 250, 130, 30);
        id5.setFont(new Font("Arial", Font.BOLD, 20));
        bg.add(id5);
        
        int i=0;
        for( i=0; i<departments.length; i++){
            if(department.equals(departments[i])){
                break;
            }
        }
        
        bx1 = new JComboBox(departments);
        bx1.setBounds(180, 250, 250, 30);
        bx1.setFont(new Font("Arial", Font.PLAIN, 16));
        bx1.setSelectedIndex(i);
        bx1.setBackground(Color.WHITE);
        bx1.addActionListener(this);
        bg.add(bx1);
        
        
        id6 = new JLabel("Job Title");
        id6.setBounds(450, 250, 200, 30);
        id6.setFont(new Font("Arial", Font.BOLD, 20));
        bg.add(id6);
        
        
        switch(i){
            case 0:
                bx2 = new JComboBox(it);
                for(int j=0; j<it.length; j++){
                    if(jobtitle.equals(it[j])){
                        System.out.println(j);
                        bx2.setSelectedIndex(j);
                        break;
                    }
                }
                break;
            case 1:
                bx2 = new JComboBox(finance);
                for(int j=0; j<finance.length; j++){
                    if(jobtitle.equals(finance[j])){
                        System.out.println(j);
                        bx2.setSelectedIndex(j);
                        break;
                    }
                }
                break;
            case 2:
                bx2 = new JComboBox(customercare);
                for(int j=0; j<customercare.length; j++){
                    if(jobtitle.equals(customercare[j])){
                        System.out.println(j);
                        bx2.setSelectedIndex(j);
                        break;
                    }
                }
                break;
            case 3:
                bx2 = new JComboBox(warehouse);
                for(int j=0; j<warehouse.length; j++){
                    if(jobtitle.equals(warehouse[j])){
                        System.out.println(j);
                        bx2.setSelectedIndex(j);
                        break;
                    }
                }
                break;
        }
        bx2.setBounds(620, 250, 250, 30);
        bx2.setFont(new Font("Arial", Font.PLAIN, 16));
        bx2.addActionListener(this);
        bx2.setBackground(Color.WHITE);
        bg.add(bx2);
        
        
        id7 = new JLabel("Hire Date");
        id7.setBounds(50, 300, 100, 30);
        id7.setFont(new Font("Arial", Font.BOLD, 20));
        bg.add(id7);
        
        t7 = new JTextField(hiredate);
        t7.setBounds(180, 300, 250, 30);
        t7.setFont(new Font("Arial", Font.PLAIN, 20));
        bg.add(t7);
        
        id8 = new JLabel("Employee Id");
        id8.setBounds(450, 300, 200, 40);
        id8.setFont(new Font("Arial", Font.BOLD, 20));
        bg.add(id8);
        
        t8 = new JTextField(employeeId+"");
        t8.setBounds(620, 300, 250, 30);
        t8.setFont(new Font("Arial", Font.BOLD, 20));
        t8.setHorizontalAlignment(JTextField.CENTER);
        t8.setEditable(false);
        bg.add(t8);
       
        id9 = new JLabel("Salary");
        id9.setBounds(50, 350, 100, 30);
        id9.setFont(new Font("Arial", Font.BOLD, 20));
        bg.add(id9);
        
        t9 = new JTextField(salary);
        t9.setBounds(180, 350, 250, 30);
        t9.setFont(new Font("Arial", Font.PLAIN, 16));
        bg.add(t9);
        
        id10 = new JLabel("Date Of Birth");
        id10.setBounds(450, 350, 130, 30);
        id10.setFont(new Font("Arial", Font.BOLD, 20));
        bg.add(id10);
        
        t10 = new JTextField(dateofbirth);
        t10.setBounds(620, 350, 250, 30);
        t10.setFont(new Font("Arial", Font.PLAIN, 20));
        bg.add(t10);
        
        b1 = new JButton("Update");
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.WHITE);
        b1.setBorder(null);
        b1.setFont(new Font("Arial", Font.BOLD, 20));
        b1.setBounds(250, 500, 150, 40);
        b1.addActionListener(this);
        
        b2 = new JButton("Cancel");
        b2.setBackground(Color.MAGENTA);
        b2.setForeground(Color.WHITE);
        b2.setBorder(null);
        b2.setFont(new Font("Arial", Font.BOLD, 20));
        b2.setBounds(450, 500, 150, 40);
        b2.addActionListener(this);
        
        bg.add(b1);
        bg.add(b2);
        
        
        jp.setLayout(null);
        add(jp);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(ae.getActionCommand().equals("Update")){
            t1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            t2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            t3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            t4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            t7.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            t9.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            t10.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            
            firstname = t1.getText();
            lastname = t2.getText();
            email = t3.getText();
            phoneno = t4.getText();
            department = (String)bx1.getSelectedItem();
            jobtitle = (String)bx2.getSelectedItem();
            hiredate = t7.getText();
            salary = t9.getText();
            dateofbirth = t10.getText();
            
            int flag = 0, empt = 0;
            
            
            if(firstname.equals("")){
                empt = 1;
                t1.setBorder(BorderFactory.createLineBorder(Color.RED));
                
            }
            if(lastname.equals("")){
                empt = 1;
                t2.setBorder(BorderFactory.createLineBorder(Color.RED));
            }
            if(email.equals("")){
                empt = 1;
                t3.setBorder(BorderFactory.createLineBorder(Color.RED));
            }
            if(phoneno.equals("")){
                empt = 1;
                t4.setBorder(BorderFactory.createLineBorder(Color.RED));
            }
            if(hiredate.equals("") || hiredate.equals("YYYY-MM-DD")){
                empt = 1;
                t7.setBorder(BorderFactory.createLineBorder(Color.RED));
            }
            if(salary.equals("")){
                empt = 1;
                t9.setBorder(BorderFactory.createLineBorder(Color.RED));
            }
            if(dateofbirth.equals("") || dateofbirth.equals("YYYY-MM--DD")){
                empt = 1;
                t10.setBorder(BorderFactory.createLineBorder(Color.RED));
            }
            if(empt == 1){
                JOptionPane.showMessageDialog(f, "Please fill all values",
               "Error", JOptionPane.WARNING_MESSAGE);
            }
            if(empt != 1){
                if(!hiredate.matches("^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$")){
                    JOptionPane.showMessageDialog(f, "Write the correct format of date YYYY-MM--DD",
                   "Error", JOptionPane.WARNING_MESSAGE);
                    t7.setBorder(BorderFactory.createLineBorder(Color.RED));
                    flag = 1;
                }
                if(!dateofbirth.matches("^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$")){
                    JOptionPane.showMessageDialog(f, "Write the correct format of date YYYY-MM--DD",
                   "Error", JOptionPane.WARNING_MESSAGE);
                    t10.setBorder(BorderFactory.createLineBorder(Color.RED));
                    flag = 1;
                }
                if(phoneno.length() != 10){
                    JOptionPane.showMessageDialog(f, "Enter 10 digits of phone number!",
                   "Error", JOptionPane.WARNING_MESSAGE);
                    t4.setBorder(BorderFactory.createLineBorder(Color.RED));
                    flag = 1;
                }
                if(!phoneno.matches("[0-9]+")){
                    JOptionPane.showMessageDialog(f, "Enter only digits for phone number",
                   "Error", JOptionPane.WARNING_MESSAGE);
                    t4.setBorder(BorderFactory.createLineBorder(Color.RED));
                    flag = 1;
                }
                if(!salary.matches("([0-9]*[.])?[0-9]+")){
                    JOptionPane.showMessageDialog(f, "Enter only digits for salary",
                   "Error", JOptionPane.WARNING_MESSAGE);
                    t9.setBorder(BorderFactory.createLineBorder(Color.RED));
                    flag = 1;
                }
            }
            
            
            if(flag == 0 && empt == 0){
                try{
                    float salaryN = Float.parseFloat(salary);
                    ConnectionClass obj = new ConnectionClass();
                    String q1 = "UPDATE PersonalInformation SET FirstName = '"+firstname+"', LastName = '"+lastname+"', Email = '"+email+
                            "', PhoneNumber = '"+phoneno+"', DateOfBirth = '"+dateofbirth+"' WHERE EmployeeID ="+ employeeId + ";";
                    String q2 = "UPDATE JobDetails SET JobTitle = '"+jobtitle+"', Department = '"+department+"', HireDate = '"+hiredate+"' WHERE EmployeeID = "+employeeId+";";
                    String q3 = "UPDATE SalaryInformation SET Salary = "+salaryN+" WHERE EmployeeID = "+employeeId+";";
                    
                    obj.stm.addBatch(q1);
                    obj.stm.addBatch(q2);
                    obj.stm.addBatch(q3);
                    
                    obj.stm.executeBatch();
                    JOptionPane.showMessageDialog(f, "Successfully Updated!");
                    setVisible(false);
                    new HomePage().setVisible(true);
                    
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        if(ae.getActionCommand().equals("Cancel")){
            new Update_Details().setVisible(true);
            setVisible(false);
        }
        if(source.equals(bx1)){
            JComboBox cb = (JComboBox)source;
            String dept = (String)cb.getSelectedItem();
            
//            "IT", "Finance", "Customer Care", "Ware House"};
            if(dept.equals("IT")){
                bx2.setModel(new javax.swing.DefaultComboBoxModel(it));
            }else if(dept.equals("Finance")){
                bx2.setModel(new javax.swing.DefaultComboBoxModel(finance));
            }else if(dept.equals("Customer Care")){
                bx2.setModel(new javax.swing.DefaultComboBoxModel(customercare));
            }else{
                bx2.setModel(new javax.swing.DefaultComboBoxModel(warehouse));
            }
        }
    }
    public static void main(String [] args){
        new Update_Details_Data("7").setVisible(true);
    }
}
