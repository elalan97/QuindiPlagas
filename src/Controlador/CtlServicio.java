/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import BO.BoServicio;
import DTO.DtoInformeServicio;
import DTO.DtoServicio;
import Modelo.Servicio;
import java.util.ArrayList;

/**
 *
 * @author ALAN
 */
public class CtlServicio {

    BoServicio boServicio;
    public static String codigoAlmacenado, direccionAlmacenado, facturaAlmacenada;

    public CtlServicio() {

        boServicio = new BoServicio();

    }

    public void guardarServicio(Servicio servicio, String direccion, String ciudad) {

        boServicio.guardarServicio(servicio, direccion, ciudad);
    }

    public Servicio buscarServicio(String nroFactura) {
        return boServicio.buscarServicio(nroFactura);
    }

    public void editarServicio(Servicio servicio, String direccion, String ciudad, String codigoViejo) {
        boServicio.editarServicio(servicio, direccion, ciudad, codigoViejo);
    }
    
    public void editarServicioTecnico(Servicio servicio, String direccion, String ciudad, String codigoViejo) {
        boServicio.editarServicioTecnico(servicio, direccion, ciudad, codigoViejo);
    }

    public void eliminarServicio(String nroFactura) {
        boServicio.eliminarServicio(nroFactura);
    }

    public DtoServicio buscarDtoServicio(String nroFactura) {
        return boServicio.buscarDtoServicio(nroFactura);
    }

    public String proximaFecha(String periocidad, String fecha) {
        return boServicio.proximaFecha(periocidad, fecha);
    }

    public DtoInformeServicio buscarDtoInformeServicio(String codigoCliente, String direccion) {
        return boServicio.buscarDtoInformeServicio(codigoCliente, direccion);
    }

    public void almacenarDatos(String codigo, String direccion) {

        codigoAlmacenado = codigo;
        direccionAlmacenado = direccion;

    }

    public void almacenarDatos1(String factura) {

        facturaAlmacenada = factura;

    }

    public ArrayList<DtoServicio> listarServicios(String codigo) {
        return boServicio.listarServicios(codigo);
    }

    public ArrayList<DtoServicio> listarServicios1() {
        return boServicio.listarServicios1();
    }

    public ArrayList<DtoServicio> listarServiciosPorFiltro(String columna, String dato) {
        return boServicio.listarServiciosPorFiltro(columna, dato);
    }

    public ArrayList<DtoServicio> listarServiciosPorFiltroVendedor(String dato, String vendedor) {
        return boServicio.listarServiciosPorFiltroVendedor(dato, vendedor);
    }

    public Servicio buscarUltimoRegistroServicio() {
        return boServicio.buscarUltimoRegistroServicio();
    }

}
