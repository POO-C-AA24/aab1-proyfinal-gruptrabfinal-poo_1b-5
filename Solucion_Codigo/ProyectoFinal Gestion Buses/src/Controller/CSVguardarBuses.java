/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.BusUrbano;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author VEL-JOSUE
 */
public class CSVguardarBuses extends GuardarBuses {
    public CSVguardarBuses(ArrayList<Buses> listaBuses, LocalTime horaIngreso, String nombreArchivo) {
        super(listaBuses, horaIngreso, nombreArchivo);
    }

    @Override
    public void guardar() throws IOException {
        LocalTime horaFin = horaIngreso.plusHours(2);

        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            writer.write("Tipo, Número, Ruta, Hora de Salida\n");

            for (Buses bus : listaBuses) {
                LocalTime horaSalida = bus.getHoraSalida();
                if (estaEnRango(horaSalida, horaIngreso, horaFin)) {
                    writer.write((bus instanceof BusUrbano ? "Urbano" : "Interurbano") + ", ");
                    writer.write(bus.getNumero() + ", ");
                    writer.write(bus.getRuta() + ", ");
                    writer.write(bus.getHoraSalida() + "\n");
                }
            }

            System.out.println("La información se ha guardado en el archivo " + nombreArchivo);
        }
    }
}/* H2 DESCARGAR
*/
