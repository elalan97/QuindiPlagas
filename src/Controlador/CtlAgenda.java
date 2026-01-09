/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import BO.BoAgenda;
import DTO.DtoAgenda;
import Modelo.Agenda;
import java.util.ArrayList;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author USER
 */
public class CtlAgenda {

    BoAgenda boAgenda;

    public CtlAgenda() {

        boAgenda = new BoAgenda();
    }

    public void guardarAgenda(Agenda agenda, String factura) {
        boAgenda.guardarAgenda(agenda, factura);
    }

    /*public Agenda buscarAgenda(String factura, String fecha) {
        return boAgenda.buscarAgenda(factura, fecha);
    }*/
    public void edtarAgenda(Agenda agenda, String factura) {
        boAgenda.edtarAgenda(agenda, factura);
    }
    
    public void edtarAgendaRefuerzo(Agenda agenda, String factura, String fecha) {
        boAgenda.edtarAgendaRefuerzo(agenda, factura, fecha);
    }

    public void eliminarAgenda(String factura, String fecha) {
        boAgenda.eliminarAgenda(factura, fecha);
    }

    public ArrayList<DtoAgenda> listarAgenda() {
        return boAgenda.listarAgenda();
    }

    public ArrayList<DtoAgenda> listarAgendaPorFiltro(String fecha) {
        return boAgenda.listarAgendaPorFiltro(fecha);
    }

    public void reporteAgenda(String fecha) throws JRException {
        boAgenda.reporteAgenda(fecha);
    }

    public DtoAgenda buscarServicioAgenda(String nroFactura) {
        return boAgenda.buscarServicioAgenda(nroFactura);
    }

}
