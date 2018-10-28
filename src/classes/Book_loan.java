/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;


import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author abdul
 */
public class Book_loan {
    private Users_class loaner;
    private int fine;
    private Date issuedate;
    private Date returndate;
    private Date returneddate;
    private Book loaned_book;
    public Book_loan()
    {
        loaner=null;
        
        issuedate=null;
        returndate=null;
        returneddate=null;
        loaned_book=null;
        fine=0;
    }
    public Book_loan(Users_class loaner,Book loaned_book)
    {
        fine=0;
        LocalDate date=LocalDate.now();
        this.returneddate=new Date(1899,11,11);
        this.loaner=loaner;
        this.loaned_book=loaned_book;
        this.issuedate=new Date(date.getYear(),date.getMonthValue(),date.getDayOfMonth());
        this.returndate=new Date(date.getYear(),date.getMonthValue(),date.getDayOfMonth()+7);
    }
    public Book_loan(Users_class loaner,Book loaned_book,Date issuedate,Date retdate,Date returneddate,int fine)
    {
        this.fine=fine;
        this.returneddate=returneddate;
        this.loaner=loaner;
        this.loaned_book=loaned_book;
        this.issuedate=issuedate;
        this.returndate=retdate;
    }
    public Book getbook()
    {
        return loaned_book;
    }
    public String getissue()
    {
        return issuedate.toString();
    }
    public String getret()
    {
        
        return returndate.toString();
    }
    public String getreted()
    {
        if(returneddate.getYear()==1899)
        {
            return "Not returned";
        }
        return returneddate.toString();
    }
    public void setActualDate()
    {
        LocalDate date=LocalDate.now();
        this.returneddate=new Date(date.getYear(),date.getMonthValue(),date.getDayOfMonth());
        this.fine=this.myfine();
    }
    public int myfine()
    {
        
        LocalDate date=LocalDate.now();
        Date today=new Date(date.getYear(),date.getMonthValue(),date.getDayOfMonth());
        long diff=(today.getTime()-this.returndate.getTime())/86400000;
        int days=(int)diff;
        if(days>0)
        {
            return days*100;
        }
        return 0;
    }
    public int getfine()
    {
        return this.fine;
    }
    public Users_class getuser()
    {
        return this.loaner;
    }
    
    
}
