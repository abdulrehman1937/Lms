/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;

/**
 *
 * @author abdul
 */
public class Book {
    private int id;
    private int noofcopies;
    private String Title;
    private String Author;
    private String Subject;
    private  String Edition;
    private ArrayList<Integer> status;
    Book()
    {
        this.id=0;
        this.Title=null;
        this.Author=null;
        this.Subject=null;
        this.noofcopies=1;
        this.status=null;
        this.Edition=null;
    }
    public Book(int id ,String Title,String Author, String Subject,String Edition,int status,int noofcopies)
    {
        this.noofcopies=noofcopies;
        for(int i=0;i<this.noofcopies;i++)
        {
            this.status.add(i, 1);
        }
        this.id=id;
        this.Title=Title;
        this.Author=Author;
        this.Subject=Subject;
        
        this.Edition=Edition;
        
    }
    public Book(int id ,String Title,String Author, String Subject,String Edition,int noofcopies,ArrayList<Integer> status)
    {
        this.noofcopies=noofcopies;
        this.status=status;
        this.id=id;
        this.Title=Title;
        this.Author=Author;
        this.Subject=Subject;
        
        this.Edition=Edition;
        
    }
    public int getcopyies()
    {
        return this.noofcopies;
    }
    public void setId(int id)
    {
        this.id=id;
    }
    public void setTitle(String Title)
    {
        this.Title=Title;
    }
    public void setAuthor(String Author)
    {
        this.Author=Author;
    }
    public void setSubject(String Subject)
    {
        this.Subject=Subject;
    }
    public void setStatus(int status,int copyno)
    {
        this.status.set(copyno, status);
    }
    public void setEdition(String Edition) 
    {
        this.Edition = Edition;
    }
    public String getEdition() 
    {
        return Edition;
    }
    public int getId()
    {
        return this.id;
    }
    public String getAuthor()
    {
        return this.Author;
    }
    public String getSubject()
    {
        return this.Subject;
    }
    public String getTitle()
    {
        return this.Title;
    }
    public int isStatus() 
    {
        
        for(int i=0;i<this.noofcopies;i++)
        {
            if(this.status.get(i)==1)
                return i;
        }
        return -1;
    }
    
}
