/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DAO.DaoLocal;
import DAO.DaoServicios;
import DTO.DtoInformeServicio;
import DTO.DtoServicio;
import Exepciones.NoExisteCliente;
import Exepciones.NoExisteLocal;
import Exepciones.NoExisteServicio;
import Exepciones.YaExisteServicio;
import Modelo.Ciudad;
import Modelo.Local;
import Modelo.Servicio;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;

/**
 *
 * @author ALAN
 */
public class BoServicio {

    DaoServicios daoServicios;
    DaoLocal daoLocal;

    public BoServicio() {

        daoServicios = new DaoServicios();
        daoLocal = new DaoLocal();

    }

    public void guardarServicio(Servicio servicio, String direccion, String ciudad) {

        Ciudad c = daoLocal.buscarCiudad(ciudad);
        Local local = daoLocal.buscarLocal(direccion, c.getIdCiudad());

        if (local.getDireccion() == null) {

            throw new NoExisteLocal();

        } else {

            Servicio s = daoServicios.buscarServicio(servicio.getNroFactura());

            if (s.getNroFactura() == null) {

                servicio.setLocalFk(local.getIdLocales());

                daoServicios.guardarServicio(servicio);

            } else {

                throw new YaExisteServicio();

            }

        }

    }

    public Servicio buscarServicio(String nroFactura) {

        Servicio servicio = daoServicios.buscarServicio(nroFactura);

        if (servicio.getNroFactura() == null) {

            throw new NoExisteServicio();

        } else {

            return servicio;

        }

    }

    public void editarServicio(Servicio servicio, String direccion, String ciudad, String codigoViejo) {

        Ciudad c = daoLocal.buscarCiudad(ciudad);
        Local local = daoLocal.buscarLocal(direccion, c.getIdCiudad());

        if (local.getDireccion() == null) {

            throw new NoExisteLocal();

        } else {

            Servicio s = daoServicios.buscarServicio(codigoViejo);

            if (s.getNroFactura() != null) {

                servicio.setLocalFk(local.getIdLocales());
                servicio.setIdServicio(s.getIdServicio());

                daoServicios.editarServicio(servicio);

            } else {

                throw new NoExisteServicio();

            }

        }

    }

    public void eliminarServicio(String nroFactura) {

        Servicio s = daoServicios.buscarServicio(nroFactura);

        if (s.getNroFactura() != null) {

            daoServicios.eliminarServicio(s.getIdServicio());

        } else {

            throw new NoExisteServicio();

        }

    }

    public DtoServicio buscarDtoServicio(String nroFactura) {

        DtoServicio dtoServicio = daoServicios.buscarDtoServicio(nroFactura);

        if (dtoServicio.getNroFactura() == null) {

            throw new NoExisteServicio();

        } else {

            return dtoServicio;

        }

    }

    public DtoInformeServicio buscarDtoInformeServicio(String codigoCliente, String direccion) {

        DtoInformeServicio dtoInformeServicio = daoServicios.buscarDtoInformeServicio(codigoCliente, direccion);

        if (dtoInformeServicio.getCodigo() == null) {

            throw new NoExisteCliente();

        } else {

            return dtoInformeServicio;

        }
    }

    public ArrayList<DtoServicio> listarServicios(String codigo) {
        return daoServicios.listarServicios(codigo);
    }

    public ArrayList<DtoServicio> listarServicios1() {
        return daoServicios.listarServicios1();
    }

    public Servicio buscarUltimoRegistroServicio() {
        return daoServicios.buscarUltimoRegistroServicio();
    }

    public String proximaFecha(String periocidad, String fecha) {

        String resultado;

        DateTimeFormatter format = new DateTimeFormatterBuilder().append(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toFormatter();

        LocalDate fecha_I = LocalDate.parse(fecha, format);

        switch (periocidad) {
            case "Mensual":

                fecha_I = fecha_I.plusMonths(1);

                resultado = fecha_I + "";

                return resultado;

            case "Bimensual":

                fecha_I = fecha_I.plusMonths(2);

                resultado = fecha_I + "";

                return resultado;

            case "Trimestral":

                fecha_I = fecha_I.plusMonths(3);

                resultado = fecha_I + "";

                return resultado;

            case "Cuatrimestral":

                fecha_I = fecha_I.plusMonths(4);

                resultado = fecha_I + "";

                return resultado;

            case "Quinquemestral":

                fecha_I = fecha_I.plusMonths(5);

                resultado = fecha_I + "";

                return resultado;

            case "Semestral":

                fecha_I = fecha_I.plusMonths(6);

                resultado = fecha_I + "";

                return resultado;

            case "Unica vez":

                resultado = fecha_I + "";

                return resultado;

        }

        return null;
    }

    public ArrayList<DtoServicio> listarServiciosPorFiltroVendedor(String dato, String vendedor) {
        return daoServicios.listarServiciosPorFiltroVendedor(dato, vendedor);
    }

    public ArrayList<DtoServicio> listarServiciosPorFiltro(String columna, String dato) {

        switch (columna) {
            case "Nombre del Negocio":

                return daoServicios.listarServiciosPorFiltro("l.nombreNegocio", dato);

            case "Direccion":

                return daoServicios.listarServiciosPorFiltro("l.direccion", dato);

            case "Nro Factura":

                return daoServicios.listarServiciosPorFiltro("s.nroFactura", dato);

            case "TipoServicio":

                return daoServicios.listarServiciosPorFiltro("s.tipoServicio", dato);

            case "Tecnico":

                return daoServicios.listarServiciosPorFiltro("s.tecnico", dato);

            case "Fecha":

                return daoServicios.listarServiciosPorFiltro("s.fecha", dato);

            case "Periocidad":

                return daoServicios.listarServiciosPorFiltro("s.periocidad", dato);

            case "Proxima Fecha":

                return daoServicios.listarServiciosPorFiltro("s.proxFecha", dato);

            case "Pago":

                return daoServicios.listarServiciosPorFiltro("s.pago", dato);

            case "Observacion":

                return daoServicios.listarServiciosPorFiltro("s.observacion", dato);

            case "Nombre del Cliente":

                return daoServicios.listarServiciosPorFiltro("c.nombre", dato);

            case "Fecha Agenda":

                return daoServicios.listarServiciosPorFiltro("a.fecha", dato);

        }

        return null;
    }

}
