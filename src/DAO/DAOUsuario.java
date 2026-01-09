/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conexion;
import Modelo.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ALAN
 */
public class DAOUsuario extends Conexion {

    public DAOUsuario() {
    }

    public Usuario buscarUsuario(String usuario) {
        String consulta = "select idUsuario, nombre_Usuario, Pw, tipo_Usuario, estado, "
                + "nombre, apellido "
                + "from Usuario where nombre_Usuario ='" + usuario + "'";
        Usuario login = new Usuario();
        super.ejecutarRetorno(consulta);
        try {
            if (resultadoDB.next()) {

                login.setIdUsuario(resultadoDB.getInt("idUsuario"));
                login.setNombre_Usuario(resultadoDB.getString("nombre_Usuario"));
                login.setPw(resultadoDB.getString("Pw"));
                login.setTipo_Usuario(resultadoDB.getString("tipo_Usuario"));
                login.setEstado(resultadoDB.getString("estado"));
                login.setNombre(resultadoDB.getString("nombre"));
                login.setApellido(resultadoDB.getString("apellido"));

            }
        } catch (SQLException ex) {
            System.out.println("Fallo al consultar");
            return null;
        }
        return login;
    }
    
    public boolean guardarUsuario(Usuario usuario) {
        String consulta = "INSERT INTO Usuario (nombre_Usuario,"
                + "Pw, tipo_Usuario, estado, nombre, apellido)"
                + "VALUES ('" + usuario.getNombre_Usuario() + "', '" + usuario.getPw() + "', '"
                + usuario.getTipo_Usuario() + "', '"
                + usuario.getEstado() + "', '"
                + usuario.getNombre() + "', '"
                + usuario.getApellido() + "' "
                + ");";
        return super.ejecutar(consulta);

    }

    public boolean editarUsuario(Usuario usuario) {
        String consulta = "UPDATE Usuario SET nombre_Usuario='" + usuario.getNombre_Usuario() + "', "
                + " Pw='" + usuario.getPw() + "', "
                + " tipo_Usuario='" + usuario.getTipo_Usuario() + "', "
                + " estado='" + usuario.getEstado() + "', "
                + " nombre ='" + usuario.getNombre() + "', "
                + " apellido='" + usuario.getApellido() + "' "
                + " WHERE idUsuario='" + usuario.getIdUsuario() + "'";
        return super.ejecutar(consulta);

    }

    public boolean eliminarUsuario(int id) {
        String consulta = "DELETE FROM Usuario where idUsuario = " + id + ";";
        return super.ejecutar(consulta);
    }

    public ArrayList<Usuario> listarUsuario() {
        ArrayList<Usuario> lista = new ArrayList<>();
        String consulta = "select idUsuario, nombre_Usuario, "
                + "Pw, tipo_Usuario, estado, nombre, apellido from Usuario;";

        super.ejecutarRetorno(consulta);
        try {
            while (resultadoDB.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(resultadoDB.getInt("idUsuario"));
                usuario.setNombre_Usuario(resultadoDB.getString("nombre_Usuario"));
                usuario.setPw(resultadoDB.getString("Pw"));
                usuario.setTipo_Usuario(resultadoDB.getString("tipo_Usuario"));
                usuario.setEstado(resultadoDB.getString("estado"));
                usuario.setNombre(resultadoDB.getString("nombre"));
                usuario.setApellido(resultadoDB.getString("apellido"));
                lista.add(usuario);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return lista;
    }

    public ArrayList<Usuario> filtarUsuario(String columna, String dato) {
        ArrayList<Usuario> lista = new ArrayList<>();
        String consulta = "select idUsuario, nombre_Usuario, Pw, "
                + "tipo_Usuario, estado, nombre, apellido "
                + "from Usuario "
                + "WHERE " + columna + " LIKE '" + dato + "%'";

        super.ejecutarRetorno(consulta);
        try {
            while (resultadoDB.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(resultadoDB.getInt("idUsuario"));
                usuario.setNombre_Usuario(resultadoDB.getString("nombre_Usuario"));
                usuario.setPw(resultadoDB.getString("Pw"));
                usuario.setTipo_Usuario(resultadoDB.getString("tipo_Usuario"));
                usuario.setEstado(resultadoDB.getString("estado"));
                usuario.setNombre(resultadoDB.getString("nombre"));
                usuario.setApellido(resultadoDB.getString("apellido"));
                lista.add(usuario);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return lista;
    }

}
