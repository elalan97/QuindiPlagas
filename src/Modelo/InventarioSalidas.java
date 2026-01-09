/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author USER
 */
public class InventarioSalidas {

    int idSalidas, cantidad, totalValor, inventarioFk;
    String fecha, descripcion;

    public InventarioSalidas() {
    }

    public InventarioSalidas(int idSalidas, int cantidad, int totalValor, int inventarioFk, String fecha, String descripcion) {
        this.idSalidas = idSalidas;
        this.cantidad = cantidad;
        this.totalValor = totalValor;
        this.inventarioFk = inventarioFk;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public int getIdSalidas() {
        return idSalidas;
    }

    public void setIdSalidas(int idSalidas) {
        this.idSalidas = idSalidas;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getTotalValor() {
        return totalValor;
    }

    public void setTotalValor(int totalValor) {
        this.totalValor = totalValor;
    }

    public int getInventarioFk() {
        return inventarioFk;
    }

    public void setInventarioFk(int inventarioFk) {
        this.inventarioFk = inventarioFk;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
