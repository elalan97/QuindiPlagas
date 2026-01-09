/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exepciones;

/**
 *
 * @author ALAN
 */
public class NoExisteLocal extends RuntimeException{

    public NoExisteLocal() {
    }
    
    public String getMessage() {
        return "no existe el local";
    }
    
}
