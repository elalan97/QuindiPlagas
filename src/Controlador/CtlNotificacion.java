/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import BO.BoNotificacion;
import Modelo.Notificacion;

/**
 *
 * @author USER
 */
public class CtlNotificacion {
    
    BoNotificacion boNotificacion;

    public CtlNotificacion() {
        boNotificacion = new BoNotificacion();
    }
    
    public void verificarNotificacion(Notificacion n){
        boNotificacion.verificarNotificacion(n);
    }
    
    public void actualizarNotificacion(Notificacion n){
        boNotificacion.actualizarNotificacion(n);
    }
    
}
