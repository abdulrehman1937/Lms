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
    }
    public Book_loan(Users_class loaner,Book loaned_book)
    {
        LocalDate date=LocalDate.now();
        this.returneddate=null;
        this.loaner=loaner;
        this.loaned_book=loaned_book;
        this.issuedate=new Date(date.getYear(),date.getMonthValue(),date.getDayOfMonth());
        this.returndate=new Date(date.getYear(),date.getMonthValue(),date.getDayOfMonth()+7);
    }
    public Book_loan(Users_class loaner,Book loaned_book,Date issuedate,Date retdate,Date returneddate)
    {
        
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
    public void setActualDate()
    {
        LocalDate date=LocalDate.now();
        this.returneddate=new Date(date.getYear(),date.getMonthValue(),date.getDayOfMonth());
    }
    
    
    
    
}
