/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author Muhammad Faraz
 */
public class Bookings extends Person {
    Connection2d conn=new Connection2d();
    
   
    private String pickupDate;
    private String Date;
    private String DepartureTime;
    private int no_Of_days;
    private String Type;
    public String CarType;

    public Bookings(String pickupDate, String Date, String DepartureTime, String no_Of_days, String Type, String FirstName, String LastName, String Cnic, String Gender, String Contact, String Address, String Email_Id, String DateOfBirth, String City, String pincode,String CarType) {
        super(FirstName, LastName, Cnic, Gender, Contact, Address, Email_Id, DateOfBirth, City, pincode);
        this.pickupDate = pickupDate;
        this.Date = Date;
        this.DepartureTime = DepartureTime;
        this.no_Of_days = Integer.parseInt(no_Of_days);
        this.Type = Type;
        this.CarType=CarType;
    }

    public Bookings() {
    }
   
    

    public String getPickupDate() {
        return pickupDate;
    }

    public String getDepartureTime() {
        return DepartureTime;
    }

    public int getNo_Of_days() {
        return no_Of_days;
    }

    public void setDepartureTime(String DepartureTime) {
        this.DepartureTime = DepartureTime;
    }

    public void setNo_Of_days(int no_Of_days) {
        this.no_Of_days = no_Of_days;
    }


    public String getDate() {
        return Date;
    }

    public String getType() {
        return Type;
    }

    public String getCarType() {
        return CarType;
    }
    
    public void addBooking()
    {
        Connection con= conn.setConnection();
        ResultSet rs =null;
        PreparedStatement pst =null;
        try{
            String sql = "Insert into Bookings(FirstName,LastName,Cnic,Gender,Pick_Up_Date,Date,DepartureTime,No_of_days,Contact,City,Email,Pincode,Address,Date_Of_Birth,Car,CarType)values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst =con.prepareStatement(sql);
            pst.setString(1,super.getFirstName());
            pst.setString(2, super.getLastName());
             pst.setString(3, super.getCnic());
            pst.setString(4, super.getGender());
           
            pst.setString(5, getPickupDate());


            pst.setString(6, getDate());
            pst.setString(7, getDepartureTime());
            pst.setInt(8, getNo_Of_days());
            pst.setString(9, super.getContact());
            pst.setString(10, getCity());
            
            pst.setString(11, getEmail_Id());
            
            pst.setString(12, getPincode());
            pst.setString(13, getAddress());
            pst.setString(14, getDateOfBirth());
            pst.setString(15, getType());
            pst.setString(16, getCarType());
            
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Book","Message",JOptionPane.OK_OPTION);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Not saved");
        }
        
    }
    public void deleteBooking(String ID){
        Connection con= conn.setConnection();
        ResultSet rs =null;
        PreparedStatement pst =null;
        try
        {
            String sql= "Delete from Bookings where ID = ? ";
            pst=con.prepareStatement(sql);
            pst.setString(1, ID);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Deleted","Message",JOptionPane.OK_OPTION);
        }
        catch(Exception e)
        {
           JOptionPane.showMessageDialog(null, "Invalid ID");
        }
    }
    public void bookRecord(JTable table)
    {
        Connection con= conn.setConnection();
       PreparedStatement pst =null;
       ResultSet rs=null;
       try{
           String sql ="select ID as [ID], FirstName as [First Name],LastName as [Last Name],Cnic as [Cnic],Pick_Up_Date as [Pick Up Date],Contact as [Contact],No_of_days as [No of Days] from Bookings"; 
       pst=con.prepareStatement(sql);
           rs=pst.executeQuery();
           table.setModel(DbUtils.resultSetToTableModel(rs));
           
       }
       catch(Exception e)
       {
           JOptionPane.showMessageDialog(null, e);
       }
    }
    public boolean searchBooking(String ID)
    {
        boolean found =false;
        
        Connection con = conn.setConnection();
        PreparedStatement pst =null;
        ResultSet rs =null;
        try{
             Statement st = con.createStatement();
            String sql = "SELECT * FROM Bookings where ID ='"+ID+"'";
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
            
    public void SearchRecords(JTable table,String search){
       
    
    Connection con=conn.setConnection();
ResultSet rs=null;
PreparedStatement pst=null;
        
        
        String sql="select ID as [ID], FirstName as [First Name],LastName as [Last Name],Cnic as [Cnic],Pick_Up_Date as [Pick Up Date],Contact as [Contact],Email as [Email],City as [City],Date as [Date],DepartureTime as [Departure Time],No_of_days as [Number Of Days] from Bookings where ID = "+search+"";
          try{
         pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
          
}
   }
    public void updateBooking(String ID)
    {
         Connection con = conn.setConnection();    
     PreparedStatement pst =null;
     ResultSet rs =null;
     try {
  
    String sql = "UPDATE Bookings SET FirstName = ?,LastName=?,Gender=?,Cnic=?,Date=?,Pick_Up_Date=?,DepartureTime=?,No_of_days=?,Contact=?,Address=?,City=?,Email=?,Pincode=?,CarType=? WHERE ID = '"+ID+"'";
    pst = con.prepareStatement(sql);
            pst.setString(1,super.getFirstName());
            pst.setString(2, super.getLastName());
            pst.setString(3, super.getGender());
            pst.setString(4, super.getCnic());
           
            pst.setString(5, getDate());
            pst.setString(6,getPickupDate());
            pst.setString(7,getDepartureTime());
            pst.setInt(8,getNo_Of_days());
            pst.setString(9,super.getContact());
            pst.setString(10,super.getAddress());
            pst.setString(11,super.getCity());
            pst.setString(12,super.getEmail_Id());
            pst.setString(13,super.getPincode());
            pst.setString(14, getCarType());
            
            
            JOptionPane.showMessageDialog(null,"Successfull");
            pst.executeUpdate();
            pst.close();
        }
        catch(Exception sqlEx){
           JOptionPane.showMessageDialog(null,"Not update");
    }      
     }
    public void set(JTextField fname,JTextField lname,JTextField Id,JTextField Contact,JTextField cnic,String search){
    Connection con =conn.setConnection();
    ResultSet rs;
    
    try{
        Statement st=con.createStatement();
         String Sql="Select [ID],[FirstName],[LastName],[Cnic],[Contact] from Bookings where ID = '"+search+"'";
         rs = st.executeQuery(Sql);
         while (rs.next()){
             String add1=rs.getString("ID");
             Id.setText(add1);
             String add2=rs.getString("FirstName");
             fname.setText(add2);
             String add3 =rs.getString("LastName");
             lname.setText(add3);
             String add4=rs.getString("Cnic");
             cnic.setText(add4);
             String add5=rs.getString("Contact");
             Contact.setText(add5);
         }
    }
    catch(Exception e)
    {
        JOptionPane.showMessageDialog(null, "Invalid Id");
    }     
        }
}
        
    

