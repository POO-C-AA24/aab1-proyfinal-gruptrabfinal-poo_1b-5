/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.Buses;
import Controller.ServiciosBuses;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class PresentarBuses {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Ingrese la hora de ingreso (formato HH:MM): ");
            String inputHora = scanner.nextLine();
            LocalTime horaIngreso = LocalTime.parse(inputHora);
            
            System.out.println("Ingrese la ruta del bus: ");
            String rutaBus = scanner.nextLine();
            
            mostrarBusesEnRango(horaIngreso, rutaBus);
        }
    }

    public static void mostrarBusesEnRango(LocalTime horaIngreso, String rutaBus) {
        LocalTime horaFin = horaIngreso.plusHours(3);

        ArrayList<Buses> listaBuses = ServiciosBuses.getAllBuses();

        System.out.println("Buses disponibles desde " + horaIngreso + " hasta " + horaFin + " en la ruta " + rutaBus + ":");
        for (Buses bus : listaBuses) {
            LocalTime horaSalida = bus.getHoraSalida();
            if (bus.getRuta().equalsIgnoreCase(rutaBus)
                    && horaSalida.isAfter(horaIngreso.minusMinutes(1))
                    && horaSalida.isBefore(horaFin.plusMinutes(1))) {
                bus.incrementarVecesPresentado();
                bus.mostrarInformacion();
                System.out.println();
            }
        }
    }

}
