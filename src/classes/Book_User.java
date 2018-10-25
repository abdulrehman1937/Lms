/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Date;

/**
 *
 * @author abdul
 */
public class Book_User {
    private Users_class requester;
    private Book requested_book;
    public Book_User()
    {
        requester=null;
        requested_book=null;
        
    }
    public Book_User(Users_class loaner,Book loaned_book)
    {
        this.requester=loaner;
        this.requested_book=loaned_book;
        
    }
    public Users_class getUser()
    {
        return requester;
    }
    public Book getBook()
    {
        return requested_book;
    }
}
