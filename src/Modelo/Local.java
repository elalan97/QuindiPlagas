/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ALAN
 */
public class Local {

    int idLocales, ciudadFk, clienteFk;
    String nombreNegocio, direccion, nit, encargado;

    public Local() {
    }

    public Local(int idLocales, int ciudadFk, int clienteFk, String nombreNegocio, String direccion, String nit, String encargado) {
        this.idLocales = idLocales;
        this.ciudadFk = ciudadFk;
        this.clienteFk = clienteFk;
        this.nombreNegocio = nombreNegocio;
        this.direccion = direccion;
        this.nit = nit;
        this.encargado = encargado;
    }

    public int getIdLocales() {
        return idLocales;
    }

    public void setIdLocales(int idLocales) {
        this.idLocales = idLocales;
    }

    public int getCiudadFk() {
        return ciudadFk;
    }

    public void setCiudadFk(int ciudadFk) {
        this.ciudadFk = ciudadFk;
    }

    public int getClienteFk() {
        return clienteFk;
    }

    public void setClienteFk(int clienteFk) {
        this.clienteFk = clienteFk;
    }

    public String getNombreNegocio() {
        return nombreNegocio;
    }

    public void setNombreNegocio(String nombreNegocio) {
        this.nombreNegocio = nombreNegocio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

}
