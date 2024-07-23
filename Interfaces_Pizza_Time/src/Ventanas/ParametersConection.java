/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ventanas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Jesus
 */
public class ParametersConection {

    private Connection con;
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String user = "root";
    private final String pass = "root";
    private final String url = "jdbc:mysql://localhost:3306/pizzeria";

//iniciar el metodo con una prueba de coneccion entre java y la bd
    public void conexion() {
        con = null;
        try {
            Class.forName(driver);
            con = (Connection) DriverManager.getConnection(url, user, pass);
            System.out.println("coneccion exitosa");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("No se pudo conectar" + e.toString());
            //JOptionPane.showMessageDialog(null, "dede Parameters "+e.toString());
        }
    }

    public void comprovarJDBC() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected String getDriver() {
        return driver;
    }

    protected String getUser() {
        return user;
    }

    protected String getPass() {
        return pass;
    }

    protected String getUrl() {
        return url;
    }
}
