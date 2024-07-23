/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ventanas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jesus
 */
public class Login {

    String puesto;
    ParametersConection sqlvar = new ParametersConection();

    public String existe(String numeroUsuario) {

        PreparedStatement ps;
        ResultSet rs;

        try {
            Class.forName(sqlvar.getDriver());
            Connection cn = DriverManager.getConnection(sqlvar.getUrl(), sqlvar.getUser(), sqlvar.getPass());
            try {
                ps = cn.prepareStatement("Select Id,Puesto from T_empleados;");
                rs = ps.executeQuery();

                while (rs.next()) {
                    if (rs.getString(1).equals(numeroUsuario)) {
                        puesto = rs.getString(2);
                    }
                }
                ps.close();
                rs.close();

            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return puesto;
    }
}
