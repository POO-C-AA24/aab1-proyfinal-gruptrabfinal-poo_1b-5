package Controller;


import java.time.LocalTime;

public abstract class Buses {
    public int numero;
    public String ruta;
    public LocalTime horaSalida;
    public int vecesPresentado;

    public Buses(int numero, String ruta, LocalTime horaSalida) {
        this.numero = numero;
        this.ruta = ruta;
        this.horaSalida = horaSalida;
        this.vecesPresentado = 0;
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

    public int getVecesPresentado() {
        return vecesPresentado;
    }
     public void setVecesPresentado(int vecesPresentado) {
        this.vecesPresentado = vecesPresentado;
    }

    public void incrementarVecesPresentado() {
        this.vecesPresentado++;
    }

    public abstract void mostrarInformacion();
    @Override
    public String toString() {
        return "Número: " + numero + ", Ruta: " + ruta + ", Hora de salida: " + horaSalida + ", Veces presentado: " + vecesPresentado;
    }
}
