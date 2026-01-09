/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exepciones;

/**
 *
 * @author ALAN
 */
public class YaExisteLocal extends RuntimeException{

    public YaExisteLocal() {
    }
    
    @Override

    public String getMessage() {
        return "ya existe el local registrado";
    }
    
}
