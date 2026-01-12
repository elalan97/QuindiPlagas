/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DAO.DaoAgenda;
import DAO.DaoReportesJasper;
import DAO.DaoServicios;
import DTO.DtoAgenda;
import Exepciones.NoExisteAgenda;
import Exepciones.NoExisteServicio;
import Exepciones.YaExisteAgenda;
import Modelo.Agenda;
import Modelo.Servicio;
import java.util.ArrayList;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author USER
 */
public class BoAgenda {

    DaoAgenda daoAgenda;
    DaoServicios daoServicios;
    DaoReportesJasper daoReportesJasper;

    public BoAgenda() {

        daoAgenda = new DaoAgenda();
        daoServicios = new DaoServicios();
        daoReportesJasper = new DaoReportesJasper();
    }

    public void guardarAgenda(Agenda agenda, String factura) {

        Servicio servicio = daoServicios.buscarServicio(factura);

        if (servicio.getNroFactura() == null) {

            throw new NoExisteServicio();

        } else {

            DtoAgenda dtoAgenda = daoAgenda.verificarAgenda(servicio.getNroFactura(),
                    agenda.getFecha());

            if (dtoAgenda.getsNroFactura() == null) {

                agenda.setServicioFk(servicio.getIdServicio());
                daoAgenda.guardarAgenda(agenda);

            } else {

                throw new YaExisteAgenda();

            }
        }

    }

    /*public Agenda buscarAgenda(String factura, String fecha) {

        DtoAgenda dtoAgenda = daoAgenda.verificarAgenda(factura, fecha);

        if (dtoAgenda.getsNroFactura() == null) {

            throw new NoExisteAgenda();

        } else {

            Agenda agenda = new Agenda(dtoAgenda.getaIdAgenda(), 0,
                    dtoAgenda.getaHora(), dtoAgenda.getaConfirmacion(), dtoAgenda.getaObservacion());
            return agenda;
        }

    }*/
    public void edtarAgenda(Agenda agenda, String factura) {

        Servicio servicio = daoServicios.buscarServicio(factura);

        if (servicio.getNroFactura() == null) {

            throw new NoExisteAgenda();

        } else {

            DtoAgenda dtoAgenda = daoAgenda.verificarAgenda(servicio.getNroFactura(),
                    servicio.getFecha());

            if (dtoAgenda.getsNroFactura() == null) {

                throw new NoExisteAgenda();

            } else {

                agenda.setServicioFk(servicio.getIdServicio());
                agenda.setIdAgenda(dtoAgenda.getaIdAgenda());

                daoAgenda.editarAgenda(agenda);

            }

        }

    }

    public void edtarAgendaRefuerzo(Agenda agenda, String factura, String fecha) {

        Servicio servicio = daoServicios.buscarServicio(factura);

        if (servicio.getNroFactura() == null) {

            throw new NoExisteAgenda();

        } else {

            DtoAgenda dtoAgenda = daoAgenda.verificarAgenda(servicio.getNroFactura(),
                    fecha);

            if (dtoAgenda.getsNroFactura() == null) {

                throw new NoExisteAgenda();

            } else {

                agenda.setServicioFk(servicio.getIdServicio());
                agenda.setIdAgenda(dtoAgenda.getaIdAgenda());

                daoAgenda.editarAgenda(agenda);

            }

        }

    }

    public void eliminarAgenda(String factura, String fecha) {

        DtoAgenda dtoAgenda = daoAgenda.verificarAgenda(factura,
                fecha);

        if (dtoAgenda.getsNroFactura() == null) {

            throw new NoExisteAgenda();

        } else {

            daoAgenda.eliminarAgenda(dtoAgenda.getaIdAgenda());

        }

    }

    public DtoAgenda buscarServicioAgenda(String nroFactura) {

        DtoAgenda dtoAgenda = daoAgenda.buscarServicioAgenda(nroFactura);

        if (dtoAgenda.getsNroFactura() == null) {

            throw new NoExisteAgenda();

        } else {

            if (dtoAgenda.getsRefuerzo().equals("Si")) {

                DtoAgenda dtoAgenda1 = daoAgenda.buscarServicioAgendaRefuerzo(nroFactura);

                return dtoAgenda1;

            } else {
                return dtoAgenda;
            }

        }

    }

    public ArrayList<DtoAgenda> listarAgenda() {
        return daoAgenda.listarAgenda();
    }

    public ArrayList<DtoAgenda> listarAgendaPorFiltro(String fecha) {
        return daoAgenda.listarAgendaPorFiltro(fecha);
    }

    public void reporteAgenda(String fecha) throws JRException {
        daoReportesJasper.reporteAgenda(fecha);
    }

}
