/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author brian
 */ //192.168.0.100
public class Conexion {
    public String driver = "com.mysql.jdbc.Driver"; //nombre del driver
    public String db = "QuindiPlagas"; //Nombre del esquema de base de datos
    public String connectString = "jdbc:mysql://192.168.0.100:3306/" + db; //ubicacion de la base de datos
    public String user = "QuindiPlagas"; //usuario de la base de datos
    public String password = "901172211"; //password de la base de datos
    public Connection conexionDB; // variable que permite la conexion
    public Statement sentenciaSQL; //permite la ejecucion de sentencias SQL
    public ResultSet resultadoDB;//almacena el resultado de una consulta

    /**
     * Permite la conexion de la base de datos
     */
    public void conectar() {
        try {
            Class.forName(driver); //se carga el driver en memoria
            conexionDB = DriverManager.getConnection(connectString, user, password);//conexion a la base de datos
            System.out.println("SE CONECTA");
            sentenciaSQL = conexionDB.createStatement();//variable que permite ejecutar las sentencias SQL    
            System.out.println("SE CREA STATEMENT");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Desconecta la conexion de la base de datos
     */
    public void desconectar() {
        try {
            conexionDB.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean ejecutar(String sentencia) {
        try {
            conectar();
            sentenciaSQL.executeUpdate(sentencia);
            //desconectar();
        } catch (Exception e) {
            System.out.println("ERROR");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void ejecutarRetorno(String sentencia) {
        try {
            conectar();
            resultadoDB = sentenciaSQL.executeQuery(sentencia);// busqueda SELECT
            //desconectar();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public Connection getConnection(){
        
        conectar();
        return conexionDB;
        
    }
    
 }
