package com.mycompany.s11_hotel.controller;

import com.mycompany.s11_hotel.model.Habitacion;
import com.mycompany.s11_hotel.service.HabitacionService;

import java.util.List;

public class HabitacionController {

    private HabitacionService service;

    public HabitacionController() {
        service = new HabitacionService();
    }

    public boolean agregarHabitacion(String numero, String tipo, double precio) {
        Habitacion h = new Habitacion(0, numero, tipo, precio);
        return service.registrarHabitacion(h);
    }

    public Habitacion buscar(String numero) {
        Habitacion h = service.buscarPorNumero(numero);
        if (h == null) {
            System.out.println("Habitacion no encontrada.");
        }
        return h;
    }

    public void actualizarHabitacion(int habitacionID, String numero, String tipo, double precio) {
        Habitacion h = new Habitacion(habitacionID, numero, tipo, precio);
        service.actualizarHabitacion(h);
    }

    public void eliminarHabitacion(int habitacionID) {
        service.eliminarHabitacion(habitacionID);
    }

    public List<Habitacion> listarHabitaciones() {
        return service.listarHabitaciones();
    }

    public double calcularCostoAlquiler(String tipo, double precioBase, int horas) {
        return service.calcularCostoAlquiler(tipo, precioBase, horas);
    }
}
