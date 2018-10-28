/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;
import javaapplication3.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author abdul
 */
public final class driver {
    private static Library lib;
    private Users_class activeuser;
    public driver() throws SQLException
    {
        init();
    }
    public void init() throws SQLException {
        
        ArrayList<Book> books=null;
        ArrayList<Users_class> users=null;
        ArrayList<Book_User> booksreq=null;
        ArrayList<Book_User> booksret=null;
        ArrayList<Book_loan> booksloan=null;
        ArrayList<register_class> newusers=null;
        
        try {
            books=getAllBooks();
        } catch (SQLException ex) {
            Logger.getLogger(driver.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            users=getAllusers();
        
        try {
            booksreq=bookreq(users,books);
        } catch (SQLException ex) {
            Logger.getLogger(driver.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            booksret=bookret(users,books);
        } catch (SQLException ex) {
            Logger.getLogger(driver.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            booksloan=books_loan(users,books);
        } catch (SQLException ex) {
            Logger.getLogger(driver.class.getName()).log(Level.SEVERE, null, ex);
        }
        newusers=getnewusers();
         lib=new Library(users,books,booksloan,booksreq,booksret,newusers);
         setAlllib(lib);
       
        
        
        
        
        
        
        
        
    }
    public void signmein()
    {
        if(activeuser!=null)
        {
            
            int type=activeuser.user_type();
            if(type==1)
            {
                Borrower ab=new Borrower(activeuser);
            }
            else if(type==2)
            {
                Clerk ab=new Clerk(activeuser);
            }
            else
            {
                Librarian ab=new Librarian(activeuser);
            }
        }
        
    }
    public  ArrayList<register_class> getnewusers() throws SQLException
    {
        dbconection db=new dbconection();
        ArrayList<register_class> newusers=new ArrayList<>();
        String query="Select * from newusers";
        ResultSet rs=db.execute(query);
        while (rs.next())
      {
        String username = rs.getString("n_id");
        String Name = rs.getString("n_name");
        String Email = rs.getString("n_email");
        String pno=rs.getString("n_phone");
        String pass=rs.getString("n_password");
        register_class temp=new register_class(username,pass,pno,Email,Name);
        newusers.add(temp);
    }
        return newusers;
    }
    public ArrayList<Book> getAllBooks() throws SQLException
    {
        
        dbconection db=new dbconection();
        ArrayList<Book> allbooks=new ArrayList<>();
        String query="Select * from book";
        
        
        ResultSet rs=db.execute(query);
        while (rs.next())
      {
        int id = rs.getInt("bk_id");
        String Title = rs.getString("bk_title");
        String Edition = rs.getString("bk_edition");
        String Author=rs.getString("bk_author");
        String Subject=rs.getString("bk_subject");
        int noofcopies = rs.getInt("bk_copies");
        ArrayList<Integer>noof=getstatus(id);
        Book temp=new Book(id,Title,Author,Subject,Edition,noofcopies,noof);
        allbooks.add(temp);
      }
        return allbooks;
    }
    public ArrayList<Integer> getstatus(int id) throws SQLException
    {
        dbconection db=new dbconection();
       String query="Select * from book_copies where bk_id="+"'"+id+"'"+" order by bk_cpno asc";
        ArrayList<Integer> noof=new ArrayList<>();   
       int i=0;
        ResultSet rs1=db.execute(query);
         while (rs1.next())
      {
          noof.add(i, rs1.getInt("bk_status"));
          i++;
      }
         return noof;
    }
    public  ArrayList<Users_class> getAllusers() throws SQLException
    {
        ResultSet rs;
        dbconection db=new dbconection();
        String query="Select * from Users";
        ArrayList<Users_class> allusers=new ArrayList<>();
        rs=db.execute(query);
        while (rs.next())
      {
        String username = rs.getString("u_id");
        String Name = rs.getString("u_name");
        String Email = rs.getString("u_email");
        int type = rs.getInt("u_type");
        String pno=rs.getString("u_phone");
        
            
           String Password=getthispassword(username);
            login a=new login(username,Password);
        ArrayList<Book_loan> Books=new ArrayList<>();
        if(type==1)
        {
            
            Borrower_class temp=new Borrower_class(Name,username,Email,pno,Books,a,lib);
            allusers.add(temp);
        }
        else if(type==2)
        {
            Clerk_class temp=new Clerk_class(Name,username,Email,pno,Books,a,lib);
            allusers.add(temp);
        }
        else
        {
            Librarian_class temp=new Librarian_class(Name,username,Email,pno,Books,a,lib);
            allusers.add(temp);
        }
      }
        return allusers;
    }
    
    public Book getBook(int id,ArrayList<Book>allbooks)
    {
        ListIterator<Book> it=null;
        it=allbooks.listIterator();
        while(it.hasNext())
        {
            Book temp=it.next();
            if(temp.getId()==id)
            {
                return temp;
            }
        }
        return null;
    }
    public Users_class getUser(String username,ArrayList<Users_class>allusers)
    {
        ListIterator<Users_class> it=null;
        it=allusers.listIterator();
        while(it.hasNext())
        {
            Users_class temp=it.next();
            if(temp.username.equals(username))
            {
                return temp;
            }
        }
        return null;
    }
public ArrayList<Book_loan> books_loan(ArrayList<Users_class> allusers,ArrayList<Book> allbooks) throws SQLException
{
    
    
    ArrayList<Book_loan> books=new ArrayList<>();
    String query="Select * from book_loan";
    dbconection db=new dbconection();
    ResultSet rs1=db.execute(query);
    while (rs1.next())
    {
                    
        String username=rs1.getString("ln_username");
        int id=rs1.getInt("bk_id");
        int bk_copyno=rs1.getInt("bk_cpno");
        Date issue=rs1.getDate("issue_date");
        Date retdate=rs1.getDate("retdate");
        if(rs1.getInt("Returned")==0)
        {
            Book a=getBook(id,allbooks);
            Users_class b=getUser(username,allusers);
            
            Book_loan temploan=new Book_loan(b,a,issue,retdate,null,0,bk_copyno);
            b.addloanedbook(temploan);
            books.add(temploan);
        }
        else
        {
            Date returneddate=rs1.getDate("retereneddate");
            int fine=rs1.getInt("fine");
            Book a=getBook(id,allbooks);
            Users_class b=getUser(username,allusers);
            Book_loan temploan=new Book_loan(b,a,issue,retdate,returneddate,fine,bk_copyno);
            books.add(temploan);
         }
        
        }
        return books;
    }
public ArrayList<Book_User> bookreq(ArrayList<Users_class> allusers,ArrayList<Book> allbooks) throws SQLException
{
    ArrayList<Book_User> booksreq=new ArrayList<>();
    String query="Select * from book_req";
    dbconection db=new dbconection();
    ResultSet rs1=db.execute(query);
    while (rs1.next())
    {   
        String Username=rs1.getString("ln_username");
        int n_id=rs1.getInt("bk_id");
        Users_class a=getUser(Username,allusers);
        Book b=getBook(n_id,allbooks);
        Book_User temp=new Book_User(a,b);
        booksreq.add(temp);
        
    }
    return booksreq;
}
public ArrayList<Book_User> bookret(ArrayList<Users_class> allusers,ArrayList<Book> allbooks) throws SQLException
{
    ArrayList<Book_User> booksret=new ArrayList<>();
    String query="Select * from book_ret";
    dbconection db=new dbconection();
    ResultSet rs1=db.execute(query);
    while (rs1.next())
    {   
        String Username=rs1.getString("ln_username");
        int n_id=rs1.getInt("bk_id");
        Users_class a=getUser(Username,allusers);
        Book b=getBook(n_id,allbooks);
        Book_User temp=new Book_User(a,b);
        booksret.add(temp);
        
    }
    return booksret;
}
public boolean signin(String username,String Password,int type)
{
    activeuser=lib.signeduser(username, Password, type);
    if(activeuser==null)
    {
        return false;
    }
    return true;
}
public String getthispassword(String username) throws SQLException
{
    dbconection db=new dbconection();
     ResultSet rs1=db.executepre(username);
           // query="select * from login where u_id='ars1937'";
            //rs1=db.execute(query);
            String password=null;
             while (rs1.next())
      {
          
          
            password=rs1.getString(2);
      }
             return password;
}

public void setAlllib(Library lib)
{
    ListIterator<Users_class>it=lib.getallusers().listIterator();
    while(it.hasNext())
    {
        it.next().setlib(lib);
    }
}
}