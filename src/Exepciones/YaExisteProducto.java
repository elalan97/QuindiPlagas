/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exepciones;

/**
 *
 * @author USER
 */
public class YaExisteProducto extends RuntimeException {

    public YaExisteProducto() {
    }

    @Override
    public String getMessage() {
        return "ya existe el producto";
    }

}
