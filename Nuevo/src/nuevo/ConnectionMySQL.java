/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuevo;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Marvella Ortega
 */
public class ConnectionMySQL {
        static Statement stm = null;
        
        public static Connection getConexion(){
            Connection cn = null;
            try{
                Class.forName("com.mysql.jdbc.Driver");
                cn = DriverManager.getConnection("jdbc:mysql://localhost/prueba", "root", "n0m3l0");
                stm = (Statement) cn.createStatement();
                System.out.print("Conexion Satisfactoria");
            }
            catch (Exception e){
                System.out.print("Error de conexion: "+e);
            }
            return cn;
        } 
        
        public void SubirDatos(String n, String ap, String am, String esc){
            try{
                stm.executeUpdate("INSERT INTO Persona(nombre, AP, AM, escuela) VALUES ('"+n+"','"+ap+"','"+am+"','"+esc+"');");
            }catch(SQLException error)
            {
                
                
                System.out.println(error.toString());
            }
        }      

}
