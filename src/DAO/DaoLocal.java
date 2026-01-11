/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conexion;
import DTO.DTOLocal;
import DTO.DtoClienteLocal;
import Modelo.Ciudad;
import Modelo.Local;
import Modelo.Municipio;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ALAN
 */
public class DaoLocal extends Conexion {

    public DaoLocal() {
    }

    public ArrayList<Municipio> cargarMunicipio() {
        ArrayList<Municipio> lista = new ArrayList<>();
        String consulta = "select idMunicipio, nombre "
                + "from Municipio;";

        super.ejecutarRetorno(consulta);
        try {
            while (resultadoDB.next()) {
                Municipio municipio = new Municipio();
                municipio.setIdMunicipio(resultadoDB.getInt("idMunicipio"));
                municipio.setNombre(resultadoDB.getString("nombre"));
                lista.add(municipio);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return lista;
    }

    public ArrayList<Ciudad> cargarCiudad(String nombre) {
        ArrayList<Ciudad> lista = new ArrayList<>();
        String consulta = "select c.idCiudad, c.nombre "
                + "from Ciudad	c "
                + "join Municipio m on c.municipioFk = m.idMunicipio "
                + "where m.nombre = '" + nombre + "';";

        super.ejecutarRetorno(consulta);
        try {
            while (resultadoDB.next()) {
                Ciudad ciudad = new Ciudad();
                ciudad.setIdCiudad(resultadoDB.getInt("c.idCiudad"));
                ciudad.setNombre(resultadoDB.getString("c.nombre"));
                lista.add(ciudad);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return lista;
    }

    public Ciudad buscarCiudad(String ciudad) {
        String consulta = "select idCiudad, nombre "
                + "from Ciudad "
                + "where nombre = '" + ciudad + "';";
        Ciudad c = new Ciudad();
        super.ejecutarRetorno(consulta);
        try {
            if (resultadoDB.next()) {

                c.setIdCiudad(resultadoDB.getInt("idCiudad"));
                c.setNombre(resultadoDB.getString("nombre"));

            }
        } catch (SQLException ex) {
            System.out.println("Fallo al consultar");
            return null;
        }
        return c;
    }

    public Local buscarLocal(String direccion, int idCiudad) {
        String consulta = "select idLocales, nombreNegocio, direccion, nit, "
                + "encargado, ciudadFk, clienteFk "
                + "from Locales where direccion ='" + direccion + "' "
                + "and ciudadFk ='" + idCiudad + "';";
        Local local = new Local();
        super.ejecutarRetorno(consulta);
        try {
            if (resultadoDB.next()) {

                local.setIdLocales(resultadoDB.getInt("idLocales"));
                local.setNombreNegocio(resultadoDB.getString("nombreNegocio"));
                local.setDireccion(resultadoDB.getString("direccion"));
                local.setNit(resultadoDB.getString("nit"));
                local.setEncargado(resultadoDB.getString("encargado"));
                local.setCiudadFk(resultadoDB.getInt("ciudadFk"));
                local.setClienteFk(resultadoDB.getInt("clienteFk"));

            }
        } catch (SQLException ex) {
            System.out.println("Fallo al consultar");
            return null;
        }
        return local;
    }

    public boolean guardarLocal(Local local) {
        String consulta = "INSERT INTO Locales (nombreNegocio, direccion, nit, "
                + "encargado, ciudadFk, clienteFk)"
                + "VALUES ('" + local.getNombreNegocio() + "', '" + local.getDireccion() + "', '"
                + local.getNit() + "', '" + local.getEncargado() + "', '"
                + local.getCiudadFk() + "', '"
                + local.getClienteFk() + "' "
                + ");";
        return super.ejecutar(consulta);

    }

    public boolean editarLocal(Local local) {
        String consulta = "UPDATE Locales SET nombreNegocio='" + local.getNombreNegocio() + "', "
                + " direccion='" + local.getDireccion() + "', "
                + " nit='" + local.getNit() + "', "
                + " encargado='" + local.getEncargado() + "', "
                + " ciudadFk='" + local.getCiudadFk() + "', "
                + " clienteFk='" + local.getClienteFk() + "' "
                + " WHERE idLocales='" + local.getIdLocales() + "'";
        return super.ejecutar(consulta);

    }

    public boolean eliminarLoca(int id) {
        String consulta = "DELETE FROM Locales where idLocales = " + id + ";";
        return super.ejecutar(consulta);
    }

    public ArrayList<DTOLocal> listarLocalPorCliente(String codigo) {
        ArrayList<DTOLocal> lista = new ArrayList<>();
        String consulta = "select l.nombreNegocio, l.direccion, l.nit, "
                + "l.encargado, mu.nombre, ci.nombre "
                + "from Locales l "
                + "join Cliente c on l.clienteFk = c.idCliente "
                + "join Ciudad ci on l.ciudadFk = ci.idCiudad "
                + "join Municipio mu on ci.municipioFk = mu.idMunicipio "
                + "where c.codigo = '" + codigo + "';";
        //System.out.println(consulta);
        super.ejecutarRetorno(consulta);
        try {
            while (resultadoDB.next()) {
                DTOLocal dtoLocal = new DTOLocal();
                dtoLocal.setNombreNegocio(resultadoDB.getString("l.nombreNegocio"));
                dtoLocal.setDireccion(resultadoDB.getString("l.direccion"));
                dtoLocal.setNit(resultadoDB.getString("l.nit"));
                dtoLocal.setEncargado(resultadoDB.getString("l.encargado"));
                dtoLocal.setMunicipio(resultadoDB.getString("mu.nombre"));
                dtoLocal.setCiudad(resultadoDB.getString("ci.nombre"));
                lista.add(dtoLocal);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return lista;
    }

    public DTOLocal buscarLocal(String direccion, String ciudad) {
        String consulta = "select l.idLocales, l.nombreNegocio, l.direccion, l.nit, "
                + "l.encargado, mu.nombre, ci.nombre "
                + "from Locales l "
                + "join Cliente c on l.clienteFk = c.idCliente "
                + "join Ciudad ci on l.ciudadFk = ci.idCiudad "
                + "join Municipio mu on ci.municipioFk = mu.idMunicipio "
                + "where l.direccion = '" + direccion + "' "
                + "and ci.nombre = '" + ciudad + "';";
        DTOLocal dtoLocal = new DTOLocal();
        super.ejecutarRetorno(consulta);
        try {
            if (resultadoDB.next()) {

                dtoLocal.setIdLocal(resultadoDB.getInt("l.idLocales"));
                dtoLocal.setNombreNegocio(resultadoDB.getString("l.nombreNegocio"));
                dtoLocal.setDireccion(resultadoDB.getString("l.direccion"));
                dtoLocal.setNit(resultadoDB.getString("l.nit"));
                dtoLocal.setEncargado(resultadoDB.getString("l.encargado"));
                dtoLocal.setMunicipio(resultadoDB.getString("mu.nombre"));
                dtoLocal.setCiudad(resultadoDB.getString("ci.nombre"));

            }
        } catch (SQLException ex) {
            System.out.println("Fallo al consultar");
            return null;
        }
        return dtoLocal;
    }

    public ArrayList<DtoClienteLocal> listaClienteLocal() {
        ArrayList<DtoClienteLocal> lista = new ArrayList<>();
        String consulta = "select c.codigo, c.tipo, c.nombre, c.apellido, "
                + "c.celular, c.correo, "
                + "l.nombreNegocio, l.direccion, l.nit, l.encargado, mu.nombre, ci.nombre "
                + "from Locales l "
                + "join Cliente c on l.clienteFk = c.idCliente "
                + "join Ciudad ci on l.ciudadFk = ci.idCiudad "
                + "join Municipio mu on ci.municipioFk = mu.idMunicipio;";
        //System.out.println(consulta);
        super.ejecutarRetorno(consulta);
        try {
            while (resultadoDB.next()) {
                DtoClienteLocal dtoClienteLocal = new DtoClienteLocal();
                dtoClienteLocal.setCodigo(resultadoDB.getString("c.codigo"));
                dtoClienteLocal.setTipo(resultadoDB.getString("c.tipo"));
                dtoClienteLocal.setNombre(resultadoDB.getString("c.nombre"));
                dtoClienteLocal.setApellido(resultadoDB.getString("c.apellido"));
                dtoClienteLocal.setCelular(resultadoDB.getString("c.celular"));
                dtoClienteLocal.setCorreo(resultadoDB.getString("c.correo"));
                dtoClienteLocal.setNombreNegocio(resultadoDB.getString("l.nombreNegocio"));
                dtoClienteLocal.setDireccion(resultadoDB.getString("l.direccion"));
                dtoClienteLocal.setNit(resultadoDB.getString("l.nit"));
                dtoClienteLocal.setEncargado(resultadoDB.getString("l.encargado"));
                dtoClienteLocal.setMunicipio(resultadoDB.getString("mu.nombre"));
                dtoClienteLocal.setCiudad(resultadoDB.getString("ci.nombre"));
                lista.add(dtoClienteLocal);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return lista;
    }

    public ArrayList<DtoClienteLocal> listaClienteLocalporFiltro(String columna, String dato) {
        ArrayList<DtoClienteLocal> lista = new ArrayList<>();
        String consulta = "select c.codigo, c.tipo, c.nombre, c.apellido, "
                + "l.nombreNegocio, l.direccion, l.nit, l.encargado, mu.nombre, ci.nombre "
                + "from Locales l "
                + "join Cliente c on l.clienteFk = c.idCliente "
                + "join Ciudad ci on l.ciudadFk = ci.idCiudad "
                + "join Municipio mu on ci.municipioFk = mu.idMunicipio "
                + "where " + columna + " LIKE '" + dato + "%';";
        //System.out.println(consulta);
        super.ejecutarRetorno(consulta);
        try {
            while (resultadoDB.next()) {
                DtoClienteLocal dtoClienteLocal = new DtoClienteLocal();
                dtoClienteLocal.setCodigo(resultadoDB.getString("c.codigo"));
                dtoClienteLocal.setTipo(resultadoDB.getString("c.tipo"));
                dtoClienteLocal.setNombre(resultadoDB.getString("c.nombre"));
                dtoClienteLocal.setApellido(resultadoDB.getString("c.apellido"));
                dtoClienteLocal.setNombreNegocio(resultadoDB.getString("l.nombreNegocio"));
                dtoClienteLocal.setDireccion(resultadoDB.getString("l.direccion"));
                dtoClienteLocal.setNit(resultadoDB.getString("l.nit"));
                dtoClienteLocal.setEncargado(resultadoDB.getString("l.encargado"));
                dtoClienteLocal.setMunicipio(resultadoDB.getString("mu.nombre"));
                dtoClienteLocal.setCiudad(resultadoDB.getString("ci.nombre"));
                lista.add(dtoClienteLocal);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return lista;
    }
}
