/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 *
 * @author abdul
 */
public class Borrower_class extends Users_class {
    
    
      
    public Borrower_class() {
        
        username=null;
        Name=null;
        Email=null;
        Books = null;
      //  Password=null;
        PhoneNumber=null;
        
    }
    public Borrower_class(String Name,String Username,String Email,String PhoneNumber,ArrayList<Book_loan> Books,login a,Library lib)
    {
        this.lib=lib;   
        this.username=Username;
        this.Name=Name;
        this.PhoneNumber=PhoneNumber;
        this.Email=Email;
        this.Books=Books;
       this.credentials=a;
        
    }
    
    @Override
    public void addloanedbook(Book_loan book)
    {
        Books.add(book);
    }
    
    
    @Override
    public int user_type()
    {
        return 1;
    }
    
    
}
