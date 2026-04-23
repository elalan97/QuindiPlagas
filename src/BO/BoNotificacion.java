/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DAO.DaoNotificacion;
import DAO.DaoServicios;
import DTO.DtoServicio;
import Modelo.Notificacion;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class BoNotificacion {

    DaoNotificacion daoNotificacion;
    DaoServicios daoServicios;

    public BoNotificacion() {
        daoNotificacion = new DaoNotificacion();
        daoServicios = new DaoServicios();
    }

    public void verificarNotificacion(Notificacion n) {

        int validacion = 0;
        String fecha, fechaprox;
        LocalDate hoy = LocalDate.now(), fecha1, fecha2;
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        ArrayList<DtoServicio> comparar = daoServicios.listarServicios1();

        for (DtoServicio dtoServicio : comparar) {

            fecha = dtoServicio.getAfecha();

            fechaprox = dtoServicio.getProxFecha();

            if (fecha.equals("") || fechaprox.equals("")) {

            } else {

                fecha1 = LocalDate.parse(fecha, format);
                fecha2 = LocalDate.parse(fechaprox, format);

                if (fecha1.isEqual(hoy) || fecha2.isEqual(hoy)) {

                    validacion = 1;
                    break;

                }

            }

        }

        if (validacion == 1) {

            Notificacion n1 = daoNotificacion.buscarUsuario(n.getId());
            
            if (n1.isNotificado() == false) {
                
                JOptionPane.showMessageDialog(null, "tiene Servicios pendientes");
                n.setNotificado(true);
                daoNotificacion.actualizarNotificacion(n);
                
            }
            

        }else{
            
            daoNotificacion.actualizarNotificacion(n);
            
        }

    }
    
    public void actualizarNotificacion(Notificacion n){
        
        Notificacion n1 = daoNotificacion.buscarUsuario(n.getId());
        
        if (n1.isNotificado() == true && n1.getFecha().equals(n.getFecha())) {
            
        }else{
            
            daoNotificacion.actualizarNotificacion(n);
            
        }
        
    }

}
