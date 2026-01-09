/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DAO.DaoCliente;
import Exepciones.NoExisteCliente;
import Exepciones.YaExisteCliente;
import Modelo.Cliente;
import java.util.ArrayList;

/**
 *
 * @author ALAN
 */
public class BoCliente {

    DaoCliente daoCliente;

    public BoCliente() {

        daoCliente = new DaoCliente();

    }

    public void guardarCliente(Cliente cliente) {

        Cliente c = daoCliente.buscarCliente(cliente.getCodigo());

        if (c.getCodigo() == null) {

            daoCliente.guardarCliente(cliente);

        } else {

            throw new YaExisteCliente();

        }

    }

    public ArrayList<Cliente> listarClientePorFiltro(String columna, String dato) {

        return daoCliente.listarClientePorFiltro(columna, dato);

    }

    public void editarCliente(Cliente cliente) {

        Cliente c = daoCliente.buscarCliente(cliente.getCodigo());

        if (c.getCodigo() == null) {

            throw new NoExisteCliente();

        } else {

            cliente.setIdCliente(c.getIdCliente());
            daoCliente.editarCliente(cliente);

        }

    }

    public void eliminarCliente(String codigo) {

        Cliente c = daoCliente.buscarCliente(codigo);

        if (c.getCodigo() == null) {

            throw new NoExisteCliente();

        } else {

            daoCliente.eliminarCliente(c.getIdCliente());

        }

    }

    public Cliente buscarCliente(String codigo) {

        Cliente cliente = daoCliente.buscarCliente(codigo);

        if (cliente.getCodigo() == null) {

            throw new NoExisteCliente();

        } else {

            return cliente;

        }

    }

    public ArrayList<Cliente> listarCliente() {

        return daoCliente.listarCliente();

    }

    public Cliente buscarUltimoRegistroCliente() {

        Cliente cliente = daoCliente.buscarUltimoRegistroCliente();

        if (cliente.getCodigo() == null) {

            throw new NoExisteCliente();

        } else {

            return cliente;

        }

    }

    public ArrayList<Cliente> llenarLista(String columna, String dato) {

        switch (columna) {
            case "Codigo":

                return daoCliente.listarClientePorFiltro("codigo", dato);

            case "Tipo":

                return daoCliente.listarClientePorFiltro("tipo", dato);

            case "Nombre":

                return daoCliente.listarClientePorFiltro("nombre", dato);

            case "Apellido":

                return daoCliente.listarClientePorFiltro("apellido", dato);

            case "Celular":

                return daoCliente.listarClientePorFiltro("celular", dato);

            case "Correo":

                return daoCliente.listarClientePorFiltro("correo", dato);

        }

        return null;

    }

}
