package com.mycompany.s11_hotel.repository;

import com.mycompany.s11_hotel.model.Habitacion;
import java.util.List;

public interface HabitacionRepository {
    void guardar(Habitacion habitacion);
    Habitacion buscarPorNumero(String numero);
    void actualizar(Habitacion habitacion);
    void eliminar(int habitacionID);
    List<Habitacion> listarTodos();
}
