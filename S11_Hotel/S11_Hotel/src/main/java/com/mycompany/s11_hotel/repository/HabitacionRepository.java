/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.s11_hotel.repository;

import java.util.List;

/**
 *
 * @author User
 */
public interface HabitacionRepository
{
    //Metodos abstractos CRUD
    void guardar(Habitacion habitacion);        
    void actualizar(Habitacion habitacion);
    void eliminar(int numero);
    List<Habitacion> listarTodos();
}
