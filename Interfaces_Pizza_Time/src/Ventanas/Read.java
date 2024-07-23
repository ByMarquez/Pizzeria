/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ventanas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jesus
 */
public class Read {

    //objeto de tipo ParametersConection con nombre sqlvar
    ParametersConection sqlvar = new ParametersConection();

    //clase que coloca un modelo de tabla automaticamente
    public DefaultTableModel readCualquierTabla(JTable nombre_variable_tabla, String nombre_SQL) {

        DefaultTableModel modelo_tabla = (DefaultTableModel) nombre_variable_tabla.getModel();
        modelo_tabla.setRowCount(0);

        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;

        try {
            Class.forName(sqlvar.getDriver());

            Connection cn = DriverManager.getConnection(sqlvar.getUrl(), sqlvar.getUser(), sqlvar.getPass());

            ps = cn.prepareStatement("Select * from " + nombre_SQL + ";");
            rs = ps.executeQuery();
            rsmd = rs.getMetaData();

            columnas = rsmd.getColumnCount();

            while (rs.next()) {
                Object[] fila = new Object[columnas];
                for (int i = 0; i < columnas; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                modelo_tabla.addRow(fila);
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return modelo_tabla;
    }

    protected void pizza(JTable tabla_empleados) {
        DefaultTableModel modelo = new DefaultTableModel();
        Statement ejecutor = null;
        Connection con;

        modelo.addColumn("Id");
        modelo.addColumn("Tamaño");
        modelo.addColumn("Ingrediente Uno");
        modelo.addColumn("Ingrediente Dos");
        modelo.addColumn("Orilla");
        modelo.addColumn("Precio");
        modelo.setRowCount(0);

        String datos[] = new String[6];
        String query = "Select * from T_pizzas;";
        ResultSet rs;
        try {
            con = DriverManager.getConnection(sqlvar.getUrl(), sqlvar.getUser(), sqlvar.getPass());
            ejecutor = con.createStatement();
            ejecutor.setQueryTimeout(20);
            rs = ejecutor.executeQuery(query);
            while (rs.next() == true) {
                datos[0] = rs.getString("Id");
                datos[1] = rs.getString("Tamaño");
                datos[2] = rs.getString("Ingrediente_uno");
                datos[3] = rs.getString("Ingrediente_dos");
                datos[4] = rs.getString("Orilla");
                datos[5] = rs.getString("Precio");
                modelo.addRow(datos);
            }
            tabla_empleados.setModel(modelo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    protected void refresco(JTable tabla_empleados) {
        DefaultTableModel modelo = new DefaultTableModel();
        Statement ejecutor = null;
        Connection con;

        modelo.addColumn("Id");
        modelo.addColumn("Marca");
        modelo.addColumn("Tamaño");
        modelo.addColumn("Precio");
        modelo.setRowCount(0);

        String datos[] = new String[4];
        String query = "Select * from T_refrescos;";
        ResultSet rs;
        try {
            con = DriverManager.getConnection(sqlvar.getUrl(), sqlvar.getUser(), sqlvar.getPass());
            ejecutor = con.createStatement();
            ejecutor.setQueryTimeout(20);
            rs = ejecutor.executeQuery(query);
            while (rs.next() == true) {
                datos[0] = rs.getString("Id");
                datos[1] = rs.getString("Marca");
                datos[2] = rs.getString("Tamaño");
                datos[3] = rs.getString("Precio");
                modelo.addRow(datos);
            }
            tabla_empleados.setModel(modelo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }

    }

}
