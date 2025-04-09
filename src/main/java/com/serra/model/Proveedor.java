package com.serra.model;

public class Proveedor {
    private static Proveedor instance;
    private GestorDragones gestorDragones;
    
    private Proveedor(){
        gestorDragones = new GestorDragones();
    }

    public static Proveedor getInstance(){
        if (instance==null) {
            instance = new Proveedor();
        }
        return instance;
    }

    public GestorDragones getGestorDragones(){
        return this.gestorDragones;
    }

    public void setGestorDragones(GestorDragones gestorDragones){
        this.gestorDragones = gestorDragones;
    }
}
