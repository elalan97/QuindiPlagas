/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exepciones;

import jdk.jshell.spi.ExecutionControl;

/**
 *
 * @author ALAN
 */
public class YaExisteUsuario extends RuntimeException{

    public YaExisteUsuario() {
    }

    @Override

    public String getMessage() {
        return "ya existe el usuario";
    }

}
