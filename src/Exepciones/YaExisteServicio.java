/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exepciones;

/**
 *
 * @author ALAN
 */
public class YaExisteServicio extends RuntimeException {

    public YaExisteServicio() {
    }

    @Override

    public String getMessage() {
        return "ya existe la factura registrada";
    }

}
