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
public class login {
    private String username;
    private String password;
    login()
    {
        this.username=null;
        this.password=null;
    }
    login(String username,String password)
    {
        this.username=username;
        this.password=password;
    }
    public boolean validate(String Username,String Password)
    {
        return (this.username.equals(Username) && this.password.equals(Password));
            
    }
    public void chage_Pass(String Pass)
    {
        this.password=Pass;
    }
}
