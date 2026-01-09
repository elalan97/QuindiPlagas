/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author USER
 */
public class DtoAgenda {
    //c = cliente, l = local, s = servicio, a = agenda

    int aIdAgenda;
    String cCodigo, cTipo, cNombre, cApellido, cCelular, cCorreo,
            lNombreNegocio, lDireccion, lNit, lEncargado, ciNombre, muNombre,
            sNroFactura, sTipoServicio, sRefuerzo, sTecnico, sFecha, sPeriocidad, sProxFecha,
            sPago, sValor, sObservacion, aHora, aConfirmacion, aObservacion, aFecha;

    public DtoAgenda() {
    }

    public DtoAgenda(int aIdAgenda, String cCodigo, String cTipo, String cNombre, String cApellido, String cCelular, String cCorreo, String lNombreNegocio, String lDireccion, String lNit, String lEncargado, String ciNombre, String muNombre, String sNroFactura, String sTipoServicio, String sRefuerzo, String sTecnico, String sFecha, String sPeriocidad, String sProxFecha, String sPago, String sValor, String sObservacion, String aHora, String aConfirmacion, String aObservacion, String aFecha) {
        this.aIdAgenda = aIdAgenda;
        this.cCodigo = cCodigo;
        this.cTipo = cTipo;
        this.cNombre = cNombre;
        this.cApellido = cApellido;
        this.cCelular = cCelular;
        this.cCorreo = cCorreo;
        this.lNombreNegocio = lNombreNegocio;
        this.lDireccion = lDireccion;
        this.lNit = lNit;
        this.lEncargado = lEncargado;
        this.ciNombre = ciNombre;
        this.muNombre = muNombre;
        this.sNroFactura = sNroFactura;
        this.sTipoServicio = sTipoServicio;
        this.sRefuerzo = sRefuerzo;
        this.sTecnico = sTecnico;
        this.sFecha = sFecha;
        this.sPeriocidad = sPeriocidad;
        this.sProxFecha = sProxFecha;
        this.sPago = sPago;
        this.sValor = sValor;
        this.sObservacion = sObservacion;
        this.aHora = aHora;
        this.aConfirmacion = aConfirmacion;
        this.aObservacion = aObservacion;
        this.aFecha = aFecha;
    }

    public int getaIdAgenda() {
        return aIdAgenda;
    }

    public void setaIdAgenda(int aIdAgenda) {
        this.aIdAgenda = aIdAgenda;
    }

    public String getcCodigo() {
        return cCodigo;
    }

    public void setcCodigo(String cCodigo) {
        this.cCodigo = cCodigo;
    }

    public String getcTipo() {
        return cTipo;
    }

    public void setcTipo(String cTipo) {
        this.cTipo = cTipo;
    }

    public String getcNombre() {
        return cNombre;
    }

    public void setcNombre(String cNombre) {
        this.cNombre = cNombre;
    }

    public String getcApellido() {
        return cApellido;
    }

    public void setcApellido(String cApellido) {
        this.cApellido = cApellido;
    }

    public String getcCelular() {
        return cCelular;
    }

    public void setcCelular(String cCelular) {
        this.cCelular = cCelular;
    }

    public String getcCorreo() {
        return cCorreo;
    }

    public void setcCorreo(String cCorreo) {
        this.cCorreo = cCorreo;
    }

    public String getlNombreNegocio() {
        return lNombreNegocio;
    }

    public void setlNombreNegocio(String lNombreNegocio) {
        this.lNombreNegocio = lNombreNegocio;
    }

    public String getlDireccion() {
        return lDireccion;
    }

    public void setlDireccion(String lDireccion) {
        this.lDireccion = lDireccion;
    }

    public String getlNit() {
        return lNit;
    }

    public void setlNit(String lNit) {
        this.lNit = lNit;
    }

    public String getlEncargado() {
        return lEncargado;
    }

    public void setlEncargado(String lEncargado) {
        this.lEncargado = lEncargado;
    }

    public String getCiNombre() {
        return ciNombre;
    }

    public void setCiNombre(String ciNombre) {
        this.ciNombre = ciNombre;
    }

    public String getMuNombre() {
        return muNombre;
    }

    public void setMuNombre(String muNombre) {
        this.muNombre = muNombre;
    }

    public String getsNroFactura() {
        return sNroFactura;
    }

    public void setsNroFactura(String sNroFactura) {
        this.sNroFactura = sNroFactura;
    }

    public String getsTipoServicio() {
        return sTipoServicio;
    }

    public void setsTipoServicio(String sTipoServicio) {
        this.sTipoServicio = sTipoServicio;
    }

    public String getsRefuerzo() {
        return sRefuerzo;
    }

    public void setsRefuerzo(String sRefuerzo) {
        this.sRefuerzo = sRefuerzo;
    }

    public String getsTecnico() {
        return sTecnico;
    }

    public void setsTecnico(String sTecnico) {
        this.sTecnico = sTecnico;
    }

    public String getsFecha() {
        return sFecha;
    }

    public void setsFecha(String sFecha) {
        this.sFecha = sFecha;
    }

    public String getsPeriocidad() {
        return sPeriocidad;
    }

    public void setsPeriocidad(String sPeriocidad) {
        this.sPeriocidad = sPeriocidad;
    }

    public String getsProxFecha() {
        return sProxFecha;
    }

    public void setsProxFecha(String sProxFecha) {
        this.sProxFecha = sProxFecha;
    }

    public String getsPago() {
        return sPago;
    }

    public void setsPago(String sPago) {
        this.sPago = sPago;
    }

    public String getsValor() {
        return sValor;
    }

    public void setsValor(String sValor) {
        this.sValor = sValor;
    }

    public String getsObservacion() {
        return sObservacion;
    }

    public void setsObservacion(String sObservacion) {
        this.sObservacion = sObservacion;
    }

    public String getaHora() {
        return aHora;
    }

    public void setaHora(String aHora) {
        this.aHora = aHora;
    }

    public String getaConfirmacion() {
        return aConfirmacion;
    }

    public void setaConfirmacion(String aConfirmacion) {
        this.aConfirmacion = aConfirmacion;
    }

    public String getaObservacion() {
        return aObservacion;
    }

    public void setaObservacion(String aObservacion) {
        this.aObservacion = aObservacion;
    }

    public String getaFecha() {
        return aFecha;
    }

    public void setaFecha(String aFecha) {
        this.aFecha = aFecha;
    }

}
