/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.text.DecimalFormat;

/**
 *
 * @author ALAN
 */
public class Miles {

    public String separarMiles(double num) {

        DecimalFormat miles = new DecimalFormat("###,###");
        return miles.format(num);
    }

}
