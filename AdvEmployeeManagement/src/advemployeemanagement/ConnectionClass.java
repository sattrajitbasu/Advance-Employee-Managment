package AdvEmployeeManagement;
import java.sql.*;

/**
 *
 * @author SATTRAJIT
 */
public class ConnectionClass {
    
    Connection con;
    Statement stm;
    
    ConnectionClass(){
        try{
//            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject","root","root");
            if(con != null){
                System.out.println("Success!!");
            }
            stm = con.createStatement();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        new ConnectionClass();
    }
}
