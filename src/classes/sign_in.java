/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javaapplication3.*;

/**
 *
 * @author abdul
 */
public class sign_in {
    
    public static void main(String args[]) {
        
        signin a=new signin();
        a.showsignin();
        
        
        
    }
   /* public void initBorrower()
    {
        Borrower_class a1=new Borrower_class("abdul rehman","ars","a@g.com","03216335236",null);
        
        Book b1=new Book(001,"Calculus","Writer","Math","First",1);
        Book b2=new Book(002,"Calculus","Writer","Math","Second",1);
        Book_loan ab=new Book_loan(a1,b1);
        ArrayList<Book_loan> array = new ArrayList();
        array.add(ab);
        Book_loan ab1=new Book_loan(a1,b2);
        array.add(ab1);
        Borrower obj=new Borrower(a1,array);
        obj.setVisible(true);
        //obj.init(a1,array);
        
    }*/
    public boolean checkCredentials(String Username,String Password,int type)
    {
        if(Username.equals("admin"))
        {
            if(Password.equals("admin"))
                return true;
        }
        return false;
    }
}
