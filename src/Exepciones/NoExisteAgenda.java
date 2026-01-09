/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exepciones;

/**
 *
 * @author USER
 */
public class NoExisteAgenda extends RuntimeException {

    public NoExisteAgenda() {
    }

    @Override

    public String getMessage() {
        return "No existe un agenda registrada para ese servicio";
    }

}
