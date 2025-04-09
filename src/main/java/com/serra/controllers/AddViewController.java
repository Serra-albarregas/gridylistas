package com.serra.controllers;

import com.serra.model.Dragon;
import com.serra.model.GestorDragones;
import com.serra.model.Proveedor;
import com.serra.model.TerrenoDragon;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

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
    public void initialize(){
        GestorDragones gestorDragones = Proveedor.getInstance().getGestorDragones();

        comboTerreno.getItems().addAll(TerrenoDragon.values());
        addButton.setOnAction(event -> {
            try {
                String nombre = textNombre.getText();
                TerrenoDragon terreno = comboTerreno.getValue();
                String castillo = textCastillo.getText();
                int edad = Integer.parseInt(textEdad.getText());
                gestorDragones.insertarDragon(new Dragon(nombre, terreno, castillo, edad));
            } catch (NumberFormatException e) {
                System.out.println("Error en el formato de los números");
            }
        });
    }
}
