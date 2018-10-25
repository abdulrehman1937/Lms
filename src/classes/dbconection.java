/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;
import java.sql.*;

/**
 *
 * @author abdul
 */
public class dbconection 
{
        Connection con;
    Statement stmt;
    
    dbconection() //cons
    {
        
        try
        {
             String s = "jdbc:sqlserver://localhost:1433;databaseName=lms";
             con=DriverManager.getConnection(s,"ars1937","admin");
           
            stmt = con.createStatement(); 
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public ResultSet execute(String query)
    {
        ResultSet rs=null;
        try
        {
            rs=stmt.executeQuery(query);
            
        }
        catch(SQLException e)
        {
            System.out.println(e);
            return null;
        }
        return rs;
    }
    public void executeupdatenuser(String username,String name,String email,String pass,String pno)
    {
        
        try
        {
            PreparedStatement statement;
          String mysql="INSERT INTO newusers " +
                   "VALUES (?, ?, ?, ?,?)";
            statement = con.prepareStatement(mysql);
            statement.setString(1, username);
            statement.setString(2, name);
            statement.setString(3, email);
            statement.setString(4, pass);
            statement.setString(5, pno);
            statement.executeUpdate();
            
        }
        catch(SQLException e)
        {
            System.out.println(e);
            
        }
        
    }
    
        
    public ResultSet executepre(String username) throws SQLException
    {
        
        PreparedStatement statement;
          String mysql="select * from login where u_id = ?";
            statement = con.prepareStatement(mysql); 
            String a=statement.toString();
        
        statement.setString(1, username);
        try
        {
            return statement.executeQuery();
            
        }
        catch(SQLException e)
        {
            System.out.println(e);
            return null;
        }
    }
    
    
}
