/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import com.sun.rowset.CachedRowSetImpl;
import configuracion.clsPropiedades;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelos.PropiedadesModel;

public class clsConexion {
    private Connection conn = null;
    private String BaseDatos="";
    private String usuario="";
    private String clave="";
    
    public clsConexion(){
        PropiedadesModel prop = new clsPropiedades().cargarPropiedad();
        BaseDatos = prop.getBasedatos();
        usuario=prop.getUsuario();
        clave = prop.getClave();
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch(ClassNotFoundException e){
            System.out.print("Error, con el driver"+e.getMessage());
        }
    }//constructor
    
    private String abrirConexion(){
        
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+BaseDatos,usuario,clave);
            return "OK";
        } catch (SQLException e){
            System.out.print("Error en base de datos"+e.getMessage());
            return "error en conexion DB "+e.getMessage();
        }
    }//abrir conexion
    
    private String cerrarConexion(){
        try{
            conn.close();
            return "OK";
        } catch (SQLException e){
            System.out.print("Error en base de datos"+e.getMessage());
            return "error en conexion DB "+e.getMessage();
        }
    }//cerrar
    
    
    
     public ResultSet EjecutarSeleccion(String Sql) {

        abrirConexion();

        Statement stmt = null;
        ResultSet rs = null;
        CachedRowSetImpl crs = null;
        try {

            stmt = conn.createStatement();
            rs = stmt.executeQuery(Sql);
            crs = new CachedRowSetImpl();
            crs.populate(rs);
        } catch (SQLException e) {
            throw new IllegalStateException("No se puede ejecutar el  query: " + Sql, e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    cerrarConexion();

                }
            } catch (SQLException e) {
                return null;
            }
        }

        return crs;

    }//end Seleccion
}//clase
