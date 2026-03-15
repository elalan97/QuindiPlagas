/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DAO.DaoServicios;
import DTO.DtoServicio;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class BoReportes {

    DaoServicios daoServicios;

    public BoReportes() {

        daoServicios = new DaoServicios();

    }

    public ArrayList<DtoServicio> listarServiciosPorFiltroVendedor(String dato, String vendedor) {
        return daoServicios.listarServiciosPorFiltroVendedor(dato, vendedor);
    }

    public ArrayList<DtoServicio> listaServicioDepartamentoCiudad(String columna, String departamento, String ciudad) {

        return null;

    }

    public ArrayList<DtoServicio> listaServicioDepartamentoCiudadFecha(String columna, String departamento, String ciudad, String fecha) {

        switch (columna) {
            case "Departamento":

                return daoServicios.listarServiciosPorIngresarFiltro("where mu.nombre LIKE '" + departamento + "%' order by s.fecha desc;");

            case "Ciudad":

                return daoServicios.listarServiciosPorIngresarFiltro("where ci.nombre LIKE '" + ciudad + "%' order by s.fecha desc;");

            case "Fecha":

                return daoServicios.listarServiciosPorIngresarFiltro("where a.fecha LIKE '" + fecha + "%' order by s.fecha desc;");

        }

        return null;

    }

}
