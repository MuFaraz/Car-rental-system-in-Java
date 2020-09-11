
import com.toedter.calendar.JDateChooser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Muhammad Faraz
 */
public class Update {
    JTextField ID;
    JTextField Fname;
    JTextField Lname;
    JTextField Cnic;
    JTextArea Address;
    JTextField Contact;
    JTextField Gender;
    JTextField Date;
    JTextField PickUpDate;
    JTextField DepartureTime;
    JTextField noDays;
    JTextField City;
    JTextField Email;
    JTextField Pincode;
    JTextField CarType;
    JTextField Car;

    public Update() {
    }
    
    

    public Update(JTextField ID, JTextField Fname, JTextField Lname, JTextField Cnic, JTextArea Address, JTextField Contact, JTextField Gender, JTextField Date, JTextField PickUpDate, JTextField DepartureTime, JTextField noDays, JTextField City, JTextField Email, JTextField Pincode, JTextField CarType, JTextField Car) {
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
        this.Pincode = Pincode;
        this.CarType = CarType;
        this.Car = Car;
    }
   Connection2d conn =new Connection2d();
    Connection con=conn.setConnection();
    PreparedStatement pst =null;
    ResultSet rs=null;
    public void set(String Search)
    {
        try{
        Statement st=con.createStatement();
        String Sql = "SELECT [ID],[FirstName],[LastName],[Cnic],[Gender],[Date],[Pick_Up_Date],[DepartureTime],[No_of_days],[Contact],[Address],[City],[Email],[CarType],[Car],[Pincode] From Bookings Where ID = '"+Search+"'";
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
        String add16=rs.getString("Pincode");
        Pincode.setText(add16);

        
        
        
        
    }
    con.close();
        }
    catch(Exception e){
        System.out.println(e);
    }
        
        }
JDateChooser DateB;
    public Update(JTextField ID, JTextField Fname, JTextField Lname, JTextField Cnic, JTextArea Address, JTextField Contact, JTextField Gender, JDateChooser Date, JTextField City, JTextField Email, JTextField Pincode, JTextField Salary, JTextField Exp, JTextField status, JTextField jyear) {
        this.ID = ID;
        this.Fname = Fname;
        this.Lname = Lname;
        this.Cnic = Cnic;
        this.Address = Address;
        this.Contact = Contact;
        this.Gender = Gender;
        this.DateB = DateB;
        this.City = City;
        this.Email = Email;
        this.Pincode = Pincode;
        this.Salary = Salary;
        this.Exp = Exp;
        this.status = status;
        this.jyear = jyear;
    }
    
    JTextField Salary;
    JTextField Exp;
    JTextField status;
    JTextField jyear;
    public void setemp(String Search)
    {
        try{
        Statement st=con.createStatement();
        String Sql = "SELECT [ID],[FirstName],[LastName],[Cnic],[Gender],[Contact],[Address],[City],[Email],[Pincode],[Salary],[Experience],[Status],[Join_year],[Date_Of_Birth] From Employee Where ID = '"+Search+"'";
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
        String add5 =rs.getString("Date_Of_Birth");
        DateB.setDateFormatString(add5);
        String add6 =rs.getString("Salary");
        Salary.setText(add6);
        
        String add8 =rs.getString("Experience");
        Exp.setText(add8);
        String add9 =rs.getString("Join_year");
        jyear.setText(add9);
        String add10 =rs.getString("Contact");
        Contact.setText(add10);
        String add11 =rs.getString("Address");
        Address.setText(add11);
        String add12 =rs.getString("City");
        City.setText(add12);
        String add13 =rs.getString("Email");
        Email.setText(add13);
        String add14 =rs.getString("Status");
        status.setText(add14);
        String add15=rs.getString("Pincode");
        Pincode.setText(add15);
        

        
        
        
        
    }
    con.close();
        }
    catch(Exception e){
        System.out.println(e);
    }
        
        }
}
