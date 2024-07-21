/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author VEL-JOSUE
 */
public class ManejodeDataBase {
    private static final String URL = "jdbc:sqlite:buses.db";

    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL);
            System.out.println("Conectado a la base de datos SQLite.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static void createTables() {
        String sqlUrbano = "CREATE TABLE IF NOT EXISTS buses_urbanos (\n"
                + " id integer PRIMARY KEY AUTOINCREMENT,\n"
                + " numero integer NOT NULL,\n"
                + " ruta text NOT NULL,\n"
                + " hora_salida text NOT NULL\n"
                + ");";
        String sqlInterUrbano = "CREATE TABLE IF NOT EXISTS buses_interurbanos (\n"
                + " id integer PRIMARY KEY AUTOINCREMENT,\n"
                + " numero integer NOT NULL,\n"
                + " ruta text NOT NULL,\n"
                + " hora_salida text NOT NULL\n"
                + ");";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sqlUrbano);
            stmt.execute(sqlInterUrbano);
            System.out.println("Tablas creadas.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertData() {
        String sqlUrbano = "INSERT INTO buses_urbanos(numero, ruta, hora_salida) VALUES\n"
                + "(22, 'Época - Campus UTPL', '06:30'),\n"
                + "(8, 'Parque Infantil - Campus UTPL', '07:00'),\n"
                + "(19, 'Hipervalle - Campus UTPL', '07:30');";
        String sqlInterUrbano = "INSERT INTO buses_interurbanos(numero, ruta, hora_salida) VALUES\n"
                + "(21, 'Operadores - Campus UTPL', '06:30'),\n"
                + "(1, 'Parque Infantil - Campus UTPL', '07:00'),\n"
                + "(12, 'Tebaida Baja - Campus UTPL', '07:30');";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sqlUrbano);
            stmt.execute(sqlInterUrbano);
            System.out.println("Datos insertados.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
