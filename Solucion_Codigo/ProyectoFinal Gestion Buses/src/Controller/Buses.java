package Controller;


import java.time.LocalTime;

public abstract class Buses {
    public int numero;
    public String ruta;
    public LocalTime horaSalida;

    public Buses(int numero, String ruta, LocalTime horaSalida) {
        this.numero = numero;
        this.ruta = ruta;
        this.horaSalida = horaSalida;
    }

    public int getNumero() {
        return numero;
    }

    public String getRuta() {
        return ruta;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public abstract void mostrarInformacion();
}
