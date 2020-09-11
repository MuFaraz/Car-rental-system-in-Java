
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
public class Reset {
    JTextField Fname;
    JTextField Lname;
    JTextField cnic;
    JTextField contact;
    JTextField address;
    JTextField pincode;
    JTextField email;
    JTextField salary;
    JTextField exp;

    public Reset(JTextField Fname, JTextField Lname, JTextField cnic, JTextField contact, JTextField address, JTextField pincode, JTextField email, JTextField salary, JTextField exp) {
        this.Fname = Fname;
        this.Lname = Lname;
        this.cnic = cnic;
        this.contact = contact;
        this.address = address;
        this.pincode = pincode;
        this.email = email;
        this.salary = salary;
        this.exp = exp;
    }
    
            public void reset()
    {
        Fname.setText("");
       Lname.setText("");
       cnic.setText("");
       contact.setText("");
       address.setText("");
       pincode.setText("");
       email.setText("");
       
       salary.setText("");
       exp.setText("");
    }
}
