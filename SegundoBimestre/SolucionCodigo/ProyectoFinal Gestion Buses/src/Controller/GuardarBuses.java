/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author VEL-JOSUE
 */
public abstract class GuardarBuses {

    public ArrayList<Buses> listaBuses;
    public LocalTime horaIngreso;
    public String nombreArchivo;

    public GuardarBuses(ArrayList<Buses> listaBuses, LocalTime horaIngreso, String nombreArchivo) {
        this.listaBuses = listaBuses;
        this.horaIngreso = horaIngreso;
        this.nombreArchivo = nombreArchivo;
    }

    public abstract void guardar() throws IOException;

    public boolean estaEnRango(LocalTime horaSalida, LocalTime horaIngreso, LocalTime horaFin) {
        return horaSalida.isAfter(horaIngreso.minusMinutes(1)) && horaSalida.isBefore(horaFin.plusMinutes(1));
    }
}
