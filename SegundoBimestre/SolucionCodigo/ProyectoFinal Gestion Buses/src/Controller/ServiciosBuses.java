/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.BusInterUrbano;
import Model.BusUrbano;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.ArrayList;

public class ServiciosBuses {

    public static ArrayList<Buses> getAllBuses() {
        ArrayList<Buses> listaBuses = new ArrayList<>();

        try (Connection conn = ManejodeDataBase.connect();
             Statement stmt = conn.createStatement()) {

            String sql = "SELECT numero, ruta, hora_salida, veces_presentado FROM buses_urbanos";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int numero = rs.getInt("numero");
                String ruta = rs.getString("ruta");
                LocalTime horaSalida = LocalTime.parse(rs.getString("hora_salida"));
                int vecesPresentado = rs.getInt("veces_presentado");
                BusUrbano bus = new BusUrbano(numero, ruta, horaSalida);
                bus.setVecesPresentado(vecesPresentado);
                listaBuses.add(bus);
            }

            sql = "SELECT numero, ruta, hora_salida, veces_presentado FROM buses_interurbanos";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int numero = rs.getInt("numero");
                String ruta = rs.getString("ruta");
                LocalTime horaSalida = LocalTime.parse(rs.getString("hora_salida"));
                int vecesPresentado = rs.getInt("veces_presentado");
                BusInterUrbano bus = new BusInterUrbano(numero, ruta, horaSalida);
                bus.setVecesPresentado(vecesPresentado);
                listaBuses.add(bus);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaBuses;
    }
}



