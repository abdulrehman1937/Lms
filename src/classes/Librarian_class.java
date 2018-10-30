/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;
import java.sql.SQLException;
import java.util.ListIterator;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
    public void delbook(int id)
    {
        try {
            lib.removebook(id);
            lib.init();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    @Override
    public int user_type()
    {
        return 3;
    }
    @Override
    public boolean book_id(int id)
      {
          return lib.Searchbyid(id);
      }
    @Override
    public void updateBook(int id,String Title,String Author,String Subject,String Edition)
    {
        lib.updateBook(id, Title, Author, Subject, Edition);
    }
    @Override
    public void addBook(int id,String Title,String Author,String Subject,String Edition)
    {
        Book temp=new Book(id,Title,Author,Subject,Edition,1,5);
        lib.addnewbook(temp);
    }
    @Override
    public boolean Searchbyid(int id)
    {
        return lib.Searchbyid(id);
    }
}
