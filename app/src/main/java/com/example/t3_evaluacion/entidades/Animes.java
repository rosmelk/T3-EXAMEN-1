package com.example.t3_evaluacion.entidades;

public class Animes {

    public int id;
    public String imagen;
    public String nombre;
    public String descripcion;

    public Animes() {

    }

    public Animes(String imagen, String nombre, String descripcion) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Animes(int id, String imagen, String nombre, String descripcion) {
        this.id = id;
        this.imagen = imagen;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
}
