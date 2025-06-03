
package com.mycompany.s11_hotel.service;

import com.mycompany.s11_hotel.model.Habitacion;
import com.mycompany.s11_hotel.repository.HabitacionRepository;
import com.mycompany.s11_hotel.repository.HabitacionRepositoryImpl;

import java.util.List;

public class HabitacionService {

    private HabitacionRepository repository;

    public HabitacionService() {
        repository = new HabitacionRepositoryImpl();
    }

    public boolean registrarHabitacion(Habitacion habitacion) {
        if (habitacion.getPrecio() < 50) {
            System.out.println("El precio minimo debe ser 50");
            return false;
        }
        repository.guardar(habitacion);
        return true;
    }

    public Habitacion buscarPorNumero(String numero) {
        return repository.buscarPorNumero(numero);
    }

    public void actualizarHabitacion(Habitacion habitacion) {
        repository.actualizar(habitacion);
    }

    public void eliminarHabitacion(int habitacionID) {
        repository.eliminar(habitacionID);
    }

    public List<Habitacion> listarHabitaciones() {
        return repository.listarTodos();
    }

    public double calcularCostoAlquiler(String tipo, double precioBase, int horas) {
        CalculoPrecioStrategy strategy;

        switch (tipo.toLowerCase()) {
            case "doble":
                strategy = new CalculoPrecioDoble();
                break;
            case "deluxe":
                strategy = new CalculoPrecioDeluxe();
                break;
            case "suite":
                strategy = new CalculoPrecioSuite();
                break;
            default:
                throw new IllegalArgumentException("Tipo de habitacion desconocido");
        }
        return strategy.calcularPrecio(precioBase, horas);
    }

    // Strategy
    interface CalculoPrecioStrategy {
        double calcularPrecio(double precioBase, int horas);
    }

    class CalculoPrecioDoble implements CalculoPrecioStrategy {
        public double calcularPrecio(double precioBase, int horas) {
            return precioBase * horas;
        }
    }

    class CalculoPrecioDeluxe implements CalculoPrecioStrategy {
        public double calcularPrecio(double precioBase, int horas) {
            return precioBase * horas * 1.2;
        }
    }

    class CalculoPrecioSuite implements CalculoPrecioStrategy {
        public double calcularPrecio(double precioBase, int horas) {
            return precioBase * horas * 1.5;
        }
    }
}
