/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.s11_hotel.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class HabitacionRepositorylmpl implements HabitacionRepository
{
    private Connection conexion=null; 

    public HabitacionRepositorylmpl(){        
        //Se crea un obj de clase Conexion para conectarse a la BD
        conexion= ConexionBD.getConnection(); 
    }

   @Override
   public void guardar(Habitacion h) {
        try {
            String sql = "INSERT INTO vehiculos (numero, precio, tipo) VALUES (?, ?, ?)";
            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setString(1, v.getNumero());
            stmt.setDouble(2, v.getPrecio());
            stmt.setString(3, v.getTipo().name());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
   
    @Override
    public void actualizar(Habitacion h) {
        try{
            String sql = "UPDATE vehiculos SET numero=?, precio=?, tipo=?";
            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setString(1, v.getNumero());
            stmt.setDouble(4, v.getPrecio());
            stmt.setString(5, v.getTipo().name());
            stmt.executeUpdate();
        } catch (SQLException e) {
           throw new RuntimeException(e);
        }
    }

    @Override
    public void eliminar(int numero) {
        try {
            String sql = "DELETE FROM habitacion WHERE numero=?";
            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setInt(1, numero);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    } 
    
    public Habitacion buscarPorNumero(int numero) {
        
        try{String sql = "SELECT * FROM habitacion WHERE numero=?";
            PreparedStatement ps = conexion.prepareStatement(sql);                
            ps.setInt(1, numero);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Habitacion(
                    rs.getInt("numero"),
                    rs.getDouble("precio"),
                    TipoHabitacion.valueOf(rs.getString("tipo"))                        
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    
    @Override
    public List<Habitacion> listarTodos() {
        List<Habitacion> lista = new ArrayList<>();
        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM vehiculos");
            while (rs.next()) {
                Habitacion h = new Habitacion(
                    rs.getNumero("numero"),
                    rs.getDouble("precio"),
                    TipoVehiculo.valueOf(rs.getString("tipo"))
                );
                lista.add(h);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }    
}
