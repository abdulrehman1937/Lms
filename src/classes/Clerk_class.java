/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;
import java.util.ListIterator;
import java.util.ArrayList;

/**
 *
 * @author abdul
 */
public class Clerk_class extends Borrower_class {
   
  //  public ArrayList<Borrower_class> allstudents;
    public Clerk_class() {
        
        username=null;
        Name=null;
        Email=null;
        Books = null;
      //  Password=null;
        PhoneNumber=null;
    //    allstudents=null;
        
    }
    public Clerk_class(String Name,String Username,String Email,String PhoneNumber,ArrayList<Book_loan> Books,login a,Library lib)
    {
        this.lib=lib;
        this.username=Username;
        this.Name=Name;
        this.PhoneNumber=PhoneNumber;
        this.Email=Email;
        this.Books=Books;
        this.credentials=a;
      //  this.allstudents=allstudents;
    }
    
    
    
   /* @Override
    public void reqBook(Book_User a)
    {
       booksreq.add(a);
    }
   
    @Override
    public void retBook(Book_User a)
    {
       booksret.add(a);
    }
    public void delloanedbook(Book_loan book)
    {
        Books.remove(book);
    }
*/
    @Override
    public void check_in(Book_User a)
    {
        lib.removefromret(a);
        a.getBook().setStatus(1);
        int aa=a.getUser().Books.indexOf(a);
        Book_loan obj=a.getUser().getbookobj(a.getBook());
        obj.setActualDate();
        lib.addtohistory(obj);
        a.getUser().delBook(obj);
    }
    @Override
    public void check_out(Book_User a)
    {
        lib.removefromreq(a);
        lib.setBookStatus(a, 0);
        Book_loan obj=new Book_loan(a.getUser(),a.getBook());
        
        a.getUser().addloanedbook(obj);
        
    }
    @Override
    public int user_type()
    {
        return 2;
    }
    
    /*@Override
    public void removereq(Book_User obj)
    {
        booksreq.remove(obj);
    }
    
    
    @Override
    public void removeret(Book_User obj)
    {
        booksret.remove(obj);
    }
    */
    public void removeuser(Users_class a)
    {
        lib.removeuser(a);
    }
    @Override
    public void adduser(int row)
    {
        register_class user=lib.getregister(row);
        login temp=new login(user.getusername(),user.getpass());
        ArrayList<Book_loan> books=new ArrayList<>();
        
        Users_class a=new Borrower_class(user.getname(),user.getusername(),user.getemail(),user.getpno(),books,temp,Clerk_class.lib);
        lib.adduser(a);
        lib.removenewuser(row);
    }
    @Override
    public void Updateuser(String userName,String Name,String Email,String pno,String pass)
    {
        lib.updateUser(userName, Name, Email, pno, pass);
    }
    
    @Override
     public ArrayList<register_class> getnewusers()
    {
        return lib.getnewusers();
    }
    @Override
     public void removenwuser(int row)
    {
        lib.removenewuser(row);
        
    }
}
