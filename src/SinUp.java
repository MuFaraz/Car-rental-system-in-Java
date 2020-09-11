
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Muhammad Faraz
 */
public class SinUp {
     Connection2d connection =new Connection2d();
    private String FirstName;
    private String LastName;
    private String UserName;
    private String Password;

    public SinUp(String FirstName, String LastName, String UserName, String Password) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.UserName = UserName;
        this.Password = Password;
        
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getUserName() {
        return UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    public void Resgistration(){
       
        Connection con =connection.setConnection();
        ResultSet rs =null;
        PreparedStatement pst =null;
        try{
            String sql="Insert into Login(FirstName,LastName,UserName,Password) values (?,?,?,?)";
            pst =con.prepareStatement(sql);
            pst.setString(1, getFirstName());
            pst.setString(2, getLastName());
            pst.setString(3, getUserName());
            pst.setString(4, getPassword());
            pst.execute();
            JOptionPane.showMessageDialog(null, "save");
    }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
