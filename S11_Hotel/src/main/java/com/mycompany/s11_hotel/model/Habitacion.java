
package com.mycompany.s11_hotel.model;

public class Habitacion {
    //Atributos
    private int habitacionID;
    private String numero;
    private String tipo;
    private double precio;

    public Habitacion() {}

    public Habitacion(int habitacionID, String numero, String tipo, double precio) {
        this.habitacionID = habitacionID;
        this.numero = numero;
        this.tipo = tipo;
        this.precio = precio;
    }

    //Metodo getters y setters
    public int getHabitacionID() {
        return habitacionID;
    }

    public void setHabitacionID(int habitacionID) {
        this.habitacionID = habitacionID;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    //Metodo reporte
    @Override
    public String toString() {
        return "Habitacion{" + "ID=" + habitacionID + ", numero='" + numero + '\'' + ", tipo='" + tipo + '\'' + ", precio=" + precio + '}';
    }
}
