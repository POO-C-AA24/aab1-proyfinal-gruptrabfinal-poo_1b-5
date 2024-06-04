/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author VEL-USER
 */
public class HoraDeIngreso {

    public LocalDateTime ahora = LocalDateTime.now();
    public DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");
    public String horaFormateada = ahora.format(formato);
    public LocalTime horaActual;

    public HoraDeIngreso(LocalTime horaActual) {
        this.horaActual = horaActual;
    }

    @Override
    public String toString() {
        return "HoraDeIngreso{" + "horaActual=" + horaActual + '}';
    }
    
}
