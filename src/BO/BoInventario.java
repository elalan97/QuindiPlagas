/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DAO.DaoInventario;
import DAO.DaoReportesJasper;
import DTO.DtoInventarioEntradas;
import DTO.DtoInventarioSalidas;
import Exepciones.NoExisteProducto;
import Exepciones.YaExisteProducto;
import Modelo.Inventario;
import Modelo.InventarioEntradas;
import Modelo.InventarioSalidas;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author USER
 */
public class BoInventario {

    DaoInventario daoInventario;
    DaoReportesJasper daoReportesJasper;

    public BoInventario() {

        daoInventario = new DaoInventario();
        daoReportesJasper = new DaoReportesJasper();

    }

    public void guardarInventario(Inventario inventario) throws ParseException {

        int valorTotal;
        String hoy1;
        Inventario i = daoInventario.buscarInventario(inventario.getNroLote());

        if (i.getNroLote() == null) {

            daoInventario.guardarInventario(inventario);

            Inventario i1 = daoInventario.buscarInventario(inventario.getNroLote());

            valorTotal = i1.getCantidad() * i1.getValor();

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            LocalDate hoy = LocalDate.now();
            hoy1 = hoy + "";

            InventarioEntradas entradas = new InventarioEntradas(0, i1.getCantidad(),
                    valorTotal, i1.getIdInventario(), hoy1, "Nuevo Producto");
            daoInventario.guardarInventarioEntradas(entradas);

        } else {

            throw new YaExisteProducto();

        }
    }

    public Inventario buscarInventario(String nroLote) {

        Inventario i = daoInventario.buscarInventario(nroLote);

        if (i.getNroLote() == null) {

            throw new NoExisteProducto();

        } else {
            return i;
        }

    }

    public void editarInventario(Inventario inventario) {

        Inventario i = daoInventario.buscarInventario(inventario.getNroLote());

        if (i.getNroLote() == null) {

            throw new NoExisteProducto();

        } else {

            inventario.setIdInventario(i.getIdInventario());
            daoInventario.editarInventario(inventario);

        }

    }

    public void eliminarInventario(String nrLote) {

        Inventario i = daoInventario.buscarInventario(nrLote);

        if (i.getNroLote() == null) {

            throw new NoExisteProducto();

        } else {

            daoInventario.eliminarInventario(i.getIdInventario());

        }

    }

    public void agregarStock(Inventario inventario, int cantidad, String descripcion) {

        String hoy1;
        int cantidadEntrada = cantidad, total, cantidadsum = 0;
        Inventario i = daoInventario.buscarInventario(inventario.getNroLote());

        if (i.getNroLote() == null) {

            throw new NoExisteProducto();

        } else {

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            LocalDate hoy = LocalDate.now();
            hoy1 = hoy + "";

            cantidadsum = i.getCantidad() + cantidad;
            inventario.setCantidad(cantidadsum);
            inventario.setIdInventario(i.getIdInventario());
            daoInventario.editarInventario(inventario);

            total = i.getValor() * cantidadEntrada;
            InventarioEntradas entradas = new InventarioEntradas(0, cantidadEntrada,
                    total, i.getIdInventario(), hoy1, descripcion);
            daoInventario.guardarInventarioEntradas(entradas);

        }

    }

    public void eliminarStock(Inventario inventario, int cantidad, String descripcion) {

        String hoy1;
        int cantidadSalida = cantidad, total, cantidadsum = 0;

        Inventario i = daoInventario.buscarInventario(inventario.getNroLote());

        if (i.getNroLote() == null) {

            throw new NoExisteProducto();

        } else {

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            LocalDate hoy = LocalDate.now();
            hoy1 = hoy + "";

            cantidadsum = i.getCantidad() - cantidad;
            inventario.setCantidad(cantidadsum);
            inventario.setIdInventario(i.getIdInventario());
            daoInventario.editarInventario(inventario);

            total = i.getValor() * cantidadSalida;
            InventarioSalidas salidas = new InventarioSalidas(0, cantidadSalida,
                    total, i.getIdInventario(), hoy1, descripcion);
            daoInventario.guardarInventarioSalidas(salidas);

        }

    }

    public ArrayList<Inventario> listaInventario() {
        return daoInventario.listaInventario();
    }

    public ArrayList<DtoInventarioEntradas> listaInventarioEntradas() {
        return daoInventario.listaInventarioEntradas();
    }

    public ArrayList<DtoInventarioSalidas> listaInventarioSalidas() {
        return daoInventario.listaInventarioSalidas();
    }

    public ArrayList<Inventario> listaInventarioFiltro(String columna, String dato) {

        switch (columna) {
            case "Nro de Lote":

                return daoInventario.listaInventarioFiltro("nroLote", dato);

            case "Nombre del Producto":

                return daoInventario.listaInventarioFiltro("nombreProducto", dato);

            case "Fecha Vencimiento":

                return daoInventario.listaInventarioFiltro("fechaVencimiento", dato);

            case "Cantidad":

                return daoInventario.listaInventarioFiltro("cantidad", dato);

            case "Valor":

                return daoInventario.listaInventarioFiltro("valor", dato);

        }

        return null;
    }

    public ArrayList<DtoInventarioEntradas> listaInventarioEntardaFiltro(String columna, String dato) {

        switch (columna) {
            case "Nro de Lote":

                return daoInventario.listaInventarioEntradasFiltro("i.nroLote", dato);

            case "Nombre del Producto":

                return daoInventario.listaInventarioEntradasFiltro("i.nombreProducto", dato);

            case "Fecha de Vencimiento":

                return daoInventario.listaInventarioEntradasFiltro("i.fechaVencimiento", dato);

            case "Descripcion":

                return daoInventario.listaInventarioEntradasFiltro("ie.descripcion", dato);

            case "Fecha":

                return daoInventario.listaInventarioEntradasFiltro("ie.fecha", dato);

            case "Cantidad":

                return daoInventario.listaInventarioEntradasFiltro("ie.cantidad", dato);

            case "Total Valor":

                return daoInventario.listaInventarioEntradasFiltro("ie.totalValor", dato);

        }

        return null;
    }

    public ArrayList<DtoInventarioSalidas> listaInventarioSalidasFiltro(String columna, String dato) {

        switch (columna) {
            case "Nro de Lote":

                return daoInventario.listaInventarioSalidasFiltro("i.nroLote", dato);

            case "Nombre del Producto":

                return daoInventario.listaInventarioSalidasFiltro("i.nombreProducto", dato);

            case "Fecha de Vencimiento":

                return daoInventario.listaInventarioSalidasFiltro("i.fechaVencimiento", dato);

            case "Descripcion":

                return daoInventario.listaInventarioSalidasFiltro("isa.descripcion", dato);

            case "Fecha":

                return daoInventario.listaInventarioSalidasFiltro("isa.fecha", dato);

            case "Cantidad":

                return daoInventario.listaInventarioSalidasFiltro("isa.cantidad", dato);

            case "Total Valor":

                return daoInventario.listaInventarioSalidasFiltro("isa.totalValor", dato);

        }

        return null;
    }

    public void reporteInventarioEntradas(String fecha) throws JRException {
        daoReportesJasper.reporteInventarioEntradas(fecha);
    }

    public void reporteInventarioSalidas(String fecha) throws JRException {
        daoReportesJasper.reporteInventarioSalidas(fecha);
    }
}
