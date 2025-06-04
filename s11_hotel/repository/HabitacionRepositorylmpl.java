package com.mycompany.s11_hotel.repository;

import com.mycompany.s11_hotel.configuracion.ConexionBD;
import com.mycompany.s11_hotel.model.Habitacion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HabitacionRepositoryImpl implements HabitacionRepository {

    private Connection conexion = ConexionBD.getConexion();

    @Override
    public void guardar(Habitacion h) {
        String sql = "INSERT INTO habitaciones (Numero, Tipo, Precio) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, h.getNumero());
            stmt.setString(2, h.getTipo());
            stmt.setDouble(3, h.getPrecio());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Habitacion buscarPorNumero(String numero) {
        String sql = "SELECT * FROM habitaciones WHERE Numero = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, numero);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Habitacion(
                        rs.getInt("HabitacionID"),
                        rs.getString("Numero"),
                        rs.getString("Tipo"),
                        rs.getDouble("Precio")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void actualizar(Habitacion h) {
        String sql = "UPDATE habitaciones SET Numero = ?, Tipo = ?, Precio = ? WHERE HabitacionID = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, h.getNumero());
            stmt.setString(2, h.getTipo());
            stmt.setDouble(3, h.getPrecio());
            stmt.setInt(4, h.getHabitacionID());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int habitacionID) {
        String sql = "DELETE FROM habitaciones WHERE HabitacionID = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, habitacionID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Habitacion> listarTodos() {
        List<Habitacion> lista = new ArrayList<>();
        String sql = "SELECT * FROM habitaciones";
        try (Statement stmt = conexion.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Habitacion h = new Habitacion(
                        rs.getInt("HabitacionID"),
                        rs.getString("Numero"),
                        rs.getString("Tipo"),
                        rs.getDouble("Precio")
                );
                lista.add(h);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
