/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DAO.DaoServicios;
import DTO.DtoServicio;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class BoReportes {
    
    DaoServicios daoServicios;

    public BoReportes() {
        
        daoServicios = new DaoServicios();
        
    }
    
    public ArrayList<DtoServicio> listarServiciosPorFiltroVendedor(String dato, String vendedor) {
        return daoServicios.listarServiciosPorFiltroVendedor(dato, vendedor);
    }  
    
}
