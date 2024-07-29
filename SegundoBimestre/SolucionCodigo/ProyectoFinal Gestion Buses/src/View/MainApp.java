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
import Controller.ServiciosBuses;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.time.LocalTime;
import java.util.ArrayList;

public class MainApp extends Application {

    private TextField horaIngresoField;
    private TextField rutaField;
    private TextArea resultadosArea;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Búsqueda de Buses");

        Label horaIngresoLabel = new Label("Ingrese la hora de ingreso (formato HH:MM):");
        horaIngresoField = new TextField();

        Label rutaLabel = new Label("Ingrese la ruta del bus:");
        rutaField = new TextField();

        Button buscarButton = new Button("Buscar Buses");
        buscarButton.setOnAction(e -> buscarBuses());

        resultadosArea = new TextArea();
        resultadosArea.setEditable(false);

        VBox vbox = new VBox(10, horaIngresoLabel, horaIngresoField, rutaLabel, rutaField, buscarButton, resultadosArea);
        Scene scene = new Scene(vbox, 400, 400);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void buscarBuses() {
        String inputHora = horaIngresoField.getText();
        String rutaBus = rutaField.getText();

        try {
            LocalTime horaIngreso = LocalTime.parse(inputHora);
            ArrayList<Buses> listaBuses = ServiciosBuses.getAllBuses();

            LocalTime horaFin = horaIngreso.plusHours(2);
            StringBuilder resultados = new StringBuilder();
            resultados.append("Buses disponibles desde ").append(horaIngreso).append(" hasta ").append(horaFin).append(" en la ruta ").append(rutaBus).append(":\n\n");

            for (Buses bus : listaBuses) {
                LocalTime horaSalida = bus.getHoraSalida();
                if (bus.getRuta().equalsIgnoreCase(rutaBus) &&
                    horaSalida.isAfter(horaIngreso.minusMinutes(1)) && 
                    horaSalida.isBefore(horaFin.plusMinutes(1))) {
                    bus.incrementarVecesPresentado();
                    resultados.append(bus).append("\n");
                }
            }

            resultadosArea.setText(resultados.toString());
        } catch (Exception e) {
            resultadosArea.setText("Error: " + e.getMessage());
        }
    }
}


