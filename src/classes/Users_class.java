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
public class Users_class {
    public login credentials;
    public static Library lib;
    public String username;
    public String Name;
    public String Email;
    //private String Password;
    public String PhoneNumber;
    public ArrayList<Book_loan> Books;
    public Users_class() {
        
        username=null;
        Name=null;
        Email=null;
        Books = null;
      //  Password=null;
        PhoneNumber=null;
    }
    public Users_class(String Name,String Username,String Email,String PhoneNumber,ArrayList<Book_loan> Books, login a,Library lib)
    {
        
        this.lib=lib;
        this.username=Username;
        this.Name=Name;
        this.PhoneNumber=PhoneNumber;
        this.Email=Email;
        this.Books=Books;
        this.credentials=a;
        
    }
    public void adduser(int row)
    {
        
    }
    public void removenwuser(int row)
    {
        
    }
    public int user_type()
    {
        return 0;
    }
    public void reqBook(Book_User a)
    {
      
    }
   
    public void retBook(Book_User a)
    {
      
    }
    public void addbook(Book a)
    {
        
    }
    public void delbook(int a)
    {
        
    }
    public boolean Searchbyid(int id)
    {
        return false;
    }
    public boolean validate(String Username,String Password)
    {
        return credentials.validate(Username, Password);
            
    }
    public void addloanedbook(Book_loan book)
    {
        
    }
    public ArrayList<Book> Search(String Name)
    {
        return lib.Search(Name);
    }
    public boolean SearchUser(String Name)
    {
        return lib.SearchUser(Name);
    }
    public void Updateuser(String userName,String Name,String Email,String pno,String pass)
    {
        
    }
    
    public ArrayList<Book_loan> getbooks()
    {
        return Books;
    }
    public void retBook(Book a)
    {
        Book_User reqested=new Book_User(this,a);
        lib.retbook(reqested);
    }
    public void reqBook( Book a)
    {
        Book_User reqested=new Book_User(this,a);
        lib.reqbook(reqested);
        
    }
    public Book_loan getbook(Book_User a)
    {
        ListIterator<Book_loan> it=null;
        it=Books.listIterator();
        while(it.hasNext()){
	   if(it.next().getbook()==a.getBook())
           {
               return it.next();
           }
	}
        return null;
    }
    public void delBook(Book_loan book)
    {
        Books.remove(book);
    }
    public void setlib(Library lib)
    {
        this.lib=lib;
    }
    public void check_out(Book_User a)
    {
        
    }
    public void check_in(Book_User a)
    {
        
    }
    public void setPassword(String Password)
    {
        this.credentials.chage_Pass(Password);
        dbconection db=new dbconection();
        db.updatepass(this.username, Password);
    }
    public boolean searchretbook(int index)
    {
        Book temp=this.Books.get(index).getbook();
        return lib.Searchbookret(this.username, temp);
    }
     public boolean searchreqbook(Book temp)
    {
        
        return lib.Searchbookreq(this.username, temp);
    }
     public Book_loan getbookobj(Book obj)
     {
         ListIterator<Book_loan> it =null;
         it=Books.listIterator();
         while(it.hasNext())
         {
             Book_loan temp=it.next();
             if(temp.getbook().equals(obj))
             {
                 return temp;
             }
         }
         return null;
     }
      public ArrayList<register_class> getnewusers()
    {
        return null;
    }
      public boolean book_id(int id)
      {
          return false;
      }
      public void updateBook(int id,String Title,String Author,String Subject,String Edition)
      {
          
      }
      public void addBook(int id,String Title,String Author,String Subject,String Edition)
      {
          
      }
      public void deluser(String Username)
      {
          
      }
      public int computefine()
      {
          int fine=0;
          ListIterator<Book_loan> it;
          it=Books.listIterator();
          while(it.hasNext())
          {
              Book_loan temp=it.next();
              fine+=temp.myfine();
          }
          return fine;
      }
      public boolean searchbook(Book bk)
      {
          ListIterator<Book_loan> it=null;
          it=Books.listIterator();
          while(it.hasNext())
          {
              Book_loan temp=it.next();
              if(temp.getbook().equals(bk))
              return true;
          }
          return false;
      
          
   
         
}
}