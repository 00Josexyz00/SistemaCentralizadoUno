package com.mycompany.practicasistemacentralizado;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.objects.annotations.Where;


public class Test {

    
        
    public Connection getConexion() 
    {
        Connection conexion = null;
        
        String servidor = "localhost";
        
        String puerto = "5432";
        
        String baseDatos = "supermercado";
        
        String url = "jdbc:postgresql://" + servidor + ":" + puerto + "/" + baseDatos;
        
        String usuario = "postgres";
        
        String clave = "00jose__";
        
        try {
            conexion = DriverManager.getConnection(url, usuario, clave);
            
        } catch (SQLException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexion;
    }
    public void ver (String codigo){
        Connection conexion = getConexion();
        String sql = "select * from producto";
        /*
        try(Statement st = conexion.createStatement()) {
           Object result = st.executeQuery(sql);
           where (result.){
            
        }
           
        } catch (Exception e) {
        }
        
       */ 
    }
    
    
    public void insertar(String codigo,String nombre,String precio) {

        Connection conexion = getConexion();
        
        
        String sql = "insert into producto values (" + codigo + ",'" + nombre + "','" + precio + "')";
        try (Statement st = conexion.createStatement()) {
            
            //EL executeUpdate ES LA EJECUCIÓN DE LA SENTENCIA
            st.executeUpdate(sql);
            
        } catch (Exception e) {
            
            e.printStackTrace();
        }

    }
    
     public void actualizar(int codigo, String nombre, double precio) {
         
        Connection conexion = getConexion();
        
        String sql = "UPDATE producto SET " + "nombre='" + nombre + "'" + ",precio=" + precio + "WHERE codigo=" + codigo;
        try (Statement st = conexion.createStatement()) {
            
            st.executeUpdate(sql);
            
        } catch (Exception e) {
            
            e.printStackTrace();
        }

    }

    public void eliminar(int codigo) {
        
        Connection conexion = getConexion();
        
        String sql = "DELETE FROM producto WHERE codigo = " + codigo;
        
        try (Statement st = conexion.createStatement()) 
        {
            st.executeUpdate(sql);
            
        } catch (Exception e) {
            
            e.printStackTrace();
        }

    }
    
    
}