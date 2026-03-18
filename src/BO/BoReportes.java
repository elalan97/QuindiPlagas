/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DAO.DaoReportesJasper;
import DAO.DaoServicios;
import DTO.DtoServicio;
import java.util.ArrayList;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author USER
 */
public class BoReportes {

    DaoServicios daoServicios;
    DaoReportesJasper daoReportesJasper;

    public BoReportes() {

        daoServicios = new DaoServicios();
        daoReportesJasper = new DaoReportesJasper();

    }

    public ArrayList<DtoServicio> listarServiciosPorFiltroVendedor(String dato, String vendedor) {
        return daoServicios.listarServiciosPorFiltroVendedor(dato, vendedor);
    }

    public ArrayList<DtoServicio> listaServicioDepartamentoCiudad(String columna, String departamento, String ciudad) {

        return daoServicios.listarServiciosPorIngresarFiltro("where mu.nombre = '" + departamento + "' "
                + "and ci.nombre = '" + ciudad + "' order by s.fecha desc;");

    }

    public ArrayList<DtoServicio> listaServicioDepartamentoCiudadFecha(String columna, String departamento, String ciudad, String fecha) {

        return daoServicios.listarServiciosPorIngresarFiltro("where mu.nombre = '" + departamento + "' "
                + "and ci.nombre = '" + ciudad + "' and a.fecha = '" + fecha + "' order by a.fecha desc;");

    }

    public ArrayList<DtoServicio> listaServicioDepartamentoCiudadFecha(String columna, String departamento, String ciudad,
            String fecha, String dato) {

        switch (columna) {
            case "Departamento":

                return daoServicios.listarServiciosPorIngresarFiltro("where mu.nombre LIKE '" + departamento + "%' order by a.fecha desc;");

            case "Ciudad":

                return daoServicios.listarServiciosPorIngresarFiltro("where ci.nombre LIKE '" + ciudad + "%' order by a.fecha desc;");

            case "Fecha":

                return daoServicios.listarServiciosPorIngresarFiltro("where a.fecha LIKE '" + fecha + "%' order by a.fecha desc;");

            case "Pago":

                return daoServicios.listarServiciosPorIngresarFiltro("where s.pago LIKE '" + dato + "%' order by a.fecha desc;");

        }

        return null;

    }

    public void reporte(String columna, String departamento, String ciudad,
            String fecha, String dato) throws JRException {

        switch (columna) {
            case "Departamento":

                daoReportesJasper.reportes("where mu.nombre LIKE '" + departamento + "%' order by a.fecha desc");
                break;

            case "Ciudad":

                daoReportesJasper.reportes("where ci.nombre LIKE '" + ciudad + "%' order by a.fecha desc");
                break;

            case "Fecha":

                daoReportesJasper.reportes("where a.fecha LIKE '" + fecha + "%' order by a.fecha desc");
                break;

            case "Pago":

                daoReportesJasper.reportes("where s.pago LIKE '" + dato + "%' order by a.fecha desc");
                break;

            case "Departamento, Ciudad":

                daoReportesJasper.reportes("where mu.nombre LIKE '" + departamento + "' "
                        + "and ci.nombre LIKE '" + ciudad + "%' order by a.fecha desc");
                break;

            case "Departamento, Ciudad, Fecha":

                daoReportesJasper.reportes("where mu.nombre LIKE '" + departamento + "%' "
                        + "and ci.nombre LIKE '" + ciudad + "%' "
                        + "and a.fecha LIKE '" + fecha + "%' " + "order by a.fecha desc");

                break;

        }

    }

}
