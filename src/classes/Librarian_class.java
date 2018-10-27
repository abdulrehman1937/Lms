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
public class Librarian_class extends Clerk_class {
    //private ArrayList<Book> allbooks;
    public Librarian_class() {
        
        username=null;
        Name=null;
        Email=null;
        Books = null;
      //  Password=null;
        PhoneNumber=null;
        //allstudents=null;
        //allbooks=null;
    }
    public Librarian_class(String Name,String Username,String Email,String PhoneNumber,ArrayList<Book_loan> Books,login a,Library lib)
    {
        this.lib=lib;
      //  this.allbooks=allbooks;
        this.username=Username;
        this.Name=Name;
        this.PhoneNumber=PhoneNumber;
        this.Email=Email;
        this.Books=Books;
        this.credentials=a;
      //  this.allstudents=allstudents;
    }
    @Override
    public void addbook(Book a)
    {
        lib.addbook(a);
    }
    @Override
    public void delbook(Book a)
    {
        lib.removebook(a);
    }
    @Override
    public int user_type()
    {
        return 3;
    }
    @Override
    public int book_id(int id)
      {
          return 0;
      }
}
