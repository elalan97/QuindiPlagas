/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conexion;
import Modelo.Notificacion;
import java.sql.SQLException;

/**
 *
 * @author USER
 */
public class DaoNotificacion extends Conexion {

    public DaoNotificacion() {
    }

    public Notificacion buscarUsuario(int id) {
        String consulta = "select idNotificacion, fecha, "
                + "notificado "
                + "from Notificacion where idNotificacion ='" + id + "'";
        Notificacion notificacion = new Notificacion();
        super.ejecutarRetorno(consulta);
        try {
            if (resultadoDB.next()) {

                notificacion.setId(resultadoDB.getInt("idNotificacion"));
                notificacion.setFecha(resultadoDB.getString("fecha"));
                notificacion.setNotificado(resultadoDB.getBoolean("notificado"));

            }
        } catch (SQLException ex) {
            System.out.println("Fallo al consultar");
            return null;
        }
        return notificacion;
    }

    public boolean actualizarNotificacion(Notificacion n) {
        String consulta = "UPDATE Notificacion SET idNotificacion='" + n.getId() + "', "
                + " fecha='" + n.getFecha() + "', "
                + " notificado='" + n.isNotificado() + "' "
                + " WHERE idNotificacion='" + n.getId() + "'";
        return super.ejecutar(consulta);

    }

}
