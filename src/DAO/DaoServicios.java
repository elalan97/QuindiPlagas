/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conexion;
import DTO.DtoInformeServicio;
import DTO.DtoServicio;
import Modelo.Servicio;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ALAN
 */
public class DaoServicios extends Conexion {

    public DaoServicios() {
    }

    public boolean guardarServicio(Servicio servicio) {
        String consulta = "INSERT INTO Servicios (nroFactura, tipoServicio, refuerzo, tecnico, "
                + "fecha, periocidad, proxFecha, pago, valor, vendedor,observacion, localFk)"
                + "VALUES ('" + servicio.getNroFactura() + "', '" + servicio.getTipoServicio() + "', '"
                + servicio.getRefuerzo() + "', '" + servicio.getTecnico() + "', '"
                + servicio.getFecha() + "', '" + servicio.getPeriocidad() + "', '"
                + servicio.getProxFecha() + "', '" + servicio.getPago() + "', '"
                + servicio.getValor() + "', '" + servicio.getVendedor() + "', '"
                + servicio.getObservacion() + "', '"
                + servicio.getLocalFk() + "' "
                + ");";
        return super.ejecutar(consulta);

    }

    public Servicio buscarServicio(String nroFactura) {
        String consulta = "select idServicio, nroFactura, tipoServicio, tecnico, "
                + "fecha, periocidad, proxFecha, pago, valor, observacion, localFk "
                + "from Servicios "
                + "where nroFactura ='" + nroFactura + "';";
        Servicio servicio = new Servicio();
        super.ejecutarRetorno(consulta);
        try {
            if (resultadoDB.next()) {

                servicio.setIdServicio(resultadoDB.getInt("idServicio"));
                servicio.setNroFactura(resultadoDB.getString("nroFactura"));
                servicio.setTipoServicio(resultadoDB.getString("tipoServicio"));
                servicio.setTecnico(resultadoDB.getString("tecnico"));
                servicio.setFecha(resultadoDB.getString("fecha"));
                servicio.setPeriocidad(resultadoDB.getString("periocidad"));
                servicio.setProxFecha(resultadoDB.getString("proxFecha"));
                servicio.setPago(resultadoDB.getString("pago"));
                servicio.setValor(resultadoDB.getInt("valor"));
                servicio.setObservacion(resultadoDB.getString("observacion"));
                servicio.setLocalFk(resultadoDB.getInt("localFk"));

            }
        } catch (SQLException ex) {
            System.out.println("Fallo al consultar");
            return null;
        }
        return servicio;
    }

    public boolean editarServicio(Servicio servicio) {
        String consulta = "UPDATE Servicios SET nroFactura='" + servicio.getNroFactura() + "', "
                + " tipoServicio='" + servicio.getTipoServicio() + "', "
                + " refuerzo='" + servicio.getRefuerzo() + "', "
                + " tecnico='" + servicio.getTecnico() + "', "
                + " fecha='" + servicio.getFecha() + "', "
                + " periocidad='" + servicio.getPeriocidad() + "', "
                + " proxFecha='" + servicio.getProxFecha() + "', "
                + " pago='" + servicio.getPago() + "', "
                + " valor='" + servicio.getValor() + "', "
                + " vendedor='" + servicio.getVendedor() + "', "
                + " observacion='" + servicio.getObservacion() + "', "
                + " localFk='" + servicio.getLocalFk() + "' "
                + " WHERE idServicio='" + servicio.getIdServicio() + "'";
        return super.ejecutar(consulta);

    }

    public boolean eliminarServicio(int id) {
        String consulta = "DELETE FROM Servicios where idServicio = " + id + ";";
        return super.ejecutar(consulta);
    }

    public DtoServicio buscarDtoServicio(String nroFactura) {
        String consulta = "select c.codigo, c.tipo, c.nombre, c.apellido, "
                + "c.celular, c.correo, l.nombreNegocio, l.direccion, l.nit, "
                + "l.encargado, ci.nombre, mu.nombre, s.nroFactura, s.refuerzo, s.tipoServicio, "
                + "s.tecnico, s.fecha, s.periocidad, s.proxFecha, s.pago, s.valor, s.observacion "
                + "from Servicios s "
                + "join Locales l on s.localFk = l.idLocales "
                + "join Cliente c on l.clienteFk = c.idCliente "
                + "join Ciudad ci on l.ciudadFk = ci.idCiudad "
                + "join Municipio mu on ci.municipioFk = mu.idMunicipio "
                + "where s.nroFactura = '" + nroFactura + "';";
        DtoServicio dtoServicio = new DtoServicio();
        super.ejecutarRetorno(consulta);
        try {
            if (resultadoDB.next()) {

                dtoServicio.setCodigo(resultadoDB.getString("c.codigo"));
                dtoServicio.setTipo(resultadoDB.getString("c.tipo"));
                dtoServicio.setNombre(resultadoDB.getString("c.nombre"));
                dtoServicio.setApellido(resultadoDB.getString("c.apellido"));
                dtoServicio.setCelular(resultadoDB.getString("c.celular"));
                dtoServicio.setCorreo(resultadoDB.getString("c.correo"));
                dtoServicio.setNombreNegocio(resultadoDB.getString("l.nombreNegocio"));
                dtoServicio.setDireccion(resultadoDB.getString("l.direccion"));
                dtoServicio.setNit(resultadoDB.getString("l.nit"));
                dtoServicio.setEncargado(resultadoDB.getString("l.encargado"));
                dtoServicio.setCiudad(resultadoDB.getString("ci.nombre"));
                dtoServicio.setMunicipio(resultadoDB.getString("mu.nombre"));
                dtoServicio.setNroFactura(resultadoDB.getString("s.nroFactura"));
                dtoServicio.setTipoServicio(resultadoDB.getString("s.tipoServicio"));
                dtoServicio.setRefuerzo(resultadoDB.getString("s.refuerzo"));
                dtoServicio.setTecnico(resultadoDB.getString("s.tecnico"));
                dtoServicio.setFecha(resultadoDB.getString("s.fecha"));
                dtoServicio.setPeriocidad(resultadoDB.getString("s.periocidad"));
                dtoServicio.setProxFecha(resultadoDB.getString("s.proxFecha"));
                dtoServicio.setPago(resultadoDB.getString("s.pago"));
                dtoServicio.setValor(resultadoDB.getString("s.valor"));
                dtoServicio.setObservacion(resultadoDB.getString("s.observacion"));

            }
        } catch (SQLException ex) {
            System.out.println("Fallo al consultar");
            return null;
        }
        return dtoServicio;
    }

    public DtoInformeServicio buscarDtoInformeServicio(String codigoCliente, String direccion) {
        String consulta = "select c.codigo, c.tipo, c.nombre, c.apellido, c.celular, c.correo, "
                + "l.nombreNegocio, l.direccion, l.nit, l.encargado, mu.nombre, ci.nombre "
                + "from Locales l "
                + "join Cliente c on l.clienteFk = c.idCliente "
                + "join Ciudad ci on l.ciudadFk = ci.idCiudad "
                + "join Municipio mu on ci.municipioFk = mu.idMunicipio "
                + "where c.codigo = '" + codigoCliente + "' and "
                + "l.direccion = '" + direccion + "';";
        DtoInformeServicio dtoInformeServicio = new DtoInformeServicio();
        super.ejecutarRetorno(consulta);
        try {
            if (resultadoDB.next()) {

                dtoInformeServicio.setCodigo(resultadoDB.getString("c.codigo"));
                dtoInformeServicio.setTipo(resultadoDB.getString("c.tipo"));
                dtoInformeServicio.setNombre(resultadoDB.getString("c.nombre"));
                dtoInformeServicio.setApellido(resultadoDB.getString("c.apellido"));
                dtoInformeServicio.setCelular(resultadoDB.getString("c.celular"));
                dtoInformeServicio.setCorreo(resultadoDB.getString("c.correo"));
                dtoInformeServicio.setNombreNegocio(resultadoDB.getString("l.nombreNegocio"));
                dtoInformeServicio.setDireccion(resultadoDB.getString("l.direccion"));
                dtoInformeServicio.setNit(resultadoDB.getString("l.nit"));
                dtoInformeServicio.setEncargado(resultadoDB.getString("l.encargado"));
                dtoInformeServicio.setNombreMunicipio(resultadoDB.getString("mu.nombre"));
                dtoInformeServicio.setNombreCiudad(resultadoDB.getString("ci.nombre"));

            }
        } catch (SQLException ex) {
            System.out.println("Fallo al consultar");
            return null;
        }
        return dtoInformeServicio;

    }

    public ArrayList<DtoServicio> listarServicios(String codigo) {
        ArrayList<DtoServicio> lista = new ArrayList<>();
        String consulta = "select c.codigo, c.tipo, c.nombre, c.apellido, c.celular, c.correo, "
                + "l.nombreNegocio, l.direccion, l.nit, l.encargado, ci.nombre, mu.nombre, "
                + "s.nroFactura, s.tipoServicio, s.refuerzo, s.tecnico, s.fecha, s.periocidad, s.proxFecha, "
                + "s.pago, s.valor, s.observacion "
                + "from Servicios s "
                + "join Locales l on s.localFk = l.idLocales "
                + "join Cliente c on l.clienteFk = c.idCliente "
                + "join Ciudad ci on l.ciudadFk = ci.idCiudad "
                + "join Municipio mu on ci.municipioFk = mu.idMunicipio "
                + "where c.codigo = '" + codigo + "' order by s.fecha asc;";
        //System.out.println(consulta);
        super.ejecutarRetorno(consulta);
        try {
            while (resultadoDB.next()) {
                DtoServicio dtoServicio = new DtoServicio();
                dtoServicio.setCodigo(resultadoDB.getString("c.codigo"));
                dtoServicio.setTipo(resultadoDB.getString("c.tipo"));
                dtoServicio.setNombre(resultadoDB.getString("c.nombre"));
                dtoServicio.setApellido(resultadoDB.getString("c.apellido"));
                dtoServicio.setCelular(resultadoDB.getString("c.celular"));
                dtoServicio.setCorreo(resultadoDB.getString("c.correo"));
                dtoServicio.setNombreNegocio(resultadoDB.getString("l.nombreNegocio"));
                dtoServicio.setDireccion(resultadoDB.getString("l.direccion"));
                dtoServicio.setNit(resultadoDB.getString("l.nit"));
                dtoServicio.setEncargado(resultadoDB.getString("l.encargado"));
                dtoServicio.setCiudad(resultadoDB.getString("ci.nombre"));
                dtoServicio.setMunicipio(resultadoDB.getString("mu.nombre"));
                dtoServicio.setNroFactura(resultadoDB.getString("s.nroFactura"));
                dtoServicio.setTipoServicio(resultadoDB.getString("s.tipoServicio"));
                dtoServicio.setTecnico(resultadoDB.getString("s.tecnico"));
                dtoServicio.setFecha(resultadoDB.getString("s.fecha"));
                dtoServicio.setPeriocidad(resultadoDB.getString("s.periocidad"));
                dtoServicio.setProxFecha(resultadoDB.getString("s.proxFecha"));
                dtoServicio.setPago(resultadoDB.getString("s.pago"));
                dtoServicio.setValor(resultadoDB.getString("s.valor"));
                dtoServicio.setRefuerzo(resultadoDB.getString("s.refuerzo"));
                dtoServicio.setObservacion(resultadoDB.getString("s.observacion"));
                lista.add(dtoServicio);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return lista;
    }

    public ArrayList<DtoServicio> listarServicios1() {
        ArrayList<DtoServicio> lista = new ArrayList<>();
        String consulta = "select c.codigo, c.tipo, c.nombre, c.apellido, c.celular, c.correo, "
                + "l.nombreNegocio, l.direccion, l.nit, l.encargado, ci.nombre, mu.nombre, "
                + "s.nroFactura, s.tipoServicio, s.refuerzo, s.tecnico, s.fecha, s.periocidad, s.proxFecha, "
                + "s.pago, s.valor, s.vendedor, s.observacion, a.hora, a.confirmacion, "
                + "a.fecha "
                + "from Servicios s "
                + "join Locales l on s.localFk = l.idLocales "
                + "join Cliente c on l.clienteFk = c.idCliente "
                + "join Ciudad ci on l.ciudadFk = ci.idCiudad "
                + "join Agenda a on s.idServicio = a.servicioFk "
                + "join Municipio mu on ci.municipioFk = mu.idMunicipio "
                + "order by s.fecha asc;";
        //System.out.println(consulta);
        super.ejecutarRetorno(consulta);
        try {
            while (resultadoDB.next()) {
                DtoServicio dtoServicio = new DtoServicio();
                dtoServicio.setCodigo(resultadoDB.getString("c.codigo"));
                dtoServicio.setTipo(resultadoDB.getString("c.tipo"));
                dtoServicio.setNombre(resultadoDB.getString("c.nombre"));
                dtoServicio.setApellido(resultadoDB.getString("c.apellido"));
                dtoServicio.setCelular(resultadoDB.getString("c.celular"));
                dtoServicio.setCorreo(resultadoDB.getString("c.correo"));
                dtoServicio.setNombreNegocio(resultadoDB.getString("l.nombreNegocio"));
                dtoServicio.setDireccion(resultadoDB.getString("l.direccion"));
                dtoServicio.setNit(resultadoDB.getString("l.nit"));
                dtoServicio.setEncargado(resultadoDB.getString("l.encargado"));
                dtoServicio.setCiudad(resultadoDB.getString("ci.nombre"));
                dtoServicio.setMunicipio(resultadoDB.getString("mu.nombre"));
                dtoServicio.setNroFactura(resultadoDB.getString("s.nroFactura"));
                dtoServicio.setTipoServicio(resultadoDB.getString("s.tipoServicio"));
                dtoServicio.setRefuerzo(resultadoDB.getString("s.tecnico"));
                dtoServicio.setTecnico(resultadoDB.getString("s.refuerzo"));
                dtoServicio.setFecha(resultadoDB.getString("s.fecha"));
                dtoServicio.setPeriocidad(resultadoDB.getString("s.periocidad"));
                dtoServicio.setProxFecha(resultadoDB.getString("s.proxFecha"));
                dtoServicio.setPago(resultadoDB.getString("s.pago"));
                dtoServicio.setValor(resultadoDB.getString("s.valor"));
                dtoServicio.setVendedor(resultadoDB.getString("s.vendedor"));
                dtoServicio.setObservacion(resultadoDB.getString("s.observacion"));
                dtoServicio.setAfecha(resultadoDB.getString("a.fecha"));
                dtoServicio.setAhora(resultadoDB.getString("a.hora"));
                dtoServicio.setAconfirmacion(resultadoDB.getString("a.confirmacion"));

                lista.add(dtoServicio);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return lista;
    }

    public ArrayList<DtoServicio> listarServiciosPorFiltro(String columna, String dato) {
        ArrayList<DtoServicio> lista = new ArrayList<>();
        String consulta = "select c.codigo, c.tipo, c.nombre, c.apellido, c.celular, c.correo, "
                + "l.nombreNegocio, l.direccion, l.nit, l.encargado, ci.nombre, mu.nombre, "
                + "s.nroFactura, s.tipoServicio, s.refuerzo, s.tecnico, s.fecha, s.periocidad, s.proxFecha, "
                + "s.pago, s.valor, s.vendedor, s.observacion, a.hora, a.confirmacion, "
                + "a.fecha "
                + "from Servicios s "
                + "join Locales l on s.localFk = l.idLocales "
                + "join Cliente c on l.clienteFk = c.idCliente "
                + "join Ciudad ci on l.ciudadFk = ci.idCiudad "
                + "join Agenda a on s.idServicio = a.servicioFk "
                + "join Municipio mu on ci.municipioFk = mu.idMunicipio "
                + "where " + columna + " LIKE '" + dato + "%' order by s.fecha asc;";
        //System.out.println(consulta);
        super.ejecutarRetorno(consulta);
        try {
            while (resultadoDB.next()) {
                DtoServicio dtoServicio = new DtoServicio();
                dtoServicio.setCodigo(resultadoDB.getString("c.codigo"));
                dtoServicio.setTipo(resultadoDB.getString("c.tipo"));
                dtoServicio.setNombre(resultadoDB.getString("c.nombre"));
                dtoServicio.setApellido(resultadoDB.getString("c.apellido"));
                dtoServicio.setCelular(resultadoDB.getString("c.celular"));
                dtoServicio.setCorreo(resultadoDB.getString("c.correo"));
                dtoServicio.setNombreNegocio(resultadoDB.getString("l.nombreNegocio"));
                dtoServicio.setDireccion(resultadoDB.getString("l.direccion"));
                dtoServicio.setNit(resultadoDB.getString("l.nit"));
                dtoServicio.setEncargado(resultadoDB.getString("l.encargado"));
                dtoServicio.setCiudad(resultadoDB.getString("ci.nombre"));
                dtoServicio.setMunicipio(resultadoDB.getString("mu.nombre"));
                dtoServicio.setNroFactura(resultadoDB.getString("s.nroFactura"));
                dtoServicio.setTipoServicio(resultadoDB.getString("s.tipoServicio"));
                dtoServicio.setRefuerzo(resultadoDB.getString("s.refuerzo"));
                dtoServicio.setTecnico(resultadoDB.getString("s.tecnico"));
                dtoServicio.setFecha(resultadoDB.getString("s.fecha"));
                dtoServicio.setPeriocidad(resultadoDB.getString("s.periocidad"));
                dtoServicio.setProxFecha(resultadoDB.getString("s.proxFecha"));
                dtoServicio.setPago(resultadoDB.getString("s.pago"));
                dtoServicio.setValor(resultadoDB.getString("s.valor"));
                dtoServicio.setVendedor(resultadoDB.getString("s.vendedor"));
                dtoServicio.setObservacion(resultadoDB.getString("s.observacion"));
                dtoServicio.setAfecha(resultadoDB.getString("a.fecha"));
                dtoServicio.setAhora(resultadoDB.getString("a.hora"));
                dtoServicio.setAconfirmacion(resultadoDB.getString("a.confirmacion"));
                lista.add(dtoServicio);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return lista;
    }

    public ArrayList<DtoServicio> listarServiciosPorFiltroVendedor(String dato, String vendedor) {
        ArrayList<DtoServicio> lista = new ArrayList<>();
        String consulta = "select c.codigo, c.tipo, c.nombre, c.apellido, c.celular, c.correo, "
                + "l.nombreNegocio, l.direccion, l.nit, l.encargado, ci.nombre, mu.nombre, "
                + "s.nroFactura, s.tipoServicio, s.refuerzo, s.tecnico, s.fecha, s.periocidad, s.proxFecha, "
                + "s.pago, s.valor, s.vendedor, s.observacion, a.hora, a.confirmacion, "
                + "a.fecha"
                + "from Servicios s "
                + "join Locales l on s.localFk = l.idLocales "
                + "join Cliente c on l.clienteFk = c.idCliente "
                + "join Ciudad ci on l.ciudadFk = ci.idCiudad "
                + "join Agenda a on s.idServicio = a.servicioFk "
                + "join Municipio mu on ci.municipioFk = mu.idMunicipio "
                + "where s.vendedor = '" + vendedor + "' "
                + "and s.fecha = '" + dato + "';";
        //System.out.println(consulta);
        super.ejecutarRetorno(consulta);
        try {
            while (resultadoDB.next()) {
                DtoServicio dtoServicio = new DtoServicio();
                dtoServicio.setCodigo(resultadoDB.getString("c.codigo"));
                dtoServicio.setTipo(resultadoDB.getString("c.tipo"));
                dtoServicio.setNombre(resultadoDB.getString("c.nombre"));
                dtoServicio.setApellido(resultadoDB.getString("c.apellido"));
                dtoServicio.setCelular(resultadoDB.getString("c.celular"));
                dtoServicio.setCorreo(resultadoDB.getString("c.correo"));
                dtoServicio.setNombreNegocio(resultadoDB.getString("l.nombreNegocio"));
                dtoServicio.setDireccion(resultadoDB.getString("l.direccion"));
                dtoServicio.setNit(resultadoDB.getString("l.nit"));
                dtoServicio.setEncargado(resultadoDB.getString("l.encargado"));
                dtoServicio.setCiudad(resultadoDB.getString("ci.nombre"));
                dtoServicio.setMunicipio(resultadoDB.getString("mu.nombre"));
                dtoServicio.setNroFactura(resultadoDB.getString("s.nroFactura"));
                dtoServicio.setTipoServicio(resultadoDB.getString("s.tipoServicio"));
                dtoServicio.setRefuerzo(resultadoDB.getString("s.refuerzo"));
                dtoServicio.setTecnico(resultadoDB.getString("s.tecnico"));
                dtoServicio.setFecha(resultadoDB.getString("s.fecha"));
                dtoServicio.setPeriocidad(resultadoDB.getString("s.periocidad"));
                dtoServicio.setProxFecha(resultadoDB.getString("s.proxFecha"));
                dtoServicio.setPago(resultadoDB.getString("s.pago"));
                dtoServicio.setValor(resultadoDB.getString("s.valor"));
                dtoServicio.setVendedor(resultadoDB.getString("s.vendedor"));
                dtoServicio.setObservacion(resultadoDB.getString("s.observacion"));
                dtoServicio.setAfecha(resultadoDB.getString("a.fecha"));
                dtoServicio.setAhora(resultadoDB.getString("a.hora"));
                dtoServicio.setAconfirmacion(resultadoDB.getString("a.confirmacion"));
                lista.add(dtoServicio);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return lista;
    }

    public Servicio buscarUltimoRegistroServicio() {
        String consulta = "select idServicio, nroFactura, tipoServicio, "
                + "refuerzo, tecnico, fecha, periocidad, "
                + "proxFecha, pago, valor, vendedor, observacion, localFk "
                + "from Servicios "
                + "order by idServicio desc limit 1;";
        Servicio servicio = new Servicio();
        super.ejecutarRetorno(consulta);
        try {
            if (resultadoDB.next()) {

                servicio.setIdServicio(resultadoDB.getInt("idServicio"));
                servicio.setNroFactura(resultadoDB.getString("nroFactura"));
                servicio.setTipoServicio(resultadoDB.getString("tipoServicio"));
                servicio.setRefuerzo(resultadoDB.getString("refuerzo"));
                servicio.setTecnico(resultadoDB.getString("tecnico"));
                servicio.setFecha(resultadoDB.getString("fecha"));
                servicio.setPeriocidad(resultadoDB.getString("periocidad"));
                servicio.setProxFecha(resultadoDB.getString("proxFecha"));
                servicio.setPago(resultadoDB.getString("pago"));
                servicio.setValor(resultadoDB.getInt("valor"));
                servicio.setVendedor(resultadoDB.getString("vendedor"));
                servicio.setObservacion(resultadoDB.getString("observacion"));
                servicio.setLocalFk(resultadoDB.getInt("localFk"));

            }
        } catch (SQLException ex) {
            System.out.println("Fallo al consultar");
            return null;
        }
        return servicio;

    }
}
