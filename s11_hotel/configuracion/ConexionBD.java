package com.mycompany.s11_hotel.configuracion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/habitaciones_db";
    private static final String USER = "root";
    private static final String PASSWORD = "200130"; //Password MySQL

    private static Connection conexion;

    public static Connection getConexion() {
        if (conexion == null) {
            try {
                conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conexion;
    }
}
