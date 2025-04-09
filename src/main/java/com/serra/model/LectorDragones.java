package com.serra.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import com.serra.App;

public class LectorDragones {
    public static ArrayList<Dragon> leerDragones(){
        ArrayList<Dragon> dragones = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(App.class.getResource("data/dragones.csv").toURI())),StandardCharsets.UTF_8))) {
            String linea = br.readLine();
            while ((linea = br.readLine())!=null){
                String[] atributos = linea.split(",");
                try {
                    dragones.add(new Dragon(atributos[0], TerrenoDragon.valueOf(atributos[1]), atributos[2], Integer.parseInt(atributos[3])));
                } catch (NumberFormatException e) {
                    System.err.println("Error en la edad del dragon " + atributos[0]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e){
            e.printStackTrace();
        }
        return dragones;
    }
    
}