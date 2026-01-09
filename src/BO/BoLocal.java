/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DAO.DaoCliente;
import DAO.DaoLocal;
import DTO.DTOLocal;
import DTO.DtoClienteLocal;
import Exepciones.NoExisteLocal;
import Exepciones.YaExisteLocal;
import Modelo.Ciudad;
import Modelo.Cliente;
import Modelo.Local;
import Modelo.Municipio;
import java.util.ArrayList;

/**
 *
 * @author ALAN
 */
public class BoLocal {

    DaoLocal daoLocal;
    DaoCliente daoCliente;

    public BoLocal() {

        daoLocal = new DaoLocal();
        daoCliente = new DaoCliente();

    }

    public ArrayList<Municipio> cargarMunicipio() {

        return daoLocal.cargarMunicipio();

    }

    public ArrayList<Ciudad> cargarCiudad(String nombre) {
        return daoLocal.cargarCiudad(nombre);
    }

    public ArrayList<DTOLocal> listarLocalPorCliente(String codigo) {
        return daoLocal.listarLocalPorCliente(codigo);
    }

    public void guardarLocal(Local local, String ciudad, String codigo) {

        DTOLocal dtoLocal = daoLocal.buscarLocal(local.getDireccion(), ciudad);

        if (dtoLocal.getDireccion() == null) {

            Cliente cliente = daoCliente.buscarCliente(codigo);
            local.setClienteFk(cliente.getIdCliente());

            Ciudad ciudad1 = daoLocal.buscarCiudad(ciudad);
            local.setCiudadFk(ciudad1.getIdCiudad());

            daoLocal.guardarLocal(local);

        } else {

            throw new YaExisteLocal();

        }

    }

    public void editarLocal(Local local, String ciudad, String codigo, String ciudadEditar, String direcionActual) {

        Ciudad c = daoLocal.buscarCiudad(ciudadEditar);
        Local l = daoLocal.buscarLocal(direcionActual, c.getIdCiudad());
        Cliente cliente = daoCliente.buscarCliente(codigo);

        if (l.getDireccion() == null || cliente.getCodigo() == null) {

            throw new NoExisteLocal();

        } else {

            Ciudad c1 = daoLocal.buscarCiudad(ciudad);

            local.setIdLocales(l.getIdLocales());
            local.setCiudadFk(c1.getIdCiudad());
            local.setClienteFk(cliente.getIdCliente());

            daoLocal.editarLocal(local);

        }
    }

    public void eliminarLocal(String direccion, String ciudad) {

        DTOLocal dtoLocal = daoLocal.buscarLocal(direccion, ciudad);

        if (dtoLocal.getDireccion() == null) {

            throw new NoExisteLocal();

        } else {

            daoLocal.eliminarLoca(dtoLocal.getIdLocal());

        }

    }

    public ArrayList<DtoClienteLocal> listaClienteLocal() {
        return daoLocal.listaClienteLocal();
    }

    public ArrayList<DtoClienteLocal> listaClienteLocalporFiltro(String columna, String dato) {

        switch (columna) {
            case "Codigo":

                return daoLocal.listaClienteLocalporFiltro("c.codigo", dato);

            case "Tipo":

                return daoLocal.listaClienteLocalporFiltro("c.tipo", dato);

            case "Nombre":

                return daoLocal.listaClienteLocalporFiltro("c.nombre", dato);

            case "Apellido":

                return daoLocal.listaClienteLocalporFiltro("c.apellido", dato);

            case "Nombre de Negocio":

                return daoLocal.listaClienteLocalporFiltro("l.nombreNegocio", dato);

            case "Direccion":

                return daoLocal.listaClienteLocalporFiltro("l.direccion", dato);

            case "Nit":

                return daoLocal.listaClienteLocalporFiltro("l.nit", dato);

            case "Encargado":

                return daoLocal.listaClienteLocalporFiltro("l.encargado", dato);

            case "Departamento":

                return daoLocal.listaClienteLocalporFiltro("mu.nombre", dato);

            case "Ciudad":

                return daoLocal.listaClienteLocalporFiltro("ci.nombre", dato);

        }

        return null;

    }
}
