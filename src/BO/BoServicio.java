/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DAO.DaoAgenda;
import DAO.DaoCliente;
import DAO.DaoLocal;
import DAO.DaoServicios;
import DTO.DTOLocal;
import DTO.DtoInformeServicio;
import DTO.DtoServicio;
import Exepciones.NoExisteCliente;
import Exepciones.NoExisteLocal;
import Exepciones.NoExisteServicio;
import Exepciones.YaExisteServicio;
import Modelo.Ciudad;
import Modelo.Cliente;
import Modelo.Local;
import Modelo.Servicio;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ALAN
 */
public class BoServicio {

    DaoServicios daoServicios;
    DaoLocal daoLocal;
    DaoCliente daoCliente;
    DaoAgenda daoAgenda;

    public BoServicio() {

        daoServicios = new DaoServicios();
        daoLocal = new DaoLocal();
        daoCliente = new DaoCliente();
        daoAgenda = new DaoAgenda();

    }

    public void guardarServicio(Servicio servicio, String direccion, String ciudad, String codigo) {

        Ciudad c = daoLocal.buscarCiudad(ciudad);
        DTOLocal local = daoLocal.buscarlocalConCLiente(codigo, direccion, c.getIdCiudad());

        if (local.getDireccion() == null) {

            throw new NoExisteLocal();

        } else {

            Servicio s = daoServicios.buscarServicio(servicio.getNroFactura());

            if (s.getNroFactura() == null) {

                servicio.setLocalFk(local.getIdLocal());

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

    public void editarServicio(Servicio servicio, String direccion, String ciudad, String codigoViejo, String codigo) {

        Ciudad c = daoLocal.buscarCiudad(ciudad);
        DTOLocal local = daoLocal.buscarlocalConCLiente(codigoViejo, direccion, c.getIdCiudad());

        if (local.getDireccion() == null) {

            throw new NoExisteLocal();

        } else {

            Servicio s = daoServicios.buscarServicio(servicio.getNroFactura());

            if (s.getNroFactura() != null) {

                servicio.setLocalFk(local.getIdLocal());
                servicio.setIdServicio(s.getIdServicio());

                daoServicios.editarServicio(servicio);

            } else {

                throw new NoExisteServicio();

            }

        }

    }

    public void editarServicioHistorial(Servicio servicio, String codigoViejo) {

        Servicio s = daoServicios.buscarServicio(codigoViejo);

        if (s.getNroFactura() != null) {

            servicio.setLocalFk(s.getLocalFk());
            servicio.setIdServicio(s.getIdServicio());

            daoServicios.editarServicio(servicio);

        } else {

            throw new NoExisteServicio();

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

        return dtoServicio;

    }

    public DtoInformeServicio buscarDtoInformeServicio(String codigoCliente, String direccion) {

        DtoInformeServicio dtoInformeServicio = daoServicios.buscarDtoInformeServicio(codigoCliente, direccion);

        if (dtoInformeServicio.getCodigo() == null) {

            throw new NoExisteCliente();

        } else {

            return dtoInformeServicio;

        }
    }

    public ArrayList<DtoServicio> listarServicios(String codigo, String direccion) {
        return daoServicios.listarServicios(codigo, direccion);
    }

    public ArrayList<DtoServicio> listarServicios1() {
        String fecha;
        LocalDate hoy = LocalDate.now(), fecha1;
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        ArrayList<DtoServicio> comparar = daoServicios.listarServicios1();
        ArrayList<DtoServicio> lista = new ArrayList<>();
        for (DtoServicio dtoServicio : comparar) {

            fecha = dtoServicio.getAfecha();

            try {
                fecha1 = LocalDate.parse(fecha, format);

                if (fecha1.isAfter(hoy)) {

                } else {

                    lista.add(dtoServicio);

                }
            } catch (Exception e) {

                System.out.println(fecha);
            }

        }

        return lista;
    }

    public ArrayList<DtoServicio> listarServiciosPendiente() {

        String fecha, fechaprox;
        LocalDate hoy = LocalDate.now(), fecha1, fecha2;
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        ArrayList<DtoServicio> comparar = daoServicios.listarServicios1();
        ArrayList<DtoServicio> lista = new ArrayList<>();
        for (DtoServicio dtoServicio : comparar) {

            fecha = dtoServicio.getAfecha();

            fechaprox = dtoServicio.getProxFecha();

            if (fecha.equals("") || fechaprox.equals("")) {

            } else {

                fecha1 = LocalDate.parse(fecha, format);
                fecha2 = LocalDate.parse(fechaprox, format);

                if (fecha1.isEqual(hoy) || fecha2.isEqual(hoy)) {

                    lista.add(dtoServicio);

                }

            }

        }

        return lista;
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

            case "Anual":

                fecha_I = fecha_I.plusMonths(12);

                resultado = fecha_I + "";

                return resultado;

            case "Quincenal":

                fecha_I = fecha_I.plusDays(14);

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
            case "Fecha Agenda":

                return daoServicios.listarServiciosPorFiltro("a.fecha", dato);

            case "Otro":

                return daoServicios.listarUniversal(dato);

        }

        return null;
    }

    public void eliminarTodoCliente(String codigoCliente, String nroServicio) {

        Cliente cliente = daoCliente.buscarCliente(codigoCliente);
        Servicio servicio = daoServicios.buscarServicio(nroServicio);

        if (cliente.getCodigo() == null || servicio.getNroFactura() == null) {

            throw new NoExisteCliente();

        } else {

            ArrayList<DTOLocal> listaLocales = daoLocal.listarLocalPorCliente(codigoCliente);

            for (DTOLocal listaLocale : listaLocales) {

                ArrayList<Servicio> listaServicio = daoServicios.listarServiciosParaEliminar("where s.localFk"
                        + "='" + listaLocale.getIdLocal() + "';");

                for (Servicio servicio1 : listaServicio) {
                    daoAgenda.eliminarAgendaPorFk(servicio1.getIdServicio());
                    daoServicios.eliminarServicio(servicio1.getIdServicio());
                }
                daoLocal.eliminarLocal(cliente.getIdCliente());
            }
            daoCliente.eliminarCliente(cliente.getIdCliente());
        }
    }
}
