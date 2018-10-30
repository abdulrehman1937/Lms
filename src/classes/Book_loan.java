/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;


import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.JOptionPane;

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
    private int copyno;
    public Book_loan()
    {
        loaner=null;
        
        issuedate=null;
        returndate=null;
        returneddate=null;
        loaned_book=null;
        fine=0;
        copyno=0;
    }
    public Book_loan(Users_class loaner,Book loaned_book,int copyno)
    {
        this.copyno=copyno;
        fine=0;
        LocalDate date=LocalDate.now();
        this.returneddate=new Date(1899,11,11);
        this.loaner=loaner;
        this.loaned_book=loaned_book;
        this.issuedate=new Date(date.getYear(),date.getMonthValue(),date.getDayOfMonth());
        this.returndate=new Date(date.getYear(),date.getMonthValue(),date.getDayOfMonth()+7);
    }
    public Book_loan(Users_class loaner,Book loaned_book,Date issuedate,Date retdate,Date returneddate,int fine,int copyno)
    {
        this.copyno=copyno;
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
        return this.datetostring(issuedate);
        
        
    }
    public String getret()
    {
        
        return this.datetostring(this.returndate);
    }
    public String getreted()
    {
        try
        {
        if(returneddate.getYear()==1899)
        {
            return "Not returned";
        }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        
        return this.datetostring(this.returneddate);
    }
    public int get_returned()
    {
        if(returneddate.getYear()==1899)
        {
            return 0;
        }
        return 1;
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
    public int getcopy()
    {
        return this.copyno;
    }
    public Date get_issue()
    {
        return this.issuedate;
    }
    public Date get_retdate()
    {
        return this.returndate;
    }
    public Date get_returneddate()
    {
        return this.returneddate;
    }
    public String get_todaydate()
    {
        LocalDate date=LocalDate.now();
        Date today=new Date(date.getYear(),date.getMonthValue(),date.getDayOfMonth());
        return this.datetostring(today);
    }
    public String datetostring(Date a)
    {
        String s;
        s = String.valueOf(a.getDate())+"-"+String.valueOf(a.getMonth())+"-"+String.valueOf(a.getYear());
        return s;
    }
}
