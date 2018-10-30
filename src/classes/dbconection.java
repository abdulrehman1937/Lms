/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;
import java.sql.*;
import javax.swing.JOptionPane;

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
            JOptionPane.showMessageDialog(null, e);
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
            JOptionPane.showMessageDialog(null, e);
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
            JOptionPane.showMessageDialog(null, e);
            
        }
        
    }
    public void insertreq(String username,int book)
    {
        
        try
        {
            PreparedStatement statement;
          String mysql="INSERT INTO book_req " +
                   "VALUES (?, ?)";
            statement = con.prepareStatement(mysql);
            statement.setInt(1, book);
            statement.setString(2, username);
            statement.executeUpdate();
            
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
            
        }
        
    }
    public void insertret(String username,int book)
    {
        
        try
        {
            PreparedStatement statement;
          String mysql="INSERT INTO book_ret " +
                   "VALUES (?, ?)";
            statement = con.prepareStatement(mysql);
            statement.setInt(1, book);
            statement.setString(2, username);
            statement.executeUpdate();
            
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
            
        }
        
    }
     public void insertloan(int id,String username,java.util.Date issue, java.util.Date retdate,java.util.Date returneddate,int returned,int fine,int copyno)
    {
        
        try
        {
            PreparedStatement statement;
          String mysql="INSERT INTO book_loan " +
                   "VALUES (?,?,?,?,?,?,?,?)";
            statement = con.prepareStatement(mysql);
            statement.setInt(1, id);
            statement.setString(2, username);
            Date issue_date=new Date(issue.getTime());
            Date ret_date=new Date(retdate.getTime());
            
            Date returned_date=new Date(returneddate.getTime());
            statement.setDate(3, issue_date);
            statement.setDate(4,ret_date);
            statement.setDate(5,returned_date);
            statement.setInt(6, returned);
            statement.setInt(7, fine);
            statement.setInt(8, copyno);
            
            statement.executeUpdate();
            
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
            
        }
        
    }
    public void delreq(String username,int book)
    {
        
        try
        {
            PreparedStatement statement;
          String mysql="delete from book_req where ln_username=? and bk_id=?";
            statement = con.prepareStatement(mysql);
            statement.setInt(2, book);
            statement.setString(1, username);
            statement.executeUpdate();
            
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
            
        }
        
    }
    public void delret(String username,int book)
    {
        
        try
        {
            PreparedStatement statement;
          String mysql="delete from book_ret where ln_username=? and bk_id=?";
            statement = con.prepareStatement(mysql);
            statement.setInt(2, book);
            statement.setString(1, username);
            statement.executeUpdate();
            
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
            
        }
        
    }
    public void delregister(String username)
    {
        
        try
        {
            PreparedStatement statement;
          String mysql="delete from newusers where n_id=?";
            statement = con.prepareStatement(mysql);
            
            statement.setString(1, username);
            statement.executeUpdate();
            
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
            
        }
        
    }
    public void updateloan(String username,int book,java.util.Date issue,java.util.Date returned,int fine)
    {
        
        try
        {
            PreparedStatement statement;
          String mysql="UPDATE book_loan SET returneddate =?, fine=? ,Returned=1 WHERE ln_username =? and bk_id=? and issue_date=?";
            statement = con.prepareStatement(mysql);
            Date returned_date=new Date(returned.getTime());
            statement.setDate(1, returned_date);
            statement.setInt(2, fine);
            statement.setString(3, username);
            statement.setInt(4, book);
            Date issue_date=new Date(issue.getTime());
            statement.setDate(5, issue_date);
            statement.executeUpdate();
            
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
            
        }
        
    }
    
        
    public ResultSet executepre(String username) throws SQLException
    {
        
        PreparedStatement statement;
          String mysql="select * from login where u_id = ?";
            statement = con.prepareStatement(mysql); 
        
        statement.setString(1, username);
        try
        {
            return statement.executeQuery();
            
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    
    public void updateBook(int id,String Title,String Author,String Subject,String Edition)
    {
        try
        {
            PreparedStatement statement;
          String mysql="UPDATE book SET bk_title =?, bk_edition=? ,bk_author=? ,bk_subject=? WHERE bk_id=?";
            statement = con.prepareStatement(mysql);
            
            statement.setInt(5, id);
            statement.setString(1, Title);
            statement.setString(2, Edition);
            statement.setString(3, Author);
            statement.setString(4, Subject);
            statement.executeUpdate();
            
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
            
        }
    }
    public void updateUser(String username,String name,String email,String pno,String pass)
    {
       try
        {
            PreparedStatement statement;
          String mysql="UPDATE Users SET u_name =?, u_email=? ,u_phone=? WHERE u_id=?";
            statement = con.prepareStatement(mysql);
            
            
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, pno);
            statement.setString(4, username);
            
            statement.executeUpdate();
            updatepass(username,pass);
            
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
            
        } 
    }
    public void updatepass(String username,String newpass)
    {
        try
        {
            PreparedStatement statement;
          String mysql="UPDATE login SET u_password=? WHERE u_id=?";
            statement = con.prepareStatement(mysql);
            
            statement.setString(1, newpass);
            statement.setString(2, username);
            statement.executeUpdate();
            
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
            
        } 
    }
    public void addpass(String username,String newpass)
    {
        try
        {
            PreparedStatement statement;
          String mysql="INSERT INTO login VALUES (?, ?)";;
            statement = con.prepareStatement(mysql);
            
            statement.setString(1, username);
            statement.setString(2, newpass);
            statement.executeUpdate();
            
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
            
        } 
    }
    public void adduser(String username,String name,String email,String pass,String pno)
    {
        
        try
        {
            PreparedStatement statement;
          String mysql="INSERT INTO Users " +
                   "VALUES (?, ?, ?,0,1,?)";
            statement = con.prepareStatement(mysql);
            statement.setString(1, username);
            statement.setString(2, name);
            statement.setString(3, email);
            statement.setString(4, pno);
            statement.executeUpdate();
            addpass(username,pass);
            
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
            
        }
        
    }
    public void addbook(int id,String Title,String Author,String Subject,String Edition,int copies)
    {
        
        try
        {
            PreparedStatement statement;
          String mysql="INSERT INTO book " +
                   "VALUES (?, ?, ?, ?, ?, ?)";
            statement = con.prepareStatement(mysql);
            statement.setInt(1, id);
            statement.setString(2, Title);
            statement.setString(3, Edition);
            statement.setString(4, Author);
            statement.setString(5, Subject);
            statement.setInt(6, copies);
            statement.executeUpdate();
            addbookstatus(id,copies);
            
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
            
        }
        
    }
    public void addbookstatus(int id,int copies)
    {
        
        try
        {
            for(int i=0;i<copies;i++)
            {
            PreparedStatement statement;
          String mysql="INSERT INTO book_copies " +
                   "VALUES (?, ?,1)";
            statement = con.prepareStatement(mysql);
            statement.setInt(1, id);
            statement.setInt(2,i);
            statement.executeUpdate();
            }
            
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
            
        }
    }
    public void updatebookstatus(int id,int copyno,int status)
    {
        
        try
        {
            
            PreparedStatement statement;
          String mysql="UPDATE book_copies SET bk_status=? WHERE bk_id=? and bk_cpno=?";
            statement = con.prepareStatement(mysql);
            statement.setInt(2, id);
            statement.setInt(1,status);
            statement.setInt(3,copyno);
            statement.executeUpdate();
            
            
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
            
        }
    }
    public void deleteuser(String username)
    {
        try
        {
            
            PreparedStatement statement;
          String mysql="delete from Users WHERE u_id=?";
            statement = con.prepareStatement(mysql);
            statement.setString(1, username);
            statement.executeUpdate();
            
            
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
            
        }
    }
    public void deletebook(int id)
    {
        try
        {
            
            PreparedStatement statement;
          String mysql="delete from book WHERE bk_id=?";
            statement = con.prepareStatement(mysql);
            statement.setInt(1, id);
            statement.executeUpdate();
            
            
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
            
        }
    }
        
}
