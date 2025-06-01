/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.s11_hotel.service.estrategia;

/**
 *
 * @author User
 */
public class ContextoCosto {
    private EstrategiaCosto estrategia;

    public void setEstrategia(EstrategiaCosto estrategia) {
        this.estrategia = estrategia;
    }

    public double ejecutarCalculo(int dias) {
        return estrategia.calcularCosto(dias);
    }

    public void seleccionarEstrategia(TipoHabitacion tipo) {
        switch (tipo) {
            case DOUBLE -> setEstrategia(new CostoDouble());
            case DELUXE -> setEstrategia(new CostoDeluxe());
            case SUITE -> setEstrategia(new CostoSuite());
        }
    }   
}
