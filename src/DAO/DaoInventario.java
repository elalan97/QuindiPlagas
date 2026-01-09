/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conexion;
import DTO.DtoInventarioEntradas;
import DTO.DtoInventarioSalidas;
import Modelo.Inventario;
import Modelo.InventarioEntradas;
import Modelo.InventarioSalidas;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class DaoInventario extends Conexion {

    public DaoInventario() {
    }

    public boolean guardarInventario(Inventario inverntario) {
        String consulta = "INSERT INTO Inventario (nombreProducto, nroLote, "
                + "fechaVencimiento, cantidad, valor)"
                + "VALUES ('" + inverntario.getNombreProducto() + "', '" + inverntario.getNroLote() + "', '"
                + inverntario.getFechaVencimiento() + "', '" + inverntario.getCantidad() + "', '"
                + inverntario.getValor() + "' "
                + ");";
        return super.ejecutar(consulta);

    }

    public Inventario buscarInventario(String nroLote) {
        String consulta = "select idInventario, nombreProducto, nroLote, "
                + "fechaVencimiento, cantidad, valor "
                + "from Inventario where nroLote ='" + nroLote + "';";
        Inventario inverntario = new Inventario();
        super.ejecutarRetorno(consulta);
        try {
            if (resultadoDB.next()) {

                inverntario.setIdInventario(resultadoDB.getInt("idInventario"));
                inverntario.setNombreProducto(resultadoDB.getString("nombreProducto"));
                inverntario.setNroLote(resultadoDB.getString("nroLote"));
                inverntario.setFechaVencimiento(resultadoDB.getString("fechaVencimiento"));
                inverntario.setCantidad(resultadoDB.getInt("cantidad"));
                inverntario.setValor(resultadoDB.getInt("valor"));

            }
        } catch (SQLException ex) {
            System.out.println("Fallo al consultar");
            return null;
        }
        return inverntario;
    }

    public boolean editarInventario(Inventario inverntario) {
        String consulta = "UPDATE Inventario SET nombreProducto='" + inverntario.getNombreProducto() + "', "
                + " nroLote='" + inverntario.getNroLote() + "', "
                + " fechaVencimiento='" + inverntario.getFechaVencimiento() + "', "
                + " cantidad='" + inverntario.getCantidad() + "', "
                + " valor='" + inverntario.getValor() + "' "
                + " WHERE idInventario='" + inverntario.getIdInventario() + "'";
        return super.ejecutar(consulta);

    }

    public boolean eliminarInventario(int id) {
        String consulta = "DELETE FROM Inventario where idInventario = " + id + ";";
        return super.ejecutar(consulta);
    }

    public boolean guardarInventarioEntradas(InventarioEntradas entradas) {
        String consulta = "INSERT INTO InventarioEntradas (descripcion, fecha, cantidad, "
                + "totalValor, inventarioFk)"
                + "VALUES ('" + entradas.getDescripcion() + "', '" + entradas.getFecha() + "', '"
                + entradas.getCantidad() + "', '" + entradas.getTotalValor() + "', '"
                + entradas.getInventarioFk() + "' "
                + ");";
        return super.ejecutar(consulta);

    }

    public boolean guardarInventarioSalidas(InventarioSalidas entradas) {
        String consulta = "INSERT INTO InventarioSalidas (fecha, descripcion, cantidad, "
                + "totalValor, inventarioFk)"
                + "VALUES ('" + entradas.getFecha() + "', '" + entradas.getDescripcion() + "', '"
                + entradas.getCantidad() + "', '" + entradas.getTotalValor() + "', '"
                + entradas.getInventarioFk() + "' "
                + ");";
        return super.ejecutar(consulta);

    }

    public ArrayList<Inventario> listaInventario() {
        ArrayList<Inventario> lista = new ArrayList<>();
        String consulta = "select nroLote, nombreProducto, fechaVencimiento, cantidad, valor "
                + "from Inventario;";
        //System.out.println(consulta);
        super.ejecutarRetorno(consulta);
        try {
            while (resultadoDB.next()) {
                Inventario inventario = new Inventario();
                inventario.setNroLote(resultadoDB.getString("nroLote"));
                inventario.setNombreProducto(resultadoDB.getString("nombreProducto"));
                inventario.setFechaVencimiento(resultadoDB.getString("fechaVencimiento"));
                inventario.setCantidad(resultadoDB.getInt("cantidad"));
                inventario.setValor(resultadoDB.getInt("valor"));
                lista.add(inventario);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return lista;

    }

    public ArrayList<DtoInventarioEntradas> listaInventarioEntradas() {
        ArrayList<DtoInventarioEntradas> lista = new ArrayList<>();
        String consulta = "select i.nroLote, i.nombreProducto, i.fechaVencimiento, ie.descripcion, "
                + "ie.fecha, ie.cantidad, ie.totalValor "
                + "from InventarioEntradas ie "
                + "join Inventario i on ie.inventarioFk = i.idInventario;";
        //System.out.println(consulta);
        super.ejecutarRetorno(consulta);
        try {
            while (resultadoDB.next()) {
                DtoInventarioEntradas entradas = new DtoInventarioEntradas();
                entradas.setNroLote(resultadoDB.getString("i.nroLote"));
                entradas.setNombreProducto(resultadoDB.getString("i.nombreProducto"));
                entradas.setFechaVencimiento(resultadoDB.getString("i.fechaVencimiento"));
                entradas.setDescripcion(resultadoDB.getString("ie.descripcion"));
                entradas.setFecha(resultadoDB.getString("ie.fecha"));
                entradas.setCantidad(resultadoDB.getInt("ie.cantidad"));
                entradas.setTotalValor(resultadoDB.getInt("ie.totalValor"));
                lista.add(entradas);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return lista;
    }

    public ArrayList<DtoInventarioSalidas> listaInventarioSalidas() {
        ArrayList<DtoInventarioSalidas> lista = new ArrayList<>();
        String consulta = "select i.nroLote, i.nombreProducto, i.fechaVencimiento, isa.descripcion, "
                + "isa.fecha, isa.cantidad, isa.totalValor "
                + "from InventarioSalidas isa "
                + "join Inventario i on isa.inventarioFk = i.idInventario;";
        //System.out.println(consulta);
        super.ejecutarRetorno(consulta);
        try {
            while (resultadoDB.next()) {
                DtoInventarioSalidas salidas = new DtoInventarioSalidas();
                salidas.setNroLote(resultadoDB.getString("i.nroLote"));
                salidas.setNombreProducto(resultadoDB.getString("i.nombreProducto"));
                salidas.setFechaVencimiento(resultadoDB.getString("i.fechaVencimiento"));
                salidas.setDescripcion(resultadoDB.getString("isa.descripcion"));
                salidas.setFecha(resultadoDB.getString("isa.fecha"));
                salidas.setCantidad(resultadoDB.getInt("isa.cantidad"));
                salidas.setTotalValor(resultadoDB.getInt("isa.totalValor"));
                lista.add(salidas);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return lista;
    }

    public ArrayList<Inventario> listaInventarioFiltro(String columna, String dato) {
        ArrayList<Inventario> lista = new ArrayList<>();
        String consulta = "select nroLote, nombreProducto, fechaVencimiento, cantidad, valor "
                + "from Inventario "
                + "where " + columna + " = '" + dato +"';";
        //System.out.println(consulta);
        super.ejecutarRetorno(consulta);
        try {
            while (resultadoDB.next()) {
                Inventario inventario = new Inventario();
                inventario.setNroLote(resultadoDB.getString("nroLote"));
                inventario.setNombreProducto(resultadoDB.getString("nombreProducto"));
                inventario.setFechaVencimiento(resultadoDB.getString("fechaVencimiento"));
                inventario.setCantidad(resultadoDB.getInt("cantidad"));
                inventario.setValor(resultadoDB.getInt("valor"));
                lista.add(inventario);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return lista;

    }
    
    public ArrayList<DtoInventarioEntradas> listaInventarioEntradasFiltro(String columna, String dato) {
        ArrayList<DtoInventarioEntradas> lista = new ArrayList<>();
        String consulta = "select i.nroLote, i.nombreProducto, i.fechaVencimiento, ie.descripcion, "
                + "ie.fecha, ie.cantidad, ie.totalValor "
                + "from InventarioEntradas ie "
                + "join Inventario i on ie.inventarioFk = i.idInventario "
                + "where " + columna + " LIKE '" + dato + "%';";
        //System.out.println(consulta);
        super.ejecutarRetorno(consulta);
        try {
            while (resultadoDB.next()) {
                DtoInventarioEntradas entradas = new DtoInventarioEntradas();
                entradas.setNroLote(resultadoDB.getString("i.nroLote"));
                entradas.setNombreProducto(resultadoDB.getString("i.nombreProducto"));
                entradas.setFechaVencimiento(resultadoDB.getString("i.fechaVencimiento"));
                entradas.setDescripcion(resultadoDB.getString("ie.descripcion"));
                entradas.setFecha(resultadoDB.getString("ie.fecha"));
                entradas.setCantidad(resultadoDB.getInt("ie.cantidad"));
                entradas.setTotalValor(resultadoDB.getInt("ie.totalValor"));
                lista.add(entradas);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return lista;
    }
    
    public ArrayList<DtoInventarioSalidas> listaInventarioSalidasFiltro(String columna, String dato) {
        ArrayList<DtoInventarioSalidas> lista = new ArrayList<>();
        String consulta = "select i.nroLote, i.nombreProducto, i.fechaVencimiento, isa.descripcion, "
                + "isa.fecha, isa.cantidad, isa.totalValor "
                + "from InventarioSalidas isa "
                + "join Inventario i on isa.inventarioFk = i.idInventario "
                + "where " + columna + " LIKE '" + dato + "%';";
        //System.out.println(consulta);
        super.ejecutarRetorno(consulta);
        try {
            while (resultadoDB.next()) {
                DtoInventarioSalidas salidas = new DtoInventarioSalidas();
                salidas.setNroLote(resultadoDB.getString("i.nroLote"));
                salidas.setNombreProducto(resultadoDB.getString("i.nombreProducto"));
                salidas.setFechaVencimiento(resultadoDB.getString("i.fechaVencimiento"));
                salidas.setDescripcion(resultadoDB.getString("isa.descripcion"));
                salidas.setFecha(resultadoDB.getString("isa.fecha"));
                salidas.setCantidad(resultadoDB.getInt("isa.cantidad"));
                salidas.setTotalValor(resultadoDB.getInt("isa.totalValor"));
                lista.add(salidas);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return lista;
    }
}
