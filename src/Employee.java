
import com.healthmarketscience.jackcess.Table;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;
//import net.proteanit.sql.DbUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Muhammad Faraz
 */
public class Employee extends Person {

    private String empid;
    private int sal;
    private String exp;
    private String registration;
    private int joinYear;
    private String Status;
    Connection2d connection = new Connection2d();
   Connection con = connection.setConnection();
        ResultSet rs = null;
        PreparedStatement pst = null;
    public Employee(String registration,String sal, String exp, String joinYear, String FirstName, String LastName, String Cnic, String Gender, String Contact, String Address, String Email_Id, String DateOfBirth, String City, String pincode, String Status) {
        super(FirstName, LastName, Cnic, Gender, Contact, Address, Email_Id, DateOfBirth, City, pincode);
        this.sal = Integer.parseInt(sal);
        this.exp = exp;
        this.joinYear = Integer.parseInt(joinYear);
        this.Status = Status;
        this.registration = registration;
    }

    public int getSal() {
        return sal;
    }

    public String getExp() {
        return exp;
    }

    public String getStatus() {
        return Status;
    }

    public String getRegistration() {
        return registration;
    }

    public int getJoinYear() {
        return joinYear;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public void setJoinYear(int joinYear) {
        this.joinYear = joinYear;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }
   

    public Employee() {
    }


    public void AddEmployee() {
        
        try {
            
            String sql = "Insert into Employee(FirstName,LastName,Cnic,Gender,Contact,Email,Address,Date_Of_Birth,City,Pincode,Salary,Experience,Status,Join_year) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = con.prepareStatement(sql);
           
            pst.setString(1, super.getFirstName());
            pst.setString(2, super.getLastName());
            pst.setString(3, super.getCnic());
            pst.setString(4, super.getGender());

            pst.setString(5, super.getContact());
            pst.setString(6, super.getEmail_Id());
            pst.setString(7, super.getAddress());
            pst.setString(8, super.getDateOfBirth());
            pst.setString(9, super.getCity());
            pst.setString(10, super.getPincode());
            pst.setInt(11, getSal());
            pst.setString(12, getExp());
            pst.setString(13, getStatus());
            pst.setInt(14, getJoinYear());
            
            pst.execute();
            JOptionPane.showMessageDialog(null,"Successfully Saved ","Employee Records",JOptionPane.INFORMATION_MESSAGE);
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void deleteEmployee(String ID)
    {
        
        try{
            int P = JOptionPane.showConfirmDialog(null," Are you sure want to delete ?","Confirmation",JOptionPane.YES_NO_OPTION);
            if (P==0)
            {    String sql="Delete From Employee where ID = ?";
            
            
            pst =con.prepareStatement(sql);
              pst.setString(1, ID);
             pst.execute();
            }
           
          
            JOptionPane.showMessageDialog(null, "Succesfully Deleted","Records",JOptionPane.INFORMATION_MESSAGE);
    }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
   public boolean searchEmployee(String ID){
        boolean found =false;
        
            
               
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM Employee where ID ='"+ID+"'";   
rs = st.executeQuery(sql);
              while(rs.next()){
                  String id = rs.getString("ID");
                  
                  
                  if(ID.equals(id) ){
                      {
                      found = true;}
                  }
                  else
                        found = false;
                 
                 
              }
               if (found==true)
                  {
                      System.out.println("Found");
                 
                  
                  }
                  else 
                      System.out.println("Not Found");
      

             
              }catch(Exception sqlEx){
                    System.out.println(sqlEx);
    }     
        return found;
    }
   public void Get_Data(JTable table,String search){
       
    
    
        
        String sql="select ID as [ID], FirstName as [First Name],LastName as [Last Name],Cnic as [Cnic],Gender as [Gender],Contact as [Contact],Email as [Email],Address as [Address],Date_Of_Birth as [Date Of Birth],City as [City],Pincode as [Pincode],Salary as [Salary],Experience as [Experience],Status as [Status],Join_Year as [Joining Year] from Employee where ID = "+search+"";
          try{
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
          
}
   }
   public void EmpRecord(JTable tab)
   {
       
       try{
           String sql ="select ID as [ID], FirstName as [First Name],LastName as [Last Name],Cnic as [Cnic],Gender as [Gender],Contact as [Contact],Email as [Email],Address as [Address],Date_Of_Birth as [Date Of Birth],City as [City],Pincode as [Pincode],Salary as [Salary],Experience as [Experience],Status as [Status],Join_Year as [Joining Year] from Employee"; 
       pst=con.prepareStatement(sql);
           rs=pst.executeQuery();
           tab.setModel(DbUtils.resultSetToTableModel(rs));
           
       }
       catch(Exception e)
       {
           JOptionPane.showMessageDialog(null, e);
       }
   }
  

public void updateEmployee(String ID){
     
    try {
//            Connection con = connection.setConnection();    
    String sql = "UPDATE Employee SET FirstName = ?,LastName=?,Cnic=?,Gender=?,Contact=?,Email=?,Address=?,Date_Of_Birth=?,City=?,Pincode=?,Salary=?,Experience=?,Status=?,Join_year=? WHERE ID = '"+ID+"'";
            pst = con.prepareStatement(sql);
            pst.setString(1,getFirstName());
            pst.setString(2,getLastName());
            pst.setString(3,getCnic());
            pst.setString(4,getGender());
            pst.setString(5,getContact());
            pst.setString(6,getEmail_Id());
            pst.setString(7,getAddress());
            pst.setString(8,getDateOfBirth());
            pst.setString(9,getCity());
            pst.setString(10,getPincode());
            pst.setInt(11,getSal());
            pst.setString(12,getExp());
            pst.setString(13,getStatus());
            pst.setInt(14,getJoinYear());
            
            JOptionPane.showMessageDialog(null,"Successfull");
            pst.executeUpdate();
            pst.close();
        }
        catch(Exception sqlEx){
           System.out.println(sqlEx);
    }     
        
  }
public void set(JTextField fname,JTextField lname,JTextField Id,JTextField Status,String ID){
    Connection con=connection.setConnection();
    ResultSet rs;
    
    try{
        Statement st=con.createStatement();
         String Sql="Select [ID],[FirstName],[LastName],[Status] from Employee where ID = '"+ID+"'";
         rs = st.executeQuery(Sql);
         while (rs.next()){
             String add1=rs.getString("ID");
             Id.setText(add1);
             String add2=rs.getString("FirstName");
             fname.setText(add2);
             String add3 =rs.getString("LastName");
             lname.setText(add3);
             String add4=rs.getString("Status");
             Status.setText(add4);
         }
    }
    catch(Exception e)
    {
        JOptionPane.showMessageDialog(null, "Invalid Id");
    }
}

}
    


