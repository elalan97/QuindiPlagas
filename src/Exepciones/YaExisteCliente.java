/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exepciones;

/**
 *
 * @author ALAN
 */
public class YaExisteCliente extends RuntimeException{

    public YaExisteCliente() {
    }
    
    @Override

    public String getMessage() {
        return "ya existe el cliente";
    }
    
}
