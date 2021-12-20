package com.company.entidades;

public class ColeccionCeldas {
    private Celda[] celdas;

    public ColeccionCeldas(Celda[] celdas, int idCelda0, int idCelda1, int idCelda2) {
        this.celdas = new Celda[3];
        this.celdas[0] = celdas[idCelda0];
        this.celdas[1] = celdas[idCelda1];
        this.celdas[2] = celdas[idCelda2];
    }
    public boolean todasContienen(int numero) {
        boolean ok = true;
        for (Celda celda: this.celdas) {
            ok = ok && celda.contiene(numero);
        }
        return ok;
    }
}
