package com.company.entidades;

public class Celda {
    private int contenido; // debe ser distinto de 0

    public Celda() {
        this.contenido = 0;
    }

    public boolean contiene(int numero) {
        return numero != 0 && this.contenido == numero;
    }

    public boolean estaLibre() {
        return this.contenido == 0;
    }

    public void actualizarContenido(int numero) {
        //exception si no esta libre
        this.contenido = numero;
    }
}


