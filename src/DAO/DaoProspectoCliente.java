/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conexion;
import DTO.DtoProspectoCliente;
import Modelo.ProspectoCliente;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class DaoProspectoCliente extends Conexion {

    public DaoProspectoCliente() {
    }

    public boolean guardarProspectoCliente(ProspectoCliente prospectoCliente) {
        String consulta = "INSERT INTO ProspectoCliente (estado, fecha, tipo, "
                + "nombre, apellido, celular, correo, nombreNegocio, direccion, "
                + "nit, encargado, ciudadFk, servicioOfrecido, valor, vendedor)"
                + "VALUES ('" + prospectoCliente.getEstado() + "', '"
                + prospectoCliente.getFecha() + "', '" + prospectoCliente.getTipo() + "', '"
                + prospectoCliente.getNombre() + "', '" + prospectoCliente.getApellido() + "', '"
                + prospectoCliente.getCelular() + "', '" + prospectoCliente.getCorreo() + "', '"
                + prospectoCliente.getNombreNegocio() + "', '" + prospectoCliente.getDireccion() + "', '"
                + prospectoCliente.getNit() + "', '" + prospectoCliente.getEncargado() + "', '"
                + prospectoCliente.getCiudadFk() + "', '" + prospectoCliente.getServicioOfrecido() + "', '"
                + prospectoCliente.getValor() + "', '" + prospectoCliente.getVendedor() + "' "
                + ");";
        return super.ejecutar(consulta);

    }

    public ProspectoCliente verificarProspectoCliente(String nombreNegocio) {
        String consulta = "select idProspecto, estado, fecha, tipo, nombre, apellido, "
                + "celular, correo, celular, correo, nombreNegocio, direccion, "
                + "nit, encargado, ciudadFk, servicioOfrecido, valor, vendedor "
                + "from ProspectoCliente where nombreNegocio ='" + nombreNegocio + "';";
        ProspectoCliente cliente = new ProspectoCliente();
        System.out.println(consulta);
        super.ejecutarRetorno(consulta);
        try {
            if (resultadoDB.next()) {

                cliente.setIdProspecto(resultadoDB.getInt("idProspecto"));
                cliente.setEstado(resultadoDB.getString("estado"));
                cliente.setFecha(resultadoDB.getString("fecha"));
                cliente.setTipo(resultadoDB.getString("tipo"));
                cliente.setNombre(resultadoDB.getString("nombre"));
                cliente.setApellido(resultadoDB.getString("apellido"));
                cliente.setCelular(resultadoDB.getString("celular"));
                cliente.setCorreo(resultadoDB.getString("correo"));
                cliente.setNombreNegocio(resultadoDB.getString("nombreNegocio"));
                cliente.setDireccion(resultadoDB.getString("direccion"));
                cliente.setNit(resultadoDB.getString("nit"));
                cliente.setEncargado(resultadoDB.getString("encargado"));
                cliente.setCiudadFk(resultadoDB.getInt("ciudadFk"));
                cliente.setServicioOfrecido(resultadoDB.getString("servicioOfrecido"));
                cliente.setValor(resultadoDB.getInt("valor"));
                cliente.setVendedor(resultadoDB.getString("vendedor"));

            }
        } catch (SQLException ex) {
            System.out.println("Fallo al consultar");
            return null;
        }
        return cliente;
    }

    public ProspectoCliente buscarProspectoCliente(String direccion) {
        String consulta = "select idProspecto, estado, fecha, tipo, nombre, apellido, "
                + "celular, correo, celular, correo, nombreNegocio, direccion, "
                + "nit, encargado, ciudadFk, servicioOfrecido, valor, vendedor "
                + "from ProspectoCliente where direccion ='" + direccion + "';";
        ProspectoCliente cliente = new ProspectoCliente();
        System.out.println(consulta);
        super.ejecutarRetorno(consulta);
        try {
            if (resultadoDB.next()) {

                cliente.setIdProspecto(resultadoDB.getInt("idProspecto"));
                cliente.setEstado(resultadoDB.getString("estado"));
                cliente.setFecha(resultadoDB.getString("fecha"));
                cliente.setTipo(resultadoDB.getString("tipo"));
                cliente.setNombre(resultadoDB.getString("nombre"));
                cliente.setApellido(resultadoDB.getString("apellido"));
                cliente.setCelular(resultadoDB.getString("celular"));
                cliente.setCorreo(resultadoDB.getString("correo"));
                cliente.setNombreNegocio(resultadoDB.getString("nombreNegocio"));
                cliente.setDireccion(resultadoDB.getString("direccion"));
                cliente.setNit(resultadoDB.getString("nit"));
                cliente.setEncargado(resultadoDB.getString("encargado"));
                cliente.setCiudadFk(resultadoDB.getInt("ciudadFk"));
                cliente.setServicioOfrecido(resultadoDB.getString("servicioOfrecido"));
                cliente.setValor(resultadoDB.getInt("valor"));
                cliente.setVendedor(resultadoDB.getString("vendedor"));

            }
        } catch (SQLException ex) {
            System.out.println("Fallo al consultar");
            return null;
        }
        return cliente;
    }

    public DtoProspectoCliente buscarProspectoCliente1(String direccion) {
        String consulta = "select pc.estado, pc.fecha, pc.tipo, pc.nombre, pc.apellido, "
                + "pc.celular, pc.correo, pc.nombreNegocio, pc.direccion, "
                + "pc.nit, pc.encargado, pc.servicioOfrecido, pc.valor, pc.vendedor, "
                + "mu.nombre, ci.nombre "
                + "from ProspectoCliente pc "
                + "join Ciudad ci on pc.ciudadFk = ci.idCiudad "
                + "join Municipio mu on ci.municipioFk = mu.idMunicipio "
                + "where pc.direccion = '" + direccion + "';";
        DtoProspectoCliente cliente = new DtoProspectoCliente();
        super.ejecutarRetorno(consulta);
        try {
            if (resultadoDB.next()) {

                cliente.setEstado(resultadoDB.getString("pc.estado"));
                cliente.setFecha(resultadoDB.getString("pc.fecha"));
                cliente.setTipo(resultadoDB.getString("pc.tipo"));
                cliente.setNombre(resultadoDB.getString("pc.nombre"));
                cliente.setApellido(resultadoDB.getString("pc.apellido"));
                cliente.setCelular(resultadoDB.getString("pc.celular"));
                cliente.setCorreo(resultadoDB.getString("pc.correo"));
                cliente.setNombreNegocio(resultadoDB.getString("pc.nombreNegocio"));
                cliente.setDireccion(resultadoDB.getString("pc.direccion"));
                cliente.setNit(resultadoDB.getString("pc.nit"));
                cliente.setEncargado(resultadoDB.getString("pc.encargado"));
                cliente.setMunicipio(resultadoDB.getString("mu.nombre"));
                cliente.setCiudad(resultadoDB.getString("ci.nombre"));
                cliente.setServicioOfrecido(resultadoDB.getString("pc.servicioOfrecido"));
                cliente.setValor(resultadoDB.getString("pc.valor"));
                cliente.setVendedor(resultadoDB.getString("pc.vendedor"));

            }
        } catch (SQLException ex) {
            System.out.println("Fallo al consultar");
            return null;
        }
        return cliente;
    }

    public boolean editarProspectoCliente(ProspectoCliente prospectoCliente) {
        String consulta = "UPDATE ProspectoCliente SET estado='" + prospectoCliente.getEstado() + "', "
                + " fecha='" + prospectoCliente.getFecha() + "', "
                + " tipo='" + prospectoCliente.getTipo() + "', "
                + " nombre='" + prospectoCliente.getNombre() + "', "
                + " apellido='" + prospectoCliente.getApellido() + "', "
                + " celular='" + prospectoCliente.getCelular() + "', "
                + " correo='" + prospectoCliente.getCorreo() + "', "
                + " nombreNegocio='" + prospectoCliente.getNombreNegocio() + "', "
                + " direccion='" + prospectoCliente.getDireccion() + "', "
                + " nit='" + prospectoCliente.getNit() + "', "
                + " encargado='" + prospectoCliente.getEncargado() + "', "
                + " servicioOfrecido='" + prospectoCliente.getServicioOfrecido() + "', "
                + " valor='" + prospectoCliente.getValor() + "', "
                + " vendedor='" + prospectoCliente.getVendedor() + "', "
                + " ciudadFk='" + prospectoCliente.getCiudadFk() + "' "
                + " WHERE idProspecto='" + prospectoCliente.getIdProspecto() + "'";
        return super.ejecutar(consulta);

    }

    public boolean eliminarProspectoCliente(int id) {
        String consulta = "DELETE FROM ProspectoCliente where idProspecto = " + id + ";";
        return super.ejecutar(consulta);
    }

    public ArrayList<DtoProspectoCliente> listarPorFiltro(String columna, String dato) {
        ArrayList<DtoProspectoCliente> lista = new ArrayList<>();
        String consulta = "select pc.estado, pc.fecha, pc.tipo, pc.nombre, pc.apellido, "
                + "pc.celular, pc.correo, pc.nombreNegocio, pc.direccion, "
                + "pc.nit, pc.encargado, pc.servicioOfrecido, pc.valor, pc.vendedor, "
                + "mu.nombre, ci.nombre "
                + "from ProspectoCliente pc "
                + "join Ciudad ci on pc.ciudadFk = ci.idCiudad "
                + "join Municipio mu on ci.municipioFk = mu.idMunicipio "
                + "WHERE " + columna + " LIKE '" + dato + "%';";
        //System.out.println(consulta);
        super.ejecutarRetorno(consulta);
        try {
            while (resultadoDB.next()) {
                DtoProspectoCliente cliente = new DtoProspectoCliente();
                cliente.setEstado(resultadoDB.getString("pc.estado"));
                cliente.setFecha(resultadoDB.getString("pc.fecha"));
                cliente.setTipo(resultadoDB.getString("pc.tipo"));
                cliente.setNombre(resultadoDB.getString("pc.nombre"));
                cliente.setApellido(resultadoDB.getString("pc.apellido"));
                cliente.setCelular(resultadoDB.getString("pc.celular"));
                cliente.setCorreo(resultadoDB.getString("pc.correo"));
                cliente.setNombreNegocio(resultadoDB.getString("pc.nombreNegocio"));
                cliente.setDireccion(resultadoDB.getString("pc.direccion"));
                cliente.setNit(resultadoDB.getString("pc.nit"));
                cliente.setEncargado(resultadoDB.getString("pc.encargado"));
                cliente.setMunicipio(resultadoDB.getString("mu.nombre"));
                cliente.setCiudad(resultadoDB.getString("ci.nombre"));
                cliente.setServicioOfrecido(resultadoDB.getString("pc.servicioOfrecido"));
                cliente.setValor(resultadoDB.getString("pc.valor"));
                cliente.setVendedor(resultadoDB.getString("pc.vendedor"));
                lista.add(cliente);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return lista;
    }

    public ArrayList<DtoProspectoCliente> listarProspectoCliente() {
        ArrayList<DtoProspectoCliente> lista = new ArrayList<>();
        String consulta = "select pc.estado, pc.fecha, pc.tipo, pc.nombre, pc.apellido, "
                + "pc.celular, pc.correo, pc.nombreNegocio, pc.direccion, "
                + "pc.nit, pc.encargado, pc.servicioOfrecido, pc.valor, pc.vendedor, "
                + "mu.nombre, ci.nombre "
                + "from ProspectoCliente pc "
                + "join Ciudad ci on pc.ciudadFk = ci.idCiudad "
                + "join Municipio mu on ci.municipioFk = mu.idMunicipio;";
        //System.out.println(consulta);
        super.ejecutarRetorno(consulta);
        try {
            while (resultadoDB.next()) {
                DtoProspectoCliente cliente = new DtoProspectoCliente();
                cliente.setEstado(resultadoDB.getString("pc.estado"));
                cliente.setFecha(resultadoDB.getString("pc.fecha"));
                cliente.setTipo(resultadoDB.getString("pc.tipo"));
                cliente.setNombre(resultadoDB.getString("pc.nombre"));
                cliente.setApellido(resultadoDB.getString("pc.apellido"));
                cliente.setCelular(resultadoDB.getString("pc.celular"));
                cliente.setCorreo(resultadoDB.getString("pc.correo"));
                cliente.setNombreNegocio(resultadoDB.getString("pc.nombreNegocio"));
                cliente.setDireccion(resultadoDB.getString("pc.direccion"));
                cliente.setNit(resultadoDB.getString("pc.nit"));
                cliente.setEncargado(resultadoDB.getString("pc.encargado"));
                cliente.setMunicipio(resultadoDB.getString("mu.nombre"));
                cliente.setCiudad(resultadoDB.getString("ci.nombre"));
                cliente.setServicioOfrecido(resultadoDB.getString("pc.servicioOfrecido"));
                cliente.setValor(resultadoDB.getString("pc.valor"));
                cliente.setVendedor(resultadoDB.getString("pc.vendedor"));
                lista.add(cliente);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return lista;
    }
    
    public ArrayList<DtoProspectoCliente> listaProspectoCliente(String fecha) {
        ArrayList<DtoProspectoCliente> lista = new ArrayList<>();
        String consulta = "select pc.estado, pc.fecha, pc.tipo, pc.nombre, pc.apellido, "
                + "pc.celular, pc.correo, pc.nombreNegocio, pc.direccion, "
                + "pc.nit, pc.encargado, pc.servicioOfrecido, pc.valor, pc.vendedor, "
                + "mu.nombre, ci.nombre "
                + "from ProspectoCliente pc "
                + "join Ciudad ci on pc.ciudadFk = ci.idCiudad "
                + "join Municipio mu on ci.municipioFk = mu.idMunicipio "
                + "where pc.fecha = '" + fecha +"';";
        //System.out.println(consulta);
        super.ejecutarRetorno(consulta);
        try {
            while (resultadoDB.next()) {
                DtoProspectoCliente cliente = new DtoProspectoCliente();
                cliente.setEstado(resultadoDB.getString("pc.estado"));
                cliente.setFecha(resultadoDB.getString("pc.fecha"));
                cliente.setTipo(resultadoDB.getString("pc.tipo"));
                cliente.setNombre(resultadoDB.getString("pc.nombre"));
                cliente.setApellido(resultadoDB.getString("pc.apellido"));
                cliente.setCelular(resultadoDB.getString("pc.celular"));
                cliente.setCorreo(resultadoDB.getString("pc.correo"));
                cliente.setNombreNegocio(resultadoDB.getString("pc.nombreNegocio"));
                cliente.setDireccion(resultadoDB.getString("pc.direccion"));
                cliente.setNit(resultadoDB.getString("pc.nit"));
                cliente.setEncargado(resultadoDB.getString("pc.encargado"));
                cliente.setMunicipio(resultadoDB.getString("mu.nombre"));
                cliente.setCiudad(resultadoDB.getString("ci.nombre"));
                cliente.setServicioOfrecido(resultadoDB.getString("pc.servicioOfrecido"));
                cliente.setValor(resultadoDB.getString("pc.valor"));
                cliente.setVendedor(resultadoDB.getString("pc.vendedor"));
                lista.add(cliente);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return lista;
    }
}
