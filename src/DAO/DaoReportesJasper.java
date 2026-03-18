/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conectar;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsReportConfiguration;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;

/**
 *
 * @author USER
 */
public class DaoReportesJasper {

    public DaoReportesJasper() {
    }

    public void reporteAgenda(String fecha) throws JRException {

        String fechaCompleta, mes;
        File carpetaConjunto = new File("../../../Desktop/Agenda");

        if (carpetaConjunto.mkdir()) {

            System.out.println("se ha creado");

        } else {

            if (carpetaConjunto.mkdirs()) {

                System.out.println("se ha creado");
            } else {
                System.out.println("no se creo");
            }

        }

        DateTimeFormatter format = new DateTimeFormatterBuilder().append(DateTimeFormatter.ofPattern("yyyy-MM-d")).toFormatter();
        LocalDate fecha_I = LocalDate.parse(fecha, format);
        mes = mesFormat(fecha_I.getMonth() + "");

        fechaCompleta = fecha_I.getDayOfMonth() + " de " + mes + " del " + fecha_I.getYear();

        Conectar con = new Conectar("jdbc:mysql://192.168.0.100:3306/QuindiPlagas");

        JasperReport archivo = JasperCompileManager.compileReport("Agenda.jrxml");

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("Fecha", fecha);

        String destino = "../../../Desktop/Agenda/" + "Agenda del " + fechaCompleta + ".pdf";
        JasperPrint prin = JasperFillManager.fillReport(archivo, map, con.getConnection());
        JasperExportManager.exportReportToPdfFile(prin, destino);

    }

    public void reporteAgendaExcel(String fecha) throws JRException {

        String fechaCompleta, mes;
        File carpetaExcel = new File("../../../Desktop/Agenda/Excel");

        if (carpetaExcel.mkdir()) {

            System.out.println("se ha creado");

        } else {

            if (carpetaExcel.mkdirs()) {

                System.out.println("se ha creado");
            } else {
                System.out.println("no se creo");
            }

        }

        DateTimeFormatter format = new DateTimeFormatterBuilder().append(DateTimeFormatter.ofPattern("yyyy-MM-d")).toFormatter();
        LocalDate fecha_I = LocalDate.parse(fecha, format);
        mes = mesFormat(fecha_I.getMonth() + "");

        fechaCompleta = fecha_I.getDayOfMonth() + " de " + mes + " del " + fecha_I.getYear();

        Conectar con = new Conectar("jdbc:mysql://192.168.0.100:3306/QuindiPlagas");

        JasperReport archivo = JasperCompileManager.compileReport("Agenda.jrxml");

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("Fecha", fecha);

        JasperPrint prin = JasperFillManager.fillReport(archivo, map, con.getConnection());

        String destinoExcel = "../../../Desktop/Agenda/Excel/" + "Agenda del " + fechaCompleta + ".xlsx";
        JRXlsxExporter exporter = new JRXlsxExporter();
        exporter.setExporterInput(new SimpleExporterInput(prin));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(destinoExcel));

        SimpleXlsxReportConfiguration config = new SimpleXlsxReportConfiguration();
        config.setDetectCellType(true);
        config.setCollapseRowSpan(false);
        config.setWhitePageBackground(false);
        config.setRemoveEmptySpaceBetweenRows(true);

        exporter.setConfiguration(config);
        exporter.exportReport();

    }

    public void reportes(String filtro) throws JRException {

        File carpetaExcel = new File("../../../Desktop/Reportes");

        if (carpetaExcel.mkdir()) {

            System.out.println("se ha creado");

        } else {

            if (carpetaExcel.mkdirs()) {

                System.out.println("se ha creado");
            } else {
                System.out.println("no se creo");
            }

        }

        Conectar con = new Conectar("jdbc:mysql://192.168.0.100:3306/QuindiPlagas");

        JasperReport archivo = JasperCompileManager.compileReport("ReportesFiltrado.jrxml");

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("Filtro", filtro);

        JasperPrint prin = JasperFillManager.fillReport(archivo, map, con.getConnection());

        String destinoExcel = "../../../Desktop/Reportes/" + "reporte.xlsx";
        JRXlsxExporter exporter = new JRXlsxExporter();
        exporter.setExporterInput(new SimpleExporterInput(prin));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(destinoExcel));

        SimpleXlsxReportConfiguration config = new SimpleXlsxReportConfiguration();
        config.setDetectCellType(true);
        config.setCollapseRowSpan(false);
        config.setWhitePageBackground(false);
        config.setRemoveEmptySpaceBetweenRows(true);

        exporter.setConfiguration(config);
        exporter.exportReport();

    }

    public void reporteInventarioEntradas(String fecha) throws JRException {

        String fechaCompleta, mes;
        File carpetaConjunto = new File("../../../Desktop/Inventario/Entrada");

        if (carpetaConjunto.mkdir()) {

            System.out.println("se ha creado");

        } else {

            if (carpetaConjunto.mkdirs()) {

                System.out.println("se ha creado");
            } else {
                System.out.println("no se creo");
            }

        }

        DateTimeFormatter format = new DateTimeFormatterBuilder().append(DateTimeFormatter.ofPattern("yyyy-MM-d")).toFormatter();
        LocalDate fecha_I = LocalDate.parse(fecha, format);
        mes = mesFormat(fecha_I.getMonth() + "");

        fechaCompleta = fecha_I.getDayOfMonth() + " de " + mes + " del " + fecha_I.getYear();

        Conectar con = new Conectar("jdbc:mysql://192.168.0.100:3306/QuindiPlagas");

        JasperReport archivo = JasperCompileManager.compileReport("inventarioEntradas.jrxml");

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("Fecha", fecha);

        String destino = "../../../Desktop/Inventario/Entrada/" + "Inventario de las entradas del " + fechaCompleta + ".pdf";
        JasperPrint prin = JasperFillManager.fillReport(archivo, map, con.getConnection());
        JasperExportManager.exportReportToPdfFile(prin, destino);

    }

    public void reporteInventarioSalidas(String fecha) throws JRException {

        String fechaCompleta, mes;
        File carpetaConjunto = new File("../../../Desktop/Inventario/Salida");

        if (carpetaConjunto.mkdir()) {

            System.out.println("se ha creado");

        } else {

            if (carpetaConjunto.mkdirs()) {

                System.out.println("se ha creado");
            } else {
                System.out.println("no se creo");
            }

        }

        DateTimeFormatter format = new DateTimeFormatterBuilder().append(DateTimeFormatter.ofPattern("yyyy-MM-d")).toFormatter();
        LocalDate fecha_I = LocalDate.parse(fecha, format);
        mes = mesFormat(fecha_I.getMonth() + "");

        fechaCompleta = fecha_I.getDayOfMonth() + " de " + mes + " del " + fecha_I.getYear();

        Conectar con = new Conectar("jdbc:mysql://192.168.0.100:3306/QuindiPlagas");

        JasperReport archivo = JasperCompileManager.compileReport("inventarioSalidas.jrxml");

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("Fecha", fecha);

        String destino = "../../../Desktop/Inventario/Salida/" + "Inventario de las salidas del " + fechaCompleta + ".pdf";
        JasperPrint prin = JasperFillManager.fillReport(archivo, map, con.getConnection());
        JasperExportManager.exportReportToPdfFile(prin, destino);

    }

    public String mesFormat(String mes) {

        String mesRetornado;
        switch (mes) {
            case "JANUARY":

                mesRetornado = "Enero";
                return mesRetornado;

            case "FEBRUARY":

                mesRetornado = "Febrero";
                return mesRetornado;

            case "MARCH":

                mesRetornado = "Marzo";
                return mesRetornado;

            case "APRIL":

                mesRetornado = "Abril";
                return mesRetornado;

            case "MAY":

                mesRetornado = "Mayo";
                return mesRetornado;

            case "JUNE":

                mesRetornado = "Junio";
                return mesRetornado;

            case "JULY":

                mesRetornado = "Julio";
                return mesRetornado;

            case "AUGUST":

                mesRetornado = "Agosto";
                return mesRetornado;

            case "SEPTEMBER":

                mesRetornado = "Septiembre";
                return mesRetornado;

            case "OCTOBER":

                mesRetornado = "Octubre";
                return mesRetornado;

            case "NOVEMBER":

                mesRetornado = "Noviembre";
                return mesRetornado;

            case "DECEMBER":

                mesRetornado = "Diciembre";
                return mesRetornado;

        }

        return null;

    }
}
