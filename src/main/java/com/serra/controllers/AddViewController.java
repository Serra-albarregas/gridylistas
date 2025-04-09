package com.serra.controllers;

import com.serra.model.Dragon;
import com.serra.model.GestorDragones;
import com.serra.model.Proveedor;
import com.serra.model.TerrenoDragon;

import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;

public class AddViewController {
    @FXML
    TextField textNombre;

    @FXML
    ComboBox<TerrenoDragon> comboTerreno;

    @FXML
    TextField textCastillo;

    @FXML
    TextField textEdad;

    @FXML
    Button addButton;

    @FXML
    Label labelLog;

    @FXML
    public void initialize() {
        GestorDragones gestorDragones = Proveedor.getInstance().getGestorDragones();

        comboTerreno.getItems().addAll(TerrenoDragon.values());
        addButton.setOnAction(event -> {
            try {
                String nombre = textNombre.getText();
                TerrenoDragon terreno = comboTerreno.getValue();
                String castillo = textCastillo.getText();
                int edad = Integer.parseInt(textEdad.getText());
                gestorDragones.insertarDragon(new Dragon(nombre, terreno, castillo, edad));

                message("Dragón añadido correctamente");
                textNombre.clear();
                comboTerreno.getSelectionModel().clearSelection();
                textCastillo.clear();
                textEdad.clear();
            } catch (NumberFormatException e) {
                message("El formato numérico es incorrecto");
            }

        });
    }

    private void message(String mensaje) {
        labelLog.setText(mensaje);
        labelLog.setOpacity(1.0);
        labelLog.setVisible(true);

        // Espera 5 segundos antes de empezar a desvanecer
        PauseTransition pausa = new PauseTransition(Duration.seconds(5));
        pausa.setOnFinished(event -> {
            FadeTransition fade = new FadeTransition(Duration.seconds(1), labelLog);
            fade.setFromValue(1.0);
            fade.setToValue(0.0);
            fade.setOnFinished(e -> labelLog.setVisible(false)); // Opcional: ocultar del layout
            fade.play();
        });

        pausa.play();
    }
}
