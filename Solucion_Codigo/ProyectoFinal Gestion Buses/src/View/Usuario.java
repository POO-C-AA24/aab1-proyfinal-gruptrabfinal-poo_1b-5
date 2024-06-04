package View;
import Model.EscrituraRutasBuses;
import Controller.PresentarBuses;
import Controller.Buses;
import java.util.ArrayList;
import java.util.Arrays;
import java.time.LocalTime;

public class Usuario {

    public static void main(String[] args) {
        ArrayList<Buses> ListaBuses = new ArrayList<Buses>(Arrays.asList(
                new Buses(22, "Época - Campus UTPL", LocalTime.of(6, 30)),
                new Buses(21, "Operadores - Campus UTPL", LocalTime.of(6, 30)),
                new Buses(8, "Parque Infantil - Campus UTPL", LocalTime.of(7, 0)),
                new Buses(1, "Parque Infantil - Campus UTPL", LocalTime.of(7, 0)),
                new Buses(19, "Hipervalle - Campus UTPL", LocalTime.of(7, 30)),
                new Buses(12, "Tebaida Baja - Campus UTPL", LocalTime.of(7, 30)),
                new Buses(13, "Coliseo Ciudad de Loja - Campus UTPL", LocalTime.of(8, 0)),
                new Buses(2, "Pradera - Campus UTPL", LocalTime.of(8, 0)),
                new Buses(9, "Canchas Calva y Calva - Campus UTPL", LocalTime.of(8, 30)),
                new Buses(20, "Las Pitas - Campus UTPL", LocalTime.of(8, 30)),
                new Buses(10, "Ciudad Alegría - Campus UTPL", LocalTime.of(9, 0)),
                new Buses(15, "Operadores - Campus UTPL", LocalTime.of(9, 0)),
                new Buses(3, "Pradera - Campus UTPL", LocalTime.of(9, 30)),
                new Buses(23, "Rosales - Campus UTPL", LocalTime.of(9, 30)),
                new Buses(7, "Ciudad Alegría - Campus UTPL", LocalTime.of(10, 0)),
                new Buses(20, "Sauces Norte - Campus UTPL", LocalTime.of(10, 0)),
                new Buses(18, "Sauces Norte - Campus UTPL", LocalTime.of(10, 30)),
                new Buses(24, "Sauces Norte - Campus UTPL", LocalTime.of(10, 30)),
                new Buses(19, "Hipervalle - Campus UTPL", LocalTime.of(11, 0)),
                new Buses(33, "Campus UTPL - La Urna", LocalTime.of(11, 0)),
                new Buses(32, "Campus UTPL - La Urna", LocalTime.of(11, 30)),
                new Buses(31, "Campus UTPL - La Urna", LocalTime.of(11, 30)),
                new Buses(14, "Lauro Guerreo - Campus UTPL", LocalTime.of(12, 0)),
                new Buses(85, "Campus UTPL -  Operadores", LocalTime.of(12, 0)),
                new Buses(83, "Campus UTPL - Daniel Álvarez", LocalTime.of(12, 30)),
                new Buses(88, "Campus UTPL -  Operadores", LocalTime.of(12, 30)),
                new Buses(91, "Campus UTPL - Daniel Álvarez", LocalTime.of(13, 0)),
                new Buses(68, "Campus UTPL - Rosales", LocalTime.of(13, 30)),
                new Buses(70, "Campus UTPL - Rosales", LocalTime.of(14, 0)),
                new Buses(98, "Campus UTPL - Sauces Norte", LocalTime.of(14, 30)),
                new Buses(76, "Campus UTPL - Terminal Terrestre", LocalTime.of(15, 0)),
                new Buses(96, "Campus UTPL - Ciudad Alegría", LocalTime.of(15, 30)),
                new Buses(63, "Campus UTPL - Benjamín Carrión", LocalTime.of(16, 0)),
                new Buses(40, "Campus UTPL - Ciudad Alegría", LocalTime.of(16, 30)),
                new Buses(95, "Campus UTPL - San Pedro", LocalTime.of(17, 0)),
                new Buses(68, "Campus UTPL - Ciudad Alegría", LocalTime.of(17, 0)),
                new Buses(65, "Campus UTPL - Rosales", LocalTime.of(18, 0)),
                new Buses(98, "Campus UTPL - Rosales", LocalTime.of(18, 30)),
                new Buses(38, "Campus UTPL - Estadio", LocalTime.of(19, 0)),
                new Buses(80, "Campus UTPL - Estadio", LocalTime.of(19, 30)),
                new Buses(45, "Campus UTPL - Sauces Norte", LocalTime.of(20, 0))));
       PresentarBuses schedule = new PresentarBuses();
        schedule.displayCurrentBuses();
        EscrituraRutasBuses archivo = new EscrituraRutasBuses();
        archivo.GuardarBuses(ListaBuses);
        
    }

}
