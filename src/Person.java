/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Muhammad Faraz
 */
public class Person {
    private String FirstName;
    private String LastName;
    private String Cnic;
    private String Gender;
    private String Contact;
    private String Address;
    private String Email_Id;
    private String DateOfBirth;
    private String City;
    private String pincode;

    public Person(String FirstName, String LastName, String Cnic, String Gender, String Contact, String Address, String Email_Id, String DateOfBirth, String City, String pincode) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Cnic = Cnic;
        this.Gender = Gender;
        this.Contact = Contact;
        this.Address = Address;
        this.Email_Id = Email_Id;
        this.DateOfBirth = DateOfBirth;
        this.City = City;
        this.pincode = pincode;
    }

   
    public Person(String FirstName, String LastName, String Cnic, String Contact, String Address, String Email_Id, String DateOfBirth, String City,String pincode) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Cnic = Cnic;
        
        this.Contact = Contact;
        this.Address = Address;
        this.Email_Id = Email_Id;
        this.DateOfBirth = DateOfBirth;
        this.City = City;
        this.pincode = pincode;
    }

    public Person() {
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getCnic() {
        return Cnic;
    }

    public String getGender() {
        return Gender;
    }

    public String getContact() {
        return Contact;
    }

    public String getAddress() {
        return Address;
    }

    public String getEmail_Id() {
        return Email_Id;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public String getCity() {
        return City;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public void setCnic(String Cnic) {
        this.Cnic = Cnic;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public void setContact(String Contact) {
        this.Contact = Contact;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setEmail_Id(String Email_Id) {
        this.Email_Id = Email_Id;
    }

    public void setDateOfBirth(String DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
    
}
