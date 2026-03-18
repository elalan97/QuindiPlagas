/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import BO.BoReportes;
import DTO.DtoServicio;
import java.util.ArrayList;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author USER
 */
public class CtlReportes {

    BoReportes boReportes;

    public CtlReportes() {

        boReportes = new BoReportes();

    }

    public ArrayList<DtoServicio> listarServiciosPorFiltroVendedor(String dato, String vendedor) {
        return boReportes.listarServiciosPorFiltroVendedor(dato, vendedor);
    }

    public ArrayList<DtoServicio> listaServicioDepartamentoCiudad(String columna, String departamento, String ciudad) {

        return boReportes.listaServicioDepartamentoCiudad(columna, departamento, ciudad);

    }

    public ArrayList<DtoServicio> listaServicioDepartamentoCiudadFecha(String columna, String departamento, String ciudad, String fecha) {

        return boReportes.listaServicioDepartamentoCiudadFecha(columna, departamento, ciudad, fecha);

    }

    public ArrayList<DtoServicio> listaServicioFiltro(String columna, String departamento, String ciudad, String fecha, String dato) {

        return boReportes.listaServicioDepartamentoCiudadFecha(columna, departamento, ciudad, fecha, dato);

    }

    public void reporte(String columna, String departamento, String ciudad,
            String fecha, String dato) throws JRException {
        boReportes.reporte(columna, departamento, ciudad, fecha, dato);
    }

    }
