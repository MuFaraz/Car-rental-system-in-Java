
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTextField;
import javax.swing.JLabel;
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
public class Invoice {
    Bookings book =new Bookings();
    private String total;
    JLabel ID;
    JLabel Fname;
    JLabel Lname;
    JLabel Cnic;
    JLabel Address;
    JLabel Contact;
    JLabel Gender;
    JLabel Date;
    JLabel PickUpDate;
    JLabel DepartureTime;
    JLabel noDays;
    JLabel City;
    JLabel Email;
    JLabel Pincode;
    JLabel CarType;
    JLabel Car;
public Invoice(Bookings book,String total){
    this.book= book;
}
    public String getTotal() {
        return total;
    }

    public Invoice(JLabel ID, JLabel Fname, JLabel Lname, JLabel Cnic, JLabel Address, JLabel Contact, JLabel Gender, JLabel Date, JLabel PickUpDate, JLabel DepartureTime, JLabel noDays, JLabel City, JLabel Email, JLabel CarType, JLabel Car) {
        this.ID = ID;
        this.Fname = Fname;
        this.Lname = Lname;
        this.Cnic = Cnic;
        this.Address = Address;
        this.Contact = Contact;
        this.Gender = Gender;
        this.Date = Date;
        this.PickUpDate = PickUpDate;
        this.DepartureTime = DepartureTime;
        this.noDays = noDays;
        this.City = City;
        this.Email = Email;
       
        this.CarType = CarType;
        this.Car = Car;
    }

    
    

    
    Connection2d conn =new Connection2d();
    Connection con=conn.setConnection();
    PreparedStatement pst =null;
    ResultSet rs=null;
    public void setBill(String Search)
    {
        try{
        Statement st=con.createStatement();
        String Sql = "SELECT [ID],[FirstName],[LastName],[Cnic],[Gender],[Date],[Pick_Up_Date],[DepartureTime],[No_of_days],[Contact],[Address],[City],[Email],[CarType],[Car] From Bookings Where ID = '"+Search+"'";
    rs =st.executeQuery(Sql);
    while (rs.next())
    {
        String add =rs.getString("ID");
        ID.setText(add);
        String add1=rs.getString("FirstName");
        Fname.setText(add1);
        String add2 = rs.getString("LastName");
        Lname.setText(add2);
        String add3=rs.getString("Cnic");
        Cnic.setText(add3);
        String add4 =rs.getString("Gender");
        Gender.setText(add4);
        String add5 =rs.getString("Date");
        Date.setText(add5);
        String add6 =rs.getString("Pick_Up_Date");
        PickUpDate.setText(add6);
        
        String add8 =rs.getString("DepartureTime");
        DepartureTime.setText(add8);
        String add9 =rs.getString("No_of_days");
        noDays.setText(add9);
        String add10 =rs.getString("Contact");
        Contact.setText(add10);
        String add11 =rs.getString("Address");
        Address.setText(add11);
        String add12 =rs.getString("City");
        City.setText(add12);
        String add13 =rs.getString("Email");
        Email.setText(add13);
        String add14 =rs.getString("CarType");
        CarType.setText(add14);
        String add7=rs.getString("Car");
        Car.setText(add7);
        
        
        
        
    }
    con.close();
        }
    catch(Exception e){
        System.out.println(e);
    }
        
        }
    public void add(){
        Connection con= conn.setConnection();
        ResultSet rs =null;
        PreparedStatement pst =null;
        try{//prepared statement used t execute
            String sql = "Insert into BookingInvoice(FirstName,LastName,Cnic,Gender,Pick_Up_Date,Date,DepartureTime,No_of_days,Contact,City,Email,Pincode,Address,Date_Of_Birth,Car,CarType,Total)values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst =con.prepareStatement(sql);
            pst.setString(1,book.getFirstName());
            pst.setString(2, book.getLastName());
             pst.setString(3, book.getCnic());
            pst.setString(4, book.getGender());
           
            pst.setString(5,book.getPickupDate());

//            pst.setString(5, getDropAddress());
            pst.setString(6, book.getDate());
            pst.setString(7, book.getDepartureTime());
            pst.setInt(8, book.getNo_Of_days());
            pst.setString(9, book.getContact());
            pst.setString(10, book.getCity());
            
            pst.setString(11, book.getEmail_Id());
            
            pst.setString(12, book.getPincode());
            pst.setString(13, book.getAddress());
            pst.setString(14, book.getDateOfBirth());
            pst.setString(15, book.getType());
            pst.setString(16, book.getCarType());
            pst.setString(17,getTotal());
            
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Save");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
     public boolean searchBooking(String ID)
    {
        boolean found =true;
        
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
    
    }

