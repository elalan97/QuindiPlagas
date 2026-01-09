/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conexion;
import Modelo.Cliente;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ALAN
 */
public class DaoCliente extends Conexion{

    public DaoCliente() {
    }
    
    public Cliente buscarCliente(String codigo) {
        String consulta = "select idCliente, codigo, tipo, nombre, apellido, "
                + "celular, correo "
                + "from Cliente where codigo ='" + codigo + "'";
        Cliente cliente = new Cliente();
        super.ejecutarRetorno(consulta);
        try {
            if (resultadoDB.next()) {

                cliente.setIdCliente(resultadoDB.getInt("idCliente"));
                cliente.setCodigo(resultadoDB.getString("codigo"));
                cliente.setTipo(resultadoDB.getString("tipo"));
                cliente.setNombre(resultadoDB.getString("nombre"));
                cliente.setApellido(resultadoDB.getString("apellido"));
                cliente.setCelular(resultadoDB.getString("celular"));
                cliente.setCorreo(resultadoDB.getString("correo"));
                
            }
        } catch (SQLException ex) {
            System.out.println("Fallo al consultar");
            return null;
        }
        return cliente;
    }

    public boolean guardarCliente(Cliente cliente) {
        String consulta = "INSERT INTO Cliente (codigo, tipo, nombre, "
                + "apellido, celular, correo)"
                + "VALUES ('" + cliente.getCodigo() + "', '" + cliente.getTipo() + "', '"
                + cliente.getNombre() + "', '" + cliente.getApellido() + "', '"
                + cliente.getCelular() + "', '"
                + cliente.getCorreo() + "' "
                + ");";
        return super.ejecutar(consulta);

    }

    public boolean editarCliente(Cliente cliente) {
        String consulta = "UPDATE Cliente SET codigo='" + cliente.getCodigo()+ "', "
                + " tipo='" + cliente.getTipo() + "', "
                + " nombre='" + cliente.getNombre() + "', "
                + " apellido='" + cliente.getApellido() + "', "
                + " celular='" + cliente.getCelular() + "', "
                + " correo='" + cliente.getCorreo() + "' "
                + " WHERE idCliente='" + cliente.getIdCliente()+ "'";
        return super.ejecutar(consulta);

    }

    public boolean eliminarCliente(int id) {
        String consulta = "DELETE FROM Cliente where idCliente = " + id + ";";
        return super.ejecutar(consulta);
    }
    
    public ArrayList<Cliente> listarClientePorFiltro(String columna, String dato) {
        ArrayList<Cliente> lista = new ArrayList<>();
        String consulta = "select codigo, tipo, nombre, apellido, celular, correo "
                + "from Cliente "
                + "WHERE " + columna + " LIKE '" + dato + "%'";
        //System.out.println(consulta);
        super.ejecutarRetorno(consulta);
        try {
            while (resultadoDB.next()) {
                Cliente cliente = new Cliente();
                cliente.setCodigo(resultadoDB.getString("codigo"));
                cliente.setTipo(resultadoDB.getString("tipo"));
                cliente.setNombre(resultadoDB.getString("nombre"));
                cliente.setApellido(resultadoDB.getString("apellido"));
                cliente.setCelular(resultadoDB.getString("celular"));
                cliente.setCorreo(resultadoDB.getString("correo"));
                lista.add(cliente);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return lista;
    }
    
    
    public ArrayList<Cliente> listarCliente() {
        ArrayList<Cliente> lista = new ArrayList<>();
        String consulta = "select codigo, tipo, nombre, apellido, celular, correo "
                + "from Cliente ";
        //System.out.println(consulta);
        super.ejecutarRetorno(consulta);
        try {
            while (resultadoDB.next()) {
                Cliente cliente = new Cliente();
                cliente.setCodigo(resultadoDB.getString("codigo"));
                cliente.setTipo(resultadoDB.getString("tipo"));
                cliente.setNombre(resultadoDB.getString("nombre"));
                cliente.setApellido(resultadoDB.getString("apellido"));
                cliente.setCelular(resultadoDB.getString("celular"));
                cliente.setCorreo(resultadoDB.getString("correo"));
                lista.add(cliente);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return lista;
    }
    
    public Cliente buscarUltimoRegistroCliente() {
        String consulta = "select idCliente, codigo, tipo, nombre, "
                + "apellido, celular, correo "
                + "from Cliente " 
                + "order by idCliente desc limit 1;";
        Cliente cliente = new Cliente();
        super.ejecutarRetorno(consulta);
        try {
            if (resultadoDB.next()) {

                cliente.setIdCliente(resultadoDB.getInt("idCliente"));
                cliente.setCodigo(resultadoDB.getString("codigo"));
                cliente.setTipo(resultadoDB.getString("tipo"));
                cliente.setNombre(resultadoDB.getString("nombre"));
                cliente.setApellido(resultadoDB.getString("apellido"));
                cliente.setCelular(resultadoDB.getString("celular"));
                cliente.setCorreo(resultadoDB.getString("correo"));
                
            }
        } catch (SQLException ex) {
            System.out.println("Fallo al consultar");
            return null;
        }
        return cliente;
    }
    
}
