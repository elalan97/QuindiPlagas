/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ALAN
 */
public class Usuario {

    int idUsuario;
    String nombre_Usuario, Pw, tipo_Usuario, estado, nombre, apellido;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nombre_Usuario, String Pw, String tipo_Usuario, String estado, String nombre, String apellido) {
        this.idUsuario = idUsuario;
        this.nombre_Usuario = nombre_Usuario;
        this.Pw = Pw;
        this.tipo_Usuario = tipo_Usuario;
        this.estado = estado;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre_Usuario() {
        return nombre_Usuario;
    }

    public void setNombre_Usuario(String nombre_Usuario) {
        this.nombre_Usuario = nombre_Usuario;
    }

    public String getPw() {
        return Pw;
    }

    public void setPw(String Pw) {
        this.Pw = Pw;
    }

    public String getTipo_Usuario() {
        return tipo_Usuario;
    }

    public void setTipo_Usuario(String tipo_Usuario) {
        this.tipo_Usuario = tipo_Usuario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    
    
}
