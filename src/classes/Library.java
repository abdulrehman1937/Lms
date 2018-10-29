/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;
import java.util.ListIterator;
import java.util.ArrayList;
import java.util.Date;
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
    public void removebook(Book a)
    {
        allbooks.remove(a);
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
}

