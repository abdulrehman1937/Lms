/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ListIterator;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaapplication3.Borrower;
import javaapplication3.Clerk;
import javaapplication3.Librarian;
import javax.swing.JOptionPane;
/**
 *
 * @author abdul
 */
public class Library {
    private Users_class activeuser;
    private ArrayList<Users_class> allusers;
    private ArrayList<Book>allbooks;
    private ArrayList<register_class> newusers;
     private ArrayList<Book_User> booksreq;
    private ArrayList<Book_User> booksret;
    private ArrayList<Book_loan> historyOfLoans;
    public void seteveything(ArrayList<Users_class> allusers,ArrayList<Book>allbooks,ArrayList<register_class> newusers,ArrayList<Book_User> booksreq,ArrayList<Book_User> booksret,ArrayList<Book_loan> historyOfLoans)
    {
        this.allbooks=allbooks;
        this.allusers=allusers;
        this.newusers=newusers;
        this.booksreq=booksreq;
        this.booksret=booksret;
        this.historyOfLoans=historyOfLoans;
    }
        
    public Library() 
    {
        this.newusers=null;
        this.allbooks=null;
        this.allusers=null;
        this.booksreq=null;
        this.booksret=null;
        this.historyOfLoans=null;
    }
    public Library(ArrayList<Users_class> allusers,ArrayList<Book>allbooks,ArrayList<Book_loan>books_loan,ArrayList<Book_User>booksreq,ArrayList<Book_User>booksret, ArrayList<register_class> newusers)
    {
        this.newusers=newusers;
        this.allbooks=allbooks;
        this.allusers=allusers;
        this.booksreq=booksreq;
        this.booksret=booksret;
        this.historyOfLoans=books_loan;
    }
    public void setLoanedbooks(ArrayList<Book_loan> historyOfLoans)
    {
        this.historyOfLoans=historyOfLoans;
    }
    public void setreqret(ArrayList<Book_User> bookreq,ArrayList<Book_User> bookret)
    {
        this.booksreq=bookreq;
        this.booksret=bookret;
    }
    public void reqbook(Book_User obj)
    {
       /* ListIterator<Users_class> it=null;
        it=allusers.listIterator();
        while(it.hasNext()){
	   if(it.next().user_type()==2)
           {
               it.next().reqBook(obj);
           }
	}*/
        booksreq.add(obj);
        insertintoreq(obj.getBook().getId(),obj.getUser().username);
        
    }
    public void delreq(int bk_id,String username)
    {
        dbconection db=new dbconection();
        db.delreq(username, bk_id);
    }
    public void insertintoreq(int bk_id,String username)
    {
        dbconection db=new dbconection();
        db.insertreq(username, bk_id);
        
    }
    public void retbook(Book_User obj)
    {
        /*ListIterator<Users_class> it=null;
        it=allusers.listIterator();
        while(it.hasNext()){
	   if(it.next().user_type()==2)
           {
               it.next().retBook(obj);
           }
	}*/
        booksret.add(obj);
        this.insertintoret(obj.getBook().getId(), obj.getUser().username);
    }
     public void insertintoret(int bk_id,String username)
    {
        dbconection db=new dbconection();
        db.insertret(username, bk_id);
        
    }
      public void delret(int bk_id,String username)
    {
        dbconection db=new dbconection();
        db.delret(username, bk_id);
    }
    public void removefromreq(Book_User obj)
    {
        /*ListIterator<Users_class> it=null;
        it=allusers.listIterator();
        while(it.hasNext()){
	   if(it.next().user_type()==2)
           {
               it.next().removereq(obj);
        }*/
        booksreq.remove(obj);
        delreq(obj.getBook().getId(),obj.getUser().username);
    }
    public void removefromreq(int index)
    {
        /*ListIterator<Users_class> it=null;
        it=allusers.listIterator();
        while(it.hasNext()){
	   if(it.next().user_type()==2)
           {
               it.next().removereq(obj);
        }*/
        delreq(booksreq.get(index).getBook().getId(),booksreq.get(index).getUser().username);
        booksreq.remove(index);
    }
    public void removefromret(Book_User obj)
    {
        /*
        ListIterator<Users_class> it=null;
        it=allusers.listIterator();
        while(it.hasNext()){
	   if(it.next().user_type()==2)
           {
               it.next().removeret(obj);
           }
	}
        */
        booksret.remove(obj);
        this.delret(obj.getBook().getId(), obj.getUser().username);
    }
    
    
    public Book_User getfromreq(int index)
    {
        /*
        ListIterator<Users_class> it=null;
        it=allusers.listIterator();
        while(it.hasNext()){
	   if(it.next().user_type()==2)
           {
               it.next().removeret(obj);
           }
	}
        */
        return booksreq.get(index);
    
    }
    public Book_User getfromret(int index)
    {
        /*
        ListIterator<Users_class> it=null;
        it=allusers.listIterator();
        while(it.hasNext()){
	   if(it.next().user_type()==2)
           {
               it.next().removeret(obj);
           }
	}
        */
        return booksret.get(index);
    
    }
    public void addbook(Book a)
    {
        allbooks.add(a);
    }
    public void addnewbook(Book a)
    {
        allbooks.add(a);
        this.addnewbookdata(a.getId(), a.getTitle(), a.getAuthor(), a.getSubject(), a.getEdition(), a.getcopyies());
    }
    public void addnewbookdata(int id,String Title,String Author,String Subject,String Edition,int copies)
    {
        dbconection db=new dbconection();
        db.addbook(id, Title, Author, Subject, Edition, copies);
    }
    public void removebook(int id)
    {
        ListIterator<Book>it=null;
        it=allbooks.listIterator();
        Book temp=new Book();
        while(it.hasNext())
        {
            temp=it.next();
            if(temp.getId()==id)
            {
                break;
            }
        }
        this.removebookdata(id);
        allbooks.remove(temp);
    }
    public void removebookdata(int id)
    {
        dbconection db=new dbconection();
        db.deletebook(id);
    }
    public void adduser(Users_class a)
    {
        allusers.add(a);
    }
     public void addnewuser(Users_class a,String pass)
    {
        allusers.add(a);
       this.addnewuserrdata(a.username, a.Name, a.Email, pass, a.PhoneNumber);
        
    }
     public void addnewuserrdata(String username,String name,String email,String pass,String pno)
     {
         dbconection db=new dbconection();
         db.adduser(username, name, email, pass, pno);
     }
    public void removeuser(String Username)
    {
        Users_class a=new Users_class();
        ListIterator<Users_class>it=null;
        it=allusers.listIterator();
        while(it.hasNext())
        {
            a=it.next();
            if(a.username.equals(Username))
                break;
        }
        allusers.remove(a);
        this.removeuserdata(Username);
    }
    public void removeuserdata(String username)
    {
        dbconection db=new dbconection();
        db.deleteuser(username);
    }
    public void addtohistory(Book_loan a)
    {
        this.historyOfLoans.add(a);
        addtobookloan(a.getbook().getId(),a.getuser().username,a.get_issue(),a.get_retdate(),a.get_returneddate(),a.get_returned(),a.getfine(),a.getcopy());
    }
    public void addtobookloan(int id,String username,Date issue, Date retdate,Date returneddate,int returned,int fine,int copyno)
    {
        dbconection db=new dbconection();
        db.insertloan(id, username, issue, retdate, returneddate, returned, fine, copyno);
    }
    
    public ArrayList<Book> Search(String Name)
    {
        ArrayList<Book> temp=new ArrayList<>();
        String name=Name.toLowerCase();
        Book a=new Book();
        ListIterator<Book>it=allbooks.listIterator();
        while(it.hasNext())
        {
            a=it.next();
            String searchwith=a.getTitle().toLowerCase();
            if(searchwith.contains(name) ||searchwith.equals(name) && a.isStatus()!=-1)
            {
                temp.add(a);
            }
        }
        return temp;
    }
    public boolean Searchbyid(int id)
    {
        Book a=new Book();
        ListIterator<Book>it=allbooks.listIterator();
        while(it.hasNext())
        {
            a=it.next();
            if(a.getId()==id)
            {
                return true;
            }
        }
        return false;
    }
    public Users_class signeduser(String username,String password,int type)
    {
        Users_class a=new Users_class();
        ListIterator<Users_class>it=null;
        it=allusers.listIterator();
        while(it.hasNext())
        {
            a=it.next();
            if(a.validate(username, password) && a.user_type()==type)
            {
                return a;
            }
        }
        return null;
    }
    public ArrayList<Users_class> getallusers()
    {
        return allusers;
    }
    public ArrayList<register_class> getnewusers()
    {
        return newusers;
    }
    public ArrayList<Book_User> getreq()
    {
        return booksreq;
        
    }
    public ArrayList<Book_User> getret()
    {
        return booksret;
        
        
    }
    /*public void setBookStatus(Book_User a,int status)
    {
        int index=allbooks.indexOf(a.getBook());
        allbooks.get(index).setStatus(status);
        
    }*/
    public boolean Searchbookret(String Username,Book obj)
    {
        ListIterator<Book_User> it=null;
        it=booksret.listIterator();
        while(it.hasNext())
        {
            Book_User temp=it.next();
            if(temp.getBook().equals(obj) && temp.getUser().username.equals(Username))
            {
                return true;
            }
            
        }
        return false;
    }
    public boolean Searchbookreq(String Username,Book obj)
    {
        ListIterator<Book_User> it=null;
        it=booksreq.listIterator();
        while(it.hasNext())
        {
            Book_User temp=it.next();
            if(temp.getBook().equals(obj) && temp.getUser().username.equals(Username))
            {
                return true;
            }
            
        }
        return false;
    }
    public boolean SearchUser(String username)
    {
        ListIterator<Users_class> it=null;
        it=allusers.listIterator();
        while(it.hasNext())
        {
            Users_class temp=it.next();
            if(temp.username.equals(username))
            {
                return true;
            }
        }
        return false;
    }
    public void updateUser(String username,String name,String email,String pno,String pass)
    {
        ListIterator<Users_class> it=null;
        it=allusers.listIterator();
        Users_class temp=null;
        while(it.hasNext())
        {
            temp=it.next();
            if(temp.username==username)
            {
                break;
            }
        }
        temp.Email=email;
        temp.Name=name;
        temp.PhoneNumber=pno;
        temp.credentials.chage_Pass(pass);
        this.updateUserdata(username, name, email, pno, pass);
    }
    public void updateUserdata(String username,String name,String email,String pno,String pass)
    {
        dbconection db=new dbconection();
        db.updateUser(username, name, email, pno, pass);
    }
    public register_class getregister(int index)
    {
        return this.newusers.get(index);
    }
    public void removenewuser(int index)
    {
        this.removenewuserdata(newusers.get(index).getusername());
        newusers.remove(index);
        
    }
    public void removenewuserdata(String username)
    {
        dbconection db=new dbconection();
        db.delregister(username);
    }
    public void updateBook(int id,String Title,String Author,String Subject,String Edition)
    {
        Book temp=null;
        ListIterator<Book> it=null;
        it=allbooks.listIterator();
        while(it.hasNext())
        {
            temp=it.next();
            if(temp.getId()==id)
            {
                break;
            }
        }
        temp.setAuthor(Author);
        temp.setEdition(Edition);
        temp.setSubject(Subject);
        temp.setTitle(Title);
        this.updateBookdata(id, Title, Author, Subject, Edition);
    }
    public void updateBookdata(int id,String Title,String Author,String Subject,String Edition)
    {
        dbconection db=new dbconection();
        db.updateBook(id, Title, Author, Subject, Edition);
    }
    public ArrayList<Book_loan> giveHistory()
    {
        return this.historyOfLoans;
    }
    public void updateHistory(Book_loan objprev,Book_loan obj)
    {
        int index=this.historyOfLoans.indexOf(objprev);
        updateloan(obj.getuser().username,obj.getbook().getId(),obj.get_issue(),obj.get_returneddate(),obj.getfine());
        this.historyOfLoans.set(index, obj);
    }
    public void updateloan(String username,int book,Date issue,Date returned,int fine)
    {
        dbconection db=new dbconection();
        db.updateloan(username, book, issue, returned, fine);
    }
    public int setBookstatus(Book a,int status)
    {
        int copyno=a.isStatus();
        a.setStatus(status, copyno);
        dbconection db=new dbconection();
        db.updatebookstatus(a.getId(), copyno, status);
        return copyno;
    }
    public int setBookstatusreturn(Book a,int copyno)
    {
       
        a.setStatus(1, copyno);
        dbconection db=new dbconection();
        db.updatebookstatus(a.getId(), copyno, 1);
        return copyno;
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
            JOptionPane.showMessageDialog(null, ex);
        }
        
            users=getAllusers();
        
        try {
            booksreq=bookreq(users,books);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        try {
            booksret=bookret(users,books);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        try {
            booksloan=books_loan(users,books);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        newusers=getnewusers();
         this.seteveything(users, books, newusers, booksreq, booksret,booksloan);
         setAlllib(this);
       
        
        
        
        
        
        
        
        
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
            else if(type==3)
            {
                Librarian ab=new Librarian(activeuser);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Wrong usertype");
            }
        }
        
        
    }
    public  ArrayList<register_class> getnewusersdb() throws SQLException
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
        
            Library lib=new Library();
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
            Date returneddate=rs1.getDate("returneddate");
            Book_loan temploan=new Book_loan(b,a,issue,retdate,returneddate,0,bk_copyno);
            b.addloanedbook(temploan);
            books.add(temploan);
        }
        else
        {
            Date returneddate=rs1.getDate("returneddate");
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
public boolean signin(String username,String Password,int type,Library lib)
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


public Book_loan getmyhistory(String Username,int id)
{
    ListIterator<Book_loan> it=null;
    it=this.historyOfLoans.listIterator();
    Book_loan temp=null;
    while(it.hasNext())
    {
        temp=it.next();
        if(temp.getuser().username==Username && temp.getbook().getId()==id)
        {
            return temp;
        }
    }
    return null;
}
}

