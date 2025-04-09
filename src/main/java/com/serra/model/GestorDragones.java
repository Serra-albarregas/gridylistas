package com.serra.model;

import java.util.ArrayList;
import java.util.List;

import com.serra.interfaces.Observer;

public class GestorDragones {
    ArrayList<Dragon> dragones;
    ArrayList<Observer> observers;

    public void subscribe(Observer observer){
        observers.add(observer);
    }

    public void unsubscribe(Observer observer){
        observers.add(observer);
    }

    public void notifyObservers(){
        observers.forEach(item -> item.onChange());
    }

    public GestorDragones() {
        this.dragones = LectorDragones.leerDragones();
        observers = new ArrayList<>();
    }

    public void insertarDragon(Dragon d){
        this.dragones.add(d);
        notifyObservers();
    }

    public void eliminarDragon(Dragon d){
        this.dragones.remove(d);
        notifyObservers();
    }

    public List<Dragon> getDragones(){
        return this.dragones;
    }

    public List<Dragon> busquedaAvanzada(String nombre, TerrenoDragon terreno, String castillo, Integer edadMin, Integer edadMax){
        List<Dragon> busqueda = new ArrayList<>();
        for (Dragon dragon : dragones) {
            boolean coincide = true;

            if (nombre != null && !dragon.getNombre().toLowerCase().contains(nombre.trim().toLowerCase())) {
                coincide = false;
            }
            if (terreno != null && !dragon.getTerreno().equals(terreno)) {
                coincide = false;
            }
            if (castillo != null && !dragon.getCastillo().toLowerCase().contains(castillo.trim().toLowerCase())) {
                coincide = false;
            }
            if (edadMin != null && dragon.getEdad()<edadMin) {
                coincide=false;
            }
            if (edadMax != null && dragon.getEdad()>edadMax) {
                coincide=false;
            }

            if (coincide) {
                busqueda.add(dragon);
            }
        }
        return busqueda;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Dragon dragon : dragones) {
            sb.append(dragon+"\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        GestorDragones gd = new GestorDragones();
        System.out.println(gd.toString());
    }
}
