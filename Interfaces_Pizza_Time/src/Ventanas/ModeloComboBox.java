/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ventanas;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Jesus
 */
public class ModeloComboBox {

    ParametersConection mysqlpa = new ParametersConection();

    protected DefaultComboBoxModel getcalues() {
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try {
            Connection con = DriverManager.getConnection(mysqlpa.getUrl(), mysqlpa.getUser(), mysqlpa.getPass());
            try {

                PreparedStatement ps = con.prepareStatement("select Nombre from T_ingredientes");
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    modelo.addElement(rs.getString(1));
                }
                ps.close();
                rs.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return modelo;
    }
    
     public String identificador() {
        String bandera="";
        try {
            Connection con = DriverManager.getConnection(mysqlpa.getUrl(), mysqlpa.getUser(), mysqlpa.getPass());
            try {

                PreparedStatement ps = con.prepareStatement("select Id from T_venta");
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    String numero = rs.getString(1);
                    bandera=numero;
                }
                ps.close();
                rs.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        System.out.println("el identificador de esta venta es:"+bandera);
        return bandera;
    }
}
