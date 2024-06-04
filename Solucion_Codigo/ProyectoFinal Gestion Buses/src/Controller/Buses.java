package Controller;

import java.time.LocalTime;
import java.util.ArrayList;

public class Buses {

    public int linea;
    public String ruta;
    public LocalTime hora;
    public ArrayList<Buses> listaBuses;

    public Buses(int linea, String ruta, LocalTime hora) {
        this.linea = linea;
        this.ruta = ruta;
        this.hora = hora;
    }

    public LocalTime getHora() {
        return hora;
    }

    @Override
    public String toString() {
        return "Linea: " + linea + ", Ruta: " + ruta + ", Hora: " + hora;
    }

}
