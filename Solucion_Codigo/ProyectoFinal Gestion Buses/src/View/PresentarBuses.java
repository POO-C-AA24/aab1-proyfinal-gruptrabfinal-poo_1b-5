/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.Buses;
import Controller.ManejodeDataBase;
import Controller.ServiciosBuses;

import Model.BusUrbano;
import Model.BusInterUrbano;


import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PresentarBuses {

    public static void main(String[] args) {
        ArrayList<Buses> listaBuses = new ArrayList<>(Arrays.asList(
                new BusUrbano(22, "Época - Campus UTPL", LocalTime.of(6, 30)),
                new BusInterUrbano(21, "Operadores - Campus UTPL", LocalTime.of(6, 30)),
                new BusUrbano(8, "Parque Infantil - Campus UTPL", LocalTime.of(7, 0)),
                new BusInterUrbano(1, "Parque Infantil - Campus UTPL", LocalTime.of(7, 0)),
                new BusUrbano(19, "Hipervalle - Campus UTPL", LocalTime.of(7, 30)),
                new BusInterUrbano(12, "Tebaida Baja - Campus UTPL", LocalTime.of(7, 30)),
                new BusUrbano(13, "Coliseo Ciudad de Loja - Campus UTPL", LocalTime.of(8, 0)),
                new BusInterUrbano(2, "Pradera - Campus UTPL", LocalTime.of(8, 0)),
                new BusUrbano(9, "Canchas Calva y Calva - Campus UTPL", LocalTime.of(8, 30)),
                new BusInterUrbano(20, "Las Pitas - Campus UTPL", LocalTime.of(8, 30)),
                new BusUrbano(10, "Ciudad Alegría - Campus UTPL", LocalTime.of(9, 0)),
                new BusInterUrbano(15, "Operadores - Campus UTPL", LocalTime.of(9, 0)),
                new BusUrbano(3, "Pradera - Campus UTPL", LocalTime.of(9, 30)),
                new BusInterUrbano(23, "Rosales - Campus UTPL", LocalTime.of(9, 30)),
                new BusUrbano(7, "Ciudad Alegría - Campus UTPL", LocalTime.of(10, 0)),
                new BusInterUrbano(20, "Sauces Norte - Campus UTPL", LocalTime.of(10, 0)),
                new BusUrbano(18, "Sauces Norte - Campus UTPL", LocalTime.of(10, 30)),
                new BusInterUrbano(24, "Sauces Norte - Campus UTPL", LocalTime.of(10, 30)),
                new BusUrbano(19, "Hipervalle - Campus UTPL", LocalTime.of(11, 0)),
                new BusInterUrbano(33, "Campus UTPL - La Urna", LocalTime.of(11, 0)),
                new BusUrbano(32, "Campus UTPL - La Urna", LocalTime.of(11, 30)),
                new BusInterUrbano(31, "Campus UTPL - La Urna", LocalTime.of(11, 30)),
                new BusUrbano(14, "Lauro Guerreo - Campus UTPL", LocalTime.of(12, 0)),
                new BusInterUrbano(85, "Campus UTPL - Operadores", LocalTime.of(12, 0)),
                new BusUrbano(83, "Campus UTPL - Daniel Álvarez", LocalTime.of(12, 30)),
                new BusInterUrbano(88, "Campus UTPL - Operadores", LocalTime.of(12, 30)),
                new BusUrbano(91, "Campus UTPL - Daniel Álvarez", LocalTime.of(13, 0)),
                new BusInterUrbano(68, "Campus UTPL - Rosales", LocalTime.of(13, 30)),
                new BusUrbano(70, "Campus UTPL - Rosales", LocalTime.of(14, 0)),
                new BusInterUrbano(98, "Campus UTPL - Sauces Norte", LocalTime.of(14, 30)),
                new BusUrbano(76, "Campus UTPL - Terminal Terrestre", LocalTime.of(15, 0)),
                new BusInterUrbano(96, "Campus UTPL - Ciudad Alegría", LocalTime.of(15, 30)),
                new BusUrbano(63, "Campus UTPL - Benjamín Carrión", LocalTime.of(16, 0)),
                new BusInterUrbano(40, "Campus UTPL - Ciudad Alegría", LocalTime.of(16, 30)),
                new BusUrbano(95, "Campus UTPL - San Pedro", LocalTime.of(17, 0)),
                new BusInterUrbano(68, "Campus UTPL - Ciudad Alegría", LocalTime.of(17, 0)),
                new BusUrbano(65, "Campus UTPL - Rosales", LocalTime.of(18, 0)),
                new BusInterUrbano(98, "Campus UTPL - Rosales", LocalTime.of(18, 30)),
                new BusUrbano(38, "Campus UTPL - Estadio", LocalTime.of(19, 0)),
                new BusInterUrbano(80, "Campus UTPL - Estadio", LocalTime.of(19, 30)),
                new BusUrbano(45, "Campus UTPL - Sauces Norte", LocalTime.of(20, 0))
        ));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la hora de ingreso (formato HH:MM): ");
        String inputHora = scanner.nextLine();
        LocalTime horaIngreso = LocalTime.parse(inputHora);

        mostrarBusesEnRango(listaBuses, horaIngreso);

        scanner.close();
        ManejodeDataBase.createTables();
        ManejodeDataBase.insertData();

        ArrayList<BusUrbano> busesUrbanos = ServiciosBuses.getBusesUrbanos();
        ArrayList<BusInterUrbano> busesInterUrbanos = ServiciosBuses.getBusesInterUrbanos();

        System.out.println("Buses Urbanos:");
        for (BusUrbano bus : busesUrbanos) {
            bus.mostrarInformacion();
        }

        System.out.println("\nBuses InterUrbanos:");
        for (BusInterUrbano bus : busesInterUrbanos) {
            bus.mostrarInformacion();
        }
    }

    public static void mostrarBusesEnRango(ArrayList<Buses> listaBuses, LocalTime horaIngreso) {
        LocalTime horaFin = horaIngreso.plusHours(2);

        System.out.println("Buses disponibles desde " + horaIngreso + " hasta " + horaFin + ":");
        for (Buses bus : listaBuses) {
            LocalTime horaSalida = bus.getHoraSalida();
            if (horaSalida.isAfter(horaIngreso.minusMinutes(1)) && horaSalida.isBefore(horaFin.plusMinutes(1))) {
                bus.mostrarInformacion();
                System.out.println(); 
            }
        }
    }
    
}
