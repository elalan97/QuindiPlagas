/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ALAN
 */
public class Servicio {

    int idServicio, localFk, valor;
    String nroFactura, tipoServicio, refuerzo, tecnico, fecha, periocidad,
            proxFecha, pago, vendedor, observacion;

    public Servicio() {
    }

    public Servicio(int idServicio, int localFk, int valor, String nroFactura, String tipoServicio, String refuerzo, String tecnico, String fecha, String periocidad, String proxFecha, String pago, String vendedor, String observacion) {
        this.idServicio = idServicio;
        this.localFk = localFk;
        this.valor = valor;
        this.nroFactura = nroFactura;
        this.tipoServicio = tipoServicio;
        this.refuerzo = refuerzo;
        this.tecnico = tecnico;
        this.fecha = fecha;
        this.periocidad = periocidad;
        this.proxFecha = proxFecha;
        this.pago = pago;
        this.vendedor = vendedor;
        this.observacion = observacion;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public int getLocalFk() {
        return localFk;
    }

    public void setLocalFk(int localFk) {
        this.localFk = localFk;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getNroFactura() {
        return nroFactura;
    }

    public void setNroFactura(String nroFactura) {
        this.nroFactura = nroFactura;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getRefuerzo() {
        return refuerzo;
    }

    public void setRefuerzo(String refuerzo) {
        this.refuerzo = refuerzo;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPeriocidad() {
        return periocidad;
    }

    public void setPeriocidad(String periocidad) {
        this.periocidad = periocidad;
    }

    public String getProxFecha() {
        return proxFecha;
    }

    public void setProxFecha(String proxFecha) {
        this.proxFecha = proxFecha;
    }

    public String getPago() {
        return pago;
    }

    public void setPago(String pago) {
        this.pago = pago;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

}
