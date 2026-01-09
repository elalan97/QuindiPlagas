/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import BO.BoLocal;
import DTO.DTOLocal;
import DTO.DtoClienteLocal;
import Modelo.Ciudad;
import Modelo.Local;
import Modelo.Municipio;
import java.util.ArrayList;

/**
 *
 * @author ALAN
 */
public class CtlLocal {
    
    BoLocal boLocal;
    
    public CtlLocal() {
        
        boLocal = new BoLocal();
        
    }
    
    public ArrayList<Municipio> cargarMunicipio() {
        
        return boLocal.cargarMunicipio();
        
    }
    
    public ArrayList<Ciudad> cargarCiudad(String nombre) {
        
        return boLocal.cargarCiudad(nombre);
    }
    
    public ArrayList<DTOLocal> listarLocalPorCliente(String codigo) {
        return boLocal.listarLocalPorCliente(codigo);
    }
    
    public void guardarLocal(Local local, String ciudad, String codigo) {
        
        boLocal.guardarLocal(local, ciudad, codigo);
    }
    
    public void editarLocal(Local local, String ciudad, String codigo, String ciudadEditar, String direcionActual) {
        boLocal.editarLocal(local, ciudad, codigo, ciudadEditar, direcionActual);
    }
    
    public void eliminarLocal(String direccion, String ciudad) {
        boLocal.eliminarLocal(direccion, ciudad);
    }
    
    public ArrayList<DtoClienteLocal> listaClienteLocal() {
        return boLocal.listaClienteLocal();
    }
    
    public ArrayList<DtoClienteLocal> listaClienteLocalporFiltro(String columna, String dato) {
        return boLocal.listaClienteLocalporFiltro(columna, dato);
    }
    
}
