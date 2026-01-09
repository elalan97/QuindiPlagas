/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DAO.DaoCliente;
import DAO.DaoLocal;
import DAO.DaoProspectoCliente;
import DTO.DtoProspectoCliente;
import Exepciones.NoExisteCliente;
import Exepciones.YaExisteCliente;
import Modelo.Ciudad;
import Modelo.Cliente;
import Modelo.ProspectoCliente;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class BoProspectoCliente {

    DaoProspectoCliente daoProspectoCliente;
    DaoLocal daoLocal;

    public BoProspectoCliente() {

        daoProspectoCliente = new DaoProspectoCliente();
        daoLocal = new DaoLocal();

    }

    public void guardarProspectoCliente(ProspectoCliente prospectoCliente, String ciudad) {

        ProspectoCliente pc = daoProspectoCliente.verificarProspectoCliente(prospectoCliente.getNombreNegocio());

        if (pc.getNombreNegocio() == null) {

            Ciudad ciudad1 = daoLocal.buscarCiudad(ciudad);

            prospectoCliente.setCiudadFk(ciudad1.getIdCiudad());
            daoProspectoCliente.guardarProspectoCliente(prospectoCliente);

        } else {

            throw new YaExisteCliente();

        }

    }

    public DtoProspectoCliente buscarProspectoCliente(String direccion) {

        DtoProspectoCliente cliente = daoProspectoCliente.buscarProspectoCliente1(direccion);

        if (cliente.getDireccion() == null) {

            throw new NoExisteCliente();

        } else {

            return cliente;

        }

    }

    public void editarProspectoCliente(ProspectoCliente prospectoCliente, String ciudad, String direccion) {

        ProspectoCliente pc = daoProspectoCliente.buscarProspectoCliente(direccion);
        Ciudad c = daoLocal.buscarCiudad(ciudad);

        if (pc.getDireccion() == null || c.getNombre() == null) {

            throw new NoExisteCliente();

        } else {

            
            prospectoCliente.setIdProspecto(pc.getIdProspecto());
            prospectoCliente.setCiudadFk(c.getIdCiudad());
            daoProspectoCliente.editarProspectoCliente(prospectoCliente);

        }

    }

    public void eliminarProspectoCliente(String direccion) {

        ProspectoCliente cliente = daoProspectoCliente.buscarProspectoCliente(direccion);

        if (cliente.getDireccion() == null) {

            throw new NoExisteCliente();

        } else {

            daoProspectoCliente.eliminarProspectoCliente(cliente.getIdProspecto());

        }

    }

    public ArrayList<DtoProspectoCliente> listarProspectoCliente() {
        return daoProspectoCliente.listarProspectoCliente();
    }
    
    public ArrayList<DtoProspectoCliente> listaProspectoCliente(String fecha) {
        return daoProspectoCliente.listaProspectoCliente(fecha);
    }

    public ArrayList<DtoProspectoCliente> listarPorFiltro(String columna, String dato) {

        switch (columna) {
            case "Estado":

                return daoProspectoCliente.listarPorFiltro("pc.estado", dato);

            case "Fecha":

                return daoProspectoCliente.listarPorFiltro("pc.fecha", dato);

            case "Tipo":

                return daoProspectoCliente.listarPorFiltro("pc.tipo", dato);

            case "Nombre":

                return daoProspectoCliente.listarPorFiltro("pc.nombre", dato);

            case "Apellido":

                return daoProspectoCliente.listarPorFiltro("pc.apellido", dato);

            case "Nombre del Negocio":

                return daoProspectoCliente.listarPorFiltro("pc.nombreNegocio", dato);

            case "Direccion":

                return daoProspectoCliente.listarPorFiltro("pc.direccion", dato);

            case "Nit":

                return daoProspectoCliente.listarPorFiltro("pc.nit", dato);

            case "Correo":

                return daoProspectoCliente.listarPorFiltro("pc.correo", dato);

        }

        return null;
    }

}
