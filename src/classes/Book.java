/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author abdul
 */
public class Book {
    private int id;
    private String Title;
    private String Author;
    private String Subject;
    private  String Edition;
    private int status;
    Book()
    {
        this.id=0;
        this.Title=null;
        this.Author=null;
        this.Subject=null;
        this.status=1;
        this.Edition=null;
    }
    public Book(int id ,String Title,String Author, String Subject,String Edition,int status)
    {
        this.id=id;
        this.Title=Title;
        this.Author=Author;
        this.Subject=Subject;
        this.status=1;
        this.Edition=Edition;
        
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
    public void setStatus(int status)
    {
        this.status=status;
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
        return this.status;
    }
    
}
