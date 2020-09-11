
import java.sql.Connection;
import java.sql.DriverManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Muhammad Faraz
 */
public class Connection2d{
    public Connection setConnection(){
        String dataSourceName="database/car.accdb";
        String dir = System.getProperty("user.dir");
        String url = "jdbc:ucanaccess://"+dir+"/" + dataSourceName;
        //String url = "jdbc:ucanaccess://C:/Users/INTEL/Documents/NetBeansProjects/prjPassword/database/PasswordDB.accdb";
        java.sql.Connection con=null;
        try {
              con = DriverManager.getConnection(url);
        }
        catch(Exception sqlEx){
                    System.out.println(sqlEx);
        }
        return con;
    }
    
}
