/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DAO.DAOUsuario;
import Exepciones.NoExisteUsuario;
import Exepciones.YaExisteUsuario;
import Modelo.Usuario;
import Vista.Menu;
import java.util.ArrayList;

/**
 *
 * @author ALAN
 */
public class BOUsuario {

    DAOUsuario daoUsuario;

    public BOUsuario() {

        daoUsuario = new DAOUsuario();

    }

    public void iniciarSesion(String usuario, String pw) {

        Usuario u = daoUsuario.buscarUsuario(usuario);

        if (usuario.equals(u.getNombre_Usuario()) && pw.equals(u.getPw())
                && u.getEstado().equals("Activo")) {

            Menu event = new Menu();
            event.setVisible(true);

        } else {

            throw new NoExisteUsuario();

        }

    }

    public Usuario tipoUsuario(String usuario) {

        Usuario u = daoUsuario.buscarUsuario(usuario);

        if (u.getNombre_Usuario() == null) {

            throw new NoExisteUsuario();

        } else {

            return u;
        }

    }

    public ArrayList<Usuario> listarUsuario() {

        return daoUsuario.listarUsuario();
    }

    public void guardarUsuario(Usuario usuario) {

        Usuario u = daoUsuario.buscarUsuario(usuario.getNombre_Usuario());

        if (u.getNombre_Usuario() == null) {

            daoUsuario.guardarUsuario(usuario);

        } else {

            throw new YaExisteUsuario();

        }

    }

    public Usuario buscarUsuario(String nombreUsuario) {

        Usuario usuario = daoUsuario.buscarUsuario(nombreUsuario);

        if (usuario.getNombre_Usuario() == null) {

            throw new NoExisteUsuario();

        } else {
            return usuario;
        }

    }

    public void editarUsuario(Usuario usuario) {
        
        Usuario u = daoUsuario.buscarUsuario(usuario.getNombre_Usuario());
        
        if (u.getNombre_Usuario() == null) {
            
            throw new NoExisteUsuario();
            
        }else{
            
            usuario.setIdUsuario(u.getIdUsuario());
            daoUsuario.editarUsuario(usuario);
            
        }

    }
    
    public void eliminarUsuario(String nombreUsuario){
        
        Usuario u = daoUsuario.buscarUsuario(nombreUsuario);
        
        if (u.getNombre_Usuario() == null) {
            
            throw new NoExisteUsuario();
            
        }else{
            
            daoUsuario.eliminarUsuario(u.getIdUsuario());
            
        }
        
    }
    
    public ArrayList<Usuario> filtarUsuario(String columna, String dato){
        
        return daoUsuario.filtarUsuario(columna, dato);
        
    }

}
