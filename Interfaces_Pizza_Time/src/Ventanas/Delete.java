/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ventanas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Jesus
 */
public class Delete {
    ParametersConection mysqlpa=new ParametersConection();
    
    protected void deleteCualquierTabla(String nombreTablaSQL, String id){
    Connection con;
    PreparedStatement ps;        
        String query="delete from "+nombreTablaSQL+" where Id='"+id+"';";
        try {
            con = DriverManager.getConnection(mysqlpa.getUrl(), mysqlpa.getUser(), mysqlpa.getPass());
            ps=con.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    
    protected void deleteingrediente(String nombreTablaSQL, String ingrediente){
    Connection con;
    PreparedStatement ps;        
        String query="delete from "+nombreTablaSQL+" where Nombre='"+ingrediente+"';";
        try {
            con = DriverManager.getConnection(mysqlpa.getUrl(), mysqlpa.getUser(), mysqlpa.getPass());
            ps=con.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
}
