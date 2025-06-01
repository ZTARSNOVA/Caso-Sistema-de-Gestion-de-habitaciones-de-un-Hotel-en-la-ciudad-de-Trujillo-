/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.s11_hotel.controller;

import java.util.List;

/**
 *
 * @author User
 */
public class HabitacionController {
    
    private HabitacionService service=null;
    
    public HabitacionController() {
        //Se crea el objeto
        service= new HabitacionService();
    }
    
    public boolean agregarHabtiacion(int numero, double precio, TipoVehiculo tipo) {
        Habitacion h = new Habitacion(0, numero, precio, tipo);
        return service.registrarHabitacion(h);
    }
    
    public Habitacion buscar(int numero) {
        Habitacion h = service.buscarPorNumero(numero);
        if (v == null)
            System.out.println("Habitacion no encontrado.");        
        return h;
    }
    
    public void calcularCostoAlquiler(TipoHabitacion tipo, int dias) {
        double costo = service.calcularCostoAlquiler(tipo, dias);
        System.out.println("Tipo: " + tipo + " Dias: " + dias + " Costo: " + costo);
    }

     
    public void actualizarHabitacion(int numero, double precio, TipoVehiculo tipo) {
        Habitacion h = new Habitacion(numero, precio, tipo);
        service.actualizarHabitacion(h);
    }

    public void eliminarHabitacion(int numero) {
        service.eliminarHabitacion(numero);
    }
    
    
    public List<Habitacion> listarHabitaciones() {
        return service.listarHabitaciones();
    }
}
