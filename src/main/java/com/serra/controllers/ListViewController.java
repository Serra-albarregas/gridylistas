package com.serra.controllers;

import java.util.List;

import com.serra.interfaces.Observer;
import com.serra.model.Dragon;
import com.serra.model.TerrenoDragon;
import com.serra.model.GestorDragones;
import com.serra.model.Proveedor;

import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class ListViewController implements Observer {
    @FXML
    ScrollPane container;

    @FXML
    TextField textNombre;

    @FXML
    ComboBox<TerrenoDragon> comboTerreno;

    @FXML
    TextField textCastillo;

    @FXML
    TextField textEdadMin;

    @FXML
    TextField textEdadMax;

    @FXML
    Button buttonBuscar;

    @FXML
    Button buttonReiniciar;

    GridPane mainGrid;

    GestorDragones gestorDragones;

    @FXML
    public void initialize(){
        gestorDragones = Proveedor.getInstance().getGestorDragones();
        gestorDragones.subscribe(this);

        mainGrid = new GridPane();
        mainGrid.setPadding(new Insets(10,50,10,50));

        double[] columnPercents = { 30, 30, 30, 10 }; // Suma = 100%

        for (double percent : columnPercents) {
            ColumnConstraints col = new ColumnConstraints();
            col.setPercentWidth(percent); // Ajuste proporcional
            col.setHgrow(Priority.ALWAYS); // Permitir que crezca con el GridPane
            col.setHalignment(HPos.LEFT);
            mainGrid.getColumnConstraints().add(col);
        }

        generarLista(gestorDragones.getDragones());
        // Agregar el grid principal al contenedor
        container.setContent(mainGrid);

        comboTerreno.getItems().addAll(TerrenoDragon.values());

        buttonBuscar.setOnAction(event -> buscar());
        textNombre.setOnAction(event -> buscar());
        comboTerreno.setOnAction(event -> buscar());
        textCastillo.setOnAction(event -> buscar());
        textEdadMin.setOnAction(event -> buscar());
        textEdadMax.setOnAction(event-> buscar());

        buttonReiniciar.setOnAction(event -> {
            textNombre.clear();
            comboTerreno.getSelectionModel().clearSelection();
            textCastillo.clear();
            textEdadMin.clear();
            textEdadMax.clear();
            buscar();
        });
    }

    public void buscar() {
        try {
            String nombre = !textNombre.getText().equals("")?textNombre.getText():null;
            TerrenoDragon terrerno = comboTerreno.getValue();
            String castillo = !textCastillo.getText().equals("")?textCastillo.getText():null;
            Integer edadMin = !textEdadMin.getText().equals("")?Integer.parseInt(textEdadMin.getText()):null;
            Integer edadMax = !textEdadMax.getText().equals("")?Integer.parseInt(textEdadMax.getText()):null;
            generarLista(gestorDragones.busquedaAvanzada(nombre, terrerno, castillo, edadMin, edadMax));
        } catch (NumberFormatException e) {
            System.err.println("Error en el formato numérico");
        }
    }

    public void generarLista(List<Dragon> dragones) {
        mainGrid.getChildren().clear();

        int row = 0;
        for (Dragon dragon : dragones) {
            Label nombreLabel = new Label(dragon.getNombre());
            Label terrenoLabel = new Label(dragon.getTerrenoString());
            Label castilloLabel = new Label(dragon.getCastillo());
            Label edadLabel = new Label(Integer.toString(dragon.getEdad()));
            mainGrid.add(nombreLabel, 0, row);
            mainGrid.add(terrenoLabel, 1, row);
            mainGrid.add(castilloLabel, 2, row);
            mainGrid.add(edadLabel, 4, row);

            row++;
        }
    }

    @Override
    public void onChange() {
        buscar();
    }
}
