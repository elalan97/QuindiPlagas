/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conexion;
import DTO.DtoAgenda;
import Modelo.Agenda;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class DaoAgenda extends Conexion {

    public DaoAgenda() {
    }

    public boolean guardarAgenda(Agenda agenda) {
        String consulta = "INSERT INTO Agenda (hora, confirmacion, "
                + "observacion, servicioFk, fecha)"
                + "VALUES ('" + agenda.getHora() + "', '" + agenda.getConfirmacion() + "', '"
                + agenda.getObservacion() + "', '"
                + agenda.getServicioFk() + "', '"
                + agenda.getFecha() + "' "
                + ");";
        return super.ejecutar(consulta);

    }

    public DtoAgenda verificarAgenda(String nroFactura, String fecha) {
        String consulta = "select c.codigo, c.tipo, c.nombre, c.apellido, c.celular, c.correo, "
                + "l.nombreNegocio, l.direccion, l.nit, l.encargado, ci.nombre, mu.nombre, "
                + "s.nroFactura, s.tipoServicio, s.tecnico, s.fecha, s.periocidad, s.proxFecha, "
                + "s.pago, s.valor, s.observacion, a.idAgenda, a.hora, a.confirmacion, a.observacion, "
                + "a.fecha "
                + "from Agenda a "
                + "join Servicios s on a.servicioFk = s.idServicio "
                + "join Locales l on s.localFk = l.idLocales "
                + "join Cliente c on l.clienteFk = c.idCliente "
                + "join Ciudad ci on l.ciudadFk = ci.idCiudad "
                + "join Municipio mu on ci.municipioFk = mu.idMunicipio "
                + "Where s.nroFactura = '" + nroFactura + "' "
                + "and a.fecha = '" + fecha + "';";
        DtoAgenda dtoAgenda = new DtoAgenda();
        super.ejecutarRetorno(consulta);
        try {
            if (resultadoDB.next()) {

                dtoAgenda.setcCodigo(resultadoDB.getString("c.codigo"));
                dtoAgenda.setcTipo(resultadoDB.getString("c.tipo"));
                dtoAgenda.setcNombre(resultadoDB.getString("c.nombre"));
                dtoAgenda.setcApellido(resultadoDB.getString("c.apellido"));
                dtoAgenda.setcCelular(resultadoDB.getString("c.celular"));
                dtoAgenda.setcCorreo(resultadoDB.getString("c.correo"));
                dtoAgenda.setlNombreNegocio(resultadoDB.getString("l.nombreNegocio"));
                dtoAgenda.setlDireccion(resultadoDB.getString("l.direccion"));
                dtoAgenda.setlNit(resultadoDB.getString("l.nit"));
                dtoAgenda.setlEncargado(resultadoDB.getString("l.encargado"));
                dtoAgenda.setCiNombre(resultadoDB.getString("ci.nombre"));
                dtoAgenda.setMuNombre(resultadoDB.getString("mu.nombre"));
                dtoAgenda.setsNroFactura(resultadoDB.getString("s.nroFactura"));
                dtoAgenda.setsTipoServicio(resultadoDB.getString("s.tipoServicio"));
                dtoAgenda.setsTecnico(resultadoDB.getString("s.tecnico"));
                dtoAgenda.setsFecha(resultadoDB.getString("s.fecha"));
                dtoAgenda.setsPeriocidad(resultadoDB.getString("s.periocidad"));
                dtoAgenda.setsProxFecha(resultadoDB.getString("s.proxFecha"));
                dtoAgenda.setsPago(resultadoDB.getString("s.pago"));
                dtoAgenda.setsValor(resultadoDB.getString("s.valor"));
                dtoAgenda.setsObservacion(resultadoDB.getString("s.observacion"));
                dtoAgenda.setaIdAgenda(resultadoDB.getInt("a.idAgenda"));
                dtoAgenda.setaHora(resultadoDB.getString("a.hora"));
                dtoAgenda.setaConfirmacion(resultadoDB.getString("a.confirmacion"));
                dtoAgenda.setaObservacion(resultadoDB.getString("a.observacion"));
                dtoAgenda.setaFecha(resultadoDB.getString("a.fecha"));

            }
        } catch (SQLException ex) {
            System.out.println("Fallo al consultar");
            return null;
        }
        return dtoAgenda;
    }

    public boolean editarAgenda(Agenda agenda) {
        String consulta = "UPDATE Agenda SET hora='" + agenda.getHora() + "', "
                + " confirmacion='" + agenda.getConfirmacion() + "', "
                + " observacion='" + agenda.getObservacion() + "', "
                + " servicioFk='" + agenda.getServicioFk() + "', "
                + " fecha='" + agenda.getFecha() + "' "
                + " WHERE idAgenda='" + agenda.getIdAgenda() + "'";
        return super.ejecutar(consulta);

    }

    public boolean eliminarAgenda(int id) {
        String consulta = "DELETE FROM Agenda where idAgenda = " + id + ";";
        return super.ejecutar(consulta);
    }

    public ArrayList<DtoAgenda> listarAgenda() {
        ArrayList<DtoAgenda> lista = new ArrayList<>();
        String consulta = "select c.codigo, c.tipo, c.nombre, c.apellido, c.celular, c.correo, "
                + "l.nombreNegocio, l.direccion, l.nit, l.encargado, ci.nombre, mu.nombre, "
                + "s.nroFactura, s.tipoServicio, s.tecnico, s.fecha, s.periocidad, s.proxFecha, "
                + "s.pago, s.valor, s.observacion, a.idAgenda, a.hora, a.confirmacion, a.observacion, "
                + "a.fecha "
                + "from Agenda a "
                + "join Servicios s on a.servicioFk = s.idServicio "
                + "join Locales l on s.localFk = l.idLocales "
                + "join Cliente c on l.clienteFk = c.idCliente "
                + "join Ciudad ci on l.ciudadFk = ci.idCiudad "
                + "join Municipio mu on ci.municipioFk = mu.idMunicipio;";
        //System.out.println(consulta);
        super.ejecutarRetorno(consulta);
        try {
            while (resultadoDB.next()) {
                DtoAgenda dtoAgenda = new DtoAgenda();
                dtoAgenda.setcCodigo(resultadoDB.getString("c.codigo"));
                dtoAgenda.setcTipo(resultadoDB.getString("c.tipo"));
                dtoAgenda.setcNombre(resultadoDB.getString("c.nombre"));
                dtoAgenda.setcApellido(resultadoDB.getString("c.apellido"));
                dtoAgenda.setcCelular(resultadoDB.getString("c.celular"));
                dtoAgenda.setcCorreo(resultadoDB.getString("c.correo"));
                dtoAgenda.setlNombreNegocio(resultadoDB.getString("l.nombreNegocio"));
                dtoAgenda.setlDireccion(resultadoDB.getString("l.direccion"));
                dtoAgenda.setlNit(resultadoDB.getString("l.nit"));
                dtoAgenda.setlEncargado(resultadoDB.getString("l.encargado"));
                dtoAgenda.setCiNombre(resultadoDB.getString("ci.nombre"));
                dtoAgenda.setMuNombre(resultadoDB.getString("mu.nombre"));
                dtoAgenda.setsNroFactura(resultadoDB.getString("s.nroFactura"));
                dtoAgenda.setsTipoServicio(resultadoDB.getString("s.tipoServicio"));
                dtoAgenda.setsTecnico(resultadoDB.getString("s.tecnico"));
                dtoAgenda.setsFecha(resultadoDB.getString("s.fecha"));
                dtoAgenda.setsPeriocidad(resultadoDB.getString("s.periocidad"));
                dtoAgenda.setsProxFecha(resultadoDB.getString("s.proxFecha"));
                dtoAgenda.setsPago(resultadoDB.getString("s.pago"));
                dtoAgenda.setsValor(resultadoDB.getString("s.valor"));
                dtoAgenda.setsObservacion(resultadoDB.getString("s.observacion"));
                dtoAgenda.setaIdAgenda(resultadoDB.getInt("a.idAgenda"));
                dtoAgenda.setaHora(resultadoDB.getString("a.hora"));
                dtoAgenda.setaConfirmacion(resultadoDB.getString("a.confirmacion"));
                dtoAgenda.setaObservacion(resultadoDB.getString("a.observacion"));
                dtoAgenda.setaFecha(resultadoDB.getString("a.fecha"));
                lista.add(dtoAgenda);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return lista;
    }
    
    public ArrayList<DtoAgenda> listarAgendaPorFiltro(String fecha) {
        ArrayList<DtoAgenda> lista = new ArrayList<>();
        String consulta = "select c.codigo, c.tipo, c.nombre, c.apellido, c.celular, c.correo, "
                + "l.nombreNegocio, l.direccion, l.nit, l.encargado, ci.nombre, mu.nombre, "
                + "s.nroFactura, s.tipoServicio, s.tecnico, s.fecha, s.periocidad, s.proxFecha, "
                + "s.pago, s.valor, s.observacion, a.idAgenda, a.hora, a.confirmacion, a.observacion, "
                + "a.fecha "
                + "from Agenda a "
                + "join Servicios s on a.servicioFk = s.idServicio "
                + "join Locales l on s.localFk = l.idLocales "
                + "join Cliente c on l.clienteFk = c.idCliente "
                + "join Ciudad ci on l.ciudadFk = ci.idCiudad "
                + "join Municipio mu on ci.municipioFk = mu.idMunicipio "
                + "Where a.fecha = '" + fecha + "' "
                + "ORDER BY STR_TO_DATE(a.hora, '%l %p');";
        //System.out.println(consulta);
        super.ejecutarRetorno(consulta);
        try {
            while (resultadoDB.next()) {
                DtoAgenda dtoAgenda = new DtoAgenda();
                dtoAgenda.setcCodigo(resultadoDB.getString("c.codigo"));
                dtoAgenda.setcTipo(resultadoDB.getString("c.tipo"));
                dtoAgenda.setcNombre(resultadoDB.getString("c.nombre"));
                dtoAgenda.setcApellido(resultadoDB.getString("c.apellido"));
                dtoAgenda.setcCelular(resultadoDB.getString("c.celular"));
                dtoAgenda.setcCorreo(resultadoDB.getString("c.correo"));
                dtoAgenda.setlNombreNegocio(resultadoDB.getString("l.nombreNegocio"));
                dtoAgenda.setlDireccion(resultadoDB.getString("l.direccion"));
                dtoAgenda.setlNit(resultadoDB.getString("l.nit"));
                dtoAgenda.setlEncargado(resultadoDB.getString("l.encargado"));
                dtoAgenda.setCiNombre(resultadoDB.getString("ci.nombre"));
                dtoAgenda.setMuNombre(resultadoDB.getString("mu.nombre"));
                dtoAgenda.setsNroFactura(resultadoDB.getString("s.nroFactura"));
                dtoAgenda.setsTipoServicio(resultadoDB.getString("s.tipoServicio"));
                dtoAgenda.setsTecnico(resultadoDB.getString("s.tecnico"));
                dtoAgenda.setsFecha(resultadoDB.getString("s.fecha"));
                dtoAgenda.setsPeriocidad(resultadoDB.getString("s.periocidad"));
                dtoAgenda.setsProxFecha(resultadoDB.getString("s.proxFecha"));
                dtoAgenda.setsPago(resultadoDB.getString("s.pago"));
                dtoAgenda.setsValor(resultadoDB.getString("s.valor"));
                dtoAgenda.setsObservacion(resultadoDB.getString("s.observacion"));
                dtoAgenda.setaIdAgenda(resultadoDB.getInt("a.idAgenda"));
                dtoAgenda.setaHora(resultadoDB.getString("a.hora"));
                dtoAgenda.setaConfirmacion(resultadoDB.getString("a.confirmacion"));
                dtoAgenda.setaObservacion(resultadoDB.getString("a.observacion"));
                dtoAgenda.setaFecha(resultadoDB.getString("a.fecha"));
                lista.add(dtoAgenda);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return lista;
    }
    
    public DtoAgenda buscarServicioAgenda(String nroFactura) {
        String consulta = "select c.codigo, c.tipo, c.nombre, c.apellido, c.celular, c.correo, "
                + "l.nombreNegocio, l.direccion, l.nit, l.encargado, ci.nombre, mu.nombre, "
                + "s.nroFactura, s.tipoServicio, s.refuerzo, s.tecnico, s.fecha, s.periocidad, s.proxFecha, "
                + "s.pago, s.valor, s.observacion, a.idAgenda, a.hora, a.confirmacion, a.observacion, "
                + "a.fecha "
                + "from Agenda a "
                + "join Servicios s on a.servicioFk = s.idServicio "
                + "join Locales l on s.localFk = l.idLocales "
                + "join Cliente c on l.clienteFk = c.idCliente "
                + "join Ciudad ci on l.ciudadFk = ci.idCiudad "
                + "join Municipio mu on ci.municipioFk = mu.idMunicipio "
                + "Where s.nroFactura = '" + nroFactura + "';";
        DtoAgenda dtoAgenda = new DtoAgenda();
        super.ejecutarRetorno(consulta);
        try {
            if (resultadoDB.next()) {

                dtoAgenda.setcCodigo(resultadoDB.getString("c.codigo"));
                dtoAgenda.setcTipo(resultadoDB.getString("c.tipo"));
                dtoAgenda.setcNombre(resultadoDB.getString("c.nombre"));
                dtoAgenda.setcApellido(resultadoDB.getString("c.apellido"));
                dtoAgenda.setcCelular(resultadoDB.getString("c.celular"));
                dtoAgenda.setcCorreo(resultadoDB.getString("c.correo"));
                dtoAgenda.setlNombreNegocio(resultadoDB.getString("l.nombreNegocio"));
                dtoAgenda.setlDireccion(resultadoDB.getString("l.direccion"));
                dtoAgenda.setlNit(resultadoDB.getString("l.nit"));
                dtoAgenda.setlEncargado(resultadoDB.getString("l.encargado"));
                dtoAgenda.setCiNombre(resultadoDB.getString("ci.nombre"));
                dtoAgenda.setMuNombre(resultadoDB.getString("mu.nombre"));
                dtoAgenda.setsNroFactura(resultadoDB.getString("s.nroFactura"));
                dtoAgenda.setsTipoServicio(resultadoDB.getString("s.tipoServicio"));
                dtoAgenda.setsRefuerzo(resultadoDB.getString("s.refuerzo"));
                dtoAgenda.setsTecnico(resultadoDB.getString("s.tecnico"));
                dtoAgenda.setsFecha(resultadoDB.getString("s.fecha"));
                dtoAgenda.setsPeriocidad(resultadoDB.getString("s.periocidad"));
                dtoAgenda.setsProxFecha(resultadoDB.getString("s.proxFecha"));
                dtoAgenda.setsPago(resultadoDB.getString("s.pago"));
                dtoAgenda.setsValor(resultadoDB.getString("s.valor"));
                dtoAgenda.setsObservacion(resultadoDB.getString("s.observacion"));
                dtoAgenda.setaIdAgenda(resultadoDB.getInt("a.idAgenda"));
                dtoAgenda.setaHora(resultadoDB.getString("a.hora"));
                dtoAgenda.setaConfirmacion(resultadoDB.getString("a.confirmacion"));
                dtoAgenda.setaObservacion(resultadoDB.getString("a.observacion"));
                dtoAgenda.setaFecha(resultadoDB.getString("a.fecha"));

            }
        } catch (SQLException ex) {
            System.out.println("Fallo al consultar");
            return null;
        }
        return dtoAgenda;
    }
    
    public DtoAgenda buscarServicioAgendaRefuerzo(String nroFactura) {
        String consulta = "select c.codigo, c.tipo, c.nombre, c.apellido, c.celular, c.correo, "
                + "l.nombreNegocio, l.direccion, l.nit, l.encargado, ci.nombre, mu.nombre, "
                + "s.nroFactura, s.tipoServicio, s.refuerzo, s.tecnico, s.fecha, s.periocidad, s.proxFecha, "
                + "s.pago, s.valor, s.observacion, a.idAgenda, a.hora, a.confirmacion, a.observacion, "
                + "a.fecha "
                + "from Agenda a "
                + "join Servicios s on a.servicioFk = s.idServicio "
                + "join Locales l on s.localFk = l.idLocales "
                + "join Cliente c on l.clienteFk = c.idCliente "
                + "join Ciudad ci on l.ciudadFk = ci.idCiudad "
                + "join Municipio mu on ci.municipioFk = mu.idMunicipio "
                + "Where s.nroFactura = '" + nroFactura + "'"
                + "order by a.fecha desc limit 1;";
        DtoAgenda dtoAgenda = new DtoAgenda();
        super.ejecutarRetorno(consulta);
        try {
            if (resultadoDB.next()) {

                dtoAgenda.setcCodigo(resultadoDB.getString("c.codigo"));
                dtoAgenda.setcTipo(resultadoDB.getString("c.tipo"));
                dtoAgenda.setcNombre(resultadoDB.getString("c.nombre"));
                dtoAgenda.setcApellido(resultadoDB.getString("c.apellido"));
                dtoAgenda.setcCelular(resultadoDB.getString("c.celular"));
                dtoAgenda.setcCorreo(resultadoDB.getString("c.correo"));
                dtoAgenda.setlNombreNegocio(resultadoDB.getString("l.nombreNegocio"));
                dtoAgenda.setlDireccion(resultadoDB.getString("l.direccion"));
                dtoAgenda.setlNit(resultadoDB.getString("l.nit"));
                dtoAgenda.setlEncargado(resultadoDB.getString("l.encargado"));
                dtoAgenda.setCiNombre(resultadoDB.getString("ci.nombre"));
                dtoAgenda.setMuNombre(resultadoDB.getString("mu.nombre"));
                dtoAgenda.setsNroFactura(resultadoDB.getString("s.nroFactura"));
                dtoAgenda.setsTipoServicio(resultadoDB.getString("s.tipoServicio"));
                dtoAgenda.setsRefuerzo(resultadoDB.getString("s.refuerzo"));
                dtoAgenda.setsTecnico(resultadoDB.getString("s.tecnico"));
                dtoAgenda.setsFecha(resultadoDB.getString("s.fecha"));
                dtoAgenda.setsPeriocidad(resultadoDB.getString("s.periocidad"));
                dtoAgenda.setsProxFecha(resultadoDB.getString("s.proxFecha"));
                dtoAgenda.setsPago(resultadoDB.getString("s.pago"));
                dtoAgenda.setsValor(resultadoDB.getString("s.valor"));
                dtoAgenda.setsObservacion(resultadoDB.getString("s.observacion"));
                dtoAgenda.setaIdAgenda(resultadoDB.getInt("a.idAgenda"));
                dtoAgenda.setaHora(resultadoDB.getString("a.hora"));
                dtoAgenda.setaConfirmacion(resultadoDB.getString("a.confirmacion"));
                dtoAgenda.setaObservacion(resultadoDB.getString("a.observacion"));
                dtoAgenda.setaFecha(resultadoDB.getString("a.fecha"));

            }
        } catch (SQLException ex) {
            System.out.println("Fallo al consultar");
            return null;
        }
        return dtoAgenda;
    }
}
