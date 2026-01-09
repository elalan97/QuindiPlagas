/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exepciones;

/**
 *
 * @author ALAN
 */
public class NoExisteUsuario extends RuntimeException {

    public NoExisteUsuario() {
    }

    @Override

    public String getMessage() {
        return "no existe el usuario";
    }

}
