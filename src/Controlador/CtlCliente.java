/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import BO.BoCliente;
import Modelo.Cliente;
import java.util.ArrayList;

/**
 *
 * @author ALAN
 */
public class CtlCliente {

    BoCliente boCliente;

    public CtlCliente() {

        boCliente = new BoCliente();

    }

    public void guardarCliente(Cliente cliente) {

        boCliente.guardarCliente(cliente);
    }

    public ArrayList<Cliente> listarClientePorFiltro(String columna, String dato) {

        return boCliente.listarClientePorFiltro(columna, dato);
    }

    public ArrayList<Cliente> listarCliente() {

        return boCliente.listarCliente();

    }

    public void editarCliente(Cliente cliente) {

        boCliente.editarCliente(cliente);
    }

    public void eliminarCliente(String codigo) {

        boCliente.eliminarCliente(codigo);
    }

    public Cliente buscarCliente(String codigo) {

        return boCliente.buscarCliente(codigo);

    }

    public ArrayList<Cliente> llenarLista(String columna, String dato) {
        return boCliente.llenarLista(columna, dato);
    }

    public Cliente buscarUltimoRegistroCliente() {
        return boCliente.buscarUltimoRegistroCliente();
    }

}
