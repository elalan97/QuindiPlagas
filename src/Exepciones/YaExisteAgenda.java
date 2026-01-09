/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exepciones;

/**
 *
 * @author USER
 */
public class YaExisteAgenda extends RuntimeException{

    public YaExisteAgenda() {
    }

    @Override

    public String getMessage() {
        return "ya existe una agenda para ese servicio con la fecha que indico";
    }

}
