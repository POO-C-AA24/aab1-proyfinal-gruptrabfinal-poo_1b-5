/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

/**
 *
 * @author VEL-JOSUE
 */
import Controller.Buses;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;

public class ReporteBuses {

    private static final String DB_URL = "jdbc:sqlite:buses.db"; 

    public static void main(String[] args) {
        ArrayList<Buses> busesSobrecapacidad = obtenerBusesSobrecapacidad();
        if (!busesSobrecapacidad.isEmpty()) {
            enviarReporte(busesSobrecapacidad);
        } else {
            System.out.println("No hay buses que hayan excedido la capacidad máxima.");
        }
    }

    public static ArrayList<Buses> obtenerBusesSobrecapacidad() {
        ArrayList<Buses> busesSobrecapacidad = new ArrayList<>();
        String query = "SELECT numero, ruta, hora_salida, veces_presentado FROM buses_urbanos WHERE veces_presentado > 70 " +
                       "UNION ALL " +
                       "SELECT numero, ruta, hora_salida, veces_presentado FROM buses_interurbanos WHERE veces_presentado > 70";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int numero = rs.getInt("numero");
                String ruta = rs.getString("ruta");
                LocalTime horaSalida = LocalTime.parse(rs.getString("hora_salida"));
                int vecesPresentado = rs.getInt("veces_presentado");

                Buses bus = new Buses(numero, ruta, horaSalida) {
                    @Override
                    public void mostrarInformacion() {
                        throw new UnsupportedOperationException("Not supported yet."); 
                    }
                };
                bus.setVecesPresentado(vecesPresentado);
                busesSobrecapacidad.add(bus);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return busesSobrecapacidad;
    }

    public static void enviarReporte(ArrayList<Buses> busesSobrecapacidad) {
        StringBuilder reporte = new StringBuilder();
        System.out.println("Estimado Rector de la Universidad Técnica Particular de Loja,\n\n");
        System.out.println("Le envío este reporte en donde se presentan las rutas de los buses que están excediendo la capacidad máxima estimulada para recoger a los usuarios.\n"
                + " Sugiero de la manera más respetuosa enviar más líneas de buses a las siguientes rutas:\n\n");

        for (Buses bus : busesSobrecapacidad) {
            reporte.append(bus.toString()).append("\n");
        }

        System.out.println(reporte.toString());
    }
}
