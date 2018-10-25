/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author abdul
 */
public class register_class {
    private String name,username,pass,pno,email;
    public register_class(String username,String pass,String pno,String email,String name)
    {
        this.email=email;
        this.name=name;
        this.pass=pass;
        this.username=username;
        this.pno=pno;
        
    }
    public void addtodb()
    {
        dbconection db=new dbconection();
        db.executeupdatenuser(username, name, email, pass, pno);
    }
    public boolean checkusernameavil(String Username) throws SQLException
    {
         dbconection db=new dbconection();
        ResultSet rs=db.executepre(Username);
        return rs.next();
        
    }
    public String getusername()
    {
        return username;
    }
    public String getname()
    {
        return name;
    }
    public String getpass()
    {
        return pass;
    }
    public String getemail()
    {
        return email;
    }
    public String getpno()
    {
        return pno;
    }
}
