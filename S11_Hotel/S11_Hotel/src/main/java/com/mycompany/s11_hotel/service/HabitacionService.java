/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.s11_hotel.service;

import java.util.List;

/**
 *
 * @author User
 */
public class HabitacionService {
    
    private HabitacionRepositorylmpl repo;
    private ContextoCosto contexto;
    
    public VehiculoService() {
        this.repo = new HabitacionRepositorylmpl();
        this.contexto = new ContextoCosto();
    }
    
    public boolean registrarVehiculo(Vehiculo v) {
        if (v.getPrecio() < 1000) {
            System.out.println("Error: El precio no puede ser menor a 1000.");
            return false;
        }

        repo.guardar(v);
        return true;
    }
    
    public Habitacion buscarPorNumero(int numero) {
        return repo.buscarPorNumero(numero);
    }

    public void actualizarHabitacion(Habitacion h) {
        repo.actualizar(h);
    }

    public void eliminarHabitacion(int numero) {
        repo.eliminar(numero);
    }
    
    public List<Habitacion> listarHabitaciones() {
        return repo.listarTodos();
    }
    
    public double calcularCostoAlquiler(TipoHabitacion tipo, int dias) {
        contexto.seleccionarEstrategia(tipo);
        return contexto.ejecutarCalculo(dias);
    }

}
