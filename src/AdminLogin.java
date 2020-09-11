
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Muhammad Faraz
 */
public class AdminLogin {
   
    private String  UserName;
    private String Pass;
    Connection2d conn = new Connection2d();
    public String getUserName() {
        return UserName;
    }

    public String getPass() {
        return Pass;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }
    public boolean match(String user, String pass){
        boolean successful =false;
        try {
              
            Connection con = conn.setConnection();  
            Statement st = con.createStatement();
            
            String sql = "SELECT * FROM Login where UserName = '"+user+"'";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
              String userName = rs.getString("UserName");
              String password = rs.getString("Password");
              if(user.equals(userName) && pass.equals(password))
                  successful = true;
              else
                  successful = false;
            }
            con.close();
        }
        catch(Exception sqlEx){
                    System.out.println(sqlEx);
        }     
        return successful;
    }
    public void ChangePassword(String UserName,String OldPassw,String NewPass,String ConfirmPass) {                                                  
        try{
         String Newpass=String.valueOf(NewPass);
         String ConfPass=String.valueOf(ConfirmPass);
        String OldPass=String.valueOf(OldPassw);
        String uName=UserName;
        if (uName.equals("")) {
              
                JOptionPane.showMessageDialog( null, "Please enter a username",
                                          "Error", JOptionPane.ERROR_MESSAGE);
                return;
               
            } else if (OldPass.equals("")) {
            
                JOptionPane.showMessageDialog(null, "Please enter a old password",
                                          "Error", JOptionPane.ERROR_MESSAGE);
                return;
               
            } else if (Newpass.equals("")) {
              
                JOptionPane.showMessageDialog( null, "Please enter a new password",
                                          "Error", JOptionPane.ERROR_MESSAGE);
                return;
                
            } else if (ConfPass.equals("")) {
               
                JOptionPane.showMessageDialog( null, "Please enter a confirmed password",
                                          "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } 
               else if (Newpass.length()< 5) {
               
                JOptionPane.showMessageDialog(null,
                                         "The New Password Should be of Atleast 5 Characters",
                                         "Error", JOptionPane.ERROR_MESSAGE);
                return;
               }
            
           
            
            else if ((Newpass).equals(OldPass)) {
                
               JOptionPane.showMessageDialog(null,
                                         "Password is same..Re-enter new password","Error", JOptionPane.ERROR_MESSAGE);
               return;
            }
    else if (!(Newpass).equals(ConfPass)) {
               
                JOptionPane.showMessageDialog(null,
                                         "New Password doesn't match with Confirmed Password",
                                         "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

    Connection con =conn.setConnection();
            PreparedStatement pst =null;
            ResultSet rs=null;
    String sql= "select UserName,Password from Login where UserName='" + UserName + "' and Password= '" + OldPassw + "'";
      pst=con.prepareStatement(sql);
      rs= pst.executeQuery();
      while(rs.next())
        {
            String usrname = rs.getString("UserName").trim();
            String passwd = rs.getString("Password").trim();
            if(uName.equals(usrname) && OldPass.equals(passwd))
            {
                con=conn.setConnection();
                 String sql1= "update Login set Password= '" + Newpass + "' where UserName= '" + uName + "' and Password = '" + OldPass + "'";
                 Statement stmt = con.createStatement();
                 stmt.execute(sql1.toString());
                 stmt.close();
                 JOptionPane.showMessageDialog(null,"Password Successfully Changed");
                 
                 return;
              }
            else
            {
             JOptionPane.showMessageDialog(null,"invalid user name or password","Error", JOptionPane.ERROR_MESSAGE);   
             UserName="";
             OldPassw="";
             NewPass="";
             ConfirmPass="";
             return;
            }
        }    
        }catch(SQLException | HeadlessException ex){
           JOptionPane.showMessageDialog(null,ex); 
        }
    }
        public void getDetail(JTable table){
            Connection con =conn.setConnection();
            ResultSet rs =null;
            PreparedStatement pst=null;
            
            try{
                String sql ="Select FirstName as [First Name],LastName as [Last Name],UserName as [User Name], Password as [Password] from Login order by FirstName";
                pst=con.prepareStatement(sql);
                rs=pst.executeQuery();
               table.setModel(DbUtils.resultSetToTableModel(rs));
                
                
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
            
        }
    
}
