/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controller.Buses;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.time.LocalTime;

/**
 *
 * @author VEL-USER
 */
public class EscrituraRutasBuses {

    public List<Buses> buses;

    public void GuardarBuses(List<Buses> currentBuses) {
        LocalTime tiempoInicio = LocalTime.of(6, 30);
        LocalTime tiempoFin = LocalTime.of(21, 0);
        LocalTime ahora = LocalTime.now();

        for (int i = 0; i <= (tiempoFin.getHour() - tiempoInicio.getHour()) / 2; i++) {
            LocalTime inicioIntervalo = tiempoInicio.plusHours(i * 2);
            LocalTime finIntervalo = inicioIntervalo.plusHours(2);

            if (ahora.isAfter(inicioIntervalo.minusMinutes(1)) && ahora.isBefore(finIntervalo.plusMinutes(1))) {
                String fileName = "Buses_" + inicioIntervalo.toString().replace(":", "_") + "_a_" + finIntervalo.toString().replace(":", "_") + ".txt";
                try (FileOutputStream fileOut = new FileOutputStream(fileName); PrintWriter writer = new PrintWriter(fileOut)) {
                    for (Buses bus : currentBuses) {
                        writer.println(bus);
                    }
                    System.out.println("Los buses se han guardado en el archivo " + fileName);
                } catch (IOException e) {
                    System.err.println("Error al guardar los buses en el archivo: " + e.getMessage());
                }
                break;
            }
        }
    }
}
