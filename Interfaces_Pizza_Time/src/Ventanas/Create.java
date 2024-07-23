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
public class Create {

    ParametersConection sqlvar = new ParametersConection();

    protected void t_pizzas(
            String tamaño,
            String ingredienteUno,
            String ingredienteDos,
            String orilla,
            String precio) {

        Connection con;
        PreparedStatement ps;

        String query = "insert into T_pizzas values(0,'"
                + tamaño + "','"
                + ingredienteUno + "','"
                + ingredienteDos + "','"
                + orilla + "','"
                + precio + "');";

        try {
            con = DriverManager.getConnection(sqlvar.getUrl(), sqlvar.getUser(), sqlvar.getPass());
            ps = con.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    protected void t_ingredientes(String nombre, String precio) {
        Connection con;
        PreparedStatement ps;

        String query = "insert into T_ingredientes values('"
                + nombre + "','"
                + precio + "');";

        try {
            con = DriverManager.getConnection(sqlvar.getUrl(), sqlvar.getUser(), sqlvar.getPass());
            ps = con.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }

    }

    protected void t_refrescos(
            String marca,
            String tamaño,
            String precio) {

        Connection con;
        PreparedStatement ps;

        String query = "insert into T_refrescos values(0,'"
                + marca + "','"
                + tamaño + "','"
                + precio + "');";

        try {
            con = DriverManager.getConnection(sqlvar.getUrl(), sqlvar.getUser(), sqlvar.getPass());
            ps = con.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }

    }

    protected void t_venta(
            String precio) {

        Connection con;
        PreparedStatement ps;

        String query = "insert into T_venta values(0,'"
                + precio + "');";

        try {
            con = DriverManager.getConnection(sqlvar.getUrl(), sqlvar.getUser(), sqlvar.getPass());
            ps = con.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }

    }

    protected void t_empleados(
            String nombre,
            String apellidos,
            String puesto,
            String salario) {

        Connection con;
        PreparedStatement ps;

        String query = "insert into T_empleados values(0,'"
                + nombre + "','"
                + apellidos + "','"
                + puesto + "','"
                + salario + "');";

        try {
            con = DriverManager.getConnection(sqlvar.getUrl(), sqlvar.getUser(), sqlvar.getPass());
            ps = con.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }

    }
    
    protected void t_ventas_refrescos(
            String id_venta,
            String id_refresco,
            String cantidad,
            String importe) {

        Connection con;
        PreparedStatement ps;

        String query = "insert into T_ventas_refrescos values(0,'"
                + id_venta + "','"
                + id_refresco + "','"
                + cantidad + "','"
                + importe + "');";

        try {
            con = DriverManager.getConnection(sqlvar.getUrl(), sqlvar.getUser(), sqlvar.getPass());
            ps = con.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }

    }
    
    protected void t_ventas_pizzas(
            String id_venta,
            String id_pizza,
            String cantidad,
            String importe) {

        Connection con;
        PreparedStatement ps;

        String query = "insert into T_ventas_pizzas values(0,"
                + id_venta + ","
                + id_pizza + ","
                + cantidad + ","
                + importe + ");";

        try {
            con = DriverManager.getConnection(sqlvar.getUrl(), sqlvar.getUser(), sqlvar.getPass());
            ps = con.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }

    }
}
