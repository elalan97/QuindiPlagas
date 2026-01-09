/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import BO.BoInventario;
import DTO.DtoInventarioEntradas;
import DTO.DtoInventarioSalidas;
import Modelo.Inventario;
import java.text.ParseException;
import java.util.ArrayList;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author USER
 */
public class CtlInventario {
    
    BoInventario boInventario;
    
    public CtlInventario() {
        
        boInventario = new BoInventario();
        
    }
    
    public void guardarInventario(Inventario inventario) throws ParseException {
        boInventario.guardarInventario(inventario);
    }
    
    public Inventario buscarInventario(String nroLote) {
        return boInventario.buscarInventario(nroLote);
    }
    
    public void editarInventario(Inventario inventario) {
        boInventario.editarInventario(inventario);
    }
    
    public void eliminarInventario(String nrLote) {
        boInventario.eliminarInventario(nrLote);
    }
    
    public void agregarStock(Inventario inventario, int cantidad, String descripcion) {
        boInventario.agregarStock(inventario, cantidad, descripcion);
    }
    
    public void eliminarStock(Inventario inventario, int cantidad, String descripcion) {
        boInventario.eliminarStock(inventario, cantidad, descripcion);
    }
    
    public ArrayList<Inventario> listaInventario() {
        return boInventario.listaInventario();
    }
    
    public ArrayList<DtoInventarioEntradas> listaInventarioEntradas() {
        return boInventario.listaInventarioEntradas();
    }
    
    public ArrayList<DtoInventarioSalidas> listaInventarioSalidas() {
        return boInventario.listaInventarioSalidas();
    }
    
    public ArrayList<Inventario> listaInventarioFiltro(String columna, String dato) {
        return boInventario.listaInventarioFiltro(columna, dato);
    }
    
    public ArrayList<DtoInventarioEntradas> listaInventarioEntardaFiltro(String columna, String dato) {
        return boInventario.listaInventarioEntardaFiltro(columna, dato);
    }
    
    public ArrayList<DtoInventarioSalidas> listaInventarioSalidasFiltro(String columna, String dato) {
        return boInventario.listaInventarioSalidasFiltro(columna, dato);
    }
    
    public void reporteInventarioEntradas(String fecha) throws JRException {
        boInventario.reporteInventarioEntradas(fecha);
    }
    
    public void reporteInventarioSalidas(String fecha) throws JRException {
        boInventario.reporteInventarioSalidas(fecha);
    }
}
