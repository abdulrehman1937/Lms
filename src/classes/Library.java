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
public class Library {
    private ArrayList<Users_class> allusers;
    private ArrayList<Book>allbooks;
    private ArrayList<register_class> newusers;
     private ArrayList<Book_User> booksreq;
    private ArrayList<Book_User> booksret;
    private ArrayList<Book_loan> historyOfLoans;
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
    
    }
    public void removefromret(int index)
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
        booksret.remove(index);
    
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
    public void removebook(Book a)
    {
        allbooks.remove(a);
    }
    public void adduser(Users_class a)
    {
        allusers.add(a);
    }
    public void removeuser(Users_class a)
    {
        allusers.remove(a);
    }
    public void addtohistory(Book_loan a)
    {
        this.historyOfLoans.add(a);
    }
    public Book Search(String Name)
    {
        Book a=new Book();
        ListIterator<Book>it=allbooks.listIterator();
        while(it.hasNext())
        {
            a=it.next();
            if(a.getTitle().equals(Name) && a.isStatus()==1)
            {
                return a;
            }
        }
        return null;
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
    public void setBookStatus(Book_User a,int status)
    {
        int index=allbooks.indexOf(a.getBook());
        allbooks.get(index).setStatus(status);
        
    }
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
        
    }
    public register_class getregister(int index)
    {
        return this.newusers.get(index);
    }
    public void removenewuser(int index)
    {
        newusers.remove(index);
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
    }
}

