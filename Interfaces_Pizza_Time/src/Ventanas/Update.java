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
public class Update {
    ParametersConection sqlvar = new ParametersConection();
    
    protected void t_pizzas(
            String id,
            String tamaño,
            String ingredienteUno,
            String ingredienteDos,
            String orilla,
            String precio) {

        Connection con;
        PreparedStatement ps;

        String query = "update T_pizzas set Tamaño='"
                + tamaño + "',Ingrediente_uno='" 
                + ingredienteUno + "',Ingrediente_dos='" 
                + ingredienteDos + "',Orilla='" 
                + orilla +"',Precio='"
                + precio +"' where Id='"+id+"';";

        try {
            con = DriverManager.getConnection(sqlvar.getUrl(), sqlvar.getUser(), sqlvar.getPass());
            ps = con.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    
    protected void t_ingredientes(
            String id,
            String nombre,
            String precio) {

        Connection con;
        PreparedStatement ps;

        String query = "update T_ingredientes set Nombre='"
                + nombre + "',Precio='" 
                + precio +"' where Id='"+id+"';";

        try {
            con = DriverManager.getConnection(sqlvar.getUrl(), sqlvar.getUser(), sqlvar.getPass());
            ps = con.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    protected void t_refrescos(
            String id,
            String marca,
            String tamaño,
            String precio) {

        Connection con;
        PreparedStatement ps;

        String query = "update T_refrescos set Marca='"
                + marca + "',Tamaño='" 
                + tamaño + "',Precio='" 
                + precio + "' where Id='"+id+"';";

        try {
            con = DriverManager.getConnection(sqlvar.getUrl(), sqlvar.getUser(), sqlvar.getPass());
            ps = con.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    protected void t_venta(
            String id,
            String pizza,
            String refresco,
            String precio) {

        Connection con;
        PreparedStatement ps;

        String query = "update T_venta set Pizza='"
                + pizza + "',Refresco='" 
                + refresco + "',Precio='" 
                + precio + "' where Id='"+id+"';";

        try {
            con = DriverManager.getConnection(sqlvar.getUrl(), sqlvar.getUser(), sqlvar.getPass());
            ps = con.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    protected void t_empleados(
            String id,
            String nombre,
            String apellidos,
            String puesto,
            String salario) {

        Connection con;
        PreparedStatement ps;

        String query = "update T_empleados set Nombre='"
                + nombre + "',Apellidos='" 
                + apellidos + "',Puesto='" 
                + puesto + "',Salario='" 
                + salario + "' where Id='"+id+"';";

        try {
            con = DriverManager.getConnection(sqlvar.getUrl(), sqlvar.getUser(), sqlvar.getPass());
            ps = con.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
}
