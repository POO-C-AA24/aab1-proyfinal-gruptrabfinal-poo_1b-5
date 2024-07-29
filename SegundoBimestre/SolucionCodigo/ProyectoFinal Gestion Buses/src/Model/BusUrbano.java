/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controller.Buses;
import java.time.LocalTime;

/**
 *
 * @author VEL-JOSUE
 */
public class BusUrbano extends Buses {

    public BusUrbano(int numero, String ruta, LocalTime horaSalida) {
        super(numero, ruta, horaSalida);
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Bus Urbano:");
        System.out.println("Número: " + getNumero());
        System.out.println("Ruta: " + getRuta());
        System.out.println("Hora de Salida: " + getHoraSalida());
    }
}
