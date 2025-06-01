/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.s11_hotel.model;

/**
 *
 * @author User
 */
public class Habitacion {
    
    private int numero;
    private double precio;
    private TipoHabitacion tipo;
    
    public Habitacion() {}

    public Habitacion(int numero, double precio, TipoHabitacion tipo) {
        this.numero = numero;
        this.precio = precio;
        this.tipo = tipo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public TipoHabitacion getTipo() {
        return tipo;
    }

    public void setTipo(TipoHabitacion tipo) {
        this.tipo = tipo;
    }

    
    
    @Override
    public String toString() {
        return "Habitacion{" + "numero=" + numero + ", precio=" + precio + ", tipo=" + tipo +'}';
    } 
}
