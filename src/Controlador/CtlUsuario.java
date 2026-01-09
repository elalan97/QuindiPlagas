/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import BO.BOUsuario;
import Modelo.Usuario;
import java.util.ArrayList;

/**
 *
 * @author ALAN
 */
public class CtlUsuario {

    BOUsuario BOUsuario;

    public CtlUsuario() {

        BOUsuario = new BOUsuario();
    }

    public void iniciarSesion(String usuario, String pw) {

        BOUsuario.iniciarSesion(usuario, pw);

    }

    public Usuario tipoUsuario(String usuario) {

        return BOUsuario.tipoUsuario(usuario);

    }

    public ArrayList<Usuario> listarUsuario() {

        return BOUsuario.listarUsuario();
    }

    public void guardarUsuario(Usuario usuario) {

        BOUsuario.guardarUsuario(usuario);

    }

    public Usuario buscarUsuario(String nombreUsuario) {

        return BOUsuario.buscarUsuario(nombreUsuario);
    }

    public void editarUsuario(Usuario usuario) {

        BOUsuario.editarUsuario(usuario);

    }

    public void eliminarUsuario(String nombreUsuario) {

        BOUsuario.eliminarUsuario(nombreUsuario);
    }

    public ArrayList<Usuario> filtarUsuario(String columna, String dato) {

        return BOUsuario.filtarUsuario(columna, dato);

    }

}
