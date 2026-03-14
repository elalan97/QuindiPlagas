/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import BO.BoReportes;
import DTO.DtoServicio;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class CtlReportes {

    BoReportes boReportes;

    public CtlReportes() {

        boReportes = new BoReportes();

    }

    public ArrayList<DtoServicio> listarServiciosPorFiltroVendedor(String dato, String vendedor) {
        return boReportes.listarServiciosPorFiltroVendedor(dato, vendedor);
    }

}
