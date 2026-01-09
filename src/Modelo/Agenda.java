/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author USER
 */
public class Agenda {

    int idAgenda, servicioFk;
    String hora, confirmacion, observacion, fecha;

    public Agenda() {
    }

    public Agenda(int idAgenda, int servicioFk, String hora, String confirmacion, String observacion, String fecha) {
        this.idAgenda = idAgenda;
        this.servicioFk = servicioFk;
        this.hora = hora;
        this.confirmacion = confirmacion;
        this.observacion = observacion;
        this.fecha = fecha;
    }

    public int getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(int idAgenda) {
        this.idAgenda = idAgenda;
    }

    public int getServicioFk() {
        return servicioFk;
    }

    public void setServicioFk(int servicioFk) {
        this.servicioFk = servicioFk;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getConfirmacion() {
        return confirmacion;
    }

    public void setConfirmacion(String confirmacion) {
        this.confirmacion = confirmacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}
