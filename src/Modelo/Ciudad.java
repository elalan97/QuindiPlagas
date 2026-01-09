/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ALAN
 */
public class Ciudad {

    int idCiudad, municipioFk;
    String nombre;

    public Ciudad() {
    }

    public Ciudad(int idCiudad, int municipioFk, String nombre) {
        this.idCiudad = idCiudad;
        this.municipioFk = municipioFk;
        this.nombre = nombre;
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public int getMunicipioFk() {
        return municipioFk;
    }

    public void setMunicipioFk(int municipioFk) {
        this.municipioFk = municipioFk;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    

}
