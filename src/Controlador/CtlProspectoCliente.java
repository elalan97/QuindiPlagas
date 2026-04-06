/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import BO.BoProspectoCliente;
import DTO.DtoProspectoCliente;
import Modelo.ProspectoCliente;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class CtlProspectoCliente {

    BoProspectoCliente boProspectoCliente;
    public static String direccion, ciudad;

    public CtlProspectoCliente() {
        boProspectoCliente = new BoProspectoCliente();
    }

    public void guardarProspectoCliente(ProspectoCliente prospectoCliente, String ciudad) {
        boProspectoCliente.guardarProspectoCliente(prospectoCliente, ciudad);
    }

    public DtoProspectoCliente buscarProspectoCliente(String direccion, String cidudad) {
        return boProspectoCliente.buscarProspectoCliente(direccion, cidudad);
    }

    public void editarProspectoCliente(ProspectoCliente prospectoCliente, String ciudad, String direccion) {
        boProspectoCliente.editarProspectoCliente(prospectoCliente, ciudad, direccion);
    }

    public void eliminarProspectoCliente(String direccion) {
        boProspectoCliente.eliminarProspectoCliente(direccion);
    }

    public ArrayList<DtoProspectoCliente> listarPorFiltro(String columna, String dato) {
        return boProspectoCliente.listarPorFiltro(columna, dato);
    }

    public ArrayList<DtoProspectoCliente> listarProspectoCliente() {
        return boProspectoCliente.listarProspectoCliente();
    }

    public ArrayList<DtoProspectoCliente> listaProspectoCliente(String fecha) {
        return boProspectoCliente.listaProspectoCliente(fecha);
    }
    
    public ProspectoCliente verificar(String nombre){
        return boProspectoCliente.verificar(nombre);
    }
    
    public void alamecenarDatos(String direccion1, String ciudad1){
        
        direccion = direccion1;
        ciudad = ciudad1;
        
    }

}
