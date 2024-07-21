/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.BusInterUrbano;
import Model.BusUrbano;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.ArrayList;

public class ServiciosBuses {

    public static ArrayList<BusUrbano> getBusesUrbanos() {
        ArrayList<BusUrbano> buses = new ArrayList<>();
        String sql = "SELECT numero, ruta, hora_salida FROM buses_urbanos";

        try (Connection conn = ManejodeDataBase.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int numero = rs.getInt("numero");
                String ruta = rs.getString("ruta");
                LocalTime horaSalida = LocalTime.parse(rs.getString("hora_salida"));
                buses.add(new BusUrbano(numero, ruta, horaSalida));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return buses;
    }

    public static ArrayList<BusInterUrbano> getBusesInterUrbanos() {
        ArrayList<BusInterUrbano> buses = new ArrayList<>();
        String sql = "SELECT numero, ruta, hora_salida FROM buses_interurbanos";

        try (Connection conn = ManejodeDataBase.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int numero = rs.getInt("numero");
                String ruta = rs.getString("ruta");
                LocalTime horaSalida = LocalTime.parse(rs.getString("hora_salida"));
                buses.add(new BusInterUrbano(numero, ruta, horaSalida));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return buses;
    }
}


