/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Microsoft Windows XP
 */
public class RentCar extends Vehicle {
    
    
    private double PricePerDay =1800;
    

    
    public double Go_car(double noDays)
    {
        return noDays*PricePerDay;
    }
    
    public double X_car(double noDays)
    {
        return 4000+(noDays*PricePerDay);
    }

    
    
}
