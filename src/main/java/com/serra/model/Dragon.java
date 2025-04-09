package com.serra.model;

public class Dragon {
    private static int ultimoId;
    private int id;
    private String nombre;
    private TerrenoDragon terreno;
    private String castillo;
    private int edad;


    public Dragon(String nombre, TerrenoDragon terreno, String castillo, int edad) {
        this.id = ultimoId++;
        this.nombre = nombre;
        this.terreno = terreno;
        this.castillo = castillo;
        this.edad = edad;
    }

    public int getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TerrenoDragon getTerreno() {
        return this.terreno;
    }

    public String getTerrenoString() {
        return this.terreno.toString().toLowerCase();
    }

    public void setTerreno(TerrenoDragon terreno) {
        this.terreno = terreno;
    }

    public String getCastillo() {
        return this.castillo;
    }

    public void setCastillo(String castillo) {
        this.castillo = castillo;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", terreno='" + getTerrenoString() + "'" +
            ", castillo='" + getCastillo() + "'" +
            ", edad='" + getEdad() + "'" +
            "}";
    }

}
